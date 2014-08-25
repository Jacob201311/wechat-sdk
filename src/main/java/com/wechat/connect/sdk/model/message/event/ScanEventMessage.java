package com.augmentum.wechat.connect.sdk.model.message.event;

import org.w3c.dom.Document;

import com.augmentum.wechat.connect.sdk.common.constant.Constants;
import com.augmentum.wechat.connect.sdk.util.XMLUtil;

public class ScanEventMessage extends EventMessage {

    private static final long serialVersionUID = 8362868248755671424L;

    private String eventKey;
    private String ticket;

    public ScanEventMessage() {
        super();
    }

    public ScanEventMessage(Document document) {
        super(document);
        eventKey = XMLUtil.getNodeContent(document, Constants.TEMPLATE_EVENT_KEY);
        ticket = XMLUtil.getNodeContent(document, Constants.TEMPLATE_EVENT_TICKET);
    }

    public String getEventKey() {
        return eventKey;
    }

    public void setEventKey(String eventKey) {
        this.eventKey = eventKey;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }
}
