package com.dostojic.climbers.rest.bff.controller;

import com.dostojic.climbers.domain.Climber;
import com.dostojic.climbers.domain.valueobject.ClimberSearchCriteria;
import com.dostojic.climbers.logging.Loggable;
import com.dostojic.climbers.logic.so.climber.CreateClimber;
import com.dostojic.climbers.logic.so.climber.DeleteClimber;
import com.dostojic.climbers.logic.so.climber.FindClimber;
import com.dostojic.climbers.logic.so.climber.SearchClimbers;
import com.dostojic.climbers.logic.so.climber.UpdateClimber;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/climbers")
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
  public Page<Climber> searchClimbers(ClimberSearchCriteria climberSearchCriteria) {
    return searchClimbers.execute(climberSearchCriteria);
  }

  @PostMapping()
  @Loggable
  public Climber save(@Valid @RequestBody Climber climber) {
    return createClimber.execute(climber);
  }

  @PutMapping("/{id}")
  @Loggable
  public Climber update(@PathVariable Long id, @Valid @RequestBody Climber climber) {
    updateClimber.execute(climber);
    return climber;
  }

  @DeleteMapping("/{id}")
  @Loggable
  public void delete(@PathVariable Integer id) {
    deleteClimber.execute(id);
  }

  @GetMapping("/{id}")
  public Climber find(@PathVariable Integer id) {
    return findClimber.execute(id);
  }


}
