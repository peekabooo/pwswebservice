package com.pws.pwswebservice.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * File name：BaseJsonResponse
 * Author: Administrator
 * Description：JSON基础结构，包含响应码和响应消息，反馈给前台页面
 * Modify History:
 */
@Data
public class BaseJsonResponse implements Serializable, Cloneable {

    private String returnCode;//响应代码
    private String returnMsg;//错误消息

    public BaseJsonResponse() {
        this.returnCode = "";
        this.returnMsg = "";
    }

    public String getReturnCode() {
        return returnCode;
    }

    public String getReturnMsg() {
        return returnMsg;
    }

    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }

    public void setReturnMsg(String returnMsg) {
        this.returnMsg = returnMsg;
    }
}
