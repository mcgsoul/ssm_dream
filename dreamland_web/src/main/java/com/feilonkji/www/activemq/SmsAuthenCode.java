package com.feilonkji.www.activemq;

import lombok.SneakyThrows;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageListener;

/**
 * @title: SmsAuthenCode
 * @Description: ActiveMQ消费者消息监听类
 * @Author zr
 * @Date:2020/9/30 15:13
 * @Version 1.8
 */
@Component
public class SmsAuthenCode implements MessageListener {

    private static final Logger LOG = Logger.getLogger(SmsAuthenCode.class);

    @Override
    @SneakyThrows
    public void onMessage(Message message) {

        MapMessage mapMessage = (MapMessage) message;
        //调用SMS服务发送短信， SmsSystem 阿里大于发送短信给客户手机实现类
        SendMessage.sendMessage(mapMessage.getString("code"),mapMessage.getString("telephone"));
        LOG.debug("发送信息成功===>验证码===>"+mapMessage.getString("code"));
    }
}
