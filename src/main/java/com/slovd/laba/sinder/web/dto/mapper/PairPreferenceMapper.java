package com.slovd.laba.sinder.web.dto.mapper;

import com.slovd.laba.sinder.domain.PairPreference;
import com.slovd.laba.sinder.web.dto.PairPreferenceDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")//, uses = {EmployeeMapper.class, TaskListMapper.class})
public interface PairPreferenceMapper {

    PairPreference toEntity(PairPreferenceDto dto);

    PairPreferenceDto toDto(PairPreference entity);

}
