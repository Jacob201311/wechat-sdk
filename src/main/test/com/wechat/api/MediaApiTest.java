package com.wechat.api;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import com.wechat.common.exception.WechatSDKException;
import com.wechat.model.common.Authorization;
import com.wechat.model.common.Media;
import com.wechat.model.common.MimeType;

public class MediaApiTest {

    Logger logger = Logger.getLogger(MediaApiTest.class);

    private Authorization authorization;
    private MediaApi api;

    @Before
    public void initAuthorization() {
        this.authorization = new OAuthApi().requestAuthorization();
//            this.authorization = new Authorization("Ly02aV9aopp1gpcrYMPry3PXYOxWkEUtsD9LSuLTymQLxur_yskNFWWt7TWiqI25CydbllFZ9zvToba8fl0txZbx7I3aPzeTGH6zOZyqVRgN8BowmHgISB2KfYnawj73PjwNNH1fTT4wl-3dx5-PrQ", 7200);
            api = new MediaApi(authorization);
    }


    @Test
    public void uploadTest() {
        String filePath = "D:/image/4.jpg";
        Media media = null;
        try {
            media = api.uploadMediaMaterial(filePath, MimeType.IMAGE);
        } catch (WechatSDKException e) {
            e.printStackTrace();
        }
        assertNotNull(media);
        logger.info(media.getType() + "|" + media.getMeidaId() + "|" + media.getCreatedTime());
    }

    @Test
    public void downloadTest() {
        HttpResponse response = api.downloadMeidaMaterial("OrGTSbP321h8c4DNBO9X0GCvCnIKStELVvLzJtIOHVEdPfwAkVSi1C6q8O4um9w-");
        System.out.println(downloadImage(response, "D:/file/", ""));
        assertNotNull(response);
    }

    private static Map<String, String> mediaType;
    static {
        mediaType = new HashMap<String, String>();
        mediaType.put("image/jpeg", ".jpg");
        mediaType.put("audio/mp3", ".mp3");
        mediaType.put("audio/amr", ".amr");
        mediaType.put("video/mpeg4", ".mp4");
        mediaType.put("text/plain", ".mp4");
    }

    private static String downloadImage(HttpResponse response, String basePath, String filePositionPath) {
        HttpEntity entity = response.getEntity();
        String contentType = entity.getContentType().getValue();
        String fileName = new Date().getTime() + (String)mediaType.get(contentType);
        File dir = new File(basePath + filePositionPath);
        File file = new File(basePath + filePositionPath + fileName);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        try {
            FileOutputStream fos = new FileOutputStream(file);
            entity.writeTo(fos);
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        }
        return filePositionPath + fileName;
    }
}
