package com.example.log4j;
import org.apache.log4j.Logger;

public class Log4JMyApp {

    final static Logger logger = Logger.getLogger(Log4JMyApp.class);

    public static void main(String[] args) {
        logger.debug("Hello world.");
        logger.info("Another message.");
        logger.error("Stop that!");
    }
}
