package com.wechat.api;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.wechat.model.common.Authorization;
import com.wechat.model.message.ImageMessage;
import com.wechat.model.message.MusicMessage;
import com.wechat.model.message.NewsItem;
import com.wechat.model.message.NewsMessage;
import com.wechat.model.message.TextMessage;
import com.wechat.model.message.VideoMessage;
import com.wechat.model.message.VoiceMessage;

public class CustomerServiceApiTest {
    private Authorization authorization;
    private CustomerServiceApi api;
    private static final String EXPECTED_RESULT = "{\"errcode\":0,\"errmsg\":\"ok\"}";

    @Before
    public void initAuthorization() {
        this.authorization = new OAuthApi().requestAuthorization();
        api = new CustomerServiceApi(authorization);
    }

    @Test
    public void replyTextMessageTest() {
        TextMessage message = new TextMessage();
        message.setToUserName("oT2H_toIK4snN9jrG5SeYcU41uBM");
        message.setContent("你好");
        String result = api.replyMessage(message);
        assertEquals(EXPECTED_RESULT, result);
    }

    @Test
    public void replyImageMessageTest() {
        ImageMessage message = new ImageMessage();
        message.setToUserName("oGyeWjr92EJfynsJgH6mTzx0JLFI");
        message.setMediaId("5GnXqPjlLt1i717dO7f5xeH2I0k540nsyrfY8No6f-4XEPlTBMLpcluJXAh_YiY3");
        String result = api.replyMessage(message);
        assertEquals(EXPECTED_RESULT, result);
    }

    @Test
    public void replyVoiceMessageTest() {
        VoiceMessage message = new VoiceMessage();
        message.setToUserName("oGyeWjr92EJfynsJgH6mTzx0JLFI");
        message.setMediaId("GJjqWuPCS9-kQ0y_7e2Jb1bQND4-exSWYwBafshkCESlNRrnRlwe6GW61g-fHqgj");
        String result = api.replyMessage(message);
        assertEquals(EXPECTED_RESULT, result);
    }

    @Test
    public void replyNewsMessageTest() {
        NewsMessage message = new NewsMessage();
        message.setToUserName("oGyeWjr92EJfynsJgH6mTzx0JLFI");
        message.addAtricle(new NewsItem("MAIN", null, "https://www.google.com.hk/images/srpr/logo11w.png", ""));
        message.addAtricle(new NewsItem("1", null, null, null));
        message.addAtricle(new NewsItem("2", null, null, "http://www.baidu.com"));
        String result = api.replyMessage(message);
        assertEquals(EXPECTED_RESULT, result);
    }

    @Test
    public void replyVideoMessageTest() {
        VideoMessage message = new VideoMessage();
        message.setToUserName("oT2H_toIK4snN9jrG5SeYcU41uBM");
        message.setMediaId("FNkaL_c3_53rPO39xGDd6I8JRh_5dK_i-SN_9M9Y6CAP6wMGbdJlkt5f5U3SSASz");
        message.setThumbMediaId("");
        String result = api.replyMessage(message);
        assertEquals(EXPECTED_RESULT, result);
    }

    @Test
    public void replyMusicMessageTest() {
        MusicMessage message = new MusicMessage();
        message.setToUserName("oGyeWjr92EJfynsJgH6mTzx0JLFI");
        message.setDescription("nice song");
        message.setMusicUrl("http://zhangmenshiting.baidu.com/data2/music/104012415/103950609118800128.mp3?xcode=dfdebea74f491bda3e00f3f5697537451c15019460481588");
        message.setTitle("your favourate");
        message.sethQMusicUrl("http://zhangmenshiting.baidu.com/data2/music/104012415/103950609118800128.mp3?xcode=dfdebea74f491bda3e00f3f5697537451c15019460481588");
        message.setThumbMediaId("PwyAPngZtGlfVmg9hgF4LlvglTXWucdJAmjXO0XoMLnn9ySoliQVE_6W04rv8PKb");
        String result = api.replyMessage(message);
        assertEquals(EXPECTED_RESULT, result);
    }
}
