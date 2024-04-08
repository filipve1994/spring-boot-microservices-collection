package org.fve.microservices.gatewayservice.config;

import com.google.common.collect.Lists;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Getter
@Setter
@ToString
@Component
@ConfigurationProperties("cors")
public class CorsProperties {

    private List<String> allowedOrigins = Lists.newArrayList("*");
    private List<String> allowedHeaders = Lists.newArrayList("*");
    private List<String> allowedMethods = Lists.newArrayList("*");

}