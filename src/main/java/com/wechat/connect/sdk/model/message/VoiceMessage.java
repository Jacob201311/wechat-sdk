package com.wechat.connect.sdk.model.message;

import org.w3c.dom.Document;

import com.wechat.connect.sdk.common.constant.Constants;
import com.wechat.connect.sdk.util.XMLUtil;

public class VoiceMessage extends Message {

    private static final long serialVersionUID = 1654393912545923974L;

    private String mediaId;
    private String format;
    private String recognition;

    public VoiceMessage() {
        this.setMessageType(Constants.MESSAGE_TYPE_VOICE);
    }

    public VoiceMessage(Message receivedMessage) {
        super(receivedMessage);
        this.setMessageType(Constants.MESSAGE_TYPE_VOICE);
    }

    public VoiceMessage(Document document) {
        super(document);
        mediaId = XMLUtil.getNodeContent(document, Constants.TEMPLATE_MEDIA_ID);
        format = XMLUtil.getNodeContent(document, Constants.TEMPLATE_VOICE_FORMAT);
        recognition = XMLUtil.getNodeContent(document, Constants.TEMPLATE_VOICE_RECOGNITION);
    }

    public VoiceMessage(String mediaId) {
        this.mediaId = mediaId;
        this.setMessageType(Constants.MESSAGE_TYPE_IMAGE);
    }

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getRecognition() {
        return recognition;
    }

    public void setRecognition(String recognition) {
        this.recognition = recognition;
    }

    private static final String XMLTemplate = "<Voice><MediaId><![CDATA[%s]]></MediaId></Voice>";
    private static final String JSONTemplate = "\"media_id\": \"%s\"";

    @Override
    public String toXML() {
        String baseTemplate = super.toXML();
        String data = String.format(XMLTemplate, mediaId);
        return baseTemplate.replace(Constants.TEMPLATE_REEPLACE_STR, data);
    }

    @Override
    public String toJSON() {
        String baseTemplate = super.toJSON();
        String data = String.format(JSONTemplate, mediaId);
        return baseTemplate.replace(Constants.TEMPLATE_REEPLACE_STR, data);
    }
}
