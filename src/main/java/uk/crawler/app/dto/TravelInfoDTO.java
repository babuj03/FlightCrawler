package uk.crawler.app.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.Data;

import javax.persistence.Entity;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class TravelInfoDTO  {
    private float price;
    private String flightNumber;
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize (using = LocalDateSerializer.class)
    private LocalDate travelDate;
    private String origin;
    private String destination;

}
