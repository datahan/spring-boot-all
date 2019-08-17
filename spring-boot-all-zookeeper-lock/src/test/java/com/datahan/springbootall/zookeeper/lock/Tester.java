package com.datahan.springbootall.zookeeper.lock;

import org.junit.Test;

import java.util.stream.IntStream;

/**
 * @description:
 * @author: jim.han
 * @date: Created in 2019-08-17 15:35
 */
public class Tester {

    @Test
    public void stream() {
        IntStream.range(0, 10000).forEach(i -> System.out.println(i + "oo"));
    }
}
