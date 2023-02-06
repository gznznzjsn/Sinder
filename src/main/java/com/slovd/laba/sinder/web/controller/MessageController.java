package com.slovd.laba.sinder.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users/{userId}/pairs/{pairId}/messages")
public class MessageController {

    @GetMapping
    public List<MessageDto> openChat(){}

    @PostMapping
    public List<MessageDto> send(){} //phone, links as request params


}
