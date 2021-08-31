/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dostojic.climbers.rest.bff.dto.mapper;

import com.dostojic.climbers.domain.Registration;
import com.dostojic.climbers.rest.bff.dto.*;
import com.dostojic.climbers.domain.Competition;
import com.dostojic.climbers.domain.RegistrationFee;
import com.dostojic.climbers.domain.Route;
import com.dostojic.climbers.domain.valueobject.CompetitionSearchCriteria;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 *
 * @author Dejan.Ostojic
 */
@Mapper
public interface CompetitionMapper {
    
    public static CompetitionMapper INSTANCE = Mappers.getMapper(CompetitionMapper.class);

    Competition fromDto(CompetitionDto competitionDto);
    CompetitionDto toDto(Competition competition);

    CompetitionSearchCriteria toSearchCriteria(CompetitionSearchCriteriaDto searchCriteria);
    
    Route fromDto(RouteDto routeDto);
    RouteDto toDto(Route route);

    RegistrationFee fromDto(RegistrationFeeDto registrationFeeDto);
    RegistrationFeeDto toDto(RegistrationFee registrationFee);

    Registration fromDto(RegistrationDto registrationDto);
    RegistrationDto toDto(Registration registration);


    @AfterMapping
    default void afterCompetitionMapping(@MappingTarget Competition competition, CompetitionDto competitionDto) {
        if (competition.getRegistrationFees() != null) {
            competition.getRegistrationFees().forEach(registrationFee
                    -> registrationFee.setCompetition(competition));
        }
        if (competition.getRoutes() != null) {
            competition.getRoutes().forEach(route
                    -> route.setCompetition(competition));
        }
        if (competition.getRegistrations() != null) {
            competition.getRegistrations().forEach(registration
                    -> registration.setCompetition(competition));
        }

    }



}
