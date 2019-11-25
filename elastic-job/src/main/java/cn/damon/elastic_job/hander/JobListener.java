package cn.damon.elastic_job.hander;

import com.dangdang.ddframe.job.executor.ShardingContexts;
import com.dangdang.ddframe.job.lite.api.listener.ElasticJobListener;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName JobListener
 * @Description
 * @Author Damon
 * @Date 2019/11/25 23:28
 * @Email zdmsjyx@163.com
 * @Version 1.0
 */
public class JobListener implements ElasticJobListener {

    //任务监听器
    @Override
    public void beforeJobExecuted(ShardingContexts shardingContexts) {
        String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        String jobName = shardingContexts.getJobName();
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName+"执行任务前，任务名称:"+jobName+"日期:"+date);
    }

    @Override
    public void afterJobExecuted(ShardingContexts shardingContexts) {
        String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        String jobName = shardingContexts.getJobName();
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName+"执行任务后，任务名称:"+jobName+"日期:"+date);
    }
}
