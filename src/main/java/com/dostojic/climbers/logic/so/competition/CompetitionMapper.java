package com.dostojic.climbers.logic.so.competition;

import com.dostojic.climbers.domain.Registration;
import com.dostojic.climbers.domain.RegistrationFee;
import com.dostojic.climbers.domain.Route;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CompetitionMapper {

    public static CompetitionMapper INSTANCE = Mappers.getMapper(CompetitionMapper.class);

    void update(Route source, @MappingTarget Route target);

    @Mapping( target = "competition", ignore = true)
    void update(RegistrationFee source, @MappingTarget RegistrationFee target);

    void update(Registration source, @MappingTarget Registration target);
}
