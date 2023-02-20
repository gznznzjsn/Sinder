package com.solvd.laba.sinder.web.dto;

import com.solvd.laba.sinder.web.validator.ValidImage;
import jakarta.validation.constraints.NotNull;
import org.springframework.web.multipart.MultipartFile;

public record ArtifactDto(

        @ValidImage
        @NotNull(message = "File can't be empty!")
        MultipartFile photo

) {
}
