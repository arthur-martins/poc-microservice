package com.ms.greetingservice.configs;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

@Data
@NoArgsConstructor
@Configuration
@RefreshScope
@ConfigurationProperties("greeting-service")
public class GreetingConfig {

    private String greeting;
    private String defaultValue;
}
