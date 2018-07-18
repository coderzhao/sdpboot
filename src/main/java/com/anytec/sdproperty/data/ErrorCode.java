package com.anytec.sdproperty.data;

/**
 * Created by xuxinjian on 15/12/2.
 * web api返回的错误码 ，  errorCode
 */
public class ErrorCode {
    public final static int EC_OK = 0;//正常
    public final static int EC_INVALID_REQUEST = 100;//sign不对， 非法请求
    public final static int EC_INVALID_SESSIONID = 101;//SESSIONID过期
    public final static int EC_INVALID_PASSWORD = 102;//用户名密码错误
    public final static int EC_INVALID_PARAM = 103;//非法参数

    public final static int EC_ERROR = 1000;//其他错误
}
