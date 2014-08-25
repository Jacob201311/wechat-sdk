package com.augmentum.wechat.connect.sdk.model.massivemsg;

import com.augmentum.wechat.connect.sdk.common.exception.WechatSDKException;

public enum MassiveMsgType {

    TEXT(1, "text"), MPNEWS(2, "mpnews"), IMAGE(3, "image"), VOICE(4, "voice"), MPVIDEO(5, "mpvideo");

    private int type;
    private String typeValue;

    private MassiveMsgType(int type, String typeValue) {
        this.type = type;
        this.typeValue = typeValue;
    }

    public String getTypeStringValue() {
        return typeValue;
    }

    public int getTypeIntValue() {
        return type;
    }

    public static MassiveMsgType getMassiveMsgType(int type) throws WechatSDKException {
        for (MassiveMsgType massiveMsgType : MassiveMsgType.values()) {
            if (massiveMsgType.getTypeIntValue() == type) {
                return massiveMsgType;
            }
        }
        throw new WechatSDKException("No Massive Message Type For Type value: " + type);
    }

}
