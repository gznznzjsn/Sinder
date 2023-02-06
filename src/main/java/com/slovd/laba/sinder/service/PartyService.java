package com.slovd.laba.sinder.service;

import com.slovd.laba.sinder.domain.Party;
import com.slovd.laba.sinder.domain.User;

import java.util.List;

public interface PartyService {

    Party retrieveById(Long partyId);

    Party publish(Long partyId);

    void requestParty(Long userId, Long partyId);

    void skipParty(Long userId, Long partyId);

    Party create(Party party);

    void delete(Long partyId);

    Party update(Party party);

    List<Party> retrievePartiesFor(User guest);


}
