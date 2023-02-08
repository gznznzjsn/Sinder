package com.solvd.laba.sinder.web.controller;

import com.solvd.laba.sinder.domain.Attachment;
import com.solvd.laba.sinder.domain.Message;
import com.solvd.laba.sinder.domain.user.User;
import com.solvd.laba.sinder.service.MessageService;
import com.solvd.laba.sinder.web.dto.AttachmentDto;
import com.solvd.laba.sinder.web.dto.MessageDto;
import com.solvd.laba.sinder.web.dto.group.OnSend;
import com.solvd.laba.sinder.web.dto.mapper.AttachmentMapper;
import com.solvd.laba.sinder.web.dto.mapper.MessageMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users/{userId}/pairs/{pairId}/messages")
public class MessageController {

    private final MessageService messageService;
    private final MessageMapper messageMapper;
    private final AttachmentMapper attachmentMapper;

    @GetMapping
    public List<MessageDto> openChat(@PathVariable Long userId,
                                     @PathVariable Long pairId) {
        List<Message> messages = messageService.retrieveAll(userId, pairId);
        return messageMapper.toDto(messages);
    }

    @PostMapping
    public MessageDto send(@Validated(OnSend.class) @RequestBody MessageDto messageDto,
                           @Validated(OnSend.class) AttachmentDto attachmentDto,
                           @PathVariable Long userId,
                           @PathVariable Long pairId) {
        Message message = messageMapper.toEntity(messageDto);
        Attachment attachment = attachmentMapper.toEntity(attachmentDto);
        message.setSender(User.builder().id(userId).build());
        message.setReceiver(User.builder().id(pairId).build());
        Message sentMessage = messageService.create(message, attachment);
        return messageMapper.toDto(sentMessage);
    }

}
