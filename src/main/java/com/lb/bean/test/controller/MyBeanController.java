package com.lb.bean.test.controller;

import com.lb.bean.test.constant.ResultState;
import com.lb.bean.test.entity.MyBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

/**
 * @author : lb
 * @date : 2020/9/1 10:44
 * @description :
 */
@RequestMapping("/my/bean")
@RestController
public class MyBeanController {

    @Autowired
    MyBean getMyBean1;

    /**
     * 使用Bean的别名
     * */
    @Autowired
    MyBean myBean;

    /**
     * 使用Bean的别名,提供使用前和使用后做一些操作
     * */
    @Autowired
    MyBean myBean20;

    /**
     * Qualifier注解用于区分同名方法，不同的bean
     * */
    @Autowired
    @Qualifier("getMyBean1")
    MyBean getMyBean2;

    @GetMapping("/query/bean1")
    public Map<String, Object> queryByGetMyBean1(){
        return ResultState.SUCCESS.toMap(getMyBean1.getPort());
    }

    @GetMapping("/query/bean2")
    public Map<String, Object> queryByGetMyBean2(){
        return ResultState.SUCCESS.toMap(getMyBean2.getPort());
    }

    @GetMapping("/query/bean3")
    public Map<String, Object> queryByGetMyBean3(){
        return ResultState.SUCCESS.toMap(myBean.getPort());
    }

    @GetMapping("/query/bean4")
    public Map<String, Object> queryByGetMyBean4(){
        Map<String, Object> result = ResultState.SUCCESS.toMap(myBean20.getPort());
        return result;
    }
}
