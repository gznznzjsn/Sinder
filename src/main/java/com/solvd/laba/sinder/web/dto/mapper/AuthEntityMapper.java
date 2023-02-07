package com.solvd.laba.sinder.web.dto.mapper;

import com.solvd.laba.sinder.domain.user.AuthEntity;
import com.solvd.laba.sinder.web.dto.AuthEntityDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")//, uses = {EmployeeMapper.class, TaskListMapper.class})
public interface AuthEntityMapper {

    AuthEntity toEntity(AuthEntityDto dto);

   AuthEntityDto toDto(AuthEntity entity);

}
