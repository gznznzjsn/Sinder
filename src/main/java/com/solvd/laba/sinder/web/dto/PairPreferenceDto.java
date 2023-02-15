package com.solvd.laba.sinder.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.solvd.laba.sinder.domain.Gender;
import com.solvd.laba.sinder.domain.pairs.Goal;
import com.solvd.laba.sinder.web.dto.group.OnUpdate;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.util.Set;

public record PairPreferenceDto(

        @JsonProperty(access = JsonProperty.Access.READ_ONLY)
        Long id,

        @NotNull(groups = {OnUpdate.class}, message = "List of genders can be empty, but not blank!")
        Set<Gender> genders,

        @NotNull(groups = {OnUpdate.class}, message = "Minimum age can't be blank!")
        @Min(value = 18, groups = {OnUpdate.class}, message = "There is no users, younger than {value}!")
        Integer minAge,

        @NotNull(groups = {OnUpdate.class}, message = "Maximum age can't be blank!")
        @Min(value = 18, groups = {OnUpdate.class}, message = "There is no user, younger than {value}!")
        Integer maxAge,

        @NotNull(groups = {OnUpdate.class}, message = "Goal can't be blank!")
        Goal goal,

        @NotNull(groups = {OnUpdate.class}, message = "Radius can't be blank!")
        @Positive(groups = {OnUpdate.class}, message = "Radius must be positive!")
        Integer radius
) {

}
