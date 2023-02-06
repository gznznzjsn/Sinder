package com.slovd.laba.sinder.persistence;

import com.slovd.laba.sinder.domain.Message;

import java.util.List;

public interface MessageRepository {

    List<Message> findChat(Long userId, Long pairId);

    void create(Message message);

}
