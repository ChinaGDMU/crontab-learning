package cn.damon.quartz.job;

import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName Job2
 * @Description
 * @Author Damon
 * @Date 2019/11/25 22:06
 * @Email zdmsjyx@163.com
 * @Version 1.0
 */
//有两种方式定义任务，一种是实现Job接口 ，一种是以JavaBean的方式注入容器
@Component
public class Job2 {

    public void doJob(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = sdf.format(new Date());
        String threadName = Thread.currentThread().getName();
        System.out.println("线程名"+threadName+",Job2.dojob正在执行任务...,时间："+format);
    }
}
