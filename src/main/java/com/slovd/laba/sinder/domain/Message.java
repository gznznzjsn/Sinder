package com.slovd.laba.sinder.domain;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Message {

    private Long id;
    private User sender;
    private User receiver;
    private String text;
    private LocalDateTime dateTime;

}
