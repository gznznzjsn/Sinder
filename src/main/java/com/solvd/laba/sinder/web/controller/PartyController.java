package com.solvd.laba.sinder.web.controller;

import com.solvd.laba.sinder.domain.Party;
import com.solvd.laba.sinder.domain.user.User;
import com.solvd.laba.sinder.service.PartyService;
import com.solvd.laba.sinder.web.dto.PartyDto;
import com.solvd.laba.sinder.web.dto.group.OnUpdate;
import com.solvd.laba.sinder.web.dto.mapper.PartyMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users/{userId}/parties")
public class PartyController {

    private final PartyService partyService;
    private final PartyMapper partyMapper;

    @GetMapping("/{partyId}")
    public PartyDto getById(@PathVariable Long userId,
                            @PathVariable Long partyId) {
        Party party = partyService.retrieveById(partyId);
        return partyMapper.toDto(party);
    }

    @PostMapping("/{partyId}")
    public PartyDto publish(@PathVariable Long userId,
                            @PathVariable Long partyId) {
        Party party = partyService.publish(partyId);
        return partyMapper.toDto(party);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public PartyDto create(@Validated(OnUpdate.class) @RequestBody PartyDto partyDto,
                           @PathVariable Long userId) {
        // name, description, geolocation, photos, date, dressCode, capacity, minAge, maxAge
        Party party = partyMapper.toEntity(partyDto);
        party.setCreator(User.builder().id(userId).build());
        Party createdParty = partyService.create(party);
        return partyMapper.toDto(createdParty);
    }

    @DeleteMapping("/{partyId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long userId,
                       @PathVariable Long partyId) {
        partyService.delete(partyId);
    }

    @PutMapping("/{partyId}")
    public PartyDto update(@Validated(OnUpdate.class) @RequestBody PartyDto partyDto,
                           @PathVariable Long userId,
                           @PathVariable Long partyId) { //do not use, if already published
        // name, description, geolocation, photos, date, dressCode, capacity, minAge, maxAge
        Party party = partyMapper.toEntity(partyDto);
        party.setId(partyId);
        Party updatedParty = partyService.update(party);
        return partyMapper.toDto(updatedParty);
    }

}
