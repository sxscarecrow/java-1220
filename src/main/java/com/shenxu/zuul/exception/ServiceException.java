package com.shenxu.zuul.exception;

import com.shenxu.zuul.domain.constant.ResultEnum;
import lombok.Data;

/**
 * 服务（业务）异常如“ 账号或密码错误 ”，该异常只做INFO级别的日志记录 @see WebMvcConfigurer
 */
@Data
public class ServiceException extends RuntimeException {

    /**
     * 错误码
     */
    private int code;
    /**
     * 错误信息
     */
    private String msg;

    public ServiceException() {
    }

    public ServiceException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
        this.msg = resultEnum.getMsg();
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(int code, String message) {
        super(message);
        this.code = code;
        this.msg = message;
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

}
