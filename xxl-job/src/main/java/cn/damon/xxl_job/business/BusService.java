package cn.damon.xxl_job.business;

import org.springframework.stereotype.Service;

/**
 * @ClassName BusService
 * @Description
 * @Author Damon
 * @Date 2019/11/26 0:13
 * @Email zdmsjyx@163.com
 * @Version 1.0
 */
@Service
public class BusService {

    public void process(int index,int total,String param){
        if(total == 1){
            System.out.println("当前执行全业务处理，参数:"+param);
        }
        System.out.println("当前执行第"+(index+1)+"/"+total+"片数据，参数:"+param);
    }
}
