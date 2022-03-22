package com.ifmo.isdb.DB.pojo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import javax.persistence.*;

@Service
@Entity
@Table(name = "embassy_applications")
@Getter
@Setter
@IdClass(EmbassyApplicationKey.class)
public class EmbassyApplication {
    @Id
    @Column(name = "embassy_id", nullable = false)
    private int embassy_id;

    @Id
    @Column(name = "application_id", nullable = false)
    private int application_id;

}