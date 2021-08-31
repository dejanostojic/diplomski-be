package com.dostojic.climbers.repository.spring.data.adapter.mapper;

import com.dostojic.climbers.domain.Competition;
import com.dostojic.climbers.domain.RegistrationFee;
import com.dostojic.climbers.repository.spring.data.adapter.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class CompetitionMapperTest {

    @Test
    void toDto() {
        Competition c = new Competition();
        c.setId(1);
        c.setName("name");
        RegistrationFee rf1 = new RegistrationFee();
        rf1.setCompetition(c);
        rf1.setOrd(1);
        RegistrationFee rf2 = new RegistrationFee();
        rf2.setCompetition(c);
        rf2.setOrd(2);

        c.setRegistrationFees(Arrays.asList(rf1, rf2));


        CompetitionDto competitionDto = CompetitionMapper.INSTANCE.toDto(c);

        assertEquals(c.getId(), competitionDto.getId());
        assertEquals(c.getName(), competitionDto.getName());
        assertEquals(c.getRegistrationFees().get(0).getOrd(), competitionDto.getRegistrationFees().get(0).getOrd());
        assertEquals(c.getRegistrationFees().get(1).getOrd(), competitionDto.getRegistrationFees().get(1).getOrd());

    }

    @Test
    void toCompetition() {
        CompetitionDto cDto = new CompetitionDto();
        cDto.setId(1);
        cDto.setName("name");
        RegistrationFeeDto rf1 = new RegistrationFeeDto();
        rf1.setId(new RegistrationFeeCompositeId(cDto.getId(), 1));
        rf1.setOrd(1);
        rf1.setCompetition(cDto);
        RegistrationFeeDto rf2 = new RegistrationFeeDto();
        rf2.setId(new RegistrationFeeCompositeId(cDto.getId(), 2));
        rf2.setCompetition(cDto);
        rf2.setOrd(2);

        cDto.setRegistrationFees(Arrays.asList(rf1, rf2));


        Competition competition = CompetitionMapper.INSTANCE.fromDto(cDto);

        assertEquals(cDto.getId(), competition.getId() );
        assertEquals(cDto.getName(), competition.getName());
        assertEquals(cDto.getRegistrationFees().get(0).getOrd(), competition.getRegistrationFees().get(0).getOrd());
        assertEquals(cDto.getRegistrationFees().get(0).getId().getOrd(), competition.getRegistrationFees().get(0).getOrd());
        assertEquals(cDto.getRegistrationFees().get(0).getId().getCompetitionId(), competition.getRegistrationFees().get(0).getCompetition().getId());

    }

    @Test
    void toCompetitionWithEmptyChildCollection(){
        CompetitionDto cDto = new CompetitionDto();
        cDto.setId(1);
        cDto.setRegistrationFees(new ArrayList<>());
        cDto.setRoutes(new ArrayList<>());
        cDto.setRegistrations(new ArrayList<>());

        Competition competition = CompetitionMapper.INSTANCE.fromDto(cDto);

        assertEquals(1, competition.getId());
        assertNotNull(competition.getRoutes());
        assertNotNull(competition.getRegistrationFees());
        assertNotNull(competition.getRegistrations());

    }
}