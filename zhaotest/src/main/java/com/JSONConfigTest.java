package com;

import com.alibaba.fastjson.JSONObject;

import java.util.Date;
import java.util.UUID;

/**
 * Created by zhaolizhen on 18-7-24.
 */
public class JSONConfigTest {

    public static void main(String args[]){
        ICBCSwitchConfig icbcSwitchConfig=new ICBCSwitchConfig();
        icbcSwitchConfig.setMerchantId("1000000319");
        icbcSwitchConfig.setEffectTime(new Date());
        icbcSwitchConfig.setAlipaySwitch(false);
        icbcSwitchConfig.setWeixinSwitch(false);

        System.out.println(JSONObject.toJSON(icbcSwitchConfig));

        String result=JSONObject.toJSONString(icbcSwitchConfig);

        long time=System.currentTimeMillis();
        System.out.println(new Date(time).getTime());

        System.out.println("6727a141361f3c44fa21e90340a34043".length());

        UUID uuid = UUID.randomUUID();
        /**
         * .{6c0222ed-e7f5-4cad-a717-a9abfb372239}
         */
        System.out.println(".{" + uuid.toString() + "}");
        /**
         * 6c0222ed-e7f5-4cad-a717-a9abfb372239
         */
        System.out.println(uuid.toString());
        /**
         * 36
         */
        System.out.println(uuid.toString().length());
        /**
         * 32
         */
        System.out.println(uuid.toString().replace("-", "").length());
        /**
         * 6c0222ede7f54cada717a9abfb372239
         */
        System.out.println(uuid.toString().replace("-", ""));

        System.out.println("5c94ad925e1d4e9c86abbc82140e7c60".length());
    }
}

class ICBCSwitchConfig{
    private String merchantId;

    private boolean weixinSwitch=false;

    private boolean alipaySwitch=false;

    private Date effectTime;

    public boolean isAlipaySwitch() {
        return alipaySwitch;
    }

    public void setAlipaySwitch(boolean alipaySwitch) {
        this.alipaySwitch = alipaySwitch;
    }

    public Date getEffectTime() {
        return effectTime;
    }

    public void setEffectTime(Date effectTime) {
        this.effectTime = effectTime;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public boolean isWeixinSwitch() {
        return weixinSwitch;
    }

    public void setWeixinSwitch(boolean weixinSwitch) {
        this.weixinSwitch = weixinSwitch;
    }
}
