/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dostojic.climbers.repository.spring.data.adapter;

import com.dostojic.climbers.dbbr.improved.DbBroker;
import com.dostojic.climbers.domain.User;
import com.dostojic.climbers.exception.EntityNotFoundException;
import com.dostojic.climbers.repository.UserRepository;
import com.dostojic.climbers.repository.spring.data.adapter.UserDto;
import com.dostojic.climbers.repository.spring.data.adapter.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.dostojic.climbers.dbbr.improved.QueryUtils.stringLiteral;

/**
 *
 * @author planina
 */
@Component // TODO REFACTOR TO JPA IMPL
public class UserRepositoryDbbrImpl implements UserRepository {

    @Autowired
    private JpaUserRepository repo;

    @Override
    public List<User> getAll()  {
        return repo.findAll()
                .stream()
                .map(gen -> UserMapper.INSTANCE.fromDto(gen))
                .collect(Collectors.toList());
                
    }
    

    @Override
    public User findByUsernameAndPassword(String username, String password)  {
        Optional<User> user = repo.findFirstByUsernameAndPassword(username, password).map(UserMapper.INSTANCE::fromDto);
        if (user.isPresent()){
            return user.get();
        } else {
          throw new EntityNotFoundException("User with username " + username + " does not exist!");
        }
    }

    @Override
    public User findByUsername(String username)  {

        Optional<User> user = repo.findFirstByUsername(username).map(UserMapper.INSTANCE::fromDto);
        if (user.isPresent()){
            return user.get();
        } else {
          throw new EntityNotFoundException("User with username " + username + " does not exist!");
        }
    }

    @Override
    public User insert(User user) {
        return UserMapper.INSTANCE.fromDto(
                repo.save(
                        UserMapper.INSTANCE.toDto(user)));
    }


}
