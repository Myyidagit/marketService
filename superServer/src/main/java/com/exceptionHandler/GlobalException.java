package com.exceptionHandler;

import com.respData.RespCode;
import com.respData.RespData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: Xu
 * @Date: 2021/3/24 - 03 - 24 - 15:44
 * @Description: 全局异常处理类
 * @version: 1.0
 */
@RestControllerAdvice
public class GlobalException {

    private static final Logger log = LoggerFactory.getLogger(GlobalException.class);

    /**
     * 系统异常处理，比如：400,500
     * @param req
     * @param e
     * @return
     * @throws Exception
     */
    @ExceptionHandler
    public RespData errHandler(HttpServletRequest req, Exception e) throws Exception{

        //得到controller抛出的异常
        System.out.println("EEEEEEE"+e.getMessage());

        //创建响应体
        RespData respData = new RespData(RespCode.FAILED);
        List<String> list = new ArrayList<>();
        respData.setData(list);

        //解析错误异常
        String message = e.getMessage() != null ?e.getMessage():"";
        int index = message.indexOf("+")+1;
        String mes = message.substring(index);

        //处理错误异常
        if(message.contains("400") || message.contains("is not present")){
            respData.setCodeMsg(RespCode.ERROR);
            respData.setMsg(mes);
        }else{
            respData.setCodeMsg(RespCode.FAILED);
            respData.setMsg(mes);
        };
        return respData;
    }
}
