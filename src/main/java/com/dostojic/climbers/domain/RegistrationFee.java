/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dostojic.climbers.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.Objects;

/**
 *
 * @author planina
 */
public class RegistrationFee implements Serializable {

    private Competition competition;
    private Integer ord;
    private String name;
    private BigDecimal amount;
    private Instant startDate;
    private Instant endDate;

    public RegistrationFee() {
    }

    public RegistrationFee(Competition competition, Integer ord, String name, BigDecimal amount, Instant startDate, Instant endDate) {
        this.competition = competition;
        this.ord = ord;
        this.name = name;
        this.amount = amount;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Competition getCompetition() {
        return competition;
    }

    public void setCompetition(Competition competition) {
        this.competition = competition;
    }

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

    @Override
    public int hashCode() {
        int hash = 7;
//        hash = 83 * hash + Objects.hashCode(this.competition);
        hash = 83 * hash + Objects.hashCode(this.ord);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final RegistrationFee other = (RegistrationFee) obj;
//        if (!Objects.equals(this.competition, other.competition)) {
//            return false;
//        }
        if (!Objects.equals(this.ord, other.ord)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "RegistrationFee{"  + "ord=" + ord + ", name=" + name + ", amount=" + amount + ", startDate=" + startDate + ", endDate=" + endDate + '}';
    }

}
