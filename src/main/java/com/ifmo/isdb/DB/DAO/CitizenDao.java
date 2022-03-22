package com.ifmo.isdb.DB.DAO;

import com.ifmo.isdb.DB.pojo.CitadelCitizen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CitizenDao extends JpaRepository<CitadelCitizen,Integer> {
}
