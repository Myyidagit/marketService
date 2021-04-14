package com.controller;

import com.dao.logindao.LoginService;
import com.model.Userinfo;
import com.respData.RespCode;
import com.respData.RespData;
import com.utils.UtilsFun;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: Xu
 * @Date: 2021/4/14 - 04 - 14 - 14:39
 * @Description: com.controller
 * @version: 1.0
 */
@RestController
public class LoginTools {
    @Autowired
    private LoginService loginService;

    /**
     * 登录接口
     * @param userInfo
     * @return
     * @throws Exception
     */
    @PostMapping(value = "/login")
    public RespData login(@RequestBody(required = true) String userInfo) throws Exception{
        RespData respData = new RespData(RespCode.SUCCESS);

        JSONObject jsonObject = JSONObject.fromObject(userInfo);
        String account = jsonObject.getString("account");
        String psd = jsonObject.getString("password");
        if(!UtilsFun.isEmptyString(account)){
            throw new Exception(RespCode.MISCODE.getCode()+"+account不能为空");
        }
        if(!UtilsFun.isEmptyString(account)){
            throw new Exception(RespCode.MISCODE.getCode()+"+password不能为空");
        }

        Userinfo user = loginService.findByAccount(account);
        System.out.println("user>>>>"+account);
        if(user == null){
            throw new Exception(RespCode.ERRCODE.getCode()+"+该用户不存在");
        }
        String psdNow = user.getPassword();
        if(!psdNow.equals(psd)){
            throw new Exception(RespCode.ERRCODE.getCode()+"+密码错误");
        }
//        生成map指定字段返回给前端
        Map<String,String> map = new HashMap<>();
        map.put("userId",user.getUserid()+"");
        map.put("roleId",user.getRoleid()+"");
        map.put("phone",user.getPhone());
        map.put("photo",user.getPhoto());
        respData.setData(map);
        respData.setMessage("登录成功");
        return respData;
    }
}
