package com.slovd.laba.sinder.web.controller;

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
    public UserDto like(){
        return null;
    }

    @PostMapping("/{pairId}/skip")
    public UserDto skip(){
        return null;
    }  // todo maybe match dto??

}
