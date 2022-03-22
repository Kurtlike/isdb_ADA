package com.ifmo.isdb.DB.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Service;

import javax.persistence.*;
@Service
@ToString
@Entity
@Table(name = "citizen_applications")
@Getter
@Setter
@IdClass(CitizenApplicationKey.class)
public class CitizenApplication {
    @Id
    private int citizen_id;
    @Id
    private int applications_id;
}