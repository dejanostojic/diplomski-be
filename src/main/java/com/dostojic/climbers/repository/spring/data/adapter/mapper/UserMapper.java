/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dostojic.climbers.repository.spring.data.adapter.mapper;

import com.dostojic.climbers.domain.User;
import com.dostojic.climbers.repository.spring.data.adapter.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 *
 * @author planina
 */
@Mapper
public interface UserMapper {

    public static com.dostojic.climbers.repository.spring.data.adapter.mapper.UserMapper INSTANCE = Mappers.getMapper(com.dostojic.climbers.repository.spring.data.adapter.mapper.UserMapper.class);

    UserDto toDto(User user);
    User fromDto(UserDto user);
    
}
