package com.slovd.laba.sinder.web.dto.mapper;

import com.slovd.laba.sinder.domain.Party;
import com.slovd.laba.sinder.web.dto.PartyDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {UserMapper.class, PointMapper.class})
public interface PartyMapper {

    Party toEntity(PartyDto dto);

    PartyDto toDto(Party entity);

}
