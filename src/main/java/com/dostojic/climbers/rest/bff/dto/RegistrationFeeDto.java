/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dostojic.climbers.rest.bff.dto;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.Date;

import static com.dostojic.climbers.rest.bff.config.RestConfig.DATE_PATTERN;

/**
 *
 * @author Dejan.Ostojic
 */
public class RegistrationFeeDto implements Serializable {
    @Positive
    private Integer ord;
    @NotBlank
    private String name;
    @PositiveOrZero
    private BigDecimal amount;
    @DateTimeFormat(pattern = DATE_PATTERN)
    @NotNull
    private Instant startDate;
    @DateTimeFormat(pattern = DATE_PATTERN)
    @NotNull
    private Instant endDate;

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
    public String toString() {
        return "RegistrationFeeDto{" + "ord=" + ord + ", name=" + name + ", amount=" + amount + ", startDate=" + startDate + ", endDate=" + endDate + '}';
    }
    
    
}
