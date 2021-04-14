package com.utils;

import java.util.List;
import java.util.regex.Pattern;

/**
 * @Auther: Xu
 * @Date: 2021/4/7 - 04 - 07 - 20:45
 * @Description: com.utils
 * @version: 1.0
 */

public class UtilsFun {
    /**
     * 是否为正整数字
     */
    public static boolean isNumeric(String string){
        Pattern pattern = Pattern.compile("[0-9]*");
        return pattern.matcher(string).matches();
    }

    /**
     * 字符串是否为空
     * @param str
     * @return boolean false为空 true不为空
     */
    public static Boolean isEmptyString(String str){
        Boolean bool = true;
        str = str.trim(); // 处理" "
        if(str == null || "".equals(str)){
            bool = false;
        }
        return bool;
    }

    /**
     * list是否为空
     * @param list
     * @return false为空 true不为空
     */
    public static Boolean isEmptyList(List list){
        Boolean bool = false;
        if(list != null && !list.isEmpty()){
            bool = true;
            //list存在且里面有元素
        }
        return bool;
    }
    /**
     * list是否为空
     * @param obj
     * @return false为空 true不为空
     */
    public static Boolean isEmptyMap(Object obj){
        Boolean bool = false;
        if(obj != null ){
            bool = true;
        }
        return bool;
    }

}
