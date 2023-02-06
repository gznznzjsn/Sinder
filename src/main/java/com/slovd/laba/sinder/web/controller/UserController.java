package com.slovd.laba.sinder.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {

    @GetMapping("/{userId}")
    public UserDto getById() {

    }

    @PostMapping("/{userId}/password/refresh")
    public UserDto refreshPassword() {

    }

    @PostMapping("/{userId}/password/update")
    public UserDto updatePassword() {

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto create() {

    }

    @DeleteMapping("/{userId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete() {

    }

    @PutMapping("/{userId}")
    public UserDto update() {

    }

}
