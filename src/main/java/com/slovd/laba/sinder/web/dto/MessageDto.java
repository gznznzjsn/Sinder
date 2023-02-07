package com.slovd.laba.sinder.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.slovd.laba.sinder.web.dto.group.OnSend;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.List;

public record MessageDto(

        @JsonProperty(access = JsonProperty.Access.READ_ONLY)
        Long id,

        UserDto sender,

        UserDto receiver,

        @NotNull(groups = {OnSend.class})
        String text,

//        @NotNull(groups = {OnSend.class})
//        List<Link>links, //todo enum

        LocalDateTime dateTime

) {
}
