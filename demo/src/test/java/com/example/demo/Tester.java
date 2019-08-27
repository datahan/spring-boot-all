package com.example.demo;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @description:
 * @author: jim.han
 * @date: Created in 2019-08-24 14:58
 */
public class Tester {

    /**
     * Map接口
     * HashMap 和 LinkedHashMap 的键或值允许是null， TreeMap不可以
     */
    @Test
    public void map() {
        Map<Object, Object> hashMap = new HashMap<>();
        hashMap.put(null, "abc");
        hashMap.put("uvw", null);
        System.out.println(hashMap);

        Set<Map.Entry<Object, Object>> entries = hashMap.entrySet();
        for (Map.Entry<Object, Object> entry : entries) {
            System.out.print(entry.getKey() + ":");
            System.out.println(entry.getValue());
        }
    }
}
