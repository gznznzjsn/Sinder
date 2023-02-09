package com.solvd.laba.sinder.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.solvd.laba.sinder.web.dto.group.OnUpdate;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.List;

public record PartyPreferenceDto(

        @JsonProperty(access = JsonProperty.Access.READ_ONLY)
        Long id,

        @NotNull(groups = {OnUpdate.class}, message = "Party dates can be empty, but can't be blank!")
        List<LocalDate> partyDates

) {

}
