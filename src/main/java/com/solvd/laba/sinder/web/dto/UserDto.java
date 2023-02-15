package com.solvd.laba.sinder.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.solvd.laba.sinder.domain.Gender;
import com.solvd.laba.sinder.web.dto.group.OnUpdate;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.hibernate.validator.constraints.Length;

import java.util.List;

public record UserDto(

        @JsonProperty(access = JsonProperty.Access.READ_ONLY)
        Long id,

        @NotBlank(groups = {OnUpdate.class}, message = "Name can't be blank!")
        @Length(min = 2, max = 50, groups = {OnUpdate.class}, message = "Name must include minimum {min} and maximum {max} characters!")
        String name,

        @Length(min = 2, max = 50, groups = {OnUpdate.class}, message = "Surname must include minimum {min} and maximum {max} characters!")
        String surname,

        @JsonProperty(access = JsonProperty.Access.READ_ONLY)
        String email,

        @NotNull(groups = {OnUpdate.class}, message = "Gender can't be blank!")
        Gender gender,

        @NotNull(groups = {OnUpdate.class}, message = "Geolocation can't be blank!")
        PointDto geolocation,

        @NotNull(groups = {OnUpdate.class}, message = "Age can't be blank!")
        @Min(value = 18, groups = {OnUpdate.class}, message = "User can't be younger than {value}!")
        Integer age,

        @NotBlank(groups = {OnUpdate.class}, message = "Description can't be blank!")
        @Length(max = 255, groups = {OnUpdate.class}, message = "Description must include maximum {max} characters!")
        String description,

        @NotNull(groups = {OnUpdate.class}, message = "Photos can't be blank!")
        List<String> photos,

        @Positive(groups = {OnUpdate.class}, message = "Phone number must be positive!")
        Integer phoneNumber,

        @Length(max = 50, groups = {OnUpdate.class}, message = "Instagram link must include maximum {max} characters!")
        String instagramLink,

        @Length(max = 50, groups = {OnUpdate.class}, message = "Facebook link must include maximum {max} characters!")
        String facebookLink,

        @Valid
        PartyPreferenceDto partyPreference,

        @Valid
        PairPreferenceDto pairPreference,

        @JsonProperty(access = JsonProperty.Access.READ_ONLY)
        Boolean enabled

) {
}
