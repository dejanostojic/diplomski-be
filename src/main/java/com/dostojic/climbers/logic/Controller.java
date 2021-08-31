/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dostojic.climbers.logic;

import com.dostojic.climbers.domain.Climber;
import com.dostojic.climbers.domain.Competition;
import com.dostojic.climbers.domain.User;
import com.dostojic.climbers.domain.valueobject.ClimberSearchCriteria;
import com.dostojic.climbers.domain.valueobject.CompetitionSearchCriteria;
import com.dostojic.climbers.domain.valueobject.LoginCredentials;
import com.dostojic.climbers.logic.so.climber.CreateClimber;
import com.dostojic.climbers.logic.so.climber.DeleteClimber;
import com.dostojic.climbers.logic.so.climber.SearchClimbers;
import com.dostojic.climbers.logic.so.climber.FindClimber;
import com.dostojic.climbers.logic.so.climber.UpdateClimber;
import com.dostojic.climbers.logic.so.competition.FindCompetition;
import com.dostojic.climbers.logic.so.competition.CreateCompetition;
import com.dostojic.climbers.logic.so.competition.SearchCompetitions;
import com.dostojic.climbers.logic.so.competition.UpdateCompetition;
import com.dostojic.climbers.logic.so.template.GeneralSO;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 *
 * @author planina
 */
public class Controller {

    private final GeneralSO<LoginCredentials, User> userLoginSO;

    // Climber related system operations
    private final SearchClimbers searchClimbers;
    private final FindClimber climberDetailsSO;
    private final UpdateClimber updateClimberSo;
    private final DeleteClimber deleteClimberSO;
    private final CreateClimber createClimberSO;

    // Competition related SO
    private final CreateCompetition createCompetitionSO;
    private final UpdateCompetition updateCompetition;
    private final SearchCompetitions searchCompetitions;
    private final FindCompetition competitionDetails;

    public Controller(GeneralSO<LoginCredentials, User> userLoginSO, SearchClimbers searchClimbers, FindClimber climberDetailsSO, UpdateClimber updateClimberSo, DeleteClimber deleteClimberSO, CreateClimber createClimberSO, CreateCompetition createCompetitionSO, UpdateCompetition updateCompetition, SearchCompetitions searchCompetitions, FindCompetition competitionDetails) {
        this.userLoginSO = userLoginSO;
        this.searchClimbers = searchClimbers;
        this.climberDetailsSO = climberDetailsSO;
        this.updateClimberSo = updateClimberSo;
        this.deleteClimberSO = deleteClimberSO;
        this.createClimberSO = createClimberSO;
        this.createCompetitionSO = createCompetitionSO;
        this.updateCompetition = updateCompetition;
        this.searchCompetitions = searchCompetitions;
        this.competitionDetails = competitionDetails;
    }
    
    public User login(LoginCredentials credentials) throws Exception {
        return userLoginSO.execute(credentials);
    }
    
    public Page<Climber> searchClimbers(ClimberSearchCriteria searchCritera) throws Exception{
        return searchClimbers.execute(searchCritera);
    }
    
    public Climber findClimberById(Integer id) throws Exception{
        return climberDetailsSO.execute(id);
    }
    
    public void deleteClimberById(Integer id) throws Exception{
        deleteClimberSO.execute(id);
    }
    
    public void updateClimber(Climber climber) throws Exception{
        updateClimberSo.execute(climber);
    }

    public Climber createClimber(Climber climber) throws Exception {
        return createClimberSO.execute(climber);
    }

    public Competition saveCompetition(Competition competition) throws Exception {
        return createCompetitionSO.execute(competition);
    }
    
    public Page<Competition> searchCompetitions(CompetitionSearchCriteria searchCriteria) throws Exception{
        return searchCompetitions.execute(searchCriteria);
    }

    public Competition findCompetitionById(Integer id) throws Exception{
        return competitionDetails.execute(id);
    }
    
    public Competition updateCompetition(Competition competition) throws Exception {
        return updateCompetition.execute(competition);
    }
}