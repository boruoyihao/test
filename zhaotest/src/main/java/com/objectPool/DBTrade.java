
package com.objectPool;

import java.util.Date;

public class DBTrade implements Cloneable{
    private String fTradeId;
    private String fOrderId;
    private String fSpId;
    private long fUserId;
    private int fUserSubAccountType;
    private String fUserLoginName;
    private String fUserRealName;
    private long fSellerId;
    private int fSellerSubAccountType;
    private String fSellerLoginName;
    private String fSellerRealName;
    private long fOrderFee;
    private String fOrderDesc;
    private long fPayUserId;
    private int fPayUserSubAccountType;
    private int fPayMode;
    private int fCurrency;
    private long fCouponAmount;
    private String fCouponIds;
    private long fTransportFee;
    private long fCashAmount;
    private long fChannelFee;
    private long fDeviceId;
    private String fProductName;
    private String fGoodName;
    private String fGoodUrl;
    private int fGoodType;
    private int fTransType;
    private int fPayType;
    private int fStatus;
    private Date fCreateTime;
    private Date fCreateTimeExt;
    private Date fExpireTime;
    private Date fCloseTime;
    private Date fPayTime;
    private Date fPayTimeExt;
    private Date fLastTryPayTime;
    private String fChargeOrderId;
    private Date fModifyTime;
    private int fDeleted;
    private String fBusinessId;
    private String fNewDeviceId;
    private long fApplyRefundFee;
    private long fRefundFee;
    private int fApplyRefundCount;
    private int fRefundCount;
    private String fRequestIp;
    private long fRefundCouponFee;
    private long fRefundChannelFee;
    private String fExtraInfo;
    private String fMerchantExtraInfo;
    private int fUserAccountType;
    private int fSellerAccountType;

