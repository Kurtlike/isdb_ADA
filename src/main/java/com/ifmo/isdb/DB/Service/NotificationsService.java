package com.ifmo.isdb.DB.Service;

import com.ifmo.isdb.DB.pojo.Notification;
import com.ifmo.isdb.DB.repos.NotificationsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
@Service
@Transactional
@Repository
public class NotificationsService {
    @Autowired
    NotificationsRepo notificationsRepo;

    public ArrayList<Notification> getNotifications(){
        return notificationsRepo.getNotifications();
    }
    public void addNotification(String text){
        notificationsRepo.addNotification(text);
    }
}
