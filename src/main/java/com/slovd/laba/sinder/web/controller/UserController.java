package com.slovd.laba.sinder.web.controller;

import com.slovd.laba.sinder.web.dto.UserDto;
import com.slovd.laba.sinder.web.dto.group.OnUpdate;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {

    @GetMapping("/{userId}")
    public UserDto getById() {
        return null;
    }

    //todo
//    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
//    public UserDto create(@RequestBody UserDto userDto) {
//
//    }

    @DeleteMapping("/{userId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete() {
    }

    @PutMapping("/{userId}")
    public UserDto update(@Validated(OnUpdate.class) @RequestBody UserDto userDto) {
        //  name,surname,gender,geolocation, age, description,photos, partyDates, phoneNumber,instagramLink;facebookLink;pairPreference;
        return null;
    }

}
