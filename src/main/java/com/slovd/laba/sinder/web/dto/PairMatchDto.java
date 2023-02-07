package com.slovd.laba.sinder.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.slovd.laba.sinder.domain.PairMatchStatus;

public record PairMatchDto(

        @JsonProperty(access = JsonProperty.Access.READ_ONLY)
        Long id,

        @JsonProperty(access = JsonProperty.Access.READ_ONLY)
        PairMatchStatus status,

        @JsonProperty(access = JsonProperty.Access.READ_ONLY)
        UserDto sender,

        @JsonProperty(access = JsonProperty.Access.READ_ONLY)
        UserDto receiver

) {
}
