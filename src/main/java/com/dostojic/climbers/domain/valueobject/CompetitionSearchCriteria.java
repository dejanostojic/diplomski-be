/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dostojic.climbers.domain.valueobject;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

/**
 *
 * @author Dejan.Ostojic
 */
public class CompetitionSearchCriteria {
    
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    // todo externalize paging and sorting!

    // todo export to separate value object
    @NotNull(message = "page number is required")
    @PositiveOrZero(message = "page number must be positive or zero")
    private int pageNumber;

    @NotNull
    @PositiveOrZero
    private int pageSize;

    private String sortCol;
    private SortOrd sortOrd;

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



    public enum SortOrd{
        Asc, Desc;

        public boolean isAsc(){
            return this == Asc;
        }
    }
}
