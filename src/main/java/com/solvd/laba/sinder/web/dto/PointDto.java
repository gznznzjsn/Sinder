package com.solvd.laba.sinder.web.dto;

import com.solvd.laba.sinder.web.dto.group.OnUpdate;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Range;

public record PointDto(

        @NotNull(groups = {OnUpdate.class}, message = "Latitude can't be blank!")
        @Range(min = -90, max = 90, message = "Latitude out of range!")
        Double latitude,

        @NotNull(groups = {OnUpdate.class}, message = "Longitude can't be blank!")
        @Range(min = 0, max = 180, message = "Longitude out of range!")
        Double longitude

) {
}
