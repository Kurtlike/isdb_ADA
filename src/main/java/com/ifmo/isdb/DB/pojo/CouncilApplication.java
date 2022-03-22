package com.ifmo.isdb.DB.pojo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import javax.persistence.*;
@Service
@Entity
@Table(name = "council_application")
@IdClass(CouncilApplicationKey.class)
@Getter
@Setter
public class CouncilApplication {
    @Id
    @Column(name = "council_id")
    private int council_id;

    @Id
    @Column(name = "application_id")
    private int application;

    @Column(name = "application_status", length = 30)
    private String application_status;

}