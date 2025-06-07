package com.atguigu.test;

import com.atguigu.ioc_01.XxxDao;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringIocTest {
    @Test
    public void test01() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-01.xml");

        XxxDao bean = applicationContext.getBean(XxxDao.class);
        System.out.println("bean = " + bean);

        Object bean1 = applicationContext.getBean("xxxService");
        System.out.println("bean1 = " + bean1);

        applicationContext.close();
    }
}
