package io.nozemi.runescape.service.login;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoginWorker implements Runnable {

    private static final Logger logger = LogManager.getLogger(LoginWorker.class);

    @Override
    public void run() {
        while(true) {
            try {
                processLoginJob();
            } catch(Exception e) {
                logger.error("Error processing login worker job!", e);
            }
        }
    }

    private void processLoginJob() {

    }
}
