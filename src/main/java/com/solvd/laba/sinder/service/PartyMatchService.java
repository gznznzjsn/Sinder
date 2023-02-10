package com.solvd.laba.sinder.service;

import com.solvd.laba.sinder.domain.partymatch.PartyMatch;

public interface PartyMatchService {

    PartyMatch retrieveById(Long partyMatchId);

    PartyMatch retrieveByGuestIdAndPartyId(Long guestId, Long partyId);

    PartyMatch create(PartyMatch partyMatch);

    PartyMatch update(PartyMatch partyMatch);

    PartyMatch requestParty(Long guestId, Long partyId);

    PartyMatch skipParty(Long guestId, Long partyId);

    PartyMatch inviteGuest(Long partyId, Long guestId);

    PartyMatch skipGuest(Long partyId, Long guestId);
}
