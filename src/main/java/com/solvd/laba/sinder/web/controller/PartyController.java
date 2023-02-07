package com.solvd.laba.sinder.web.controller;

import com.solvd.laba.sinder.web.dto.PartyDto;
import com.solvd.laba.sinder.web.dto.group.OnUpdate;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users/{userId}/parties")
public class PartyController {

    @GetMapping("/{partyId}")
    public PartyDto getById() {
        return null;
    }

    @PostMapping("/{partyId}")
    public PartyDto publish() {
        return null;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public PartyDto create(@Validated(OnUpdate.class) @RequestBody PartyDto partyDto) {
        // name, description, geolocation, photos, date, dressCode, capacity, minAge, maxAge
        return null;
    }

    @DeleteMapping("/{partyId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete() {

    }

    @PutMapping("/{partyId}")
    public PartyDto update(@Validated(OnUpdate.class) @RequestBody PartyDto partyDto) { //do not use, if already published
        // name, description, geolocation, photos, date, dressCode, capacity, minAge, maxAge
        return null;
    }

}
