package com.lb.bean.test.entity;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @author : lb
 * @date : 2020/9/1 10:16
 * @description :
 */
@Data
@Slf4j
public class MyBean {

    private String port;

    public void init() {
        log.info("MyBean 开始初始化...");
    }

    public void destroy() {
        log.info("MyBean销毁...");
    }

}
