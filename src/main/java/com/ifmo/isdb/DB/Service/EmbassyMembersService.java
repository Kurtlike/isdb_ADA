package com.ifmo.isdb.DB.Service;

import com.ifmo.isdb.DB.repos.EmbassyMembersRepo;
import com.ifmo.isdb.DB.repos.EmbassyMessagesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@Repository
public class EmbassyMembersService {
    @Autowired
    EmbassyMembersRepo embassyMembersRepo;
    public  Integer getMember(Integer id){
        return embassyMembersRepo.getMember(id);
    }
}
