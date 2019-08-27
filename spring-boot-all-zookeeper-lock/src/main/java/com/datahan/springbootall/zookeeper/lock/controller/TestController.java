package com.datahan.springbootall.zookeeper.lock.controller;

import com.datahan.springbootall.zookeeper.lock.annotation.LockKeyParam;
import com.datahan.springbootall.zookeeper.lock.annotation.ZooLock;
import com.datahan.springbootall.zookeeper.lock.model.Person;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    public ResponseEntity cut(@LockKeyParam String sort) {
        System.out.println("cut start...");
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("cut stop!");
        return new ResponseEntity<>("cut 成功", HttpStatus.OK);
    }

    @ZooLock(key = "add", timeout = 2000, timeUnit = TimeUnit.MILLISECONDS)
    @PostMapping("/add")
    public ResponseEntity addPerson(@RequestBody @LockKeyParam(fields = {"id"}) Person person) {

        System.out.println("进入addPerson方法");

        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("add 成功", HttpStatus.OK);
    }
}
