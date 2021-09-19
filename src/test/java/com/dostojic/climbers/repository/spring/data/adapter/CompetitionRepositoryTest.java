package com.dostojic.climbers.repository.spring.data.adapter;

import com.dostojic.climbers.domain.Climber;
import com.dostojic.climbers.domain.Competition;
import com.dostojic.climbers.domain.Registration;
import com.dostojic.climbers.domain.RegistrationFee;
import com.dostojic.climbers.domain.valueobject.ClimberSearchCriteria;
import com.dostojic.climbers.repository.ClimberRepository;
import com.dostojic.climbers.repository.CompetitionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest//(classes = {ClimbersApplication.class})
@TestPropertySource(
        locations = "classpath:application-it.properties")
@Profile("it")
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)

class CompetitionRepositoryTest /*extends DataSourceBasedDBTestCase */{


    @Autowired
    private CompetitionRepository repo;

    @Autowired
    private JpaCompetitionRepository jpaCompetitionRepository;


    @Test
    @Sql({ "/competitions/competitions.sql"})
    @Transactional
    void getCompetitionById() throws Exception {

        Competition c = repo.findById(37);

        assertEquals(37, c.getId());
        assertEquals("Comp 37", c.getName());

        List<RegistrationFee> fees = c.getRegistrationFees();
        assertEquals(3, fees.size());
        assertNotNull(fees.get(0).getCompetition(), "Competitions must not be null");
        assertEquals(37, fees.get(0).getCompetition().getId(), "Competition id must match");
        assertNotNull(c.getRoutes());

        List<Registration> registrations = c.getRegistrations();
        assertEquals(1, registrations.size(), "Registration must be loaded");
        assertEquals(1, registrations.get(0).getClimber().getId(), "Registered climber must be loaded");


    }

    @Test
    @Sql({ "/competitions/competitions.sql"})
    @Transactional
    void update(){
        String newName= "NAME UPDATE FOR FEE";
        Competition c = repo.findById(37);
        c.getRegistrationFees().get(0).setName(newName);

        repo.update(c);
        assertEquals(newName,repo.findById(37).getRegistrationFees().get(0).getName());

    }



    @Test
//    @Sql({ "/competitions/competitions.sql"})
    @Transactional
    void insert(){

        assertEquals(0, jpaCompetitionRepository.count());

        String newName= "New comp";
        Competition c = new Competition();
        c.setName(newName);
        RegistrationFee fee1 = new RegistrationFee();
        fee1.setOrd(1);

        fee1.setCompetition(c);
        fee1.setName("n1");

        RegistrationFee fee2 = new RegistrationFee();
        fee2.setOrd(2);
        fee2.setCompetition(c);
        fee2.setName("n2");

        c.setRegistrationFees(Arrays.asList(fee1, fee2));
        c.setRoutes(new ArrayList<>());
        c.setRegistrations(new ArrayList<>());


        Competition insert = repo.insert(c);

        assertEquals(newName, insert.getName());
        assertEquals(2, insert.getRegistrationFees().size());


        Competition loaded = repo.findById(insert.getId());


        System.out.println("all comp:");
        jpaCompetitionRepository.findAll().iterator().forEachRemaining(comp -> {
            System.out.println(comp);
        });

        assertEquals(1, jpaCompetitionRepository.count());


    }



}