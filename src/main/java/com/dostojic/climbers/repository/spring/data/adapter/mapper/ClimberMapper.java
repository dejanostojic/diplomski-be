/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dostojic.climbers.repository.spring.data.adapter.mapper;

import com.dostojic.climbers.domain.Climber;
import com.dostojic.climbers.repository.spring.data.adapter.ClimberDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.Collection;
import java.util.List;

/**
 *
 * @author planina
 */
@Mapper
public interface ClimberMapper {
    
    public static ClimberMapper INSTANCE = Mappers.getMapper(ClimberMapper.class);

    ClimberDto toDto(Climber climber);
    List<ClimberDto> toDto(Collection<Climber> climberList);
    
    Climber fromDto(ClimberDto climber);
    List<Climber> fromDto(Collection<ClimberDto> climberList);
    
    
}
