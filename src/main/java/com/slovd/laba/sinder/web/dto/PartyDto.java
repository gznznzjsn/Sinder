package com.slovd.laba.sinder.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.slovd.laba.sinder.domain.User;
import com.slovd.laba.sinder.web.dto.group.OnUpdate;
import jakarta.validation.constraints.NotNull;

import java.awt.*;
import java.time.LocalDate;
import java.util.List;

public record PartyDto(

        // name, description, geolocation, photos, date, dressCode, capacity, minAge, maxAge
        @JsonProperty(access = JsonProperty.Access.READ_ONLY)
        Long id,

        UserDto creator,

        @NotNull(groups = {OnUpdate.class})
        String name,

        @NotNull(groups = {OnUpdate.class})
        String description,

        @NotNull(groups = {OnUpdate.class})
        Point geolocation,

        @NotNull(groups = {OnUpdate.class})
        List<String> photos,

        @NotNull(groups = {OnUpdate.class})
        LocalDate date,

        @NotNull(groups = {OnUpdate.class})
        String dressCode,

        @NotNull(groups = {OnUpdate.class})
        Integer capacity,

        @NotNull(groups = {OnUpdate.class})
        Integer minAge,

        @NotNull(groups = {OnUpdate.class})
        Integer maxAge,

        boolean published

) {
}
