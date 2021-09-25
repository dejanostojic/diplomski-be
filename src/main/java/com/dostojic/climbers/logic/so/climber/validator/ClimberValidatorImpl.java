/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dostojic.climbers.logic.so.climber.validator;

import com.dostojic.climbers.domain.Climber;
import com.dostojic.climbers.exception.ClimbersValidationException;
import org.springframework.stereotype.Component;

/**
 * @author Dejan.Ostojic
 */
@Component
public class ClimberValidatorImpl implements ClimberValidator {

  @Override
  public void validate(Climber climber) {
    boolean isValid = true;
    StringBuilder error = new StringBuilder("Climber is not valid!");
    if (climber.getFirstName() == null || climber.getFirstName().isEmpty()) {
      isValid = false;
      error.append(" First name is mandatory field!");
    }
    if (climber.getLastName() == null || climber.getLastName().isEmpty()) {
      isValid = false;
      error.append(" Last name is mandatory field!");
    }
    if (climber.getYearOfBirth() != null && climber.getYearOfBirth() < 1900) {
      isValid = false;
      error.append(" Year of birth must be bigger than 1900!");
    }

    if (!isValid) {
      throw new ClimbersValidationException(error.toString().trim());
    }
  }
}
