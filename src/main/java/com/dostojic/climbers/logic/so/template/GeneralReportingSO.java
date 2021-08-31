/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dostojic.climbers.logic.so.template;

import com.dostojic.climbers.logic.so.template.GeneralSO;
import com.dostojic.climbers.logic.TransactionManager;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Dejan.Ostojic
 * @param <InputParam>
 * @param <OperationResult>
 */
public abstract class GeneralReportingSO<InputParam, OperationResult>  implements GeneralSO<InputParam, OperationResult> {


    @Transactional
    public OperationResult execute(InputParam domainObject) {
        return executeOperation(domainObject);
    }


    protected abstract OperationResult executeOperation(InputParam domainObject) ;
}
