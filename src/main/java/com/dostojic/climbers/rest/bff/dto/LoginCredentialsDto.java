/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dostojic.climbers.rest.bff.dto;

import java.io.Serializable;

/**
 *
 * @author planina
 */
public class LoginCredentialsDto implements Serializable {
    private final String username;
    private final String password;

    public LoginCredentialsDto(String username, String password) {
        this.username = username;
        this.password = password;
        validate();
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    private void validate() {
        System.out.println("TODO: validate username and pass (e.g) must not be null or empty string");
    }
    
}
