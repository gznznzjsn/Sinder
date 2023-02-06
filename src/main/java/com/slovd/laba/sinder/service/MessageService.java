package com.slovd.laba.sinder.service;

import com.slovd.laba.sinder.domain.Message;

import java.util.List;

public interface MessageService {

    List<Message> retrieveAll(Long userId, Long pairId);

    Message create(Message message);

}
