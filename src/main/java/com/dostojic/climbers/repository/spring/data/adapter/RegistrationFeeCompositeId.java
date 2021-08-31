/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dostojic.climbers.repository.spring.data.adapter;


import com.dostojic.climbers.domain.Competition;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Dejan.Ostojic
 */
@Embeddable
public class RegistrationFeeCompositeId implements Serializable {


    @Column(name = "competition_id", nullable = false)
    private Integer competitionId;

    @Column(name = "ord")
    private Integer ord;

    public RegistrationFeeCompositeId() {
    }

    public RegistrationFeeCompositeId(Integer competitionId, Integer ord) {
        this.competitionId = competitionId;
        this.ord = ord;
    }

    public Integer getCompetitionId() {
        return competitionId;
    }

    public void setCompetitionId(Integer competitionId) {
        this.competitionId = competitionId;
    }

    public Integer getOrd() {
        return ord;
    }

    public void setOrd(Integer ord) {
        this.ord = ord;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RegistrationFeeCompositeId that = (RegistrationFeeCompositeId) o;
        return Objects.equals(competitionId, that.competitionId) &&
                Objects.equals(ord, that.ord);
    }

    @Override
    public int hashCode() {
        return Objects.hash(competitionId, ord);
    }
}
