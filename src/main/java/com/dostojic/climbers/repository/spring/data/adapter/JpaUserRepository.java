package com.dostojic.climbers.repository.spring.data.adapter;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JpaUserRepository extends JpaRepository<UserDto, Integer> {

    @Override
    Optional<UserDto> findById(Integer id);

    Optional<UserDto> findFirstByUsernameAndPassword(String username, String password);

    Optional<UserDto> findFirstByUsername(String username);

    @Override
    void deleteById(Integer integer);

    @Override
    void delete(UserDto UserDto);

    @Override
    UserDto save(UserDto UserDto);
    
    
    
    
}
