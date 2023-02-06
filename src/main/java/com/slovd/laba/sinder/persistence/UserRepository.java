package com.slovd.laba.sinder.persistence;

import com.slovd.laba.sinder.domain.Party;
import com.slovd.laba.sinder.domain.User;

import java.util.List;

public interface UserRepository {

    List<User> findPairsFor(Long userId);

    List<User> findGuestsFor(Long partyId);

    User findById(Long userId);

    boolean isExist(String email);

    void inviteGuest(Long partyId, Long guestId);

    void skipGuest(Long partyId, Long guestId);

    void likePair(Long userId, Long pairId);

    void skipPair(Long userId, Long pairId);

    void create(User user);

    void update(User user);

    void delete(Long userId);

}
