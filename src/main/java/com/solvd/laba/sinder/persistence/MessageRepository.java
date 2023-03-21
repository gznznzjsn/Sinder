package com.solvd.laba.sinder.persistence;

import com.solvd.laba.sinder.domain.chat.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {

    List<Message> findAllBySenderIdAndReceiverIdOrSenderIdAndReceiverIdOrderByDateTime(Long firstSenderId, Long firstReceiverId, Long secondSenderId, Long secondReceiverId);

}
