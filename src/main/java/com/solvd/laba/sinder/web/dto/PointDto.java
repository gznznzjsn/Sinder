package com.solvd.laba.sinder.web.dto;

import com.solvd.laba.sinder.web.dto.group.OnUpdate;
import jakarta.validation.constraints.NotNull;

public record PointDto(

        @NotNull(groups = {OnUpdate.class}, message = "Latitude can't be blank!")
        //todo
        Double latitude,

        @NotNull(groups = {OnUpdate.class}, message = "Longtitude can't be blank!")
        //todo
        Double longitude

) {
}
