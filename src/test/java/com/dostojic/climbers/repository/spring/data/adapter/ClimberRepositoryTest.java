package com.dostojic.climbers.repository.spring.data.adapter;

import com.dostojic.climbers.ClimbersApplication;
import com.dostojic.climbers.domain.Climber;
import com.dostojic.climbers.domain.valueobject.ClimberSearchCriteria;
import com.dostojic.climbers.repository.ClimberRepository;
import com.dostojic.climbers.repository.spring.data.adapter.config.RepositoryConfig;
import org.dbunit.PrepAndExpectedTestCase;
import org.dbunit.PrepAndExpectedTestCaseSteps;
import org.dbunit.VerifyTableDefinition;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest//(classes = {ClimbersApplication.class})
@TestPropertySource(
        locations = "classpath:application-it.properties")
@Profile("it")
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)

class ClimberRepositoryTest /*extends DataSourceBasedDBTestCase */{


    @Autowired
    private ClimberRepository repo;


    @Test
    @Sql({ "/climbers/climbers.sql"})
    void getClimberById() throws Exception {

        Climber c1 = repo.findById(1);

        assertEquals(1, c1.getId());
        assertEquals("c1", c1.getFirstName());

        Climber c2 = repo.findById(2);

        assertEquals(2, c2.getId());
        assertEquals("c2", c2.getFirstName());

    }

    @Test
    @Sql({ "/climbers/climbers.sql"})
    void loadClimbers() throws Exception {

        Page<Climber> climbers = repo.searchClimbers(new ClimberSearchCriteria("c1", null,null, 0,10, null,ClimberSearchCriteria.SortOrd.Asc));

        assertEquals(1, climbers.getTotalElements());
        assertEquals(1, climbers.getNumberOfElements());
        assertEquals(1, climbers.getContent().get(0).getId());
        assertEquals("c1", climbers.getContent().get(0).getFirstName());

    }




}