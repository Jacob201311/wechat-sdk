package com.augmentum.wechat.connect.sdk.api;

import java.util.HashMap;
import java.util.Map;

import com.augmentum.wechat.connect.sdk.common.constant.Constants;
import com.augmentum.wechat.connect.sdk.common.exception.WechatSDKException;
import com.augmentum.wechat.connect.sdk.model.common.Authorization;
import com.augmentum.wechat.connect.sdk.model.common.Follower;
import com.augmentum.wechat.connect.sdk.model.common.FollowerContainer;
import com.augmentum.wechat.connect.sdk.util.PropertiesUtil;
import com.augmentum.wechat.connect.sdk.util.RequestUtil;

public class FollowerApi extends BaseApi {

    /**
     * get follower openId list, the pagination is 10,000
     * @param nextOpenId: optional
     * @return FollowerContainer
     * @throws WechatSDKException
     */
    public FollowerContainer getFollowerList(Authorization authorization, String... nextOpenId) throws WechatSDKException {
        String getFollowerListAPI = PropertiesUtil.getAPI(Constants.API_FOLOOLWER_LIST);
        Map<String, String> params = new HashMap<String, String>();
        params.put(Constants.ARG_ACCESS_TOKEN, authorization.getAccessToken());
        if (nextOpenId.length > 0) {
            params.put(Constants.ARG_NEXT_OPENID, nextOpenId[0]);
        }
        String result = RequestUtil.doGet(getFollowerListAPI, params);
        FollowerContainer followerContainer = this.wrapModel(result, FollowerContainer.class);
        return followerContainer;
    }

    /**
     * get follower info by its openId
     * @param openId
     * @return Follower
     * @throws WechatSDKException
     */
    public Follower getFollowerInfo(Authorization authorization, String openId) throws WechatSDKException {
        Map<String, String> params = new HashMap<String, String>();
        params.put(Constants.ARG_ACCESS_TOKEN, authorization.getAccessToken());
        params.put(Constants.ARG_OPENID, openId);
        String getFollowerInfoAPI = PropertiesUtil.getAPI(Constants.API_FOLOOLWER_INFO);
        String result = RequestUtil.doGet(getFollowerInfoAPI, params);
        Follower follower = this.wrapModel(result, Follower.class);
        return follower;
    }

}
