package com.dostojic.climbers.repository.spring.data.adapter;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface JpaRegistrationRepository extends JpaRepository<RegistrationDto, Integer> {

    @Override
    Optional<RegistrationDto> findById(Integer id);


    @Override
    void deleteById(Integer integer);

    @Override
    void delete(RegistrationDto registrationDto);

    @Override
    RegistrationDto save(RegistrationDto registrationDto);

    List<RegistrationDto> findRegistrationsByIdCompetitionId(Integer id);


}
