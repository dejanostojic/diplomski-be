/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dostojic.climbers.repository.spring.data.adapter;



import javax.persistence.*;

/**
 *
 * @author Dejan.Ostojic
 */
@Entity
@Table(name = "route")
public class RouteDto {
    
    
    @EmbeddedId
    private RouteCompositeId id;


    @ManyToOne
    @MapsId("competitionId")
    @JoinColumn(name = "competition_id", nullable = false, updatable = false)
    private CompetitionDto competition;

    @Column(insertable = false, updatable = false)
    private Integer ord;

    @Column(name = "name")
    private String name;
    
    @Column(name = "grade")
    private String grade;

    public RouteDto() {
    }

    public RouteDto(RouteCompositeId id, String name, String grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }


    public RouteCompositeId getId() {
        return id;
    }

    public void setId(RouteCompositeId id) {
        this.id = id;
    }
    
    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    @Override
    public String toString() {
        return "RouteDto{" + "id=" + id + ", name=" + ord + ", ord=" + name + ", grade=" + grade + '}';
    }

}
