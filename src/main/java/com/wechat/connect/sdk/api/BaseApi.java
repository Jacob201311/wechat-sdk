package com.wechat.connect.sdk.api;

import com.wechat.connect.sdk.common.exception.WechatSDKException;
import com.wechat.connect.sdk.util.JSONUtil;

public abstract class BaseApi {

    protected <T> T wrapModel(String result, Class<T> clazz) throws WechatSDKException {
        T model = JSONUtil.JsonStr2Model(result, clazz);
        if (null == model) {
            throw new WechatSDKException(result);
        } else {
            return model;
        }
    }
}
