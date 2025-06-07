package com.atguigu.ioc_05;

import org.springframework.beans.factory.FactoryBean;

public class JavaFactoryBean implements FactoryBean<JavaBean> {
    @Override
    public JavaBean getObject() throws Exception {
        return new JavaBean();
    }

    @Override
    public Class<?> getObjectType() {
        return JavaBean.class;
    }
}
