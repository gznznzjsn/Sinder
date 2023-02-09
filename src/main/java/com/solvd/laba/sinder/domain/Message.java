package com.solvd.laba.sinder.domain;

import com.solvd.laba.sinder.domain.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "messages")
public class Message {

    @Id
    @GeneratedValue
    @Column(name = "message_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "message_sender_id", nullable = false)
    private User sender;

    @ManyToOne
    @JoinColumn(name = "message_receiver_id", nullable = false)
    private User receiver;

    @Column(name = "message_text",nullable = false)
    private String text;

    @Column(name = "message_date_time", nullable = false)
    private LocalDateTime dateTime;

}
