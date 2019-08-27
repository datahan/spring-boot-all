package com.datahan.springbootall.ehcache.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @description:
 * @author: jim.han
 * @date: Created in 2019-08-21 22:06
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person implements Serializable {

    private static final long serialVersionUID = 6576774586396296398L;

    private Long id;
    private String name;
}
