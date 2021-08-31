package com.dostojic.climbers.rest.bff.controller;

import com.dostojic.climbers.domain.Competition;
import com.dostojic.climbers.domain.valueobject.CompetitionSearchCriteria;
import com.dostojic.climbers.logging.Loggable;
import com.dostojic.climbers.logic.so.competition.*;
import com.dostojic.climbers.rest.bff.dto.CompetitionDto;
import com.dostojic.climbers.rest.bff.dto.mapper.CompetitionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by planina on 1.8.21..
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/competitions")
//@Validated
public class CompetitionRestController {

    @Autowired
    private CreateCompetition createCompetition;

    @Autowired
    private SearchCompetitions searchCompetitions;

    @Autowired
    private UpdateCompetition updateCompetition;
//
//    @Autowired
//    private DeleteCompetition deleteCompetition;

    @Autowired
    private FindCompetition findCompetition;

    @GetMapping()
    @Loggable
    public @ResponseBody ResponseEntity<Object> searchCompetitions(CompetitionSearchCriteria competitionSearchCriteria) {
//        CompetitionSearchCriteriaDto searchCriteriaDto = new CompetitionSearchCriteriaDto();
//        searchCriteriaDto.
//        try {
            System.out.println("GOT SEARCH CLIMBERS");
            System.out.println("competitionSearchCriteria: " + competitionSearchCriteria);



        return ResponseEntity.status(HttpStatus.OK).body(
                searchCompetitions.execute(competitionSearchCriteria).map(CompetitionMapper.INSTANCE::toDto)
            );
//        } catch (Exception e) {
//            throw new RuntimeException(e);
////            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
//        }
    }

    @PostMapping()
    @Loggable
    public @ResponseBody ResponseEntity<Object> save(@Valid @RequestBody CompetitionDto competition) {

        Competition result = createCompetition.execute(CompetitionMapper.INSTANCE.fromDto(competition));
//        System.out.println("result: " + result);


        return ResponseEntity.status(HttpStatus.OK).body(CompetitionMapper.INSTANCE.toDto(result));
    }

    @PutMapping("/{id}")
    @Loggable
    public @ResponseBody ResponseEntity<Object> update(@PathVariable Integer id, @Valid @RequestBody CompetitionDto competition) {
//        try {
        if (competition.getId() == null){
            competition.setId(id);
        } else {
            if (competition.getId() != id){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Id in path param must match id in the body, or id in the body should be ommited.");
            }
        }

        competition.setId(id);
        Competition result = updateCompetition.execute(CompetitionMapper.INSTANCE.fromDto(competition));
        return ResponseEntity.status(HttpStatus.OK).body(CompetitionMapper.INSTANCE.toDto(result));
//        } catch (Exception  ex) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
//        }
    }
//
//    @DeleteMapping("/{id}")
//    @Loggable
//    public @ResponseBody ResponseEntity<String> delete(@PathVariable Integer id) {
//        try {
//            deleteCompetition.execute(id);
//            return ResponseEntity.status(HttpStatus.OK).body("Deleted");
//        } catch (Exception  ex) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
//        }
//    }

    @GetMapping("/{id}")
    public @ResponseBody ResponseEntity<CompetitionDto> find(@PathVariable Integer id) {
//        try {
            return ResponseEntity.status(HttpStatus.OK).body(CompetitionMapper.INSTANCE.toDto(findCompetition.execute(id)));
//        } catch (Exception  ex) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null); // todo add error handler
//        }
    }










}
