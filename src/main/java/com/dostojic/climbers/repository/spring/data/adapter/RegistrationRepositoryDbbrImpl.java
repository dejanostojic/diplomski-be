/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dostojic.climbers.repository.spring.data.adapter;

import com.dostojic.climbers.domain.Registration;
import com.dostojic.climbers.repository.RegistrationRepository;
import com.dostojic.climbers.repository.spring.data.adapter.RegistrationCompositeId;
import com.dostojic.climbers.repository.spring.data.adapter.RegistrationDto;
import com.dostojic.climbers.repository.spring.data.adapter.mapper.CompetitionMapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 *
 * @author Dejan.Ostojic
 */
@Component // TODO REFACTOR TO JPA IMPL
public class RegistrationRepositoryDbbrImpl implements RegistrationRepository {

    JpaRegistrationRepository jpaRegistrationRepository;

    @Override
    public Registration insert(Registration registration)  {
        RegistrationDto registrationDto = CompetitionMapper.INSTANCE.toDto(registration);
        System.out.println("Registration dto to insert: " + registrationDto);
        RegistrationDto inserted = jpaRegistrationRepository.save(registrationDto);

        return CompetitionMapper.INSTANCE.fromDto(inserted);
    }

    @Override
    public Registration update(Registration registration)  {
        RegistrationDto registrationDto = CompetitionMapper.INSTANCE.toDto(registration);
        System.out.println("REGISTRATION DTO update: " + registrationDto);
        jpaRegistrationRepository.save(registrationDto);

        return registration;
    }

    @Override
    public void delete(Registration registration)  {
        RegistrationDto registrationDto = CompetitionMapper.INSTANCE.toDto(registration);
        System.out.println("Resgistration DTO: " + registrationDto);
        jpaRegistrationRepository.delete(registrationDto);

    }

    @Override
    public List<Registration> findByCompetitionId(Integer id)  {
        throw new RuntimeException("NOT USED ANYMORE!");
//        return CompetitionMapper.INSTANCE.toRegistrations(jpaRegistrationRepository.findRegistrationsByIdCompetitionId( id));
    }

}
