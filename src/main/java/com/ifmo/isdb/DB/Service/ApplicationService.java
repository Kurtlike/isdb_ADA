package com.ifmo.isdb.DB.Service;

import com.ifmo.isdb.DB.DAO.ApplicationDao;
import com.ifmo.isdb.DB.DAO.CitizenDao;
import com.ifmo.isdb.DB.pojo.Application;
import com.ifmo.isdb.DB.pojo.CitadelCitizen;
import com.ifmo.isdb.DB.repos.ApplicationsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;


@Service
@Transactional
@Repository
public class ApplicationService {
    @Autowired
    ApplicationsRepo applicationsRepo;
    public Integer addApplication(Application application){
       return applicationsRepo.addApplication(application.getText(), application.getStatus());
    }
}
