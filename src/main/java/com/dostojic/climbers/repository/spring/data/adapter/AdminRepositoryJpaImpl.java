/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dostojic.climbers.repository.spring.data.adapter;

import com.dostojic.climbers.domain.Admin;
import com.dostojic.climbers.domain.valueobject.AdminSearchCriteria;
import com.dostojic.climbers.exception.EntityNotFoundException;
import com.dostojic.climbers.repository.AdminRepository;
import com.dostojic.climbers.repository.spring.data.adapter.mapper.AdminMapper;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.Expressions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 *
 * @author planina
 */
@Component // TODO REFACTOR TO JPA IMPL
public class AdminRepositoryJpaImpl implements AdminRepository {

    @Autowired
    private JpaAdminRepository repo;

    private final AdminMapper mapper = AdminMapper.INSTANCE;

    @Override
    public Admin findByUsernameAndPassword(String username, String password)  {
        Optional<Admin> user = repo.findFirstByUsernameAndPassword(username, password).map(
            AdminMapper.INSTANCE::fromDto);
        if (user.isPresent()){
            return user.get();
        } else {
          throw new EntityNotFoundException("User with username " + username + " does not exist!");
        }
    }

    @Override
    public Admin findByUsername(String username)  {

        Optional<Admin> user = repo.findFirstByUsername(username).map(AdminMapper.INSTANCE::fromDto);
        if (user.isPresent()){
            return user.get();
        } else {
          throw new EntityNotFoundException("User with username " + username + " does not exist!");
        }
    }

    @Override
    public Admin insert(Admin admin) {
        return AdminMapper.INSTANCE.fromDto(
                repo.save(
                        AdminMapper.INSTANCE.toDto(admin)));
    }

    @Override
    public void deleteById(Long id) {
        repo.deleteById(id);
    }

    @Override
    public void delete(Admin admin) {
        repo.delete(mapper.toDto(admin));
    }

    @Override
    public boolean update(Admin admin) {
        repo.save(mapper.toDto(admin));
        return false;
    }

    @Override
    public Admin findById(Long adminId) {
        Optional<AdminDto> optAdmin = repo.findById(adminId);
        if (optAdmin.isPresent()) {
            return mapper.fromDto(optAdmin.get());

        }
        throw new EntityNotFoundException("Admin not found with id: " + adminId);
    }

    @Override
    public Page<Admin> searchAdmins(AdminSearchCriteria searchCriteria) {
        Sort order = Sort.unsorted();

        if (searchCriteria.getSortOrd() != null && searchCriteria.getSortCol() != null) {
            order.and(searchCriteria.getSortOrd().isAsc() ?
                Sort.by(searchCriteria.getSortCol()).ascending() :
                Sort.by(searchCriteria.getSortCol()).descending());
        }

        Pageable pageable = PageRequest.of(searchCriteria.getPageNumber(), searchCriteria.getPageSize(),
            order);

        Predicate predicate = getPredicate(searchCriteria);
        Page<Admin> result = repo.findAll(predicate, pageable).map(dto -> mapper.fromDto(dto));
        System.out.println("results: " + result);

        return result;
    }


    private Predicate getPredicate(AdminSearchCriteria searchCriteria) {
        BooleanBuilder bb = new BooleanBuilder();

        bb.and(Expressions.asBoolean(true).isTrue());

        System.out.println("Got pred new ");
        if (searchCriteria.getFirstName() != null && !searchCriteria.getFirstName().isEmpty()) {
            System.out.println("aaaaa");
            bb.and(QAdminDto.adminDto.firstName.startsWithIgnoreCase(searchCriteria.getFirstName()));
            System.out.println("set it now");
        }
        if (searchCriteria.getLastName() != null && !searchCriteria.getLastName().isEmpty()) {
            System.out.println("last name!!!");
            bb.and(QAdminDto.adminDto.lastName.startsWithIgnoreCase(searchCriteria.getLastName()));
            System.out.println("gout it last name");
        }

        System.out.println("pred val: " + bb.getValue());

        return bb.getValue();
    }



}
