package com.wechat.connect.sdk.model.common;

import org.codehaus.jackson.annotate.JsonProperty;

public class Media {

    private String type;
    @JsonProperty(value = "media_id")
    private String meidaId;
    @JsonProperty(value = "created_at")
    private long createdTime;

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getMeidaId() {
        return meidaId;
    }
    public void setMeidaId(String meidaId) {
        this.meidaId = meidaId;
    }
    public long getCreatedTime() {
        return createdTime;
    }
    public void setCreatedTime(long createdTime) {
        this.createdTime = createdTime;
    }

}
