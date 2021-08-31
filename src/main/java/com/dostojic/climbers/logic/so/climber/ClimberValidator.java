/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dostojic.climbers.logic.so.climber;

import com.dostojic.climbers.domain.Climber;
import com.dostojic.climbers.exception.ClimbersValidationException;

/**
 *
 * @author Dejan.Ostojic
 */
// TODO: Change this to DTO and use DTO in controller
public class ClimberValidator {
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
