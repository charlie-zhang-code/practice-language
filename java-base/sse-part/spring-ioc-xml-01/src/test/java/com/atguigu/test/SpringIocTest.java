package com.atguigu.test;

import com.atguigu.ioc_03.HappyComponent;
import com.atguigu.ioc_04.JavaBean2;
import com.atguigu.ioc_04.JavaBean3;
import com.atguigu.ioc_05.JavaBean;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringIocTest {
    public void createIoc() {
        //方式1:实例化并且指定配置文件
        //参数：String...locations 传入一个或者多个配置文件
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-03.xml");

        //方式2:先实例化，再指定配置文件，最后刷新容器触发Bean实例化动作 [springmvc源码和contextLoadListener源码方式]
        ClassPathXmlApplicationContext applicationContext1 = new ClassPathXmlApplicationContext();
        //设置配置配置文件,方法参数为可变参数,可以设置一个或者多个配置
        applicationContext1.setConfigLocations("spring-03.xml");
        //后配置的文件,需要调用refresh方法,触发刷新配置
        applicationContext1.refresh();
    }

    @Test
    public void getBeanFromIoc() {
        ClassPathXmlApplicationContext applicationContext1 = new ClassPathXmlApplicationContext();
        applicationContext1.setConfigLocations("spring-03.xml");
        applicationContext1.refresh();

        //方式1: 根据id获取
        //没有指定类型,返回为Object,需要类型转化!(不推荐)
        HappyComponent happyComponent1 = (HappyComponent) applicationContext1.getBean("happyComponent01");
        //使用组件对象
        happyComponent1.doWork();

        //方式2: 根据类型获取
        //根据类型获取,但是要求,同类型(当前类,或者之类,或者接口的实现类)只能有一个对象交给IoC容器管理
        //配置两个或者以上出现: org.springframework.beans.factory.NoUniqueBeanDefinitionException 问题
        HappyComponent happyComponent2 = applicationContext1.getBean(HappyComponent.class);
        happyComponent2.doWork();

        //方式3: 根据id和类型获取
        HappyComponent happyComponent3 = applicationContext1.getBean("happyComponent01", HappyComponent.class);
        happyComponent3.doWork();

        System.out.println(happyComponent1 == happyComponent2);
        System.out.println(happyComponent1 == happyComponent3);
        System.out.println(happyComponent2 == happyComponent3);
    }

    @Test
    public void test04() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-04.xml");

        JavaBean2 bean = applicationContext.getBean(JavaBean2.class);
        JavaBean2 bean1 = applicationContext.getBean(JavaBean2.class);
        System.out.println(bean == bean1); //true

        JavaBean3 bean2 = applicationContext.getBean(JavaBean3.class);
        JavaBean3 bean3 = applicationContext.getBean(JavaBean3.class);
        System.out.println(bean2 == bean3); //false


        applicationContext.close();
    }

    @Test
    public void test05() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-05.xml");

        JavaBean javaBean = applicationContext.getBean("javaBean", JavaBean.class);
        System.out.println(javaBean);

        Object bean = applicationContext.getBean("&javaBean");
        System.out.println(bean);


        applicationContext.close();
    }
}
