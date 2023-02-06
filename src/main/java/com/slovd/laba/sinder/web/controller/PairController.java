package com.slovd.laba.sinder.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users/{userId}/pairs")
public class PairController {

    @GetMapping
    public List<UserDto> getAppropriate(){}

    @GetMapping("/{pairId}")
    public UserDto getById(){}

    @PostMapping("/{pairId}/like")
    public UserDto like(){}

    @PostMapping("/{pairId}/skip")
    public UserDto skip(){}

}
