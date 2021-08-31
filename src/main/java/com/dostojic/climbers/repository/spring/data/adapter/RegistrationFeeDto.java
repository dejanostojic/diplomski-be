/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dostojic.climbers.repository.spring.data.adapter;


import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;

/**
 *
 * @author Dejan.Ostojic
 */
@Entity
@Table(name = "registration_fee")
public class RegistrationFeeDto implements Serializable {
    
    @EmbeddedId
    private RegistrationFeeCompositeId id;

    @ManyToOne
    @MapsId("competitionId")
    @JoinColumn(name = "competition_id", nullable = false, updatable = false)
    private CompetitionDto competition;

//    @Id
    @Column(insertable = false, updatable = false)
//    @MapsId("ord")
    private Integer ord;

    @Column(name = "name")
    private String name;

    @Column(name = "amount")
    private BigDecimal amount;

    @Column(name = "start_date")
    private Instant startDate;

    @Column(name = "end_date")
    private Instant endDate;

    public RegistrationFeeDto() {
    }

    public RegistrationFeeCompositeId getId() {
        return id;
    }

    public void setId(RegistrationFeeCompositeId id) {
        this.id = id;
    }


    public Integer getOrd() {
        return ord;
    }

    public void setOrd(Integer ord) {
        this.ord = ord;
    }

    public CompetitionDto getCompetition() {
        return competition;
    }

    public void setCompetition(CompetitionDto competition) {
        this.competition = competition;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Instant getStartDate() {
        return startDate;
    }

    public void setStartDate(Instant startDate) {
        this.startDate = startDate;
    }

    public Instant getEndDate() {
        return endDate;
    }

    public void setEndDate(Instant endDate) {
        this.endDate = endDate;
    }
    
    

}
