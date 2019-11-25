package cn.damon.elastic_job.business;

import org.springframework.stereotype.Service;

/**
 * @ClassName BusService
 * @Description
 * @Author Damon
 * @Date 2019/11/25 23:32
 * @Email zdmsjyx@163.com
 * @Version 1.0
 */
@Service
public class BusService {

    private String sql = "select * from xxxx where name = %s";

    public String getSql(String value){
        return String.format(sql,value);
    }

    //执行分片sql
    public void process(String sql){
        System.out.println("执行sql:"+sql);
    }
}
