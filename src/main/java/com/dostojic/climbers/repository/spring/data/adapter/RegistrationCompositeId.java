/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dostojic.climbers.repository.spring.data.adapter;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Dejan.Ostojic
 */
@Embeddable
public class RegistrationCompositeId implements Serializable {

    @Column(name = "competition_id", nullable = false)
    private Integer competitionId;

    @Column(name = "climber_id")
    private Integer climberId;

    public RegistrationCompositeId() {
    }

    public RegistrationCompositeId(Integer competitionId, Integer climberId) {
        this.competitionId = competitionId;
        this.climberId = climberId;
    }

    public Integer getCompetitionId() {
        return competitionId;
    }

    public void setCompetitionId(Integer competitionId) {
        this.competitionId = competitionId;
    }

    public Integer getClimberId() {
        return climberId;
    }

    public void setClimberId(Integer climberId) {
        this.climberId = climberId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RegistrationCompositeId that = (RegistrationCompositeId) o;
        return Objects.equals(competitionId, that.competitionId) &&
                Objects.equals(climberId, that.climberId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(competitionId, climberId);
    }
}
