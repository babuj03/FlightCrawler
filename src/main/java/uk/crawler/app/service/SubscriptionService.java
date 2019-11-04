package uk.crawler.app.service;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import uk.crawler.app.domain.Subscription;
import uk.crawler.app.dto.SubscriptionDTO;
import uk.crawler.app.exception.CrawlerException;
import uk.crawler.app.repository.SubscriptionRepository;
import uk.crawler.app.util.Email;
import uk.crawler.app.util.Messages;
import uk.crawler.app.util.TokenGenerator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class  SubscriptionService {

    private final SubscriptionRepository crawlerRepository;
    private static Logger logger = LoggerFactory.getLogger(SubscriptionService.class);
    private final Email email;

    public SubscriptionService(SubscriptionRepository crawlerRepository, Email email)  {
        this.crawlerRepository = crawlerRepository;
        this.email = email;
    }

    public void subscribe(SubscriptionDTO subscriptionDTO) throws CrawlerException {
        if(findByEmail(subscriptionDTO.getEmailId())!=null){
            throw new CrawlerException(Messages.EMAIL_ALREADY_FOUND);
        }

        if(!validateEmail(subscriptionDTO.getEmailId())){
            throw new CrawlerException(Messages.INVALID_EMAIL);
        }

        if(!valiwdateAirPortName(subscriptionDTO.getOrigin())){
            throw new CrawlerException(Messages.INVALID_SOURCE);
        }

        if(!valiwdateAirPortName(subscriptionDTO.getDestination())){
            throw new CrawlerException(Messages.INVALID_DESTINATION);
        }

        ModelMapper modelMapper = new ModelMapper();
        Subscription subscription = modelMapper.map(subscriptionDTO, Subscription.class);
        subscription.setEmailToken(TokenGenerator.generateToken());
        crawlerRepository.save(subscription);
        sendEmail(subscription.getEmailId(), subscription.getEmailToken());
    }

    public void sendEmail(String toEmailId, String emailToken)  {
        logger.info("sending confirmation");
        logger.info("From Email "+email.getFromEmail()+"\n"+
                "To Email "+ toEmailId+"\n"+
                "Subject " +email.getSubject()+"\n"+
                "content "+ email.getContent()+"\n" +email.getUrl()+emailToken);
    }

    public void sendBulkEmail()  {
        // fetch all user who need notification.
        // read save flightinfo  and send email
        logger.info("sending confirmation");
        logger.info("From Email "+email.getFromEmail()+"\n"+
                "To Email <<from DB >>\n"+
                "Subject flight offer\n"+
                "content  offer content \n");
    }

    public void activateEmailAfterConfirm(String emailToken)  {
        logger.info("sending confirmation");
         Subscription subscription= crawlerRepository.findByEmailToken(emailToken);
         subscription.setEmailValidated(true);
         crawlerRepository.save(subscription);
    }

    public Subscription findByEmail(String emailId){
        return crawlerRepository.findByEmailId(emailId);
    }


    private boolean validateEmail(String email) {
        String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return  matcher.matches();
    }


    private boolean valiwdateAirPortName(String airportName) {
        return  airportName.matches("[a-zA-Z]{3}");
    }

    public Subscription getSubscription(String emailId) throws CrawlerException {
        if(!validateEmail(emailId)){
            throw new CrawlerException(Messages.INVALID_EMAIL);
        }
        return findByEmail(emailId);
    }


}
