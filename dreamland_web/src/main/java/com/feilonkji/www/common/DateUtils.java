package com.feilonkji.www.common;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @title: DateUtils
 * @Description: 日期时间工具类
 * @Author zr
 * @Date:2020/10/30 17:03
 * @Version 1.8
 */
public class DateUtils {

    /**
     *
     * Description: 日期时间格式转换
     * @param dateStr 时间字符串
     * @param formatStr 指定的时间格式串
     * @return java.util.Date
     * @throws
     * @date 2020/10/30
     */
    public static Date StringToDate(String dateStr,String formatStr){
        DateFormat dateFormat = new SimpleDateFormat(formatStr);
        Date date = null;
        try {
            date = dateFormat.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
