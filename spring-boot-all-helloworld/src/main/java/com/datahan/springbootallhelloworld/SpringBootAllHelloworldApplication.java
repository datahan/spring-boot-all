package com.datahan.springbootallhelloworld;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

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

        return "Hello, " + who + "!";
    }

    @GetMapping(value = "/rest", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public String sayRest() throws JsonProcessingException {
        final String url = "http://localhost:8090/add";

        RestTemplate restTemplate = new RestTemplate();

        Map<String, Object> parts = new HashMap<>();
        parts.put("age", 18);
        parts.put("name", "小芳");
        parts.put("address", "广东深圳");

        return restTemplate.postForObject(url, parts, String.class);
    }
}
