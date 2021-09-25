/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dostojic.climbers.logic.so.climber;

import com.dostojic.climbers.domain.Climber;
import com.dostojic.climbers.logic.so.template.GeneralSO;
import com.dostojic.climbers.repository.ClimberRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author Dejan.Ostojic
 */
@Service
public class FindClimber extends GeneralSO<Integer, Climber> {

    private final ClimberRepository climberRepository;
    
    public FindClimber(ClimberRepository climberRepository) {
        this.climberRepository = climberRepository;
    }


    @Override
    protected Climber executeOperation(Integer id)  {
        return climberRepository.findById(id);
    }

}
    