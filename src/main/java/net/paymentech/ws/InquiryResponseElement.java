/**
 * InquiryResponseElement.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package net.paymentech.ws;

public class InquiryResponseElement  implements java.io.Serializable {
    private java.lang.String version;

    private java.lang.String industryType;

    private java.lang.String transType;

    private java.lang.String bin;

    private java.lang.String merchantID;

    private java.lang.String terminalID;

    private java.lang.String cardBrand;

    private java.lang.String orderID;

    private java.lang.String txRefNum;

    private java.lang.String txRefIdx;

    private java.lang.String respDateTime;

    private java.lang.String procStatus;

    private java.lang.String approvalStatus;

    private java.lang.String respCode;

    private java.lang.String avsRespCode;

    private java.lang.String cvvRespCode;

    private java.lang.String authorizationCode;

    private java.lang.String mcRecurringAdvCode;

    private java.lang.String visaVbVRespCode;

    private java.lang.String procStatusMessage;

    private java.lang.String respCodeMessage;

    private java.lang.String hostRespCode;

    private java.lang.String hostAVSRespCode;

    private java.lang.String hostCVVRespCode;

    private java.lang.String retryTrace;

    private java.lang.String retryAttempCount;

    private java.lang.String lastRetryDate;

    private java.lang.String customerRefNum;

    private java.lang.String customerName;

    private java.lang.String profileProcStatus;

    private java.lang.String profileProcStatusMsg;

    private java.lang.String giftCardInd;

    private java.lang.String remainingBalance;

    private java.lang.String requestAmount;

    private java.lang.String redeemedAmount;

    private java.lang.String ccAccountNum;

    private java.lang.String debitBillerReferenceNumber;

    private java.lang.String mbMicroPaymentDaysLeft;

    private java.lang.String mbMicroPaymentDollarsLeft;

    private java.lang.String mbStatus;

    private java.lang.String debitPinSurchargeAmount;

    private java.lang.String debitPinTraceNumber;

    private java.lang.String debitPinNetworkID;

    private java.lang.String partialAuthOccurred;

    private java.lang.String countryFraudFilterStatus;

    private java.lang.String isoCountryCode;

    private java.lang.String fraudScoreProcStatus;

    private java.lang.String fraudScoreProcMsg;

    private net.paymentech.ws.FraudAnalysisResponseType fraudAnalysisResponse;

    private java.lang.String ctiAffluentCard;

    private java.lang.String ctiCommercialCard;

    private java.lang.String ctiDurbinExemption;

    private java.lang.String ctiHealthcareCard;

    private java.lang.String ctiLevel3Eligible;

    private java.lang.String ctiPayrollCard;

    private java.lang.String ctiPrepaidCard;

    private java.lang.String ctiPINlessDebitCard;

    private java.lang.String ctiSignatureDebitCard;

    private java.lang.String ctiIssuingCountry;

    private java.lang.String euddBankSortCode;

    private java.lang.String euddCountryCode;

    private java.lang.String euddRibCode;

    private java.lang.String euddBankBranchCode;

    private java.lang.String euddIBAN;

    private java.lang.String euddBIC;

    private java.lang.String euddMandateSignatureDate;

    private java.lang.String euddMandateID;

    private java.lang.String euddMandateType;

    public InquiryResponseElement() {
    }

    public InquiryResponseElement(
           java.lang.String version,
           java.lang.String industryType,
           java.lang.String transType,
           java.lang.String bin,
           java.lang.String merchantID,
           java.lang.String terminalID,
           java.lang.String cardBrand,
           java.lang.String orderID,
           java.lang.String txRefNum,
           java.lang.String txRefIdx,
           java.lang.String respDateTime,
           java.lang.String procStatus,
           java.lang.String approvalStatus,
           java.lang.String respCode,
           java.lang.String avsRespCode,
           java.lang.String cvvRespCode,
           java.lang.String authorizationCode,
           java.lang.String mcRecurringAdvCode,
           java.lang.String visaVbVRespCode,
           java.lang.String procStatusMessage,
           java.lang.String respCodeMessage,
           java.lang.String hostRespCode,
           java.lang.String hostAVSRespCode,
           java.lang.String hostCVVRespCode,
           java.lang.String retryTrace,
           java.lang.String retryAttempCount,
           java.lang.String lastRetryDate,
           java.lang.String customerRefNum,
           java.lang.String customerName,
           java.lang.String profileProcStatus,
           java.lang.String profileProcStatusMsg,
           java.lang.String giftCardInd,
           java.lang.String remainingBalance,
           java.lang.String requestAmount,
           java.lang.String redeemedAmount,
           java.lang.String ccAccountNum,
           java.lang.String debitBillerReferenceNumber,
           java.lang.String mbMicroPaymentDaysLeft,
           java.lang.String mbMicroPaymentDollarsLeft,
           java.lang.String mbStatus,
           java.lang.String debitPinSurchargeAmount,
           java.lang.String debitPinTraceNumber,
           java.lang.String debitPinNetworkID,
           java.lang.String partialAuthOccurred,
           java.lang.String countryFraudFilterStatus,
           java.lang.String isoCountryCode,
           java.lang.String fraudScoreProcStatus,
           java.lang.String fraudScoreProcMsg,
           net.paymentech.ws.FraudAnalysisResponseType fraudAnalysisResponse,
           java.lang.String ctiAffluentCard,
           java.lang.String ctiCommercialCard,
           java.lang.String ctiDurbinExemption,
           java.lang.String ctiHealthcareCard,
           java.lang.String ctiLevel3Eligible,
           java.lang.String ctiPayrollCard,
           java.lang.String ctiPrepaidCard,
           java.lang.String ctiPINlessDebitCard,
           java.lang.String ctiSignatureDebitCard,
           java.lang.String ctiIssuingCountry,
           java.lang.String euddBankSortCode,
           java.lang.String euddCountryCode,
           java.lang.String euddRibCode,
           java.lang.String euddBankBranchCode,
           java.lang.String euddIBAN,
           java.lang.String euddBIC,
           java.lang.String euddMandateSignatureDate,
           java.lang.String euddMandateID,
           java.lang.String euddMandateType) {
           this.version = version;
           this.industryType = industryType;
           this.transType = transType;
           this.bin = bin;
           this.merchantID = merchantID;
           this.terminalID = terminalID;
           this.cardBrand = cardBrand;
           this.orderID = orderID;
           this.txRefNum = txRefNum;
           this.txRefIdx = txRefIdx;
           this.respDateTime = respDateTime;
           this.procStatus = procStatus;
           this.approvalStatus = approvalStatus;
           this.respCode = respCode;
           this.avsRespCode = avsRespCode;
           this.cvvRespCode = cvvRespCode;
           this.authorizationCode = authorizationCode;
           this.mcRecurringAdvCode = mcRecurringAdvCode;
           this.visaVbVRespCode = visaVbVRespCode;
           this.procStatusMessage = procStatusMessage;
           this.respCodeMessage = respCodeMessage;
           this.hostRespCode = hostRespCode;
           this.hostAVSRespCode = hostAVSRespCode;
           this.hostCVVRespCode = hostCVVRespCode;
           this.retryTrace = retryTrace;
           this.retryAttempCount = retryAttempCount;
           this.lastRetryDate = lastRetryDate;
           this.customerRefNum = customerRefNum;
           this.customerName = customerName;
           this.profileProcStatus = profileProcStatus;
           this.profileProcStatusMsg = profileProcStatusMsg;
           this.giftCardInd = giftCardInd;
           this.remainingBalance = remainingBalance;
           this.requestAmount = requestAmount;
           this.redeemedAmount = redeemedAmount;
           this.ccAccountNum = ccAccountNum;
           this.debitBillerReferenceNumber = debitBillerReferenceNumber;
           this.mbMicroPaymentDaysLeft = mbMicroPaymentDaysLeft;
           this.mbMicroPaymentDollarsLeft = mbMicroPaymentDollarsLeft;
           this.mbStatus = mbStatus;
           this.debitPinSurchargeAmount = debitPinSurchargeAmount;
           this.debitPinTraceNumber = debitPinTraceNumber;
           this.debitPinNetworkID = debitPinNetworkID;
           this.partialAuthOccurred = partialAuthOccurred;
           this.countryFraudFilterStatus = countryFraudFilterStatus;
           this.isoCountryCode = isoCountryCode;
           this.fraudScoreProcStatus = fraudScoreProcStatus;
           this.fraudScoreProcMsg = fraudScoreProcMsg;
           this.fraudAnalysisResponse = fraudAnalysisResponse;
           this.ctiAffluentCard = ctiAffluentCard;
           this.ctiCommercialCard = ctiCommercialCard;
           this.ctiDurbinExemption = ctiDurbinExemption;
           this.ctiHealthcareCard = ctiHealthcareCard;
           this.ctiLevel3Eligible = ctiLevel3Eligible;
           this.ctiPayrollCard = ctiPayrollCard;
           this.ctiPrepaidCard = ctiPrepaidCard;
           this.ctiPINlessDebitCard = ctiPINlessDebitCard;
           this.ctiSignatureDebitCard = ctiSignatureDebitCard;
           this.ctiIssuingCountry = ctiIssuingCountry;
           this.euddBankSortCode = euddBankSortCode;
           this.euddCountryCode = euddCountryCode;
           this.euddRibCode = euddRibCode;
           this.euddBankBranchCode = euddBankBranchCode;
           this.euddIBAN = euddIBAN;
           this.euddBIC = euddBIC;
           this.euddMandateSignatureDate = euddMandateSignatureDate;
           this.euddMandateID = euddMandateID;
           this.euddMandateType = euddMandateType;
    }


    /**
     * Gets the version value for this InquiryResponseElement.
     * 
     * @return version
     */
    public java.lang.String getVersion() {
        return version;
    }


    /**
     * Sets the version value for this InquiryResponseElement.
     * 
     * @param version
     */
    public void setVersion(java.lang.String version) {
        this.version = version;
    }


    /**
     * Gets the industryType value for this InquiryResponseElement.
     * 
     * @return industryType
     */
    public java.lang.String getIndustryType() {
        return industryType;
    }


    /**
     * Sets the industryType value for this InquiryResponseElement.
     * 
     * @param industryType
     */
    public void setIndustryType(java.lang.String industryType) {
        this.industryType = industryType;
    }


    /**
     * Gets the transType value for this InquiryResponseElement.
     * 
     * @return transType
     */
    public java.lang.String getTransType() {
        return transType;
    }


    /**
     * Sets the transType value for this InquiryResponseElement.
     * 
     * @param transType
     */
    public void setTransType(java.lang.String transType) {
        this.transType = transType;
    }


    /**
     * Gets the bin value for this InquiryResponseElement.
     * 
     * @return bin
     */
    public java.lang.String getBin() {
        return bin;
    }


    /**
     * Sets the bin value for this InquiryResponseElement.
     * 
     * @param bin
     */
    public void setBin(java.lang.String bin) {
        this.bin = bin;
    }


    /**
     * Gets the merchantID value for this InquiryResponseElement.
     * 
     * @return merchantID
     */
    public java.lang.String getMerchantID() {
        return merchantID;
    }


    /**
     * Sets the merchantID value for this InquiryResponseElement.
     * 
     * @param merchantID
     */
    public void setMerchantID(java.lang.String merchantID) {
        this.merchantID = merchantID;
    }


    /**
     * Gets the terminalID value for this InquiryResponseElement.
     * 
     * @return terminalID
     */
    public java.lang.String getTerminalID() {
        return terminalID;
    }


    /**
     * Sets the terminalID value for this InquiryResponseElement.
     * 
     * @param terminalID
     */
    public void setTerminalID(java.lang.String terminalID) {
        this.terminalID = terminalID;
    }


    /**
     * Gets the cardBrand value for this InquiryResponseElement.
     * 
     * @return cardBrand
     */
    public java.lang.String getCardBrand() {
        return cardBrand;
    }


    /**
     * Sets the cardBrand value for this InquiryResponseElement.
     * 
     * @param cardBrand
     */
    public void setCardBrand(java.lang.String cardBrand) {
        this.cardBrand = cardBrand;
    }


    /**
     * Gets the orderID value for this InquiryResponseElement.
     * 
     * @return orderID
     */
    public java.lang.String getOrderID() {
        return orderID;
    }


    /**
     * Sets the orderID value for this InquiryResponseElement.
     * 
     * @param orderID
     */
    public void setOrderID(java.lang.String orderID) {
        this.orderID = orderID;
    }


    /**
     * Gets the txRefNum value for this InquiryResponseElement.
     * 
     * @return txRefNum
     */
    public java.lang.String getTxRefNum() {
        return txRefNum;
    }


    /**
     * Sets the txRefNum value for this InquiryResponseElement.
     * 
     * @param txRefNum
     */
    public void setTxRefNum(java.lang.String txRefNum) {
        this.txRefNum = txRefNum;
    }


    /**
     * Gets the txRefIdx value for this InquiryResponseElement.
     * 
     * @return txRefIdx
     */
    public java.lang.String getTxRefIdx() {
        return txRefIdx;
    }


    /**
     * Sets the txRefIdx value for this InquiryResponseElement.
     * 
     * @param txRefIdx
     */
    public void setTxRefIdx(java.lang.String txRefIdx) {
        this.txRefIdx = txRefIdx;
    }


    /**
     * Gets the respDateTime value for this InquiryResponseElement.
     * 
     * @return respDateTime
     */
    public java.lang.String getRespDateTime() {
        return respDateTime;
    }


    /**
     * Sets the respDateTime value for this InquiryResponseElement.
     * 
     * @param respDateTime
     */
    public void setRespDateTime(java.lang.String respDateTime) {
        this.respDateTime = respDateTime;
    }


    /**
     * Gets the procStatus value for this InquiryResponseElement.
     * 
     * @return procStatus
     */
    public java.lang.String getProcStatus() {
        return procStatus;
    }


    /**
     * Sets the procStatus value for this InquiryResponseElement.
     * 
     * @param procStatus
     */
    public void setProcStatus(java.lang.String procStatus) {
        this.procStatus = procStatus;
    }


    /**
     * Gets the approvalStatus value for this InquiryResponseElement.
     * 
     * @return approvalStatus
     */
    public java.lang.String getApprovalStatus() {
        return approvalStatus;
    }


    /**
     * Sets the approvalStatus value for this InquiryResponseElement.
     * 
     * @param approvalStatus
     */
    public void setApprovalStatus(java.lang.String approvalStatus) {
        this.approvalStatus = approvalStatus;
    }


    /**
     * Gets the respCode value for this InquiryResponseElement.
     * 
     * @return respCode
     */
    public java.lang.String getRespCode() {
        return respCode;
    }


    /**
     * Sets the respCode value for this InquiryResponseElement.
     * 
     * @param respCode
     */
    public void setRespCode(java.lang.String respCode) {
        this.respCode = respCode;
    }


    /**
     * Gets the avsRespCode value for this InquiryResponseElement.
     * 
     * @return avsRespCode
     */
    public java.lang.String getAvsRespCode() {
        return avsRespCode;
    }


    /**
     * Sets the avsRespCode value for this InquiryResponseElement.
     * 
     * @param avsRespCode
     */
    public void setAvsRespCode(java.lang.String avsRespCode) {
        this.avsRespCode = avsRespCode;
    }


    /**
     * Gets the cvvRespCode value for this InquiryResponseElement.
     * 
     * @return cvvRespCode
     */
    public java.lang.String getCvvRespCode() {
        return cvvRespCode;
    }


    /**
     * Sets the cvvRespCode value for this InquiryResponseElement.
     * 
     * @param cvvRespCode
     */
    public void setCvvRespCode(java.lang.String cvvRespCode) {
        this.cvvRespCode = cvvRespCode;
    }


    /**
     * Gets the authorizationCode value for this InquiryResponseElement.
     * 
     * @return authorizationCode
     */
    public java.lang.String getAuthorizationCode() {
        return authorizationCode;
    }


    /**
     * Sets the authorizationCode value for this InquiryResponseElement.
     * 
     * @param authorizationCode
     */
    public void setAuthorizationCode(java.lang.String authorizationCode) {
        this.authorizationCode = authorizationCode;
    }


    /**
     * Gets the mcRecurringAdvCode value for this InquiryResponseElement.
     * 
     * @return mcRecurringAdvCode
     */
    public java.lang.String getMcRecurringAdvCode() {
        return mcRecurringAdvCode;
    }


    /**
     * Sets the mcRecurringAdvCode value for this InquiryResponseElement.
     * 
     * @param mcRecurringAdvCode
     */
    public void setMcRecurringAdvCode(java.lang.String mcRecurringAdvCode) {
        this.mcRecurringAdvCode = mcRecurringAdvCode;
    }


    /**
     * Gets the visaVbVRespCode value for this InquiryResponseElement.
     * 
     * @return visaVbVRespCode
     */
    public java.lang.String getVisaVbVRespCode() {
        return visaVbVRespCode;
    }


    /**
     * Sets the visaVbVRespCode value for this InquiryResponseElement.
     * 
     * @param visaVbVRespCode
     */
    public void setVisaVbVRespCode(java.lang.String visaVbVRespCode) {
        this.visaVbVRespCode = visaVbVRespCode;
    }


    /**
     * Gets the procStatusMessage value for this InquiryResponseElement.
     * 
     * @return procStatusMessage
     */
    public java.lang.String getProcStatusMessage() {
        return procStatusMessage;
    }


    /**
     * Sets the procStatusMessage value for this InquiryResponseElement.
     * 
     * @param procStatusMessage
     */
    public void setProcStatusMessage(java.lang.String procStatusMessage) {
        this.procStatusMessage = procStatusMessage;
    }


    /**
     * Gets the respCodeMessage value for this InquiryResponseElement.
     * 
     * @return respCodeMessage
     */
    public java.lang.String getRespCodeMessage() {
        return respCodeMessage;
    }


    /**
     * Sets the respCodeMessage value for this InquiryResponseElement.
     * 
     * @param respCodeMessage
     */
    public void setRespCodeMessage(java.lang.String respCodeMessage) {
        this.respCodeMessage = respCodeMessage;
    }


    /**
     * Gets the hostRespCode value for this InquiryResponseElement.
     * 
     * @return hostRespCode
     */
    public java.lang.String getHostRespCode() {
        return hostRespCode;
    }


    /**
     * Sets the hostRespCode value for this InquiryResponseElement.
     * 
     * @param hostRespCode
     */
    public void setHostRespCode(java.lang.String hostRespCode) {
        this.hostRespCode = hostRespCode;
    }


    /**
     * Gets the hostAVSRespCode value for this InquiryResponseElement.
     * 
     * @return hostAVSRespCode
     */
    public java.lang.String getHostAVSRespCode() {
        return hostAVSRespCode;
    }


    /**
     * Sets the hostAVSRespCode value for this InquiryResponseElement.
     * 
     * @param hostAVSRespCode
     */
    public void setHostAVSRespCode(java.lang.String hostAVSRespCode) {
        this.hostAVSRespCode = hostAVSRespCode;
    }


    /**
     * Gets the hostCVVRespCode value for this InquiryResponseElement.
     * 
     * @return hostCVVRespCode
     */
    public java.lang.String getHostCVVRespCode() {
        return hostCVVRespCode;
    }


    /**
     * Sets the hostCVVRespCode value for this InquiryResponseElement.
     * 
     * @param hostCVVRespCode
     */
    public void setHostCVVRespCode(java.lang.String hostCVVRespCode) {
        this.hostCVVRespCode = hostCVVRespCode;
    }


    /**
     * Gets the retryTrace value for this InquiryResponseElement.
     * 
     * @return retryTrace
     */
    public java.lang.String getRetryTrace() {
        return retryTrace;
    }


    /**
     * Sets the retryTrace value for this InquiryResponseElement.
     * 
     * @param retryTrace
     */
    public void setRetryTrace(java.lang.String retryTrace) {
        this.retryTrace = retryTrace;
    }


    /**
     * Gets the retryAttempCount value for this InquiryResponseElement.
     * 
     * @return retryAttempCount
     */
    public java.lang.String getRetryAttempCount() {
        return retryAttempCount;
    }


    /**
     * Sets the retryAttempCount value for this InquiryResponseElement.
     * 
     * @param retryAttempCount
     */
    public void setRetryAttempCount(java.lang.String retryAttempCount) {
        this.retryAttempCount = retryAttempCount;
    }


    /**
     * Gets the lastRetryDate value for this InquiryResponseElement.
     * 
     * @return lastRetryDate
     */
    public java.lang.String getLastRetryDate() {
        return lastRetryDate;
    }


    /**
     * Sets the lastRetryDate value for this InquiryResponseElement.
     * 
     * @param lastRetryDate
     */
    public void setLastRetryDate(java.lang.String lastRetryDate) {
        this.lastRetryDate = lastRetryDate;
    }


    /**
     * Gets the customerRefNum value for this InquiryResponseElement.
     * 
     * @return customerRefNum
     */
    public java.lang.String getCustomerRefNum() {
        return customerRefNum;
    }


    /**
     * Sets the customerRefNum value for this InquiryResponseElement.
     * 
     * @param customerRefNum
     */
    public void setCustomerRefNum(java.lang.String customerRefNum) {
        this.customerRefNum = customerRefNum;
    }


    /**
     * Gets the customerName value for this InquiryResponseElement.
     * 
     * @return customerName
     */
    public java.lang.String getCustomerName() {
        return customerName;
    }


    /**
     * Sets the customerName value for this InquiryResponseElement.
     * 
     * @param customerName
     */
    public void setCustomerName(java.lang.String customerName) {
        this.customerName = customerName;
    }


    /**
     * Gets the profileProcStatus value for this InquiryResponseElement.
     * 
     * @return profileProcStatus
     */
    public java.lang.String getProfileProcStatus() {
        return profileProcStatus;
    }


    /**
     * Sets the profileProcStatus value for this InquiryResponseElement.
     * 
     * @param profileProcStatus
     */
    public void setProfileProcStatus(java.lang.String profileProcStatus) {
        this.profileProcStatus = profileProcStatus;
    }


    /**
     * Gets the profileProcStatusMsg value for this InquiryResponseElement.
     * 
     * @return profileProcStatusMsg
     */
    public java.lang.String getProfileProcStatusMsg() {
        return profileProcStatusMsg;
    }


    /**
     * Sets the profileProcStatusMsg value for this InquiryResponseElement.
     * 
     * @param profileProcStatusMsg
     */
    public void setProfileProcStatusMsg(java.lang.String profileProcStatusMsg) {
        this.profileProcStatusMsg = profileProcStatusMsg;
    }


    /**
     * Gets the giftCardInd value for this InquiryResponseElement.
     * 
     * @return giftCardInd
     */
    public java.lang.String getGiftCardInd() {
        return giftCardInd;
    }


    /**
     * Sets the giftCardInd value for this InquiryResponseElement.
     * 
     * @param giftCardInd
     */
    public void setGiftCardInd(java.lang.String giftCardInd) {
        this.giftCardInd = giftCardInd;
    }


    /**
     * Gets the remainingBalance value for this InquiryResponseElement.
     * 
     * @return remainingBalance
     */
    public java.lang.String getRemainingBalance() {
        return remainingBalance;
    }


    /**
     * Sets the remainingBalance value for this InquiryResponseElement.
     * 
     * @param remainingBalance
     */
    public void setRemainingBalance(java.lang.String remainingBalance) {
        this.remainingBalance = remainingBalance;
    }


    /**
     * Gets the requestAmount value for this InquiryResponseElement.
     * 
     * @return requestAmount
     */
    public java.lang.String getRequestAmount() {
        return requestAmount;
    }


    /**
     * Sets the requestAmount value for this InquiryResponseElement.
     * 
     * @param requestAmount
     */
    public void setRequestAmount(java.lang.String requestAmount) {
        this.requestAmount = requestAmount;
    }


    /**
     * Gets the redeemedAmount value for this InquiryResponseElement.
     * 
     * @return redeemedAmount
     */
    public java.lang.String getRedeemedAmount() {
        return redeemedAmount;
    }


    /**
     * Sets the redeemedAmount value for this InquiryResponseElement.
     * 
     * @param redeemedAmount
     */
    public void setRedeemedAmount(java.lang.String redeemedAmount) {
        this.redeemedAmount = redeemedAmount;
    }


    /**
     * Gets the ccAccountNum value for this InquiryResponseElement.
     * 
     * @return ccAccountNum
     */
    public java.lang.String getCcAccountNum() {
        return ccAccountNum;
    }


    /**
     * Sets the ccAccountNum value for this InquiryResponseElement.
     * 
     * @param ccAccountNum
     */
    public void setCcAccountNum(java.lang.String ccAccountNum) {
        this.ccAccountNum = ccAccountNum;
    }


    /**
     * Gets the debitBillerReferenceNumber value for this InquiryResponseElement.
     * 
     * @return debitBillerReferenceNumber
     */
    public java.lang.String getDebitBillerReferenceNumber() {
        return debitBillerReferenceNumber;
    }


    /**
     * Sets the debitBillerReferenceNumber value for this InquiryResponseElement.
     * 
     * @param debitBillerReferenceNumber
     */
    public void setDebitBillerReferenceNumber(java.lang.String debitBillerReferenceNumber) {
        this.debitBillerReferenceNumber = debitBillerReferenceNumber;
    }


    /**
     * Gets the mbMicroPaymentDaysLeft value for this InquiryResponseElement.
     * 
     * @return mbMicroPaymentDaysLeft
     */
    public java.lang.String getMbMicroPaymentDaysLeft() {
        return mbMicroPaymentDaysLeft;
    }


    /**
     * Sets the mbMicroPaymentDaysLeft value for this InquiryResponseElement.
     * 
     * @param mbMicroPaymentDaysLeft
     */
    public void setMbMicroPaymentDaysLeft(java.lang.String mbMicroPaymentDaysLeft) {
        this.mbMicroPaymentDaysLeft = mbMicroPaymentDaysLeft;
    }


    /**
     * Gets the mbMicroPaymentDollarsLeft value for this InquiryResponseElement.
     * 
     * @return mbMicroPaymentDollarsLeft
     */
    public java.lang.String getMbMicroPaymentDollarsLeft() {
        return mbMicroPaymentDollarsLeft;
    }


    /**
     * Sets the mbMicroPaymentDollarsLeft value for this InquiryResponseElement.
     * 
     * @param mbMicroPaymentDollarsLeft
     */
    public void setMbMicroPaymentDollarsLeft(java.lang.String mbMicroPaymentDollarsLeft) {
        this.mbMicroPaymentDollarsLeft = mbMicroPaymentDollarsLeft;
    }


    /**
     * Gets the mbStatus value for this InquiryResponseElement.
     * 
     * @return mbStatus
     */
    public java.lang.String getMbStatus() {
        return mbStatus;
    }


    /**
     * Sets the mbStatus value for this InquiryResponseElement.
     * 
     * @param mbStatus
     */
    public void setMbStatus(java.lang.String mbStatus) {
        this.mbStatus = mbStatus;
    }


    /**
     * Gets the debitPinSurchargeAmount value for this InquiryResponseElement.
     * 
     * @return debitPinSurchargeAmount
     */
    public java.lang.String getDebitPinSurchargeAmount() {
        return debitPinSurchargeAmount;
    }


    /**
     * Sets the debitPinSurchargeAmount value for this InquiryResponseElement.
     * 
     * @param debitPinSurchargeAmount
     */
    public void setDebitPinSurchargeAmount(java.lang.String debitPinSurchargeAmount) {
        this.debitPinSurchargeAmount = debitPinSurchargeAmount;
    }


    /**
     * Gets the debitPinTraceNumber value for this InquiryResponseElement.
     * 
     * @return debitPinTraceNumber
     */
    public java.lang.String getDebitPinTraceNumber() {
        return debitPinTraceNumber;
    }


    /**
     * Sets the debitPinTraceNumber value for this InquiryResponseElement.
     * 
     * @param debitPinTraceNumber
     */
    public void setDebitPinTraceNumber(java.lang.String debitPinTraceNumber) {
        this.debitPinTraceNumber = debitPinTraceNumber;
    }


    /**
     * Gets the debitPinNetworkID value for this InquiryResponseElement.
     * 
     * @return debitPinNetworkID
     */
    public java.lang.String getDebitPinNetworkID() {
        return debitPinNetworkID;
    }


    /**
     * Sets the debitPinNetworkID value for this InquiryResponseElement.
     * 
     * @param debitPinNetworkID
     */
    public void setDebitPinNetworkID(java.lang.String debitPinNetworkID) {
        this.debitPinNetworkID = debitPinNetworkID;
    }


    /**
     * Gets the partialAuthOccurred value for this InquiryResponseElement.
     * 
     * @return partialAuthOccurred
     */
    public java.lang.String getPartialAuthOccurred() {
        return partialAuthOccurred;
    }


    /**
     * Sets the partialAuthOccurred value for this InquiryResponseElement.
     * 
     * @param partialAuthOccurred
     */
    public void setPartialAuthOccurred(java.lang.String partialAuthOccurred) {
        this.partialAuthOccurred = partialAuthOccurred;
    }


    /**
     * Gets the countryFraudFilterStatus value for this InquiryResponseElement.
     * 
     * @return countryFraudFilterStatus
     */
    public java.lang.String getCountryFraudFilterStatus() {
        return countryFraudFilterStatus;
    }


    /**
     * Sets the countryFraudFilterStatus value for this InquiryResponseElement.
     * 
     * @param countryFraudFilterStatus
     */
    public void setCountryFraudFilterStatus(java.lang.String countryFraudFilterStatus) {
        this.countryFraudFilterStatus = countryFraudFilterStatus;
    }


    /**
     * Gets the isoCountryCode value for this InquiryResponseElement.
     * 
     * @return isoCountryCode
     */
    public java.lang.String getIsoCountryCode() {
        return isoCountryCode;
    }


    /**
     * Sets the isoCountryCode value for this InquiryResponseElement.
     * 
     * @param isoCountryCode
     */
    public void setIsoCountryCode(java.lang.String isoCountryCode) {
        this.isoCountryCode = isoCountryCode;
    }


    /**
     * Gets the fraudScoreProcStatus value for this InquiryResponseElement.
     * 
     * @return fraudScoreProcStatus
     */
    public java.lang.String getFraudScoreProcStatus() {
        return fraudScoreProcStatus;
    }


    /**
     * Sets the fraudScoreProcStatus value for this InquiryResponseElement.
     * 
     * @param fraudScoreProcStatus
     */
    public void setFraudScoreProcStatus(java.lang.String fraudScoreProcStatus) {
        this.fraudScoreProcStatus = fraudScoreProcStatus;
    }


    /**
     * Gets the fraudScoreProcMsg value for this InquiryResponseElement.
     * 
     * @return fraudScoreProcMsg
     */
    public java.lang.String getFraudScoreProcMsg() {
        return fraudScoreProcMsg;
    }


    /**
     * Sets the fraudScoreProcMsg value for this InquiryResponseElement.
     * 
     * @param fraudScoreProcMsg
     */
    public void setFraudScoreProcMsg(java.lang.String fraudScoreProcMsg) {
        this.fraudScoreProcMsg = fraudScoreProcMsg;
    }


    /**
     * Gets the fraudAnalysisResponse value for this InquiryResponseElement.
     * 
     * @return fraudAnalysisResponse
     */
    public net.paymentech.ws.FraudAnalysisResponseType getFraudAnalysisResponse() {
        return fraudAnalysisResponse;
    }


    /**
     * Sets the fraudAnalysisResponse value for this InquiryResponseElement.
     * 
     * @param fraudAnalysisResponse
     */
    public void setFraudAnalysisResponse(net.paymentech.ws.FraudAnalysisResponseType fraudAnalysisResponse) {
        this.fraudAnalysisResponse = fraudAnalysisResponse;
    }


    /**
     * Gets the ctiAffluentCard value for this InquiryResponseElement.
     * 
     * @return ctiAffluentCard
     */
    public java.lang.String getCtiAffluentCard() {
        return ctiAffluentCard;
    }


    /**
     * Sets the ctiAffluentCard value for this InquiryResponseElement.
     * 
     * @param ctiAffluentCard
     */
    public void setCtiAffluentCard(java.lang.String ctiAffluentCard) {
        this.ctiAffluentCard = ctiAffluentCard;
    }


    /**
     * Gets the ctiCommercialCard value for this InquiryResponseElement.
     * 
     * @return ctiCommercialCard
     */
    public java.lang.String getCtiCommercialCard() {
        return ctiCommercialCard;
    }


    /**
     * Sets the ctiCommercialCard value for this InquiryResponseElement.
     * 
     * @param ctiCommercialCard
     */
    public void setCtiCommercialCard(java.lang.String ctiCommercialCard) {
        this.ctiCommercialCard = ctiCommercialCard;
    }


    /**
     * Gets the ctiDurbinExemption value for this InquiryResponseElement.
     * 
     * @return ctiDurbinExemption
     */
    public java.lang.String getCtiDurbinExemption() {
        return ctiDurbinExemption;
    }


    /**
     * Sets the ctiDurbinExemption value for this InquiryResponseElement.
     * 
     * @param ctiDurbinExemption
     */
    public void setCtiDurbinExemption(java.lang.String ctiDurbinExemption) {
        this.ctiDurbinExemption = ctiDurbinExemption;
    }


    /**
     * Gets the ctiHealthcareCard value for this InquiryResponseElement.
     * 
     * @return ctiHealthcareCard
     */
    public java.lang.String getCtiHealthcareCard() {
        return ctiHealthcareCard;
    }


    /**
     * Sets the ctiHealthcareCard value for this InquiryResponseElement.
     * 
     * @param ctiHealthcareCard
     */
    public void setCtiHealthcareCard(java.lang.String ctiHealthcareCard) {
        this.ctiHealthcareCard = ctiHealthcareCard;
    }


    /**
     * Gets the ctiLevel3Eligible value for this InquiryResponseElement.
     * 
     * @return ctiLevel3Eligible
     */
    public java.lang.String getCtiLevel3Eligible() {
        return ctiLevel3Eligible;
    }


    /**
     * Sets the ctiLevel3Eligible value for this InquiryResponseElement.
     * 
     * @param ctiLevel3Eligible
     */
    public void setCtiLevel3Eligible(java.lang.String ctiLevel3Eligible) {
        this.ctiLevel3Eligible = ctiLevel3Eligible;
    }


    /**
     * Gets the ctiPayrollCard value for this InquiryResponseElement.
     * 
     * @return ctiPayrollCard
     */
    public java.lang.String getCtiPayrollCard() {
        return ctiPayrollCard;
    }


    /**
     * Sets the ctiPayrollCard value for this InquiryResponseElement.
     * 
     * @param ctiPayrollCard
     */
    public void setCtiPayrollCard(java.lang.String ctiPayrollCard) {
        this.ctiPayrollCard = ctiPayrollCard;
    }


    /**
     * Gets the ctiPrepaidCard value for this InquiryResponseElement.
     * 
     * @return ctiPrepaidCard
     */
    public java.lang.String getCtiPrepaidCard() {
        return ctiPrepaidCard;
    }


    /**
     * Sets the ctiPrepaidCard value for this InquiryResponseElement.
     * 
     * @param ctiPrepaidCard
     */
    public void setCtiPrepaidCard(java.lang.String ctiPrepaidCard) {
        this.ctiPrepaidCard = ctiPrepaidCard;
    }


    /**
     * Gets the ctiPINlessDebitCard value for this InquiryResponseElement.
     * 
     * @return ctiPINlessDebitCard
     */
    public java.lang.String getCtiPINlessDebitCard() {
        return ctiPINlessDebitCard;
    }


    /**
     * Sets the ctiPINlessDebitCard value for this InquiryResponseElement.
     * 
     * @param ctiPINlessDebitCard
     */
    public void setCtiPINlessDebitCard(java.lang.String ctiPINlessDebitCard) {
        this.ctiPINlessDebitCard = ctiPINlessDebitCard;
    }


    /**
     * Gets the ctiSignatureDebitCard value for this InquiryResponseElement.
     * 
     * @return ctiSignatureDebitCard
     */
    public java.lang.String getCtiSignatureDebitCard() {
        return ctiSignatureDebitCard;
    }


    /**
     * Sets the ctiSignatureDebitCard value for this InquiryResponseElement.
     * 
     * @param ctiSignatureDebitCard
     */
    public void setCtiSignatureDebitCard(java.lang.String ctiSignatureDebitCard) {
        this.ctiSignatureDebitCard = ctiSignatureDebitCard;
    }


    /**
     * Gets the ctiIssuingCountry value for this InquiryResponseElement.
     * 
     * @return ctiIssuingCountry
     */
    public java.lang.String getCtiIssuingCountry() {
        return ctiIssuingCountry;
    }


    /**
     * Sets the ctiIssuingCountry value for this InquiryResponseElement.
     * 
     * @param ctiIssuingCountry
     */
    public void setCtiIssuingCountry(java.lang.String ctiIssuingCountry) {
        this.ctiIssuingCountry = ctiIssuingCountry;
    }


    /**
     * Gets the euddBankSortCode value for this InquiryResponseElement.
     * 
     * @return euddBankSortCode
     */
    public java.lang.String getEuddBankSortCode() {
        return euddBankSortCode;
    }


    /**
     * Sets the euddBankSortCode value for this InquiryResponseElement.
     * 
     * @param euddBankSortCode
     */
    public void setEuddBankSortCode(java.lang.String euddBankSortCode) {
        this.euddBankSortCode = euddBankSortCode;
    }


    /**
     * Gets the euddCountryCode value for this InquiryResponseElement.
     * 
     * @return euddCountryCode
     */
    public java.lang.String getEuddCountryCode() {
        return euddCountryCode;
    }


    /**
     * Sets the euddCountryCode value for this InquiryResponseElement.
     * 
     * @param euddCountryCode
     */
    public void setEuddCountryCode(java.lang.String euddCountryCode) {
        this.euddCountryCode = euddCountryCode;
    }


    /**
     * Gets the euddRibCode value for this InquiryResponseElement.
     * 
     * @return euddRibCode
     */
    public java.lang.String getEuddRibCode() {
        return euddRibCode;
    }


    /**
     * Sets the euddRibCode value for this InquiryResponseElement.
     * 
     * @param euddRibCode
     */
    public void setEuddRibCode(java.lang.String euddRibCode) {
        this.euddRibCode = euddRibCode;
    }


    /**
     * Gets the euddBankBranchCode value for this InquiryResponseElement.
     * 
     * @return euddBankBranchCode
     */
    public java.lang.String getEuddBankBranchCode() {
        return euddBankBranchCode;
    }


    /**
     * Sets the euddBankBranchCode value for this InquiryResponseElement.
     * 
     * @param euddBankBranchCode
     */
    public void setEuddBankBranchCode(java.lang.String euddBankBranchCode) {
        this.euddBankBranchCode = euddBankBranchCode;
    }


    /**
     * Gets the euddIBAN value for this InquiryResponseElement.
     * 
     * @return euddIBAN
     */
    public java.lang.String getEuddIBAN() {
        return euddIBAN;
    }


    /**
     * Sets the euddIBAN value for this InquiryResponseElement.
     * 
     * @param euddIBAN
     */
    public void setEuddIBAN(java.lang.String euddIBAN) {
        this.euddIBAN = euddIBAN;
    }


    /**
     * Gets the euddBIC value for this InquiryResponseElement.
     * 
     * @return euddBIC
     */
    public java.lang.String getEuddBIC() {
        return euddBIC;
    }


    /**
     * Sets the euddBIC value for this InquiryResponseElement.
     * 
     * @param euddBIC
     */
    public void setEuddBIC(java.lang.String euddBIC) {
        this.euddBIC = euddBIC;
    }


    /**
     * Gets the euddMandateSignatureDate value for this InquiryResponseElement.
     * 
     * @return euddMandateSignatureDate
     */
    public java.lang.String getEuddMandateSignatureDate() {
        return euddMandateSignatureDate;
    }


    /**
     * Sets the euddMandateSignatureDate value for this InquiryResponseElement.
     * 
     * @param euddMandateSignatureDate
     */
    public void setEuddMandateSignatureDate(java.lang.String euddMandateSignatureDate) {
        this.euddMandateSignatureDate = euddMandateSignatureDate;
    }


    /**
     * Gets the euddMandateID value for this InquiryResponseElement.
     * 
     * @return euddMandateID
     */
    public java.lang.String getEuddMandateID() {
        return euddMandateID;
    }


    /**
     * Sets the euddMandateID value for this InquiryResponseElement.
     * 
     * @param euddMandateID
     */
    public void setEuddMandateID(java.lang.String euddMandateID) {
        this.euddMandateID = euddMandateID;
    }


    /**
     * Gets the euddMandateType value for this InquiryResponseElement.
     * 
     * @return euddMandateType
     */
    public java.lang.String getEuddMandateType() {
        return euddMandateType;
    }


    /**
     * Sets the euddMandateType value for this InquiryResponseElement.
     * 
     * @param euddMandateType
     */
    public void setEuddMandateType(java.lang.String euddMandateType) {
        this.euddMandateType = euddMandateType;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof InquiryResponseElement)) return false;
        InquiryResponseElement other = (InquiryResponseElement) obj;
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
            ((this.industryType==null && other.getIndustryType()==null) || 
             (this.industryType!=null &&
              this.industryType.equals(other.getIndustryType()))) &&
            ((this.transType==null && other.getTransType()==null) || 
             (this.transType!=null &&
              this.transType.equals(other.getTransType()))) &&
            ((this.bin==null && other.getBin()==null) || 
             (this.bin!=null &&
              this.bin.equals(other.getBin()))) &&
            ((this.merchantID==null && other.getMerchantID()==null) || 
             (this.merchantID!=null &&
              this.merchantID.equals(other.getMerchantID()))) &&
            ((this.terminalID==null && other.getTerminalID()==null) || 
             (this.terminalID!=null &&
              this.terminalID.equals(other.getTerminalID()))) &&
            ((this.cardBrand==null && other.getCardBrand()==null) || 
             (this.cardBrand!=null &&
              this.cardBrand.equals(other.getCardBrand()))) &&
            ((this.orderID==null && other.getOrderID()==null) || 
             (this.orderID!=null &&
              this.orderID.equals(other.getOrderID()))) &&
            ((this.txRefNum==null && other.getTxRefNum()==null) || 
             (this.txRefNum!=null &&
              this.txRefNum.equals(other.getTxRefNum()))) &&
            ((this.txRefIdx==null && other.getTxRefIdx()==null) || 
             (this.txRefIdx!=null &&
              this.txRefIdx.equals(other.getTxRefIdx()))) &&
            ((this.respDateTime==null && other.getRespDateTime()==null) || 
             (this.respDateTime!=null &&
              this.respDateTime.equals(other.getRespDateTime()))) &&
            ((this.procStatus==null && other.getProcStatus()==null) || 
             (this.procStatus!=null &&
              this.procStatus.equals(other.getProcStatus()))) &&
            ((this.approvalStatus==null && other.getApprovalStatus()==null) || 
             (this.approvalStatus!=null &&
              this.approvalStatus.equals(other.getApprovalStatus()))) &&
            ((this.respCode==null && other.getRespCode()==null) || 
             (this.respCode!=null &&
              this.respCode.equals(other.getRespCode()))) &&
            ((this.avsRespCode==null && other.getAvsRespCode()==null) || 
             (this.avsRespCode!=null &&
              this.avsRespCode.equals(other.getAvsRespCode()))) &&
            ((this.cvvRespCode==null && other.getCvvRespCode()==null) || 
             (this.cvvRespCode!=null &&
              this.cvvRespCode.equals(other.getCvvRespCode()))) &&
            ((this.authorizationCode==null && other.getAuthorizationCode()==null) || 
             (this.authorizationCode!=null &&
              this.authorizationCode.equals(other.getAuthorizationCode()))) &&
            ((this.mcRecurringAdvCode==null && other.getMcRecurringAdvCode()==null) || 
             (this.mcRecurringAdvCode!=null &&
              this.mcRecurringAdvCode.equals(other.getMcRecurringAdvCode()))) &&
            ((this.visaVbVRespCode==null && other.getVisaVbVRespCode()==null) || 
             (this.visaVbVRespCode!=null &&
              this.visaVbVRespCode.equals(other.getVisaVbVRespCode()))) &&
            ((this.procStatusMessage==null && other.getProcStatusMessage()==null) || 
             (this.procStatusMessage!=null &&
              this.procStatusMessage.equals(other.getProcStatusMessage()))) &&
            ((this.respCodeMessage==null && other.getRespCodeMessage()==null) || 
             (this.respCodeMessage!=null &&
              this.respCodeMessage.equals(other.getRespCodeMessage()))) &&
            ((this.hostRespCode==null && other.getHostRespCode()==null) || 
             (this.hostRespCode!=null &&
              this.hostRespCode.equals(other.getHostRespCode()))) &&
            ((this.hostAVSRespCode==null && other.getHostAVSRespCode()==null) || 
             (this.hostAVSRespCode!=null &&
              this.hostAVSRespCode.equals(other.getHostAVSRespCode()))) &&
            ((this.hostCVVRespCode==null && other.getHostCVVRespCode()==null) || 
             (this.hostCVVRespCode!=null &&
              this.hostCVVRespCode.equals(other.getHostCVVRespCode()))) &&
            ((this.retryTrace==null && other.getRetryTrace()==null) || 
             (this.retryTrace!=null &&
              this.retryTrace.equals(other.getRetryTrace()))) &&
            ((this.retryAttempCount==null && other.getRetryAttempCount()==null) || 
             (this.retryAttempCount!=null &&
              this.retryAttempCount.equals(other.getRetryAttempCount()))) &&
            ((this.lastRetryDate==null && other.getLastRetryDate()==null) || 
             (this.lastRetryDate!=null &&
              this.lastRetryDate.equals(other.getLastRetryDate()))) &&
            ((this.customerRefNum==null && other.getCustomerRefNum()==null) || 
             (this.customerRefNum!=null &&
              this.customerRefNum.equals(other.getCustomerRefNum()))) &&
            ((this.customerName==null && other.getCustomerName()==null) || 
             (this.customerName!=null &&
              this.customerName.equals(other.getCustomerName()))) &&
            ((this.profileProcStatus==null && other.getProfileProcStatus()==null) || 
             (this.profileProcStatus!=null &&
              this.profileProcStatus.equals(other.getProfileProcStatus()))) &&
            ((this.profileProcStatusMsg==null && other.getProfileProcStatusMsg()==null) || 
             (this.profileProcStatusMsg!=null &&
              this.profileProcStatusMsg.equals(other.getProfileProcStatusMsg()))) &&
            ((this.giftCardInd==null && other.getGiftCardInd()==null) || 
             (this.giftCardInd!=null &&
              this.giftCardInd.equals(other.getGiftCardInd()))) &&
            ((this.remainingBalance==null && other.getRemainingBalance()==null) || 
             (this.remainingBalance!=null &&
              this.remainingBalance.equals(other.getRemainingBalance()))) &&
            ((this.requestAmount==null && other.getRequestAmount()==null) || 
             (this.requestAmount!=null &&
              this.requestAmount.equals(other.getRequestAmount()))) &&
            ((this.redeemedAmount==null && other.getRedeemedAmount()==null) || 
             (this.redeemedAmount!=null &&
              this.redeemedAmount.equals(other.getRedeemedAmount()))) &&
            ((this.ccAccountNum==null && other.getCcAccountNum()==null) || 
             (this.ccAccountNum!=null &&
              this.ccAccountNum.equals(other.getCcAccountNum()))) &&
            ((this.debitBillerReferenceNumber==null && other.getDebitBillerReferenceNumber()==null) || 
             (this.debitBillerReferenceNumber!=null &&
              this.debitBillerReferenceNumber.equals(other.getDebitBillerReferenceNumber()))) &&
            ((this.mbMicroPaymentDaysLeft==null && other.getMbMicroPaymentDaysLeft()==null) || 
             (this.mbMicroPaymentDaysLeft!=null &&
              this.mbMicroPaymentDaysLeft.equals(other.getMbMicroPaymentDaysLeft()))) &&
            ((this.mbMicroPaymentDollarsLeft==null && other.getMbMicroPaymentDollarsLeft()==null) || 
             (this.mbMicroPaymentDollarsLeft!=null &&
              this.mbMicroPaymentDollarsLeft.equals(other.getMbMicroPaymentDollarsLeft()))) &&
            ((this.mbStatus==null && other.getMbStatus()==null) || 
             (this.mbStatus!=null &&
              this.mbStatus.equals(other.getMbStatus()))) &&
            ((this.debitPinSurchargeAmount==null && other.getDebitPinSurchargeAmount()==null) || 
             (this.debitPinSurchargeAmount!=null &&
              this.debitPinSurchargeAmount.equals(other.getDebitPinSurchargeAmount()))) &&
            ((this.debitPinTraceNumber==null && other.getDebitPinTraceNumber()==null) || 
             (this.debitPinTraceNumber!=null &&
              this.debitPinTraceNumber.equals(other.getDebitPinTraceNumber()))) &&
            ((this.debitPinNetworkID==null && other.getDebitPinNetworkID()==null) || 
             (this.debitPinNetworkID!=null &&
              this.debitPinNetworkID.equals(other.getDebitPinNetworkID()))) &&
            ((this.partialAuthOccurred==null && other.getPartialAuthOccurred()==null) || 
             (this.partialAuthOccurred!=null &&
              this.partialAuthOccurred.equals(other.getPartialAuthOccurred()))) &&
            ((this.countryFraudFilterStatus==null && other.getCountryFraudFilterStatus()==null) || 
             (this.countryFraudFilterStatus!=null &&
              this.countryFraudFilterStatus.equals(other.getCountryFraudFilterStatus()))) &&
            ((this.isoCountryCode==null && other.getIsoCountryCode()==null) || 
             (this.isoCountryCode!=null &&
              this.isoCountryCode.equals(other.getIsoCountryCode()))) &&
            ((this.fraudScoreProcStatus==null && other.getFraudScoreProcStatus()==null) || 
             (this.fraudScoreProcStatus!=null &&
              this.fraudScoreProcStatus.equals(other.getFraudScoreProcStatus()))) &&
            ((this.fraudScoreProcMsg==null && other.getFraudScoreProcMsg()==null) || 
             (this.fraudScoreProcMsg!=null &&
              this.fraudScoreProcMsg.equals(other.getFraudScoreProcMsg()))) &&
            ((this.fraudAnalysisResponse==null && other.getFraudAnalysisResponse()==null) || 
             (this.fraudAnalysisResponse!=null &&
              this.fraudAnalysisResponse.equals(other.getFraudAnalysisResponse()))) &&
            ((this.ctiAffluentCard==null && other.getCtiAffluentCard()==null) || 
             (this.ctiAffluentCard!=null &&
              this.ctiAffluentCard.equals(other.getCtiAffluentCard()))) &&
            ((this.ctiCommercialCard==null && other.getCtiCommercialCard()==null) || 
             (this.ctiCommercialCard!=null &&
              this.ctiCommercialCard.equals(other.getCtiCommercialCard()))) &&
            ((this.ctiDurbinExemption==null && other.getCtiDurbinExemption()==null) || 
             (this.ctiDurbinExemption!=null &&
              this.ctiDurbinExemption.equals(other.getCtiDurbinExemption()))) &&
            ((this.ctiHealthcareCard==null && other.getCtiHealthcareCard()==null) || 
             (this.ctiHealthcareCard!=null &&
              this.ctiHealthcareCard.equals(other.getCtiHealthcareCard()))) &&
            ((this.ctiLevel3Eligible==null && other.getCtiLevel3Eligible()==null) || 
             (this.ctiLevel3Eligible!=null &&
              this.ctiLevel3Eligible.equals(other.getCtiLevel3Eligible()))) &&
            ((this.ctiPayrollCard==null && other.getCtiPayrollCard()==null) || 
             (this.ctiPayrollCard!=null &&
              this.ctiPayrollCard.equals(other.getCtiPayrollCard()))) &&
            ((this.ctiPrepaidCard==null && other.getCtiPrepaidCard()==null) || 
             (this.ctiPrepaidCard!=null &&
              this.ctiPrepaidCard.equals(other.getCtiPrepaidCard()))) &&
            ((this.ctiPINlessDebitCard==null && other.getCtiPINlessDebitCard()==null) || 
             (this.ctiPINlessDebitCard!=null &&
              this.ctiPINlessDebitCard.equals(other.getCtiPINlessDebitCard()))) &&
            ((this.ctiSignatureDebitCard==null && other.getCtiSignatureDebitCard()==null) || 
             (this.ctiSignatureDebitCard!=null &&
              this.ctiSignatureDebitCard.equals(other.getCtiSignatureDebitCard()))) &&
            ((this.ctiIssuingCountry==null && other.getCtiIssuingCountry()==null) || 
             (this.ctiIssuingCountry!=null &&
              this.ctiIssuingCountry.equals(other.getCtiIssuingCountry()))) &&
            ((this.euddBankSortCode==null && other.getEuddBankSortCode()==null) || 
             (this.euddBankSortCode!=null &&
              this.euddBankSortCode.equals(other.getEuddBankSortCode()))) &&
            ((this.euddCountryCode==null && other.getEuddCountryCode()==null) || 
             (this.euddCountryCode!=null &&
              this.euddCountryCode.equals(other.getEuddCountryCode()))) &&
            ((this.euddRibCode==null && other.getEuddRibCode()==null) || 
             (this.euddRibCode!=null &&
              this.euddRibCode.equals(other.getEuddRibCode()))) &&
            ((this.euddBankBranchCode==null && other.getEuddBankBranchCode()==null) || 
             (this.euddBankBranchCode!=null &&
              this.euddBankBranchCode.equals(other.getEuddBankBranchCode()))) &&
            ((this.euddIBAN==null && other.getEuddIBAN()==null) || 
             (this.euddIBAN!=null &&
              this.euddIBAN.equals(other.getEuddIBAN()))) &&
            ((this.euddBIC==null && other.getEuddBIC()==null) || 
             (this.euddBIC!=null &&
              this.euddBIC.equals(other.getEuddBIC()))) &&
            ((this.euddMandateSignatureDate==null && other.getEuddMandateSignatureDate()==null) || 
             (this.euddMandateSignatureDate!=null &&
              this.euddMandateSignatureDate.equals(other.getEuddMandateSignatureDate()))) &&
            ((this.euddMandateID==null && other.getEuddMandateID()==null) || 
             (this.euddMandateID!=null &&
              this.euddMandateID.equals(other.getEuddMandateID()))) &&
            ((this.euddMandateType==null && other.getEuddMandateType()==null) || 
             (this.euddMandateType!=null &&
              this.euddMandateType.equals(other.getEuddMandateType())));
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
        if (getIndustryType() != null) {
            _hashCode += getIndustryType().hashCode();
        }
        if (getTransType() != null) {
            _hashCode += getTransType().hashCode();
        }
        if (getBin() != null) {
            _hashCode += getBin().hashCode();
        }
        if (getMerchantID() != null) {
            _hashCode += getMerchantID().hashCode();
        }
        if (getTerminalID() != null) {
            _hashCode += getTerminalID().hashCode();
        }
        if (getCardBrand() != null) {
            _hashCode += getCardBrand().hashCode();
        }
        if (getOrderID() != null) {
            _hashCode += getOrderID().hashCode();
        }
        if (getTxRefNum() != null) {
            _hashCode += getTxRefNum().hashCode();
        }
        if (getTxRefIdx() != null) {
            _hashCode += getTxRefIdx().hashCode();
        }
        if (getRespDateTime() != null) {
            _hashCode += getRespDateTime().hashCode();
        }
        if (getProcStatus() != null) {
            _hashCode += getProcStatus().hashCode();
        }
        if (getApprovalStatus() != null) {
            _hashCode += getApprovalStatus().hashCode();
        }
        if (getRespCode() != null) {
            _hashCode += getRespCode().hashCode();
        }
        if (getAvsRespCode() != null) {
            _hashCode += getAvsRespCode().hashCode();
        }
        if (getCvvRespCode() != null) {
            _hashCode += getCvvRespCode().hashCode();
        }
        if (getAuthorizationCode() != null) {
            _hashCode += getAuthorizationCode().hashCode();
        }
        if (getMcRecurringAdvCode() != null) {
            _hashCode += getMcRecurringAdvCode().hashCode();
        }
        if (getVisaVbVRespCode() != null) {
            _hashCode += getVisaVbVRespCode().hashCode();
        }
        if (getProcStatusMessage() != null) {
            _hashCode += getProcStatusMessage().hashCode();
        }
        if (getRespCodeMessage() != null) {
            _hashCode += getRespCodeMessage().hashCode();
        }
        if (getHostRespCode() != null) {
            _hashCode += getHostRespCode().hashCode();
        }
        if (getHostAVSRespCode() != null) {
            _hashCode += getHostAVSRespCode().hashCode();
        }
        if (getHostCVVRespCode() != null) {
            _hashCode += getHostCVVRespCode().hashCode();
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
        if (getCustomerRefNum() != null) {
            _hashCode += getCustomerRefNum().hashCode();
        }
        if (getCustomerName() != null) {
            _hashCode += getCustomerName().hashCode();
        }
        if (getProfileProcStatus() != null) {
            _hashCode += getProfileProcStatus().hashCode();
        }
        if (getProfileProcStatusMsg() != null) {
            _hashCode += getProfileProcStatusMsg().hashCode();
        }
        if (getGiftCardInd() != null) {
            _hashCode += getGiftCardInd().hashCode();
        }
        if (getRemainingBalance() != null) {
            _hashCode += getRemainingBalance().hashCode();
        }
        if (getRequestAmount() != null) {
            _hashCode += getRequestAmount().hashCode();
        }
        if (getRedeemedAmount() != null) {
            _hashCode += getRedeemedAmount().hashCode();
        }
        if (getCcAccountNum() != null) {
            _hashCode += getCcAccountNum().hashCode();
        }
        if (getDebitBillerReferenceNumber() != null) {
            _hashCode += getDebitBillerReferenceNumber().hashCode();
        }
        if (getMbMicroPaymentDaysLeft() != null) {
            _hashCode += getMbMicroPaymentDaysLeft().hashCode();
        }
        if (getMbMicroPaymentDollarsLeft() != null) {
            _hashCode += getMbMicroPaymentDollarsLeft().hashCode();
        }
        if (getMbStatus() != null) {
            _hashCode += getMbStatus().hashCode();
        }
        if (getDebitPinSurchargeAmount() != null) {
            _hashCode += getDebitPinSurchargeAmount().hashCode();
        }
        if (getDebitPinTraceNumber() != null) {
            _hashCode += getDebitPinTraceNumber().hashCode();
        }
        if (getDebitPinNetworkID() != null) {
            _hashCode += getDebitPinNetworkID().hashCode();
        }
        if (getPartialAuthOccurred() != null) {
            _hashCode += getPartialAuthOccurred().hashCode();
        }
        if (getCountryFraudFilterStatus() != null) {
            _hashCode += getCountryFraudFilterStatus().hashCode();
        }
        if (getIsoCountryCode() != null) {
            _hashCode += getIsoCountryCode().hashCode();
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
        if (getCtiAffluentCard() != null) {
            _hashCode += getCtiAffluentCard().hashCode();
        }
        if (getCtiCommercialCard() != null) {
            _hashCode += getCtiCommercialCard().hashCode();
        }
        if (getCtiDurbinExemption() != null) {
            _hashCode += getCtiDurbinExemption().hashCode();
        }
        if (getCtiHealthcareCard() != null) {
            _hashCode += getCtiHealthcareCard().hashCode();
        }
        if (getCtiLevel3Eligible() != null) {
            _hashCode += getCtiLevel3Eligible().hashCode();
        }
        if (getCtiPayrollCard() != null) {
            _hashCode += getCtiPayrollCard().hashCode();
        }
        if (getCtiPrepaidCard() != null) {
            _hashCode += getCtiPrepaidCard().hashCode();
        }
        if (getCtiPINlessDebitCard() != null) {
            _hashCode += getCtiPINlessDebitCard().hashCode();
        }
        if (getCtiSignatureDebitCard() != null) {
            _hashCode += getCtiSignatureDebitCard().hashCode();
        }
        if (getCtiIssuingCountry() != null) {
            _hashCode += getCtiIssuingCountry().hashCode();
        }
        if (getEuddBankSortCode() != null) {
            _hashCode += getEuddBankSortCode().hashCode();
        }
        if (getEuddCountryCode() != null) {
            _hashCode += getEuddCountryCode().hashCode();
        }
        if (getEuddRibCode() != null) {
            _hashCode += getEuddRibCode().hashCode();
        }
        if (getEuddBankBranchCode() != null) {
            _hashCode += getEuddBankBranchCode().hashCode();
        }
        if (getEuddIBAN() != null) {
            _hashCode += getEuddIBAN().hashCode();
        }
        if (getEuddBIC() != null) {
            _hashCode += getEuddBIC().hashCode();
        }
        if (getEuddMandateSignatureDate() != null) {
            _hashCode += getEuddMandateSignatureDate().hashCode();
        }
        if (getEuddMandateID() != null) {
            _hashCode += getEuddMandateID().hashCode();
        }
        if (getEuddMandateType() != null) {
            _hashCode += getEuddMandateType().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(InquiryResponseElement.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "InquiryResponseElement"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("version");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "version"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("industryType");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "industryType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("transType");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "transType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bin");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "bin"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
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
        elemField.setFieldName("cardBrand");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "cardBrand"));
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
        elemField.setFieldName("txRefNum");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "txRefNum"));
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
        elemField.setFieldName("respDateTime");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "respDateTime"));
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
        elemField.setFieldName("approvalStatus");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "approvalStatus"));
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
        elemField.setFieldName("avsRespCode");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "avsRespCode"));
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
        elemField.setFieldName("authorizationCode");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "authorizationCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mcRecurringAdvCode");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "mcRecurringAdvCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("visaVbVRespCode");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "visaVbVRespCode"));
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
        elemField.setFieldName("respCodeMessage");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "respCodeMessage"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("hostRespCode");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "hostRespCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("hostAVSRespCode");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "hostAVSRespCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("hostCVVRespCode");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "hostCVVRespCode"));
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
        elemField.setFieldName("customerRefNum");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "customerRefNum"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("customerName");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "customerName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("profileProcStatus");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "profileProcStatus"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("profileProcStatusMsg");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "profileProcStatusMsg"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("giftCardInd");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "giftCardInd"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("remainingBalance");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "remainingBalance"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("requestAmount");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "requestAmount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("redeemedAmount");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "redeemedAmount"));
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
        elemField.setFieldName("debitBillerReferenceNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "debitBillerReferenceNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mbMicroPaymentDaysLeft");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "mbMicroPaymentDaysLeft"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mbMicroPaymentDollarsLeft");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "mbMicroPaymentDollarsLeft"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mbStatus");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "mbStatus"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("debitPinSurchargeAmount");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "debitPinSurchargeAmount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("debitPinTraceNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "debitPinTraceNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("debitPinNetworkID");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "debitPinNetworkID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("partialAuthOccurred");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "partialAuthOccurred"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("countryFraudFilterStatus");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "countryFraudFilterStatus"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isoCountryCode");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "isoCountryCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
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
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ctiAffluentCard");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "ctiAffluentCard"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ctiCommercialCard");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "ctiCommercialCard"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ctiDurbinExemption");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "ctiDurbinExemption"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ctiHealthcareCard");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "ctiHealthcareCard"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ctiLevel3Eligible");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "ctiLevel3Eligible"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ctiPayrollCard");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "ctiPayrollCard"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ctiPrepaidCard");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "ctiPrepaidCard"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ctiPINlessDebitCard");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "ctiPINlessDebitCard"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ctiSignatureDebitCard");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "ctiSignatureDebitCard"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ctiIssuingCountry");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "ctiIssuingCountry"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("euddBankSortCode");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "euddBankSortCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("euddCountryCode");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "euddCountryCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("euddRibCode");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "euddRibCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("euddBankBranchCode");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "euddBankBranchCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("euddIBAN");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "euddIBAN"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("euddBIC");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "euddBIC"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("euddMandateSignatureDate");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "euddMandateSignatureDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("euddMandateID");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "euddMandateID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("euddMandateType");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "euddMandateType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
