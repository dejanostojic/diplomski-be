/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dostojic.climbers.repository.spring.data.adapter;

import com.dostojic.climbers.dbbr.improved.DbBroker;
import com.dostojic.climbers.domain.RegistrationFee;
import com.dostojic.climbers.repository.RegistrationFeeRepository;
import com.dostojic.climbers.repository.spring.data.adapter.RegistrationFeeCompositeId;
import com.dostojic.climbers.repository.spring.data.adapter.RegistrationFeeDto;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 *
 * @author Dejan.Ostojic
 */
@Component // TODO REFACTOR TO JPA IMPL
public class RegistrationFeeRepositoryDbbrImpl implements RegistrationFeeRepository {

    @Override
    public RegistrationFee insert(RegistrationFee registrationFee)  {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public RegistrationFee update(RegistrationFee registrationFee)  {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(RegistrationFee registrationFee)  {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<RegistrationFee> findByCompetitionId(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
