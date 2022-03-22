package com.ifmo.isdb.DB.Service;

import com.ifmo.isdb.DB.pojo.Application;
import com.ifmo.isdb.DB.repos.ApplicationsRepo;
import com.ifmo.isdb.DB.repos.CitizenApplicationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Service
@Transactional
@Repository
public class CitizenApplicationService {
    @Autowired
    CitizenApplicationRepo citizenApplicationRepo;
    @Autowired
    ApplicationsRepo applicationsRepo;
    public void addCitizenApplication(int citizen_id, int applications_id ){
        citizenApplicationRepo.addCitizenApplication(citizen_id, applications_id);
    }
    public ArrayList<Application> getApplications(Integer citizenId){
        return  applicationsRepo.getApplications(citizenId);
    }
}
