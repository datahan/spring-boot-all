package com.datahan.springbootall.zookeeper.lock.controller;

import com.datahan.springbootall.zookeeper.lock.annotation.ZooLock;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: jim.han
 * @date: Created in 2019-08-17 16:27
 */
@RestController
public class TestController {

    @ZooLock(key = "cut", timeout = 5000, timeUnit = TimeUnit.MILLISECONDS)
    @GetMapping("/cut")
    public void cut() {
        System.out.println("cut start...");
        for (int i = 0; i < 200; i++) {
            for (int j = 0; j < 900000000; j++) {
                j++;
            }
            i++;
        }
        System.out.println("cut stop!");
    }
}
