## @Bean注解的使用
**com.lb.bean.test.config.MyConfiguration展示了@Bean的具体用法**


## @Configuration和@Component比较
**比较文件在com.lb.bean.test.config.component.vs.configuration包下面:**

*   @Configuration注解的代码会像我们期望的一样正常运行，因为driver()这段代码中driver.setCar(car())方法会由Spring代理执行，Spring发现方法所请求的Bean已经在容器中，那么就直接返回容器中的Bean。所以全局只有一个Car对象的实例。
*   @Component注解的代码在执行driver() 时driver.setCar(car())不会被Spring代理，会直接调用car()方法获取一个全新的Car对象实例，所以全局会有多个Car对象的实例

**原因:**

    @Configuration 中所有带 @Bean 注解的方法都会被动态代理，因此调用该方法返回的都是同一个实例；@Component 中driver.setCar(car())只是纯JAVA方式的调用，多次调用该方法返回的是不同的对象实例，要在@Component 中实现同样效果，在@Component注解中使用@Autowired注入
    
具体代码[github](https://github.com/lb7517/bean-test.git)上