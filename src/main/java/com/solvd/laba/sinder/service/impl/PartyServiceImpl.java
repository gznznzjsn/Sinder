package com.solvd.laba.sinder.service.impl;

import com.solvd.laba.sinder.domain.Party;
import com.solvd.laba.sinder.domain.exception.IllegalActionException;
import com.solvd.laba.sinder.domain.exception.ResourceNotFoundException;
import com.solvd.laba.sinder.persistence.PartyRepository;
import com.solvd.laba.sinder.service.PartyService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PartyServiceImpl implements PartyService {

    private final PartyRepository partyRepository;

    @Override
    @Transactional(readOnly = true)
    public Page<Party> retrievePartiesFor(Long guestId, Pageable pageable) {
        return partyRepository.findPartiesFor(guestId, pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Party retrieveById(Long partyId) {
        return partyRepository.findById(partyId)
                .orElseThrow(() -> new ResourceNotFoundException("Party with id = " + partyId + " not found!"));
    }

    @Override
    @Transactional
    public Party publish(Long partyId) {
        Party party = retrieveById(partyId);
        party.setPublished(true);
        return partyRepository.save(party);
    }

    @Override
    @Transactional
    public Party create(Party party) {
        party.setPublished(false);
        return partyRepository.save(party);
    }

    @Override
    @Transactional
    public void delete(Long partyId) {
        Party party = retrieveById(partyId);
        partyRepository.delete(party);
    }

    @Override
    @Transactional
    public Party update(Party party) {
        Party foundParty = retrieveById(party.getId());
        if (!foundParty.getPublished()) {
            throw new IllegalActionException(""); //todo message
        }
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
