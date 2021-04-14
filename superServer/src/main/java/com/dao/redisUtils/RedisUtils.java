package com.dao.redisUtils;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @Auther: Xu
 * @Date: 2021/4/14 - 04 - 14 - 10:55
 * @Description: com.dao.redisUtils
 * @version: 1.0
 */
@Component
public class RedisUtils {
    @Resource
    private RedisTemplate<String,String> redisTemplate;

    /**
     *
     * @param key
     * @param value
     * @return
     * @throws Exception
     */
    public Boolean setToken(String key,String value) throws Exception{
        Boolean flag = false;
        try{
            redisTemplate.opsForValue().set(key,value);
            // 这里指的是1小时后失效
            redisTemplate.expire(key, 1, TimeUnit.HOURS);
            flag = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;

    }

    /**
     * 删除redis数据
     * @param key
     * @return
     */
    public Boolean delData(String key) throws Exception{
        Boolean flag = false;
        try{
            redisTemplate.delete(key);
            flag = true;
        }catch (Exception e){

        }
        return flag;
    }
    /**
     * @description 写入键值对
     * @param key
     * @param value
     * @return
     */
    public Boolean setData(String key,String value) throws Exception{
        Boolean flag = false;
        try{
            redisTemplate.opsForValue().set(key,value);
            // 这里指的是1小时后失效
            redisTemplate.expire(key, 1, TimeUnit.HOURS);
            flag = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;

    }

    /**
     * 获取字符串
     * @param key
     * @return
     */
    public Object getStringData(String key){
        System.out.println(key);
        Object value = redisTemplate.opsForValue().get(key);
        System.out.println("value"+value);
        return value;
    }
}
