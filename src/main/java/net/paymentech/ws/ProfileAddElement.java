/**
 * ProfileAddElement.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package net.paymentech.ws;

public class ProfileAddElement  implements java.io.Serializable {
    private java.lang.String orbitalConnectionUsername;

    private java.lang.String orbitalConnectionPassword;

    private java.lang.String version;

    private java.lang.String bin;

    private java.lang.String merchantID;

    private java.lang.String customerName;

    private java.lang.String customerRefNum;

    private java.lang.String customerAddress1;

    private java.lang.String customerAddress2;

    private java.lang.String customerCity;

    private java.lang.String customerState;

    private java.lang.String customerZIP;

    private java.lang.String customerEmail;

    private java.lang.String customerPhone;

    private java.lang.String customerCountryCode;

    private java.lang.String customerProfileOrderOverideInd;

    private java.lang.String customerProfileFromOrderInd;

    private java.lang.String orderDefaultDescription;

    private java.lang.String orderDefaultAmount;

    private java.lang.String customerAccountType;

    private java.lang.String ccAccountNum;

    private java.lang.String encryptedPan;

    private java.lang.String encryptedPanMethod;

    private java.lang.String encryptedPanKey;

    private java.lang.String encryptedPanPublicKeyFingerPrint;

    private java.lang.String encryptedPanHash;

    private java.lang.String ccExp;

    private java.lang.String ecpCheckDDA;

    private java.lang.String ecpBankAcctType;

    private java.lang.String ecpCheckRT;

    private java.lang.String ecpDelvMethod;

    private java.lang.String switchSoloCardStartDate;

    private java.lang.String switchSoloIssueNum;

    private java.lang.String mbType;

    private java.lang.String mbOrderIdGenerationMethod;

    private java.lang.String mbRecurringStartDate;

    private java.lang.String mbRecurringEndDate;

    private java.lang.String mbRecurringNoEndDateFlag;

    private java.lang.String mbRecurringMaxBillings;

    private java.lang.String mbRecurringFrequency;

    private java.lang.String mbMicroPaymentMaxDollarValue;

    private java.lang.String mbMicroPaymentMaxBillingDays;

    private java.lang.String mbMicroPaymentMaxTransactions;

    private java.lang.String mbDeferredBillDate;

    private java.lang.String mcSecureCodeAAV;

    private java.lang.String softDescMercName;

    private java.lang.String softDescProdDesc;

    private java.lang.String softDescMercCity;

    private java.lang.String softDescMercPhone;

    private java.lang.String softDescMercURL;

    private java.lang.String softDescMercEmail;

    private java.lang.String euddBankSortCode;

    private java.lang.String euddCountryCode;

    private java.lang.String euddRibCode;

    private java.lang.String euddBankBranchCode;

    private java.lang.String euddIBAN;

    private java.lang.String euddBIC;

    private java.lang.String euddMandateSignatureDate;

    private java.lang.String euddMandateID;

    private java.lang.String euddMandateType;

    private java.lang.String status;

    private java.lang.String debitBillerReferenceNumber;

    private java.lang.String accountUpdaterEligibility;

    private java.lang.String dpanInd;

    public ProfileAddElement() {
    }

    public ProfileAddElement(
           java.lang.String orbitalConnectionUsername,
           java.lang.String orbitalConnectionPassword,
           java.lang.String version,
           java.lang.String bin,
           java.lang.String merchantID,
           java.lang.String customerName,
           java.lang.String customerRefNum,
           java.lang.String customerAddress1,
           java.lang.String customerAddress2,
           java.lang.String customerCity,
           java.lang.String customerState,
           java.lang.String customerZIP,
           java.lang.String customerEmail,
           java.lang.String customerPhone,
           java.lang.String customerCountryCode,
           java.lang.String customerProfileOrderOverideInd,
           java.lang.String customerProfileFromOrderInd,
           java.lang.String orderDefaultDescription,
           java.lang.String orderDefaultAmount,
           java.lang.String customerAccountType,
           java.lang.String ccAccountNum,
           java.lang.String encryptedPan,
           java.lang.String encryptedPanMethod,
           java.lang.String encryptedPanKey,
           java.lang.String encryptedPanPublicKeyFingerPrint,
           java.lang.String encryptedPanHash,
           java.lang.String ccExp,
           java.lang.String ecpCheckDDA,
           java.lang.String ecpBankAcctType,
           java.lang.String ecpCheckRT,
           java.lang.String ecpDelvMethod,
           java.lang.String switchSoloCardStartDate,
           java.lang.String switchSoloIssueNum,
           java.lang.String mbType,
           java.lang.String mbOrderIdGenerationMethod,
           java.lang.String mbRecurringStartDate,
           java.lang.String mbRecurringEndDate,
           java.lang.String mbRecurringNoEndDateFlag,
           java.lang.String mbRecurringMaxBillings,
           java.lang.String mbRecurringFrequency,
           java.lang.String mbMicroPaymentMaxDollarValue,
           java.lang.String mbMicroPaymentMaxBillingDays,
           java.lang.String mbMicroPaymentMaxTransactions,
           java.lang.String mbDeferredBillDate,
           java.lang.String mcSecureCodeAAV,
           java.lang.String softDescMercName,
           java.lang.String softDescProdDesc,
           java.lang.String softDescMercCity,
           java.lang.String softDescMercPhone,
           java.lang.String softDescMercURL,
           java.lang.String softDescMercEmail,
           java.lang.String euddBankSortCode,
           java.lang.String euddCountryCode,
           java.lang.String euddRibCode,
           java.lang.String euddBankBranchCode,
           java.lang.String euddIBAN,
           java.lang.String euddBIC,
           java.lang.String euddMandateSignatureDate,
           java.lang.String euddMandateID,
           java.lang.String euddMandateType,
           java.lang.String status,
           java.lang.String debitBillerReferenceNumber,
           java.lang.String accountUpdaterEligibility,
           java.lang.String dpanInd) {
           this.orbitalConnectionUsername = orbitalConnectionUsername;
           this.orbitalConnectionPassword = orbitalConnectionPassword;
           this.version = version;
           this.bin = bin;
           this.merchantID = merchantID;
           this.customerName = customerName;
           this.customerRefNum = customerRefNum;
           this.customerAddress1 = customerAddress1;
           this.customerAddress2 = customerAddress2;
           this.customerCity = customerCity;
           this.customerState = customerState;
           this.customerZIP = customerZIP;
           this.customerEmail = customerEmail;
           this.customerPhone = customerPhone;
           this.customerCountryCode = customerCountryCode;
           this.customerProfileOrderOverideInd = customerProfileOrderOverideInd;
           this.customerProfileFromOrderInd = customerProfileFromOrderInd;
           this.orderDefaultDescription = orderDefaultDescription;
           this.orderDefaultAmount = orderDefaultAmount;
           this.customerAccountType = customerAccountType;
           this.ccAccountNum = ccAccountNum;
           this.encryptedPan = encryptedPan;
           this.encryptedPanMethod = encryptedPanMethod;
           this.encryptedPanKey = encryptedPanKey;
           this.encryptedPanPublicKeyFingerPrint = encryptedPanPublicKeyFingerPrint;
           this.encryptedPanHash = encryptedPanHash;
           this.ccExp = ccExp;
           this.ecpCheckDDA = ecpCheckDDA;
           this.ecpBankAcctType = ecpBankAcctType;
           this.ecpCheckRT = ecpCheckRT;
           this.ecpDelvMethod = ecpDelvMethod;
           this.switchSoloCardStartDate = switchSoloCardStartDate;
           this.switchSoloIssueNum = switchSoloIssueNum;
           this.mbType = mbType;
           this.mbOrderIdGenerationMethod = mbOrderIdGenerationMethod;
           this.mbRecurringStartDate = mbRecurringStartDate;
           this.mbRecurringEndDate = mbRecurringEndDate;
           this.mbRecurringNoEndDateFlag = mbRecurringNoEndDateFlag;
           this.mbRecurringMaxBillings = mbRecurringMaxBillings;
           this.mbRecurringFrequency = mbRecurringFrequency;
           this.mbMicroPaymentMaxDollarValue = mbMicroPaymentMaxDollarValue;
           this.mbMicroPaymentMaxBillingDays = mbMicroPaymentMaxBillingDays;
           this.mbMicroPaymentMaxTransactions = mbMicroPaymentMaxTransactions;
           this.mbDeferredBillDate = mbDeferredBillDate;
           this.mcSecureCodeAAV = mcSecureCodeAAV;
           this.softDescMercName = softDescMercName;
           this.softDescProdDesc = softDescProdDesc;
           this.softDescMercCity = softDescMercCity;
           this.softDescMercPhone = softDescMercPhone;
           this.softDescMercURL = softDescMercURL;
           this.softDescMercEmail = softDescMercEmail;
           this.euddBankSortCode = euddBankSortCode;
           this.euddCountryCode = euddCountryCode;
           this.euddRibCode = euddRibCode;
           this.euddBankBranchCode = euddBankBranchCode;
           this.euddIBAN = euddIBAN;
           this.euddBIC = euddBIC;
           this.euddMandateSignatureDate = euddMandateSignatureDate;
           this.euddMandateID = euddMandateID;
           this.euddMandateType = euddMandateType;
           this.status = status;
           this.debitBillerReferenceNumber = debitBillerReferenceNumber;
           this.accountUpdaterEligibility = accountUpdaterEligibility;
           this.dpanInd = dpanInd;
    }


    /**
     * Gets the orbitalConnectionUsername value for this ProfileAddElement.
     * 
     * @return orbitalConnectionUsername
     */
    public java.lang.String getOrbitalConnectionUsername() {
        return orbitalConnectionUsername;
    }


    /**
     * Sets the orbitalConnectionUsername value for this ProfileAddElement.
     * 
     * @param orbitalConnectionUsername
     */
    public void setOrbitalConnectionUsername(java.lang.String orbitalConnectionUsername) {
        this.orbitalConnectionUsername = orbitalConnectionUsername;
    }


    /**
     * Gets the orbitalConnectionPassword value for this ProfileAddElement.
     * 
     * @return orbitalConnectionPassword
     */
    public java.lang.String getOrbitalConnectionPassword() {
        return orbitalConnectionPassword;
    }


    /**
     * Sets the orbitalConnectionPassword value for this ProfileAddElement.
     * 
     * @param orbitalConnectionPassword
     */
    public void setOrbitalConnectionPassword(java.lang.String orbitalConnectionPassword) {
        this.orbitalConnectionPassword = orbitalConnectionPassword;
    }


    /**
     * Gets the version value for this ProfileAddElement.
     * 
     * @return version
     */
    public java.lang.String getVersion() {
        return version;
    }


    /**
     * Sets the version value for this ProfileAddElement.
     * 
     * @param version
     */
    public void setVersion(java.lang.String version) {
        this.version = version;
    }


    /**
     * Gets the bin value for this ProfileAddElement.
     * 
     * @return bin
     */
    public java.lang.String getBin() {
        return bin;
    }


    /**
     * Sets the bin value for this ProfileAddElement.
     * 
     * @param bin
     */
    public void setBin(java.lang.String bin) {
        this.bin = bin;
    }


    /**
     * Gets the merchantID value for this ProfileAddElement.
     * 
     * @return merchantID
     */
    public java.lang.String getMerchantID() {
        return merchantID;
    }


    /**
     * Sets the merchantID value for this ProfileAddElement.
     * 
     * @param merchantID
     */
    public void setMerchantID(java.lang.String merchantID) {
        this.merchantID = merchantID;
    }


    /**
     * Gets the customerName value for this ProfileAddElement.
     * 
     * @return customerName
     */
    public java.lang.String getCustomerName() {
        return customerName;
    }


    /**
     * Sets the customerName value for this ProfileAddElement.
     * 
     * @param customerName
     */
    public void setCustomerName(java.lang.String customerName) {
        this.customerName = customerName;
    }


    /**
     * Gets the customerRefNum value for this ProfileAddElement.
     * 
     * @return customerRefNum
     */
    public java.lang.String getCustomerRefNum() {
        return customerRefNum;
    }


    /**
     * Sets the customerRefNum value for this ProfileAddElement.
     * 
     * @param customerRefNum
     */
    public void setCustomerRefNum(java.lang.String customerRefNum) {
        this.customerRefNum = customerRefNum;
    }


    /**
     * Gets the customerAddress1 value for this ProfileAddElement.
     * 
     * @return customerAddress1
     */
    public java.lang.String getCustomerAddress1() {
        return customerAddress1;
    }


    /**
     * Sets the customerAddress1 value for this ProfileAddElement.
     * 
     * @param customerAddress1
     */
    public void setCustomerAddress1(java.lang.String customerAddress1) {
        this.customerAddress1 = customerAddress1;
    }


    /**
     * Gets the customerAddress2 value for this ProfileAddElement.
     * 
     * @return customerAddress2
     */
    public java.lang.String getCustomerAddress2() {
        return customerAddress2;
    }


    /**
     * Sets the customerAddress2 value for this ProfileAddElement.
     * 
     * @param customerAddress2
     */
    public void setCustomerAddress2(java.lang.String customerAddress2) {
        this.customerAddress2 = customerAddress2;
    }


    /**
     * Gets the customerCity value for this ProfileAddElement.
     * 
     * @return customerCity
     */
    public java.lang.String getCustomerCity() {
        return customerCity;
    }


    /**
     * Sets the customerCity value for this ProfileAddElement.
     * 
     * @param customerCity
     */
    public void setCustomerCity(java.lang.String customerCity) {
        this.customerCity = customerCity;
    }


    /**
     * Gets the customerState value for this ProfileAddElement.
     * 
     * @return customerState
     */
    public java.lang.String getCustomerState() {
        return customerState;
    }


    /**
     * Sets the customerState value for this ProfileAddElement.
     * 
     * @param customerState
     */
    public void setCustomerState(java.lang.String customerState) {
        this.customerState = customerState;
    }


    /**
     * Gets the customerZIP value for this ProfileAddElement.
     * 
     * @return customerZIP
     */
    public java.lang.String getCustomerZIP() {
        return customerZIP;
    }


    /**
     * Sets the customerZIP value for this ProfileAddElement.
     * 
     * @param customerZIP
     */
    public void setCustomerZIP(java.lang.String customerZIP) {
        this.customerZIP = customerZIP;
    }


    /**
     * Gets the customerEmail value for this ProfileAddElement.
     * 
     * @return customerEmail
     */
    public java.lang.String getCustomerEmail() {
        return customerEmail;
    }


    /**
     * Sets the customerEmail value for this ProfileAddElement.
     * 
     * @param customerEmail
     */
    public void setCustomerEmail(java.lang.String customerEmail) {
        this.customerEmail = customerEmail;
    }


    /**
     * Gets the customerPhone value for this ProfileAddElement.
     * 
     * @return customerPhone
     */
    public java.lang.String getCustomerPhone() {
        return customerPhone;
    }


    /**
     * Sets the customerPhone value for this ProfileAddElement.
     * 
     * @param customerPhone
     */
    public void setCustomerPhone(java.lang.String customerPhone) {
        this.customerPhone = customerPhone;
    }


    /**
     * Gets the customerCountryCode value for this ProfileAddElement.
     * 
     * @return customerCountryCode
     */
    public java.lang.String getCustomerCountryCode() {
        return customerCountryCode;
    }


    /**
     * Sets the customerCountryCode value for this ProfileAddElement.
     * 
     * @param customerCountryCode
     */
    public void setCustomerCountryCode(java.lang.String customerCountryCode) {
        this.customerCountryCode = customerCountryCode;
    }


    /**
     * Gets the customerProfileOrderOverideInd value for this ProfileAddElement.
     * 
     * @return customerProfileOrderOverideInd
     */
    public java.lang.String getCustomerProfileOrderOverideInd() {
        return customerProfileOrderOverideInd;
    }


    /**
     * Sets the customerProfileOrderOverideInd value for this ProfileAddElement.
     * 
     * @param customerProfileOrderOverideInd
     */
    public void setCustomerProfileOrderOverideInd(java.lang.String customerProfileOrderOverideInd) {
        this.customerProfileOrderOverideInd = customerProfileOrderOverideInd;
    }


    /**
     * Gets the customerProfileFromOrderInd value for this ProfileAddElement.
     * 
     * @return customerProfileFromOrderInd
     */
    public java.lang.String getCustomerProfileFromOrderInd() {
        return customerProfileFromOrderInd;
    }


    /**
     * Sets the customerProfileFromOrderInd value for this ProfileAddElement.
     * 
     * @param customerProfileFromOrderInd
     */
    public void setCustomerProfileFromOrderInd(java.lang.String customerProfileFromOrderInd) {
        this.customerProfileFromOrderInd = customerProfileFromOrderInd;
    }


    /**
     * Gets the orderDefaultDescription value for this ProfileAddElement.
     * 
     * @return orderDefaultDescription
     */
    public java.lang.String getOrderDefaultDescription() {
        return orderDefaultDescription;
    }


    /**
     * Sets the orderDefaultDescription value for this ProfileAddElement.
     * 
     * @param orderDefaultDescription
     */
    public void setOrderDefaultDescription(java.lang.String orderDefaultDescription) {
        this.orderDefaultDescription = orderDefaultDescription;
    }


    /**
     * Gets the orderDefaultAmount value for this ProfileAddElement.
     * 
     * @return orderDefaultAmount
     */
    public java.lang.String getOrderDefaultAmount() {
        return orderDefaultAmount;
    }


    /**
     * Sets the orderDefaultAmount value for this ProfileAddElement.
     * 
     * @param orderDefaultAmount
     */
    public void setOrderDefaultAmount(java.lang.String orderDefaultAmount) {
        this.orderDefaultAmount = orderDefaultAmount;
    }


    /**
     * Gets the customerAccountType value for this ProfileAddElement.
     * 
     * @return customerAccountType
     */
    public java.lang.String getCustomerAccountType() {
        return customerAccountType;
    }


    /**
     * Sets the customerAccountType value for this ProfileAddElement.
     * 
     * @param customerAccountType
     */
    public void setCustomerAccountType(java.lang.String customerAccountType) {
        this.customerAccountType = customerAccountType;
    }


    /**
     * Gets the ccAccountNum value for this ProfileAddElement.
     * 
     * @return ccAccountNum
     */
    public java.lang.String getCcAccountNum() {
        return ccAccountNum;
    }


    /**
     * Sets the ccAccountNum value for this ProfileAddElement.
     * 
     * @param ccAccountNum
     */
    public void setCcAccountNum(java.lang.String ccAccountNum) {
        this.ccAccountNum = ccAccountNum;
    }


    /**
     * Gets the encryptedPan value for this ProfileAddElement.
     * 
     * @return encryptedPan
     */
    public java.lang.String getEncryptedPan() {
        return encryptedPan;
    }


    /**
     * Sets the encryptedPan value for this ProfileAddElement.
     * 
     * @param encryptedPan
     */
    public void setEncryptedPan(java.lang.String encryptedPan) {
        this.encryptedPan = encryptedPan;
    }


    /**
     * Gets the encryptedPanMethod value for this ProfileAddElement.
     * 
     * @return encryptedPanMethod
     */
    public java.lang.String getEncryptedPanMethod() {
        return encryptedPanMethod;
    }


    /**
     * Sets the encryptedPanMethod value for this ProfileAddElement.
     * 
     * @param encryptedPanMethod
     */
    public void setEncryptedPanMethod(java.lang.String encryptedPanMethod) {
        this.encryptedPanMethod = encryptedPanMethod;
    }


    /**
     * Gets the encryptedPanKey value for this ProfileAddElement.
     * 
     * @return encryptedPanKey
     */
    public java.lang.String getEncryptedPanKey() {
        return encryptedPanKey;
    }


    /**
     * Sets the encryptedPanKey value for this ProfileAddElement.
     * 
     * @param encryptedPanKey
     */
    public void setEncryptedPanKey(java.lang.String encryptedPanKey) {
        this.encryptedPanKey = encryptedPanKey;
    }


    /**
     * Gets the encryptedPanPublicKeyFingerPrint value for this ProfileAddElement.
     * 
     * @return encryptedPanPublicKeyFingerPrint
     */
    public java.lang.String getEncryptedPanPublicKeyFingerPrint() {
        return encryptedPanPublicKeyFingerPrint;
    }


    /**
     * Sets the encryptedPanPublicKeyFingerPrint value for this ProfileAddElement.
     * 
     * @param encryptedPanPublicKeyFingerPrint
     */
    public void setEncryptedPanPublicKeyFingerPrint(java.lang.String encryptedPanPublicKeyFingerPrint) {
        this.encryptedPanPublicKeyFingerPrint = encryptedPanPublicKeyFingerPrint;
    }


    /**
     * Gets the encryptedPanHash value for this ProfileAddElement.
     * 
     * @return encryptedPanHash
     */
    public java.lang.String getEncryptedPanHash() {
        return encryptedPanHash;
    }


    /**
     * Sets the encryptedPanHash value for this ProfileAddElement.
     * 
     * @param encryptedPanHash
     */
    public void setEncryptedPanHash(java.lang.String encryptedPanHash) {
        this.encryptedPanHash = encryptedPanHash;
    }


    /**
     * Gets the ccExp value for this ProfileAddElement.
     * 
     * @return ccExp
     */
    public java.lang.String getCcExp() {
        return ccExp;
    }


    /**
     * Sets the ccExp value for this ProfileAddElement.
     * 
     * @param ccExp
     */
    public void setCcExp(java.lang.String ccExp) {
        this.ccExp = ccExp;
    }


    /**
     * Gets the ecpCheckDDA value for this ProfileAddElement.
     * 
     * @return ecpCheckDDA
     */
    public java.lang.String getEcpCheckDDA() {
        return ecpCheckDDA;
    }


    /**
     * Sets the ecpCheckDDA value for this ProfileAddElement.
     * 
     * @param ecpCheckDDA
     */
    public void setEcpCheckDDA(java.lang.String ecpCheckDDA) {
        this.ecpCheckDDA = ecpCheckDDA;
    }


    /**
     * Gets the ecpBankAcctType value for this ProfileAddElement.
     * 
     * @return ecpBankAcctType
     */
    public java.lang.String getEcpBankAcctType() {
        return ecpBankAcctType;
    }


    /**
     * Sets the ecpBankAcctType value for this ProfileAddElement.
     * 
     * @param ecpBankAcctType
     */
    public void setEcpBankAcctType(java.lang.String ecpBankAcctType) {
        this.ecpBankAcctType = ecpBankAcctType;
    }


    /**
     * Gets the ecpCheckRT value for this ProfileAddElement.
     * 
     * @return ecpCheckRT
     */
    public java.lang.String getEcpCheckRT() {
        return ecpCheckRT;
    }


    /**
     * Sets the ecpCheckRT value for this ProfileAddElement.
     * 
     * @param ecpCheckRT
     */
    public void setEcpCheckRT(java.lang.String ecpCheckRT) {
        this.ecpCheckRT = ecpCheckRT;
    }


    /**
     * Gets the ecpDelvMethod value for this ProfileAddElement.
     * 
     * @return ecpDelvMethod
     */
    public java.lang.String getEcpDelvMethod() {
        return ecpDelvMethod;
    }


    /**
     * Sets the ecpDelvMethod value for this ProfileAddElement.
     * 
     * @param ecpDelvMethod
     */
    public void setEcpDelvMethod(java.lang.String ecpDelvMethod) {
        this.ecpDelvMethod = ecpDelvMethod;
    }


    /**
     * Gets the switchSoloCardStartDate value for this ProfileAddElement.
     * 
     * @return switchSoloCardStartDate
     */
    public java.lang.String getSwitchSoloCardStartDate() {
        return switchSoloCardStartDate;
    }


    /**
     * Sets the switchSoloCardStartDate value for this ProfileAddElement.
     * 
     * @param switchSoloCardStartDate
     */
    public void setSwitchSoloCardStartDate(java.lang.String switchSoloCardStartDate) {
        this.switchSoloCardStartDate = switchSoloCardStartDate;
    }


    /**
     * Gets the switchSoloIssueNum value for this ProfileAddElement.
     * 
     * @return switchSoloIssueNum
     */
    public java.lang.String getSwitchSoloIssueNum() {
        return switchSoloIssueNum;
    }


    /**
     * Sets the switchSoloIssueNum value for this ProfileAddElement.
     * 
     * @param switchSoloIssueNum
     */
    public void setSwitchSoloIssueNum(java.lang.String switchSoloIssueNum) {
        this.switchSoloIssueNum = switchSoloIssueNum;
    }


    /**
     * Gets the mbType value for this ProfileAddElement.
     * 
     * @return mbType
     */
    public java.lang.String getMbType() {
        return mbType;
    }


    /**
     * Sets the mbType value for this ProfileAddElement.
     * 
     * @param mbType
     */
    public void setMbType(java.lang.String mbType) {
        this.mbType = mbType;
    }


    /**
     * Gets the mbOrderIdGenerationMethod value for this ProfileAddElement.
     * 
     * @return mbOrderIdGenerationMethod
     */
    public java.lang.String getMbOrderIdGenerationMethod() {
        return mbOrderIdGenerationMethod;
    }


    /**
     * Sets the mbOrderIdGenerationMethod value for this ProfileAddElement.
     * 
     * @param mbOrderIdGenerationMethod
     */
    public void setMbOrderIdGenerationMethod(java.lang.String mbOrderIdGenerationMethod) {
        this.mbOrderIdGenerationMethod = mbOrderIdGenerationMethod;
    }


    /**
     * Gets the mbRecurringStartDate value for this ProfileAddElement.
     * 
     * @return mbRecurringStartDate
     */
    public java.lang.String getMbRecurringStartDate() {
        return mbRecurringStartDate;
    }


    /**
     * Sets the mbRecurringStartDate value for this ProfileAddElement.
     * 
     * @param mbRecurringStartDate
     */
    public void setMbRecurringStartDate(java.lang.String mbRecurringStartDate) {
        this.mbRecurringStartDate = mbRecurringStartDate;
    }


    /**
     * Gets the mbRecurringEndDate value for this ProfileAddElement.
     * 
     * @return mbRecurringEndDate
     */
    public java.lang.String getMbRecurringEndDate() {
        return mbRecurringEndDate;
    }


    /**
     * Sets the mbRecurringEndDate value for this ProfileAddElement.
     * 
     * @param mbRecurringEndDate
     */
    public void setMbRecurringEndDate(java.lang.String mbRecurringEndDate) {
        this.mbRecurringEndDate = mbRecurringEndDate;
    }


    /**
     * Gets the mbRecurringNoEndDateFlag value for this ProfileAddElement.
     * 
     * @return mbRecurringNoEndDateFlag
     */
    public java.lang.String getMbRecurringNoEndDateFlag() {
        return mbRecurringNoEndDateFlag;
    }


    /**
     * Sets the mbRecurringNoEndDateFlag value for this ProfileAddElement.
     * 
     * @param mbRecurringNoEndDateFlag
     */
    public void setMbRecurringNoEndDateFlag(java.lang.String mbRecurringNoEndDateFlag) {
        this.mbRecurringNoEndDateFlag = mbRecurringNoEndDateFlag;
    }


    /**
     * Gets the mbRecurringMaxBillings value for this ProfileAddElement.
     * 
     * @return mbRecurringMaxBillings
     */
    public java.lang.String getMbRecurringMaxBillings() {
        return mbRecurringMaxBillings;
    }


    /**
     * Sets the mbRecurringMaxBillings value for this ProfileAddElement.
     * 
     * @param mbRecurringMaxBillings
     */
    public void setMbRecurringMaxBillings(java.lang.String mbRecurringMaxBillings) {
        this.mbRecurringMaxBillings = mbRecurringMaxBillings;
    }


    /**
     * Gets the mbRecurringFrequency value for this ProfileAddElement.
     * 
     * @return mbRecurringFrequency
     */
    public java.lang.String getMbRecurringFrequency() {
        return mbRecurringFrequency;
    }


    /**
     * Sets the mbRecurringFrequency value for this ProfileAddElement.
     * 
     * @param mbRecurringFrequency
     */
    public void setMbRecurringFrequency(java.lang.String mbRecurringFrequency) {
        this.mbRecurringFrequency = mbRecurringFrequency;
    }


    /**
     * Gets the mbMicroPaymentMaxDollarValue value for this ProfileAddElement.
     * 
     * @return mbMicroPaymentMaxDollarValue
     */
    public java.lang.String getMbMicroPaymentMaxDollarValue() {
        return mbMicroPaymentMaxDollarValue;
    }


    /**
     * Sets the mbMicroPaymentMaxDollarValue value for this ProfileAddElement.
     * 
     * @param mbMicroPaymentMaxDollarValue
     */
    public void setMbMicroPaymentMaxDollarValue(java.lang.String mbMicroPaymentMaxDollarValue) {
        this.mbMicroPaymentMaxDollarValue = mbMicroPaymentMaxDollarValue;
    }


    /**
     * Gets the mbMicroPaymentMaxBillingDays value for this ProfileAddElement.
     * 
     * @return mbMicroPaymentMaxBillingDays
     */
    public java.lang.String getMbMicroPaymentMaxBillingDays() {
        return mbMicroPaymentMaxBillingDays;
    }


    /**
     * Sets the mbMicroPaymentMaxBillingDays value for this ProfileAddElement.
     * 
     * @param mbMicroPaymentMaxBillingDays
     */
    public void setMbMicroPaymentMaxBillingDays(java.lang.String mbMicroPaymentMaxBillingDays) {
        this.mbMicroPaymentMaxBillingDays = mbMicroPaymentMaxBillingDays;
    }


    /**
     * Gets the mbMicroPaymentMaxTransactions value for this ProfileAddElement.
     * 
     * @return mbMicroPaymentMaxTransactions
     */
    public java.lang.String getMbMicroPaymentMaxTransactions() {
        return mbMicroPaymentMaxTransactions;
    }


    /**
     * Sets the mbMicroPaymentMaxTransactions value for this ProfileAddElement.
     * 
     * @param mbMicroPaymentMaxTransactions
     */
    public void setMbMicroPaymentMaxTransactions(java.lang.String mbMicroPaymentMaxTransactions) {
        this.mbMicroPaymentMaxTransactions = mbMicroPaymentMaxTransactions;
    }


    /**
     * Gets the mbDeferredBillDate value for this ProfileAddElement.
     * 
     * @return mbDeferredBillDate
     */
    public java.lang.String getMbDeferredBillDate() {
        return mbDeferredBillDate;
    }


    /**
     * Sets the mbDeferredBillDate value for this ProfileAddElement.
     * 
     * @param mbDeferredBillDate
     */
    public void setMbDeferredBillDate(java.lang.String mbDeferredBillDate) {
        this.mbDeferredBillDate = mbDeferredBillDate;
    }


    /**
     * Gets the mcSecureCodeAAV value for this ProfileAddElement.
     * 
     * @return mcSecureCodeAAV
     */
    public java.lang.String getMcSecureCodeAAV() {
        return mcSecureCodeAAV;
    }


    /**
     * Sets the mcSecureCodeAAV value for this ProfileAddElement.
     * 
     * @param mcSecureCodeAAV
     */
    public void setMcSecureCodeAAV(java.lang.String mcSecureCodeAAV) {
        this.mcSecureCodeAAV = mcSecureCodeAAV;
    }


    /**
     * Gets the softDescMercName value for this ProfileAddElement.
     * 
     * @return softDescMercName
     */
    public java.lang.String getSoftDescMercName() {
        return softDescMercName;
    }


    /**
     * Sets the softDescMercName value for this ProfileAddElement.
     * 
     * @param softDescMercName
     */
    public void setSoftDescMercName(java.lang.String softDescMercName) {
        this.softDescMercName = softDescMercName;
    }


    /**
     * Gets the softDescProdDesc value for this ProfileAddElement.
     * 
     * @return softDescProdDesc
     */
    public java.lang.String getSoftDescProdDesc() {
        return softDescProdDesc;
    }


    /**
     * Sets the softDescProdDesc value for this ProfileAddElement.
     * 
     * @param softDescProdDesc
     */
    public void setSoftDescProdDesc(java.lang.String softDescProdDesc) {
        this.softDescProdDesc = softDescProdDesc;
    }


    /**
     * Gets the softDescMercCity value for this ProfileAddElement.
     * 
     * @return softDescMercCity
     */
    public java.lang.String getSoftDescMercCity() {
        return softDescMercCity;
    }


    /**
     * Sets the softDescMercCity value for this ProfileAddElement.
     * 
     * @param softDescMercCity
     */
    public void setSoftDescMercCity(java.lang.String softDescMercCity) {
        this.softDescMercCity = softDescMercCity;
    }


    /**
     * Gets the softDescMercPhone value for this ProfileAddElement.
     * 
     * @return softDescMercPhone
     */
    public java.lang.String getSoftDescMercPhone() {
        return softDescMercPhone;
    }


    /**
     * Sets the softDescMercPhone value for this ProfileAddElement.
     * 
     * @param softDescMercPhone
     */
    public void setSoftDescMercPhone(java.lang.String softDescMercPhone) {
        this.softDescMercPhone = softDescMercPhone;
    }


    /**
     * Gets the softDescMercURL value for this ProfileAddElement.
     * 
     * @return softDescMercURL
     */
    public java.lang.String getSoftDescMercURL() {
        return softDescMercURL;
    }


    /**
     * Sets the softDescMercURL value for this ProfileAddElement.
     * 
     * @param softDescMercURL
     */
    public void setSoftDescMercURL(java.lang.String softDescMercURL) {
        this.softDescMercURL = softDescMercURL;
    }


    /**
     * Gets the softDescMercEmail value for this ProfileAddElement.
     * 
     * @return softDescMercEmail
     */
    public java.lang.String getSoftDescMercEmail() {
        return softDescMercEmail;
    }


    /**
     * Sets the softDescMercEmail value for this ProfileAddElement.
     * 
     * @param softDescMercEmail
     */
    public void setSoftDescMercEmail(java.lang.String softDescMercEmail) {
        this.softDescMercEmail = softDescMercEmail;
    }


    /**
     * Gets the euddBankSortCode value for this ProfileAddElement.
     * 
     * @return euddBankSortCode
     */
    public java.lang.String getEuddBankSortCode() {
        return euddBankSortCode;
    }


    /**
     * Sets the euddBankSortCode value for this ProfileAddElement.
     * 
     * @param euddBankSortCode
     */
    public void setEuddBankSortCode(java.lang.String euddBankSortCode) {
        this.euddBankSortCode = euddBankSortCode;
    }


    /**
     * Gets the euddCountryCode value for this ProfileAddElement.
     * 
     * @return euddCountryCode
     */
    public java.lang.String getEuddCountryCode() {
        return euddCountryCode;
    }


    /**
     * Sets the euddCountryCode value for this ProfileAddElement.
     * 
     * @param euddCountryCode
     */
    public void setEuddCountryCode(java.lang.String euddCountryCode) {
        this.euddCountryCode = euddCountryCode;
    }


    /**
     * Gets the euddRibCode value for this ProfileAddElement.
     * 
     * @return euddRibCode
     */
    public java.lang.String getEuddRibCode() {
        return euddRibCode;
    }


    /**
     * Sets the euddRibCode value for this ProfileAddElement.
     * 
     * @param euddRibCode
     */
    public void setEuddRibCode(java.lang.String euddRibCode) {
        this.euddRibCode = euddRibCode;
    }


    /**
     * Gets the euddBankBranchCode value for this ProfileAddElement.
     * 
     * @return euddBankBranchCode
     */
    public java.lang.String getEuddBankBranchCode() {
        return euddBankBranchCode;
    }


    /**
     * Sets the euddBankBranchCode value for this ProfileAddElement.
     * 
     * @param euddBankBranchCode
     */
    public void setEuddBankBranchCode(java.lang.String euddBankBranchCode) {
        this.euddBankBranchCode = euddBankBranchCode;
    }


    /**
     * Gets the euddIBAN value for this ProfileAddElement.
     * 
     * @return euddIBAN
     */
    public java.lang.String getEuddIBAN() {
        return euddIBAN;
    }


    /**
     * Sets the euddIBAN value for this ProfileAddElement.
     * 
     * @param euddIBAN
     */
    public void setEuddIBAN(java.lang.String euddIBAN) {
        this.euddIBAN = euddIBAN;
    }


    /**
     * Gets the euddBIC value for this ProfileAddElement.
     * 
     * @return euddBIC
     */
    public java.lang.String getEuddBIC() {
        return euddBIC;
    }


    /**
     * Sets the euddBIC value for this ProfileAddElement.
     * 
     * @param euddBIC
     */
    public void setEuddBIC(java.lang.String euddBIC) {
        this.euddBIC = euddBIC;
    }


    /**
     * Gets the euddMandateSignatureDate value for this ProfileAddElement.
     * 
     * @return euddMandateSignatureDate
     */
    public java.lang.String getEuddMandateSignatureDate() {
        return euddMandateSignatureDate;
    }


    /**
     * Sets the euddMandateSignatureDate value for this ProfileAddElement.
     * 
     * @param euddMandateSignatureDate
     */
    public void setEuddMandateSignatureDate(java.lang.String euddMandateSignatureDate) {
        this.euddMandateSignatureDate = euddMandateSignatureDate;
    }


    /**
     * Gets the euddMandateID value for this ProfileAddElement.
     * 
     * @return euddMandateID
     */
    public java.lang.String getEuddMandateID() {
        return euddMandateID;
    }


    /**
     * Sets the euddMandateID value for this ProfileAddElement.
     * 
     * @param euddMandateID
     */
    public void setEuddMandateID(java.lang.String euddMandateID) {
        this.euddMandateID = euddMandateID;
    }


    /**
     * Gets the euddMandateType value for this ProfileAddElement.
     * 
     * @return euddMandateType
     */
    public java.lang.String getEuddMandateType() {
        return euddMandateType;
    }


    /**
     * Sets the euddMandateType value for this ProfileAddElement.
     * 
     * @param euddMandateType
     */
    public void setEuddMandateType(java.lang.String euddMandateType) {
        this.euddMandateType = euddMandateType;
    }


    /**
     * Gets the status value for this ProfileAddElement.
     * 
     * @return status
     */
    public java.lang.String getStatus() {
        return status;
    }


    /**
     * Sets the status value for this ProfileAddElement.
     * 
     * @param status
     */
    public void setStatus(java.lang.String status) {
        this.status = status;
    }


    /**
     * Gets the debitBillerReferenceNumber value for this ProfileAddElement.
     * 
     * @return debitBillerReferenceNumber
     */
    public java.lang.String getDebitBillerReferenceNumber() {
        return debitBillerReferenceNumber;
    }


    /**
     * Sets the debitBillerReferenceNumber value for this ProfileAddElement.
     * 
     * @param debitBillerReferenceNumber
     */
    public void setDebitBillerReferenceNumber(java.lang.String debitBillerReferenceNumber) {
        this.debitBillerReferenceNumber = debitBillerReferenceNumber;
    }


    /**
     * Gets the accountUpdaterEligibility value for this ProfileAddElement.
     * 
     * @return accountUpdaterEligibility
     */
    public java.lang.String getAccountUpdaterEligibility() {
        return accountUpdaterEligibility;
    }


    /**
     * Sets the accountUpdaterEligibility value for this ProfileAddElement.
     * 
     * @param accountUpdaterEligibility
     */
    public void setAccountUpdaterEligibility(java.lang.String accountUpdaterEligibility) {
        this.accountUpdaterEligibility = accountUpdaterEligibility;
    }


    /**
     * Gets the dpanInd value for this ProfileAddElement.
     * 
     * @return dpanInd
     */
    public java.lang.String getDpanInd() {
        return dpanInd;
    }


    /**
     * Sets the dpanInd value for this ProfileAddElement.
     * 
     * @param dpanInd
     */
    public void setDpanInd(java.lang.String dpanInd) {
        this.dpanInd = dpanInd;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ProfileAddElement)) return false;
        ProfileAddElement other = (ProfileAddElement) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.orbitalConnectionUsername==null && other.getOrbitalConnectionUsername()==null) || 
             (this.orbitalConnectionUsername!=null &&
              this.orbitalConnectionUsername.equals(other.getOrbitalConnectionUsername()))) &&
            ((this.orbitalConnectionPassword==null && other.getOrbitalConnectionPassword()==null) || 
             (this.orbitalConnectionPassword!=null &&
              this.orbitalConnectionPassword.equals(other.getOrbitalConnectionPassword()))) &&
            ((this.version==null && other.getVersion()==null) || 
             (this.version!=null &&
              this.version.equals(other.getVersion()))) &&
            ((this.bin==null && other.getBin()==null) || 
             (this.bin!=null &&
              this.bin.equals(other.getBin()))) &&
            ((this.merchantID==null && other.getMerchantID()==null) || 
             (this.merchantID!=null &&
              this.merchantID.equals(other.getMerchantID()))) &&
            ((this.customerName==null && other.getCustomerName()==null) || 
             (this.customerName!=null &&
              this.customerName.equals(other.getCustomerName()))) &&
            ((this.customerRefNum==null && other.getCustomerRefNum()==null) || 
             (this.customerRefNum!=null &&
              this.customerRefNum.equals(other.getCustomerRefNum()))) &&
            ((this.customerAddress1==null && other.getCustomerAddress1()==null) || 
             (this.customerAddress1!=null &&
              this.customerAddress1.equals(other.getCustomerAddress1()))) &&
            ((this.customerAddress2==null && other.getCustomerAddress2()==null) || 
             (this.customerAddress2!=null &&
              this.customerAddress2.equals(other.getCustomerAddress2()))) &&
            ((this.customerCity==null && other.getCustomerCity()==null) || 
             (this.customerCity!=null &&
              this.customerCity.equals(other.getCustomerCity()))) &&
            ((this.customerState==null && other.getCustomerState()==null) || 
             (this.customerState!=null &&
              this.customerState.equals(other.getCustomerState()))) &&
            ((this.customerZIP==null && other.getCustomerZIP()==null) || 
             (this.customerZIP!=null &&
              this.customerZIP.equals(other.getCustomerZIP()))) &&
            ((this.customerEmail==null && other.getCustomerEmail()==null) || 
             (this.customerEmail!=null &&
              this.customerEmail.equals(other.getCustomerEmail()))) &&
            ((this.customerPhone==null && other.getCustomerPhone()==null) || 
             (this.customerPhone!=null &&
              this.customerPhone.equals(other.getCustomerPhone()))) &&
            ((this.customerCountryCode==null && other.getCustomerCountryCode()==null) || 
             (this.customerCountryCode!=null &&
              this.customerCountryCode.equals(other.getCustomerCountryCode()))) &&
            ((this.customerProfileOrderOverideInd==null && other.getCustomerProfileOrderOverideInd()==null) || 
             (this.customerProfileOrderOverideInd!=null &&
              this.customerProfileOrderOverideInd.equals(other.getCustomerProfileOrderOverideInd()))) &&
            ((this.customerProfileFromOrderInd==null && other.getCustomerProfileFromOrderInd()==null) || 
             (this.customerProfileFromOrderInd!=null &&
              this.customerProfileFromOrderInd.equals(other.getCustomerProfileFromOrderInd()))) &&
            ((this.orderDefaultDescription==null && other.getOrderDefaultDescription()==null) || 
             (this.orderDefaultDescription!=null &&
              this.orderDefaultDescription.equals(other.getOrderDefaultDescription()))) &&
            ((this.orderDefaultAmount==null && other.getOrderDefaultAmount()==null) || 
             (this.orderDefaultAmount!=null &&
              this.orderDefaultAmount.equals(other.getOrderDefaultAmount()))) &&
            ((this.customerAccountType==null && other.getCustomerAccountType()==null) || 
             (this.customerAccountType!=null &&
              this.customerAccountType.equals(other.getCustomerAccountType()))) &&
            ((this.ccAccountNum==null && other.getCcAccountNum()==null) || 
             (this.ccAccountNum!=null &&
              this.ccAccountNum.equals(other.getCcAccountNum()))) &&
            ((this.encryptedPan==null && other.getEncryptedPan()==null) || 
             (this.encryptedPan!=null &&
              this.encryptedPan.equals(other.getEncryptedPan()))) &&
            ((this.encryptedPanMethod==null && other.getEncryptedPanMethod()==null) || 
             (this.encryptedPanMethod!=null &&
              this.encryptedPanMethod.equals(other.getEncryptedPanMethod()))) &&
            ((this.encryptedPanKey==null && other.getEncryptedPanKey()==null) || 
             (this.encryptedPanKey!=null &&
              this.encryptedPanKey.equals(other.getEncryptedPanKey()))) &&
            ((this.encryptedPanPublicKeyFingerPrint==null && other.getEncryptedPanPublicKeyFingerPrint()==null) || 
             (this.encryptedPanPublicKeyFingerPrint!=null &&
              this.encryptedPanPublicKeyFingerPrint.equals(other.getEncryptedPanPublicKeyFingerPrint()))) &&
            ((this.encryptedPanHash==null && other.getEncryptedPanHash()==null) || 
             (this.encryptedPanHash!=null &&
              this.encryptedPanHash.equals(other.getEncryptedPanHash()))) &&
            ((this.ccExp==null && other.getCcExp()==null) || 
             (this.ccExp!=null &&
              this.ccExp.equals(other.getCcExp()))) &&
            ((this.ecpCheckDDA==null && other.getEcpCheckDDA()==null) || 
             (this.ecpCheckDDA!=null &&
              this.ecpCheckDDA.equals(other.getEcpCheckDDA()))) &&
            ((this.ecpBankAcctType==null && other.getEcpBankAcctType()==null) || 
             (this.ecpBankAcctType!=null &&
              this.ecpBankAcctType.equals(other.getEcpBankAcctType()))) &&
            ((this.ecpCheckRT==null && other.getEcpCheckRT()==null) || 
             (this.ecpCheckRT!=null &&
              this.ecpCheckRT.equals(other.getEcpCheckRT()))) &&
            ((this.ecpDelvMethod==null && other.getEcpDelvMethod()==null) || 
             (this.ecpDelvMethod!=null &&
              this.ecpDelvMethod.equals(other.getEcpDelvMethod()))) &&
            ((this.switchSoloCardStartDate==null && other.getSwitchSoloCardStartDate()==null) || 
             (this.switchSoloCardStartDate!=null &&
              this.switchSoloCardStartDate.equals(other.getSwitchSoloCardStartDate()))) &&
            ((this.switchSoloIssueNum==null && other.getSwitchSoloIssueNum()==null) || 
             (this.switchSoloIssueNum!=null &&
              this.switchSoloIssueNum.equals(other.getSwitchSoloIssueNum()))) &&
            ((this.mbType==null && other.getMbType()==null) || 
             (this.mbType!=null &&
              this.mbType.equals(other.getMbType()))) &&
            ((this.mbOrderIdGenerationMethod==null && other.getMbOrderIdGenerationMethod()==null) || 
             (this.mbOrderIdGenerationMethod!=null &&
              this.mbOrderIdGenerationMethod.equals(other.getMbOrderIdGenerationMethod()))) &&
            ((this.mbRecurringStartDate==null && other.getMbRecurringStartDate()==null) || 
             (this.mbRecurringStartDate!=null &&
              this.mbRecurringStartDate.equals(other.getMbRecurringStartDate()))) &&
            ((this.mbRecurringEndDate==null && other.getMbRecurringEndDate()==null) || 
             (this.mbRecurringEndDate!=null &&
              this.mbRecurringEndDate.equals(other.getMbRecurringEndDate()))) &&
            ((this.mbRecurringNoEndDateFlag==null && other.getMbRecurringNoEndDateFlag()==null) || 
             (this.mbRecurringNoEndDateFlag!=null &&
              this.mbRecurringNoEndDateFlag.equals(other.getMbRecurringNoEndDateFlag()))) &&
            ((this.mbRecurringMaxBillings==null && other.getMbRecurringMaxBillings()==null) || 
             (this.mbRecurringMaxBillings!=null &&
              this.mbRecurringMaxBillings.equals(other.getMbRecurringMaxBillings()))) &&
            ((this.mbRecurringFrequency==null && other.getMbRecurringFrequency()==null) || 
             (this.mbRecurringFrequency!=null &&
              this.mbRecurringFrequency.equals(other.getMbRecurringFrequency()))) &&
            ((this.mbMicroPaymentMaxDollarValue==null && other.getMbMicroPaymentMaxDollarValue()==null) || 
             (this.mbMicroPaymentMaxDollarValue!=null &&
              this.mbMicroPaymentMaxDollarValue.equals(other.getMbMicroPaymentMaxDollarValue()))) &&
            ((this.mbMicroPaymentMaxBillingDays==null && other.getMbMicroPaymentMaxBillingDays()==null) || 
             (this.mbMicroPaymentMaxBillingDays!=null &&
              this.mbMicroPaymentMaxBillingDays.equals(other.getMbMicroPaymentMaxBillingDays()))) &&
            ((this.mbMicroPaymentMaxTransactions==null && other.getMbMicroPaymentMaxTransactions()==null) || 
             (this.mbMicroPaymentMaxTransactions!=null &&
              this.mbMicroPaymentMaxTransactions.equals(other.getMbMicroPaymentMaxTransactions()))) &&
            ((this.mbDeferredBillDate==null && other.getMbDeferredBillDate()==null) || 
             (this.mbDeferredBillDate!=null &&
              this.mbDeferredBillDate.equals(other.getMbDeferredBillDate()))) &&
            ((this.mcSecureCodeAAV==null && other.getMcSecureCodeAAV()==null) || 
             (this.mcSecureCodeAAV!=null &&
              this.mcSecureCodeAAV.equals(other.getMcSecureCodeAAV()))) &&
            ((this.softDescMercName==null && other.getSoftDescMercName()==null) || 
             (this.softDescMercName!=null &&
              this.softDescMercName.equals(other.getSoftDescMercName()))) &&
            ((this.softDescProdDesc==null && other.getSoftDescProdDesc()==null) || 
             (this.softDescProdDesc!=null &&
              this.softDescProdDesc.equals(other.getSoftDescProdDesc()))) &&
            ((this.softDescMercCity==null && other.getSoftDescMercCity()==null) || 
             (this.softDescMercCity!=null &&
              this.softDescMercCity.equals(other.getSoftDescMercCity()))) &&
            ((this.softDescMercPhone==null && other.getSoftDescMercPhone()==null) || 
             (this.softDescMercPhone!=null &&
              this.softDescMercPhone.equals(other.getSoftDescMercPhone()))) &&
            ((this.softDescMercURL==null && other.getSoftDescMercURL()==null) || 
             (this.softDescMercURL!=null &&
              this.softDescMercURL.equals(other.getSoftDescMercURL()))) &&
            ((this.softDescMercEmail==null && other.getSoftDescMercEmail()==null) || 
             (this.softDescMercEmail!=null &&
              this.softDescMercEmail.equals(other.getSoftDescMercEmail()))) &&
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
              this.euddMandateType.equals(other.getEuddMandateType()))) &&
            ((this.status==null && other.getStatus()==null) || 
             (this.status!=null &&
              this.status.equals(other.getStatus()))) &&
            ((this.debitBillerReferenceNumber==null && other.getDebitBillerReferenceNumber()==null) || 
             (this.debitBillerReferenceNumber!=null &&
              this.debitBillerReferenceNumber.equals(other.getDebitBillerReferenceNumber()))) &&
            ((this.accountUpdaterEligibility==null && other.getAccountUpdaterEligibility()==null) || 
             (this.accountUpdaterEligibility!=null &&
              this.accountUpdaterEligibility.equals(other.getAccountUpdaterEligibility()))) &&
            ((this.dpanInd==null && other.getDpanInd()==null) || 
             (this.dpanInd!=null &&
              this.dpanInd.equals(other.getDpanInd())));
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
        if (getOrbitalConnectionUsername() != null) {
            _hashCode += getOrbitalConnectionUsername().hashCode();
        }
        if (getOrbitalConnectionPassword() != null) {
            _hashCode += getOrbitalConnectionPassword().hashCode();
        }
        if (getVersion() != null) {
            _hashCode += getVersion().hashCode();
        }
        if (getBin() != null) {
            _hashCode += getBin().hashCode();
        }
        if (getMerchantID() != null) {
            _hashCode += getMerchantID().hashCode();
        }
        if (getCustomerName() != null) {
            _hashCode += getCustomerName().hashCode();
        }
        if (getCustomerRefNum() != null) {
            _hashCode += getCustomerRefNum().hashCode();
        }
        if (getCustomerAddress1() != null) {
            _hashCode += getCustomerAddress1().hashCode();
        }
        if (getCustomerAddress2() != null) {
            _hashCode += getCustomerAddress2().hashCode();
        }
        if (getCustomerCity() != null) {
            _hashCode += getCustomerCity().hashCode();
        }
        if (getCustomerState() != null) {
            _hashCode += getCustomerState().hashCode();
        }
        if (getCustomerZIP() != null) {
            _hashCode += getCustomerZIP().hashCode();
        }
        if (getCustomerEmail() != null) {
            _hashCode += getCustomerEmail().hashCode();
        }
        if (getCustomerPhone() != null) {
            _hashCode += getCustomerPhone().hashCode();
        }
        if (getCustomerCountryCode() != null) {
            _hashCode += getCustomerCountryCode().hashCode();
        }
        if (getCustomerProfileOrderOverideInd() != null) {
            _hashCode += getCustomerProfileOrderOverideInd().hashCode();
        }
        if (getCustomerProfileFromOrderInd() != null) {
            _hashCode += getCustomerProfileFromOrderInd().hashCode();
        }
        if (getOrderDefaultDescription() != null) {
            _hashCode += getOrderDefaultDescription().hashCode();
        }
        if (getOrderDefaultAmount() != null) {
            _hashCode += getOrderDefaultAmount().hashCode();
        }
        if (getCustomerAccountType() != null) {
            _hashCode += getCustomerAccountType().hashCode();
        }
        if (getCcAccountNum() != null) {
            _hashCode += getCcAccountNum().hashCode();
        }
        if (getEncryptedPan() != null) {
            _hashCode += getEncryptedPan().hashCode();
        }
        if (getEncryptedPanMethod() != null) {
            _hashCode += getEncryptedPanMethod().hashCode();
        }
        if (getEncryptedPanKey() != null) {
            _hashCode += getEncryptedPanKey().hashCode();
        }
        if (getEncryptedPanPublicKeyFingerPrint() != null) {
            _hashCode += getEncryptedPanPublicKeyFingerPrint().hashCode();
        }
        if (getEncryptedPanHash() != null) {
            _hashCode += getEncryptedPanHash().hashCode();
        }
        if (getCcExp() != null) {
            _hashCode += getCcExp().hashCode();
        }
        if (getEcpCheckDDA() != null) {
            _hashCode += getEcpCheckDDA().hashCode();
        }
        if (getEcpBankAcctType() != null) {
            _hashCode += getEcpBankAcctType().hashCode();
        }
        if (getEcpCheckRT() != null) {
            _hashCode += getEcpCheckRT().hashCode();
        }
        if (getEcpDelvMethod() != null) {
            _hashCode += getEcpDelvMethod().hashCode();
        }
        if (getSwitchSoloCardStartDate() != null) {
            _hashCode += getSwitchSoloCardStartDate().hashCode();
        }
        if (getSwitchSoloIssueNum() != null) {
            _hashCode += getSwitchSoloIssueNum().hashCode();
        }
        if (getMbType() != null) {
            _hashCode += getMbType().hashCode();
        }
        if (getMbOrderIdGenerationMethod() != null) {
            _hashCode += getMbOrderIdGenerationMethod().hashCode();
        }
        if (getMbRecurringStartDate() != null) {
            _hashCode += getMbRecurringStartDate().hashCode();
        }
        if (getMbRecurringEndDate() != null) {
            _hashCode += getMbRecurringEndDate().hashCode();
        }
        if (getMbRecurringNoEndDateFlag() != null) {
            _hashCode += getMbRecurringNoEndDateFlag().hashCode();
        }
        if (getMbRecurringMaxBillings() != null) {
            _hashCode += getMbRecurringMaxBillings().hashCode();
        }
        if (getMbRecurringFrequency() != null) {
            _hashCode += getMbRecurringFrequency().hashCode();
        }
        if (getMbMicroPaymentMaxDollarValue() != null) {
            _hashCode += getMbMicroPaymentMaxDollarValue().hashCode();
        }
        if (getMbMicroPaymentMaxBillingDays() != null) {
            _hashCode += getMbMicroPaymentMaxBillingDays().hashCode();
        }
        if (getMbMicroPaymentMaxTransactions() != null) {
            _hashCode += getMbMicroPaymentMaxTransactions().hashCode();
        }
        if (getMbDeferredBillDate() != null) {
            _hashCode += getMbDeferredBillDate().hashCode();
        }
        if (getMcSecureCodeAAV() != null) {
            _hashCode += getMcSecureCodeAAV().hashCode();
        }
        if (getSoftDescMercName() != null) {
            _hashCode += getSoftDescMercName().hashCode();
        }
        if (getSoftDescProdDesc() != null) {
            _hashCode += getSoftDescProdDesc().hashCode();
        }
        if (getSoftDescMercCity() != null) {
            _hashCode += getSoftDescMercCity().hashCode();
        }
        if (getSoftDescMercPhone() != null) {
            _hashCode += getSoftDescMercPhone().hashCode();
        }
        if (getSoftDescMercURL() != null) {
            _hashCode += getSoftDescMercURL().hashCode();
        }
        if (getSoftDescMercEmail() != null) {
            _hashCode += getSoftDescMercEmail().hashCode();
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
        if (getStatus() != null) {
            _hashCode += getStatus().hashCode();
        }
        if (getDebitBillerReferenceNumber() != null) {
            _hashCode += getDebitBillerReferenceNumber().hashCode();
        }
        if (getAccountUpdaterEligibility() != null) {
            _hashCode += getAccountUpdaterEligibility().hashCode();
        }
        if (getDpanInd() != null) {
            _hashCode += getDpanInd().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ProfileAddElement.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "ProfileAddElement"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("orbitalConnectionUsername");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "orbitalConnectionUsername"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("orbitalConnectionPassword");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "orbitalConnectionPassword"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("version");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "version"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
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
        elemField.setFieldName("customerName");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "customerName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("customerRefNum");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "customerRefNum"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("customerAddress1");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "customerAddress1"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("customerAddress2");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "customerAddress2"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("customerCity");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "customerCity"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("customerState");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "customerState"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("customerZIP");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "customerZIP"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("customerEmail");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "customerEmail"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("customerPhone");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "customerPhone"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("customerCountryCode");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "customerCountryCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("customerProfileOrderOverideInd");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "customerProfileOrderOverideInd"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("customerProfileFromOrderInd");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "customerProfileFromOrderInd"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("orderDefaultDescription");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "orderDefaultDescription"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("orderDefaultAmount");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "orderDefaultAmount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("customerAccountType");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "customerAccountType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ccAccountNum");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "ccAccountNum"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("encryptedPan");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "encryptedPan"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("encryptedPanMethod");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "encryptedPanMethod"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("encryptedPanKey");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "encryptedPanKey"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("encryptedPanPublicKeyFingerPrint");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "encryptedPanPublicKeyFingerPrint"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("encryptedPanHash");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "encryptedPanHash"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ccExp");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "ccExp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ecpCheckDDA");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "ecpCheckDDA"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ecpBankAcctType");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "ecpBankAcctType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ecpCheckRT");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "ecpCheckRT"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ecpDelvMethod");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "ecpDelvMethod"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("switchSoloCardStartDate");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "switchSoloCardStartDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("switchSoloIssueNum");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "switchSoloIssueNum"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mbType");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "mbType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mbOrderIdGenerationMethod");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "mbOrderIdGenerationMethod"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mbRecurringStartDate");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "mbRecurringStartDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mbRecurringEndDate");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "mbRecurringEndDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mbRecurringNoEndDateFlag");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "mbRecurringNoEndDateFlag"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mbRecurringMaxBillings");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "mbRecurringMaxBillings"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mbRecurringFrequency");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "mbRecurringFrequency"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mbMicroPaymentMaxDollarValue");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "mbMicroPaymentMaxDollarValue"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mbMicroPaymentMaxBillingDays");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "mbMicroPaymentMaxBillingDays"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mbMicroPaymentMaxTransactions");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "mbMicroPaymentMaxTransactions"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mbDeferredBillDate");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "mbDeferredBillDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mcSecureCodeAAV");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "mcSecureCodeAAV"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("softDescMercName");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "softDescMercName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("softDescProdDesc");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "softDescProdDesc"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("softDescMercCity");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "softDescMercCity"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("softDescMercPhone");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "softDescMercPhone"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("softDescMercURL");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "softDescMercURL"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("softDescMercEmail");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "softDescMercEmail"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("euddBankSortCode");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "euddBankSortCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("euddCountryCode");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "euddCountryCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("euddRibCode");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "euddRibCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("euddBankBranchCode");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "euddBankBranchCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("euddIBAN");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "euddIBAN"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("euddBIC");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "euddBIC"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("euddMandateSignatureDate");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "euddMandateSignatureDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("euddMandateID");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "euddMandateID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("euddMandateType");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "euddMandateType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("status");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "status"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("debitBillerReferenceNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "debitBillerReferenceNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("accountUpdaterEligibility");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "accountUpdaterEligibility"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dpanInd");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "dpanInd"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
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
