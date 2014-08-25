package com.wechat.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.http.HttpResponse;
import org.apache.http.entity.mime.Header;
import org.xml.sax.SAXException;

import com.wechat.api.BaseApi;
import com.wechat.api.CustomerServiceApi;
import com.wechat.api.GroupApi;
import com.wechat.api.MediaApi;
import com.wechat.api.MenuApi;
import com.wechat.api.MessageConverterApi;
import com.wechat.api.OAuthApi;
import com.wechat.api.QrCodeApi;
import com.wechat.api.FollowerApi;
import com.wechat.common.exception.WechatSDKException;
import com.wechat.model.common.Authorization;
import com.wechat.model.common.Follower;
import com.wechat.model.common.FollowerContainer;
import com.wechat.model.common.Group;
import com.wechat.model.common.GroupContainer;
import com.wechat.model.common.Media;
import com.wechat.model.common.MimeType;
import com.wechat.model.common.TempTicketArgs;
import com.wechat.model.common.Ticket;
import com.wechat.model.common.TicketArgs;
import com.wechat.model.message.ImageMessage;
import com.wechat.model.message.Message;
import com.wechat.model.message.MusicMessage;
import com.wechat.model.message.NewsItem;
import com.wechat.model.message.NewsMessage;
import com.wechat.model.message.TextMessage;
import com.wechat.model.message.VideoMessage;
import com.wechat.model.message.VoiceMessage;
import com.wechat.util.XMLUtil;

public class Test {

