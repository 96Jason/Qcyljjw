package com.xjh.fe.utils;

import com.alibaba.fastjson.JSONException;
import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;
import com.github.qcloudsms.httpclient.HTTPException;

import java.io.IOException;
import java.util.Random;

/**
 * Created by XuJinghui on 2019/11/24.
 */
public class SendMessageUtil {

    private static int appid = 1400288478;//腾讯短信应用的 SDK AppID
    private static String appkey = "863401e2f21f83f60bb49852b075ef8d";//腾讯云短信中的 App Key
//    private static int templateId = 481068;//短信模板ID 第二版修改
    private static String signature = "后端开发学习笔录公众号";//腾讯云短信签名内容

    public static String sendMessage(String code, String phoneNumber, int templateId){
        String validTime = "2";//验证码有效时间
        String[] params = {code, validTime};
        SmsSingleSenderResult result = null;
        try {
            SmsSingleSender sender = new SmsSingleSender(appid, appkey);
            // 签名参数未提供或者为空时，会使用默认签名发送短信，这里的13800138000是为用户输入的手机号码
            result = sender.sendWithParam("86", phoneNumber, templateId, params, signature, "", "");
        } catch (HTTPException e) {
            // HTTP响应码错误
            e.printStackTrace();
            return "failure";
        } catch (JSONException e) {
            // json解析错误
            e.printStackTrace();
            return "failure";
        } catch (IOException e) {
            // 网络IO错误
            e.printStackTrace();
            return "failure";
        }
        return "success";
    }

}
