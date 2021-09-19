/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dostojic.climbers.repository.spring.data.adapter.mapper;

import com.dostojic.climbers.domain.Competition;
import com.dostojic.climbers.domain.Registration;
import com.dostojic.climbers.domain.RegistrationFee;
import com.dostojic.climbers.domain.Route;
import com.dostojic.climbers.repository.spring.data.adapter.*;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.Collection;
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

    List<Competition> toCompetitions(Collection<CompetitionDto> competitinDtos);

    List<Route> toRoutes(Collection<RouteDto> routeDtos);

    // PREVENT CIRCULAR MAPPING OF FEES
    @IterableMapping(qualifiedByName="toFeeDtoListWithoutCompetitionFees")
    List<RegistrationFeeDto> toRegistrationFeeDtos(List<RegistrationFee> registrationFees);

    @Named("toFeeDtoListWithoutCompetitionFees")
    @Mapping(target = "competition.routes", ignore = true)
    @Mapping(target = "competition.registrationFees", ignore = true)
    @Mapping(target = "competition.registrations", ignore = true)
    @Mapping(source = "competition.id", target = "id.competitionId")
    @Mapping(source = "ord", target = "id.ord")
    RegistrationFeeDto mapWithouData(RegistrationFee source);


    @IterableMapping(qualifiedByName="toFeeListWithoutCompetitionFees")
    List<RegistrationFee> toRegistrationFee(List<RegistrationFeeDto> registrationFeeDtos);

    @Named("toFeeListWithoutCompetitionFees")
    @Mapping(target = "competition.routes", ignore = true)
    @Mapping(target = "competition.registrationFees", ignore = true)
    RegistrationFee toFeeListWithoutCompetitionFees(RegistrationFeeDto source);

    // PREVENT CIRCULAR MAPPING OF Routes
    @IterableMapping(qualifiedByName="toRouteDtoListWithoutCompetitionRoutes")
    List<RouteDto> toRouteDtos(List<Route> routes);

    @Named("toRouteDtoListWithoutCompetitionRoutes")
    @Mapping(target = "competition.routes", ignore = true)
    @Mapping(target = "competition.registrationFees", ignore = true)
    @Mapping(target = "competition.registrations", ignore = true)
    @Mapping(source = "competition.id", target = "id.competitionId")
    @Mapping(source = "ord", target = "id.ord")
    RouteDto mapWithouData(Route source);


    @IterableMapping(qualifiedByName="toRouteListWithoutCompetitionRoutes")
    List<Route> toRoute(List<RouteDto> routeDtos);

    @Named("toRouteListWithoutCompetitionRoutes")
    @Mapping(target = "competition.routes", ignore = true)
    @Mapping(target = "competition.registrationFees", ignore = true)
    @Mapping(target = "competition.registrations", ignore = true)
    Route toRouteListWithoutCompetitionRoutes(RouteDto source);


    Route fromDto(RouteDto routeDto);


    @Mapping(source = "competition.id", target = "id.competitionId")
    @Mapping(source = "ord", target = "id.ord")
    RouteDto toDto(Route route);

    RegistrationFee fromDto(RegistrationFeeDto registrationFeeDto);

    @Mapping(source = "competition.id", target = "id.competitionId")
    @Mapping(source = "ord", target = "id.ord")
    RegistrationFeeDto toDto(RegistrationFee registrationFee);

    Registration fromDto(RegistrationDto registrationDto);

    @Mapping(source = "competition.id", target = "id.competitionId")
    @Mapping(source = "climber.id", target = "id.climberId")
    RegistrationDto toDto(Registration registration);

//    public List<Registration> toRegistrations(List<RegistrationDto> loadList);


    // prevent circular mapping of registrations
    // PREVENT CIRCULAR MAPPING OF FEES
    @IterableMapping(qualifiedByName="toRegistrationDtoListWithoutRegistrations")
    List<RegistrationDto> toRegistrationDtos(List<Registration> registration);

    @Named("toRegistrationDtoListWithoutRegistrations")
    @Mapping(target = "competition.routes", ignore = true)
    @Mapping(target = "competition.registrationFees", ignore = true)
    @Mapping(target = "competition.registrations", ignore = true)
    @Mapping(source = "competition.id", target = "id.competitionId")
    @Mapping(source = "climber.id", target = "id.climberId")
    RegistrationDto mapWithouData(Registration source);


    @IterableMapping(qualifiedByName="toRegistrationListWithoutRegistrations")
    List<Registration> toRegistration(List<RegistrationDto> registrationDtos);

    @Named("toRegistrationListWithoutRegistrations")
    @Mapping(target = "competition.routes", ignore = true)
    @Mapping(target = "competition.registrationFees", ignore = true)
    @Mapping(target = "competition.registrations", ignore = true)
    Registration toRegistrationListWithoutCompetitionFees(RegistrationDto source);

    @AfterMapping
    default void afterCompetitionMapping(@MappingTarget Competition competition, CompetitionDto competitionDto) {
       /* if (competition.getRegistrationFees() != null) {
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
        }*/
    }

    @AfterMapping
    default void afterCompetitionDtoMapping(@MappingTarget CompetitionDto competitionDto, Competition competition) {
     /*   if (competitionDto.getRegistrationFees() != null) {
            competitionDto.getRegistrationFees().forEach(registrationFee
                    -> registrationFee.setId(new RegistrationFeeCompositeId(competitionDto, registrationFee.getOrd())));
        }

        if (competitionDto.getRoutes() != null) {
            competitionDto.getRoutes().forEach(route
                    -> route.setId(new RouteCompositeId(competitionDto, route.getOrd())));
        }*/
//      TODO: Retink this, now Climber is used for ID!
//        if (competitionDto.getRegistrations() != null) {
//            competitionDto.getRegistrations().forEach(registration
//                    -> registration.setId(new RegistrationCompositeId(competitionDto, registration.get)));
//        }

    }

}
