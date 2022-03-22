package com.ifmo.isdb.DB.repos;

import com.ifmo.isdb.DB.pojo.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;

public interface ApplicationsRepo extends JpaRepository<Application,Integer> {

    @Query(value = "INSERT into application (text, status) VALUES (:text, :status) RETURNING id",nativeQuery=true)
    Integer addApplication(String text, String status);

    @Query(value = "SELECT id, text, status, result FROM application join citizen_applications  on citizen_applications.applications_id = application.id where citizen_applications.citizen_id = :citizenId",nativeQuery=true)
    ArrayList<Application> getApplications(Integer citizenId);

    @Query(value = "SELECT application.id, text, status, result FROM application join citizen_applications ca on application.id = ca.applications_id join citadel_citizen cc on ca.citizen_id = cc.id where cc.race = :race ",nativeQuery=true)
    ArrayList<Application> getApplicationsForEmbassy(String race);

    @Modifying
    @Query(value = "UPDATE application set status =:status, result=:result WHERE id=:id",nativeQuery=true)
    void setStatusAndResult(int id, String status, String result);

    @Query(value = "SELECT application.id, text, status, result FROM application where status = 'councilConsideration'",nativeQuery=true)
    ArrayList<Application> getApplicationsForCouncil();
}
