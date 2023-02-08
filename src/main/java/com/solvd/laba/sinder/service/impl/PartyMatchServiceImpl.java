package com.solvd.laba.sinder.service.impl;

import com.solvd.laba.sinder.domain.exception.ResourceNotFoundException;
import com.solvd.laba.sinder.domain.partymatch.PartyMatch;
import com.solvd.laba.sinder.persistence.PartyMatchRepository;
import com.solvd.laba.sinder.service.PartyMatchService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PartyMatchServiceImpl implements PartyMatchService {

    private final PartyMatchRepository partyMatchRepository;

    @Override
    public PartyMatch retrieveById(Long partyMatchId) {
        return partyMatchRepository.findById(partyMatchId)
                .orElseThrow(() -> new ResourceNotFoundException("PartyMatch with id = " + partyMatchId + " not found!"));
    }

    @Override
    public PartyMatch retrieveByGuestIdAndPartyId(Long guestId, Long partyId) {
        return partyMatchRepository.findByGuestIdAndPartyId(guestId, partyId)
                .orElseThrow(() -> new ResourceNotFoundException("PartyMatch with guest's id = " + guestId + " and party's id = " + partyId + " not found!"));
    }

    @Override
    public Boolean isExist(Long guestId, Long partyId) {
        return partyMatchRepository.existsByGuestIdAndPartyId(guestId, partyId);
    }

    @Override
    public PartyMatch create(PartyMatch partyMatch) {
        return partyMatchRepository.save(partyMatch);
    }

    @Override
    public PartyMatch update(PartyMatch partyMatch) {
        PartyMatch foundPartyMatch = retrieveById(partyMatch.getId());
        foundPartyMatch.setParty(partyMatch.getParty());
        foundPartyMatch.setGuest(partyMatch.getGuest());
        foundPartyMatch.setStatus(partyMatch.getStatus());
        return partyMatchRepository.save(partyMatch);
    }
}
