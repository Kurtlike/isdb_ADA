package com.ifmo.isdb.DB.pojo;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Service;

import javax.persistence.Id;
import java.io.Serializable;

@Service
@EqualsAndHashCode
@ToString
@Getter
@Setter
public class EmbassyApplicationKey implements Serializable {
    private static final long serialVersionUID = 7063787474085184326L;
    @Id
    private int embassy_id;

    @Id
    private int application_id;;

}