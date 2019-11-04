package uk.crawler.app.domain;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@MappedSuperclass
public class BaseEnity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String origin;

    private String destination;

    private LocalDateTime createDate = LocalDateTime.now();
}
