package com.slovd.laba.sinder.web.dto.mapper;

import com.slovd.laba.sinder.domain.User;
import com.slovd.laba.sinder.web.dto.UserDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {PairPreferenceMapper.class, PointMapper.class})
public interface UserMapper {

    User toEntity(UserDto dto);

    UserDto toDto(User entity);

}
