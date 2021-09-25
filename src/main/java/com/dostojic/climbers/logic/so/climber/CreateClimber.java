/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dostojic.climbers.logic.so.climber;

import com.dostojic.climbers.domain.Climber;
import com.dostojic.climbers.logic.so.climber.validator.ClimberValidator;
import com.dostojic.climbers.logic.so.template.GeneralSO;
import com.dostojic.climbers.repository.ClimberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Dejan.Ostojic
 */
@Service
public class CreateClimber extends GeneralSO<Climber, Climber> {

  private ClimberRepository climberRepository;
  private ClimberValidator climberValidator;

  @Autowired
  public void setClimberRepository(ClimberRepository climberRepository) {
    this.climberRepository = climberRepository;
  }

  @Autowired
  public void setClimberValidator(
      ClimberValidator climberValidator) {
    this.climberValidator = climberValidator;
  }

  @Override
  protected void checkPrecondition(Climber climber) {
    climberValidator.validate(climber);
  }

  @Override
  public Climber executeOperation(Climber climber) {
    System.out.println("DEBUG: Inserting climber: " + climber);
    return climberRepository.insert(climber);
  }

}
