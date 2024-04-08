package org.fve.microservices.adminservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * The ApplicationReadyEvent is fired only after the application is ready
 * so that the above listener will execute after all the other solutions described in this article have done their work.
 */
@Component
@Order(0)
public class StartUpApplicationListener implements ApplicationListener<ApplicationReadyEvent> {

    private static final Logger logger = LoggerFactory.getLogger(StartUpApplicationListener.class);

    @Autowired
    private Environment environment;

    @Value("${startupinfo.startupLogMessageSuccess:UPM-COMPONENT STARTED}")
    private String successfulStartedUpMessage;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        logger.info("ApplicationListener#onApplicationEvent()");

        logger.info(successfulStartedUpMessage);
    }
}
