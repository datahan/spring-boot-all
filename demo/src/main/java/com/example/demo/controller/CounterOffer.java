package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@RestController
public class CounterOffer {

    @PostMapping("/add")
    public String add(@RequestBody Map<String, Object> params) {

        Set<Map.Entry<String, Object>> entries = params.entrySet();
        Iterator<Map.Entry<String, Object>> iterator =
                entries.iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Object> ent = iterator.next();
            System.out.println(ent.getKey() + "===>" + ent.getValue());
        }
        return "over";
    }

    @GetMapping("/mind")
    public String mind(@RequestParam Map<String, String> params) {
        return "finish";
    }
}
