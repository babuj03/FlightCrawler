package uk.crawler.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class CrawlerApiApplication {

	public static void main(String[] args) {
		final ApplicationContext ctx = SpringApplication.run(CrawlerApiApplication.class, args);
	}
}
