package com.example.basiccrud.utills;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogTest {

    private final static Logger log = LoggerFactory.getLogger(LogTest.class);

    public void run() {
        log.trace("trace!!!!!");
        log.debug("debug!!!!");
        log.info("info!!!!!");
        log.warn("warn!!!!!");
        log.error("error!!!!");
    }

    public static void main(String[] args) {
        new LogTest().run();
    }
}
