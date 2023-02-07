package com.slovd.laba.sinder.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.slovd.laba.sinder.domain.Gender;
import com.slovd.laba.sinder.domain.Goal;
import com.slovd.laba.sinder.web.dto.group.OnUpdate;
import jakarta.validation.constraints.NotNull;

import java.util.Set;

public record PairPreferenceDto(

        @JsonProperty(access = JsonProperty.Access.READ_ONLY)
        Long id,

        @NotNull(groups = {OnUpdate.class})
        Set<Gender> genders,

        @NotNull(groups = {OnUpdate.class})
        Integer minAge,

        @NotNull(groups = {OnUpdate.class})
        Integer maxAge,

        @NotNull(groups = {OnUpdate.class})
        Goal goal,

        @NotNull(groups = {OnUpdate.class})
        Integer radius
) {

}
