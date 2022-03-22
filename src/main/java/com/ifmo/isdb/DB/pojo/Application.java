package com.ifmo.isdb.DB.pojo;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.springframework.stereotype.Service;

import javax.persistence.*;
@Service
@Entity
@Table(name = "application")
@Getter
@Setter
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Lob
    @Type(type = "org.hibernate.type.TextType")
    @Column(name = "text", nullable = false)
    private String text;

    @Lob
    @Type(type = "org.hibernate.type.TextType")
    @Column(name = "status", nullable = false, length = 30)
    private String status;

    @Lob
    @Type(type = "org.hibernate.type.TextType")
    @Column(name = "result")
    private String result;
}