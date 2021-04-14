package com.dao.logindao;

import com.model.Userinfo;
import com.sun.org.apache.xpath.internal.operations.Bool;
import com.utils.UtilsFun;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Auther: Xu
 * @Date: 2021/4/14 - 04 - 14 - 14:35
 * @Description: com.dao.logindao
 * @version: 1.0
 */
@Service
public class LoginService {
    @Autowired
    private Logindao logindao;

    /**
     * 创建用户
     * @param userinfo
     * @return
     */
    public Boolean register(Userinfo userinfo){
        Boolean flag = false;
        try{
            logindao.save(userinfo);
            flag = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    public Userinfo findByAccount(String account){
        Userinfo userinfo = logindao.findByAccount(account);
        return userinfo;
    }

    /**
     * 通过账号来查看用户存不存在
     * @param account
     * @return
     */
    public Boolean isExitUser(String account){
        Boolean flag = false;
        Userinfo userinfo = logindao.findByAccount(account);
        System.out.println(userinfo);
        if(UtilsFun.isEmptyMap(userinfo)){
            flag = true;
        }
        return flag;
    }
}
