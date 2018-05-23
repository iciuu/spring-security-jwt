package com.ng.howlongapi.util;


import lombok.extern.slf4j.Slf4j;
import sun.misc.BASE64Encoder;

import java.security.MessageDigest;

@Slf4j
public class WordEncode {

    public static String EncoderByMd5(String str){
        String newstr = null;
        try{
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            BASE64Encoder base64Encoder = new BASE64Encoder();
            newstr = base64Encoder.encode(md5.digest(str.getBytes("utf-8")));
        } catch (Exception e){
            log.error("加密密码失败",e);
        }
        return newstr;
    }
}
