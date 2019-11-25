package cn.damon.xxl_job.job;

import cn.damon.xxl_job.business.BusService;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName Simple
 * @Description
 * @Author Damon
 * @Date 2019/11/26 0:19
 * @Email zdmsjyx@163.com
 * @Version 1.0
 */
@JobHandler("simple")
@Service
public class Simple extends IJobHandler {

    @Autowired
    private BusService busService;

    @Override
    public ReturnT<String> execute(String param) throws Exception {
        busService.process(1,1,param);
        return SUCCESS;
    }
}
