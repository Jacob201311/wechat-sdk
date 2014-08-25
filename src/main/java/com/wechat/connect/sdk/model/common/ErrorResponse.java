package com.augmentum.wechat.connect.sdk.model.common;

import org.codehaus.jackson.annotate.JsonProperty;

public class ErrorResponse {
    @JsonProperty("errcode")
    private int errorCode;
    @JsonProperty("errmsg")
    private String errorMsg;

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
