package com.solvd.laba.sinder.service;

import com.solvd.laba.sinder.domain.Party;

import java.util.List;

public interface PartyService {

    List<Party> retrievePartiesFor(Long guestId);

    Party retrieveById(Long partyId);

    Party publish(Long partyId);

    void requestParty(Long userId, Long partyId);

    void skipParty(Long userId, Long partyId);

    Party create(Party party);

    void delete(Long partyId);

    Party update(Party party);

}
