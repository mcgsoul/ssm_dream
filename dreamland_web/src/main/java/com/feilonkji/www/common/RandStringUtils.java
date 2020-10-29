package com.feilonkji.www.common;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Random;

/**
 * @title: RandStringUtils
 * @Description: 随机生成字符串工具类
 * @Author zr
 * @Date:2020/10/13 10:19
 * @Version 1.8
 */
public class RandStringUtils {

    private static final String[] HEADERS_TO_TRY = {
            "X-Forwarded-For",
            "Proxy-Client-IP",
            "WL-Proxy-Client-IP",
            "HTTP_X_FORWARDED_FOR",
            "HTTP_X_FORWARDED",
            "HTTP_X_CLUSTER_CLIENT_IP",
            "HTTP_CLIENT_IP",
            "HTTP_FORWARDED_FOR",
            "HTTP_FORWARDED",
            "HTTP_VIA",
            "REMOTE_ADDR",
            "X-Real-IP"};

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

    /**
     *
     * Description: 获取客户端ip地址
     * @param
     * @return java.lang.String 返回ip地址
     * @throws
     * @date 2020/10/29
     */
    public static String getClientIpAddress(){
        HttpServletRequest request = getRequest();
        String str = "unknown";
        for(String header: HEADERS_TO_TRY){
            String ip = request.getHeader(header);
            if(ip != null && ip.length() != 0 && str.equalsIgnoreCase(ip)){
                return ip;
            }
        }
        return request.getRemoteAddr();
    }

    public static HttpServletRequest getRequest(){
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        return requestAttributes.getRequest();
    }
}
