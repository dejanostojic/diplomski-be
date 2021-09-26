/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dostojic.climbers.logic.so.admin;

import com.dostojic.climbers.logic.so.template.GeneralSO;
import com.dostojic.climbers.repository.AdminRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author Dejan.Ostojic
 */
@Service
public class DeleteAdmin extends GeneralSO<Long, Boolean> {

    private final AdminRepository adminRepository;

    public DeleteAdmin(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @Override
    protected void checkPrecondition(Long adminId) {
        System.out.println("No preconditions DeleteClimberSO");
    }

    @Override
    protected Boolean executeOperation(Long adminId) {
        adminRepository.deleteById(adminId);
        System.out.println("TODO: return boolean if climber deleted!");
        return null;
    }

}
