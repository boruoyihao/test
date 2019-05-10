package com.enum1;

/**
 * Created by zhaolizhen on 17-6-15.
 */
public enum FruitEnum {
    APPLE("apple","苹果");

    private final String code;
    private final String msg;

    FruitEnum(String code,String msg){
        this.code=code;
        this.msg=msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public static void main(String args[]){
        System.out.println(FruitEnum.APPLE==FruitEnum.APPLE);
    }
}
