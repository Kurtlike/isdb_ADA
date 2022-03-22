package com.ifmo.isdb.DB.pojo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "embassy_members")
@Getter
@Setter
@IdClass(EmbassyMemberKey.class)
public class EmbassyMember {
    @Id
    @Column(name = "embassy_id", nullable = false)
    private int embassy_id;
    @Id
    @Column(name = "member_id", nullable = false)
    private int member_id;

    @Column(name = "member_mode")
    private int member_mode;

}