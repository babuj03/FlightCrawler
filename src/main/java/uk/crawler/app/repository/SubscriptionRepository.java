package uk.crawler.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uk.crawler.app.domain.Subscription;

import java.util.List;

@Repository
public interface SubscriptionRepository extends CrudRepository<Subscription, Long> {
 public List<Subscription> findAll();
 public Subscription findByEmailId(String emailId);
 public Subscription findByEmailToken(String emailToken);
}