    public static void main(String[] args) throws WechatSDKException, IOException {

//        OAuthApi authApi = new OAuthApi();
//        Authorization authorization = authApi.requestAuthorization();
//        Authorization authorization = new Authorization("xVXm16bNoiWiiPxd1iZVS_A7V67eFO5UiFPWktzB4wfg6tPOuaa-quXhivT-oBZxcZ-c7VK3tiu0Ji9IKHrBNTAn8Hpmv3qYB1nr_v7_NIMvmGE-nEgM_LIfacLwCzzyauAtnzdtNt1kwc4IN4dNUQ", 7200);
        //=========================== media ================================
//        MediaApi mediaApi = new MediaApi(authorization);

//        String filePath = "D:/image/6.jpg"; // upload image
//        Media media = mediaApi.uploadMediaMaterial(filePath, MimeType.IMAGE);
//        System.out.println(media.getType() + "|" + media.getMeidaId() + "|" + media.getCreatedTime());
        
//        HttpResponse response = mediaApi.downloadMeidaMaterial("s6xm5Sl7SPCzwvlZXGb07eHdgkS_7UFS1E7RJV0f4tg1V56l7u4ry_FgUAvEGB2t"); // download image
//        File file = new File("D:/image/tteesstt44444.jpg");
//        OutputStream os = new FileOutputStream(file);
//        response.getEntity().writeTo(os);
//        System.out.println("download finished");

//        String filePath = "D:/image/voice.amr"; // upload voice
//        Media media = mediaApi.uploadMediaMaterial(filePath, MimeType.VOICE);
//        System.out.println(media.getType() + "|" + media.getMeidaId() + "|" + media.getCreatedTime());
        
//        HttpResponse response = mediaApi.downloadMeidaMaterial("GJjqWuPCS9-kQ0y_7e2Jb1bQND4-exSWYwBafshkCESlNRrnRlwe6GW61g-fHqgj"); // download voice
//        File file = new File("D:/image/tteesstt222.amr");
//        OutputStream os = new FileOutputStream(file);
//        response.getEntity().writeTo(os);
//        System.out.println("download finished");

//        String filePath = "D:/image/20131125_100243.mp4"; // upload video
//        Media media = mediaApi.uploadMediaMaterial(filePath, MimeType.VIDEO); //PwyAPngZtGlfVmg9hgF4LlvglTXWucdJAmjXO0XoMLnn9ySoliQVE_6W04rv8PKb
//        System.out.println(media.getType() + "|" + media.getMeidaId() + "|" + media.getCreatedTime());
//        
//        HttpResponse response = mediaApi.downloadMeidaMaterial(media.getMeidaId()); // download video
//        File file = new File("D:/image/tteesstt333.mp4");
//        OutputStream os = new FileOutputStream(file);
//        response.getEntity().writeTo(os);
//        System.out.println("download finished");

        //========================== group ==================================
//        GroupApi groupApi = new GroupApi(authorization);

//        Group group = new Group("New_Test111"); // create group
//        group = groupApi.createGroup(group);
//        System.out.println(group.getName() + "|" + group.getId());

//        GroupContainer groupContainer = groupApi.getGroup(); // get group info
//        System.out.println(groupContainer.getGroups().get(3));

//        Group group = new Group(102, "TEST1234"); // rename group
//        System.out.println(groupApi.renameGroup(group));

//        System.out.println(groupApi.moveUserTo("oGyeWjr92EJfynsJgH6mTzx0JLFI", 102)); // move user to

        //========================== follower =================================
//        FollowerApi followerApi = new FollowerApi(authorization);
        
//        FollowerContainer followerContainer = followerApi.getFollowerList(); // get follower list
//        System.out.println(followerContainer.getTotal() + "|" + followerContainer.getNextOpenId() + "|" + followerContainer.getCount());
        
//        Follower follower = followerApi.getFollowerInfo("oGyeWjr92EJfynsJgH6mTzx0JLFI"); // get follower info
//        System.out.println(follower.getOpenId() + "|" + follower.getHeadImageURL() + "|" + follower.getCity());

        //========================== menu ====================================
//        MenuApi menuApi = new MenuApi(authorization);

//        System.out.println(menuApi.getMenu()); // get menu

        //========================== QR code ===================================
//        QrCodeApi qrCodeApi = new QrCodeApi(authorization);

//        TicketArgs ticketArgs = new TicketArgs(1234); // request permanent ticket
//        Ticket ticket = qrCodeApi.requestTicket(ticketArgs);
//        System.out.println(ticket.getTicket() + "|" + ticket.getExpiredTime());
//        
//        HttpResponse response = qrCodeApi.redeemTicket(ticket); // redeem ticket
//        File file = new File("D:/image/QRCODE.jpg");
//        OutputStream os = new FileOutputStream(file);
//        response.getEntity().writeTo(os);
//        System.out.println("download finished");

//        TicketArgs ticketArgs = new TempTicketArgs(1234, 100); // request temporary ticket
//        Ticket ticket = qrCodeApi.requestTicket(ticketArgs);
//        System.out.println(ticket.getTicket() + "|" + ticket.getExpiredTime());
//      
//        HttpResponse response = qrCodeApi.redeemTicket(ticket); // redeem ticket
//        File file = new File("D:/image/QRCODETEMP.jpg");
//        OutputStream os = new FileOutputStream(file);
//        response.getEntity().writeTo(os);
//        System.out.println("download finished");

        //========================== customer service ==============================
//        CustomerServiceApi customerServiceApi = new CustomerServiceApi(authorization);
        
//        TextMessage message = new TextMessage(); // text
//        message.setToUserName("oGyeWjr92EJfynsJgH6mTzx0JLFI");
//        message.setContent("TEST CUSTOMER SERVICE");
        
//        ImageMessage message = new ImageMessage(); // image
//        message.setToUserName("oGyeWjr92EJfynsJgH6mTzx0JLFI");
//        message.setMediaId("5GnXqPjlLt1i717dO7f5xeH2I0k540nsyrfY8No6f-4XEPlTBMLpcluJXAh_YiY3");
        
//        VoiceMessage message = new VoiceMessage(); // voice
//        message.setToUserName("oGyeWjr92EJfynsJgH6mTzx0JLFI");
//        message.setMediaId("GJjqWuPCS9-kQ0y_7e2Jb1bQND4-exSWYwBafshkCESlNRrnRlwe6GW61g-fHqgj");
        
//        NewsMessage message = new NewsMessage(); // news
//        message.setToUserName("oGyeWjr92EJfynsJgH6mTzx0JLFI");
//        message.addAtricle(new NewsItem("MAIN", null, "https://www.google.com.hk/images/srpr/logo11w.png", ""));
//        message.addAtricle(new NewsItem("1", null, null, null));
//        message.addAtricle(new NewsItem("2", null, null, "http://www.baidu.com"));
        
//        VideoMessage message = new VideoMessage(); //video
//        message.setToUserName("oGyeWjr92EJfynsJgH6mTzx0JLFI");
//        message.setMediaId("PwyAPngZtGlfVmg9hgF4LlvglTXWucdJAmjXO0XoMLnn9ySoliQVE_6W04rv8PKb");
//        message.setThumbMediaId("PwyAPngZtGlfVmg9hgF4LlvglTXWucdJAmjXO0XoMLnn9ySoliQVE_6W04rv8PKb");
        
//        MusicMessage message = new MusicMessage(); //music
//        message.setToUserName("oGyeWjr92EJfynsJgH6mTzx0JLFI");
//        message.setDescription("nice song");
//        message.setMusicUrl("http://zhangmenshiting.baidu.com/data2/music/104012415/103950609118800128.mp3?xcode=dfdebea74f491bda3e00f3f5697537451c15019460481588");
//        message.setTitle("your favourate");
//        message.sethQMusicUrl("http://zhangmenshiting.baidu.com/data2/music/104012415/103950609118800128.mp3?xcode=dfdebea74f491bda3e00f3f5697537451c15019460481588");
//        message.setThumbMediaId("PwyAPngZtGlfVmg9hgF4LlvglTXWucdJAmjXO0XoMLnn9ySoliQVE_6W04rv8PKb");
        
//        System.out.println(customerServiceApi.replyMessage(message));

        //============================== model ================================
        MessageConverterApi converterApi = new MessageConverterApi();
        String subscribe = "<xml><ToUserName><![CDATA[toUser]]></ToUserName><FromUserName><![CDATA[FromUser]]></FromUserName><CreateTime>123456789</CreateTime><MsgType><![CDATA[event]]></MsgType><Event><![CDATA[subscribe]]></Event></xml>";
        Message message = converterApi.xml2Message(subscribe);
        TextMessage textMessage = new TextMessage(message, "hello");
        System.out.println(textMessage.toXML());
    }
}
