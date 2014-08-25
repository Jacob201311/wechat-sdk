package com.augmentum.wechat.connect.sdk.util;

import java.io.IOException;
import java.util.Map;

import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonParser.Feature;
import org.codehaus.jackson.map.ObjectMapper;

public class JSONUtil {

    private static Logger logger = Logger.getLogger(JSONUtil.class);

    private JSONUtil() {}

    private static ObjectMapper mapper = new ObjectMapper();

    static {
        mapper.configure(Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
    }

    @SuppressWarnings("unchecked")
    public static Map<String, Object> jsonStr2Map(String jsonStr) {
        Map<String, Object> result = null;
        try {
            result = mapper.readValue(jsonStr, Map.class);
        } catch (IOException e) {
            logger.error(jsonStr, e);
        }
        return result;
    }

    public static String Map2JsonStr(Map<String, Object> map) {
        String jsonStr = null;
        try {
            jsonStr = mapper.writeValueAsString(map);
        } catch (IOException e) {
            logger.error(e);
        }
        return jsonStr;
    }

    public static <T> T JsonStr2Model(String jsonStr, Class<T> clazz) {
        T model = null;
        try {
            model = mapper.readValue(jsonStr, clazz);
        } catch (IOException e) {
            logger.error(jsonStr, e);
        }
        return model;
    }

}
