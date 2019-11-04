package uk.crawler.app.service;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import uk.crawler.app.domain.TravelInfo;
import uk.crawler.app.dto.TravelInfoDTO;
import uk.crawler.app.exception.CrawlerException;
import uk.crawler.app.repository.TravelInfoRepository;

import java.util.List;

@Service
public class    TravelInfoService {
    private final TravelInfoRepository travelInfoRepository;
    private static Logger logger = LoggerFactory.getLogger(SubscriptionService.class);

    public TravelInfoService(TravelInfoRepository travelInfoRepository ) {
        this.travelInfoRepository = travelInfoRepository;
    }

    public void saveTravelInfo(TravelInfoDTO travelInfoDTO) throws CrawlerException {
        ModelMapper modelMapper = new ModelMapper();
        TravelInfo travelInfo= modelMapper.map(travelInfoDTO, TravelInfo.class);
        travelInfoRepository.save(travelInfo);
    }

    public List<TravelInfo> search(Specification<TravelInfo> specs) {
         return  travelInfoRepository.findAll();
    }

}
