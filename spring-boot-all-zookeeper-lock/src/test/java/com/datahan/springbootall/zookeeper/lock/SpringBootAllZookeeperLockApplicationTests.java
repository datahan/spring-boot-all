package com.datahan.springbootall.zookeeper.lock;

import com.datahan.springbootall.zookeeper.lock.annotation.ZooLock;
import com.datahan.springbootall.zookeeper.lock.aspectj.ZooLockAspect;
import lombok.extern.slf4j.Slf4j;
import org.apache.curator.framework.CuratorFramework;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class SpringBootAllZookeeperLockApplicationTests {

    public Integer getCount() {
        return count;
    }

    private Integer count = 20;
    private ExecutorService executorService = Executors.newFixedThreadPool(1);

    @Autowired
    private CuratorFramework zkClient;

    /**
     * 不使用分布式锁，程序结束查看count的值是否为0
     */
    /*@Test
    public void test() throws InterruptedException {
        IntStream.range(0, 10000).forEach(i -> executorService.execute(this::doBuy));
        TimeUnit.MINUTES.sleep(1);
        log.error("count值为{}", count);
    }*/

    /**
     * 测试AOP分布式锁
     */
    @Test
    public void testAopLock() throws InterruptedException {
        // 测试类中使用AOP需要手动代理
        SpringBootAllZookeeperLockApplicationTests target = new SpringBootAllZookeeperLockApplicationTests();
        AspectJProxyFactory factory = new AspectJProxyFactory(target);
        ZooLockAspect aspect = new ZooLockAspect(zkClient);
        factory.addAspect(aspect);
        SpringBootAllZookeeperLockApplicationTests proxy = factory.getProxy();
        IntStream.range(0, 20).forEach(i -> executorService.execute(() -> proxy.aopBuy(i)));
        TimeUnit.MINUTES.sleep(1);
        log.error("count值为{}", proxy.getCount());
    }

    @ZooLock(key = "buy", timeout = 3, timeUnit = TimeUnit.SECONDS)
    public void aopBuy(int userId) {
        log.info("{} 正在出库。。。", userId);
        doBuy();
        log.info("{} 扣库存成功。。。", userId);
    }

    public void doBuy() {
        count--;
        log.info("count值为{}", count);
    }
}
