package com.feilonkji.www.common;

import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import sun.security.provider.MD5;

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
     * @return byte[] 返回的是加密后的字节数组
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
        return result;
    }

    /**
     *
     * Description: 将源字符串通过MD5加密为32位16进制数
     * @param source
     * @return java.lang.String
     * @throws
     * @date 2020/9/28
     */
    public static String encodeToHex(String source){
        //先加密为字节数组
        byte[] data = encodeToBytes(source);
        StringBuffer stringBuffer = new StringBuffer();
        for(int i=0;i<data.length;i++){
            String hex = Integer.toHexString(0xff & data[i]);
            if(hex.length() == 1){
                stringBuffer.append("0");
            }
            stringBuffer.append(hex);
        }
        return stringBuffer.toString();
    }

    /**
     *
     * Description: 验证字符串是否匹配
     * @param unknown 待验证的字符串
     * @param okHex 使用MD5加密后的16进制字符串
     * @return boolean
     * @throws
     * @date 2020/9/28
     */
    public static boolean validate(String unknown,String okHex){
        return okHex.equals(encodeToHex(unknown));
    }

    public static void main(String[] args) {
        String password = new Md5PasswordEncoder().encodePassword("123456","12344@qq.com");
        System.out.println(password);
    }

}















