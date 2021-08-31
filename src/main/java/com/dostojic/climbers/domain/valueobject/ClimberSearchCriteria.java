/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dostojic.climbers.domain.valueobject;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

/**
 *
 * @author Dejan.Ostojic
 */
public class ClimberSearchCriteria {

    private String firstName;
    private String lastName;
    private Integer yearOfBirth;

    // todo export to separate value object
    @NotNull(message = "page number is required")
    @PositiveOrZero(message = "page number must be positive or zero")
    private int pageNumber;

    @NotNull
    @PositiveOrZero
    private int pageSize;

    private String sortCol;
    private SortOrd sortOrd;

    public ClimberSearchCriteria() {
    }

    public ClimberSearchCriteria(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public ClimberSearchCriteria(String firstName, String lastName, Integer yearOfBirth, @NotNull(message = "page number is required") @PositiveOrZero(message = "page number must be positive or zero") int pageNumber, @NotNull @PositiveOrZero int pageSize, String sortCol, SortOrd sortOrd) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.yearOfBirth = yearOfBirth;
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
        this.sortCol = sortCol;
        this.sortOrd = sortOrd;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getSortCol() {
        return sortCol;
    }

    public void setSortCol(String sortCol) {
        this.sortCol = sortCol;
    }

    public SortOrd getSortOrd() {
        return sortOrd;
    }

    public void setSortOrd(SortOrd sortOrd) {
        this.sortOrd = sortOrd;
    }

    public Integer getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(Integer yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    @Override
    public String toString() {
        return "ClimberSearchCriteria{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", pageNumber=" + pageNumber +
                ", yearOfBirth=" + yearOfBirth +
                ", pageSize=" + pageSize +
                ", sortCol='" + sortCol + '\'' +
                ", sortOrd='" + sortOrd + '\'' +
                '}';
    }

    public enum SortOrd{
        Asc, Desc;

        public boolean isAsc(){
            return this == Asc;
        }
    }
}
