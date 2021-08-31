/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dostojic.climbers.domain;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author planina
 */
public class Competition implements Serializable {

    private Integer id;
    private String name;
    private String description;
    private Instant registrationOpen;
    private Instant registrationClose;
    private Instant eventStart;
    private List<Route> routes;
    private List<RegistrationFee> registrationFees;
    private List<Registration> registrations;

    public Competition() {
        routes = new ArrayList<>();
        registrationFees = new ArrayList<>();
        registrations = new ArrayList<>();
    }

    public Competition(Integer id, String name, String description, Instant registrationOpen, Instant registrationClose, Instant eventStart, List<Route> routes, List<RegistrationFee> registrationFees, List<Registration> registrations) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.registrationOpen = registrationOpen;
        this.registrationClose = registrationClose;
        this.eventStart = eventStart;
        this.routes = routes;
        this.registrationFees = registrationFees;
        this.registrations = registrations;
    }



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

    public List<Route> getRoutes() {
        return routes;
    }

    public void setRoutes(List<Route> routes) {
        this.routes = routes;
    }

    public List<RegistrationFee> getRegistrationFees() {
        return registrationFees;
    }

    public void setRegistrationFees(List<RegistrationFee> registrationFees) {
        this.registrationFees = registrationFees;
//        for(RegistrationFee fee : registrationFees){
//            fee.setCompetition(this);
//        }
    }

    public List<Registration> getRegistrations() {
        return registrations;
    }

    public void setRegistrations(List<Registration> registrations) {
        this.registrations = registrations;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Competition that = (Competition) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Competition{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", registrationOpen=" + registrationOpen +
                ", registrationClose=" + registrationClose +
                ", eventStart=" + eventStart +
                ", routes=" + routes +
                ", registrationFees=" + registrationFees +
                ", registrations=" + registrations +
                '}';
    }
}
