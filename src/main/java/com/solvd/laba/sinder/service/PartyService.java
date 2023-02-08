package com.solvd.laba.sinder.service;

import com.solvd.laba.sinder.domain.Party;
import com.solvd.laba.sinder.domain.partymatch.PartyMatch;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PartyService {

    Page<Party> retrievePartiesFor(Long guestId, Pageable pageable);

    Party retrieveById(Long partyId);

    Party publish(Long partyId);

    PartyMatch requestParty(Long userId, Long partyId);

    PartyMatch skipParty(Long userId, Long partyId);

    Party create(Party party);

    void delete(Long partyId);

    Party update(Party party);

}
