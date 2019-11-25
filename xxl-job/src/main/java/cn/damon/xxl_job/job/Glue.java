package cn.damon.xxl_job.job;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;

/**
 * @ClassName Glue
 * @Description
 * @Author Damon
 * @Date 2019/11/26 0:10
 * @Email zdmsjyx@163.com
 * @Version 1.0
 */
public class Glue extends IJobHandler {
    @Override
    public ReturnT<String> execute(String param) throws Exception {
        System.out.println("测试Glue任务");
        return SUCCESS;
    }
}
