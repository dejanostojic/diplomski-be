/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dostojic.climbers.logic.so.climber;

import com.dostojic.climbers.domain.Climber;
import com.dostojic.climbers.domain.valueobject.ClimberSearchCriteria;
//import com.dostojic.climbers.domain.valueobject.Page;
import org.springframework.data.domain.Page;

import com.dostojic.climbers.repository.ClimberRepository;
import com.dostojic.climbers.logic.TransactionManager;
import com.dostojic.climbers.logic.so.template.GeneralReportingSO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * @author Dejan.Ostojic
 */
@Service
public class SearchClimbers extends GeneralReportingSO<ClimberSearchCriteria, Page<Climber>>{
    private ClimberRepository climberRepository;
    
    public SearchClimbers(ClimberRepository climberRepository) {
        this.climberRepository = climberRepository;
    }


    @Override
    protected Page<Climber> executeOperation(ClimberSearchCriteria searchCriteria)  {
        return climberRepository.searchClimbers(searchCriteria);
    }
    
}
