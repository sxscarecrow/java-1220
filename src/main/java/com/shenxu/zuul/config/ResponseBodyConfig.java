package com.shenxu.zuul.config;

import com.shenxu.zuul.domain.result.Response;
import com.shenxu.zuul.domain.result.Result;
import com.shenxu.zuul.domain.result.ResultBuilder;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.util.Collections;
import java.util.Objects;

/**
 * 统一封装返回结果
 *
 * @author ly
 * @date 2020/8/4 14:23
 */

@ControllerAdvice
public class ResponseBodyConfig implements ResponseBodyAdvice<Object> {

//    @Override
//    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
//        RestController restController = methodParameter.getMethod().getDeclaringClass().getDeclaredAnnotation(RestController.class);
//        return Objects.nonNull(restController);
//    }
//
//    @Override
//    public Object beforeBodyWrite(Object body, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
//        if (null == body){
//            Class<?> returnClass = methodParameter.getParameterType();
//            // 返回类型是数组或者是集合
//            if (Collections.class.isAssignableFrom(returnClass) || returnClass.isArray()){
//                body = Collections.emptyList();
//            }
//            return ResultBuilder.success(body);
//        }
//        if (body.getClass() != Result.class && body.getClass() != String.class){
//            return ResultBuilder.success(body);
//        }
//        return body;
//    }

    /**
     * 判断是否要执行beforeBodyWrite方法
     *
     * @param returnType
     * @param aClass
     * @return bool
     */
    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> aClass) {
        return !returnType.getParameterType().equals(Response.class);
    }

    /**
     * 处理返回结果
     */
    @Override
    public Object beforeBodyWrite(Object body,
                                  MethodParameter returnType,
                                  MediaType mediaType,
                                  Class<? extends HttpMessageConverter<?>> aClass,
                                  ServerHttpRequest request,
                                  ServerHttpResponse response) {
        if (body instanceof Response) {
            return body;
        }
        if (body instanceof String) {
            return Response.success(String.valueOf(body));
        }
        return Response.success(body);
    }
}
