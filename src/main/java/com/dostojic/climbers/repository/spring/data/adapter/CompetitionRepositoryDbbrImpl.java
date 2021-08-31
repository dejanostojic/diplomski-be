/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dostojic.climbers.repository.spring.data.adapter;

import com.dostojic.climbers.dbbr.improved.DbBroker;
import com.dostojic.climbers.dbbr.improved.QueryUtils;
import com.dostojic.climbers.domain.Climber;
import com.dostojic.climbers.domain.Competition;
import com.dostojic.climbers.domain.valueobject.ClimberSearchCriteria;
import com.dostojic.climbers.domain.valueobject.CompetitionSearchCriteria;
import com.dostojic.climbers.exception.EntityNotFoundException;
import com.dostojic.climbers.logging.Loggable;
import com.dostojic.climbers.repository.CompetitionRepository;
import com.dostojic.climbers.repository.spring.data.adapter.mapper.CompetitionMapper;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.Expressions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Dejan.Ostojic
 */
@Component // TODO REFACTOR TO JPA IMPL
public class CompetitionRepositoryDbbrImpl implements CompetitionRepository {

    @Autowired
    JpaCompetitionRepository repo;

//    DbBroker<RouteDto, RouteCompositeId> routeDbbr;
//    DbBroker<RegistrationFeeDto, RegistrationFeeCompositeId> registrationFeeDbbr;
//    DbBroker<RegistrationDto, RegistrationCompositeId> registrationDbbr;

    public CompetitionRepositoryDbbrImpl() {
    }

    private Predicate getPredicate(CompetitionSearchCriteria searchCriteria) {
        BooleanBuilder bb = new BooleanBuilder();

        bb .and(Expressions.asBoolean(true).isTrue());

        System.out.println("Got pred new ");
        if (searchCriteria.getName() != null && !searchCriteria.getName().isEmpty()){
            System.out.println("aaaaa");
            bb.and(QCompetitionDto.competitionDto.name.startsWithIgnoreCase(searchCriteria.getName()));
            System.out.println("set it now");
        }


        System.out.println("pred val: " + bb.getValue());

        return bb.getValue();
    }
    
    @Override
    @Loggable
    public Competition insert(Competition competition) {
        CompetitionDto competitionDto = CompetitionMapper.INSTANCE.toDto(competition);

        CompetitionDto insert = repo.save(competitionDto);

        return CompetitionMapper.INSTANCE.fromDto(insert);
    }

    @Override
    public Competition update(Competition competition) {
        // TODO FIX CODE DUPLICATION!!!

        CompetitionDto competitionDto = CompetitionMapper.INSTANCE.toDto(competition);
        CompetitionDto savedComp = repo.save(competitionDto);

        return CompetitionMapper.INSTANCE.fromDto(savedComp) ;
//        if (!updated){
//            throw new Exception("Competition that should be updated not found!"); // TODO: Throw proper bussines exception!
//        }

//        return competition;
    }

    @Override
    public Page<Competition> searchCompetitions(CompetitionSearchCriteria searchCriteria) {
        StringBuilder where = new StringBuilder("true");
        
       if (searchCriteria.getName() != null && !searchCriteria.getName().isEmpty()){
           where.append(" and name like").append(QueryUtils.mySqlLikeLiteral(searchCriteria.getName()));
        }

        Sort order = Sort.unsorted();

        if (searchCriteria.getSortOrd() != null && searchCriteria.getSortCol() != null){
            order.and(searchCriteria.getSortOrd().isAsc() ?
                    Sort.by(searchCriteria.getSortCol()).ascending() :
                    Sort.by(searchCriteria.getSortCol()).descending());
        }


        Pageable pageable = PageRequest.of(searchCriteria.getPageNumber(), searchCriteria.getPageSize(), order);

        System.out.println("PAGEABLE heeuy: " + pageable);
        Predicate predicate = getPredicate(searchCriteria);
//            System.out.println("got predicate: " + predicate);
        Page<Competition> result = repo.findAll(predicate, pageable).map(dto -> CompetitionMapper.INSTANCE.fromDto(dto));
        System.out.println("results: " + result);
        return result;
    }

    @Override
    public Competition findById(Integer id) {
        Optional<CompetitionDto> optById = repo.findById(id);
        Optional<Competition> competition = optById.map(CompetitionMapper.INSTANCE::fromDto);
        if (competition.isPresent()){
            return competition.get();
        }
        throw new EntityNotFoundException("Comp not found!");
    }
    
    
}
