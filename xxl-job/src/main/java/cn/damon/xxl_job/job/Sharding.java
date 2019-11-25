package cn.damon.xxl_job.job;

import cn.damon.xxl_job.business.BusService;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import com.xxl.job.core.util.ShardingUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName Sharding
 * @Description
 * @Author Damon
 * @Date 2019/11/26 0:16
 * @Email zdmsjyx@163.com
 * @Version 1.0
 */
@JobHandler(value = "sharding")
@Service
public class Sharding extends IJobHandler {

    @Autowired
    private BusService busService;

    @Override
    public ReturnT<String> execute(String param) throws Exception {
        ShardingUtil.ShardingVO shardingVo = ShardingUtil.getShardingVo();
        busService.process(shardingVo.getIndex(),shardingVo.getTotal(),param);
        return SUCCESS;
    }
}
