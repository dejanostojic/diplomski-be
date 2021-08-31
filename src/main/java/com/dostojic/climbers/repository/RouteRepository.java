/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dostojic.climbers.repository;

import com.dostojic.climbers.domain.Route;
import java.util.List;

/**
 *
 * @author Dejan.Ostojic
 */
public interface RouteRepository {
    Route insert(Route route);
    Route update(Route route);
    void delete(Route route);

    public List<Route> findByCompetitionId(Integer id);
}
