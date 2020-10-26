package com.feilonkji.www.common;

import java.util.Random;

/**
 * @title: RandStringUtils
 * @Description: 随机生成字符串工具类
 * @Author zr
 * @Date:2020/10/13 10:19
 * @Version 1.8
 */
public class RandStringUtils {

    /**
     *
     * Description: 随机生成指定位数的数字字符串
     * @param nums 生成的数字位数
     * @return java.lang.String
     * @throws
     * @date 2020/10/13
     */
    public static String getCode(int nums){
        Random random = new Random();
        StringBuffer stringBuffer = new StringBuffer();
        for(int i=0;i<nums;i++){
            int ran = random.nextInt(10);
            stringBuffer.append(ran);
        }
        return stringBuffer.toString();
    }
}
