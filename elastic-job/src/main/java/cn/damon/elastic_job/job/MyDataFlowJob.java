package cn.damon.elastic_job.job;

import cn.damon.elastic_job.business.BusService;
import com.cxytiandi.elasticjob.annotation.ElasticJobConf;
import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.dataflow.DataflowJob;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @ClassName DataFlowJob
 * @Description
 * @Author Damon
 * @Date 2019/11/25 23:41
 * @Email zdmsjyx@163.com
 * @Version 1.0
 */
@ElasticJobConf(name = "DataflowJob",cron = "0/5 * * * * ?"
		,shardingItemParameters = "0=beijing,1=shanghai",shardingTotalCount = 2
		,listener = "cn.damon.elastic_job.hander.JobListener",jobExceptionHandler = "cn.damon.elastic_job.hander.CustomJobExceptionHandler"
)
public class MyDataFlowJob implements DataflowJob<String> {

    @Autowired
    private BusService busService;

    @Override
    public List<String> fetchData(ShardingContext shardingContext) {
        String sql = busService.getSql(shardingContext.getShardingParameter());
        return Collections.singletonList(sql);
    }

    @Override
    public void processData(ShardingContext shardingContext, List<String> list) {
        System.out.println("当前分片："+shardingContext.getShardingParameter());
        busService.process(list.get(0));
    }
}
