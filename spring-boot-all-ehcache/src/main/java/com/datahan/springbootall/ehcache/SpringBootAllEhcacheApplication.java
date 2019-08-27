package com.datahan.springbootall.ehcache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SpringBootAllEhcacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootAllEhcacheApplication.class, args);
    }

}
