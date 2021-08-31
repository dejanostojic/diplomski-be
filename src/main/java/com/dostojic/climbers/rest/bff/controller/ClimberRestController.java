package com.dostojic.climbers.rest.bff.controller;

import com.dostojic.climbers.domain.Climber;
import com.dostojic.climbers.domain.valueobject.ClimberSearchCriteria;
import com.dostojic.climbers.logging.Loggable;
import com.dostojic.climbers.logic.so.climber.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by planina on 1.8.21..
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/climbers")
//@Validated
public class ClimberRestController {

    @Autowired
    private CreateClimber createClimber;

    @Autowired
    private SearchClimbers searchClimbers;

    @Autowired
    private UpdateClimber updateClimber;

    @Autowired
    private DeleteClimber deleteClimber;

    @Autowired
    private FindClimber findClimber;

    @GetMapping()
    @Loggable
    public @ResponseBody ResponseEntity<Object> searchClimbers(ClimberSearchCriteria climberSearchCriteria) {
//        ClimberSearchCriteriaDto searchCriteriaDto = new ClimberSearchCriteriaDto();
//        searchCriteriaDto.
        try {
            System.out.println("GOT SEARCH CLIMBERS");
            System.out.println("climberSearchCriteria: " + climberSearchCriteria);
            return ResponseEntity.status(HttpStatus.OK).body(
                    searchClimbers.execute(climberSearchCriteria));
        } catch (Exception e) {
            throw new RuntimeException(e);
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PostMapping()
    @Loggable
    public @ResponseBody ResponseEntity<Object> save(@Valid @RequestBody Climber climber) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(createClimber.execute(climber));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    @Loggable
    public @ResponseBody ResponseEntity<Object> update(@PathVariable Long id, @Valid @RequestBody Climber climber) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(updateClimber.execute(climber));
        } catch (Exception  ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    @Loggable
    public @ResponseBody ResponseEntity<String> delete(@PathVariable Integer id) {
        try {
            deleteClimber.execute(id);
            return ResponseEntity.status(HttpStatus.OK).body("Deleted");
        } catch (Exception  ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @GetMapping("/{id}")
    public @ResponseBody ResponseEntity<Climber> find(@PathVariable Integer id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(findClimber.execute(id));
        } catch (Exception  ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null); // todo add error handler
        }
    }










}
