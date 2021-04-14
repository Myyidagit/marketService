package com.controller;

import com.dao.classTypedao.ClassTypeService;
import com.dao.classTypedao.ClassTypedao;
import com.dao.redisUtils.RedisUtils;
import com.model.ClassTypeModel;
import com.respData.RespCode;
import com.respData.RespData;
import com.utils.UtilsFun;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Auther: Xu
 * @Date: 2021/4/9 - 04 - 09 - 17:46
 * @Description: com.controller
 * @version: 1.0
 */
@RestController
public class ClassTypeTools {

    @Autowired
    private ClassTypeService classTypeService;
    @Autowired
    private RedisUtils redisUtils;

    /**
     * 获取分类列表
     * @return
     */
    @GetMapping(value = "/getClassType")
    public RespData getClassType() throws Exception{
        RespData respData = new RespData(RespCode.SUCCESS);
        List<ClassTypeModel> list = classTypeService.findAll();
        respData.setData(list);
        return respData;
    }

    /**
     * 创建分类
     * @param label
     * @return
     * @throws Exception
     */
    @PostMapping(value = "/createClass")
    public RespData createClass(@RequestBody(required = true) String label) throws Exception{

        RespData respData = new RespData(RespCode.SUCCESS);
        JSONObject jsonObject = JSONObject.fromObject(label);
        String la = jsonObject.getString("label");
        System.out.println(label.toString());
        if(!UtilsFun.isEmptyString(la)){
            throw new Exception(RespCode.MISCODE.getCode()+"+label不能为空");
        };
        int i = classTypeService.getNextSequence("classType");
        System.out.println("最后一个id"+i);

        ClassTypeModel classTypeModel = new ClassTypeModel();
        classTypeModel.setId(i);
        classTypeModel.setLabel(la);
        System.out.println(classTypeModel.toString());
        classTypeService.insertOne(classTypeModel);
        return respData;
    }
}
