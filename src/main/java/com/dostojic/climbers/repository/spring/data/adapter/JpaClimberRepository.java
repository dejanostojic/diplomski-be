package com.dostojic.climbers.repository.spring.data.adapter;


import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface JpaClimberRepository extends PagingAndSortingRepository<ClimberDto, Integer> , QuerydslPredicateExecutor<ClimberDto> {

    @Override
    Optional<ClimberDto> findById(Integer id);

    @Override
    void deleteById(Integer integer);

    @Override
    void delete(ClimberDto climberDto);

    @Override
    ClimberDto save(ClimberDto climberDto);

    List<ClimberDto> findClimberByFirstName(String firstName);
}
