package com.datahan.springbootall.zookeeper.lock.model;

/**
 * @description:
 * @author: jim.han
 * @date: Created in 2019-08-20 14:21
 */
public class Person {

    private Integer id;
    private String name;

    public Person() {
    }

    public Person(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}