package com.solvd.laba.sinder.web.dto.mapper;

import com.solvd.laba.sinder.domain.user.PairPreference;
import com.solvd.laba.sinder.domain.user.PartyPreference;
import com.solvd.laba.sinder.web.dto.PairPreferenceDto;
import com.solvd.laba.sinder.web.dto.PartyPreferenceDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PartyPreferenceMapper {

    PartyPreference toEntity(PartyPreferenceDto dto);

    PairPreferenceDto toDto(PairPreference entity);

}
