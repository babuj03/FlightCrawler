package uk.crawler.app.util;

public  enum Messages {

    EMAIL_ALREADY_FOUND("1","Email is already found"),
    INVALID_EMAIL("2","Invalid email"),
    INVALID_SOURCE("2","Invalid source"),
    INVALID_DESTINATION("3","Invalid Destination");

    private final String code;
    private final String description;

    private Messages(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public String getCode() {
        return code;
    }

    @Override
    public String toString() {
        return code + ": " + description;
    }
}
