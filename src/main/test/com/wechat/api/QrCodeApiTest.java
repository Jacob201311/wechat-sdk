package com.wechat.api;

import static org.junit.Assert.*;

import org.apache.http.HttpResponse;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import com.wechat.common.exception.WechatSDKException;
import com.wechat.model.common.Authorization;
import com.wechat.model.common.TempTicketArgs;
import com.wechat.model.common.Ticket;
import com.wechat.model.common.TicketArgs;

public class QrCodeApiTest {
    Logger logger = Logger.getLogger(QrCodeApiTest.class);

    private Authorization authorization;
    private QrCodeApi api;

    @Before
    public void initAuthorization() {
//        this.authorization = new OAuthApi().requestAuthorization();
            this.authorization = new Authorization("Ly02aV9aopp1gpcrYMPry3PXYOxWkEUtsD9LSuLTymQLxur_yskNFWWt7TWiqI25CydbllFZ9zvToba8fl0txZbx7I3aPzeTGH6zOZyqVRgN8BowmHgISB2KfYnawj73PjwNNH1fTT4wl-3dx5-PrQ", 7200);
            api = new QrCodeApi(authorization);
    }

    @Test
    public void requestPermanentTicketTest() {
        TicketArgs ticketArgs = new TicketArgs(1234);
        Ticket ticket = null;
        try {
            ticket = api.requestTicket(ticketArgs);
        } catch (WechatSDKException e) {
            e.printStackTrace();
        }
        assertNotNull(ticket);
        logger.info(ticket.getTicket() + "|" + ticket.getExpiredTime());
    }

    @Test
    public void requestTempTicketTest() {
        TicketArgs ticketArgs = new TempTicketArgs(1234, 100);
        Ticket ticket = null;
        try {
            ticket = api.requestTicket(ticketArgs);
        } catch (WechatSDKException e) {
            e.printStackTrace();
        }
        assertNotNull(ticket);
        logger.info(ticket.getTicket() + "|" + ticket.getExpiredTime());
    }

    @Test
    public void redeemTicketTest() {
        TicketArgs ticketArgs = new TicketArgs(1234);
        Ticket ticket = null;
        try {
            ticket = api.requestTicket(ticketArgs);
        } catch (WechatSDKException e) {
            e.printStackTrace();
        }
        HttpResponse response = api.redeemTicket(ticket);
        assertNotNull(response);
    }
}
