/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dostojic.climbers.repository.spring.data.adapter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.time.Instant;

/**
 *
 * @author Dejan.Ostojic
 */
@Entity
@Table(name = "registration")
public class RegistrationDto {
    
    @EmbeddedId
    private RegistrationCompositeId id;

    @ManyToOne
    @MapsId("competitionId")
    @JoinColumn(name = "competition_id", nullable = false, updatable = false)
    private CompetitionDto competition;

    @ManyToOne
//    @MapsId("climberId")
    @JoinColumn(name = "climber_id", insertable = false, nullable = false, updatable = false)
    private ClimberDto climber;

    @Column
    Integer startNumber;
    @Column
    Integer totalOrd;
    @Column
    Boolean paid;
    @Column
    Instant createdDate;
    @Column
    Instant paidDate;

    @JoinColumns({@JoinColumn(
            name = "competition_id",
            referencedColumnName = "competition_id", insertable = false, updatable = false),
            @JoinColumn(
                    name = "fee_ord",
                    referencedColumnName = "ord", insertable = false, updatable = false)})
//
    @OneToOne
    RegistrationFeeDto registrationFee;

    public RegistrationDto() {
    }

    public RegistrationCompositeId getId() {
        return id;
    }

    public void setId(RegistrationCompositeId id) {
        this.id = id;
    }

    public Integer getStartNumber() {
        return startNumber;
    }

    public void setStartNumber(Integer startNumber) {
        this.startNumber = startNumber;
    }

    public Integer getTotalOrd() {
        return totalOrd;
    }

    public void setTotalOrd(Integer totalOrd) {
        this.totalOrd = totalOrd;
    }

    public Boolean getPaid() {
        return paid;
    }

    public void setPaid(Boolean paid) {
        this.paid = paid;
    }

    public Instant getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Instant createdDate) {
        this.createdDate = createdDate;
    }

    public Instant getPaidDate() {
        return paidDate;
    }

    public void setPaidDate(Instant paidDate) {
        this.paidDate = paidDate;
    }

    public RegistrationFeeDto getRegistrationFee() {
        return registrationFee;
    }

    public void setRegistrationFee(RegistrationFeeDto registrationFee) {
        this.registrationFee = registrationFee;
    }

    public CompetitionDto getCompetition() {
        return competition;
    }

    public void setCompetition(CompetitionDto competition) {
        this.competition = competition;
    }

    public ClimberDto getClimber() {
        return climber;
    }

    public void setClimber(ClimberDto climber) {
        this.climber = climber;
    }
}
