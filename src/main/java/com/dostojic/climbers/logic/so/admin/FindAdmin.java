/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dostojic.climbers.logic.so.admin;

import com.dostojic.climbers.domain.Admin;
import com.dostojic.climbers.domain.Climber;
import com.dostojic.climbers.logic.so.template.GeneralSO;
import com.dostojic.climbers.repository.AdminRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author Dejan.Ostojic
 */
@Service
public class FindAdmin extends GeneralSO<Integer, Admin> {

    private final AdminRepository adminRepository;
    
    public FindAdmin(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }


    @Override
    protected Admin executeOperation(Integer id)  {
        return adminRepository.findById(id);
    }

}
    