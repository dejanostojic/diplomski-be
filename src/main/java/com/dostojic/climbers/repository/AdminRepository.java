/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dostojic.climbers.repository;

import com.dostojic.climbers.domain.Admin;
import com.dostojic.climbers.domain.valueobject.AdminSearchCriteria;
import java.util.List;
import org.springframework.data.domain.Page;

/**
 * @author planina
 */
public interface AdminRepository {


  Admin findByUsernameAndPassword(String username, String password);

  Admin findByUsername(String username);

  Admin insert(Admin admin);

  void deleteById(Long id);

  void delete(Admin admin);

  boolean update(Admin admin);

  Admin findById(Long adminId);

  Page<Admin> searchAdmins(AdminSearchCriteria searchCriteria);

}
