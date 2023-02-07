package com.slovd.laba.sinder.web.controller;

import com.slovd.laba.sinder.web.dto.PairMatchDto;
import com.slovd.laba.sinder.web.dto.UserDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users/{userId}/pairs")
public class PairController {

    @GetMapping
    public List<UserDto> getAppropriate(){
        return null;
    }

    @GetMapping("/{pairId}")
    public UserDto getById(){
        return null;
    }

    @PostMapping("/{pairId}/like")
    public PairMatchDto like(){
        return null;
    }

    @PostMapping("/{pairId}/skip")
    public PairMatchDto skip(){
        return null;
    }

}
