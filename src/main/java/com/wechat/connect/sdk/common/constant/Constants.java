package com.augmentum.wechat.connect.sdk.common.constant;

public class Constants {

    public static final String TEMPLATE_REEPLACE_STR = "<_flag_>";

    public static final String TEMPLATE_COMMON_FROM_USER_NAME = "FromUserName";
    public static final String TEMPLATE_COMMON_TO_USER_NAME = "ToUserName";
    public static final String TEMPLATE_COMMON_CREATE_TIME = "CreateTime";
    public static final String TEMPLATE_COMMON_MESSAGE_TYPE = "MsgType";
    public static final String TEMPLATE_COMMON_MESSAGE_ID = "MsgId";
    public static final String TEMPLATE_COMMON_MESSAGE_ID_MP = "MsgID";
    public static final String TEMPLATE_TEXT_CONTENT = "Content";
    public static final String TEMPLATE_IMAGE_PICTURE_URL = "PicUrl";
    public static final String TEMPLATE_MEDIA_ID = "MediaId";
    public static final String TEMPLATE_VOICE_FORMAT = "Format";
    public static final String TEMPLATE_VOICE_RECOGNITION = "Recognition";
    public static final String TEMPLATE_VIDEO_THUMBMEDIA_ID = "ThumbMediaId";
    public static final String TEMPLATE_LOCATION_LOCATION_X = "Location_X";
    public static final String TEMPLATE_LOCATION_LOCATION_Y = "Location_Y";
    public static final String TEMPLATE_LOCATION_SCALE = "Scale";
    public static final String TEMPLATE_LOCATION_LABEL = "Label";
    public static final String TEMPLATE_LINK_TITLE = "Title";
    public static final String TEMPLATE_LINK_DESCRIPTION = "Description";
    public static final String TEMPLATE_LINK_URL = "Url";
    public static final String TEMPLATE_EVENT = "Event";
    public static final String TEMPLATE_EVENT_KEY = "EventKey";
    public static final String TEMPLATE_EVENT_TICKET = "Ticket";
    public static final String TEMPLATE_EVENT_LATITUDE = "Latitude";
    public static final String TEMPLATE_EVENT_LONGITUDE = "Longitude";
    public static final String TEMPLATE_EVENT_PRECISION = "Precision";
    public static final String TEMPLATE_EVENT_STATUS = "Status";
    public static final String TEMPLATE_EVENT_TOTALCOUNT = "TotalCount";
    public static final String TEMPLATE_EVENT_FILTERCOUNT = "FilterCount";
    public static final String TEMPLATE_EVENT_SENTCOUNT = "SentCount";
    public static final String TEMPLATE_EVENT_ERRORCOUNT = "ErrorCount";

    public static final String MESSAGE_TYPE_TEXT ="text";
    public static final String MESSAGE_TYPE_IMAGE ="image";
    public static final String MESSAGE_TYPE_LOCATION ="location";
    public static final String MESSAGE_TYPE_LINK ="link";
    public static final String MESSAGE_TYPE_MUSIC ="music";
    public static final String MESSAGE_TYPE_VOICE ="voice";
    public static final String MESSAGE_TYPE_VIDEO ="video";
    public static final String MESSAGE_TYPE_NEWS ="news";
    public static final String MESSAGE_TYPE_EVENT = "event";
    public static final String MESSAGE_TYPE_TRANSFER_CS = "transfer_customer_service";
    public static final String EVENT_TYPE_SUBSCRIBE = "subscribe";
    public static final String EVENT_TYPE_UNSUBSCRIBE = "unsubscribe";
    public static final String EVENT_TYPE_SCAN = "SCAN";
    public static final String EVENT_TYPE_CLICK = "CLICK";
    public static final String EVENT_TYPE_VIEW = "VIEW";
    public static final String EVENT_TYPE_LOCATION = "LOCATION";
    public static final String EVENT_TYPE_MASS_SEND_JOB_FINISH = "MASSSENDJOBFINISH";

    public static final String ARG_ACCESS_TOKEN = "access_token";
    public static final String ARG_APP_ID = "appid";
    public static final String ARG_APP_SECRET = "secret";
    public static final String ARG_EXPIRES_IN = "expires_in";
    public static final String ARG_MENU_BUTTON = "button";
    public static final String ARG_TICKET = "ticket";
    public static final String ARG_EXPIRE_SECONDS = "expire_seconds";
    public static final String ARG_NEXT_OPENID = "next_openid";
    public static final String ARG_OPENID = "openid";
    public static final String ARG_TO_GROUP_ID = "to_groupid";
    public static final String ARG_SUBSCRIBE = "subscribe";
    public static final String ARG_TOTAL = "total";
    public static final String ARG_MEDIA_TYPE = "type";
    public static final String ARG_MEDIA_ID = "media_id";
    public static final String ARG_GROUP = "group";

    public static final String RESPONSE_MESSAGE_ERRCODE = "errcode";
    public static final String RESPONSE_MESSAGE_ERRCODE_SUCCESS = "ok";

    public static final String PROPERTIES_PATH = "/wechat.api.properties";
    public static final String WECHAT_APP_ID = "app.id";
    public static final String WECHAT_APP_SECRET = "app.secret";
    public static final String API_ACCESS_TOKEN = "wechat.access.token";
    public static final String API_CUSTOMER_SERVICE = "wechat.customer.service";
    public static final String API_MENU_CREATE = "wechat.menu.create";
    public static final String API_MENU_GET = "wechat.menu.get";
    public static final String API_MENU_DELETE = "wechat.menu.delete";
    public static final String API_QRCODE_TICKET_CREATE = "wechat.qrcocde.ticket.create";
    public static final String API_QRCODE_TICKET_REDEEM = "wechat.qrcocde.ticket.redeem";
    public static final String API_FOLOOLWER_LIST = "wechat.follower.list";
    public static final String API_FOLOOLWER_INFO = "wechat.follower.info";
    public static final String API_GROUP_GET = "wechat.group.get";
    public static final String API_GROUP_CREATE = "wechat.group.create";
    public static final String API_GROUP_UPDATE = "wechat.group.update";
    public static final String API_GROUP_MOVE_USER = "wechat.group.mvuser";
    public static final String API_MEDIA_UPLOAD = "wechat.media.upload";
    public static final String API_MEDIA_DOWNLOAD = "wechat.media.download";
    public static final String API_MPNEWS_CREATE = "wechat.mpnews.create";
    public static final String API_MASSIVEMSG_GROUP_SEND = "wechat.msg.group.send";
    public static final String API_MASSIVEMSG_OIDS_SEND = "wechat.msg.oids.send";
    public static final String API_MASSIVEMSG_DELETE = "wechat.msg.delete";
}
