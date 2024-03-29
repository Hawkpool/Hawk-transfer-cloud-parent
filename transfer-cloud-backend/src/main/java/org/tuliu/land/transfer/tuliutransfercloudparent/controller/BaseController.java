package org.tuliu.land.transfer.tuliutransfercloudparent.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tuliu.land.transfer.tuliutransfercloudparent.domain.RestAPIResult;
import org.tuliu.land.transfer.tuliutransfercloudparent.domain.exception.BusinessException;
import org.tuliu.land.transfer.tuliutransfercloudparent.domain.exception.DatabaseException;

import javax.xml.bind.ValidationException;

public class BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(BaseController.class);

    @ExceptionHandler(Exception.class)
    public @ResponseBody
    RestAPIResult<?> handleUncaughtException(Exception ex) { //系统异常
        //        LOGGER.error(ex.getStackTrace().toString(), ex.getCause());
        printStackTrace(ex);
        if (null == ex.getMessage()) {
            return new RestAPIResult<>("系统异常！");
        }
        if (ex instanceof org.springframework.jdbc.BadSqlGrammarException) {
            return new RestAPIResult<>("查询失败，后台SQL语法错误");
        }
        if (ex instanceof NumberFormatException) {
            return new RestAPIResult<>("数据转换异常!");
        }
        return new RestAPIResult<>(ex.getMessage());
    }

    @ExceptionHandler(ValidationException.class)
    public @ResponseBody
    RestAPIResult<?> handleValidationException(ValidationException validationEx) { //数据校验异常
        //        LOGGER.error(validationEx.getMessage(), validationEx.getCause());
        printStackTrace(validationEx);
        return new RestAPIResult<>(validationEx.getMessage());
    }

    @ExceptionHandler(BusinessException.class)
    public @ResponseBody
    RestAPIResult<?> handleBusinessException(BusinessException businessEx) { //业务逻辑异常
        //        LOGGER.error(businessEx.getMessage(), businessEx.getCause());
        printStackTrace(businessEx);
        return new RestAPIResult<>(businessEx.getMessage());
    }

    @ExceptionHandler(DatabaseException.class)
    public @ResponseBody
    RestAPIResult<?> handleValidationException(DatabaseException dbEx) { //数据库操作异常
        //        LOGGER.error(dbEx.getMessage(), dbEx.getCause());
        printStackTrace(dbEx);
        return new RestAPIResult<>(dbEx.getMessage());
    }

    @ExceptionHandler(HttpMessageNotWritableException.class)
    public @ResponseBody
    RestAPIResult<?> handleJSONConvertException(HttpMessageNotWritableException jsonEx) { //JSON格式转换异常
        //        LOGGER.error(jsonEx.getMessage(), jsonEx.getCause());
        printStackTrace(jsonEx);
        return new RestAPIResult<>("JSON格式转换异常");
    }

    /**
     * printStackTrace:日志中打印错误信息<br/>
     */
    public void printStackTrace(Exception ex) {
        ex.printStackTrace();
        StackTraceElement[] ste = ex.getStackTrace();
        //只打出最先导致出错的地方
        if (ste.length > 3) {
            for (int i = 0; i < 4; i++) {
                StackTraceElement stackTraceElement = ste[i];
                String errorMsg = "[error Class]：" + stackTraceElement.getClassName() + "------[error Method]：" + stackTraceElement.getMethodName() + "------[error Line]："
                        + stackTraceElement.getLineNumber() + "---------[error message]：" + ex.getMessage();
                LOGGER.error(errorMsg);
            }
        } else {
            for (int i = 0; i < ste.length; i++) {
                StackTraceElement stackTraceElement = ste[i];
                String errorMsg = "[error Class]：" + stackTraceElement.getClassName() + "------[error Method]：" + stackTraceElement.getMethodName() + "------[error Line]："
                        + stackTraceElement.getLineNumber() + "---------[error message]：" + ex.getMessage();
                LOGGER.error(errorMsg);
            }
        }
    }

}
