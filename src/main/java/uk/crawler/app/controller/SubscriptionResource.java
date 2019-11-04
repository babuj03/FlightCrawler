package uk.crawler.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uk.crawler.app.dto.SubscriptionDTO;
import uk.crawler.app.exception.CrawlerException;
import uk.crawler.app.service.SubscriptionService;

/**
 * REST controller for managing {@link SubscriptionResource }.
 */
@RestController
@RequestMapping("api/v1/crawler")
public class SubscriptionResource {
    private final Logger log = LoggerFactory.getLogger(SubscriptionResource.class);

    SubscriptionService subscriptionService;
    public SubscriptionResource(SubscriptionService subscriptionService) {
        this.subscriptionService= subscriptionService;
    }

   @PostMapping(path = "/subscribe")
    public ResponseEntity<String> subscription(@RequestBody SubscriptionDTO subscriptionDTO) throws CrawlerException {
       subscriptionService.subscribe(subscriptionDTO);
        return ResponseEntity.ok().build();
    }

}
