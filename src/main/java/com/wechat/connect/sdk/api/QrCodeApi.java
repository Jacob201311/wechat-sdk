package com.wechat.connect.sdk.api;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpResponse;

import com.wechat.connect.sdk.common.constant.Constants;
import com.wechat.connect.sdk.common.exception.WechatSDKException;
import com.wechat.connect.sdk.model.common.Authorization;
import com.wechat.connect.sdk.model.common.Ticket;
import com.wechat.connect.sdk.model.common.TicketArgs;
import com.wechat.connect.sdk.util.PropertiesUtil;
import com.wechat.connect.sdk.util.RequestUtil;

public class QrCodeApi extends BaseApi {

    /**
     * request a ticket, the ticket can use to redeem the QR code
     * @param ticketArgs
     * @return Ticket
     * @throws WechatSDKException
     */
    public Ticket requestTicket(Authorization authorization, TicketArgs ticketArgs) throws WechatSDKException {
        String getTicketAPI = PropertiesUtil.getAPI(Constants.API_QRCODE_TICKET_CREATE);
        Map<String, String> params = new HashMap<String, String>();
        params.put(Constants.ARG_ACCESS_TOKEN, authorization.getAccessToken());
        String result = RequestUtil.doPost(getTicketAPI, params, ticketArgs.toString());
        Ticket ticket = this.wrapModel(result, Ticket.class);
        return ticket;
    }

    /**
     * the QR-Code image page
     * @param ticket
     * @return HttpResponse
     */
    public HttpResponse redeemTicket(Ticket ticket) {
        String redeemTicketAPI = PropertiesUtil.getAPI(Constants.API_QRCODE_TICKET_REDEEM);
        Map<String, String> params = new HashMap<String, String>();
        params.put(Constants.ARG_TICKET, ticket.getTicket());
        HttpResponse response = RequestUtil.doGetResource(redeemTicketAPI, params);
        return response;
    }

}
