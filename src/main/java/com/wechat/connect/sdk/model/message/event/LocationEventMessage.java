package com.augmentum.wechat.connect.sdk.model.message.event;

import org.w3c.dom.Document;

import com.augmentum.wechat.connect.sdk.common.constant.Constants;
import com.augmentum.wechat.connect.sdk.util.XMLUtil;

public class LocationEventMessage extends EventMessage {

    private static final long serialVersionUID = -8250444793139051438L;

    private double latitude;
    private double longitude;
    private double precision;

    public LocationEventMessage() {
        this.setEvent(Constants.EVENT_TYPE_LOCATION);
    }

    public LocationEventMessage(Document document) {
        super(document);
        latitude = Double.valueOf(XMLUtil.getNodeContent(document, Constants.TEMPLATE_EVENT_LATITUDE));
        longitude = Double.valueOf(XMLUtil.getNodeContent(document, Constants.TEMPLATE_EVENT_LONGITUDE));
        precision = Double.valueOf(XMLUtil.getNodeContent(document, Constants.TEMPLATE_EVENT_PRECISION));
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getPrecision() {
        return precision;
    }

    public void setPrecision(double precision) {
        this.precision = precision;
    }
}
