package com.solvd.laba.sinder.web.validator;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.TYPE, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = {ImageFileValidator.class})
public @interface ValidImage {

    String message() default "Invalid image file!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}