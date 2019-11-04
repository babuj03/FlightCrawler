package uk.crawler.app.util;

import java.security.SecureRandom;
import java.util.UUID;

public class TokenGenerator {

        public synchronized static  String generateToken() {
                return UUID.randomUUID().toString();
        }
}