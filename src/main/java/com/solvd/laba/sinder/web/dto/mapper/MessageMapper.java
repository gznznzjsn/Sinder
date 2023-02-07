package com.solvd.laba.sinder.web.dto.mapper;

import com.solvd.laba.sinder.domain.Message;
import com.solvd.laba.sinder.web.dto.MessageDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {UserMapper.class})
public interface MessageMapper {

    Message toEntity(MessageDto dto);

    MessageDto toDto(Message entity);

}
