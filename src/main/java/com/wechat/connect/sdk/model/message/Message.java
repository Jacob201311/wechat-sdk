package com.augmentum.wechat.connect.sdk.model.message;

import java.io.Serializable;
import java.util.Date;

import org.w3c.dom.Document;

import com.augmentum.wechat.connect.sdk.common.constant.Constants;
import com.augmentum.wechat.connect.sdk.util.XMLUtil;

public abstract class Message implements Serializable {

    private static final long serialVersionUID = 3603509452147684251L;
    private String fromUserName;
    private String toUserName;
    private long createTime;
    private String messageType;
    private String messageId;

    public Message() {};

    public Message(Document document) {
        fromUserName = XMLUtil.getNodeContent(document, Constants.TEMPLATE_COMMON_FROM_USER_NAME);
        toUserName = XMLUtil.getNodeContent(document, Constants.TEMPLATE_COMMON_TO_USER_NAME);
        createTime = Long.valueOf(XMLUtil.getNodeContent(document, Constants.TEMPLATE_COMMON_CREATE_TIME));
        messageType = XMLUtil.getNodeContent(document, Constants.TEMPLATE_COMMON_MESSAGE_TYPE);
        messageId = XMLUtil.getNodeContent(document, Constants.TEMPLATE_COMMON_MESSAGE_ID);
        if ("".equals(messageId)) { // mp MsgID
            messageId = XMLUtil.getNodeContent(document, Constants.TEMPLATE_COMMON_MESSAGE_ID_MP);
        }
    }

    public Message(Message receivedMessage) {
        fromUserName = receivedMessage.toUserName;
        toUserName = receivedMessage.fromUserName;
    }

    public String getFromUserName() {
        return fromUserName;
    }

    public void setFromUserName(String fromUserName) {
        this.fromUserName = fromUserName;
    }

    public String getToUserName() {
        return toUserName;
    }

    public void setToUserName(String toUserName) {
        this.toUserName = toUserName;
    }

    public String getMessageType() {
        return messageType;
    }

    protected void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    private static String messageXMLTemplate =
        "<xml>" + "\n" +
        "<FromUserName><![CDATA[%s]]></FromUserName>" + "\n" +
        "<ToUserName><![CDATA[%s]]></ToUserName>" + "\n" +
        "<CreateTime>%s</CreateTime>" + "\n" +
        "<MsgType><![CDATA[%s]]></MsgType>" + "\n" +
        "%s" + "\n" +
        "</xml>";

    private static String messageJSONTemplate =
        "{" + "\n" +
        "  \"touser\": \"%s\"," + "\n" +
        "  \"msgtype\": \"%s\"," + "\n" +
        "  \"%s\":" + "\n" +
        "    {" + "\n" +
        "        %s" + "\n" +
        "    }" + "\n" +
        "}";

    public String toXML() {
        createTime = new Date().getTime() / 1000;
        return String.format(messageXMLTemplate, fromUserName, toUserName, createTime, messageType, Constants.TEMPLATE_REEPLACE_STR);
    }

    public String toJSON() {
        return String.format(messageJSONTemplate, toUserName, messageType, messageType, Constants.TEMPLATE_REEPLACE_STR);
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }
}
