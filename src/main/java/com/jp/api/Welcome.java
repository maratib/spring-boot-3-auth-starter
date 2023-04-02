package com.jp.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Welcome {

    @Value("${app.version}")
    private String version;

    @RequestMapping("/")
    String home() {
        return String.format("API : %s ", version);
    }

}
