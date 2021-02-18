package com.shenxu.zuul.domain.result;

import lombok.Builder;
import lombok.Data;
import org.slf4j.MDC;

/**
 * @author zhaowei
 */
@Data
@Builder
public class Response {

    /**
     * 错误码
     */
    private int code;
    /**
     * 错误信息
     */
    private String msg;
    /**
     * 数据对象
     */
    private Object data;

    private String requestId;

    public static <T> Response success(T data) {
        return Response.builder()
                .code(200)
                .msg("")
                .requestId(MDC.get("requestId"))
                .data(data)
                .build();
    }
}