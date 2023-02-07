package com.slovd.laba.sinder.web.dto.mapper;

import com.slovd.laba.sinder.domain.AuthEntity;
import com.slovd.laba.sinder.web.dto.AuthEntityDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")//, uses = {EmployeeMapper.class, TaskListMapper.class})
public interface AuthEntityMapper {

    AuthEntity toEntity(AuthEntityDto dto);

   AuthEntityDto toDto(AuthEntity entity);

}
