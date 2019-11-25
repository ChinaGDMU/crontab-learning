package cn.damon.spring_task;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import javax.annotation.PreDestroy;
import java.util.concurrent.*;

/**
 * @ClassName PoolConfig
 * @Description
 * @Author Damon
 * @Date 2019/11/25 21:48
 * @Email zdmsjyx@163.com
 * @Version 1.0
 */
//可以去掉这个配置看看效果
@Configuration
public class PoolConfig implements SchedulingConfigurer {

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        //把一个线程池作为一个执行器
        taskRegistrar.setScheduler(executor());
    }


    @Bean(destroyMethod = "shutdown")
    public Executor executor(){
        return Executors.newScheduledThreadPool(10);
    }



}
