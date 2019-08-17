package com.datahan.springbootallhelloworld;

import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@SpringBootApplication
@RestController
public class SpringBootAllHelloworldApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootAllHelloworldApplication.class, args);
    }

    @GetMapping("/hello")
    public String sayHello(@RequestParam(required = false, name = "who") String who) {

        if (StringUtils.isBlank(who)) {
            who = "World";
        }

        return "Hello, " + who + "!" ;
    }
}
