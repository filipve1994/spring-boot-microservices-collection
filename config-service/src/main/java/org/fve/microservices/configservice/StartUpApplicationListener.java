package org.fve.microservices.configservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private final Environment environment;

    @Value("${startupinfo.startupLogMessageSuccess:UPM-COMPONENT STARTED}")
    private String successfulStartedUpMessage;

    public StartUpApplicationListener(Environment environment) {
        this.environment = environment;
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {

        logger.info("ApplicationListener#onApplicationEvent()");

        logger.info(successfulStartedUpMessage);

        String projectFinalName = logEnvironmentProperties(environment);

        logger.info(projectFinalName.toUpperCase() + " project start success...........");
        logger.info("\n{}", getStartSuccessMessage());

    }

    private static String getStartSuccessMessage() {
        return """
                 ____    __                    __        ____                                                  \s
                /\\  _`\\ /\\ \\__                /\\ \\__    /\\  _`\\                                                \s
                \\ \\,\\L\\_\\ \\ ,_\\    __     _ __\\ \\ ,_\\   \\ \\,\\L\\_\\  __  __    ___    ___     __    ____    ____ \s
                 \\/_\\__ \\\\ \\ \\/  /'__`\\  /\\`'__\\ \\ \\/    \\/_\\__ \\ /\\ \\/\\ \\  /'___\\ /'___\\ /'__`\\ /',__\\  /',__\\\s
                   /\\ \\L\\ \\ \\ \\_/\\ \\L\\.\\_\\ \\ \\/ \\ \\ \\_     /\\ \\L\\ \\ \\ \\_\\ \\/\\ \\__//\\ \\__//\\  __//\\__, `\\/\\__, `\\
                   \\ `\\____\\ \\__\\ \\__/.\\_\\\\ \\_\\  \\ \\__\\    \\ `\\____\\ \\____/\\ \\____\\ \\____\\ \\____\\/\\____/\\/\\____/
                    \\/_____/\\/__/\\/__/\\/_/ \\/_/   \\/__/     \\/_____/\\/___/  \\/____/\\/____/\\/____/\\/___/  \\/___/\s
                                                                                                               \s
                                                                                                               \s""";
    }

    private String logEnvironmentProperties(Environment environment) {

        // project name
        String projectFinalName = environment.getProperty("spring.application.name");
//        notNull(projectFinalName, "spring.application.name cannot be null");
        logger.info("projectFinalName : {}", projectFinalName);

        // Project version
        String projectVersion = environment.getProperty("application.version");
        logger.info("projectVersion : {}", projectVersion);

        // Project profile
        String profileActive = environment.getProperty("spring.profiles.active");
        logger.info("profileActive : {}", profileActive);

        // Project path
        String contextPath = environment.getProperty("server.servlet.context-path");
        contextPath = (contextPath != null) ? contextPath : "/";
        logger.info("contextPath : {}", contextPath);

        // Project port
        String port = environment.getProperty("server.port");
        logger.info("port : {}", port);

        // Server address
        String serverAddress = environment.getProperty("server.address");
        logger.info("serverAddress : {}", serverAddress);

        // homeUrl
        String homeUrl = "http://" + serverAddress + ":" + port + contextPath;
        logger.info("home: {}", homeUrl);

        // Springdoc Swagger
        String springdocSwaggerUiPathUrl = environment.getProperty("springdoc.swagger-ui.path");
        if (springdocSwaggerUiPathUrl != null) {
            String swaggerUrl = "http://" + serverAddress + ":" + port + contextPath + springdocSwaggerUiPathUrl;
            logger.info("docs: {}", swaggerUrl);
        } else {
            logger.info("docs: {}", "There is no swagger in this project.");
        }

        return projectFinalName;
    }
}
