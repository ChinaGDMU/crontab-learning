package cn.damon.elastic_job.hander;

import com.dangdang.ddframe.job.executor.handler.JobExceptionHandler;

/**
 * @ClassName CustomJobExceptionHandler
 * @Description
 * @Author Damon
 * @Date 2019/11/25 23:25
 * @Email zdmsjyx@163.com
 * @Version 1.0
 */
public class CustomJobExceptionHandler implements JobExceptionHandler {
    @Override
    public void handleException(String jobName, Throwable throwable) {
        System.out.println("发生了异常,jobName:"+jobName+",throwable:"+throwable);
    }
}
