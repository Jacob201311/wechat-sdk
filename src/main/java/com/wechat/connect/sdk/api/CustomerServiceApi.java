package com.wechat.connect.sdk.api;

import java.util.HashMap;
import java.util.Map;

import com.wechat.connect.sdk.common.constant.Constants;
import com.wechat.connect.sdk.common.exception.WechatSDKException;
import com.wechat.connect.sdk.model.common.Authorization;
import com.wechat.connect.sdk.model.common.ErrorResponse;
import com.wechat.connect.sdk.model.massivemsg.MassiveSendArg;
import com.wechat.connect.sdk.model.massivemsg.MpMsgSendResponse;
import com.wechat.connect.sdk.model.message.Message;
import com.wechat.connect.sdk.util.PropertiesUtil;
import com.wechat.connect.sdk.util.RequestUtil;

public class CustomerServiceApi extends BaseApi {

    /**
     * this method can be called since a follower send message to wechat account within 24 h
     * @param message
     * @return String
     */
    public String replyMessage(Authorization authorization, Message message) {
        String url = PropertiesUtil.getAPI(Constants.API_CUSTOMER_SERVICE);
        Map<String, String> params = new HashMap<String, String>();
        params.put(Constants.ARG_ACCESS_TOKEN, authorization.getAccessToken());
        String result = RequestUtil.doPost(url, params, message.toJSON());
        return result;
    }

    /**
     * 
     * @param groupArg
     * @return {"errcode":0,"errmsg":"send job submission success","msg_id":34182}
     * @throws WechatSDKException 
     */
    public MpMsgSendResponse groupSendMassiveMsg(Authorization authorization, MassiveSendArg groupArg) throws WechatSDKException {
        String groupSendAPI = PropertiesUtil.getAPI(Constants.API_MASSIVEMSG_GROUP_SEND);
        Map<String, String> params = new HashMap<String, String>();
        params.put(Constants.ARG_ACCESS_TOKEN, authorization.getAccessToken());
        String result = RequestUtil.doPost(groupSendAPI, params, groupArg.toGroupJSON());
        MpMsgSendResponse response = this.wrapModel(result, MpMsgSendResponse.class);
        return response;
    }

    /**
     * 
     * @param oidsArg
     * @return {"errcode":0,"errmsg":"send job submission success","msg_id":34182}
     * @throws WechatSDKException 
     */
    public MpMsgSendResponse oidsSendMassiveMsg(Authorization authorization, MassiveSendArg oidsArg) throws WechatSDKException {
        String oidsSendAPI = PropertiesUtil.getAPI(Constants.API_MASSIVEMSG_OIDS_SEND);
        Map<String, String> params = new HashMap<String, String>();
        params.put(Constants.ARG_ACCESS_TOKEN, authorization.getAccessToken());
        String result = RequestUtil.doPost(oidsSendAPI, params, oidsArg.toOidsJSON());
        MpMsgSendResponse response = this.wrapModel(result, MpMsgSendResponse.class);
        return response;
    }

    public ErrorResponse deleteMassiveMsg(Authorization authorization, long msgId) throws WechatSDKException {
        String jsonStr = 
                "{\n" +
                "\"msg_id\":%d\n" +
                "}";
        String oidsSendAPI = PropertiesUtil.getAPI(Constants.API_MASSIVEMSG_DELETE);
        Map<String, String> params = new HashMap<String, String>();
        params.put(Constants.ARG_ACCESS_TOKEN, authorization.getAccessToken());
        String result = RequestUtil.doPost(oidsSendAPI, params, String.format(jsonStr, msgId));
        ErrorResponse response= this.wrapModel(result, ErrorResponse.class);
        return response;
    }
}
