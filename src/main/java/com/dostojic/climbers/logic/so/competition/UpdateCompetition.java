/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dostojic.climbers.logic.so.competition;

import com.dostojic.climbers.domain.Competition;
import com.dostojic.climbers.domain.Registration;
import com.dostojic.climbers.domain.RegistrationFee;
import com.dostojic.climbers.domain.Route;
import com.dostojic.climbers.logic.so.template.GeneralSO;
import com.dostojic.climbers.repository.CompetitionRepository;
import com.dostojic.climbers.repository.RegistrationFeeRepository;
import com.dostojic.climbers.repository.RegistrationRepository;
import com.dostojic.climbers.repository.RouteRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 *
 * @author Dejan.Ostojic
 */
@Service
public class UpdateCompetition extends GeneralSO<Competition, Competition> {

    private final CompetitionRepository competitionRepository;
    private final RouteRepository routeRepository;
    private final RegistrationFeeRepository registrationFeeRepository;
    private final RegistrationRepository registrationRepository;

    public UpdateCompetition(CompetitionRepository competitionRepository,
            RouteRepository routeRepository, RegistrationFeeRepository registrationFeeRepository, 
            RegistrationRepository registrationRepository) {
        this.competitionRepository = competitionRepository;
        this.routeRepository = routeRepository;
        this.registrationFeeRepository = registrationFeeRepository;
        this.registrationRepository = registrationRepository;
    }

    @Override
    protected void checkPrecondition(Competition domainObject) {
        System.out.println("TODO: CHECK PRECONDITIONS FOR UPDATE COMPETITION");
    }

    @Override
    protected Competition executeOperation(Competition submittedCompetition) {
        Competition fromDb = competitionRepository.findById(submittedCompetition.getId());

        // update competition fields
        fromDb.setName(submittedCompetition.getName());
        fromDb.setDescription(submittedCompetition.getDescription());
        fromDb.setEventStart(submittedCompetition.getEventStart());
        fromDb.setRegistrationOpen(submittedCompetition.getRegistrationOpen());
        fromDb.setRegistrationClose(submittedCompetition.getRegistrationClose());


        // update children

        handleRoutes(fromDb, submittedCompetition);
        handleRegistrationFees(fromDb, submittedCompetition);
        handleRegistrations(fromDb, submittedCompetition);

        System.out.println(fromDb.toString());

        // execute update to the db
        return competitionRepository.update(fromDb);
    }

    private void handleRoutes(Competition fromDb, Competition competition)  {
        List<Route> prevRoutes = fromDb.getRoutes();
        List<Route> submittedRoutes = competition.getRoutes();

        List<Route> deletedRoutes = submittedRoutes == null ? prevRoutes : findDeletedRoutes(prevRoutes, submittedRoutes);
        List<Route> createdRoutes = submittedRoutes == null ? new ArrayList<>() : findCreatedRoutes(prevRoutes, submittedRoutes);

        prevRoutes.removeAll(deletedRoutes);
        updateRoutes(prevRoutes, submittedRoutes);

        prevRoutes.addAll(createdRoutes);

    }


    private List<Route> findDeletedRoutes(List<Route> prevRoutes, List<Route> submittedRoutes) {
        return prevRoutes.stream().filter(prev -> !submittedRoutes.contains(prev)).collect(Collectors.toList());
    }

    private void updateRoutes(List<Route> prevRoutes, List<Route> submittedRoutes){
        prevRoutes.stream().forEach(prev -> {
            Optional<Route> submitted = submittedRoutes.stream().filter(newRoute -> prev.equals(newRoute)).findFirst();
            if (submitted.isPresent()) {
                CompetitionMapper.INSTANCE.update(submitted.get(), prev);
            }
        });
    }

    private List<Route> findCreatedRoutes(List<Route> prevRoutes, List<Route> submittedRoutes) {
        return submittedRoutes.stream().filter(submitted -> !prevRoutes.contains(submitted)).collect(Collectors.toList());
    }


