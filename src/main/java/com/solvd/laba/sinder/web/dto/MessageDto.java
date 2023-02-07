package com.solvd.laba.sinder.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.solvd.laba.sinder.web.dto.group.OnSend;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;

public record MessageDto(

        @JsonProperty(access = JsonProperty.Access.READ_ONLY)
        Long id,

        @JsonProperty(access = JsonProperty.Access.READ_ONLY)
        UserDto sender,

        @JsonProperty(access = JsonProperty.Access.READ_ONLY)
        UserDto receiver,

        @Length(max = 255, groups = {OnSend.class}, message = "Too long text!")
        String text,

        @JsonProperty(access = JsonProperty.Access.READ_ONLY)
        LocalDateTime dateTime

) {
}
