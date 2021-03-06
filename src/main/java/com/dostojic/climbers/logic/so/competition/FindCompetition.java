/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dostojic.climbers.logic.so.competition;

import com.dostojic.climbers.domain.Competition;
import com.dostojic.climbers.domain.RegistrationFee;
import com.dostojic.climbers.domain.Route;
import com.dostojic.climbers.logic.so.template.GeneralSO;
import com.dostojic.climbers.repository.CompetitionRepository;
import com.dostojic.climbers.repository.RegistrationFeeRepository;
import com.dostojic.climbers.repository.RegistrationRepository;
import com.dostojic.climbers.repository.RouteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Dejan.Ostojic
 */
@Service
public class FindCompetition extends GeneralSO<Integer, Competition> {

    private final CompetitionRepository competitionRepository;
    private final RouteRepository routeRepository;
    private final RegistrationFeeRepository registrationFeeRepository;
    private final RegistrationRepository registrationRepository;
    
    public FindCompetition(CompetitionRepository competitionRepository,
                           RouteRepository routeRepository, RegistrationFeeRepository registrationFeeRepository,
                           RegistrationRepository registrationRepository) {
        this.competitionRepository = competitionRepository;
        this.routeRepository = routeRepository;
        this.registrationFeeRepository = registrationFeeRepository;
        this.registrationRepository = registrationRepository;
    }


    @Override
    protected Competition executeOperation(Integer id)  {
        Competition competition = competitionRepository.findById(id);
        /*
        List<Route> routes = getRoutesForCompetition(competition);
        competition.setRoutes(routes);
        
        List<RegistrationFee> registrationFees = getRegistrationFeesForCompetition(competition);
        competition.setRegistrationFees(registrationFees);
        */
        return competition;
    }
    
    
    private List<Route> getRoutesForCompetition(Competition competition) {
        return routeRepository.findByCompetitionId(competition.getId())
                .stream()
                .map(route -> {
                    
                    route.setCompetition(competition);
                    
                    return route;
                })
                .collect(Collectors.toList());    
    }
    
    private List<RegistrationFee> getRegistrationFeesForCompetition(Competition competition) {
        return registrationFeeRepository.findByCompetitionId(competition.getId())
                .stream()
                .map(registrationFee -> {
                    registrationFee.setCompetition(competition);
                    
                    return registrationFee;
                })
                .collect(Collectors.toList());    
    }
    

}
    