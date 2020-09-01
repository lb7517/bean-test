package com.lb.bean.test.config;

import com.lb.bean.test.entity.MyBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * @author : lb
 * @date : 2020/9/1 10:38
 * @description : 注解bean的使用, @Configuration相当于Spring配置文件中的<beans />标签
 */
@Configuration
@Slf4j
public class MyConfiguration {

    /**
     * 使用默认bean，是单例，注解使用getMyBean1名称
     * 1、@Bean注解在返回实例的方法上，如果未通过@Bean指定bean的名称，则默认与方法名相同
     * 2、@Bean注解默认作用域为单例singleton作用域，可通过@Scope(“prototype”)设置为多例
     * */
    @Bean
    public MyBean getMyBean1() {
        MyBean myBean = new MyBean();
        myBean.setPort("8080");
        log.info("通过 getMyBean1 方法获取MyBean实例");
        return myBean;
    }

    /**
     * 给bean设置别名，是单例，注解使用myBean或getMyBean2名称
     *  Scope包含: singleton, prototype, request, session, globalSession
     *  1、 singleton 默认单例
     *  2、 prototype 每次从容器中调用Bean时，都返回一个新的实例，即每次调用getBean()时，相当于执行new XxxBean()
     *  3、 request 每次HTTP请求都会创建一个新的Bean，该该作用域仅适用于WebApplicationContext环境
     *  4、 session 同一个HTTP Session共享一个Bean，不同Session使用不同Bean，仅适用于WebApplicationContext环境
     *  5. globalSession 一般用于Portlet应用环境，该作用域仅适用于WebApplicationContext环境
     * */
    @Bean("myBean")
    @Scope("singleton")
    public MyBean getMyBean2() {
        MyBean myBean = new MyBean();
        myBean.setPort("8082");
        log.info("通过 getMyBean2或myBean 方法获取MyBean实例");
        return myBean;
    }

    /**
     * @Bean 注解的 initMethod 和 destrodMethod 进行指定 Bean 在初始化和销毁时需要调用相应的方法
     * */
    @Bean(value = "myBean20", initMethod = "init", destroyMethod = "destroy")
    public MyBean getMyBean3() {
        MyBean myBean = new MyBean();
        myBean.setPort("8084");
        log.info("通过 getMyBean3或myBean2 方法获取MyBean实例");
        return myBean;
    }
}
