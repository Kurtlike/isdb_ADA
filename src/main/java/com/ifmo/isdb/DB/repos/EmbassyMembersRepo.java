package com.ifmo.isdb.DB.repos;

import com.ifmo.isdb.DB.pojo.EmbassyMember;
import com.ifmo.isdb.DB.pojo.EmbassyMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;

public interface EmbassyMembersRepo extends JpaRepository<EmbassyMember,Integer> {
    @Query(value = "SELECT embassy_id from embassy_members where member_id = :id", nativeQuery = true)
    Integer getMember(Integer id);
}
