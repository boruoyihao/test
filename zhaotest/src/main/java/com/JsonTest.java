package com;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.model.Student;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhaolizhen on 18-9-5.
 */
public class JsonTest {

    static String findNumber(List<Integer> arr, int k) {
        if(null!=arr||arr.size()==0){
            return "NO";
        }

        for(int data:arr){
            if(data==k){
                return "YES";
            }
        }
        return "NO";
    }

    public static void main(String args[]){
//        String json="{\"actionId\":0,\"destination\":\"cmf.upay.fundsResultQueue\",\"destinationType\":0,\"deliveryMode\":2,\"acknowledgeMode\":1,\"transacted\":true,\"requestTime\":\"\\/Date(1536127419553)\\/\",\"requestType\":0,\"expirationTime\":0,\"messageFormat\":2,\"properties\":null,\"content\":{\"paymentSeqNo\":\"2018090530153612740500063302\",\"requestNo\":null,\"returnCode\":\"0000\",\"returnMessage\":\"处理成功 交易成功\",\"fundsChannelCode\":\"ICBC60101\",\"channelPayNo\":\"20152018090546534910\",\"instPayNo\":\"20152018090546534910\",\"instPayTime\":\"\\/Date(1536127419524)\\/\",\"amount\":\"1.00\",\"unityResultCode\":\"S0001\",\"unityResultMessage\":\"\",\"extension\":\"{\\\"unityResultMessage\\\":\\\"\\\",\\\"unityResultCode\\\":\\\"S0001\\\",\\\"instChannelSettleTime\\\":\\\"\\\",\\\"apigw_certid\\\":\\\"10521211144903856029\\\",\\\"apiResultMessage\\\":\\\"交易成功\\\",\\\"fee\\\":\\\"0\\\",\\\"channelTransTime\\\":\\\"20180905\\\",\\\"closeTime\\\":\\\"2018-09-05 14:33:26\\\",\\\"apiResultCode\\\":\\\"00000\\\",\\\"apigw_sign\\\":\\\"jwYqqGRSMY8JWEqHKv1DPdMbqwrlQb3uVbiVi2LNNjCJPIwsJUKIbfBytOXxIaaxDMnAPbopAiY+\\n4yGxgQZsIMUdznGJq90Z2pC2x8anTnW07LQx10R0NdU6ihJohWBZqDBVao4pGpee55LLZzi6USyG\\nDrN4WH/YOF7puadbYIo=\\\",\\\"bizType\\\":\\\"I\\\",\\\"channelSettleTime\\\":\\\"2018-09-05 14:03:39:514\\\",\\\"apigw_rspdata\\\":\\\"{\\\\\"invokerCode\\\\\":\\\\\"SUCCESS\\\\\",\\\\\"response\\\\\":{\\\\\"subInstId\\\\\":\\\\\"869102673920001\\\\\",\\\\\"tradeType\\\\\":\\\\\"\\\\\",\\\\\"tradeStatus\\\\\":\\\\\"NOTPAY\\\\\",\\\\\"instId\\\\\":\\\\\"12021000000000000093\\\\\",\\\\\"tradeNo\\\\\":\\\\\"\\\\\",\\\\\"esh\\\\\":{\\\\\"merDiscAmt\\\\\":\\\\\"\\\\\",\\\\\"cardNo\\\\\":\\\\\"\\\\\",\\\\\"custId\\\\\":\\\\\"\\\\\",\\\\\"paymentAmt\\\\\":\\\\\"\\\\\",\\\\\"tradeNo\\\\\":\\\\\"\\\\\",\\\\\"payStatus\\\\\":\\\\\"\\\\\",\\\\\"ecouponAmt\\\\\":\\\\\"\\\\\",\\\\\"totalDiscAmt\\\\\":\\\\\"\\\\\",\\\\\"pointAmt\\\\\":\\\\\"\\\\\",\\\\\"outTradeNo\\\\\":\\\\\"0024880172285\\\\\",\\\\\"couponAmt\\\\\":\\\\\"\\\\\",\\\\\"bankDiscAmt\\\\\":\\\\\"\\\\\"},\\\\\"doubtf\\\\\":\\\\\"0\\\\\",\\\\\"txDate\\\\\":\\\\\"20180905\\\\\",\\\\\"deviceInfo\\\\\":\\\\\"\\\\\",\\\\\"stlAmt\\\\\":\\\\\"1\\\\\",\\\\\"resultMsg\\\\\":\\\\\"等待用户支付\\\\\",\\\\\"systemDate\\\\\":\\\\\"20180905\\\\\",\\\\\"serialNo\\\\\":\\\\\"0024880172285\\\\\",\\\\\"systemTime\\\\\":\\\\\"140327\\\\\",\\\\\"txTime\\\\\":\\\\\"\\\\\",\\\\\"orderNo\\\\\":\\\\\"20152018090546534910\\\\\",\\\\\"wxpay\\\\\":{\\\\\"detail\\\\\":\\\\\"\\\\\",\\\\\"cashFee\\\\\":\\\\\"\\\\\",\\\\\"subOpenid\\\\\":\\\\\"\\\\\",\\\\\"attach\\\\\":\\\\\"\\\\\",\\\\\"bankType\\\\\":\\\\\"\\\\\",\\\\\"appid\\\\\":\\\\\"wx63a1482d11b20e35\\\\\",\\\\\"openid\\\\\":\\\\\"\\\\\",\\\\\"couponInfo\\\\\":\\\\\"\\\\\",\\\\\"subIsSubscribe\\\\\":\\\\\"\\\\\",\\\\\"isSubscribe\\\\\":\\\\\"\\\\\",\\\\\"couponFee\\\\\":\\\\\"\\\\\"},\\\\\"alipay\\\\\":{\\\\\"buyerPayAmount\\\\\":\\\\\"\\\\\",\\\\\"buyerUserId\\\\\":\\\\\"\\\\\",\\\\\"storeName\\\\\":\\\\\"\\\\\",\\\\\"pointAmount\\\\\":\\\\\"\\\\\",\\\\\"buyerLogonId\\\\\":\\\\\"\\\\\",\\\\\"invoiceAmount\\\\\":\\\\\"\\\\\",\\\\\"fundBillList\\\\\":\\\\\"\\\\\",\\\\\"receiptAmount\\\\\":\\\\\"\\\\\",\\\\\"storeId\\\\\":\\\\\"\\\\\"},\\\\\"totalAmount\\\\\":\\\\\"1\\\\\",\\\\\"resultCode\\\\\":\\\\\"FFFFF\\\\\",\\\\\"payMethod\\\\\":\\\\\"8\\\\\"},\\\\\"ICBC_API_RETMSG\\\\\":\\\\\"success\\\\\",\\\\\"ICBC_API_TIMESTAMP\\\\\":\\\\\"2018-09-05 14:03:39\\\\\",\\\\\"invokerMsg\\\\\":\\\\\"交易成功\\\\\",\\\\\"hostRspCode\\\\\":\\\\\"00000\\\\\",\\\\\"hostRspMsg\\\\\":\\\\\"交易成功\\\\\",\\\\\"ICBC_API_RETCODE\\\\\":0}\\\",\\\"settlementId\\\":\\\"20180905140325826026021610670615\\\",\\\"instCode\\\":\\\"WXPAY\\\"}\"},\"referenceId\":null}";

        Student student=new Student();
        student.setName("dd");
        student.setSex("Man");
        Map<String,Object> m=new HashMap<String,Object>();

        m.put("1","zhaolizhen");
        m.put("2",1);
        m.put("3",student);

        String str=JSONObject.toJSONString(m);
        System.out.println(JSONObject.toJSONString(m));

        JsonObject jsonObject=new JsonParser().parse(str).getAsJsonObject().get("3").getAsJsonObject();

        System.out.println(jsonObject.get("name").getAsString());

        int array[]=new int[10];
        if(array.length>0){

        }
//        new JsonParser().parse().getAsJsonObject();
    }
}
