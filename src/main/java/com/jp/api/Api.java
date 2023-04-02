package com.jp.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class Api {

    @GetMapping("/path/{first}/{second}")
    public String pathVariable(@PathVariable String first, @PathVariable String second) {

        return String.format("API : First:%s Second:%s ", first, second);
    }

}