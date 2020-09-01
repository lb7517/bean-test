package com.lb.bean.test.config.component.vs.configuration;

import com.lb.bean.test.entity.Car;
import com.lb.bean.test.entity.Driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author : lb
 * @date : 2020/9/1 14:31
 * @description :
 */
@Component
public class MyComponent2 {

    @Autowired
    Car car;

    @Bean
    public Driver driver() {
        Driver driver = new Driver();
        driver.setId(1);
        driver.setName("driver");
        driver.setCar(car);
        return driver;
    }

    @Bean
    public Car car() {
        Car car = new Car();
        car.setId(1);
        car.setName("car");
        return car;
    }

}
