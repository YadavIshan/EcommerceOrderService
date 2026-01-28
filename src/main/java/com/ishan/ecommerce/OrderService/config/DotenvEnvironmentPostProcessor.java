package com.ishan.ecommerce.OrderService.config;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;

import java.util.HashMap;
import java.util.Map;

public class DotenvEnvironmentPostProcessor implements EnvironmentPostProcessor {

    private static final String DOTENV_PROPERTY_SOURCE_NAME = "dotenvProperties";

    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
        // Load .env file.
        Dotenv dotenv = Dotenv.configure()
                .ignoreIfMissing()
                .load();

        Map<String, Object> envMap = new HashMap<>();
        for (var entry : dotenv.entries()) {
            envMap.put(entry.getKey(), entry.getValue());
        }

        // Add the .env properties to the environment
        if (!envMap.isEmpty()) {
            environment.getPropertySources().addLast(new MapPropertySource(DOTENV_PROPERTY_SOURCE_NAME, envMap));
        }
    }
}
