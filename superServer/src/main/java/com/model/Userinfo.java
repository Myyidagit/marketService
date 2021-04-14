package com.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @Auther: Xu
 * @Date: 2021/4/14 - 04 - 14 - 14:31
 * @Description: com.model
 * @version: 1.0
 */
@Data
@Document(collection = "userInfo")
public class Userinfo {
    @Id
    private String _id;
    /**
     * 用户id
     */
    private int userid;
    private int roleid;
    private String account;
    private String password;
    private String nickname;
    private String photo;
    private String phone;
}
