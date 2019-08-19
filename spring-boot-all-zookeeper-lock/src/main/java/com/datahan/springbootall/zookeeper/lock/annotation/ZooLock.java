package com.datahan.springbootall.zookeeper.lock.annotation;

import java.lang.annotation.*;
import java.util.concurrent.TimeUnit;

/**
 * @description: 基于Zookeeper的分布式锁注解，在需要加锁的方法上打上该注解后，AOP会帮助你统一管理这个方法的锁
 * @author: jim.han
 * @date: Created in 2019-08-17 14:30
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface ZooLock {

    /**
     * 分布式锁的键
     */
    String key();

    /**
     * 获取锁等待时间，默认五秒
     */
    long timeout() default 5 * 1000;

    /**
     * 时间格式，默认：毫秒
     */
    TimeUnit timeUnit() default TimeUnit.MILLISECONDS;
}
