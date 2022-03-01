package com.ms.greetingservice.controllers;

import com.ms.greetingservice.configs.GreetingConfig;
import com.ms.greetingservice.models.Greeting;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping(value = "/greeting")
public class GreetingController {

    private final GreetingConfig greetingConfig;

    private static final String template = "%s, %s";
    private final AtomicLong counter = new AtomicLong();

    public GreetingController(GreetingConfig greetingConfig) {
        this.greetingConfig = greetingConfig;
    }

    @GetMapping
    public Greeting greeting() {
        return new Greeting(counter.incrementAndGet(),
                String.format(template, greetingConfig.getGreeting(), greetingConfig.getDefaultValue()));
    }
}
