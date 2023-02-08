package com.solvd.laba.sinder.web.dto.mapper;

import com.solvd.laba.sinder.domain.user.User;
import com.solvd.laba.sinder.web.dto.UserDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {PairPreferenceMapper.class, PointMapper.class})
public interface UserMapper {

    User toEntity(UserDto dto);

    UserDto toDto(User entity);

    List<User> toEntity(List<UserDto> dto);

    List<UserDto> toDto(List<User> entity);

}
