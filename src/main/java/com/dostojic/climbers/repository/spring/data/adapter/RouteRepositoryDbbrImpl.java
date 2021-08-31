/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dostojic.climbers.repository.spring.data.adapter;

import com.dostojic.climbers.dbbr.improved.DbBroker;
import com.dostojic.climbers.domain.Route;
import com.dostojic.climbers.repository.RouteRepository;
import com.dostojic.climbers.repository.spring.data.adapter.RouteCompositeId;
import com.dostojic.climbers.repository.spring.data.adapter.RouteDto;
import com.dostojic.climbers.repository.spring.data.adapter.mapper.CompetitionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 *
 * @author Dejan.Ostojic
 */
@Component // TODO REFACTOR TO JPA IMPL
public class RouteRepositoryDbbrImpl implements RouteRepository {

    @Autowired
    JpaRouteRepository routeRepository;


    @Override
    public Route insert(Route route)  {
        RouteDto routeDto = CompetitionMapper.INSTANCE.toDto(route);
        System.out.println("ROUTE DTO: " + routeDto);
        RouteDto inserted = routeRepository.save(routeDto);

        return CompetitionMapper.INSTANCE.fromDto(inserted);
    }

    @Override
    public Route update(Route route)  {
        RouteDto routeDto = CompetitionMapper.INSTANCE.toDto(route);
        System.out.println("ROUTE DTO: " + routeDto);
        return CompetitionMapper.INSTANCE.fromDto(routeRepository.save(routeDto));

    }

    @Override
    public void delete(Route route)  {
        RouteDto routeDto = CompetitionMapper.INSTANCE.toDto(route);
        System.out.println("ROUTE DTO: " + routeDto);
        routeRepository.delete(routeDto);

    }

    @Override
    public List<Route> findByCompetitionId(Integer competitionId)  {
        return CompetitionMapper.INSTANCE.toRoutes(routeRepository.findByIdCompetitionId(competitionId));
    }
    
}
