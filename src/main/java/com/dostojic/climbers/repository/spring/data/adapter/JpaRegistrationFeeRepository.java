package com.dostojic.climbers.repository.spring.data.adapter;


import com.dostojic.climbers.repository.spring.data.adapter.RegistrationFeeDto;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JpaRegistrationFeeRepository extends PagingAndSortingRepository<RegistrationFeeDto, Integer> {

    @Override
    Optional<RegistrationFeeDto> findById(Integer id);

    @Override
    void deleteById(Integer integer);

    @Override
    void delete(RegistrationFeeDto RegistrationFeeDto);

    @Override
    RegistrationFeeDto save(RegistrationFeeDto RegistrationFeeDto);

}
