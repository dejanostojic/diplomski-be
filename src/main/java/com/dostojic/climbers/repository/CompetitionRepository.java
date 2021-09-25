/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dostojic.climbers.repository;

import com.dostojic.climbers.domain.Competition;
import com.dostojic.climbers.domain.valueobject.CompetitionSearchCriteria;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 *
 * @author planina
 */
public interface CompetitionRepository {

    Page<Competition> searchCompetitions(CompetitionSearchCriteria searchCriteria);

    Competition insert(Competition competition);
    
    Competition update(Competition competition);

    Competition findById(Integer id);

}
