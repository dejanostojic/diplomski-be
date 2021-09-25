/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dostojic.climbers.logic.so.template;

import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Dejan.Ostojic
 */
public abstract class GeneralSO<DomainObjectIn, DomainObjectOut> {


    @Transactional
    public DomainObjectOut execute(DomainObjectIn domainObject) {
        // todo: check transactional works in superclass
        checkPrecondition(domainObject);
        return executeOperation(domainObject);
    }

    protected void checkPrecondition(DomainObjectIn domainObject){};

    protected abstract DomainObjectOut executeOperation(DomainObjectIn domainObject);
}
