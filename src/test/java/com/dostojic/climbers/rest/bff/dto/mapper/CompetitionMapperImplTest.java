package com.dostojic.climbers.rest.bff.dto.mapper;

import com.dostojic.climbers.domain.Competition;
import com.dostojic.climbers.domain.RegistrationFee;
import com.dostojic.climbers.rest.bff.dto.CompetitionDto;
import com.dostojic.climbers.rest.bff.dto.RegistrationFeeDto;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class CompetitionMapperImplTest {

    private static RegistrationFeeDto fee1;
    private static RegistrationFeeDto fee2;

    static {
         fee1 = new RegistrationFeeDto();
         fee1.setOrd(1);
         fee1.setName("EarlyBirds");
         fee1.setAmount(BigDecimal.ONE);
         fee1.setEndDate(Instant.now());
         fee1.setStartDate(Instant.now());

         fee2 = new RegistrationFeeDto();
         fee2.setOrd(2);
         fee2.setName("Regular");
         fee2.setAmount(BigDecimal.valueOf(2));
         fee2.setEndDate(Instant.now());
         fee2.setStartDate(Instant.now());

    }
    @Test
    void fromDto() {
        CompetitionDto dto = new CompetitionDto();
        dto.setId(1);
        dto.setName("c1");

        dto.setRegistrationFees(Arrays.asList(fee1,fee2));

        Competition competition = CompetitionMapper.INSTANCE.fromDto(dto);

        assertEquals(dto.getId(), competition.getId(), "Id must be correct");
        assertEquals(dto.getName(), competition.getName(), "Id must be correct");
        assertEquals(2, competition.getRegistrationFees().size());
        assertNotNull(competition.getRegistrationFees().get(0).getCompetition(), "Competition is set for registiation fee");
        assertEquals(dto.getId(), competition.getRegistrationFees().get(0).getCompetition().getId(), "Competition id matches");

    }

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

}