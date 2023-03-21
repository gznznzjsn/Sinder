package com.solvd.laba.sinder.service.impl;

import com.solvd.laba.sinder.domain.chat.Attachment;
import com.solvd.laba.sinder.domain.chat.Message;
import com.solvd.laba.sinder.domain.exception.ResourceNotFoundException;
import com.solvd.laba.sinder.domain.User;
import com.solvd.laba.sinder.persistence.MessageRepository;
import com.solvd.laba.sinder.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class MessageServiceImpl implements MessageService {

    private final MessageRepository messageRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Message> retrieveAll(Long userId, Long pairId) {
        return messageRepository.findAllBySenderIdAndReceiverIdOrSenderIdAndReceiverIdOrderByDateTime(userId, pairId, pairId, userId);
    }

    @Override
    @Transactional
    public Message create(Message message, Attachment attachment) {
        StringBuilder text = new StringBuilder(message.getText());
        User sender = message.getSender();
        if (attachment.getPhoneNumber()) {
            Integer phoneNumber = sender.getPhoneNumber();
            if (Objects.nonNull(phoneNumber)) {
                text.append("\nMy phone number: ").append(phoneNumber);
            } else {
                throw new ResourceNotFoundException("Phone number doesn't exist!");
            }
        }
        if (attachment.getInstagramLink()) {
            String instagramLink = sender.getInstagramLink();
            if (Objects.nonNull(instagramLink)) {
                text.append("\nMy instagram: ").append(instagramLink);
            } else {
                throw new ResourceNotFoundException("Instagram link doesn't exist!");
            }
        }
        if (attachment.getFacebookLink()) {
            String facebookLink = sender.getFacebookLink();
            if (Objects.nonNull(facebookLink)) {
                text.append("\nMy facebook: ").append(facebookLink);
            } else {
                throw new ResourceNotFoundException("Facebook link doesn't exist!");
            }
        }
        message.setText(text.toString());
        return messageRepository.save(message);
    }

}
