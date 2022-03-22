package com.ifmo.isdb.DB.repos;

import com.ifmo.isdb.DB.pojo.Application;
import com.ifmo.isdb.DB.pojo.CitizenApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;

public interface CitizenApplicationRepo extends JpaRepository<CitizenApplication,Long> {
    @Modifying
    @Query(value = "INSERT into citizen_applications (citizen_id, applications_id) VALUES (:citizen_id, :applications_id)",nativeQuery=true)
    void addCitizenApplication(int citizen_id, int applications_id);
}
