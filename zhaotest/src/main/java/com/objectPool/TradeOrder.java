package com.objectPool;

import java.util.Date;

class TradeOrder {

    public TradeOrder(){

    }
    private String fTradeId = "";
    private long fOrderFee;
    private long fCouponAmount;
    private long fChannelFee;
    private int fStatus;
    private long fUserId;
    private long fSellerId;
    private String fChargeOrderId = "";
    private Date fCreateTime;
    private Date fModifyTime;
    private int fApplyRefundCount;
    private int fRefundCount;
    private String fExtraInfo;

    public String getfExtraInfo() {
        return fExtraInfo;
    }

    public void setfExtraInfo(String fExtraInfo) {
        this.fExtraInfo = fExtraInfo;
    }

    public int getfApplyRefundCount() {
        return fApplyRefundCount;
    }

    public void setfApplyRefundCount(int fApplyRefundCount) {
        this.fApplyRefundCount = fApplyRefundCount;
    }

    public int getfRefundCount() {
        return fRefundCount;
    }

    public void setfRefundCount(int fRefundCount) {
        this.fRefundCount = fRefundCount;
    }

    public String getfTradeId() {
        return fTradeId;
    }

    public void setfTradeId(String fTradeId) {
        this.fTradeId = fTradeId;
    }

    public long getfOrderFee() {
        return fOrderFee;
    }

    public void setfOrderFee(long fOrderFee) {
        this.fOrderFee = fOrderFee;
        // this.orderFee = new Money(fOrderFee);
    }

    public long getfCouponAmount() {
        return fCouponAmount;
    }

    public void setfCouponAmount(long fCouponAmount) {
        this.fCouponAmount = fCouponAmount;
        // this.couponAmount = new Money(fCouponAmount);
    }

    public long getfChannelFee() {
        return fChannelFee;
    }

    public void setfChannelFee(long fChannelFee) {
        this.fChannelFee = fChannelFee;
        // this.chennelFee = new Money(fChannelFee);
    }

    public int getfStatus() {
        return fStatus;
    }

    public void setfStatus(int fStatus) {
        this.fStatus = fStatus;
    }

    public long getfUserId() {
        return fUserId;
    }

    public void setfUserId(long fUserId) {
        this.fUserId = fUserId;
    }

    public long getfSellerId() {
        return fSellerId;
    }

    public void setfSellerId(long fSellerId) {
        this.fSellerId = fSellerId;
    }

    public Date getfCreateTime() {
        return fCreateTime;
    }

    public void setfCreateTime(Date fCreateTime) {
        this.fCreateTime = fCreateTime;
    }

    public Date getfModifyTime() {
        return fModifyTime;
    }

    public void setfModifyTime(Date fModifyTime) {
        this.fModifyTime = fModifyTime;
    }

    public String getfChargeOrderId() {
        return fChargeOrderId;
    }

    public void setfChargeOrderId(String fChargeOrderId) {
        this.fChargeOrderId = fChargeOrderId;
    }

    @Override
    public String toString() {
        return "TradeOrder{" +
                "fTradeId='" + fTradeId + '\'' +
                ", fOrderFee=" + fOrderFee +
                ", fCouponAmount=" + fCouponAmount +
                ", fChannelFee=" + fChannelFee +
                ", fStatus=" + fStatus +
                ", fUserId=" + fUserId +
                ", fSellerId=" + fSellerId +
                ", fChargeOrderId='" + fChargeOrderId + '\'' +
                ", fCreateTime=" + fCreateTime +
                ", fModifyTime=" + fModifyTime +
                ", fApplyRefundCount=" + fApplyRefundCount +
                ", fRefundCount=" + fRefundCount +
                ", fExtraInfo='" + fExtraInfo + '\'' +
                '}';
    }
}