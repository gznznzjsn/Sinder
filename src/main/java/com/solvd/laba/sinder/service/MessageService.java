package com.solvd.laba.sinder.service;

import com.solvd.laba.sinder.domain.chat.Attachment;
import com.solvd.laba.sinder.domain.chat.Message;

import java.util.List;

public interface MessageService {

    List<Message> retrieveAll(Long userId, Long pairId);

    Message create(Message message, Attachment attachment);

}
