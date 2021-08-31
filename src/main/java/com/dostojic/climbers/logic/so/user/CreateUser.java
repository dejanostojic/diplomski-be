package com.dostojic.climbers.logic.so.user;

import com.dostojic.climbers.domain.User;
import com.dostojic.climbers.repository.UserRepository;
import com.dostojic.climbers.rest.bff.dto.mapper.UserMapper;
import com.dostojic.climbers.rest.bff.dto.CreateUserRequest;
import com.dostojic.climbers.rest.bff.dto.UserDto;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CreateUser {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public CreateUser(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User createUser(CreateUserRequest request){
        User user = new User();
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        if (!request.getPassword().equals(request.getRePassword())){
            throw new RuntimeException("Password and re password must match!");
        }

        return userRepository.insert(user);
    }
}
