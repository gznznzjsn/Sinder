package com.solvd.laba.sinder.web.security.expression;

import com.solvd.laba.sinder.domain.Party;
import com.solvd.laba.sinder.domain.pairmatch.PairMatch;
import com.solvd.laba.sinder.domain.pairmatch.PairMatchStatus;
import com.solvd.laba.sinder.domain.user.User;
import com.solvd.laba.sinder.service.PairMatchService;
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
    private final PairMatchService pairMatchService;

    public boolean hasParty(Long userId, Long partyId) {
        Party party = partyService.retrieveById(partyId);
        return party.getCreator().getId().equals(userId);
    }

    public boolean isUser(Long userId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.retrieveById(userId);
        return authentication.getName().equals(user.getEmail());
    }

    public boolean isPair(Long userId, Long pairId) {
        PairMatch pairMatch1 = pairMatchService.retrieveBySenderIdAndReceiverId(userId, pairId);
        PairMatch pairMatch2 = pairMatchService.retrieveBySenderIdAndReceiverId(pairId, userId);
        if (pairMatch1 != null) {
            return pairMatch1.getStatus().equals(PairMatchStatus.APPROVED);
        }
        if (pairMatch2 != null) {
            return pairMatch2.getStatus().equals(PairMatchStatus.APPROVED);
        }
        return false;
    }

}
