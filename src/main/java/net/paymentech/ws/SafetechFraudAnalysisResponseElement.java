/**
 * SafetechFraudAnalysisResponseElement.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package net.paymentech.ws;

public class SafetechFraudAnalysisResponseElement  implements java.io.Serializable {
    private java.lang.String version;

    private java.lang.String industryType;

    private java.lang.String bin;

    private java.lang.String merchantID;

    private java.lang.String terminalID;

    private java.lang.String cardBrand;

    private java.lang.String ccAccountNum;

    private java.lang.String orderID;

    private java.lang.String txRefNum;

    private java.lang.String respDateTime;

    private java.lang.String euddBankSortCode;

    private java.lang.String euddCountryCode;

    private java.lang.String euddRibCode;

    private java.lang.String euddBankBranchCode;

    private java.lang.String euddIBAN;

    private java.lang.String euddBIC;

    private java.lang.String procStatus;

    private java.lang.String approvalStatus;

    private java.lang.String respCode;

    private java.lang.String procStatusMessage;

    private java.lang.String respCodeMessage;

    private java.lang.String hostRespCode;

    private java.lang.String retryTrace;

    private java.lang.String retryAttempCount;

    private java.lang.String lastRetryDate;

    private java.lang.String customerRefNum;

    private java.lang.String customerName;

    private java.lang.String profileProcStatus;

    private java.lang.String profileProcStatusMsg;

    private net.paymentech.ws.FraudAnalysisResponseType fraudAnalysisResponse;

    public SafetechFraudAnalysisResponseElement() {
    }

    public SafetechFraudAnalysisResponseElement(
           java.lang.String version,
           java.lang.String industryType,
           java.lang.String bin,
           java.lang.String merchantID,
           java.lang.String terminalID,
           java.lang.String cardBrand,
           java.lang.String ccAccountNum,
           java.lang.String orderID,
           java.lang.String txRefNum,
           java.lang.String respDateTime,
           java.lang.String euddBankSortCode,
           java.lang.String euddCountryCode,
           java.lang.String euddRibCode,
           java.lang.String euddBankBranchCode,
           java.lang.String euddIBAN,
           java.lang.String euddBIC,
           java.lang.String procStatus,
           java.lang.String approvalStatus,
           java.lang.String respCode,
           java.lang.String procStatusMessage,
           java.lang.String respCodeMessage,
           java.lang.String hostRespCode,
           java.lang.String retryTrace,
           java.lang.String retryAttempCount,
           java.lang.String lastRetryDate,
           java.lang.String customerRefNum,
           java.lang.String customerName,
           java.lang.String profileProcStatus,
           java.lang.String profileProcStatusMsg,
           net.paymentech.ws.FraudAnalysisResponseType fraudAnalysisResponse) {
           this.version = version;
           this.industryType = industryType;
           this.bin = bin;
           this.merchantID = merchantID;
           this.terminalID = terminalID;
           this.cardBrand = cardBrand;
           this.ccAccountNum = ccAccountNum;
           this.orderID = orderID;
           this.txRefNum = txRefNum;
           this.respDateTime = respDateTime;
           this.euddBankSortCode = euddBankSortCode;
           this.euddCountryCode = euddCountryCode;
           this.euddRibCode = euddRibCode;
           this.euddBankBranchCode = euddBankBranchCode;
           this.euddIBAN = euddIBAN;
           this.euddBIC = euddBIC;
           this.procStatus = procStatus;
           this.approvalStatus = approvalStatus;
           this.respCode = respCode;
           this.procStatusMessage = procStatusMessage;
           this.respCodeMessage = respCodeMessage;
           this.hostRespCode = hostRespCode;
           this.retryTrace = retryTrace;
           this.retryAttempCount = retryAttempCount;
           this.lastRetryDate = lastRetryDate;
           this.customerRefNum = customerRefNum;
           this.customerName = customerName;
           this.profileProcStatus = profileProcStatus;
           this.profileProcStatusMsg = profileProcStatusMsg;
           this.fraudAnalysisResponse = fraudAnalysisResponse;
    }


    /**
     * Gets the version value for this SafetechFraudAnalysisResponseElement.
     * 
     * @return version
     */
    public java.lang.String getVersion() {
        return version;
    }


    /**
     * Sets the version value for this SafetechFraudAnalysisResponseElement.
     * 
     * @param version
     */
    public void setVersion(java.lang.String version) {
        this.version = version;
    }


    /**
     * Gets the industryType value for this SafetechFraudAnalysisResponseElement.
     * 
     * @return industryType
     */
    public java.lang.String getIndustryType() {
        return industryType;
    }


    /**
     * Sets the industryType value for this SafetechFraudAnalysisResponseElement.
     * 
     * @param industryType
     */
    public void setIndustryType(java.lang.String industryType) {
        this.industryType = industryType;
    }


    /**
     * Gets the bin value for this SafetechFraudAnalysisResponseElement.
     * 
     * @return bin
     */
    public java.lang.String getBin() {
        return bin;
    }


    /**
     * Sets the bin value for this SafetechFraudAnalysisResponseElement.
     * 
     * @param bin
     */
    public void setBin(java.lang.String bin) {
        this.bin = bin;
    }


    /**
     * Gets the merchantID value for this SafetechFraudAnalysisResponseElement.
     * 
     * @return merchantID
     */
    public java.lang.String getMerchantID() {
        return merchantID;
    }


    /**
     * Sets the merchantID value for this SafetechFraudAnalysisResponseElement.
     * 
     * @param merchantID
     */
    public void setMerchantID(java.lang.String merchantID) {
        this.merchantID = merchantID;
    }


    /**
     * Gets the terminalID value for this SafetechFraudAnalysisResponseElement.
     * 
     * @return terminalID
     */
    public java.lang.String getTerminalID() {
        return terminalID;
    }


    /**
     * Sets the terminalID value for this SafetechFraudAnalysisResponseElement.
     * 
     * @param terminalID
     */
    public void setTerminalID(java.lang.String terminalID) {
        this.terminalID = terminalID;
    }


    /**
     * Gets the cardBrand value for this SafetechFraudAnalysisResponseElement.
     * 
     * @return cardBrand
     */
    public java.lang.String getCardBrand() {
        return cardBrand;
    }


    /**
     * Sets the cardBrand value for this SafetechFraudAnalysisResponseElement.
     * 
     * @param cardBrand
     */
    public void setCardBrand(java.lang.String cardBrand) {
        this.cardBrand = cardBrand;
    }


    /**
     * Gets the ccAccountNum value for this SafetechFraudAnalysisResponseElement.
     * 
     * @return ccAccountNum
     */
    public java.lang.String getCcAccountNum() {
        return ccAccountNum;
    }


    /**
     * Sets the ccAccountNum value for this SafetechFraudAnalysisResponseElement.
     * 
     * @param ccAccountNum
     */
    public void setCcAccountNum(java.lang.String ccAccountNum) {
        this.ccAccountNum = ccAccountNum;
    }


    /**
     * Gets the orderID value for this SafetechFraudAnalysisResponseElement.
     * 
     * @return orderID
     */
    public java.lang.String getOrderID() {
        return orderID;
    }


    /**
     * Sets the orderID value for this SafetechFraudAnalysisResponseElement.
     * 
     * @param orderID
     */
    public void setOrderID(java.lang.String orderID) {
        this.orderID = orderID;
    }


    /**
     * Gets the txRefNum value for this SafetechFraudAnalysisResponseElement.
     * 
     * @return txRefNum
     */
    public java.lang.String getTxRefNum() {
        return txRefNum;
    }


    /**
     * Sets the txRefNum value for this SafetechFraudAnalysisResponseElement.
     * 
     * @param txRefNum
     */
    public void setTxRefNum(java.lang.String txRefNum) {
        this.txRefNum = txRefNum;
    }


    /**
     * Gets the respDateTime value for this SafetechFraudAnalysisResponseElement.
     * 
     * @return respDateTime
     */
    public java.lang.String getRespDateTime() {
        return respDateTime;
    }


    /**
     * Sets the respDateTime value for this SafetechFraudAnalysisResponseElement.
     * 
     * @param respDateTime
     */
    public void setRespDateTime(java.lang.String respDateTime) {
        this.respDateTime = respDateTime;
    }


    /**
     * Gets the euddBankSortCode value for this SafetechFraudAnalysisResponseElement.
     * 
     * @return euddBankSortCode
     */
    public java.lang.String getEuddBankSortCode() {
        return euddBankSortCode;
    }


    /**
     * Sets the euddBankSortCode value for this SafetechFraudAnalysisResponseElement.
     * 
     * @param euddBankSortCode
     */
    public void setEuddBankSortCode(java.lang.String euddBankSortCode) {
        this.euddBankSortCode = euddBankSortCode;
    }


    /**
     * Gets the euddCountryCode value for this SafetechFraudAnalysisResponseElement.
     * 
     * @return euddCountryCode
     */
    public java.lang.String getEuddCountryCode() {
        return euddCountryCode;
    }


    /**
     * Sets the euddCountryCode value for this SafetechFraudAnalysisResponseElement.
     * 
     * @param euddCountryCode
     */
    public void setEuddCountryCode(java.lang.String euddCountryCode) {
        this.euddCountryCode = euddCountryCode;
    }


    /**
     * Gets the euddRibCode value for this SafetechFraudAnalysisResponseElement.
     * 
     * @return euddRibCode
     */
    public java.lang.String getEuddRibCode() {
        return euddRibCode;
    }


    /**
     * Sets the euddRibCode value for this SafetechFraudAnalysisResponseElement.
     * 
     * @param euddRibCode
     */
    public void setEuddRibCode(java.lang.String euddRibCode) {
        this.euddRibCode = euddRibCode;
    }


    /**
     * Gets the euddBankBranchCode value for this SafetechFraudAnalysisResponseElement.
     * 
     * @return euddBankBranchCode
     */
    public java.lang.String getEuddBankBranchCode() {
        return euddBankBranchCode;
    }


    /**
     * Sets the euddBankBranchCode value for this SafetechFraudAnalysisResponseElement.
     * 
     * @param euddBankBranchCode
     */
    public void setEuddBankBranchCode(java.lang.String euddBankBranchCode) {
        this.euddBankBranchCode = euddBankBranchCode;
    }


    /**
     * Gets the euddIBAN value for this SafetechFraudAnalysisResponseElement.
     * 
     * @return euddIBAN
     */
    public java.lang.String getEuddIBAN() {
        return euddIBAN;
    }


    /**
     * Sets the euddIBAN value for this SafetechFraudAnalysisResponseElement.
     * 
     * @param euddIBAN
     */
    public void setEuddIBAN(java.lang.String euddIBAN) {
        this.euddIBAN = euddIBAN;
    }


    /**
     * Gets the euddBIC value for this SafetechFraudAnalysisResponseElement.
     * 
     * @return euddBIC
     */
    public java.lang.String getEuddBIC() {
        return euddBIC;
    }


    /**
     * Sets the euddBIC value for this SafetechFraudAnalysisResponseElement.
     * 
     * @param euddBIC
     */
    public void setEuddBIC(java.lang.String euddBIC) {
        this.euddBIC = euddBIC;
    }


    /**
     * Gets the procStatus value for this SafetechFraudAnalysisResponseElement.
     * 
     * @return procStatus
     */
    public java.lang.String getProcStatus() {
        return procStatus;
    }


    /**
     * Sets the procStatus value for this SafetechFraudAnalysisResponseElement.
     * 
     * @param procStatus
     */
    public void setProcStatus(java.lang.String procStatus) {
        this.procStatus = procStatus;
    }


    /**
     * Gets the approvalStatus value for this SafetechFraudAnalysisResponseElement.
     * 
     * @return approvalStatus
     */
    public java.lang.String getApprovalStatus() {
        return approvalStatus;
    }


    /**
     * Sets the approvalStatus value for this SafetechFraudAnalysisResponseElement.
     * 
     * @param approvalStatus
     */
    public void setApprovalStatus(java.lang.String approvalStatus) {
        this.approvalStatus = approvalStatus;
    }


    /**
     * Gets the respCode value for this SafetechFraudAnalysisResponseElement.
     * 
     * @return respCode
     */
    public java.lang.String getRespCode() {
        return respCode;
    }


    /**
     * Sets the respCode value for this SafetechFraudAnalysisResponseElement.
     * 
     * @param respCode
     */
    public void setRespCode(java.lang.String respCode) {
        this.respCode = respCode;
    }


    /**
     * Gets the procStatusMessage value for this SafetechFraudAnalysisResponseElement.
     * 
     * @return procStatusMessage
     */
    public java.lang.String getProcStatusMessage() {
        return procStatusMessage;
    }


    /**
     * Sets the procStatusMessage value for this SafetechFraudAnalysisResponseElement.
     * 
     * @param procStatusMessage
     */
    public void setProcStatusMessage(java.lang.String procStatusMessage) {
        this.procStatusMessage = procStatusMessage;
    }


    /**
     * Gets the respCodeMessage value for this SafetechFraudAnalysisResponseElement.
     * 
     * @return respCodeMessage
     */
    public java.lang.String getRespCodeMessage() {
        return respCodeMessage;
    }


    /**
     * Sets the respCodeMessage value for this SafetechFraudAnalysisResponseElement.
     * 
     * @param respCodeMessage
     */
    public void setRespCodeMessage(java.lang.String respCodeMessage) {
        this.respCodeMessage = respCodeMessage;
    }


    /**
     * Gets the hostRespCode value for this SafetechFraudAnalysisResponseElement.
     * 
     * @return hostRespCode
     */
    public java.lang.String getHostRespCode() {
        return hostRespCode;
    }


    /**
     * Sets the hostRespCode value for this SafetechFraudAnalysisResponseElement.
     * 
     * @param hostRespCode
     */
    public void setHostRespCode(java.lang.String hostRespCode) {
        this.hostRespCode = hostRespCode;
    }


    /**
     * Gets the retryTrace value for this SafetechFraudAnalysisResponseElement.
     * 
     * @return retryTrace
     */
    public java.lang.String getRetryTrace() {
        return retryTrace;
    }


    /**
     * Sets the retryTrace value for this SafetechFraudAnalysisResponseElement.
     * 
     * @param retryTrace
     */
    public void setRetryTrace(java.lang.String retryTrace) {
        this.retryTrace = retryTrace;
    }


    /**
     * Gets the retryAttempCount value for this SafetechFraudAnalysisResponseElement.
     * 
     * @return retryAttempCount
     */
    public java.lang.String getRetryAttempCount() {
        return retryAttempCount;
    }


    /**
     * Sets the retryAttempCount value for this SafetechFraudAnalysisResponseElement.
     * 
     * @param retryAttempCount
     */
    public void setRetryAttempCount(java.lang.String retryAttempCount) {
        this.retryAttempCount = retryAttempCount;
    }


    /**
     * Gets the lastRetryDate value for this SafetechFraudAnalysisResponseElement.
     * 
     * @return lastRetryDate
     */
    public java.lang.String getLastRetryDate() {
        return lastRetryDate;
    }


    /**
     * Sets the lastRetryDate value for this SafetechFraudAnalysisResponseElement.
     * 
     * @param lastRetryDate
     */
    public void setLastRetryDate(java.lang.String lastRetryDate) {
        this.lastRetryDate = lastRetryDate;
    }


    /**
     * Gets the customerRefNum value for this SafetechFraudAnalysisResponseElement.
     * 
     * @return customerRefNum
     */
    public java.lang.String getCustomerRefNum() {
        return customerRefNum;
    }


    /**
     * Sets the customerRefNum value for this SafetechFraudAnalysisResponseElement.
     * 
     * @param customerRefNum
     */
    public void setCustomerRefNum(java.lang.String customerRefNum) {
        this.customerRefNum = customerRefNum;
    }


    /**
     * Gets the customerName value for this SafetechFraudAnalysisResponseElement.
     * 
     * @return customerName
     */
    public java.lang.String getCustomerName() {
        return customerName;
    }


    /**
     * Sets the customerName value for this SafetechFraudAnalysisResponseElement.
     * 
     * @param customerName
     */
    public void setCustomerName(java.lang.String customerName) {
        this.customerName = customerName;
    }


    /**
     * Gets the profileProcStatus value for this SafetechFraudAnalysisResponseElement.
     * 
     * @return profileProcStatus
     */
    public java.lang.String getProfileProcStatus() {
        return profileProcStatus;
    }


    /**
     * Sets the profileProcStatus value for this SafetechFraudAnalysisResponseElement.
     * 
     * @param profileProcStatus
     */
    public void setProfileProcStatus(java.lang.String profileProcStatus) {
        this.profileProcStatus = profileProcStatus;
    }


    /**
     * Gets the profileProcStatusMsg value for this SafetechFraudAnalysisResponseElement.
     * 
     * @return profileProcStatusMsg
     */
    public java.lang.String getProfileProcStatusMsg() {
        return profileProcStatusMsg;
    }


    /**
     * Sets the profileProcStatusMsg value for this SafetechFraudAnalysisResponseElement.
     * 
     * @param profileProcStatusMsg
     */
    public void setProfileProcStatusMsg(java.lang.String profileProcStatusMsg) {
        this.profileProcStatusMsg = profileProcStatusMsg;
    }


    /**
     * Gets the fraudAnalysisResponse value for this SafetechFraudAnalysisResponseElement.
     * 
     * @return fraudAnalysisResponse
     */
    public net.paymentech.ws.FraudAnalysisResponseType getFraudAnalysisResponse() {
        return fraudAnalysisResponse;
    }


    /**
     * Sets the fraudAnalysisResponse value for this SafetechFraudAnalysisResponseElement.
     * 
     * @param fraudAnalysisResponse
     */
    public void setFraudAnalysisResponse(net.paymentech.ws.FraudAnalysisResponseType fraudAnalysisResponse) {
        this.fraudAnalysisResponse = fraudAnalysisResponse;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SafetechFraudAnalysisResponseElement)) return false;
        SafetechFraudAnalysisResponseElement other = (SafetechFraudAnalysisResponseElement) obj;
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
            ((this.ccAccountNum==null && other.getCcAccountNum()==null) || 
             (this.ccAccountNum!=null &&
              this.ccAccountNum.equals(other.getCcAccountNum()))) &&
            ((this.orderID==null && other.getOrderID()==null) || 
             (this.orderID!=null &&
              this.orderID.equals(other.getOrderID()))) &&
            ((this.txRefNum==null && other.getTxRefNum()==null) || 
             (this.txRefNum!=null &&
              this.txRefNum.equals(other.getTxRefNum()))) &&
            ((this.respDateTime==null && other.getRespDateTime()==null) || 
             (this.respDateTime!=null &&
              this.respDateTime.equals(other.getRespDateTime()))) &&
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
            ((this.procStatus==null && other.getProcStatus()==null) || 
             (this.procStatus!=null &&
              this.procStatus.equals(other.getProcStatus()))) &&
            ((this.approvalStatus==null && other.getApprovalStatus()==null) || 
             (this.approvalStatus!=null &&
              this.approvalStatus.equals(other.getApprovalStatus()))) &&
            ((this.respCode==null && other.getRespCode()==null) || 
             (this.respCode!=null &&
              this.respCode.equals(other.getRespCode()))) &&
            ((this.procStatusMessage==null && other.getProcStatusMessage()==null) || 
             (this.procStatusMessage!=null &&
              this.procStatusMessage.equals(other.getProcStatusMessage()))) &&
            ((this.respCodeMessage==null && other.getRespCodeMessage()==null) || 
             (this.respCodeMessage!=null &&
              this.respCodeMessage.equals(other.getRespCodeMessage()))) &&
            ((this.hostRespCode==null && other.getHostRespCode()==null) || 
             (this.hostRespCode!=null &&
              this.hostRespCode.equals(other.getHostRespCode()))) &&
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
        if (getIndustryType() != null) {
            _hashCode += getIndustryType().hashCode();
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
        if (getCcAccountNum() != null) {
            _hashCode += getCcAccountNum().hashCode();
        }
        if (getOrderID() != null) {
            _hashCode += getOrderID().hashCode();
        }
        if (getTxRefNum() != null) {
            _hashCode += getTxRefNum().hashCode();
        }
        if (getRespDateTime() != null) {
            _hashCode += getRespDateTime().hashCode();
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
        if (getProcStatus() != null) {
            _hashCode += getProcStatus().hashCode();
        }
        if (getApprovalStatus() != null) {
            _hashCode += getApprovalStatus().hashCode();
        }
        if (getRespCode() != null) {
            _hashCode += getRespCode().hashCode();
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
        if (getFraudAnalysisResponse() != null) {
            _hashCode += getFraudAnalysisResponse().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SafetechFraudAnalysisResponseElement.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "SafetechFraudAnalysisResponseElement"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("version");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "version"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("industryType");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "industryType"));
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
        elemField.setFieldName("ccAccountNum");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "ccAccountNum"));
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
        elemField.setFieldName("respDateTime");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "respDateTime"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
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
        elemField.setFieldName("fraudAnalysisResponse");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "fraudAnalysisResponse"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "FraudAnalysisResponseType"));
        elemField.setNillable(false);
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
