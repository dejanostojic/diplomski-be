/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dostojic.climbers.logic.so.admin;

import com.dostojic.climbers.domain.Admin;
import com.dostojic.climbers.domain.valueobject.AdminSearchCriteria;
import com.dostojic.climbers.logic.so.template.GeneralSO;
import com.dostojic.climbers.repository.AdminRepository;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

/**
 *
 * @author Dejan.Ostojic
 */
@Service
public class SearchAdmins extends GeneralSO<AdminSearchCriteria, Page<Admin>> {
    private AdminRepository adminRepository;
    
    public SearchAdmins(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }


    @Override
    protected Page<Admin> executeOperation(AdminSearchCriteria searchCriteria)  {
        return adminRepository.searchAdmins(searchCriteria);
    }
    
}
