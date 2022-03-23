package com.ifmo.isdb.DB.Service;

import com.ifmo.isdb.DB.pojo.EmbassyMessage;
import com.ifmo.isdb.DB.repos.EmbassyMessagesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.ArrayList;

@Service
@Transactional
@Repository
public class EmbassyMessagesService {
    @Autowired
    EmbassyMessagesRepo embassyMessagesRepo;
    public ArrayList<EmbassyMessage> getMessages(Integer id){
        return embassyMessagesRepo.getMessages(id);
    }
    public void addMessage(Integer id, String message){
        embassyMessagesRepo.addMessage(id, message, LocalDate.now());
    }
}
