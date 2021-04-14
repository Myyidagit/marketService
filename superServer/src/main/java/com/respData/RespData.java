package com.respData;

import lombok.Data;

/**
 * @Auther: Xu
 * @Date: 2021/3/30 - 03 - 30 - 16:22
 * @Description: com.respData
 * @version: 1.0
 */
@Data
public class RespData<T> {
    /**
     * 状态码 200 成功
     */
    private int code;
    /**
     * 状态消息
     */
    private String message;
    /**
     * 总条数
     */
    private Long total;

    private T data;

    public RespData(){}

    public RespData(RespCode respCode){
        this.code = respCode.getCode();
        this.message = respCode.getMessage();
    }

    /**
     * 这是状态码和消息
     * @param respCode
     */
    public void setCodeMsg(RespCode respCode) {
        this.code = respCode.getCode();
        this.message = respCode.getMessage();
    }

    /**
     * 设置响应消息
     */
    public void setMsg(String str){
        this.message = str;
    }
    /**
     * 设置相应体
     */
    public void setData(T data){
        this.data = data;
    }
}
