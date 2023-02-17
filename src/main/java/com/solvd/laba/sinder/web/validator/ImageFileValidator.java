package com.solvd.laba.sinder.web.validator;

import org.apache.commons.compress.utils.FileNameUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.Objects;

public class ImageFileValidator implements ConstraintValidator<ValidImage, MultipartFile> {

    private static final String[] TYPES = {"png", "jpg", "jpeg", "tiff"};

    @Override
    public void initialize(ValidImage constraintAnnotation) {

    }

    @Override
    public boolean isValid(MultipartFile multipartFile, ConstraintValidatorContext context) {
        String extension = FileNameUtils.getExtension(multipartFile.getOriginalFilename());
        if (multipartFile.isEmpty()) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("File should not be empty!")
                    .addConstraintViolation();
            return false;
        }
        if (!isSupportedExtension(extension)) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Only PNG, JPG, JPEG or TIFF images are allowed!")
                    .addConstraintViolation();
            return false;
        }
        return true;
    }

    private boolean isSupportedExtension(String extension) {
        return Objects.nonNull(extension) && Arrays.stream(TYPES).anyMatch(extension::equalsIgnoreCase);
    }
}