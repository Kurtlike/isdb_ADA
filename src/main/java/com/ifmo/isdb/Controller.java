package com.ifmo.isdb;

import com.ifmo.isdb.DB.Service.*;
import com.ifmo.isdb.DB.pojo.Application;
import com.ifmo.isdb.DB.pojo.CitadelCitizen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class Controller {
    @Autowired
    CitizenService citizenService;
    @Autowired
    ApplicationService applicationService;
    @Autowired
    CitizenApplicationService citizenApplicationService;
    @Autowired
    Answer answer;
    @Autowired
    EmbassyApplicationService embassyApplicationService;
    @Autowired
    CouncilApplicationService councilApplicationService;

    @PostMapping(value = "/adduser")
    public void addNewUser(@RequestBody CitadelCitizen citizen) {
        if(!citizenService.isCitizen(citizen.getLogin())&&citizen.getLogin().indexOf(" ")==-1) {
            System.out.println(citizen.getPassword());
            this.citizenService.addCitizen(citizen);
        }
    }

    @PostMapping(value = "/sentCitizenApplication")
    public void sentCitizenApp(@RequestBody Application application) {
        String login= SecurityContextHolder.getContext().getAuthentication().getName();
        CitadelCitizen citizen = citizenService.getCitizen(login);
        int app_id = applicationService.addApplication(application);
        citizenApplicationService.addCitizenApplication(citizen.getId(), app_id);
    }
    @GetMapping(value = "/getCitizenApplications")
    public ArrayList<Application> getCitizenApp() {
        String login= SecurityContextHolder.getContext().getAuthentication().getName();
        CitadelCitizen citizen = citizenService.getCitizen(login);
        return citizenApplicationService.getApplications(citizen.getId());
    }
    @GetMapping(value = "/getCitizenApplicationsForEmbassy")
    public ArrayList<Application> getCitizenApplicationsForEmbassy() {
        String login= SecurityContextHolder.getContext().getAuthentication().getName();
        CitadelCitizen citizen = citizenService.getCitizen(login);
        return embassyApplicationService.getApplicationsForEmbassy(citizen.getRace());
    }

    @PostMapping(value = "/setStatusAndResult")
    public void setStatusAndResult(@RequestBody Application application) {
        embassyApplicationService.setStatusAndResult(application.getId(),application.getStatus(),application.getResult());
    }
    @GetMapping(value = "/getCitizenApplicationsForCouncil")
    public ArrayList<Application> getCitizenApplicationsForCouncil() {
        return councilApplicationService.getApplicationsForCouncil();
    }
}
