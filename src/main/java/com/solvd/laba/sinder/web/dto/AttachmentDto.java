package com.solvd.laba.sinder.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.solvd.laba.sinder.web.dto.group.OnSend;
import jakarta.validation.constraints.NotNull;

public record AttachmentDto(

        @NotNull(groups = {OnSend.class}, message = "Phone number should be marked as attached or unattached!")
        @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
        Boolean phoneNumber,

        @NotNull(groups = {OnSend.class}, message = "Instagram link should be marked as attached or unattached!")
        @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
        Boolean instagramLink,

        @NotNull(groups = {OnSend.class}, message = "Facebook link should be marked as attached or unattached!")
        @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
        Boolean facebookLink

) {
}
