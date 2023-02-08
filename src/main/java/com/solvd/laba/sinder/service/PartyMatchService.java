package com.solvd.laba.sinder.service;

import com.solvd.laba.sinder.domain.partymatch.PartyMatch;

public interface PartyMatchService {

    PartyMatch inviteGuest(Long partyId, Long guestId);

    PartyMatch skipGuest(Long partyId, Long guestId);

    PartyMatch requestParty(Long guestId, Long partyId);

    PartyMatch skipParty(Long userId, Long partyId);
}
