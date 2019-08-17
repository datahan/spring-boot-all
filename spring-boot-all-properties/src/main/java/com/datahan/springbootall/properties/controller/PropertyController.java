package com.datahan.springbootall.properties.controller;

import com.datahan.springbootall.properties.property.ApplicationProperty;
import com.datahan.springbootall.properties.property.DeveloperProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class PropertyController {
    private final ApplicationProperty applicationProperty;
    private final DeveloperProperty developerProperty;

    @Autowired
    public PropertyController(ApplicationProperty applicationProperty, DeveloperProperty developerProperty) {
        this.applicationProperty = applicationProperty;
        this.developerProperty = developerProperty;
    }

    @GetMapping("/allproperty")
    public HashMap<String, Object> allproperty() {
        HashMap<String, Object> hashMap = new HashMap<>(16);
        hashMap.put("applicationProperty", applicationProperty);
        hashMap.put("developerProperty", developerProperty);
        return hashMap;
    }
}
