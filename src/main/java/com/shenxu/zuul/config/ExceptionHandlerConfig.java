package com.shenxu.zuul.config;

import com.shenxu.zuul.domain.constant.ResultEnum;
import com.shenxu.zuul.exception.ServiceException;
import com.shenxu.zuul.domain.result.Result;
import com.shenxu.zuul.domain.result.ResultBuilder;
import lombok.extern.log4j.Log4j2;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.yaml.snakeyaml.constructor.DuplicateKeyException;

import java.util.List;

/**
 * 异常处理器
 *
 * @author yzh
 */
@RestControllerAdvice
@Log4j2
public class ExceptionHandlerConfig {

    /**
     * 处理自定义异常
     */
    @ExceptionHandler(ServiceException.class)
    public Result handleRRException(ServiceException e) {
        log.error(e.getMessage(), e);
        return ResultBuilder.error(e.getCode(), e.getMessage());
    }

    @ExceptionHandler(DuplicateKeyException.class)
    public Result handleDuplicateKeyException(DuplicateKeyException e) {
        log.error(e.getMessage(), e);
        return ResultBuilder.error(ResultEnum.NO_DATA.getCode(), ResultEnum.NO_DATA.getMsg());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result handleArgumentNotValidException(MethodArgumentNotValidException e) {
        log.error(e.getMessage(), e);
        List<FieldError> fieldError = e.getBindingResult().getFieldErrors();
        StringBuffer buffer = new StringBuffer();

        fieldError.forEach(field -> {
            if (buffer.length() > 0) {
                buffer.append("-");
            }
            buffer.append(field.getDefaultMessage());
        });
        return ResultBuilder.error(ResultEnum.REQUEST_SERVER_PARAM_ERROR.getCode(), buffer.toString());
    }

    @ExceptionHandler(BindException.class)
    public Result handleBindException(BindException e) {
        log.error(e.getMessage(), e);
        List<FieldError> fieldError = e.getBindingResult().getFieldErrors();
        StringBuffer buffer = new StringBuffer();

        fieldError.forEach(field -> {
            if (buffer.length() > 0) {
                buffer.append("-");
            }
            buffer.append(field.getDefaultMessage());
        });
        return ResultBuilder.error(ResultEnum.REQUEST_SERVER_PARAM_ERROR.getCode(), buffer.toString());
    }

    @ExceptionHandler(NullPointerException.class)
    public Result handleException(NullPointerException e) {
        log.error(e.getMessage(), e);
        return ResultBuilder.error(ResultEnum.INTERNAL_SERVER_NULLPOINTER_ERROR.getCode(), ResultEnum.INTERNAL_SERVER_NULLPOINTER_ERROR.getMsg());
    }

    @ExceptionHandler(Exception.class)
    public Result handleException(Exception e) {
        log.error(e.getMessage(), e);
        return ResultBuilder.error(ResultEnum.ERROR.getCode(), ResultEnum.ERROR.getMsg());
    }

}
