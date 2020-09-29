package com.feilonkji.www.common;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @title: MyThreadPool
 * @Description: 线程池
 * @Author zr
 * @Date:2020/9/29 16:42
 * @Version 1.8
 */
public class MyThreadPool {
    /**构建线程池对象*/
    private static ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(Constant.THREAD_CORE_POOL_SIZE,
            Constant.THREAD_MAX_POOL_SIZE,
            Constant.THREAD_KEEP_ALIVE_TIME,
            TimeUnit.HOURS,
            new ArrayBlockingQueue<Runnable>(Constant.THREAD_QUERY_NUM));

    /**
     *
     * Description: 获取到线程池对象
     * @param
     * @return java.util.concurrent.ThreadPoolExecutor
     * @throws
     * @date 2020/9/29
     */
    public static ThreadPoolExecutor getThreadPoolExecutor(){
        return threadPoolExecutor;
    }
}

