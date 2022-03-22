package com.ifmo.isdb.DB.pojo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import javax.persistence.*;
@Service
@Entity
@Table(name = "council_notifications")
@Getter
@Setter
@IdClass(CouncilNotificationKey.class)
public class CouncilNotification {
    @Id
    @Column(name = "council_id", nullable = false)
    private int council_id;

    @Id
    @Column(name = "notification_id", nullable = false)
    private int notification_id;

}