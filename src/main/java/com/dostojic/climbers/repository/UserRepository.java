/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dostojic.climbers.repository;

import com.dostojic.climbers.domain.User;
import java.util.List;

/**
 *
 * @author planina
 */
public interface UserRepository {
    List<User> getAll() ;
    User findByUsernameAndPassword(String username, String password) ;
    User findByUsername(String username) ;
    User insert(User user);
}