package uk.crawler.app.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uk.crawler.app.domain.TravelInfo;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TravelInfoRepository extends CrudRepository<TravelInfo, Long>, JpaSpecificationExecutor<TravelInfo> {
    public List<TravelInfo> findAll();
    @Query("SELECT t FROM  TravelInfo t WHERE t.flightNumber = ?1 AND t.travelDate = ?2 AND t.origin =?3 AND t.destination = ?4")
    public TravelInfo findByFlightNumberANDTravelDateANDOriginANDDestination(String flightNumner, LocalDate travelDate, String origin, String destination);
}
