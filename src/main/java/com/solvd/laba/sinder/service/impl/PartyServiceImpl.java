package com.solvd.laba.sinder.service.impl;

import com.solvd.laba.sinder.domain.Party;
import com.solvd.laba.sinder.domain.exception.ResourceNotFoundException;
import com.solvd.laba.sinder.domain.user.User;
import com.solvd.laba.sinder.persistence.PartyRepository;
import com.solvd.laba.sinder.service.PartyService;
import com.solvd.laba.sinder.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PartyServiceImpl implements PartyService {

    private final PartyRepository partyRepository;
    private final UserService userService;

    @Override
    public Page<Party> retrievePartiesFor(Long guestId, Pageable pageable) {
        User guest = userService.retrieveById(guestId);
        return partyRepository.findAllByDateIn(guest.getPartyDates(), pageable);
    }

    @Override
    public Party retrieveById(Long partyId) {
        return partyRepository.findById(partyId)
                .orElseThrow(() -> new ResourceNotFoundException("Party with id = " + partyId + " not found!"));
    }

    @Override
    public Party publish(Long partyId) {
        Party party = retrieveById(partyId);
        party.setPublished(true);
        return partyRepository.save(party);
    }

    @Override
    public Party create(Party party) {
        return partyRepository.save(party);
    }

    @Override
    public void delete(Long partyId) {
        Party party = retrieveById(partyId);
        partyRepository.delete(party);
    }

    @Override
    public Party update(Party party) {
        Party foundParty = retrieveById(party.getId());
        foundParty.setCreator(party.getCreator());
        foundParty.setName(party.getName());
        foundParty.setDescription(party.getDescription());
        foundParty.setDate(party.getDate());
        foundParty.setGeolocation(party.getGeolocation());
        foundParty.setPhotos(party.getPhotos());
        foundParty.setDressCode(party.getDressCode());
        foundParty.setCapacity(party.getCapacity());
        foundParty.setMinAge(party.getMinAge());
        foundParty.setMaxAge(party.getMaxAge());
        foundParty.setPublished(party.getPublished());
        return partyRepository.save(foundParty);
    }

}
