package com.dostojic.climbers.repository.spring.data.adapter;


import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface JpaRouteRepository extends PagingAndSortingRepository<RouteDto, Integer> {

    @Override
    Optional<RouteDto> findById(Integer id);

    @Override
    void deleteById(Integer integer);

    @Override
    void delete(RouteDto routeDto);

    @Override
    RouteDto save(RouteDto routeDto);


    List<RouteDto> findByIdCompetitionId(Integer competitionId);
}
