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
}
