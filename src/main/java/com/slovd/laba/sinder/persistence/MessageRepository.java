package com.slovd.laba.sinder.persistence;

import com.slovd.laba.sinder.domain.Message;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends CrudRepository<Message, Long> {

//    List<Message> findAll(Long userId, Long pairId);

//    void create(Message message);

}
