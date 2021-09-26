/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dostojic.climbers.logic.so.admin;

import com.dostojic.climbers.domain.Admin;
import com.dostojic.climbers.logic.so.admin.validator.AdminValidator;
import com.dostojic.climbers.logic.so.template.GeneralSO;
import com.dostojic.climbers.repository.AdminRepository;
import com.dostojic.climbers.rest.bff.config.ClimberException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

/**
 *
 * @author Dejan.Ostojic
 */
@Service
public class UpdateAdmin extends GeneralSO<Admin, Boolean> {

    private final AdminRepository adminRepository;
    private final AdminValidator adminValidator;

    public UpdateAdmin(AdminRepository AdminRepository, AdminValidator adminValidator) {
        this.adminRepository = AdminRepository;
        this.adminValidator = adminValidator;
    }

    @Override
    protected void checkPrecondition(Admin admin) {
        adminValidator.validate(admin);
    }

    @Override
    protected Boolean executeOperation(Admin admin) {
        Admin existing = adminRepository.findById(admin.getId());
        if (existing == null){
            throw new ClimberException(HttpStatus.BAD_REQUEST, "Admin not found");
        }

        System.out.println("DEBUG: Updating admin: " + admin);
        return adminRepository.update(admin);
    }

}
