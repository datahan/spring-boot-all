package com.datahan.springbootall.ehcache.service;

import com.datahan.springbootall.ehcache.model.Person;

/**
 * @description:
 * @author: jim.han
 * @date: Created in 2019-08-21 22:09
 */
public interface PersonService {

    /**
     * 保存或修改用户
     *
     * @param person 用户对象
     * @return 操作结果
     */
    Person saveOrUpdate(Person person);

    /**
     * 获取用户
     *
     * @param id key值
     * @return 返回结果
     */
    Person get(Long id);

    /**
     * 删除
     *
     * @param id key值
     */
    void delete(Long id);
}
