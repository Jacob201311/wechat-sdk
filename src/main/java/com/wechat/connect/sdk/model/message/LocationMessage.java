package com.augmentum.wechat.connect.sdk.model.message;

import org.w3c.dom.Document;

import com.augmentum.wechat.connect.sdk.common.constant.Constants;
import com.augmentum.wechat.connect.sdk.util.XMLUtil;

public class LocationMessage extends Message {

    private static final long serialVersionUID = 2196040554682426103L;

    private Double latitude;
    private Double longitude;
    private int scale;
    private String label;

    public LocationMessage() {
        this.setMessageType(Constants.MESSAGE_TYPE_LOCATION);
    }

    public LocationMessage(Document document) {
        super(document);
        latitude = Double.valueOf(XMLUtil.getNodeContent(document, Constants.TEMPLATE_LOCATION_LOCATION_X));
        longitude = Double.valueOf(XMLUtil.getNodeContent(document, Constants.TEMPLATE_LOCATION_LOCATION_Y));
        scale = Integer.valueOf(XMLUtil.getNodeContent(document, Constants.TEMPLATE_LOCATION_SCALE));
        label = XMLUtil.getNodeContent(document, Constants.TEMPLATE_LOCATION_LABEL);
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public int getScale() {
        return scale;
    }

    public void setScale(int scale) {
        this.scale = scale;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

}
