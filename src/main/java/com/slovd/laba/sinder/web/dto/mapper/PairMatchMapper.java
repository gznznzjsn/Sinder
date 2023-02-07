package com.slovd.laba.sinder.web.dto.mapper;

import com.slovd.laba.sinder.domain.PairMatch;
import com.slovd.laba.sinder.web.dto.PairMatchDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {UserMapper.class})
public interface PairMatchMapper {

    PairMatch toEntity(PairMatchDto dto);

    PairMatchDto toDto(PairMatch entity);

}
