package com.ifmo.isdb.DB.pojo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import javax.persistence.*;

@Service
@Entity
@Table(name = "citadel_citizen")
@Getter
@Setter
public class CitadelCitizen {
    protected CitadelCitizen(){}
    public CitadelCitizen(String login, String pass) {
        this.login = login;
        this.password = pass;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "permission", nullable = false)
    private Integer permission;

    @Column(name = "login", nullable = false, length = 15)
    private String login;

    @Column(name = "password", nullable = false, length = 15)
    private String password;

    @Column(name = "name", nullable = false, length = 30)
    private String name;

    @Column(name = "race", nullable = false, length = 30)
    private String race;

    @Column(name = "notifications_id")
    private Integer notificationsId;


}