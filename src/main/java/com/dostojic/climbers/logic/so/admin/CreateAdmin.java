/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dostojic.climbers.logic.so.admin;

import com.dostojic.climbers.domain.Admin;
import com.dostojic.climbers.logic.so.admin.validator.AdminValidator;
import com.dostojic.climbers.logic.so.template.GeneralSO;
import com.dostojic.climbers.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author Dejan.Ostojic
 */
@Service
public class CreateAdmin extends GeneralSO<Admin, Admin> {

  private AdminRepository adminRepository;
  private AdminValidator adminValidator;
  private PasswordEncoder passwordEncoder;

  @Autowired
  public void setAdminRepository(AdminRepository adminRepository) {
    this.adminRepository = adminRepository;
  }

  @Autowired
  public void setClimberValidator(
      AdminValidator adminValidator) {
    this.adminValidator = adminValidator;
  }

  @Autowired
  public void setPasswordEncoder(
      PasswordEncoder passwordEncoder) {
    this.passwordEncoder = passwordEncoder;
  }

  @Override
  protected void checkPrecondition(Admin admin) {
    adminValidator.validate(admin);
  }

  @Override
  public Admin executeOperation(Admin admin) {
    System.out.println("DEBUG: Inserting admin: " + admin);
    admin.setPassword(passwordEncoder.encode(admin.getPassword()));
    return adminRepository.insert(admin);
  }

}
