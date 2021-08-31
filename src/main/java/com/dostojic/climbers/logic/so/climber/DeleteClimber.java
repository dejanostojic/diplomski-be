/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dostojic.climbers.logic.so.climber;

import com.dostojic.climbers.domain.Climber;
import com.dostojic.climbers.repository.ClimberRepository;
import com.dostojic.climbers.logic.TransactionManager;
import com.dostojic.climbers.logic.so.template.GeneralUpdateSO;
import org.springframework.stereotype.Service;

/**
 *
 * @author Dejan.Ostojic
 */
@Service
public class DeleteClimber extends GeneralUpdateSO<Integer, Boolean> {

    private final ClimberRepository climberRepository;

    public DeleteClimber(ClimberRepository climberRepository) {
        this.climberRepository = climberRepository;
    }

    @Override
    protected void checkPrecondition(Integer climberId) {
        System.out.println("No preconditions DeleteClimberSO");
    }

    @Override
    protected Boolean executeOperation(Integer climberId) {
        climberRepository.deleteById(climberId);
        System.out.println("TODO: return boolean if climber deleted!");
        return null;
    }

}
