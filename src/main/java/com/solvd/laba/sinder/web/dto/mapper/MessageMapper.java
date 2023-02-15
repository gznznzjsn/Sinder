package com.solvd.laba.sinder.web.dto.mapper;

import com.solvd.laba.sinder.domain.chat.Message;
import com.solvd.laba.sinder.web.dto.MessageDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {UserMapper.class})
public interface MessageMapper {

    Message toEntity(MessageDto dto);

    MessageDto toDto(Message entity);

    List<Message> toEntity(List<MessageDto> dto);

    List<MessageDto> toDto(List<Message> entity);

}
