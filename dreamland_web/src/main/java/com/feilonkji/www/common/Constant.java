package com.feilonkji.www.common;

/**
 * @title: Constant
 * @Description: 常量类
 * @Author zr
 * @Date:2020/9/29 11:44
 * @Version 1.8
 */
public class Constant {

    /**账户激活状态码1,表示激活*/
    public static final String STATE_ONE = "1";

    /**账户激活状态码0，表示未激活*/
    public static final String STATE_ZERO = "0";

    /**账户可用状态码1，1表示可用*/
    public static final String ENABLE_ONE = "1";

    /**账户可用状态码0，0表示不可用*/
    public static final String ENABLE_ZERO = "0";

    /**线程池核心线程数*/
    public static final int THREAD_CORE_POOL_SIZE = 10;

    /**线程池最大线程数*/
    public static final int THREAD_MAX_POOL_SIZE = 13;

    /**线程池线程最大空闲时间*/
    public static final Long THREAD_KEEP_ALIVE_TIME = 1000L;

    /**线程池队列数*/
    public static final int THREAD_QUERY_NUM = 10;


}
