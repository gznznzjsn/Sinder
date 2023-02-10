package com.solvd.laba.sinder.web.controller;

import com.solvd.laba.sinder.domain.Party;
import com.solvd.laba.sinder.domain.partymatch.PartyMatch;
import com.solvd.laba.sinder.service.PartyMatchService;
import com.solvd.laba.sinder.service.PartyService;
import com.solvd.laba.sinder.web.dto.PartyDto;
import com.solvd.laba.sinder.web.dto.PartyMatchDto;
import com.solvd.laba.sinder.web.dto.mapper.PartyMapper;
import com.solvd.laba.sinder.web.dto.mapper.PartyMatchMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users/{userId}/invitations")
public class InvitationController {

    private final PartyService partyService;
    private final PartyMatchService partyMatchService;
    private final PartyMatchMapper partyMatchMapper;
    private final PartyMapper partyMapper;

    @PreAuthorize("@securityExpressions.isUser(#userId)")
    @GetMapping
    public Page<PartyDto> getAppropriate(@PathVariable Long userId,
                                         @PageableDefault(size = 5) Pageable pageable) {
        Page<Party> parties = partyService.retrievePartiesFor(userId, pageable);
        List<PartyDto> partiesDto = partyMapper.toDto(parties.getContent());
        return new PageImpl<>(partiesDto);
    }

    @PreAuthorize("@securityExpressions.isUser(#userId)")
    @GetMapping("/{partyId}")
    public PartyDto getById(@PathVariable Long userId,
                            @PathVariable Long partyId) {
        Party party = partyService.retrieveById(partyId);
        return partyMapper.toDto(party);
    }

    @PreAuthorize("@securityExpressions.isUser(#userId)")
    @PostMapping("/{partyId}/request")
    public PartyMatchDto request(@PathVariable Long userId,
                                 @PathVariable Long partyId) {
        PartyMatch partyMatch = partyMatchService.requestParty(userId, partyId);
        return partyMatchMapper.toDto(partyMatch);
    }

    @PreAuthorize("@securityExpressions.isUser(#userId)")
    @PostMapping("/{partyId}/skip")
    public PartyMatchDto skip(@PathVariable Long userId,
                              @PathVariable Long partyId) {
        PartyMatch partyMatch = partyMatchService.skipParty(userId, partyId);
        return partyMatchMapper.toDto(partyMatch);
    }

}
