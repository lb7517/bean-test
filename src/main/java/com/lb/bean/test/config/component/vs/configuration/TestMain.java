package com.lb.bean.test.config.component.vs.configuration;

import com.lb.bean.test.entity.Car;
import com.lb.bean.test.entity.Driver;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author : lb
 * @date : 2020/9/1 15:07
 * @description :
 */
public class TestMain {

    public static void main(String[] args){
        AnnotationConfigApplicationContext component2Context = new
                AnnotationConfigApplicationContext(MyComponent2.class);
        AnnotationConfigApplicationContext componentContext = new
                AnnotationConfigApplicationContext(MyComponent.class);
        AnnotationConfigApplicationContext configurationContext = new
                AnnotationConfigApplicationContext(MyConfiguration.class);
        testDiffCar(componentContext);
        testSameCar(component2Context);
        testConfigurationCar(configurationContext);
    }

    /**
     * 使用@Component注解时，被@Bean修饰获取car是不同的
     * */
    public static void testDiffCar(AnnotationConfigApplicationContext context) {
        Driver driver = (Driver) context.getBean("driver");
        Car car = (Car) context.getBean("car");
        boolean result = driver.getCar() == car;
        System.out.println("执行MyComponent类: " + (result ? "同一个car" : "不同的car"));
    }

    /**
     * 使用@Component注解时，被@Bean修饰获，且通过@Autowired注入的car是相同的
     * */
    public static void testSameCar(AnnotationConfigApplicationContext context) {
        Driver driver = (Driver) context.getBean("driver");
        Car car = (Car) context.getBean("car");
        boolean result = driver.getCar() == car;
        System.out.println("执行MyComponent2类: " + (result ? "同一个car" : "不同的car"));
    }

    /**
     * 使用@Configuration注解时，被@Bean修饰获取car是相同的
     * */
    public static void testConfigurationCar(AnnotationConfigApplicationContext context) {
        Driver driver = (Driver) context.getBean("driver");
        Car car = (Car) context.getBean("car");
        boolean result = driver.getCar() == car;
        System.out.println("执行MyConfiguration类: " + (result ? "同一个car" : "不同的car"));
    }
}
