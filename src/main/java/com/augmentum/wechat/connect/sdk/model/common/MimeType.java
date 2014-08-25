package com.augmentum.wechat.connect.sdk.model.common;

public enum MimeType {

    IMAGE("image"),
    VOICE("voice"),
    VIDEO("video"),
    THUMB("thumb");

    private String type;

    MimeType (String type) {
        this.type = type;
    }

    public String toString() {
        return this.type;
    }
}
