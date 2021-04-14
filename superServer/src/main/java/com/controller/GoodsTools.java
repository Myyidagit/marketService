package com.controller;

import com.dao.GoodsService;
import com.model.GoodsModel;
import com.respData.RespCode;
import com.respData.RespData;
import com.utils.UtilsFun;
import lombok.Data;
import net.sf.json.JSONObject;
import netscape.javascript.JSObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * @Auther: Xu
 * @Date: 2021/4/1 - 04 - 01 - 18:54
 * @Description: com.controller
 * @version: 1.0
 */
//@ResponseBody
//@Controller
//@RestController是包含两个注解的
@RestController
public class GoodsTools {
    @Autowired
    private GoodsService goodsService;

    //根据商品名字 和上下架状态来查询
    @GetMapping(value = "/getGoodsList")
    public RespData getGoods(@RequestParam(required = false) String name,
                             @RequestParam(required = false) String status,
                             @RequestParam(required = true,defaultValue = "1") int pageNum,
                             @RequestParam(required = true,defaultValue = "10") int pageSize) throws Exception{

        //创建响应体
        RespData respData = new RespData(RespCode.SUCCESS);

        List<GoodsModel> list = new ArrayList<>();
        //0全部 1上架 2下架
        if("0".equals(status)){
            Page<GoodsModel> pageObj = goodsService.findnameLike(name,pageNum,pageSize);
            list= pageObj.getContent();
            respData.setTotal(pageObj.getTotalElements());
        }else{
            Page<GoodsModel> pageObj = goodsService.pageList(name,Integer.parseInt(status),pageNum,pageSize);
            list= pageObj.getContent();
            respData.setTotal(pageObj.getTotalElements());
        }
        respData.setData(list);
        return respData;
    }

    @PostMapping(value = "/createGoods")
//    public RespData createGoods(@RequestBody(required = true) Map<String,String> param) throws Exception{
    public RespData createGoods(@RequestBody(required = true) GoodsModel goodsModel) throws Exception{
        System.out.println(goodsModel.toString());
        System.out.println(goodsModel.getCTime());
        //_id是否为空 为空为新建，不为空为修改
        if(!UtilsFun.isEmptyString(goodsModel.get_id())){
            Long date = new Date().getTime();
            goodsModel.setCTime(date+"");
        };
        if(goodsModel.getClassType() == 0){
            throw new Exception(RespCode.MISCODE.getCode()+"+classType不能为空");
        }
        if(goodsModel.getPrice() <= 0){
            throw new Exception(RespCode.MISCODE.getCode()+"+Price不能小于零");
        }

        if(!UtilsFun.isNumeric(goodsModel.getDisCount()+"")){
            throw new Exception(RespCode.MISCODE.getCode()+"+disCount类型错误");
        }

        RespData respData = new RespData(RespCode.SUCCESS);
        goodsService.insertOne(goodsModel);

        return respData;
    }

    @PostMapping(value = "/deleteGoods")
    public RespData deleteGoods(@RequestBody(required = true) String goods) throws Exception{

        RespData respData = new RespData(RespCode.SUCCESS);

        //接受到goods是个json字符串
        JSONObject jsonObject = JSONObject.fromObject(goods);
        //取出id
        String id = jsonObject.getString("id");

        if(id == null || id == ""){
            throw new Exception(RespCode.MISCODE.getCode()+"+id不能为空");
        }

        Boolean isexit = goodsService.isExit(id);
        System.out.println("mongodvid>>>>>>>"+isexit);
        if(isexit){
            goodsService.deleteOne(id);
        }else{
            respData.setMsg("数据不存在");
            respData.setCode(500);
        }
        return respData;
    }

    @GetMapping(value = "/goodsDetail")
    public RespData getGoodsDetail(@RequestParam(required = true) String id) throws Exception{

        RespData respData = new RespData(RespCode.SUCCESS);
        if(id == null || id == ""){
            throw new Exception(RespCode.MISCODE.getCode()+"+id不能为空");
        }
        Boolean isexit = goodsService.isExit(id);
        if(!isexit){
            throw new Exception(RespCode.ERRCODE.getCode()+"+数据不存在");
        }
        GoodsModel goodsModel = goodsService.findById(id);
        respData.setData(goodsModel);
        return respData;
    }
}
