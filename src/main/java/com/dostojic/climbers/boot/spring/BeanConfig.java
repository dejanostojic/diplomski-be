package com.dostojic.climbers.boot.spring;

import com.dostojic.climbers.logic.Controller;
import com.dostojic.climbers.logic.so.UserLoginSO;
import com.dostojic.climbers.logic.so.climber.*;
import com.dostojic.climbers.logic.so.competition.FindCompetition;
import com.dostojic.climbers.logic.so.competition.CreateCompetition;
import com.dostojic.climbers.logic.so.competition.SearchCompetitions;
import com.dostojic.climbers.logic.so.competition.UpdateCompetition;
import com.dostojic.climbers.repository.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by planina on 1.8.21..
 */
//@Configuration
public class BeanConfig {
/*
    @Bean
    public Controller controller(UserLoginSO userLoginSO, SearchClimbers searchClimbers,
                                 FindClimber climberDetailsSO, UpdateClimber updateClimberSo, DeleteClimber deleteClimberSO,
                                 CreateClimber createClimberSO, CreateCompetition createCompetitionSO, UpdateCompetition updateCompetition,
                                 SearchCompetitions searchCompetitions, FindCompetition competitionDetails) {
        return new Controller(userLoginSO, searchClimbers,
                climberDetailsSO, updateClimberSo, deleteClimberSO,
                createClimberSO, createCompetitionSO, updateCompetition, searchCompetitions, competitionDetails);
    }


    @Bean
    public UserLoginSO userLoginSO(UserRepository userRepository){
        return new UserLoginSO(userRepository);
    }

    @Bean
    public SearchClimbers searchClimbersSo(ClimberRepository climberRepository) {
        return new SearchClimbers(climberRepository);
    }

    @Bean
    public FindClimber findClimber(ClimberRepository climberRepository) {
        return new FindClimber(climberRepository);
    }

    @Bean
    public UpdateClimber updateClimber(ClimberRepository climberRepository) {
        return new UpdateClimber(climberRepository);
    }

    @Bean
    public DeleteClimber deleteClimber(ClimberRepository climberRepository) {
        return new DeleteClimber(climberRepository);
    }

    @Bean
    public CreateClimber createClimber(ClimberRepository climberRepository) {
        return new CreateClimber(climberRepository);
    }

    @Bean
    public CreateCompetition saveCompetition(CompetitionRepository competitionRepository,
                                             RouteRepository routeRepository, RegistrationFeeRepository registrationFeeRepository,
                                             RegistrationRepository registrationRepository) {
        return new CreateCompetition(competitionRepository, routeRepository, registrationFeeRepository, registrationRepository);
    }

    @Bean
    public UpdateCompetition updateCompetition(CompetitionRepository competitionRepository,
                                               RouteRepository routeRepository, RegistrationFeeRepository registrationFeeRepository,
                                               RegistrationRepository registrationRepository) {
        return new UpdateCompetition(competitionRepository, routeRepository, registrationFeeRepository, registrationRepository);
    }

    @Bean
    public SearchCompetitions searchCompetitions(CompetitionRepository competitionRepository) {
        return new SearchCompetitions(competitionRepository);
    }


    @Bean
    public FindCompetition getCompetitionDetailsSO(CompetitionRepository competitionRepository,
                                                   RouteRepository routeRepository, RegistrationFeeRepository registrationFeeRepository,
                                                   RegistrationRepository registrationRepository) {
        return new FindCompetition(competitionRepository, routeRepository, registrationFeeRepository, registrationRepository);
    }


//    @Bean
//    public (){return new ();}
*/
}
