package com.wechat.connect.sdk.api;

import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.wechat.connect.sdk.common.constant.Constants;
import com.wechat.connect.sdk.model.message.ImageMessage;
import com.wechat.connect.sdk.model.message.LinkMessage;
import com.wechat.connect.sdk.model.message.LocationMessage;
import com.wechat.connect.sdk.model.message.Message;
import com.wechat.connect.sdk.model.message.TextMessage;
import com.wechat.connect.sdk.model.message.VideoMessage;
import com.wechat.connect.sdk.model.message.VoiceMessage;
import com.wechat.connect.sdk.model.message.event.ClickEventMessage;
import com.wechat.connect.sdk.model.message.event.EventMessage;
import com.wechat.connect.sdk.model.message.event.LocationEventMessage;
import com.wechat.connect.sdk.model.message.event.MSendCallbackEventMessage;
import com.wechat.connect.sdk.model.message.event.ScanEventMessage;
import com.wechat.connect.sdk.model.message.event.ViewEventMessage;
import com.wechat.connect.sdk.util.XMLUtil;

public class MessageConverterApi {

    private static Map<String, Class<? extends Message>> msgTypeModelMap;
    static {
        msgTypeModelMap = new HashMap<String, Class<? extends Message>>();
        msgTypeModelMap.put(Constants.MESSAGE_TYPE_TEXT, TextMessage.class);
        msgTypeModelMap.put(Constants.MESSAGE_TYPE_IMAGE, ImageMessage.class);
        msgTypeModelMap.put(Constants.MESSAGE_TYPE_LOCATION, LocationMessage.class);
        msgTypeModelMap.put(Constants.MESSAGE_TYPE_LINK, LinkMessage.class);
        msgTypeModelMap.put(Constants.MESSAGE_TYPE_VOICE, VoiceMessage.class);
        msgTypeModelMap.put(Constants.MESSAGE_TYPE_VIDEO, VideoMessage.class);
        msgTypeModelMap.put(Constants.EVENT_TYPE_SUBSCRIBE, EventMessage.class);
        msgTypeModelMap.put(Constants.EVENT_TYPE_UNSUBSCRIBE, EventMessage.class);
        msgTypeModelMap.put(Constants.EVENT_TYPE_SCAN, ScanEventMessage.class);
        msgTypeModelMap.put(Constants.EVENT_TYPE_LOCATION, LocationEventMessage.class);
        msgTypeModelMap.put(Constants.EVENT_TYPE_CLICK, ClickEventMessage.class);
        msgTypeModelMap.put(Constants.EVENT_TYPE_VIEW, ViewEventMessage.class);
        msgTypeModelMap.put(Constants.EVENT_TYPE_MASS_SEND_JOB_FINISH, MSendCallbackEventMessage.class);
    }

    /**
     * convert the post data to Message model
     * @param xmlIs
     * @return Message
     */
    public Message xml2Message(InputStream xmlIs) {
        Document document = XMLUtil.getDocument(xmlIs);
        Node node = document.getElementsByTagName(Constants.TEMPLATE_COMMON_MESSAGE_TYPE).item(0);
        String messageType = node.getTextContent();
        Class<? extends Message> clazz = null;
        if (messageType.equals(Constants.MESSAGE_TYPE_EVENT)) {
            node = document.getElementsByTagName(Constants.TEMPLATE_EVENT).item(0);
            String eventType = node.getTextContent();
            clazz =  msgTypeModelMap.get(eventType);
            if (Constants.EVENT_TYPE_SUBSCRIBE.equals(eventType)) {
                NodeList eventKey = document.getElementsByTagName(Constants.TEMPLATE_EVENT_KEY);
                if (eventKey.getLength() != 0 && !"".equals(eventKey.item(0).getTextContent())) {
                    clazz =  msgTypeModelMap.get(Constants.EVENT_TYPE_SCAN);
                }
            }
        } else {
            clazz =  msgTypeModelMap.get(messageType);
        }
        Message message = null;
        try {
            Constructor<? extends Message> constructor = clazz.getConstructor(Document.class);
            message = constructor.newInstance(document);
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return message;
    }

    /**
     * convert the post data to Message model
     * @param xmlStr
     * @return Message
     */
    public Message xml2Message(String xmlStr) {
        Document document = XMLUtil.getDocument(xmlStr);
        Node node = document.getElementsByTagName(Constants.TEMPLATE_COMMON_MESSAGE_TYPE).item(0);
        String messageType = node.getTextContent();
        Class<? extends Message> clazz = null;
        if (messageType.equals(Constants.MESSAGE_TYPE_EVENT)) {
            node = document.getElementsByTagName(Constants.TEMPLATE_EVENT).item(0);
            String eventType = node.getTextContent();
            clazz =  msgTypeModelMap.get(eventType);
        } else {
            clazz =  msgTypeModelMap.get(messageType);
        }
        Message message = null;
        try {
            Constructor<? extends Message> constructor = clazz.getConstructor(Document.class);
            message = constructor.newInstance(document);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return message;
    }
}
