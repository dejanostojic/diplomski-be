/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dostojic.climbers.repository;

import com.dostojic.climbers.domain.Registration;
import java.util.List;

/**
 *
 * @author Dejan.Ostojic
 */
public interface RegistrationRepository {
    Registration insert(Registration registration);
    Registration update(Registration registration);
    void delete(Registration registration);

    public List<Registration> findByCompetitionId(Integer id);
}
