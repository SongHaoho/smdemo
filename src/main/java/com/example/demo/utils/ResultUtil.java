package com.example.demo.utils;

import com.example.demo.entity.DataReturn;

public class ResultUtil {

    public static DataReturn returnSuccess(Object object){
        DataReturn dataReturn = new DataReturn();
        dataReturn.setCode(0);
        dataReturn.setMsg("success");
        dataReturn.setData(object);
        return dataReturn;
    }

    public static DataReturn returnSuccess(){
        return returnSuccess(null);
    }

    public static DataReturn returnError(Integer code, String msg){
        DataReturn dataReturn = new DataReturn();
        dataReturn.setCode(code);
        dataReturn.setMsg(msg);
        return dataReturn;
    }
}
