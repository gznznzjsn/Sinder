package com.slovd.laba.sinder.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.slovd.laba.sinder.domain.Gender;
import com.slovd.laba.sinder.web.dto.group.OnUpdate;
import jakarta.validation.constraints.NotNull;

import java.awt.Point;
import java.time.LocalDate;
import java.util.List;

public record UserDto(

        @JsonProperty(access = JsonProperty.Access.READ_ONLY)
        Long id,

        @NotNull(groups = {OnUpdate.class})
        String name,

        @NotNull(groups = {OnUpdate.class})
        String surname,

        String email,

        String password,

        @NotNull(groups = {OnUpdate.class})
        Gender gender,

        @NotNull(groups = {OnUpdate.class})
        Point geolocation,

        @NotNull(groups = {OnUpdate.class})
        Integer age,

        @NotNull(groups = {OnUpdate.class})
        String description,

        @NotNull(groups = {OnUpdate.class})
        List<String> photos,

        @NotNull(groups = {OnUpdate.class})
        List<LocalDate> partyDates,

        @NotNull(groups = {OnUpdate.class})
        Integer phoneNumber,

        @NotNull(groups = {OnUpdate.class})
        String instagramLink,

        @NotNull(groups = {OnUpdate.class})
        String facebookLink,

        PairPreferenceDto pairPreference,

        @JsonProperty(access = JsonProperty.Access.READ_ONLY)
        boolean enabled

) {
}
