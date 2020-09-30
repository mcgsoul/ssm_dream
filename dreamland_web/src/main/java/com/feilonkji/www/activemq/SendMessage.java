package com.feilonkji.www.activemq;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;

/**
 * @title: SendMessage
 * @Description: 短信服务，验证码发送类
 * @Author zr
 * @Date:2020/9/30 15:22
 * @Version 1.8
 */
public class SendMessage {
    /**连接阿里短信接口的密钥*/
    private static String accessKeyId = "***";
    private static String accessKeySecret = "***";

    /**短信签名*/
    private static String setSignName = "梦幻家园网";
    /**短信模板*/
    private static String messageTempCode = "***";

    /**
     *
     * Description: 发送短信
     * @param code 验证码
     * @param phone 手机号码
     * @return void
     * @throws
     * @date 2020/9/30
     */
    public static void sendMessage(String code,String phone) throws ClientException {

        //设置超时时间
        System.setProperty("sun.net.client.defaultConnectTimeout","100");
        System.setProperty("sun.net.client.defaultReadTimeout","10000");

        //初始化ascClient需要的几个参数
        //短信API产品名称
        final String product = "Dysmsapi";
        //短信API产品域名
        final String domain = "dysmsapi.aliyuncs.com";
        //初始化ascClient
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou",accessKeyId,accessKeySecret);
        DefaultProfile.addEndpoint("cn-hangzhou","cn-hangzhou",product,domain);
        IAcsClient acsClient = new DefaultAcsClient(profile);

        //组件请求对象
        SendSmsRequest request = new SendSmsRequest();
        //必填，接收人的手机号,支持用逗号分隔进行批量发送，最多20个
        request.setPhoneNumbers(phone);
        //必填，短信签名
        request.setSignName(setSignName);
        //必填短信模板-在阿里云网站控制台中申请的短信模板
        request.setTemplateCode(messageTempCode);
        //可选，模板中的变量替换JSON串
        request.setTemplateParam("{\"code\":"+code+"}");
        //可选，outId为提供给业务方扩展字段，最终在短信回执信息中将此值带回给调用者
        request.setOutId("yourOutId");
        SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);

        if(sendSmsResponse.getCode() != null && sendSmsResponse.getCode().equals("OK")){
            //请求成功
            System.out.println("短信发送请求成功！");
        }

    }

}
