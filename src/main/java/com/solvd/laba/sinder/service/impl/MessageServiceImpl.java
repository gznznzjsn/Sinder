package com.solvd.laba.sinder.service.impl;

import com.solvd.laba.sinder.domain.Attachment;
import com.solvd.laba.sinder.domain.Message;
import com.solvd.laba.sinder.domain.exception.ResourceNotFoundException;
import com.solvd.laba.sinder.domain.user.User;
import com.solvd.laba.sinder.persistence.MessageRepository;
import com.solvd.laba.sinder.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

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
        String text = message.getText();
        User sender = message.getSender();
        if (attachment.getPhoneNumber()) {
            Integer phoneNumber = sender.getPhoneNumber();
            if (Objects.nonNull(phoneNumber)) {
                text += "\nMy phone number: " + phoneNumber;
            } else {
                throw new ResourceNotFoundException("Phone number doesn't exist!");
            }
        }
        if (attachment.getInstagramLink()) {
            String instagramLink = sender.getInstagramLink();
            if (Objects.nonNull(instagramLink)) {
                text += "\nMy instagram: " + instagramLink;
            } else {
                throw new ResourceNotFoundException("Instagram link doesn't exist!");
            }
        }
        if (attachment.getFacebookLink()) {
            String facebookLink = sender.getFacebookLink();
            if (Objects.nonNull(facebookLink)) {
                text += "\nMy facebook: " + facebookLink;
            } else {
                throw new ResourceNotFoundException("Facebook link doesn't exist!");
            }
        }
        message.setText(text);
        return messageRepository.save(message);
    }

}
