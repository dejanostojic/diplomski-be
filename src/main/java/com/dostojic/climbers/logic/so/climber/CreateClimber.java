/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dostojic.climbers.logic.so.climber;

import com.dostojic.climbers.domain.Climber;
import com.dostojic.climbers.repository.ClimberRepository;
import com.dostojic.climbers.logic.so.template.GeneralUpdateSO;
import org.springframework.stereotype.Service;

/**
 *
 * @author Dejan.Ostojic
 */
@Service
public class CreateClimber extends GeneralUpdateSO<Climber, Climber> {

    private final ClimberRepository climberRepository;
    private final ClimberValidator climberValidator;

    public CreateClimber(ClimberRepository climberRepository, ClimberValidator climberValidator) {
        this.climberRepository = climberRepository;
        this.climberValidator = climberValidator;
    }

    @Override
    protected void checkPrecondition(Climber climber) {
        climberValidator .validate(climber);
    }

    @Override
    public Climber executeOperation(Climber climber) {
        System.out.println("DEBUG: Inserting climber: " + climber);
        return climberRepository.insert(climber);
    }

}
