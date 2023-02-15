package com.solvd.laba.sinder.web.dto.mapper;

import com.solvd.laba.sinder.domain.pairs.PairPreference;
import com.solvd.laba.sinder.web.dto.PairPreferenceDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")//, uses = {EmployeeMapper.class, TaskListMapper.class})
public interface PairPreferenceMapper {

    PairPreference toEntity(PairPreferenceDto dto);

    PairPreferenceDto toDto(PairPreference entity);

}
