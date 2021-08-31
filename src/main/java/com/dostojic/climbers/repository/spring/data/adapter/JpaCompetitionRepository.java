package com.dostojic.climbers.repository.spring.data.adapter;


import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JpaCompetitionRepository extends PagingAndSortingRepository<CompetitionDto, Integer>, QuerydslPredicateExecutor<CompetitionDto> {

    @Override
    Optional<CompetitionDto> findById(Integer id);

    @Override
    void deleteById(Integer integer);

    @Override
    void delete(CompetitionDto competitionDto);

    @Override
    CompetitionDto save(CompetitionDto competitionDto);

}
