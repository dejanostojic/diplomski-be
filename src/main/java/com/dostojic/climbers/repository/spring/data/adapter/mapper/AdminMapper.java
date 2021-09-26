/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dostojic.climbers.repository.spring.data.adapter.mapper;

import com.dostojic.climbers.domain.Admin;
import com.dostojic.climbers.repository.spring.data.adapter.AdminDto;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 *
 * @author planina
 */
@Mapper
public interface AdminMapper {

    public static AdminMapper INSTANCE = Mappers.getMapper(AdminMapper.class);

    AdminDto toDto(Admin admin);
    List<AdminDto> toDto(List<Admin> admin);

    Admin fromDto(AdminDto user);
    List<Admin> fromDto(List<AdminDto> user);

}
