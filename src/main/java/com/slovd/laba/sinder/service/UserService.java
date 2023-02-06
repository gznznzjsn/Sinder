package com.slovd.laba.sinder.service;

import com.slovd.laba.sinder.domain.Party;
import com.slovd.laba.sinder.domain.User;

import java.util.List;

public interface UserService {

    List<User> retrievePairsFor(Long userId);

    List<User> retrieveGuestsFor(Long partyId);

    User retrieveById(Long userId);

    void skipPair(Long userId, Long pairId);

    void likePair(Long userId, Long pairId);

    void inviteGuest(Long partyId, Long guestId);

    void skipGuest(Long partyId, Long guestId);

    User create(User user);

    User update(User user);

    void delete(Long userId);

}
