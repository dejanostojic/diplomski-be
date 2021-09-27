package com.dostojic.climbers.domain.valueobject;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

public class AdminSearchCriteria {

  private String firstName;
  private String lastName;
  private String username;


  // todo export to separate value object
  @NotNull(message = "page number is required")
  @PositiveOrZero(message = "page number must be positive or zero")
  private int pageNumber;

  @NotNull
  @PositiveOrZero
  private int pageSize;

  private String sortCol;
  private SortOrd sortOrd;


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

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
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

  @Override
  public String toString() {
    return "AdminSearchCriteria{" +
        "firstName='" + firstName + '\'' +
        ", lastName='" + lastName + '\'' +
        ", pageNumber=" + pageNumber +
        ", pageSize=" + pageSize +
        ", sortCol='" + sortCol + '\'' +
        ", sortOrd='" + sortOrd + '\'' +
        '}';
  }

  public enum SortOrd {
    Asc, Desc;

    public boolean isAsc() {
      return this == Asc;
    }
  }

}
