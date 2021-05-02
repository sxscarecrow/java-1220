package com.shenxu.zuul.domain.result;

import com.shenxu.zuul.domain.constant.ResultEnum;
import com.shenxu.zuul.util.JsonUtils;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 统一API响应结果封装
 *
 * @author shenxu
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PACKAGE)
public class Result implements Serializable {

    private static final long serialVersionUID = -8673449371126308022L;

    private int code;
    private String msg;
    private Object data;
    private String requestId;

    public Result setResult(ResultEnum result) {
        this.code = result.code;
        this.msg = result.msg;
        return this;
    }

    public Result setData(Object data) {
        this.data = data;
        return this;
    }

    public Result addMessage(String message) {
        if (this.msg == null) {
            this.msg = message;
        } else {
            this.msg = message;
        }
        return this;
    }

    @Override
    public String toString() {
        return JsonUtils.toJsonString(this);
    }
}