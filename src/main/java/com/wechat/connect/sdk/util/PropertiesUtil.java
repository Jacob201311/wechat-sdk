package com.wechat.connect.sdk.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.wechat.connect.sdk.common.constant.Constants;

public class PropertiesUtil {

    private static Properties properties;

    static {
        InputStream inputStream = PropertiesUtil.class.getResourceAsStream(Constants.PROPERTIES_PATH);
        properties = new Properties();
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getAPI(String apiName) {
        return properties.getProperty(apiName);
    }
}
