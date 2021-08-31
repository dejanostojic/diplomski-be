/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dostojic.climbers.repository;

import com.dostojic.climbers.domain.Climber;
import com.dostojic.climbers.domain.valueobject.ClimberSearchCriteria;
//import com.dostojic.climbers.domain.valueobject.Page;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 *
 * @author planina
 */
public interface ClimberRepository {

    Page<Climber> searchClimbers(ClimberSearchCriteria searchCriteria);

    void deleteById(Integer id);

    void delete(Climber climber);

    boolean update(Climber climber);

    Climber findById(Integer climber);

    public Climber insert(Climber climber) ;
}
