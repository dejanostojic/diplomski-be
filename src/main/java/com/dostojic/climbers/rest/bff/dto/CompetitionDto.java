/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dostojic.climbers.rest.bff.dto;

import com.dostojic.climbers.rest.bff.dto.RegistrationFeeDto;
import com.dostojic.climbers.rest.bff.dto.RouteDto;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.io.Serializable;
import java.time.Instant;
import java.util.Date;
import java.util.List;

import static com.dostojic.climbers.rest.bff.config.RestConfig.DATE_PATTERN;

/**
 *
 * @author Dejan.Ostojic
 */

public class CompetitionDto implements Serializable{

    @Positive
    private Integer id;
    @NotBlank
    private String name;
    private String description;
    @DateTimeFormat(pattern = DATE_PATTERN)
    private Instant registrationOpen;
    @DateTimeFormat(pattern = DATE_PATTERN)
    private Instant registrationClose;
    @DateTimeFormat(pattern = DATE_PATTERN)
    private Instant eventStart;
    @NotNull(message = "Routes must not be null. Empty list is allowed.")
    @Valid
    private List<RouteDto> routes;
    @NotNull(message = "Fees must not be null. Empty list is allowed.")
    @Valid
    private List<RegistrationFeeDto> registrationFees;
    @NotNull(message = "Fees must not be null. Empty list is allowed.")
    @Valid
    private List<RegistrationDto> registrations;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Instant getRegistrationOpen() {
        return registrationOpen;
    }

    public void setRegistrationOpen(Instant registrationOpen) {
        this.registrationOpen = registrationOpen;
    }

    public Instant getRegistrationClose() {
        return registrationClose;
    }

    public void setRegistrationClose(Instant registrationClose) {
        this.registrationClose = registrationClose;
    }

    public Instant getEventStart() {
        return eventStart;
    }

    public void setEventStart(Instant eventStart) {
        this.eventStart = eventStart;
    }

    public List<RouteDto> getRoutes() {
        return routes;
    }

    public void setRoutes(List<RouteDto> routes) {
        this.routes = routes;
    }

    public List<RegistrationFeeDto> getRegistrationFees() {
        return registrationFees;
    }

    public void setRegistrationFees(List<RegistrationFeeDto> registrationFees) {
        this.registrationFees = registrationFees;
    }

    public List<RegistrationDto> getRegistrations() {
        return registrations;
    }

    public void setRegistrations(List<RegistrationDto> registrations) {
        this.registrations = registrations;
    }

    @Override
    public String toString() {
        return "CompetitionDto{" + "id=" + id + ", name=" + name + ", description=" + description + ", registrationOpen=" + registrationOpen + ", registrationClose=" + registrationClose + ", eventStart=" + eventStart + ", routes=" + routes + ", registrationFees=" + registrationFees + '}';
    }

}
