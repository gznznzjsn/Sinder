package com.solvd.laba.sinder.web.dto.mapper;

import com.solvd.laba.sinder.domain.Party;
import com.solvd.laba.sinder.web.dto.PartyDto;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

@Mapper(componentModel = "spring", uses = {UserMapper.class, PointMapper.class})
public interface PartyMapper {

    Party toEntity(PartyDto dto);

    PartyDto toDto(Party entity);

    Page<Party> toEntity(Page<PartyDto> dto);

    Page<PartyDto> toDto(Page<Party> entity);

}
