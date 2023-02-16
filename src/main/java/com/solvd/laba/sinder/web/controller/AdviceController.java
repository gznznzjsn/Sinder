package com.solvd.laba.sinder.web.controller;

import com.solvd.laba.sinder.domain.exception.*;
import com.solvd.laba.sinder.web.dto.ExceptionDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@RestControllerAdvice
public class AdviceController {

    @ExceptionHandler(IllegalActionException.class)
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    public ExceptionDto handleIllegalAction(IllegalActionException e) {
        return ExceptionDto.builder()
                .message(e.getMessage())
                .build();
    }

    @ExceptionHandler(InvalidPasswordException.class)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ExceptionDto handleInvalidPassword(InvalidPasswordException e) {
        return ExceptionDto.builder()
                .message(e.getMessage())
                .build();
    }

    @ExceptionHandler(MailException.class)
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    public ExceptionDto handleMail(MailException e) {
        return ExceptionDto.builder()
                .message(e.getMessage())
                .build();
    }

    @ExceptionHandler(ResourceAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ExceptionDto handleResourceAlreadyExists(ResourceAlreadyExistsException e) {
        return ExceptionDto.builder()
                .message(e.getMessage())
                .build();
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionDto handleResourceNotFound(ResourceNotFoundException e) {
        return ExceptionDto.builder()
                .message(e.getMessage())
                .build();
    }

    @ExceptionHandler({AccessDeniedException.class})
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ExceptionDto handleAccessDenied() {
        return ExceptionDto.builder()
                .message("Access denied!")
                .build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionDto handleMethodArgumentNotValid(MethodArgumentNotValidException e) {
        Map<String, String> otherInfo = e.getBindingResult()
                .getFieldErrors().stream()
                .collect(Collectors.toMap(
                                (FieldError::getField),
                                (fieldError ->
                                        fieldError.getDefaultMessage() == null ? "No message" : fieldError.getDefaultMessage()
                                )
                        )
                );
        return ExceptionDto.builder()
                .message("One or more of arguments are invalid!")
                .otherInfo(otherInfo)
                .build();
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ExceptionDto handleOther(Exception e) {
        log.error(e.getMessage(), e);
        return ExceptionDto.builder()
                .message("Please, try later!")
                .build();
    }

}
