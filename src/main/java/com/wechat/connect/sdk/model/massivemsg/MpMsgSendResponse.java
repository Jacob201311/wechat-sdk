package com.wechat.connect.sdk.model.massivemsg;

import org.codehaus.jackson.annotate.JsonProperty;

import com.augmentum.wechat.connect.sdk.model.common.ErrorResponse;

public class MpMsgSendResponse extends ErrorResponse {

    @JsonProperty("msg_id")
    private long msgId;

    public long getMsgId() {
        return msgId;
    }

    public void setMsgId(long msgId) {
        this.msgId = msgId;
    }
}
