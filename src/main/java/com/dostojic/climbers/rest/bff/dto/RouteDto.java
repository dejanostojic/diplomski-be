/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dostojic.climbers.rest.bff.dto;

import javax.validation.constraints.Positive;
import java.io.Serializable;

/**
 *
 * @author Dejan.Ostojic
 */
public class RouteDto implements Serializable{
    @Positive
    private Integer ord;
    private String name;
    private String grade;

    public Integer getOrd() {
        return ord;
    }

    public void setOrd(Integer ord) {
        this.ord = ord;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "RouteDto{" + "ord=" + ord + ", name=" + name + ", grade=" + grade + '}';
    }

    
}
