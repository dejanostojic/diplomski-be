/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dostojic.climbers.logic.so.climber;

import com.dostojic.climbers.logic.so.climber.validator.ClimberValidator;
import com.dostojic.climbers.domain.Climber;
import com.dostojic.climbers.logic.so.template.GeneralSO;
import com.dostojic.climbers.repository.ClimberRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author Dejan.Ostojic
 */
@Service
public class UpdateClimber extends GeneralSO<Climber, Boolean> {

    private final ClimberRepository climberRepository;
    private final ClimberValidator climberValidator;

    public UpdateClimber(ClimberRepository climberRepository, ClimberValidator climberValidator) {
        this.climberRepository = climberRepository;
        this.climberValidator = climberValidator;
    }

    @Override
    protected void checkPrecondition(Climber climber) {
        climberValidator.validate(climber);
    }

    @Override
    protected Boolean executeOperation(Climber climber) {
        System.out.println("DEBUG: Updating climber: " + climber);
        return climberRepository.update(climber);
    }

}
