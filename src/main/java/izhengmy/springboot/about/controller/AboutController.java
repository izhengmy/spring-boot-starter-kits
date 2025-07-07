package izhengmy.springboot.about.controller;

import izhengmy.springboot.about.response.AboutResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class AboutController {

    @Value("${spring.application.name}")
    private String app;

    private final Environment environment;

    @GetMapping(value = "/api/abouts")
    public AboutResponse about() {
        String environment = this.environment.getActiveProfiles()[0];

        return AboutResponse.builder()
                .app(app)
                .environment(environment)
                .build();
    }

}
