package com.solvd.laba.sinder.web.security.expression;

import com.solvd.laba.sinder.domain.Party;
import com.solvd.laba.sinder.domain.user.User;
import com.solvd.laba.sinder.service.PartyService;
import com.solvd.laba.sinder.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SecurityExpressions {

    private final PartyService partyService;
    private final UserService userService;

    public boolean hasParty(Long userId, Long partyId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.retrieveById(userId);
        Party party = partyService.retrieveById(partyId);
        return authentication.getName().equals(user.getEmail())
               && party.getCreator().getId().equals(userId);
    }

    public boolean hasUser(Long userId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.retrieveById(userId);
        return authentication.getName().equals(user.getEmail());
    }

}
