package com.shenxu.zuul.domain.result;

import com.shenxu.zuul.domain.constant.ResultEnum;
import org.slf4j.MDC;

import java.util.ArrayList;
import java.util.List;

/**
 * 结果集构建
 */
public class ResultBuilder {

    /**
     * 成功结果集
     *
     * @return Result
     * @author shenxu
     */
    public static Result success() {
        return success(ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getMsg(), new ArrayList<>());
    }

    /**
     * 成功结果集
     *
     * @param data 集合列表
     * @return Result
     * @author shenxu
     */
    public static <T> Result success(List<T> data) {
        return success(ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getMsg(), data);
    }

    /**
     * 成功结果集
     *
     * @param data 集合列表
     * @return Result
     * @author shenxu
     */
    public static <T> Result success(int code, String msg, List<T> data) {
        return Result.builder()
                .code(code)
                .msg(msg)
                .data(data)
                .requestId(MDC.get("requestId"))
                .build();
    }

    /**
     * 成功结果集
     *
     * @param data 对象
     * @return Result
     * @author shenxu
     */
    public static <T> Result success(T data) {
        return success(ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getMsg(), data);
    }

    /**
     * 成功结果集
     *
     * @param code 状态码
     * @param msg  消息
     * @param data 对象数据
     * @return Result
     * @author shexu
     */
    public static <T> Result success(int code, String msg, T data) {
        return Result.builder()
                .code(code)
                .msg(msg)
                .data(data)
                .requestId("requestId")
                .build();
    }

    /**
     * 成功结果集
     *
     * @return Result
     * @author shenxu
     */
    public static Result error() {
        return error(ResultEnum.ERROR.getCode(), ResultEnum.ERROR.getMsg(), null);
    }

    /**
     * 错误结果集
     *
     * @param msg 消息
     * @return Result
     * @author shenxu
     */
    public static Result error(String msg) {
        return error(ResultEnum.ERROR.getCode(), msg, null);
    }

    /**
     * 错误结果集
     *
     * @param code 状态码
     * @param msg  消息
     * @return Result
     * @author shenxu
     */
    public static Result error(int code, String msg) {
        return error(code, msg, null);
    }

    /**
     * 错误结果集
     *
     * @param code 状态码
     * @param msg  消息
     * @param data 集合数据
     * @return Result
     * @author shenxu
     */
    public static <T> Result error(int code, String msg, List<T> data) {
        return Result.builder()
                .code(code)
                .msg(msg)
                .data(data)
                .requestId("requestId")
                .build();
    }

    /**
     * 错误结果集
     *
     * @param code 状态码
     * @param msg  消息
     * @param data 对象数据
     * @return Result
     * @author shenxu
     */
    public static <T> Result error(int code, String msg, T data) {
        return Result.builder()
                .code(code)
                .msg(msg)
                .data(data)
                .requestId("requestId")
                .build();
    }

}

