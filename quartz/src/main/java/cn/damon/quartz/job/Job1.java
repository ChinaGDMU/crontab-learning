package cn.damon.quartz.job;

import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName Job1
 * @Description
 * @Author Damon
 * @Date 2019/11/25 22:01
 * @Email zdmsjyx@163.com
 * @Version 1.0
 */
//有两种方式定义任务，一种是实现Job接口 ，一种是以JavaBean的方式注入容器
public class Job1 implements Job{

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        JobDetail jobDetail = context.getJobDetail();
        String param = (String) jobDetail.getJobDataMap().get("param");
        doJob(param);
    }

    public void doJob(String param){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = sdf.format(new Date());
        String threadName = Thread.currentThread().getName();
        System.out.println("线程名"+threadName+",dojob正在执行任务...,参数："+param+"时间："+format);
    }
}
