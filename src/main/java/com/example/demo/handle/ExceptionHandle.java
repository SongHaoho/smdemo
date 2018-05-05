package com.example.demo.handle;

import com.example.demo.entity.DataReturn;
import com.example.demo.exception.DemoException;
import com.example.demo.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandle {

    // Spring自带的日志框架 sl4j
    private final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);
    /**
     * 最初只做了一个统一的异常处理
     */
//    @ExceptionHandler(value = Exception.class)
//    @ResponseBody
//    private Map<String,Object> exceptionHandler(HttpServletRequest req,Exception e){
//        Map<String,Object> modelMap = new HashMap<String, Object>();
//        modelMap.put("success",false);
//        modelMap.put("errMsg",e.getMessage());
//        return modelMap;
//    }

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    private DataReturn exceptionHandle(Exception e){
        // 判断是否是自己定义的异常
        if(e instanceof DemoException){
            DemoException demoException = (DemoException) e;
            return ResultUtil.returnError(demoException.getCode(),demoException.getMessage());
        }else {
            logger.error("系统异常: {}",e.getMessage());
            return ResultUtil.returnError(-1,e.getMessage());
        }
    }
}
