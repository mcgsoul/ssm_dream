package com.feilonkji.www.common;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @title: MD5Util
 * @Description: md5加密工具类
 * @Author zr
 * @Date:2020/9/27 21:26
 * @Version 1.8
 */
public class MD5Util {

    /**
     *
     * Description: 将源字符串进行md5加密为字节数组
     * @param source
     * @return byte[]
     * @throws
     * @date 2020/9/27
     */
    public static byte[] encodeToBytes(String source){
        byte[] result = null;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            //重置
            messageDigest.reset();
            //添加加密源
            messageDigest.update(source.getBytes());
            //加密
            result = messageDigest.digest();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }
}
