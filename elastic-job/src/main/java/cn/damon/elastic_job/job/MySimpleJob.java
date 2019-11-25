package cn.damon.elastic_job.job;

import cn.damon.elastic_job.business.BusService;
import com.cxytiandi.elasticjob.annotation.ElasticJobConf;
import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @ClassName MySimpleJob
 * @Description
 * @Author Damon
 * @Date 2019/11/25 23:34
 * @Email zdmsjyx@163.com
 * @Version 1.0
 */
//通过注解来配置
//    @ElasticJobConf(
//            name="elastic-simple-job",
//            cron = "0/5 * * * * ?",
//            shardingItemParameters = "0=beijing|shenzhen|tianjin,1=shanghai",
//            shardingTotalCount = 2,
//            listener = "cn.damon.elastic_job.hander.JobListener",
//            jobExceptionHandler = "cn.damon.elastic_job.hander.CustomJobExceptionHandler"
//
//    )
public class MySimpleJob implements SimpleJob {

    @Autowired
    private BusService busService;

    @Override
    public void execute(ShardingContext shardingContext) {
        System.out.println("elastic-job,当前分片:"+shardingContext.getShardingParameter());
        String sql = busService.getSql(shardingContext.getShardingParameter());
        busService.process(sql);
    }
}
