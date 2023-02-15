package com.solvd.laba.sinder.web.dto.mapper;

import com.solvd.laba.sinder.domain.pairs.PairMatch;
import com.solvd.laba.sinder.web.dto.PairMatchDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {UserMapper.class})
public interface PairMatchMapper {

    PairMatch toEntity(PairMatchDto dto);

    PairMatchDto toDto(PairMatch entity);

}
