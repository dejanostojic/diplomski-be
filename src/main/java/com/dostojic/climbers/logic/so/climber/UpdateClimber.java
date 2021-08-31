/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dostojic.climbers.logic.so.climber;

import com.dostojic.climbers.logic.so.template.GeneralUpdateSO;
import com.dostojic.climbers.domain.Climber;
import com.dostojic.climbers.repository.ClimberRepository;
import com.dostojic.climbers.logic.TransactionManager;
import org.springframework.stereotype.Service;

/**
 *
 * @author Dejan.Ostojic
 */
@Service
public class UpdateClimber extends GeneralUpdateSO<Climber, Boolean> {

    ClimberRepository climberRepository;

    public UpdateClimber(ClimberRepository climberRepository) {
        this.climberRepository = climberRepository;

    }

    @Override
    protected void checkPrecondition(Climber climber) {
        new ClimberValidator().validate(climber);
    }

    @Override
    protected Boolean executeOperation(Climber climber) {
        System.out.println("DEBUG: Updating climber: " + climber);
        return climberRepository.update(climber);
    }

}
