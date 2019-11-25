package cn.damon.spring_task;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName TaskConfig
 * @Description
 * @Author Damon
 * @Date 2019/11/25 21:40
 * @Email zdmsjyx@163.com
 * @Version 1.0
 */
//加入bean管理
@Component
//启用定时任务
@EnableScheduling
public class TaskConfig {

    //配置两个线程

    //固定延迟5秒执行
    @Scheduled(fixedRate = 5000)
    public void execute1() throws Exception{
        String threadName = Thread.currentThread().getName();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = format.format(new Date());
        System.out.println("execute1"+threadName+",我正在执行....,时间:"+time);
    }

    //从0秒开始，每5秒执行一次
    @Scheduled(cron = "0/5 * * * * ?")
    public void execute2(){
        String threadName = Thread.currentThread().getName();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = format.format(new Date());
        System.out.println("execute2"+threadName+",我正在执行....,时间:"+time);
    }

}
