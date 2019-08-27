package com.datahan.springbootall.ehcache.service.impl;

import com.datahan.springbootall.ehcache.model.Person;
import com.datahan.springbootall.ehcache.service.PersonService;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @description:
 * @author: jim.han
 * @date: Created in 2019-08-21 22:49
 */
@Service
@Slf4j
public class PersonServiceImpl implements PersonService {

    /**
     * 模拟数据库
     */
    private static final Map<Long, Person> DATABASES = Maps.newConcurrentMap();

    /**
     * 初始化数据
     */
    static {
        DATABASES.put(1L, new Person(1L, "person1"));
        DATABASES.put(2L, new Person(2L, "person2"));
        DATABASES.put(3L, new Person(3L, "person3"));
    }

    /**
     * 保存或修改用户
     *
     * @param person 用户对象
     * @return 操作结果
     */
    @CachePut(value = "person", key = "#person.id")
    @Override
    public Person saveOrUpdate(Person person) {
        DATABASES.put(person.getId(), person);
        log.info("保存用户【person】= {}", person);
        return person;
    }

    /**
     * 获取用户
     *
     * @param id key值
     * @return 返回结果
     */
    @Cacheable(value = "person", key = "#id")
    @Override
    public Person get(Long id) {
        // 我们假设从数据库读取
        log.info("查询用户【id】= {}", id);
        return DATABASES.get(id);
    }

    /**
     * 删除
     *
     * @param id key值
     */
    @CacheEvict(value = "person", key = "#id")
    @Override
    public void delete(Long id) {
        DATABASES.remove(id);
        log.info("删除用户【id】= {}", id);
    }
}
