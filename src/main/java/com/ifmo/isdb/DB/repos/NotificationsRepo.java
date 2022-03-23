package com.ifmo.isdb.DB.repos;

import com.ifmo.isdb.DB.pojo.Application;
import com.ifmo.isdb.DB.pojo.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;

public interface NotificationsRepo  extends JpaRepository<Notification,Integer> {
    @Query(value = "SELECT * from notifications",nativeQuery=true)
    ArrayList<Notification> getNotifications();
    @Modifying
    @Query(value = "insert into notifications (text) values (:text)",nativeQuery=true)
    void addNotification(String text);
}
