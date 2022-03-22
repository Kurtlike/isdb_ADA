package com.ifmo.isdb.DB.pojo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import javax.persistence.*;
@Service
@Entity
@Table(name = "council_members")
@Getter
@Setter
@IdClass(CouncilMemberKey.class)
public class CouncilMember {
    @Id
    @Column(name = "council_id", nullable = false)
    private int council_id;

    @Id
    @Column(name = "member_id", nullable = false)
    private int member_id;

    @Column(name = "member_mode")
    private int member_mode;

}