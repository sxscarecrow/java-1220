package com.shenxu.zuul.domain.constant;

/**
 * 响应码枚举，参考HTTP状态码的语义
 */
public enum ResultEnum {

    /**
     * 成功
     */
    SUCCESS(10200, "操作成功"),
    /**
     * 数据为空
     */
    NO_DATA(10201, "无数据"),
    /**
     * 重复数据
     */
    REPEAT_DATA(10202, "重复数据"),
    /**
     * 无操作权限
     */
    ACCESS_NOT_OPERATION(10203, "无操作权限"),
    /**
     * 您的账号在其它设备已经登录
     */
    LOGIN_REPEAT_OPERATION(10204, "您的账号在其它设备已经登录"),
    /**
     * 失败
     */
    ERROR(10400, "服务错误"),
    /**
     * 未登录或未认证（签名错误）
     */
    UNAUTHORIZED(10401, "未登录（签名错误）"),
    /**
     * 用户名或密码错误
     */
    INCORRECT_CREDENTIALS(10402, "用户名或密码错误"),
    /**
     * 用户名或密码错误
     */
    USER_NOT_EXISTED(10403, "用户名或密码错误"),
    /**
     * 服务不存在
     */
    NOT_FOUND(10404, "服务不存在"),
    /**
     * 接口不存在
     */
    PARAM_ERROR(10405, "接口不存在"),
    /**
     * 服务器内部错误
     */
    INTERNAL_SERVER_ERROR(10500, "服务器错误"),
    /**
     * 服务器内部错误
     */
    INTERNAL_SERVER_NULLPOINTER_ERROR(10501, "数据对象为空"),
    /**
     * 服务器参数验证错误
     */
    REQUEST_SERVER_PARAM_ERROR(10504, "参数验证错误"),
    /**
     * 登陆过期
     */
    LOGIN_TOKEN_EXPIRE(10502, "登录已超时，请重新登录"),
    /**
     * 手机号长度不对
     */
    REG_MOBILE_CHECK_LENGTH_ERROR(10001, "手机号长度不对"),
    /**
     * 手机号已存在
     */
    REG_MOBILE_CHECK_EXIST(10002, "手机号已存在"),
    /**
     * 手机号格式不对
     */
    REG_MOBILE_CHECK_REG_ERROR(10003, "手机号格式不对"),
    /**
     * 邮箱格式不对
     */
    REG_EMAIL_CHECK_REG_ERROR(10004, "邮箱格式不正确");

    /**
     * 错误码
     */
    public int code;
    /**
     * 消息
     */
    public String msg;

    ResultEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
