package com.dostojic.climbers.rest.bff.controller;

import com.dostojic.climbers.domain.Competition;
import com.dostojic.climbers.domain.RegistrationFee;
import com.dostojic.climbers.domain.Route;
import com.dostojic.climbers.repository.CompetitionRepository;
import com.dostojic.climbers.rest.bff.dto.CompetitionDto;
import com.dostojic.climbers.rest.bff.dto.RegistrationFeeDto;
import com.dostojic.climbers.rest.bff.dto.RouteDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)//(classes = {ClimbersApplication.class})
@TestPropertySource(
        locations = "classpath:application-it.properties")
//@Profile("it")
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@AutoConfigureMockMvc

class CompetitionRestControllerITTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CompetitionRepository compRepo;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void searchCompetitions() {
    }

    @Test
    @Sql({ "/competitions/competitions.sql"})
    @Transactional // this is because of compRepo validation
    @WithMockUser()
    void save() throws Exception {
        CompetitionDto comp = new CompetitionDto();
        comp.setId(37);
        comp.setName("Update comp name");

        RegistrationFeeDto rf1 = new RegistrationFeeDto();
        rf1.setName("fee1");
        rf1.setOrd(1);
        rf1.setAmount(BigDecimal.valueOf(100));
        rf1.setStartDate(Instant.now());
        rf1.setEndDate(Instant.now());

        RegistrationFeeDto rf2 = new RegistrationFeeDto();
        rf2.setName("fee2");
        rf2.setOrd(2);
        rf2.setAmount(BigDecimal.valueOf(200));
        rf2.setStartDate(Instant.now());
        rf2.setEndDate(Instant.now());

        RouteDto r1 = new RouteDto();
        r1.setOrd(1);
        r1.setName("1");
        r1.setGrade("1");
        RouteDto r2 = new RouteDto();
        r2.setOrd(2);
        r2.setName("2");
        r2.setGrade("2");
        RouteDto r3 = new RouteDto();
        r3.setOrd(3);
        r3.setName("3");
        r3.setGrade("3");


        comp.setRegistrationFees(Arrays.asList(rf1, rf2));
        comp.setRoutes(Arrays.asList(r1, r2, r3)); // TODO: CHECK IF THIS SHOULD BE MANDATORY!
        comp.setRegistrations(Collections.emptyList());
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println(objectMapper.writeValueAsString(comp));

        mockMvc.perform(MockMvcRequestBuilders.put("/api/competitions/{forumId}", 37L)
                .contentType("application/json")
//                .param("sendWelcomeMail", "true")
                .content(objectMapper.writeValueAsString(comp)))
                .andExpect(status().isOk());

        Competition updatedComp = compRepo.findById(37);
        assertEquals(comp.getName(), updatedComp.getName());
        assertEquals(2, updatedComp.getRegistrationFees().size());
        assertEquals(3, updatedComp.getRoutes().size());

        Optional<Route> optRoute = updatedComp.getRoutes().stream().filter(route -> route.getOrd().equals(1)).findFirst();
        assertTrue(optRoute.isPresent(), "route with ord 1 must be present");
        assertEquals("1", optRoute.get().getName(), "Route name must match");
    }

    @Test
    void update() {
    }

    @Test
    void find() {
    }
}