    public DBTrade() {
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public String getFTradeId() {
        return this.fTradeId;
    }

    public void setFTradeId(String fTradeId) {
        this.fTradeId = fTradeId;
    }

    public String getFOrderId() {
        return this.fOrderId;
    }

    public void setFOrderId(String fOrderId) {
        this.fOrderId = fOrderId;
    }

    public String getFSpId() {
        return this.fSpId;
    }

    public void setFSpId(String spId) {
        this.fSpId = spId;
    }

    public long getFUserId() {
        return this.fUserId;
    }

    public void setFUserId(long fUserId) {
        this.fUserId = fUserId;
    }

    public void setFUserSubAccountType(int userSubAccountType) {
        this.fUserSubAccountType = userSubAccountType;
    }

    public int getFUserSubAccountType() {
        return this.fUserSubAccountType;
    }

    public String getFUserLoginName() {
        return this.fUserLoginName;
    }

    public void setFUserLoginName(String fUserLoginName) {
        this.fUserLoginName = fUserLoginName;
    }

    public String getFUserRealName() {
        return this.fUserRealName;
    }

    public void setFUserRealName(String fUserRealName) {
        this.fUserRealName = fUserRealName;
    }

    public long getFSellerId() {
        return this.fSellerId;
    }

    public void setFSellerId(long fSellerId) {
        this.fSellerId = fSellerId;
    }

    public int getFSellerSubAccountType() {
        return this.fSellerSubAccountType;
    }

    public void setFSellerSubAccountType(int fSellerSubAccountType) {
        this.fSellerSubAccountType = fSellerSubAccountType;
    }

    public String getFSellerLoginName() {
        return this.fSellerLoginName;
    }

    public void setFSellerLoginName(String fSellerLoginName) {
        this.fSellerLoginName = fSellerLoginName;
    }

    public String getFSellerRealName() {
        return this.fSellerRealName;
    }

    public void setFSellerRealName(String fSellerRealName) {
        this.fSellerRealName = fSellerRealName;
    }

    public long getFOrderFee() {
        return this.fOrderFee;
    }

    public void setFOrderFee(long fOrderFee) {
        this.fOrderFee = fOrderFee;
    }

    public String getFOrderDesc() {
        return this.fOrderDesc;
    }

    public void setFOrderDesc(String fOrderDesc) {
        this.fOrderDesc = fOrderDesc;
    }

    public long getFPayUserId() {
        return this.fPayUserId;
    }

    public void setFPayUserId(long fPayUserId) {
        this.fPayUserId = fPayUserId;
    }

    public int getFPayUserSubAccountType() {
        return this.fPayUserSubAccountType;
    }

    public void setFPayUserSubAccountType(int fPayUserSubAccountType) {
        this.fPayUserSubAccountType = fPayUserSubAccountType;
    }

    public int getFPayMode() {
        return this.fPayMode;
    }

    public void setFPayMode(int fPayMode) {
        this.fPayMode = fPayMode;
    }

    public int getFCurrency() {
        return this.fCurrency;
    }

    public void setFCurrency(int fCurrency) {
        this.fCurrency = fCurrency;
    }

    public long getFCouponAmount() {
        return this.fCouponAmount;
    }

    public void setFCouponAmount(long fCouponAmount) {
        this.fCouponAmount = fCouponAmount;
    }

    public String getFCouponIds() {
        return this.fCouponIds;
    }

    public void setFCouponIds(String fCouponIds) {
        this.fCouponIds = fCouponIds;
    }

    public long getFTransportFee() {
        return this.fTransportFee;
    }

    public void setFTransportFee(long fTransportFee) {
        this.fTransportFee = fTransportFee;
    }

    public long getFCashAmount() {
        return this.fCashAmount;
    }

    public void setFCashAmount(long fCashAmount) {
        this.fCashAmount = fCashAmount;
    }

    public long getFChannelFee() {
        return this.fChannelFee;
    }

    public void setFChannelFee(long fChannelFee) {
        this.fChannelFee = fChannelFee;
    }

    public long getFDeviceId() {
        return this.fDeviceId;
    }

    public void setFDeviceId(long fDeviceId) {
        this.fDeviceId = fDeviceId;
    }

    public String getFProductName() {
        return this.fProductName;
    }

    public void setFProductName(String fProductName) {
        this.fProductName = fProductName;
    }

    public String getFGoodName() {
        return this.fGoodName;
    }

    public void setFGoodName(String fGoodName) {
        this.fGoodName = fGoodName;
    }

    public String getFGoodUrl() {
        return this.fGoodUrl;
    }

    public void setFGoodUrl(String fGoodUrl) {
        this.fGoodUrl = fGoodUrl;
    }

    public int getFGoodType() {
        return this.fGoodType;
    }

    public void setFGoodType(int fGoodType) {
        this.fGoodType = fGoodType;
    }

    public int getFTransType() {
        return this.fTransType;
    }

    public void setFTransType(int fTransType) {
        this.fTransType = fTransType;
    }

    public int getFPayType() {
        return this.fPayType;
    }

    public void setFPayType(int fPayType) {
        this.fPayType = fPayType;
    }

    public int getFStatus() {
        return this.fStatus;
    }

    public void setFStatus(int fStatus) {
        this.fStatus = fStatus;
    }

    public Date getFCreateTime() {
        return this.fCreateTime;
    }

    public void setFCreateTime(Date fCreateTime) {
        this.fCreateTime = fCreateTime;
    }

    public Date getFCreateTimeExt() {
        return this.fCreateTimeExt;
    }

    public void setFCreateTimeExt(Date fCreateTimeExt) {
        this.fCreateTimeExt = fCreateTimeExt;
    }

    public Date getFExpireTime() {
        return this.fExpireTime;
    }

    public void setFExpireTime(Date fExpireTime) {
        this.fExpireTime = fExpireTime;
    }

    public Date getFCloseTime() {
        return this.fCloseTime;
    }

    public void setFCloseTime(Date fCloseTime) {
        this.fCloseTime = fCloseTime;
    }

    public Date getFPayTime() {
        return this.fPayTime;
    }

    public void setFPayTime(Date fPayTime) {
        this.fPayTime = fPayTime;
    }

    public Date getFPayTimeExt() {
        return this.fPayTimeExt;
    }

    public void setFPayTimeExt(Date fPayTimeExt) {
        this.fPayTimeExt = fPayTimeExt;
    }

    public Date getFLastTryPayTime() {
        return this.fLastTryPayTime;
    }

    public void setFLastTryPayTime(Date fLastTryPayTime) {
        this.fLastTryPayTime = fLastTryPayTime;
    }

    public String getFChargeOrderId() {
        return this.fChargeOrderId;
    }

    public void setFChargeOrderId(String fChargeOrderId) {
        this.fChargeOrderId = fChargeOrderId;
    }

    public Date getFModifyTime() {
        return this.fModifyTime;
    }

    public void setFModifyTime(Date fModifyTime) {
        this.fModifyTime = fModifyTime;
    }

    public int getFDeleted() {
        return this.fDeleted;
    }

    public void setFDeleted(int fDeleted) {
        this.fDeleted = fDeleted;
    }

    public void setFBusinessId(String fBusinessId) {
        this.fBusinessId = fBusinessId;
    }

    public String getFBusinessId() {
        return this.fBusinessId;
    }

    public void setFNewDeviceId(String fNewDeviceId) {
        this.fNewDeviceId = fNewDeviceId;
    }

    public String getFNewDeviceId() {
        return this.fNewDeviceId;
    }

    public long getFApplyRefundFee() {
        return this.fApplyRefundFee;
    }

    public void setFApplyRefundFee(long fApplyRefundFee) {
        this.fApplyRefundFee = fApplyRefundFee;
    }

    public long getFRefundFee() {
        return this.fRefundFee;
    }

    public void setFRefundFee(long fRefundFee) {
        this.fRefundFee = fRefundFee;
    }

    public int getFApplyRefundCount() {
        return this.fApplyRefundCount;
    }

    public void setFApplyRefundCount(int fApplyRefundCount) {
        this.fApplyRefundCount = fApplyRefundCount;
    }

    public int getFRefundCount() {
        return this.fRefundCount;
    }

    public void setFRefundCount(int fRefundCount) {
        this.fRefundCount = fRefundCount;
    }

    public String getFRequestIp() {
        return this.fRequestIp;
    }

    public void setFRequestIp(String requestIp) {
        this.fRequestIp = requestIp;
    }

    public void setFRefundCouponFee(long fRefundCouponFee) {
        this.fRefundCouponFee = fRefundCouponFee;
    }

    public long getFRefundCouponFee() {
        return this.fRefundCouponFee;
    }

    public long getFRefundChannelFee() {
        return this.fRefundChannelFee;
    }

    public void setFRefundChannelFee(long refundChannelFee) {
        this.fRefundChannelFee = refundChannelFee;
    }

    public String getFExtraInfo() {
        return this.fExtraInfo;
    }


    public String getFMerchantExtraInfo() {
        return this.fMerchantExtraInfo;
    }

    public void setFMerchantExtraInfo(String merchantExtraInfo) {
        this.fMerchantExtraInfo = merchantExtraInfo;
    }

    public void setFUserAccountType(int userAccountType) {
        this.fUserAccountType = userAccountType;
    }

    public int getFUserAccountType() {
        return this.fUserAccountType;
    }

    public void setFSellerAccountType(int sellerAccountType) {
        this.fSellerAccountType = sellerAccountType;
    }

    public int getFSellerAccountType() {
        return this.fSellerAccountType;
    }

    public String toString() {
        StringBuilder sb = (new StringBuilder(512)).append("DBTrade [tradeId=").append(this.fTradeId).append(",chargeId=").append(this.fChargeOrderId).append(",fOrderId=").append(this.fOrderId).append(",fSpId=").append(this.fSpId).append(",seller=").append(this.fSellerId).append(",clientType=").append(",sellerLoginName=").append(this.fSellerLoginName).append(",userId=").append(this.fUserId).append(",userLoginName=").append(this.fUserLoginName).append(",desc=").append(this.fOrderDesc).append(",extra=").append(this.fExtraInfo).append("]");
        return sb.toString();
    }
}
