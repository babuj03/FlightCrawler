package uk.crawler.app.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import uk.crawler.app.util.Frequency;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@Setter
@ToString
@Getter
public class SubscriptionDTO implements Serializable {
    private Long id;

    @Column(length = 50)
    @NotBlank(message = "Email is mandatory")
    private String emailId;

    @Column(length = 50)
    @NotBlank(message = "Origin is mandatory")
    private String origin;

    @Column(length = 50)
    @NotBlank(message = "Destination is mandatory")
    private String destination;

    @Enumerated(EnumType.STRING)
    private Frequency frequency;

    private Boolean active=true;

    private LocalDate createDate = LocalDate.now();


}
