/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dostojic.climbers.logic.so;

import com.dostojic.climbers.domain.Admin;
import com.dostojic.climbers.domain.valueobject.LoginCredentials;
import com.dostojic.climbers.exception.LoginException;
import com.dostojic.climbers.logic.so.template.GeneralSO;
import com.dostojic.climbers.repository.AdminRepository;
import org.springframework.stereotype.Service;

/**
 * System operation for login functionality. 
 * @author Dejan.Ostojic
 */
@Service
public class UserLoginSO extends GeneralSO<LoginCredentials, Admin> {
    
    private final AdminRepository adminRepository;
    
    public UserLoginSO(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @Override
    protected Admin executeOperation(LoginCredentials loginCreds)  {
        String username = loginCreds.getUsername();
        String pass = loginCreds.getPassword();
        
        Admin admin = adminRepository.findByUsernameAndPassword(username, pass);
        if (admin == null){
            throw new LoginException("Wrong username of password");
        }
        return admin;
    }
    
}
