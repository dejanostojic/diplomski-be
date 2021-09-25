/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dostojic.climbers.logic.so.competition;

import com.dostojic.climbers.domain.Competition;
import com.dostojic.climbers.domain.valueobject.CompetitionSearchCriteria;
import com.dostojic.climbers.logic.so.template.GeneralSO;
import com.dostojic.climbers.repository.CompetitionRepository;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

/**
 *
 * @author Dejan.Ostojic
 */
@Service
public class SearchCompetitions extends GeneralSO<CompetitionSearchCriteria, Page<Competition>> {

     private final CompetitionRepository competitionRepository;

    public SearchCompetitions(CompetitionRepository competitionRepository) {
        this.competitionRepository = competitionRepository;
    }
     

    @Override
    protected Page<Competition> executeOperation(CompetitionSearchCriteria searchCriteria)  {
        return competitionRepository.searchCompetitions(searchCriteria);
    }
    
}
