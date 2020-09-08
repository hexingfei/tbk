package cn.tbk.enums;

import lombok.Getter;

/**
 * @ClassName ResultEnum
 * @Author rhb
 * @Description 请求结果集枚举
 * @Date 2018-12-17
 * @Version 1.0
 **/
@Getter
public enum ResultEnum implements CodeEnum{
    SUCCESS(0, "请求成功"),
    ERROR(300, "请求失败"),
    COMMON_CODE_ERROR(901,"系统未知异常"),
    MAIL_PARAM_EXCEPT(801,"邮件发送参数异常"),
    HOST_PARAM_EXCEPT(701,"ip端口参数异常"),
    SMS_PARAM_EXCEPT(601,"短信发送参数异常"),

    WEAK_NET_WORK(-1, "网络异常，请稍后重试");

    private Integer code;
    /** 请求结果返回内容信息 */
    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
