/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dostojic.climbers.rest.bff.dto;

import java.io.Serializable;

/**
 *
 * @author Dejan.Ostojic
 */
public class ClimberSearchCriteriaDto implements Serializable{
    String firstName;
    String lastName;

    public ClimberSearchCriteriaDto() {
    }

    public ClimberSearchCriteriaDto(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "ClimberSearchCriteriaDto{" + "firstName=" + firstName + ", lastName=" + lastName + '}';
    }
    
    
}
