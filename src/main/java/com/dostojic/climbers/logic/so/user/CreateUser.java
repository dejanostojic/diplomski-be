package com.dostojic.climbers.logic.so.user;

import com.dostojic.climbers.domain.Admin;
import com.dostojic.climbers.repository.AdminRepository;
import com.dostojic.climbers.rest.bff.dto.CreateUserRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CreateUser {

    private final AdminRepository adminRepository;
    private final PasswordEncoder passwordEncoder;

    public CreateUser(AdminRepository adminRepository, PasswordEncoder passwordEncoder) {
        this.adminRepository = adminRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Admin createUser(CreateUserRequest request){
        Admin admin = new Admin();
        admin.setFirstName(request.getFirstName());
        admin.setLastName(request.getLastName());
        admin.setUsername(request.getUsername());
        admin.setPassword(passwordEncoder.encode(request.getPassword()));

        if (!request.getPassword().equals(request.getRePassword())){
            throw new RuntimeException("Password and re password must match!");
        }

        return adminRepository.insert(admin);
    }
}
