package com.respData;

import lombok.Getter;

/**
 * @Auther: Xu
 * @Date: 2021/3/30 - 03 - 30 - 16:25
 * @Description: com.respData
 * @version: 1.0
 */
@Getter
public enum RespCode {

    SUCCESS(200,"成功"),
    FAILED(500,"失败"),
    ERROR(400,"参数错误"),
    MISCODE(400),
    ERRCODE(500);
    private int code;
    private String message;
    private int missCode=400;
    private int errCode=500;

    RespCode(int code, String msg){
        this.code = code;
        this.message = msg;
    }
    RespCode(int code){
        this.code = code;
    }
}
