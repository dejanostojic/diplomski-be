package com.dostojic.climbers.repository.spring.data.adapter;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JpaAdminRepository extends CrudRepository<AdminDto, Long>,
    QuerydslPredicateExecutor<AdminDto> {

    @Override
    Optional<AdminDto> findById(Long id);

    Optional<AdminDto> findFirstByUsernameAndPassword(String username, String password);

    Optional<AdminDto> findFirstByUsername(String username);

    @Override
    void deleteById(Long integer);

    @Override
    void delete(AdminDto AdminDto);

    @Override
    AdminDto save(AdminDto AdminDto);
    
    
    
    
}
