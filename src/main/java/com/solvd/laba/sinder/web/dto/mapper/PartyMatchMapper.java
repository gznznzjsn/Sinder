package com.solvd.laba.sinder.web.dto.mapper;

import com.solvd.laba.sinder.domain.partymatch.PartyMatch;
import com.solvd.laba.sinder.web.dto.PartyMatchDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {UserMapper.class, PartyMapper.class})
public interface PartyMatchMapper {

    PartyMatch toEntity(PartyMatchDto dto);

    PartyMatchDto toDto(PartyMatch entity);

}
