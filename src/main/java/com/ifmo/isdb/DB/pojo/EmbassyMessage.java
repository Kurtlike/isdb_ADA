package com.ifmo.isdb.DB.pojo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.time.LocalDate;
@Service
@Getter
@Setter
@Entity
@Table(name = "embassy_messages")
@IdClass(EmbassyMessageKey.class)
public class EmbassyMessage {
    @Id
    @Column(name = "embassy_recipient_id", nullable = false)
    private int embassy_recipient_id;
    @Id
    @Lob
    @Column(name = "text", nullable = false)
    private String text;
    @Id
    @Column(name = "dispatch_time", nullable = false)
    private LocalDate dispatchTime;

}