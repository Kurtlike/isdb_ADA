package com.ifmo.isdb.DB.Service;

import com.ifmo.isdb.DB.pojo.Application;
import com.ifmo.isdb.DB.repos.ApplicationsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Service
@Transactional
@Repository
public class CouncilApplicationService {
    @Autowired
    ApplicationsRepo applicationsRepo;
    public ArrayList<Application> getApplicationsForCouncil(){
        return applicationsRepo.getApplicationsForCouncil();
    }
    public void setStatusAndResult(int id, String status, String result){
        applicationsRepo.setStatusAndResult(id, status, result);
    }
}
