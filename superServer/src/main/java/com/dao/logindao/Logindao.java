package com.dao.logindao;

import com.model.Userinfo;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @Auther: Xu
 * @Date: 2021/4/14 - 04 - 14 - 14:31
 * @Description: com.dao.logindao
 * @version: 1.0
 */
public interface Logindao extends MongoRepository<Userinfo,String> {
    public Userinfo findByAccount(String account);
}
