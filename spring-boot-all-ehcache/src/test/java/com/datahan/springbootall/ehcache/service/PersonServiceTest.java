package com.datahan.springbootall.ehcache.service;

import com.datahan.springbootall.ehcache.SpringBootAllEhcacheApplicationTests;
import com.datahan.springbootall.ehcache.model.Person;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @description:
 * @author: jim.han
 * @date: Created in 2019-08-22 00:10
 */
@Slf4j
public class PersonServiceTest extends SpringBootAllEhcacheApplicationTests {

    @Autowired
    private PersonService personService;

    /**
     * 获取两次，查看日志验证缓存
     */
    @Test
    public void getTwice() {
        // 模拟查询id为1的用户
        Person person1 = personService.get(1L);
        log.debug("【person1】= {}", person1);

        // 再次查询
        Person person2 = personService.get(1L);
        log.debug("【person2】= {}", person2);
        // 查看日志，只打印一次日志，证明缓存生效
    }

    /**
     * 先存，再查询，查看日志验证缓存
     */
    @Test
    public void getAfterSave() {
        personService.saveOrUpdate(new Person(4L, "person4"));

        Person person = personService.get(4L);
        log.debug("【person】= {}", person);
        // 查看日志，只打印保存用户的日志，查询是未触发查询日志，因此缓存生效
    }

    /**
     * 测试删除，查看redis是否存在缓存数据
     */
    @Test
    public void deletePerson() {
        // 查询一次，使ehcache中存在缓存数据
        Person person1 = personService.get(1L);
        log.debug("【person】= {}", person1);

        // 删除，查看ehcache是否存在缓存数据
        personService.delete(1L);
        Person person2 = personService.get(1L);
        log.debug("【person】= {}", person2);
    }
}
