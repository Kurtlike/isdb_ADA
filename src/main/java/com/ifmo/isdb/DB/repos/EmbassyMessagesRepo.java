package com.ifmo.isdb.DB.repos;

import com.ifmo.isdb.DB.pojo.Application;
import com.ifmo.isdb.DB.pojo.EmbassyMessage;
import com.ifmo.isdb.DB.pojo.EmbassyMessageKey;
import com.ifmo.isdb.DB.pojo.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.ArrayList;

public interface EmbassyMessagesRepo  extends JpaRepository<EmbassyMessage, EmbassyMessageKey> {
    @Query(value = "SELECT * from embassy_messages where embassy_recipient_id =:id", nativeQuery = true)
    ArrayList<EmbassyMessage> getMessages(Integer id);

    @Modifying
    @Query(value = "Insert into embassy_messages values (:id, :message, :time)", nativeQuery = true)
    void addMessage(Integer id, String message, LocalDate time);
}