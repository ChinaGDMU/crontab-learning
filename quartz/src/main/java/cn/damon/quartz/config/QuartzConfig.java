package cn.damon.quartz.config;

import cn.damon.quartz.job.Job1;
import cn.damon.quartz.job.Job2;
import org.quartz.CronTrigger;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.SimpleTrigger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.MethodInvokingFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.*;

/**
 * @ClassName QuartzConfig
 * @Description
 * @Author Damon
 * @Date 2019/11/25 22:07
 * @Email zdmsjyx@163.com
 * @Version 1.0
 */
@Configuration
public class QuartzConfig {

    //配置任务详情,复杂业务，需要传参 //有参数的任务
    @Bean
    public JobDetailFactoryBean job1Detail(){
        JobDetailFactoryBean detailFactoryBean = new JobDetailFactoryBean();
        detailFactoryBean.setJobClass(Job1.class);
        JobDataMap map = new JobDataMap();
        map.put("param","参数1111");
        detailFactoryBean.setJobDataMap(map);
        return detailFactoryBean;
    }

    //简单任务
    @Bean
    public MethodInvokingJobDetailFactoryBean job2Detail(Job2 job2){
        MethodInvokingJobDetailFactoryBean detail = new MethodInvokingJobDetailFactoryBean();
        detail.setConcurrent(false);
        detail.setTargetObject(job2);
        detail.setTargetMethod("doJob");
        return detail;
    }

    //简单trigger
    @Bean
    public SimpleTriggerFactoryBean simpleTrigger(@Qualifier("job2Detail") @Autowired JobDetail jobDetail){
        SimpleTriggerFactoryBean simpleTrigger = new SimpleTriggerFactoryBean();
        simpleTrigger.setJobDetail(jobDetail);
        //0延时
        simpleTrigger.setStartDelay(0);
        //间隔五秒
        simpleTrigger.setRepeatInterval(5000);
        return simpleTrigger;
    }

    //复杂参数trigger
    @Bean
    public CronTriggerFactoryBean detailTrigger(@Qualifier("job1Detail") @Autowired JobDetail jobDetail){
        CronTriggerFactoryBean cronTrigger = new CronTriggerFactoryBean();
        cronTrigger.setJobDetail(jobDetail);
        cronTrigger.setCronExpression("0/5 * * * * ?");
        return cronTrigger;
    }


    //配置schedule工厂
    @Bean
    public SchedulerFactoryBean scheduleFactoryBean(@Qualifier("simpleTrigger") @Autowired SimpleTrigger simpleTrigger
            ,@Qualifier("detailTrigger") @Autowired CronTrigger cronTrigger) {
        SchedulerFactoryBean factoryBean = new SchedulerFactoryBean();
        //延时1秒启动
        factoryBean.setStartupDelay(1);
        factoryBean.setTriggers(simpleTrigger,cronTrigger);
        return factoryBean;
    }

}
