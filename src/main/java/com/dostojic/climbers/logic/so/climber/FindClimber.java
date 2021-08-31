/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dostojic.climbers.logic.so.climber;

import com.dostojic.climbers.domain.Climber;
import com.dostojic.climbers.repository.ClimberRepository;
import com.dostojic.climbers.logic.TransactionManager;
import com.dostojic.climbers.logic.so.template.GeneralReportingSO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author Dejan.Ostojic
 */
@Service
public class FindClimber extends GeneralReportingSO<Integer, Climber>{

    private final ClimberRepository climberRepository;
    
    public FindClimber(ClimberRepository climberRepository) {
        this.climberRepository = climberRepository;
    }


    @Override
    protected Climber executeOperation(Integer id)  {
        return climberRepository.findById(id);
    }

}
    