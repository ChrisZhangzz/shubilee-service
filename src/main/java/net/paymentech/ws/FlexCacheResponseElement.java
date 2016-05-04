/**
 * FlexCacheResponseElement.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package net.paymentech.ws;

public class FlexCacheResponseElement  implements java.io.Serializable {
    private java.lang.String version;

    private java.lang.String merchantID;

    private java.lang.String terminalID;

    private java.lang.String orderID;

    private java.lang.String ccAccountNum;

    private java.lang.String startAccountNum;

    private java.lang.String flexAcctBalance;

    private java.lang.String flexAcctPriorBalance;

    private java.lang.String flexAcctExpireDate;

    private java.lang.String cardType;

    private java.lang.String txRefIdx;

    private java.lang.String txRefNum;

    private java.lang.String procStatus;

    private java.lang.String procStatusMessage;

    private java.lang.String approvalStatus;

    private java.lang.String authorizationCode;

    private java.lang.String respCode;

    private java.lang.String batchFailedAcctNum;

    private java.lang.String flexRequestedAmount;

    private java.lang.String flexRedeemedAmt;

    private java.lang.String flexHostTrace;

    private java.lang.String flexAction;

    private java.lang.String respDateTime;

    private java.lang.String autoAuthTxRefIdx;

    private java.lang.String autoAuthTxRefNum;

    private java.lang.String autoAuthProcStatus;

    private java.lang.String autoAuthStatusMsg;

    private java.lang.String autoAuthApprovalStatus;

    private java.lang.String autoAuthFlexRedeemedAmt;

    private java.lang.String autoAuthResponseCodes;

    private java.lang.String autoAuthFlexHostTrace;

    private java.lang.String autoAuthFlexAction;

    private java.lang.String autoAuthRespTime;

    private java.lang.String retryTrace;

    private java.lang.String retryAttempCount;

    private java.lang.String lastRetryDate;

    private java.lang.String cvvRespCode;

    private java.lang.String superBlockID;

    private java.lang.String fraudScoreProcStatus;

    private java.lang.String fraudScoreProcMsg;

    private net.paymentech.ws.FraudAnalysisResponseType fraudAnalysisResponse;

    public FlexCacheResponseElement() {
    }

    public FlexCacheResponseElement(
           java.lang.String version,
           java.lang.String merchantID,
           java.lang.String terminalID,
           java.lang.String orderID,
           java.lang.String ccAccountNum,
           java.lang.String startAccountNum,
           java.lang.String flexAcctBalance,
           java.lang.String flexAcctPriorBalance,
           java.lang.String flexAcctExpireDate,
           java.lang.String cardType,
           java.lang.String txRefIdx,
           java.lang.String txRefNum,
           java.lang.String procStatus,
           java.lang.String procStatusMessage,
           java.lang.String approvalStatus,
           java.lang.String authorizationCode,
           java.lang.String respCode,
           java.lang.String batchFailedAcctNum,
           java.lang.String flexRequestedAmount,
           java.lang.String flexRedeemedAmt,
           java.lang.String flexHostTrace,
           java.lang.String flexAction,
           java.lang.String respDateTime,
           java.lang.String autoAuthTxRefIdx,
           java.lang.String autoAuthTxRefNum,
           java.lang.String autoAuthProcStatus,
           java.lang.String autoAuthStatusMsg,
           java.lang.String autoAuthApprovalStatus,
           java.lang.String autoAuthFlexRedeemedAmt,
           java.lang.String autoAuthResponseCodes,
           java.lang.String autoAuthFlexHostTrace,
           java.lang.String autoAuthFlexAction,
           java.lang.String autoAuthRespTime,
           java.lang.String retryTrace,
           java.lang.String retryAttempCount,
           java.lang.String lastRetryDate,
           java.lang.String cvvRespCode,
           java.lang.String superBlockID,
           java.lang.String fraudScoreProcStatus,
           java.lang.String fraudScoreProcMsg,
           net.paymentech.ws.FraudAnalysisResponseType fraudAnalysisResponse) {
           this.version = version;
           this.merchantID = merchantID;
           this.terminalID = terminalID;
           this.orderID = orderID;
           this.ccAccountNum = ccAccountNum;
           this.startAccountNum = startAccountNum;
           this.flexAcctBalance = flexAcctBalance;
           this.flexAcctPriorBalance = flexAcctPriorBalance;
           this.flexAcctExpireDate = flexAcctExpireDate;
           this.cardType = cardType;
           this.txRefIdx = txRefIdx;
           this.txRefNum = txRefNum;
           this.procStatus = procStatus;
           this.procStatusMessage = procStatusMessage;
           this.approvalStatus = approvalStatus;
           this.authorizationCode = authorizationCode;
           this.respCode = respCode;
           this.batchFailedAcctNum = batchFailedAcctNum;
           this.flexRequestedAmount = flexRequestedAmount;
           this.flexRedeemedAmt = flexRedeemedAmt;
           this.flexHostTrace = flexHostTrace;
           this.flexAction = flexAction;
           this.respDateTime = respDateTime;
           this.autoAuthTxRefIdx = autoAuthTxRefIdx;
           this.autoAuthTxRefNum = autoAuthTxRefNum;
           this.autoAuthProcStatus = autoAuthProcStatus;
           this.autoAuthStatusMsg = autoAuthStatusMsg;
           this.autoAuthApprovalStatus = autoAuthApprovalStatus;
           this.autoAuthFlexRedeemedAmt = autoAuthFlexRedeemedAmt;
           this.autoAuthResponseCodes = autoAuthResponseCodes;
           this.autoAuthFlexHostTrace = autoAuthFlexHostTrace;
           this.autoAuthFlexAction = autoAuthFlexAction;
           this.autoAuthRespTime = autoAuthRespTime;
           this.retryTrace = retryTrace;
           this.retryAttempCount = retryAttempCount;
           this.lastRetryDate = lastRetryDate;
           this.cvvRespCode = cvvRespCode;
           this.superBlockID = superBlockID;
           this.fraudScoreProcStatus = fraudScoreProcStatus;
           this.fraudScoreProcMsg = fraudScoreProcMsg;
           this.fraudAnalysisResponse = fraudAnalysisResponse;
    }


    /**
     * Gets the version value for this FlexCacheResponseElement.
     * 
     * @return version
     */
    public java.lang.String getVersion() {
        return version;
    }


    /**
     * Sets the version value for this FlexCacheResponseElement.
     * 
     * @param version
     */
    public void setVersion(java.lang.String version) {
        this.version = version;
    }


    /**
     * Gets the merchantID value for this FlexCacheResponseElement.
     * 
     * @return merchantID
     */
    public java.lang.String getMerchantID() {
        return merchantID;
    }


    /**
     * Sets the merchantID value for this FlexCacheResponseElement.
     * 
     * @param merchantID
     */
    public void setMerchantID(java.lang.String merchantID) {
        this.merchantID = merchantID;
    }


    /**
     * Gets the terminalID value for this FlexCacheResponseElement.
     * 
     * @return terminalID
     */
    public java.lang.String getTerminalID() {
        return terminalID;
    }


    /**
     * Sets the terminalID value for this FlexCacheResponseElement.
     * 
     * @param terminalID
     */
    public void setTerminalID(java.lang.String terminalID) {
        this.terminalID = terminalID;
    }


    /**
     * Gets the orderID value for this FlexCacheResponseElement.
     * 
     * @return orderID
     */
    public java.lang.String getOrderID() {
        return orderID;
    }


    /**
     * Sets the orderID value for this FlexCacheResponseElement.
     * 
     * @param orderID
     */
    public void setOrderID(java.lang.String orderID) {
        this.orderID = orderID;
    }


    /**
     * Gets the ccAccountNum value for this FlexCacheResponseElement.
     * 
     * @return ccAccountNum
     */
    public java.lang.String getCcAccountNum() {
        return ccAccountNum;
    }


    /**
     * Sets the ccAccountNum value for this FlexCacheResponseElement.
     * 
     * @param ccAccountNum
     */
    public void setCcAccountNum(java.lang.String ccAccountNum) {
        this.ccAccountNum = ccAccountNum;
    }


    /**
     * Gets the startAccountNum value for this FlexCacheResponseElement.
     * 
     * @return startAccountNum
     */
    public java.lang.String getStartAccountNum() {
        return startAccountNum;
    }


    /**
     * Sets the startAccountNum value for this FlexCacheResponseElement.
     * 
     * @param startAccountNum
     */
    public void setStartAccountNum(java.lang.String startAccountNum) {
        this.startAccountNum = startAccountNum;
    }


    /**
     * Gets the flexAcctBalance value for this FlexCacheResponseElement.
     * 
     * @return flexAcctBalance
     */
    public java.lang.String getFlexAcctBalance() {
        return flexAcctBalance;
    }


    /**
     * Sets the flexAcctBalance value for this FlexCacheResponseElement.
     * 
     * @param flexAcctBalance
     */
    public void setFlexAcctBalance(java.lang.String flexAcctBalance) {
        this.flexAcctBalance = flexAcctBalance;
    }


    /**
     * Gets the flexAcctPriorBalance value for this FlexCacheResponseElement.
     * 
     * @return flexAcctPriorBalance
     */
    public java.lang.String getFlexAcctPriorBalance() {
        return flexAcctPriorBalance;
    }


    /**
     * Sets the flexAcctPriorBalance value for this FlexCacheResponseElement.
     * 
     * @param flexAcctPriorBalance
     */
    public void setFlexAcctPriorBalance(java.lang.String flexAcctPriorBalance) {
        this.flexAcctPriorBalance = flexAcctPriorBalance;
    }


    /**
     * Gets the flexAcctExpireDate value for this FlexCacheResponseElement.
     * 
     * @return flexAcctExpireDate
     */
    public java.lang.String getFlexAcctExpireDate() {
        return flexAcctExpireDate;
    }


    /**
     * Sets the flexAcctExpireDate value for this FlexCacheResponseElement.
     * 
     * @param flexAcctExpireDate
     */
    public void setFlexAcctExpireDate(java.lang.String flexAcctExpireDate) {
        this.flexAcctExpireDate = flexAcctExpireDate;
    }


    /**
     * Gets the cardType value for this FlexCacheResponseElement.
     * 
     * @return cardType
     */
    public java.lang.String getCardType() {
        return cardType;
    }


    /**
     * Sets the cardType value for this FlexCacheResponseElement.
     * 
     * @param cardType
     */
    public void setCardType(java.lang.String cardType) {
        this.cardType = cardType;
    }


    /**
     * Gets the txRefIdx value for this FlexCacheResponseElement.
     * 
     * @return txRefIdx
     */
    public java.lang.String getTxRefIdx() {
        return txRefIdx;
    }


    /**
     * Sets the txRefIdx value for this FlexCacheResponseElement.
     * 
     * @param txRefIdx
     */
    public void setTxRefIdx(java.lang.String txRefIdx) {
        this.txRefIdx = txRefIdx;
    }


    /**
     * Gets the txRefNum value for this FlexCacheResponseElement.
     * 
     * @return txRefNum
     */
    public java.lang.String getTxRefNum() {
        return txRefNum;
    }


    /**
     * Sets the txRefNum value for this FlexCacheResponseElement.
     * 
     * @param txRefNum
     */
    public void setTxRefNum(java.lang.String txRefNum) {
        this.txRefNum = txRefNum;
    }


    /**
     * Gets the procStatus value for this FlexCacheResponseElement.
     * 
     * @return procStatus
     */
    public java.lang.String getProcStatus() {
        return procStatus;
    }


    /**
     * Sets the procStatus value for this FlexCacheResponseElement.
     * 
     * @param procStatus
     */
    public void setProcStatus(java.lang.String procStatus) {
        this.procStatus = procStatus;
    }


    /**
     * Gets the procStatusMessage value for this FlexCacheResponseElement.
     * 
     * @return procStatusMessage
     */
    public java.lang.String getProcStatusMessage() {
        return procStatusMessage;
    }


    /**
     * Sets the procStatusMessage value for this FlexCacheResponseElement.
     * 
     * @param procStatusMessage
     */
    public void setProcStatusMessage(java.lang.String procStatusMessage) {
        this.procStatusMessage = procStatusMessage;
    }


    /**
     * Gets the approvalStatus value for this FlexCacheResponseElement.
     * 
     * @return approvalStatus
     */
    public java.lang.String getApprovalStatus() {
        return approvalStatus;
    }


    /**
     * Sets the approvalStatus value for this FlexCacheResponseElement.
     * 
     * @param approvalStatus
     */
    public void setApprovalStatus(java.lang.String approvalStatus) {
        this.approvalStatus = approvalStatus;
    }


    /**
     * Gets the authorizationCode value for this FlexCacheResponseElement.
     * 
     * @return authorizationCode
     */
    public java.lang.String getAuthorizationCode() {
        return authorizationCode;
    }


    /**
     * Sets the authorizationCode value for this FlexCacheResponseElement.
     * 
     * @param authorizationCode
     */
    public void setAuthorizationCode(java.lang.String authorizationCode) {
        this.authorizationCode = authorizationCode;
    }


    /**
     * Gets the respCode value for this FlexCacheResponseElement.
     * 
     * @return respCode
     */
    public java.lang.String getRespCode() {
        return respCode;
    }


    /**
     * Sets the respCode value for this FlexCacheResponseElement.
     * 
     * @param respCode
     */
    public void setRespCode(java.lang.String respCode) {
        this.respCode = respCode;
    }


    /**
     * Gets the batchFailedAcctNum value for this FlexCacheResponseElement.
     * 
     * @return batchFailedAcctNum
     */
    public java.lang.String getBatchFailedAcctNum() {
        return batchFailedAcctNum;
    }


    /**
     * Sets the batchFailedAcctNum value for this FlexCacheResponseElement.
     * 
     * @param batchFailedAcctNum
     */
    public void setBatchFailedAcctNum(java.lang.String batchFailedAcctNum) {
        this.batchFailedAcctNum = batchFailedAcctNum;
    }


    /**
     * Gets the flexRequestedAmount value for this FlexCacheResponseElement.
     * 
     * @return flexRequestedAmount
     */
    public java.lang.String getFlexRequestedAmount() {
        return flexRequestedAmount;
    }


    /**
     * Sets the flexRequestedAmount value for this FlexCacheResponseElement.
     * 
     * @param flexRequestedAmount
     */
    public void setFlexRequestedAmount(java.lang.String flexRequestedAmount) {
        this.flexRequestedAmount = flexRequestedAmount;
    }


    /**
     * Gets the flexRedeemedAmt value for this FlexCacheResponseElement.
     * 
     * @return flexRedeemedAmt
     */
    public java.lang.String getFlexRedeemedAmt() {
        return flexRedeemedAmt;
    }


    /**
     * Sets the flexRedeemedAmt value for this FlexCacheResponseElement.
     * 
     * @param flexRedeemedAmt
     */
    public void setFlexRedeemedAmt(java.lang.String flexRedeemedAmt) {
        this.flexRedeemedAmt = flexRedeemedAmt;
    }


    /**
     * Gets the flexHostTrace value for this FlexCacheResponseElement.
     * 
     * @return flexHostTrace
     */
    public java.lang.String getFlexHostTrace() {
        return flexHostTrace;
    }


    /**
     * Sets the flexHostTrace value for this FlexCacheResponseElement.
     * 
     * @param flexHostTrace
     */
    public void setFlexHostTrace(java.lang.String flexHostTrace) {
        this.flexHostTrace = flexHostTrace;
    }


    /**
     * Gets the flexAction value for this FlexCacheResponseElement.
     * 
     * @return flexAction
     */
    public java.lang.String getFlexAction() {
        return flexAction;
    }


    /**
     * Sets the flexAction value for this FlexCacheResponseElement.
     * 
     * @param flexAction
     */
    public void setFlexAction(java.lang.String flexAction) {
        this.flexAction = flexAction;
    }


    /**
     * Gets the respDateTime value for this FlexCacheResponseElement.
     * 
     * @return respDateTime
     */
    public java.lang.String getRespDateTime() {
        return respDateTime;
    }


    /**
     * Sets the respDateTime value for this FlexCacheResponseElement.
     * 
     * @param respDateTime
     */
    public void setRespDateTime(java.lang.String respDateTime) {
        this.respDateTime = respDateTime;
    }


    /**
     * Gets the autoAuthTxRefIdx value for this FlexCacheResponseElement.
     * 
     * @return autoAuthTxRefIdx
     */
    public java.lang.String getAutoAuthTxRefIdx() {
        return autoAuthTxRefIdx;
    }


    /**
     * Sets the autoAuthTxRefIdx value for this FlexCacheResponseElement.
     * 
     * @param autoAuthTxRefIdx
     */
    public void setAutoAuthTxRefIdx(java.lang.String autoAuthTxRefIdx) {
        this.autoAuthTxRefIdx = autoAuthTxRefIdx;
    }


    /**
     * Gets the autoAuthTxRefNum value for this FlexCacheResponseElement.
     * 
     * @return autoAuthTxRefNum
     */
    public java.lang.String getAutoAuthTxRefNum() {
        return autoAuthTxRefNum;
    }


    /**
     * Sets the autoAuthTxRefNum value for this FlexCacheResponseElement.
     * 
     * @param autoAuthTxRefNum
     */
    public void setAutoAuthTxRefNum(java.lang.String autoAuthTxRefNum) {
        this.autoAuthTxRefNum = autoAuthTxRefNum;
    }


    /**
     * Gets the autoAuthProcStatus value for this FlexCacheResponseElement.
     * 
     * @return autoAuthProcStatus
     */
    public java.lang.String getAutoAuthProcStatus() {
        return autoAuthProcStatus;
    }


    /**
     * Sets the autoAuthProcStatus value for this FlexCacheResponseElement.
     * 
     * @param autoAuthProcStatus
     */
    public void setAutoAuthProcStatus(java.lang.String autoAuthProcStatus) {
        this.autoAuthProcStatus = autoAuthProcStatus;
    }


    /**
     * Gets the autoAuthStatusMsg value for this FlexCacheResponseElement.
     * 
     * @return autoAuthStatusMsg
     */
    public java.lang.String getAutoAuthStatusMsg() {
        return autoAuthStatusMsg;
    }


    /**
     * Sets the autoAuthStatusMsg value for this FlexCacheResponseElement.
     * 
     * @param autoAuthStatusMsg
     */
    public void setAutoAuthStatusMsg(java.lang.String autoAuthStatusMsg) {
        this.autoAuthStatusMsg = autoAuthStatusMsg;
    }


    /**
     * Gets the autoAuthApprovalStatus value for this FlexCacheResponseElement.
     * 
     * @return autoAuthApprovalStatus
     */
    public java.lang.String getAutoAuthApprovalStatus() {
        return autoAuthApprovalStatus;
    }


    /**
     * Sets the autoAuthApprovalStatus value for this FlexCacheResponseElement.
     * 
     * @param autoAuthApprovalStatus
     */
    public void setAutoAuthApprovalStatus(java.lang.String autoAuthApprovalStatus) {
        this.autoAuthApprovalStatus = autoAuthApprovalStatus;
    }


    /**
     * Gets the autoAuthFlexRedeemedAmt value for this FlexCacheResponseElement.
     * 
     * @return autoAuthFlexRedeemedAmt
     */
    public java.lang.String getAutoAuthFlexRedeemedAmt() {
        return autoAuthFlexRedeemedAmt;
    }


    /**
     * Sets the autoAuthFlexRedeemedAmt value for this FlexCacheResponseElement.
     * 
     * @param autoAuthFlexRedeemedAmt
     */
    public void setAutoAuthFlexRedeemedAmt(java.lang.String autoAuthFlexRedeemedAmt) {
        this.autoAuthFlexRedeemedAmt = autoAuthFlexRedeemedAmt;
    }


    /**
     * Gets the autoAuthResponseCodes value for this FlexCacheResponseElement.
     * 
     * @return autoAuthResponseCodes
     */
    public java.lang.String getAutoAuthResponseCodes() {
        return autoAuthResponseCodes;
    }


    /**
     * Sets the autoAuthResponseCodes value for this FlexCacheResponseElement.
     * 
     * @param autoAuthResponseCodes
     */
    public void setAutoAuthResponseCodes(java.lang.String autoAuthResponseCodes) {
        this.autoAuthResponseCodes = autoAuthResponseCodes;
    }


    /**
     * Gets the autoAuthFlexHostTrace value for this FlexCacheResponseElement.
     * 
     * @return autoAuthFlexHostTrace
     */
    public java.lang.String getAutoAuthFlexHostTrace() {
        return autoAuthFlexHostTrace;
    }


    /**
     * Sets the autoAuthFlexHostTrace value for this FlexCacheResponseElement.
     * 
     * @param autoAuthFlexHostTrace
     */
    public void setAutoAuthFlexHostTrace(java.lang.String autoAuthFlexHostTrace) {
        this.autoAuthFlexHostTrace = autoAuthFlexHostTrace;
    }


    /**
     * Gets the autoAuthFlexAction value for this FlexCacheResponseElement.
     * 
     * @return autoAuthFlexAction
     */
    public java.lang.String getAutoAuthFlexAction() {
        return autoAuthFlexAction;
    }


    /**
     * Sets the autoAuthFlexAction value for this FlexCacheResponseElement.
     * 
     * @param autoAuthFlexAction
     */
    public void setAutoAuthFlexAction(java.lang.String autoAuthFlexAction) {
        this.autoAuthFlexAction = autoAuthFlexAction;
    }


    /**
     * Gets the autoAuthRespTime value for this FlexCacheResponseElement.
     * 
     * @return autoAuthRespTime
     */
    public java.lang.String getAutoAuthRespTime() {
        return autoAuthRespTime;
    }


    /**
     * Sets the autoAuthRespTime value for this FlexCacheResponseElement.
     * 
     * @param autoAuthRespTime
     */
    public void setAutoAuthRespTime(java.lang.String autoAuthRespTime) {
        this.autoAuthRespTime = autoAuthRespTime;
    }


    /**
     * Gets the retryTrace value for this FlexCacheResponseElement.
     * 
     * @return retryTrace
     */
    public java.lang.String getRetryTrace() {
        return retryTrace;
    }


    /**
     * Sets the retryTrace value for this FlexCacheResponseElement.
     * 
     * @param retryTrace
     */
    public void setRetryTrace(java.lang.String retryTrace) {
        this.retryTrace = retryTrace;
    }


    /**
     * Gets the retryAttempCount value for this FlexCacheResponseElement.
     * 
     * @return retryAttempCount
     */
    public java.lang.String getRetryAttempCount() {
        return retryAttempCount;
    }


    /**
     * Sets the retryAttempCount value for this FlexCacheResponseElement.
     * 
     * @param retryAttempCount
     */
    public void setRetryAttempCount(java.lang.String retryAttempCount) {
        this.retryAttempCount = retryAttempCount;
    }


    /**
     * Gets the lastRetryDate value for this FlexCacheResponseElement.
     * 
     * @return lastRetryDate
     */
    public java.lang.String getLastRetryDate() {
        return lastRetryDate;
    }


    /**
     * Sets the lastRetryDate value for this FlexCacheResponseElement.
     * 
     * @param lastRetryDate
     */
    public void setLastRetryDate(java.lang.String lastRetryDate) {
        this.lastRetryDate = lastRetryDate;
    }


    /**
     * Gets the cvvRespCode value for this FlexCacheResponseElement.
     * 
     * @return cvvRespCode
     */
    public java.lang.String getCvvRespCode() {
        return cvvRespCode;
    }


    /**
     * Sets the cvvRespCode value for this FlexCacheResponseElement.
     * 
     * @param cvvRespCode
     */
    public void setCvvRespCode(java.lang.String cvvRespCode) {
        this.cvvRespCode = cvvRespCode;
    }


    /**
     * Gets the superBlockID value for this FlexCacheResponseElement.
     * 
     * @return superBlockID
     */
    public java.lang.String getSuperBlockID() {
        return superBlockID;
    }


    /**
     * Sets the superBlockID value for this FlexCacheResponseElement.
     * 
     * @param superBlockID
     */
    public void setSuperBlockID(java.lang.String superBlockID) {
        this.superBlockID = superBlockID;
    }


    /**
     * Gets the fraudScoreProcStatus value for this FlexCacheResponseElement.
     * 
     * @return fraudScoreProcStatus
     */
    public java.lang.String getFraudScoreProcStatus() {
        return fraudScoreProcStatus;
    }


    /**
     * Sets the fraudScoreProcStatus value for this FlexCacheResponseElement.
     * 
     * @param fraudScoreProcStatus
     */
    public void setFraudScoreProcStatus(java.lang.String fraudScoreProcStatus) {
        this.fraudScoreProcStatus = fraudScoreProcStatus;
    }


    /**
     * Gets the fraudScoreProcMsg value for this FlexCacheResponseElement.
     * 
     * @return fraudScoreProcMsg
     */
    public java.lang.String getFraudScoreProcMsg() {
        return fraudScoreProcMsg;
    }


    /**
     * Sets the fraudScoreProcMsg value for this FlexCacheResponseElement.
     * 
     * @param fraudScoreProcMsg
     */
    public void setFraudScoreProcMsg(java.lang.String fraudScoreProcMsg) {
        this.fraudScoreProcMsg = fraudScoreProcMsg;
    }


    /**
     * Gets the fraudAnalysisResponse value for this FlexCacheResponseElement.
     * 
     * @return fraudAnalysisResponse
     */
    public net.paymentech.ws.FraudAnalysisResponseType getFraudAnalysisResponse() {
        return fraudAnalysisResponse;
    }


    /**
     * Sets the fraudAnalysisResponse value for this FlexCacheResponseElement.
     * 
     * @param fraudAnalysisResponse
     */
    public void setFraudAnalysisResponse(net.paymentech.ws.FraudAnalysisResponseType fraudAnalysisResponse) {
        this.fraudAnalysisResponse = fraudAnalysisResponse;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof FlexCacheResponseElement)) return false;
        FlexCacheResponseElement other = (FlexCacheResponseElement) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.version==null && other.getVersion()==null) || 
             (this.version!=null &&
              this.version.equals(other.getVersion()))) &&
            ((this.merchantID==null && other.getMerchantID()==null) || 
             (this.merchantID!=null &&
              this.merchantID.equals(other.getMerchantID()))) &&
            ((this.terminalID==null && other.getTerminalID()==null) || 
             (this.terminalID!=null &&
              this.terminalID.equals(other.getTerminalID()))) &&
            ((this.orderID==null && other.getOrderID()==null) || 
             (this.orderID!=null &&
              this.orderID.equals(other.getOrderID()))) &&
            ((this.ccAccountNum==null && other.getCcAccountNum()==null) || 
             (this.ccAccountNum!=null &&
              this.ccAccountNum.equals(other.getCcAccountNum()))) &&
            ((this.startAccountNum==null && other.getStartAccountNum()==null) || 
             (this.startAccountNum!=null &&
              this.startAccountNum.equals(other.getStartAccountNum()))) &&
            ((this.flexAcctBalance==null && other.getFlexAcctBalance()==null) || 
             (this.flexAcctBalance!=null &&
              this.flexAcctBalance.equals(other.getFlexAcctBalance()))) &&
            ((this.flexAcctPriorBalance==null && other.getFlexAcctPriorBalance()==null) || 
             (this.flexAcctPriorBalance!=null &&
              this.flexAcctPriorBalance.equals(other.getFlexAcctPriorBalance()))) &&
            ((this.flexAcctExpireDate==null && other.getFlexAcctExpireDate()==null) || 
             (this.flexAcctExpireDate!=null &&
              this.flexAcctExpireDate.equals(other.getFlexAcctExpireDate()))) &&
            ((this.cardType==null && other.getCardType()==null) || 
             (this.cardType!=null &&
              this.cardType.equals(other.getCardType()))) &&
            ((this.txRefIdx==null && other.getTxRefIdx()==null) || 
             (this.txRefIdx!=null &&
              this.txRefIdx.equals(other.getTxRefIdx()))) &&
            ((this.txRefNum==null && other.getTxRefNum()==null) || 
             (this.txRefNum!=null &&
              this.txRefNum.equals(other.getTxRefNum()))) &&
            ((this.procStatus==null && other.getProcStatus()==null) || 
             (this.procStatus!=null &&
              this.procStatus.equals(other.getProcStatus()))) &&
            ((this.procStatusMessage==null && other.getProcStatusMessage()==null) || 
             (this.procStatusMessage!=null &&
              this.procStatusMessage.equals(other.getProcStatusMessage()))) &&
            ((this.approvalStatus==null && other.getApprovalStatus()==null) || 
             (this.approvalStatus!=null &&
              this.approvalStatus.equals(other.getApprovalStatus()))) &&
            ((this.authorizationCode==null && other.getAuthorizationCode()==null) || 
             (this.authorizationCode!=null &&
              this.authorizationCode.equals(other.getAuthorizationCode()))) &&
            ((this.respCode==null && other.getRespCode()==null) || 
             (this.respCode!=null &&
              this.respCode.equals(other.getRespCode()))) &&
            ((this.batchFailedAcctNum==null && other.getBatchFailedAcctNum()==null) || 
             (this.batchFailedAcctNum!=null &&
              this.batchFailedAcctNum.equals(other.getBatchFailedAcctNum()))) &&
            ((this.flexRequestedAmount==null && other.getFlexRequestedAmount()==null) || 
             (this.flexRequestedAmount!=null &&
              this.flexRequestedAmount.equals(other.getFlexRequestedAmount()))) &&
            ((this.flexRedeemedAmt==null && other.getFlexRedeemedAmt()==null) || 
             (this.flexRedeemedAmt!=null &&
              this.flexRedeemedAmt.equals(other.getFlexRedeemedAmt()))) &&
            ((this.flexHostTrace==null && other.getFlexHostTrace()==null) || 
             (this.flexHostTrace!=null &&
              this.flexHostTrace.equals(other.getFlexHostTrace()))) &&
            ((this.flexAction==null && other.getFlexAction()==null) || 
             (this.flexAction!=null &&
              this.flexAction.equals(other.getFlexAction()))) &&
            ((this.respDateTime==null && other.getRespDateTime()==null) || 
             (this.respDateTime!=null &&
              this.respDateTime.equals(other.getRespDateTime()))) &&
            ((this.autoAuthTxRefIdx==null && other.getAutoAuthTxRefIdx()==null) || 
             (this.autoAuthTxRefIdx!=null &&
              this.autoAuthTxRefIdx.equals(other.getAutoAuthTxRefIdx()))) &&
            ((this.autoAuthTxRefNum==null && other.getAutoAuthTxRefNum()==null) || 
             (this.autoAuthTxRefNum!=null &&
              this.autoAuthTxRefNum.equals(other.getAutoAuthTxRefNum()))) &&
            ((this.autoAuthProcStatus==null && other.getAutoAuthProcStatus()==null) || 
             (this.autoAuthProcStatus!=null &&
              this.autoAuthProcStatus.equals(other.getAutoAuthProcStatus()))) &&
            ((this.autoAuthStatusMsg==null && other.getAutoAuthStatusMsg()==null) || 
             (this.autoAuthStatusMsg!=null &&
              this.autoAuthStatusMsg.equals(other.getAutoAuthStatusMsg()))) &&
            ((this.autoAuthApprovalStatus==null && other.getAutoAuthApprovalStatus()==null) || 
             (this.autoAuthApprovalStatus!=null &&
              this.autoAuthApprovalStatus.equals(other.getAutoAuthApprovalStatus()))) &&
            ((this.autoAuthFlexRedeemedAmt==null && other.getAutoAuthFlexRedeemedAmt()==null) || 
             (this.autoAuthFlexRedeemedAmt!=null &&
              this.autoAuthFlexRedeemedAmt.equals(other.getAutoAuthFlexRedeemedAmt()))) &&
            ((this.autoAuthResponseCodes==null && other.getAutoAuthResponseCodes()==null) || 
             (this.autoAuthResponseCodes!=null &&
              this.autoAuthResponseCodes.equals(other.getAutoAuthResponseCodes()))) &&
            ((this.autoAuthFlexHostTrace==null && other.getAutoAuthFlexHostTrace()==null) || 
             (this.autoAuthFlexHostTrace!=null &&
              this.autoAuthFlexHostTrace.equals(other.getAutoAuthFlexHostTrace()))) &&
            ((this.autoAuthFlexAction==null && other.getAutoAuthFlexAction()==null) || 
             (this.autoAuthFlexAction!=null &&
              this.autoAuthFlexAction.equals(other.getAutoAuthFlexAction()))) &&
            ((this.autoAuthRespTime==null && other.getAutoAuthRespTime()==null) || 
             (this.autoAuthRespTime!=null &&
              this.autoAuthRespTime.equals(other.getAutoAuthRespTime()))) &&
            ((this.retryTrace==null && other.getRetryTrace()==null) || 
             (this.retryTrace!=null &&
              this.retryTrace.equals(other.getRetryTrace()))) &&
            ((this.retryAttempCount==null && other.getRetryAttempCount()==null) || 
             (this.retryAttempCount!=null &&
              this.retryAttempCount.equals(other.getRetryAttempCount()))) &&
            ((this.lastRetryDate==null && other.getLastRetryDate()==null) || 
             (this.lastRetryDate!=null &&
              this.lastRetryDate.equals(other.getLastRetryDate()))) &&
            ((this.cvvRespCode==null && other.getCvvRespCode()==null) || 
             (this.cvvRespCode!=null &&
              this.cvvRespCode.equals(other.getCvvRespCode()))) &&
            ((this.superBlockID==null && other.getSuperBlockID()==null) || 
             (this.superBlockID!=null &&
              this.superBlockID.equals(other.getSuperBlockID()))) &&
            ((this.fraudScoreProcStatus==null && other.getFraudScoreProcStatus()==null) || 
             (this.fraudScoreProcStatus!=null &&
              this.fraudScoreProcStatus.equals(other.getFraudScoreProcStatus()))) &&
            ((this.fraudScoreProcMsg==null && other.getFraudScoreProcMsg()==null) || 
             (this.fraudScoreProcMsg!=null &&
              this.fraudScoreProcMsg.equals(other.getFraudScoreProcMsg()))) &&
            ((this.fraudAnalysisResponse==null && other.getFraudAnalysisResponse()==null) || 
             (this.fraudAnalysisResponse!=null &&
              this.fraudAnalysisResponse.equals(other.getFraudAnalysisResponse())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getVersion() != null) {
            _hashCode += getVersion().hashCode();
        }
        if (getMerchantID() != null) {
            _hashCode += getMerchantID().hashCode();
        }
        if (getTerminalID() != null) {
            _hashCode += getTerminalID().hashCode();
        }
        if (getOrderID() != null) {
            _hashCode += getOrderID().hashCode();
        }
        if (getCcAccountNum() != null) {
            _hashCode += getCcAccountNum().hashCode();
        }
        if (getStartAccountNum() != null) {
            _hashCode += getStartAccountNum().hashCode();
        }
        if (getFlexAcctBalance() != null) {
            _hashCode += getFlexAcctBalance().hashCode();
        }
        if (getFlexAcctPriorBalance() != null) {
            _hashCode += getFlexAcctPriorBalance().hashCode();
        }
        if (getFlexAcctExpireDate() != null) {
            _hashCode += getFlexAcctExpireDate().hashCode();
        }
        if (getCardType() != null) {
            _hashCode += getCardType().hashCode();
        }
        if (getTxRefIdx() != null) {
            _hashCode += getTxRefIdx().hashCode();
        }
        if (getTxRefNum() != null) {
            _hashCode += getTxRefNum().hashCode();
        }
        if (getProcStatus() != null) {
            _hashCode += getProcStatus().hashCode();
        }
        if (getProcStatusMessage() != null) {
            _hashCode += getProcStatusMessage().hashCode();
        }
        if (getApprovalStatus() != null) {
            _hashCode += getApprovalStatus().hashCode();
        }
        if (getAuthorizationCode() != null) {
            _hashCode += getAuthorizationCode().hashCode();
        }
        if (getRespCode() != null) {
            _hashCode += getRespCode().hashCode();
        }
        if (getBatchFailedAcctNum() != null) {
            _hashCode += getBatchFailedAcctNum().hashCode();
        }
        if (getFlexRequestedAmount() != null) {
            _hashCode += getFlexRequestedAmount().hashCode();
        }
        if (getFlexRedeemedAmt() != null) {
            _hashCode += getFlexRedeemedAmt().hashCode();
        }
        if (getFlexHostTrace() != null) {
            _hashCode += getFlexHostTrace().hashCode();
        }
        if (getFlexAction() != null) {
            _hashCode += getFlexAction().hashCode();
        }
        if (getRespDateTime() != null) {
            _hashCode += getRespDateTime().hashCode();
        }
        if (getAutoAuthTxRefIdx() != null) {
            _hashCode += getAutoAuthTxRefIdx().hashCode();
        }
        if (getAutoAuthTxRefNum() != null) {
            _hashCode += getAutoAuthTxRefNum().hashCode();
        }
        if (getAutoAuthProcStatus() != null) {
            _hashCode += getAutoAuthProcStatus().hashCode();
        }
        if (getAutoAuthStatusMsg() != null) {
            _hashCode += getAutoAuthStatusMsg().hashCode();
        }
        if (getAutoAuthApprovalStatus() != null) {
            _hashCode += getAutoAuthApprovalStatus().hashCode();
        }
        if (getAutoAuthFlexRedeemedAmt() != null) {
            _hashCode += getAutoAuthFlexRedeemedAmt().hashCode();
        }
        if (getAutoAuthResponseCodes() != null) {
            _hashCode += getAutoAuthResponseCodes().hashCode();
        }
        if (getAutoAuthFlexHostTrace() != null) {
            _hashCode += getAutoAuthFlexHostTrace().hashCode();
        }
        if (getAutoAuthFlexAction() != null) {
            _hashCode += getAutoAuthFlexAction().hashCode();
        }
        if (getAutoAuthRespTime() != null) {
            _hashCode += getAutoAuthRespTime().hashCode();
        }
        if (getRetryTrace() != null) {
            _hashCode += getRetryTrace().hashCode();
        }
        if (getRetryAttempCount() != null) {
            _hashCode += getRetryAttempCount().hashCode();
        }
        if (getLastRetryDate() != null) {
            _hashCode += getLastRetryDate().hashCode();
        }
        if (getCvvRespCode() != null) {
            _hashCode += getCvvRespCode().hashCode();
        }
        if (getSuperBlockID() != null) {
            _hashCode += getSuperBlockID().hashCode();
        }
        if (getFraudScoreProcStatus() != null) {
            _hashCode += getFraudScoreProcStatus().hashCode();
        }
        if (getFraudScoreProcMsg() != null) {
            _hashCode += getFraudScoreProcMsg().hashCode();
        }
        if (getFraudAnalysisResponse() != null) {
            _hashCode += getFraudAnalysisResponse().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(FlexCacheResponseElement.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "FlexCacheResponseElement"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("version");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "version"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("merchantID");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "merchantID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("terminalID");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "terminalID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("orderID");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "orderID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ccAccountNum");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "ccAccountNum"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("startAccountNum");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "startAccountNum"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("flexAcctBalance");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "flexAcctBalance"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("flexAcctPriorBalance");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "flexAcctPriorBalance"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("flexAcctExpireDate");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "flexAcctExpireDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cardType");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "cardType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("txRefIdx");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "txRefIdx"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("txRefNum");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "txRefNum"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("procStatus");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "procStatus"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("procStatusMessage");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "procStatusMessage"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("approvalStatus");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "approvalStatus"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("authorizationCode");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "authorizationCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("respCode");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "respCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("batchFailedAcctNum");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "batchFailedAcctNum"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("flexRequestedAmount");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "flexRequestedAmount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("flexRedeemedAmt");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "flexRedeemedAmt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("flexHostTrace");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "flexHostTrace"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("flexAction");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "flexAction"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("respDateTime");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "respDateTime"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("autoAuthTxRefIdx");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "autoAuthTxRefIdx"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("autoAuthTxRefNum");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "autoAuthTxRefNum"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("autoAuthProcStatus");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "autoAuthProcStatus"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("autoAuthStatusMsg");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "autoAuthStatusMsg"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("autoAuthApprovalStatus");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "autoAuthApprovalStatus"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("autoAuthFlexRedeemedAmt");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "autoAuthFlexRedeemedAmt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("autoAuthResponseCodes");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "autoAuthResponseCodes"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("autoAuthFlexHostTrace");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "autoAuthFlexHostTrace"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("autoAuthFlexAction");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "autoAuthFlexAction"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("autoAuthRespTime");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "autoAuthRespTime"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("retryTrace");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "retryTrace"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("retryAttempCount");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "retryAttempCount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("lastRetryDate");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "lastRetryDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cvvRespCode");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "cvvRespCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("superBlockID");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "superBlockID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fraudScoreProcStatus");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "fraudScoreProcStatus"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fraudScoreProcMsg");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "fraudScoreProcMsg"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fraudAnalysisResponse");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "fraudAnalysisResponse"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "FraudAnalysisResponseType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
