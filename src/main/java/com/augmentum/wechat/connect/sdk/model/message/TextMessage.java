package com.augmentum.wechat.connect.sdk.model.message;

import org.w3c.dom.Document;

import com.augmentum.wechat.connect.sdk.common.constant.Constants;
import com.augmentum.wechat.connect.sdk.util.CommonUtil;
import com.augmentum.wechat.connect.sdk.util.XMLUtil;

public class TextMessage extends Message {

    private static final long serialVersionUID = 2842486242504602375L;

    private String content;

    public TextMessage() {
        super.setMessageType(Constants.MESSAGE_TYPE_TEXT);
    }

    public TextMessage(Message receivedMessage) {
        super(receivedMessage);
        super.setMessageType(Constants.MESSAGE_TYPE_TEXT);
    }

    public TextMessage(Message receivedMessage, String content) {
        super(receivedMessage);
        super.setMessageType(Constants.MESSAGE_TYPE_TEXT);
        this.content = content;
    }

    public TextMessage(String content) {
        this.content = content;
        super.setMessageType(Constants.MESSAGE_TYPE_TEXT);
    }

    public TextMessage(Document document) {
        super(document);
        content = XMLUtil.getNodeContent(document, Constants.TEMPLATE_TEXT_CONTENT);
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    private static final String XMLTemplate = "<Content><![CDATA[%s]]></Content>";
    private static final String JSONTemplate = "\"content\": \"%s\"";

    @Override
    public String toXML() {
        String baseTemplate = super.toXML();
        String data = String.format(XMLTemplate, content);
        return baseTemplate.replace(Constants.TEMPLATE_REEPLACE_STR, data);
    }

    @Override
    public String toJSON() {
        String baseTemplate = super.toJSON();
        String data = String.format(JSONTemplate, CommonUtil.escapeStr(content));
        return baseTemplate.replace(Constants.TEMPLATE_REEPLACE_STR, data);
    }

}
