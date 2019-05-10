package com.json;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;

import java.util.Map;

/**
 * Created by zhaolizhen on 17-6-29.
 */
public class JsonTest {
    public static void main(String args[]){
//        J j=new J();
//        j.setName("zhaolizhen");
//        j.setId(12);
//        String json= JSONObject.toJSONString(j);
//        System.out.println(json);
        String json="{\"paymentFunds\":\"{\\\"idType\\\":\\\"IC\\\",\\\"client\\\":\\\"MOBILE\\\",\\\"orderDesc\\\":\\\"小米科技5170720993146309号订单\\\",\\\"mcc\\\":\\\"5732\\\",\\\"goodsNameShort\\\":\\\"零售百货-垂直-数码3C\\\",\\\"partnerId\\\":\\\"1000000004\\\",\\\"DBCR\\\":\\\"DC\\\",\\\"mht\\\":\\\"10000066\\\",\\\"MEMBER_ID\\\":\\\"129925415\\\",\\\"cardNo\\\":\\\"BASE64_GCCX6vJOpQXFqQAjbAApRP24OK4ARpgBjUhu/6q1NLDI9xgSkW5zYEJVTN+zRMEFTqHhlJUBGBBmkssuLRJEQazPU8SSgtjxGBQjpK+KD8m0XoDSJ6WL1L6iIa2pHQA=\\\",\\\"installNum\\\":\\\"3\\\",\\\"principal\\\":\\\"RUIFT\\\",\\\"signNo\\\":\\\"\\\",\\\"userId\\\":\\\"129925415\\\",\\\"verificationCode\\\":\\\"\\\",\\\"subMerId\\\":\\\"1000100005\\\",\\\"cvv2\\\":\\\"\\\",\\\"idNo\\\":\\\"BASE64_GCC3KfgBrIzxEver9FjcFHGZD9w9LIdclqR4hUdxPI0CDhgSfTA+pXRxRZiaG7uGqeU1lc8BGBD9tk2cWEpKRYotEFF5t6B7GBTIO3qLLvCd6IQgEFvJN5GkjVFShQA=\\\",\\\"xiaomiId\\\":750503687,\\\"bindId\\\":0,\\\"subMerName\\\":\\\"小米网\\\",\\\"GATE_ORDER_NO\\\":\\\"20170721000050943000101830188212\\\",\\\"industryType\\\":\\\"零售百货-垂直-数码3C\\\",\\\"goodsIsVirtual\\\":\\\"false\\\",\\\"accountName\\\":\\\"BASE64_GBDYahOElUVS1fbqR/LQtzPMGBJrLnD+Qm1C6pAjtXP3FefMFwEYEIZb4pmVFEuTk3LDqcnTFA4YFCmd0sKnmp5c5D0er12f0LGawi+QAA==\\\",\\\"validDate\\\":\\\"\\\",\\\"subMerNo\\\":\\\"10000066\\\",\\\"ACCESS_CHANNEL\\\":\\\"CLIENT\\\",\\\"merOrderId\\\":\\\"200110005170720993146309\\\",\\\"mobileNo\\\":\\\"BASE64_GBAOKNuZ6Pxl91z3c/4Ljj/iGBLyboS8Oy9FdLOKbw5Bk6reJwEYEDPuJzVMTU3+sTjSDOJ8wN4YFDyuE+9J9kxRuAtvksMJy4jNLWFMAA==\\\"}\",\"bizExtension\":\"{\\\"platform\\\":\\\"pc\\\",\\\"userId\\\":\\\"129925415\\\",\\\"mht\\\":\\\"10000066\\\",\\\"payChannel\\\":\\\"15\\\",\\\"prod\\\":\\\"chr_trd\\\"}\",\"bizFields\":\"{\\\"BIZ_PAYMENT_TYPE\\\":\\\"QP\\\",\\\"CALLBACK_ADDR\\\":\\\"mq:xiaomi.cashpaycore.paymentResultQueue\\\",\\\"CONTROL_PARAM\\\":\\\"\\\",\\\"CLIENT_ID\\\":\\\"CASH-CORE\\\"}\",\"bizInfo\":\"Y\"}\n";
        long start=System.currentTimeMillis();
        JSONObject.parseObject(json, new TypeReference<Map<String,String>>(){});
        System.out.println(System.currentTimeMillis()-start);

        long start1=System.currentTimeMillis();
        JSONObject.parseObject(json, new TypeReference<Map<String,String>>(){});
        System.out.println(System.currentTimeMillis()-start1);
    }
}

class J{
    private String name="zhao";
    private int id=3;

    public String getName() {
        System.out.println("getname");
        return name;
    }

    public void setName(String name) {
        System.out.println("setName");
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "J{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
