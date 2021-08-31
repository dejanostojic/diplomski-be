/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dostojic.climbers.repository.spring.data.adapter;

import com.dostojic.climbers.repository.spring.data.adapter.RegistrationFeeDto;
import com.dostojic.climbers.repository.spring.data.adapter.RouteDto;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Dejan.Ostojic
 */
@Entity
@Table(name = "competition")
public class CompetitionDto implements Serializable {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY,
            generator = "native"
    )
    private Integer id;
    
    @Column(name = "competition_name")
    private String name;
    
    @Column(name = "description")
    private String description;
    
    @Column(name = "registration_open")
    private Instant registrationOpen;
    
    @Column(name = "registration_close")
    private Instant registrationClose;
    
    @Column(name = "max_number_of_registrations")
    private Integer maxNumberOfRegistrations;

    @Column(name = "event_start_date")
    private Instant eventStart;

    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="competition", orphanRemoval = true)
    private List<RouteDto> routes;

//    @OneToMany(cascade={CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE}, fetch=FetchType.LAZY, mappedBy="competition", orphanRemoval = true)
    @OneToMany(cascade={CascadeType.ALL}, fetch=FetchType.LAZY, mappedBy="competition", orphanRemoval = true)
    private List<RegistrationFeeDto> registrationFees;

    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="competition", orphanRemoval = true)
    private List<RegistrationDto> registrations;

    public CompetitionDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Instant getEventStart() {
        return eventStart;
    }

    public void setEventStart(Instant eventStart) {
        this.eventStart = eventStart;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public List<RouteDto> getRoutes() {
        return routes;
    }

    public void setRoutes(List<RouteDto> routes) {
        if (this.routes != null){
            this.routes.clear();
        } else {
            this.routes = new ArrayList<>();
        }
        for (RouteDto route: routes){
            this.routes.add(route);
            route.setCompetition(this);
        }
        this.routes = routes;
    }

    public List<RegistrationFeeDto> getRegistrationFees() {
        return registrationFees;
    }

    public void setRegistrationFees(List<RegistrationFeeDto> registrationFees) {
//        this.registrationFees = registrationFees;
        if (this.registrationFees != null){
            this.registrationFees.clear();
        } else {
            this.registrationFees = new ArrayList<>();
        }
        for (RegistrationFeeDto fee: registrationFees){
            this.registrationFees.add(fee);
            fee.setCompetition(this);
        }
//
//        if (registrationFees != null) {
//            this.registrationFees.addAll(registrationFees);
//        }
    }

    public List<RegistrationDto> getRegistrations() {
        return registrations;
    }

    public void setRegistrations(List<RegistrationDto> registrations) {
        this.registrations = registrations;
    }

    public Integer getMaxNumberOfRegistrations() {
        return maxNumberOfRegistrations;
    }

    public void setMaxNumberOfRegistrations(Integer maxNumberOfRegistrations) {
        this.maxNumberOfRegistrations = maxNumberOfRegistrations;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompetitionDto that = (CompetitionDto) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Competition{" + "id=" + id + ", description=" + description + ", registrationOpen=" + registrationOpen + ", registrationClose=" + registrationClose + ", eventStart=" + eventStart + '}';
    }
}
