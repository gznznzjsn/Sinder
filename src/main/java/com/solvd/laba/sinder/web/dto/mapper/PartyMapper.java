package com.solvd.laba.sinder.web.dto.mapper;

import com.solvd.laba.sinder.domain.Party;
import com.solvd.laba.sinder.web.dto.PartyDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {UserMapper.class, PointMapper.class})
public interface PartyMapper {

    Party toEntity(PartyDto dto);

    PartyDto toDto(Party entity);

    List<Party> toEntity(List<PartyDto> dto);

    List<PartyDto> toDto(List<Party> entity);

}
