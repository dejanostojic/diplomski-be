/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dostojic.climbers.repository.spring.data.adapter;

import com.dostojic.climbers.domain.Climber;
import com.dostojic.climbers.domain.valueobject.ClimberSearchCriteria;
import com.dostojic.climbers.exception.EntityNotFoundException;
import com.dostojic.climbers.repository.ClimberRepository;
import com.dostojic.climbers.repository.spring.data.adapter.mapper.ClimberMapper;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.Expressions;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

/**
 * @author Dejan.Ostojic
 */
@Component
public class ClimberRepositoryJpaImpl implements ClimberRepository {

  @Autowired
  private JpaClimberRepository repo;

  private ClimberMapper mapper = ClimberMapper.INSTANCE;

  private Predicate getPredicate(ClimberSearchCriteria searchCriteria) {
    BooleanBuilder bb = new BooleanBuilder();

    bb.and(Expressions.asBoolean(true).isTrue());

    System.out.println("Got pred new ");
    if (searchCriteria.getFirstName() != null && !searchCriteria.getFirstName().isEmpty()) {
      System.out.println("aaaaa");
      bb.and(QClimberDto.climberDto.firstName.startsWithIgnoreCase(searchCriteria.getFirstName()));
      System.out.println("set it now");
    }
    if (searchCriteria.getLastName() != null && !searchCriteria.getLastName().isEmpty()) {
      System.out.println("last name!!!");
      bb.and(QClimberDto.climberDto.lastName.startsWithIgnoreCase(searchCriteria.getLastName()));
      System.out.println("gout it last name");
    }

    if (searchCriteria.getYearOfBirth() != null) {
      System.out.println("yb!!!");
      bb.and(QClimberDto.climberDto.yearOfBirth.eq(searchCriteria.getYearOfBirth()));
      System.out.println("gout it last name");
    }

    System.out.println("pred val: " + bb.getValue());

    return bb.getValue();
  }


  @Override
  public Page<Climber> searchClimbers(ClimberSearchCriteria searchCriteria) {
    StringBuilder where = new StringBuilder("true");

    Sort order = Sort.unsorted();

    if (searchCriteria.getSortOrd() != null && searchCriteria.getSortCol() != null) {
      order.and(searchCriteria.getSortOrd().isAsc() ?
          Sort.by(searchCriteria.getSortCol()).ascending() :
          Sort.by(searchCriteria.getSortCol()).descending());
    }

    Pageable pageable = PageRequest.of(searchCriteria.getPageNumber(), searchCriteria.getPageSize(),
        order);

    Predicate predicate = getPredicate(searchCriteria);
    Page<Climber> result = repo.findAll(predicate, pageable).map(dto -> mapper.fromDto(dto));
    System.out.println("results: " + result);

    return result;
  }

  @Override
  public void deleteById(Integer id) {
    repo.deleteById(id);
  }

  @Override
  public void delete(Climber climber) {
    repo.delete(mapper.toDto(climber));
  }

  @Override
  public boolean update(Climber climber) {
    repo.save(mapper.toDto(climber));
    return false; // TODO CHANGE TO VOID!
  }

  @Override
  public Climber findById(Integer climberId) {
    Optional<ClimberDto> optClimber = repo.findById(climberId);
    if (optClimber.isPresent()) {
      return mapper.fromDto(optClimber.get());

    }
    throw new EntityNotFoundException("Climber not found with id: " + climberId);
  }

  @Override
  public Climber insert(Climber climber) {
    try {
      return mapper.fromDto(repo.save(
          mapper.toDto(climber)));
    } catch (Exception ex) {
      ex.printStackTrace();
      throw new EntityNotFoundException("Error saving climber.", ex);
    }
  }

}
