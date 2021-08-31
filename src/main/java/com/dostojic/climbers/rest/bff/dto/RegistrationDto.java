package com.dostojic.climbers.rest.bff.dto;

import java.time.Instant;

public class RegistrationDto {
    ClimberDto climber;
    Integer startNumber;
    Integer totalOrd;
    Boolean paid;
    Instant createdDate;
    Instant paidDate;
    RegistrationFeeDto registrationFee;
//    List<RouteClimbedDto> climbedRoutes;


    public ClimberDto getClimber() {
        return climber;
    }

    public void setClimber(ClimberDto climber) {
        this.climber = climber;
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


}
