package com.solvd.laba.sinder.web.dto.mapper;

import com.solvd.laba.sinder.domain.pairs.PairPreference;
import com.solvd.laba.sinder.domain.parties.PartyPreference;
import com.solvd.laba.sinder.web.dto.PairPreferenceDto;
import com.solvd.laba.sinder.web.dto.PartyPreferenceDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PartyPreferenceMapper {

    PartyPreference toEntity(PartyPreferenceDto dto);

    PairPreferenceDto toDto(PairPreference entity);

}
