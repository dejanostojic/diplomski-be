package com.dostojic.climbers.logic.so.competition;

import com.dostojic.climbers.domain.Competition;
import com.dostojic.climbers.exception.CompetitionNotValidException;

public class CompetitionValidator {


    public void validate(Competition competition) {
        boolean isValid = true;

        if (!isValid){
            throw new CompetitionNotValidException("CompetitionValidator message! TODO!");
        }
    }

}
