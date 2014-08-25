package com.augmentum.wechat.connect.sdk.util;

public class CommonUtil {

    public static String escapeStr(String str) {
        return str.replace("\\", "\\\\").replace("\"", "\\\"");
    }

}
