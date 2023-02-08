package com.solvd.laba.sinder.service;

import com.solvd.laba.sinder.domain.user.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {

    Page<User> retrievePairsFor(Long userId, Pageable pageable);

    Page<User> retrieveGuestsFor(Long partyId, Pageable pageable);

    User retrieveById(Long userId);

    User create(User user);

    User update(User user);

    void delete(Long userId);

}
