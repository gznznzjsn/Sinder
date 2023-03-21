package com.solvd.laba.sinder.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.solvd.laba.sinder.domain.parties.PartyMatchStatus;

public record PartyMatchDto(

        @JsonProperty(access = JsonProperty.Access.READ_ONLY)
        Long id,

        @JsonProperty(access = JsonProperty.Access.READ_ONLY)
        PartyMatchStatus status,

        @JsonProperty(access = JsonProperty.Access.READ_ONLY)
        UserDto guest,

        @JsonProperty(access = JsonProperty.Access.READ_ONLY)
        PartyDto party

) {
}
