/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dostojic.climbers.logic.so.admin.validator;

import com.dostojic.climbers.domain.Admin;
import com.dostojic.climbers.exception.ClimbersValidationException;
import org.springframework.stereotype.Component;

/**
 * @author Dejan.Ostojic
 */
@Component
public class AdminValidatorImpl implements AdminValidator {

  @Override
  public void validate(Admin admin) {
    boolean isValid = true;
    StringBuilder error = new StringBuilder("Climber is not valid!");
    if (admin.getFirstName() == null || admin.getFirstName().isEmpty()) {
      isValid = false;
      error.append(" First name is mandatory field!");
    }
    if (admin.getLastName() == null || admin.getLastName().isEmpty()) {
      isValid = false;
      error.append(" Last name is mandatory field!");
    }


    if (!isValid) {
      throw new ClimbersValidationException(error.toString().trim());
    }
  }
}
