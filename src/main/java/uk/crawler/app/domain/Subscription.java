package uk.crawler.app.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import uk.crawler.app.util.Frequency;
import uk.crawler.app.util.TokenGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@Setter
@ToString
@Getter
@Entity
public class Subscription extends  BaseEnity implements Serializable {
    //@Column(unique = true)
    private String emailId;
    @Enumerated(EnumType.STRING)
    private Frequency frequency;

    private Boolean active=true;

    private Boolean emailValidated=false;

    private String emailToken;



}