    private void handleRegistrationFees(Competition prevComp, Competition submitterdCompetition) {
        List<RegistrationFee> prevFees = prevComp.getRegistrationFees();
        List<RegistrationFee> submittedFees = submitterdCompetition.getRegistrationFees();

        List<RegistrationFee> deletedRoutes = findDeletedRegistrationFees(prevFees, submittedFees);
        List<RegistrationFee> createdRoutes = findCreatedRegistrationFees(prevFees, submittedFees);

        prevFees.removeAll(deletedRoutes);
        updateFees(prevFees, submittedFees);

        prevFees.addAll(createdRoutes);

    }

    private void handleRegistrations(Competition prevComp, Competition submitterdCompetition) {
        List<Registration> prevRegs = prevComp.getRegistrations();
        List<Registration> submittedRegs = submitterdCompetition.getRegistrations();

        List<Registration> deletedRoutes = findDeletedRegistrations(prevRegs, submittedRegs);
//        List<Registration> updatedRoutes = findUpdatedRegistrationFees(prevFees, submittedFees);
        List<Registration> createdRoutes = findCreatedRegistrations(prevRegs, submittedRegs);

        prevRegs.removeAll(deletedRoutes);
        updateRegs(prevRegs, submittedRegs);

        prevRegs.addAll(createdRoutes);

    }

    private void updateFees(List<RegistrationFee> prevFees, List<RegistrationFee> submittedFees){
        prevFees.stream().forEach(prev -> {
            Optional<RegistrationFee> submitted = submittedFees.stream().filter(newRoute -> prev.equals(newRoute)).findFirst();
            if (submitted.isPresent()) {
                CompetitionMapper.INSTANCE.update(submitted.get(), prev);
            }
        });
    }

    private void updateRegs(List<Registration> prevRegs, List<Registration> submittedRegs){
        prevRegs.stream().forEach(prev -> {
            Optional<Registration> submitted = submittedRegs.stream().filter(newReg -> prev.equals(newReg)).findFirst();
            if (submitted.isPresent()) {
                CompetitionMapper.INSTANCE.update(submitted.get(), prev);
            }
        });
    }

    private List<RegistrationFee> findDeletedRegistrationFees(List<RegistrationFee> prevRoutes, List<RegistrationFee> submittedRoutes) {
        return prevRoutes.stream().filter(prev -> !submittedRoutes.contains(prev)).collect(Collectors.toList());
    }
    
    private List<RegistrationFee> findUpdatedRegistrationFees(List<RegistrationFee> prevRoutes, List<RegistrationFee> submittedRoutes) {
        return submittedRoutes.stream().filter(submitted -> prevRoutes.contains(submitted)).collect(Collectors.toList());
    }

    private List<RegistrationFee> findCreatedRegistrationFees(List<RegistrationFee> prevRoutes, List<RegistrationFee> submittedRoutes) {
        return submittedRoutes.stream().filter(submitted -> !prevRoutes.contains(submitted)).collect(Collectors.toList());
    }
    
    private void handleRegistrations(Competition competition) {
        List<Registration> prevRoutes = registrationRepository.findByCompetitionId(competition.getId());
        List<Registration> submittedRoutes = competition.getRegistrations();

        List<Registration> deletedRoutes = findDeletedRegistrations(prevRoutes, submittedRoutes);
        List<Registration> updatedRoutes = findUpdatedRegistrations(prevRoutes, submittedRoutes);
        List<Registration> createdRoutes = findCreatedRegistrations(prevRoutes, submittedRoutes);

        for (Registration r : deletedRoutes) {
            registrationRepository.delete(r);
        }

        for (Registration r : updatedRoutes) {
            registrationRepository.update(r);
        }

        for (Registration r : createdRoutes) {
            registrationRepository.insert(r);
        }
    }
    
    private List<Registration> findDeletedRegistrations(List<Registration> prevRoutes, List<Registration> submittedRoutes) {
        return prevRoutes.stream().filter(prev -> !submittedRoutes.contains(prev)).collect(Collectors.toList());
    }
    
    private List<Registration> findUpdatedRegistrations(List<Registration> prevRoutes, List<Registration> submittedRoutes) {
        return submittedRoutes.stream().filter(submitted -> prevRoutes.contains(submitted)).collect(Collectors.toList());
    }

    private List<Registration> findCreatedRegistrations(List<Registration> prevRoutes, List<Registration> submittedRoutes) {
        return submittedRoutes.stream().filter(submitted -> !prevRoutes.contains(submitted)).collect(Collectors.toList());
    }


}
