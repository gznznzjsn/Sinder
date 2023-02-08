package com.solvd.laba.sinder.service.impl;

import com.solvd.laba.sinder.domain.Attachment;
import com.solvd.laba.sinder.domain.Message;
import com.solvd.laba.sinder.persistence.MessageRepository;
import com.solvd.laba.sinder.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MessageServiceImpl implements MessageService {

    private final MessageRepository messageRepository;

    @Override
    public List<Message> retrieveAll(Long userId, Long pairId) {
        return messageRepository.findAllBySenderIdAndReceiverIdOrSenderIdAndReceiverId(userId, pairId, pairId, userId);
    }

    @Override
    public Message create(Message message, Attachment attachment) {
        return null;
    }

}
