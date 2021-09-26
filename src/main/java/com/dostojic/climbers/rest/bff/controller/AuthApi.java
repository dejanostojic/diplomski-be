package com.dostojic.climbers.rest.bff.controller;

import com.dostojic.climbers.boot.spring.security.JwtTokenUtil;
import com.dostojic.climbers.domain.Admin;
import com.dostojic.climbers.domain.valueobject.LoginCredentials;
import com.dostojic.climbers.logic.so.user.CreateUser;
import com.dostojic.climbers.rest.bff.dto.CreateUserRequest;
import com.dostojic.climbers.rest.bff.dto.UserDto;
import com.dostojic.climbers.rest.bff.dto.mapper.UserMapper;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/public/auth")
public class AuthApi {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenUtil jwtTokenUtil;
    private final CreateUser createUser;
//    private final UserViewMapper userViewMapper;
//    private final UserService userService;


    public AuthApi(AuthenticationManager authenticationManager, JwtTokenUtil jwtTokenUtil, CreateUser createUser) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenUtil = jwtTokenUtil;
        this.createUser = createUser;
    }

    @PostMapping("/login")
    public ResponseEntity<Admin> login(@RequestBody @Valid LoginCredentials request) {
        try {
            Authentication authenticate = authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));

            Admin admin = (Admin) authenticate.getPrincipal();

            return ResponseEntity.ok()
                    .header(HttpHeaders.AUTHORIZATION, jwtTokenUtil.generateAccessToken(admin))
                    .header(HttpHeaders.ACCESS_CONTROL_ALLOW_HEADERS, HttpHeaders.AUTHORIZATION)
                    .header(HttpHeaders.ACCESS_CONTROL_EXPOSE_HEADERS, HttpHeaders.AUTHORIZATION)
                    .body(admin);
        } catch (BadCredentialsException ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
//
    @PostMapping("/register")
    public ResponseEntity<UserDto>  register(@RequestBody @Valid CreateUserRequest request) {
        Admin admin = createUser.createUser(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(UserMapper.INSTANCE.toDto(admin));
    }

}