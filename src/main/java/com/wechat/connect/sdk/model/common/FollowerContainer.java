package com.wechat.connect.sdk.model.common;

import java.util.Map;

import org.codehaus.jackson.annotate.JsonProperty;

public class FollowerContainer {

    private String total;

    private String count;

    private Map<String, Object> data;

    @JsonProperty(value = "next_openid")
    private String nextOpenId;

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    public String getNextOpenId() {
        return nextOpenId;
    }

    public void setNextOpenId(String nextOpenId) {
        this.nextOpenId = nextOpenId;
    }

}
