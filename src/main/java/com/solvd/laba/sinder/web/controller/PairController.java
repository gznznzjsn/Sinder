package com.solvd.laba.sinder.web.controller;

import com.solvd.laba.sinder.domain.pairmatch.PairMatch;
import com.solvd.laba.sinder.domain.user.User;
import com.solvd.laba.sinder.service.PairMatchService;
import com.solvd.laba.sinder.service.UserService;
import com.solvd.laba.sinder.web.dto.PairMatchDto;
import com.solvd.laba.sinder.web.dto.UserDto;
import com.solvd.laba.sinder.web.dto.mapper.PairMatchMapper;
import com.solvd.laba.sinder.web.dto.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users/{userId}/pairs")
public class PairController {

    private final UserService userService;
    private final UserMapper userMapper;
    private final PairMatchService pairMatchService;
    private final PairMatchMapper pairMatchMapper;

    @GetMapping
    public Page<UserDto> getAppropriate(@PathVariable Long userId,
                                        @PageableDefault(size = 5) Pageable pageable) { //reqParam page! Postman
        Page<User> pairs = userService.retrievePairsFor(userId, pageable); //create
        List<UserDto> pairsDto = userMapper.toDto(pairs.getContent());
        return new PageImpl<>(pairsDto);
    }

    @GetMapping("/{pairId}")
    public UserDto getById(@PathVariable Long userId,
                           @PathVariable Long pairId) {
        User pair = userService.retrieveById(pairId);
        return userMapper.toDto(pair);
    }

    @PostMapping("/{pairId}/like")
    public PairMatchDto like(@PathVariable Long userId,
                             @PathVariable Long pairId) {
        PairMatch pairMatch = pairMatchService.likePair(userId, pairId);
        return pairMatchMapper.toDto(pairMatch);
    }

    @PostMapping("/{pairId}/skip")
    public PairMatchDto skip(@PathVariable Long userId,
                             @PathVariable Long pairId) {
        PairMatch pairMatch = pairMatchService.skipPair(userId, pairId);
        return pairMatchMapper.toDto(pairMatch);
    }

}
