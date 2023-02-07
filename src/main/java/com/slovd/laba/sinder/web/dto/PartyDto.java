package com.slovd.laba.sinder.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.slovd.laba.sinder.web.dto.group.OnUpdate;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.hibernate.validator.constraints.Length;

import java.awt.*;
import java.time.LocalDate;
import java.util.List;

public record PartyDto(

        @JsonProperty(access = JsonProperty.Access.READ_ONLY)
        Long id,

        @Valid
        UserDto creator,

        @NotBlank(groups = {OnUpdate.class}, message = "Name can't be blank!")
        @Length(min = 2, max = 50, groups = {OnUpdate.class}, message = "Name must include minimum {min} and maximum {max} characters!")
        String name,

        @NotBlank(groups = {OnUpdate.class}, message = "Description can't be blank!")
        @Length(max = 255, groups = {OnUpdate.class}, message = "Description must include maximum {max} characters!")
        String description,

        @NotNull(groups = {OnUpdate.class}, message = "Geolocation can't be blank!")
        Point geolocation,

        @NotNull(groups = {OnUpdate.class}, message = "Photos can't be blank!")
        List<String> photos,

        @NotNull(groups = {OnUpdate.class}, message = "Date can't be blank!")
        LocalDate date,

        @NotBlank(groups = {OnUpdate.class}, message = "Dress code can't be blank!")
        @Length(max = 50, groups = {OnUpdate.class}, message = "Dress code must include maximum {max} characters!")
        String dressCode,

        @NotNull(groups = {OnUpdate.class}, message = "Capacity can't be blank!")
        @Positive(groups = {OnUpdate.class}, message = "Capacity must be positive!")
        Integer capacity,

        @NotNull(groups = {OnUpdate.class}, message = "Minimum age can't be blank!")
        @Min(value = 18, groups = {OnUpdate.class}, message = "There is no user, younger than {value}!")
        Integer minAge,

        @NotNull(groups = {OnUpdate.class}, message = "Maximum age can't be blank!")
        @Min(value = 18, groups = {OnUpdate.class}, message = "There is no user, younger than {value}!")
        Integer maxAge,

        @JsonProperty(access = JsonProperty.Access.READ_ONLY)
        Boolean published

) {
}
