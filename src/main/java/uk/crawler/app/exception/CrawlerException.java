package uk.crawler.app.exception;

import uk.crawler.app.util.Messages;

public class CrawlerException extends Exception {
    String message;
    String messageCode;
    public CrawlerException(Messages message){
      this.message = message.getDescription();
      this.messageCode = message.getCode();
    }
    public CrawlerException(String message, String messageCode){
        this.messageCode = messageCode;
    }
}
