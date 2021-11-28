package com.example.jul;

import java.util.logging.Logger;

public class JulMyApp {

    final static Logger logger = Logger.getLogger("JulMyApp");

    public static void main(String[] args) {
        logger.warning("Hello world.");
        logger.info("Another message.");
    }
}
