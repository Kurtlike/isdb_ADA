package com.ifmo.isdb.DB.pojo;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Service;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Lob;
import java.io.Serializable;
import java.time.LocalDate;

@Service
@EqualsAndHashCode
@ToString
@Getter
@Setter
public class EmbassyMessageKey implements Serializable {
    private static final long serialVersionUID = 7063787474085184326L;
    @Id
    private int embassy_recipient_id;
    @Id
    private String text;
    @Id
    private LocalDate dispatchTime;
}
