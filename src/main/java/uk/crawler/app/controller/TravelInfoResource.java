package uk.crawler.app.controller;

import com.sipios.springsearch.anotation.SearchSpec;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uk.crawler.app.domain.TravelInfo;
import uk.crawler.app.dto.SubscriptionDTO;
import uk.crawler.app.dto.TravelInfoDTO;
import uk.crawler.app.exception.CrawlerException;
import uk.crawler.app.service.SubscriptionService;
import uk.crawler.app.service.TravelInfoService;

import java.awt.*;
import java.time.LocalDate;
import java.util.List;

/**
 * REST controller for managing {@link TravelInfoResource }.
 */
@RestController
@RequestMapping("api/v1/")
public class  TravelInfoResource {
    private final Logger log = LoggerFactory.getLogger(TravelInfoResource.class);
    TravelInfoService travelInfoService;
    public TravelInfoResource(TravelInfoService travelInfoService) {
        this.travelInfoService = travelInfoService ;
    }

    @PostMapping(path = "/save/travel-info")
    public ResponseEntity<String> saveTravelInfo(@RequestBody TravelInfoDTO travelInfoDTO) throws CrawlerException {
       travelInfoService.saveTravelInfo(travelInfoDTO);
       return ResponseEntity.ok().build();
    }

    @GetMapping(path="/search")
    public ResponseEntity<List<TravelInfo>> getTravelnfo(@SearchSpec Specification<TravelInfo> specs) throws CrawlerException {
        return ResponseEntity.ok().body(travelInfoService.search(specs));
    }


}
