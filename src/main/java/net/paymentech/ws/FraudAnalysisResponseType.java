/**
 * FraudAnalysisResponseType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package net.paymentech.ws;

public class FraudAnalysisResponseType  implements java.io.Serializable {
    private java.lang.String fraudScoreIndicator;

    private java.lang.String fraudStatusCode;

    private java.lang.String riskInquiryTransactionID;

    private java.lang.String autoDecisionResponse;

    private java.lang.String riskScore;

    private java.lang.String kaptchaMatchFlag;

    private java.lang.String worstCountry;

    private java.lang.String customerRegion;

    private java.lang.String paymentBrand;

    private java.lang.String fourteenDayVelocity;

    private java.lang.String sixHourVelocity;

    private java.lang.String customerNetwork;

    private java.lang.String numberOfDevices;

    private java.lang.String numberOfCards;

    private java.lang.String numberOfEmails;

    private java.lang.String deviceLayers;

    private java.lang.String deviceFingerprint;

    private java.lang.String customerTimeZone;

    private java.lang.String customerLocalDateTime;

    private java.lang.String deviceRegion;

    private java.lang.String deviceCountry;

    private java.lang.String proxyStatus;

    private java.lang.String javascriptStatus;

    private java.lang.String flashStatus;

    private java.lang.String cookiesStatus;

    private java.lang.String browserCountry;

    private java.lang.String browserLanguage;

    private java.lang.String mobileDeviceIndicator;

    private java.lang.String mobileDeviceType;

    private java.lang.String mobileWirelessIndicator;

    private java.lang.String voiceDevice;

    private java.lang.String pcRemoteIndicator;

    private java.lang.String rulesDataLength;

    private java.lang.String rulesData;

    public FraudAnalysisResponseType() {
    }

    public FraudAnalysisResponseType(
           java.lang.String fraudScoreIndicator,
           java.lang.String fraudStatusCode,
           java.lang.String riskInquiryTransactionID,
           java.lang.String autoDecisionResponse,
           java.lang.String riskScore,
           java.lang.String kaptchaMatchFlag,
           java.lang.String worstCountry,
           java.lang.String customerRegion,
           java.lang.String paymentBrand,
           java.lang.String fourteenDayVelocity,
           java.lang.String sixHourVelocity,
           java.lang.String customerNetwork,
           java.lang.String numberOfDevices,
           java.lang.String numberOfCards,
           java.lang.String numberOfEmails,
           java.lang.String deviceLayers,
           java.lang.String deviceFingerprint,
           java.lang.String customerTimeZone,
           java.lang.String customerLocalDateTime,
           java.lang.String deviceRegion,
           java.lang.String deviceCountry,
           java.lang.String proxyStatus,
           java.lang.String javascriptStatus,
           java.lang.String flashStatus,
           java.lang.String cookiesStatus,
           java.lang.String browserCountry,
           java.lang.String browserLanguage,
           java.lang.String mobileDeviceIndicator,
           java.lang.String mobileDeviceType,
           java.lang.String mobileWirelessIndicator,
           java.lang.String voiceDevice,
           java.lang.String pcRemoteIndicator,
           java.lang.String rulesDataLength,
           java.lang.String rulesData) {
           this.fraudScoreIndicator = fraudScoreIndicator;
           this.fraudStatusCode = fraudStatusCode;
           this.riskInquiryTransactionID = riskInquiryTransactionID;
           this.autoDecisionResponse = autoDecisionResponse;
           this.riskScore = riskScore;
           this.kaptchaMatchFlag = kaptchaMatchFlag;
           this.worstCountry = worstCountry;
           this.customerRegion = customerRegion;
           this.paymentBrand = paymentBrand;
           this.fourteenDayVelocity = fourteenDayVelocity;
           this.sixHourVelocity = sixHourVelocity;
           this.customerNetwork = customerNetwork;
           this.numberOfDevices = numberOfDevices;
           this.numberOfCards = numberOfCards;
           this.numberOfEmails = numberOfEmails;
           this.deviceLayers = deviceLayers;
           this.deviceFingerprint = deviceFingerprint;
           this.customerTimeZone = customerTimeZone;
           this.customerLocalDateTime = customerLocalDateTime;
           this.deviceRegion = deviceRegion;
           this.deviceCountry = deviceCountry;
           this.proxyStatus = proxyStatus;
           this.javascriptStatus = javascriptStatus;
           this.flashStatus = flashStatus;
           this.cookiesStatus = cookiesStatus;
           this.browserCountry = browserCountry;
           this.browserLanguage = browserLanguage;
           this.mobileDeviceIndicator = mobileDeviceIndicator;
           this.mobileDeviceType = mobileDeviceType;
           this.mobileWirelessIndicator = mobileWirelessIndicator;
           this.voiceDevice = voiceDevice;
           this.pcRemoteIndicator = pcRemoteIndicator;
           this.rulesDataLength = rulesDataLength;
           this.rulesData = rulesData;
    }


    /**
     * Gets the fraudScoreIndicator value for this FraudAnalysisResponseType.
     * 
     * @return fraudScoreIndicator
     */
    public java.lang.String getFraudScoreIndicator() {
        return fraudScoreIndicator;
    }


    /**
     * Sets the fraudScoreIndicator value for this FraudAnalysisResponseType.
     * 
     * @param fraudScoreIndicator
     */
    public void setFraudScoreIndicator(java.lang.String fraudScoreIndicator) {
        this.fraudScoreIndicator = fraudScoreIndicator;
    }


    /**
     * Gets the fraudStatusCode value for this FraudAnalysisResponseType.
     * 
     * @return fraudStatusCode
     */
    public java.lang.String getFraudStatusCode() {
        return fraudStatusCode;
    }


    /**
     * Sets the fraudStatusCode value for this FraudAnalysisResponseType.
     * 
     * @param fraudStatusCode
     */
    public void setFraudStatusCode(java.lang.String fraudStatusCode) {
        this.fraudStatusCode = fraudStatusCode;
    }


    /**
     * Gets the riskInquiryTransactionID value for this FraudAnalysisResponseType.
     * 
     * @return riskInquiryTransactionID
     */
    public java.lang.String getRiskInquiryTransactionID() {
        return riskInquiryTransactionID;
    }


    /**
     * Sets the riskInquiryTransactionID value for this FraudAnalysisResponseType.
     * 
     * @param riskInquiryTransactionID
     */
    public void setRiskInquiryTransactionID(java.lang.String riskInquiryTransactionID) {
        this.riskInquiryTransactionID = riskInquiryTransactionID;
    }


    /**
     * Gets the autoDecisionResponse value for this FraudAnalysisResponseType.
     * 
     * @return autoDecisionResponse
     */
    public java.lang.String getAutoDecisionResponse() {
        return autoDecisionResponse;
    }


    /**
     * Sets the autoDecisionResponse value for this FraudAnalysisResponseType.
     * 
     * @param autoDecisionResponse
     */
    public void setAutoDecisionResponse(java.lang.String autoDecisionResponse) {
        this.autoDecisionResponse = autoDecisionResponse;
    }


    /**
     * Gets the riskScore value for this FraudAnalysisResponseType.
     * 
     * @return riskScore
     */
    public java.lang.String getRiskScore() {
        return riskScore;
    }


    /**
     * Sets the riskScore value for this FraudAnalysisResponseType.
     * 
     * @param riskScore
     */
    public void setRiskScore(java.lang.String riskScore) {
        this.riskScore = riskScore;
    }


    /**
     * Gets the kaptchaMatchFlag value for this FraudAnalysisResponseType.
     * 
     * @return kaptchaMatchFlag
     */
    public java.lang.String getKaptchaMatchFlag() {
        return kaptchaMatchFlag;
    }


    /**
     * Sets the kaptchaMatchFlag value for this FraudAnalysisResponseType.
     * 
     * @param kaptchaMatchFlag
     */
    public void setKaptchaMatchFlag(java.lang.String kaptchaMatchFlag) {
        this.kaptchaMatchFlag = kaptchaMatchFlag;
    }


    /**
     * Gets the worstCountry value for this FraudAnalysisResponseType.
     * 
     * @return worstCountry
     */
    public java.lang.String getWorstCountry() {
        return worstCountry;
    }


    /**
     * Sets the worstCountry value for this FraudAnalysisResponseType.
     * 
     * @param worstCountry
     */
    public void setWorstCountry(java.lang.String worstCountry) {
        this.worstCountry = worstCountry;
    }


    /**
     * Gets the customerRegion value for this FraudAnalysisResponseType.
     * 
     * @return customerRegion
     */
    public java.lang.String getCustomerRegion() {
        return customerRegion;
    }


    /**
     * Sets the customerRegion value for this FraudAnalysisResponseType.
     * 
     * @param customerRegion
     */
    public void setCustomerRegion(java.lang.String customerRegion) {
        this.customerRegion = customerRegion;
    }


    /**
     * Gets the paymentBrand value for this FraudAnalysisResponseType.
     * 
     * @return paymentBrand
     */
    public java.lang.String getPaymentBrand() {
        return paymentBrand;
    }


    /**
     * Sets the paymentBrand value for this FraudAnalysisResponseType.
     * 
     * @param paymentBrand
     */
    public void setPaymentBrand(java.lang.String paymentBrand) {
        this.paymentBrand = paymentBrand;
    }


    /**
     * Gets the fourteenDayVelocity value for this FraudAnalysisResponseType.
     * 
     * @return fourteenDayVelocity
     */
    public java.lang.String getFourteenDayVelocity() {
        return fourteenDayVelocity;
    }


    /**
     * Sets the fourteenDayVelocity value for this FraudAnalysisResponseType.
     * 
     * @param fourteenDayVelocity
     */
    public void setFourteenDayVelocity(java.lang.String fourteenDayVelocity) {
        this.fourteenDayVelocity = fourteenDayVelocity;
    }


    /**
     * Gets the sixHourVelocity value for this FraudAnalysisResponseType.
     * 
     * @return sixHourVelocity
     */
    public java.lang.String getSixHourVelocity() {
        return sixHourVelocity;
    }


    /**
     * Sets the sixHourVelocity value for this FraudAnalysisResponseType.
     * 
     * @param sixHourVelocity
     */
    public void setSixHourVelocity(java.lang.String sixHourVelocity) {
        this.sixHourVelocity = sixHourVelocity;
    }


    /**
     * Gets the customerNetwork value for this FraudAnalysisResponseType.
     * 
     * @return customerNetwork
     */
    public java.lang.String getCustomerNetwork() {
        return customerNetwork;
    }


    /**
     * Sets the customerNetwork value for this FraudAnalysisResponseType.
     * 
     * @param customerNetwork
     */
    public void setCustomerNetwork(java.lang.String customerNetwork) {
        this.customerNetwork = customerNetwork;
    }


    /**
     * Gets the numberOfDevices value for this FraudAnalysisResponseType.
     * 
     * @return numberOfDevices
     */
    public java.lang.String getNumberOfDevices() {
        return numberOfDevices;
    }


    /**
     * Sets the numberOfDevices value for this FraudAnalysisResponseType.
     * 
     * @param numberOfDevices
     */
    public void setNumberOfDevices(java.lang.String numberOfDevices) {
        this.numberOfDevices = numberOfDevices;
    }


    /**
     * Gets the numberOfCards value for this FraudAnalysisResponseType.
     * 
     * @return numberOfCards
     */
    public java.lang.String getNumberOfCards() {
        return numberOfCards;
    }


    /**
     * Sets the numberOfCards value for this FraudAnalysisResponseType.
     * 
     * @param numberOfCards
     */
    public void setNumberOfCards(java.lang.String numberOfCards) {
        this.numberOfCards = numberOfCards;
    }


    /**
     * Gets the numberOfEmails value for this FraudAnalysisResponseType.
     * 
     * @return numberOfEmails
     */
    public java.lang.String getNumberOfEmails() {
        return numberOfEmails;
    }


    /**
     * Sets the numberOfEmails value for this FraudAnalysisResponseType.
     * 
     * @param numberOfEmails
     */
    public void setNumberOfEmails(java.lang.String numberOfEmails) {
        this.numberOfEmails = numberOfEmails;
    }


    /**
     * Gets the deviceLayers value for this FraudAnalysisResponseType.
     * 
     * @return deviceLayers
     */
    public java.lang.String getDeviceLayers() {
        return deviceLayers;
    }


    /**
     * Sets the deviceLayers value for this FraudAnalysisResponseType.
     * 
     * @param deviceLayers
     */
    public void setDeviceLayers(java.lang.String deviceLayers) {
        this.deviceLayers = deviceLayers;
    }


    /**
     * Gets the deviceFingerprint value for this FraudAnalysisResponseType.
     * 
     * @return deviceFingerprint
     */
    public java.lang.String getDeviceFingerprint() {
        return deviceFingerprint;
    }


    /**
     * Sets the deviceFingerprint value for this FraudAnalysisResponseType.
     * 
     * @param deviceFingerprint
     */
    public void setDeviceFingerprint(java.lang.String deviceFingerprint) {
        this.deviceFingerprint = deviceFingerprint;
    }


    /**
     * Gets the customerTimeZone value for this FraudAnalysisResponseType.
     * 
     * @return customerTimeZone
     */
    public java.lang.String getCustomerTimeZone() {
        return customerTimeZone;
    }


    /**
     * Sets the customerTimeZone value for this FraudAnalysisResponseType.
     * 
     * @param customerTimeZone
     */
    public void setCustomerTimeZone(java.lang.String customerTimeZone) {
        this.customerTimeZone = customerTimeZone;
    }


    /**
     * Gets the customerLocalDateTime value for this FraudAnalysisResponseType.
     * 
     * @return customerLocalDateTime
     */
    public java.lang.String getCustomerLocalDateTime() {
        return customerLocalDateTime;
    }


    /**
     * Sets the customerLocalDateTime value for this FraudAnalysisResponseType.
     * 
     * @param customerLocalDateTime
     */
    public void setCustomerLocalDateTime(java.lang.String customerLocalDateTime) {
        this.customerLocalDateTime = customerLocalDateTime;
    }


    /**
     * Gets the deviceRegion value for this FraudAnalysisResponseType.
     * 
     * @return deviceRegion
     */
    public java.lang.String getDeviceRegion() {
        return deviceRegion;
    }


    /**
     * Sets the deviceRegion value for this FraudAnalysisResponseType.
     * 
     * @param deviceRegion
     */
    public void setDeviceRegion(java.lang.String deviceRegion) {
        this.deviceRegion = deviceRegion;
    }


    /**
     * Gets the deviceCountry value for this FraudAnalysisResponseType.
     * 
     * @return deviceCountry
     */
    public java.lang.String getDeviceCountry() {
        return deviceCountry;
    }


    /**
     * Sets the deviceCountry value for this FraudAnalysisResponseType.
     * 
     * @param deviceCountry
     */
    public void setDeviceCountry(java.lang.String deviceCountry) {
        this.deviceCountry = deviceCountry;
    }


    /**
     * Gets the proxyStatus value for this FraudAnalysisResponseType.
     * 
     * @return proxyStatus
     */
    public java.lang.String getProxyStatus() {
        return proxyStatus;
    }


    /**
     * Sets the proxyStatus value for this FraudAnalysisResponseType.
     * 
     * @param proxyStatus
     */
    public void setProxyStatus(java.lang.String proxyStatus) {
        this.proxyStatus = proxyStatus;
    }


    /**
     * Gets the javascriptStatus value for this FraudAnalysisResponseType.
     * 
     * @return javascriptStatus
     */
    public java.lang.String getJavascriptStatus() {
        return javascriptStatus;
    }


    /**
     * Sets the javascriptStatus value for this FraudAnalysisResponseType.
     * 
     * @param javascriptStatus
     */
    public void setJavascriptStatus(java.lang.String javascriptStatus) {
        this.javascriptStatus = javascriptStatus;
    }


    /**
     * Gets the flashStatus value for this FraudAnalysisResponseType.
     * 
     * @return flashStatus
     */
    public java.lang.String getFlashStatus() {
        return flashStatus;
    }


    /**
     * Sets the flashStatus value for this FraudAnalysisResponseType.
     * 
     * @param flashStatus
     */
    public void setFlashStatus(java.lang.String flashStatus) {
        this.flashStatus = flashStatus;
    }


    /**
     * Gets the cookiesStatus value for this FraudAnalysisResponseType.
     * 
     * @return cookiesStatus
     */
    public java.lang.String getCookiesStatus() {
        return cookiesStatus;
    }


    /**
     * Sets the cookiesStatus value for this FraudAnalysisResponseType.
     * 
     * @param cookiesStatus
     */
    public void setCookiesStatus(java.lang.String cookiesStatus) {
        this.cookiesStatus = cookiesStatus;
    }


    /**
     * Gets the browserCountry value for this FraudAnalysisResponseType.
     * 
     * @return browserCountry
     */
    public java.lang.String getBrowserCountry() {
        return browserCountry;
    }


    /**
     * Sets the browserCountry value for this FraudAnalysisResponseType.
     * 
     * @param browserCountry
     */
    public void setBrowserCountry(java.lang.String browserCountry) {
        this.browserCountry = browserCountry;
    }


    /**
     * Gets the browserLanguage value for this FraudAnalysisResponseType.
     * 
     * @return browserLanguage
     */
    public java.lang.String getBrowserLanguage() {
        return browserLanguage;
    }


    /**
     * Sets the browserLanguage value for this FraudAnalysisResponseType.
     * 
     * @param browserLanguage
     */
    public void setBrowserLanguage(java.lang.String browserLanguage) {
        this.browserLanguage = browserLanguage;
    }


    /**
     * Gets the mobileDeviceIndicator value for this FraudAnalysisResponseType.
     * 
     * @return mobileDeviceIndicator
     */
    public java.lang.String getMobileDeviceIndicator() {
        return mobileDeviceIndicator;
    }


    /**
     * Sets the mobileDeviceIndicator value for this FraudAnalysisResponseType.
     * 
     * @param mobileDeviceIndicator
     */
    public void setMobileDeviceIndicator(java.lang.String mobileDeviceIndicator) {
        this.mobileDeviceIndicator = mobileDeviceIndicator;
    }


    /**
     * Gets the mobileDeviceType value for this FraudAnalysisResponseType.
     * 
     * @return mobileDeviceType
     */
    public java.lang.String getMobileDeviceType() {
        return mobileDeviceType;
    }


    /**
     * Sets the mobileDeviceType value for this FraudAnalysisResponseType.
     * 
     * @param mobileDeviceType
     */
    public void setMobileDeviceType(java.lang.String mobileDeviceType) {
        this.mobileDeviceType = mobileDeviceType;
    }


    /**
     * Gets the mobileWirelessIndicator value for this FraudAnalysisResponseType.
     * 
     * @return mobileWirelessIndicator
     */
    public java.lang.String getMobileWirelessIndicator() {
        return mobileWirelessIndicator;
    }


    /**
     * Sets the mobileWirelessIndicator value for this FraudAnalysisResponseType.
     * 
     * @param mobileWirelessIndicator
     */
    public void setMobileWirelessIndicator(java.lang.String mobileWirelessIndicator) {
        this.mobileWirelessIndicator = mobileWirelessIndicator;
    }


    /**
     * Gets the voiceDevice value for this FraudAnalysisResponseType.
     * 
     * @return voiceDevice
     */
    public java.lang.String getVoiceDevice() {
        return voiceDevice;
    }


    /**
     * Sets the voiceDevice value for this FraudAnalysisResponseType.
     * 
     * @param voiceDevice
     */
    public void setVoiceDevice(java.lang.String voiceDevice) {
        this.voiceDevice = voiceDevice;
    }


    /**
     * Gets the pcRemoteIndicator value for this FraudAnalysisResponseType.
     * 
     * @return pcRemoteIndicator
     */
    public java.lang.String getPcRemoteIndicator() {
        return pcRemoteIndicator;
    }


    /**
     * Sets the pcRemoteIndicator value for this FraudAnalysisResponseType.
     * 
     * @param pcRemoteIndicator
     */
    public void setPcRemoteIndicator(java.lang.String pcRemoteIndicator) {
        this.pcRemoteIndicator = pcRemoteIndicator;
    }


    /**
     * Gets the rulesDataLength value for this FraudAnalysisResponseType.
     * 
     * @return rulesDataLength
     */
    public java.lang.String getRulesDataLength() {
        return rulesDataLength;
    }


    /**
     * Sets the rulesDataLength value for this FraudAnalysisResponseType.
     * 
     * @param rulesDataLength
     */
    public void setRulesDataLength(java.lang.String rulesDataLength) {
        this.rulesDataLength = rulesDataLength;
    }


    /**
     * Gets the rulesData value for this FraudAnalysisResponseType.
     * 
     * @return rulesData
     */
    public java.lang.String getRulesData() {
        return rulesData;
    }


    /**
     * Sets the rulesData value for this FraudAnalysisResponseType.
     * 
     * @param rulesData
     */
    public void setRulesData(java.lang.String rulesData) {
        this.rulesData = rulesData;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof FraudAnalysisResponseType)) return false;
        FraudAnalysisResponseType other = (FraudAnalysisResponseType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.fraudScoreIndicator==null && other.getFraudScoreIndicator()==null) || 
             (this.fraudScoreIndicator!=null &&
              this.fraudScoreIndicator.equals(other.getFraudScoreIndicator()))) &&
            ((this.fraudStatusCode==null && other.getFraudStatusCode()==null) || 
             (this.fraudStatusCode!=null &&
              this.fraudStatusCode.equals(other.getFraudStatusCode()))) &&
            ((this.riskInquiryTransactionID==null && other.getRiskInquiryTransactionID()==null) || 
             (this.riskInquiryTransactionID!=null &&
              this.riskInquiryTransactionID.equals(other.getRiskInquiryTransactionID()))) &&
            ((this.autoDecisionResponse==null && other.getAutoDecisionResponse()==null) || 
             (this.autoDecisionResponse!=null &&
              this.autoDecisionResponse.equals(other.getAutoDecisionResponse()))) &&
            ((this.riskScore==null && other.getRiskScore()==null) || 
             (this.riskScore!=null &&
              this.riskScore.equals(other.getRiskScore()))) &&
            ((this.kaptchaMatchFlag==null && other.getKaptchaMatchFlag()==null) || 
             (this.kaptchaMatchFlag!=null &&
              this.kaptchaMatchFlag.equals(other.getKaptchaMatchFlag()))) &&
            ((this.worstCountry==null && other.getWorstCountry()==null) || 
             (this.worstCountry!=null &&
              this.worstCountry.equals(other.getWorstCountry()))) &&
            ((this.customerRegion==null && other.getCustomerRegion()==null) || 
             (this.customerRegion!=null &&
              this.customerRegion.equals(other.getCustomerRegion()))) &&
            ((this.paymentBrand==null && other.getPaymentBrand()==null) || 
             (this.paymentBrand!=null &&
              this.paymentBrand.equals(other.getPaymentBrand()))) &&
            ((this.fourteenDayVelocity==null && other.getFourteenDayVelocity()==null) || 
             (this.fourteenDayVelocity!=null &&
              this.fourteenDayVelocity.equals(other.getFourteenDayVelocity()))) &&
            ((this.sixHourVelocity==null && other.getSixHourVelocity()==null) || 
             (this.sixHourVelocity!=null &&
              this.sixHourVelocity.equals(other.getSixHourVelocity()))) &&
            ((this.customerNetwork==null && other.getCustomerNetwork()==null) || 
             (this.customerNetwork!=null &&
              this.customerNetwork.equals(other.getCustomerNetwork()))) &&
            ((this.numberOfDevices==null && other.getNumberOfDevices()==null) || 
             (this.numberOfDevices!=null &&
              this.numberOfDevices.equals(other.getNumberOfDevices()))) &&
            ((this.numberOfCards==null && other.getNumberOfCards()==null) || 
             (this.numberOfCards!=null &&
              this.numberOfCards.equals(other.getNumberOfCards()))) &&
            ((this.numberOfEmails==null && other.getNumberOfEmails()==null) || 
             (this.numberOfEmails!=null &&
              this.numberOfEmails.equals(other.getNumberOfEmails()))) &&
            ((this.deviceLayers==null && other.getDeviceLayers()==null) || 
             (this.deviceLayers!=null &&
              this.deviceLayers.equals(other.getDeviceLayers()))) &&
            ((this.deviceFingerprint==null && other.getDeviceFingerprint()==null) || 
             (this.deviceFingerprint!=null &&
              this.deviceFingerprint.equals(other.getDeviceFingerprint()))) &&
            ((this.customerTimeZone==null && other.getCustomerTimeZone()==null) || 
             (this.customerTimeZone!=null &&
              this.customerTimeZone.equals(other.getCustomerTimeZone()))) &&
            ((this.customerLocalDateTime==null && other.getCustomerLocalDateTime()==null) || 
             (this.customerLocalDateTime!=null &&
              this.customerLocalDateTime.equals(other.getCustomerLocalDateTime()))) &&
            ((this.deviceRegion==null && other.getDeviceRegion()==null) || 
             (this.deviceRegion!=null &&
              this.deviceRegion.equals(other.getDeviceRegion()))) &&
            ((this.deviceCountry==null && other.getDeviceCountry()==null) || 
             (this.deviceCountry!=null &&
              this.deviceCountry.equals(other.getDeviceCountry()))) &&
            ((this.proxyStatus==null && other.getProxyStatus()==null) || 
             (this.proxyStatus!=null &&
              this.proxyStatus.equals(other.getProxyStatus()))) &&
            ((this.javascriptStatus==null && other.getJavascriptStatus()==null) || 
             (this.javascriptStatus!=null &&
              this.javascriptStatus.equals(other.getJavascriptStatus()))) &&
            ((this.flashStatus==null && other.getFlashStatus()==null) || 
             (this.flashStatus!=null &&
              this.flashStatus.equals(other.getFlashStatus()))) &&
            ((this.cookiesStatus==null && other.getCookiesStatus()==null) || 
             (this.cookiesStatus!=null &&
              this.cookiesStatus.equals(other.getCookiesStatus()))) &&
            ((this.browserCountry==null && other.getBrowserCountry()==null) || 
             (this.browserCountry!=null &&
              this.browserCountry.equals(other.getBrowserCountry()))) &&
            ((this.browserLanguage==null && other.getBrowserLanguage()==null) || 
             (this.browserLanguage!=null &&
              this.browserLanguage.equals(other.getBrowserLanguage()))) &&
            ((this.mobileDeviceIndicator==null && other.getMobileDeviceIndicator()==null) || 
             (this.mobileDeviceIndicator!=null &&
              this.mobileDeviceIndicator.equals(other.getMobileDeviceIndicator()))) &&
            ((this.mobileDeviceType==null && other.getMobileDeviceType()==null) || 
             (this.mobileDeviceType!=null &&
              this.mobileDeviceType.equals(other.getMobileDeviceType()))) &&
            ((this.mobileWirelessIndicator==null && other.getMobileWirelessIndicator()==null) || 
             (this.mobileWirelessIndicator!=null &&
              this.mobileWirelessIndicator.equals(other.getMobileWirelessIndicator()))) &&
            ((this.voiceDevice==null && other.getVoiceDevice()==null) || 
             (this.voiceDevice!=null &&
              this.voiceDevice.equals(other.getVoiceDevice()))) &&
            ((this.pcRemoteIndicator==null && other.getPcRemoteIndicator()==null) || 
             (this.pcRemoteIndicator!=null &&
              this.pcRemoteIndicator.equals(other.getPcRemoteIndicator()))) &&
            ((this.rulesDataLength==null && other.getRulesDataLength()==null) || 
             (this.rulesDataLength!=null &&
              this.rulesDataLength.equals(other.getRulesDataLength()))) &&
            ((this.rulesData==null && other.getRulesData()==null) || 
             (this.rulesData!=null &&
              this.rulesData.equals(other.getRulesData())));
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
        if (getFraudScoreIndicator() != null) {
            _hashCode += getFraudScoreIndicator().hashCode();
        }
        if (getFraudStatusCode() != null) {
            _hashCode += getFraudStatusCode().hashCode();
        }
        if (getRiskInquiryTransactionID() != null) {
            _hashCode += getRiskInquiryTransactionID().hashCode();
        }
        if (getAutoDecisionResponse() != null) {
            _hashCode += getAutoDecisionResponse().hashCode();
        }
        if (getRiskScore() != null) {
            _hashCode += getRiskScore().hashCode();
        }
        if (getKaptchaMatchFlag() != null) {
            _hashCode += getKaptchaMatchFlag().hashCode();
        }
        if (getWorstCountry() != null) {
            _hashCode += getWorstCountry().hashCode();
        }
        if (getCustomerRegion() != null) {
            _hashCode += getCustomerRegion().hashCode();
        }
        if (getPaymentBrand() != null) {
            _hashCode += getPaymentBrand().hashCode();
        }
        if (getFourteenDayVelocity() != null) {
            _hashCode += getFourteenDayVelocity().hashCode();
        }
        if (getSixHourVelocity() != null) {
            _hashCode += getSixHourVelocity().hashCode();
        }
        if (getCustomerNetwork() != null) {
            _hashCode += getCustomerNetwork().hashCode();
        }
        if (getNumberOfDevices() != null) {
            _hashCode += getNumberOfDevices().hashCode();
        }
        if (getNumberOfCards() != null) {
            _hashCode += getNumberOfCards().hashCode();
        }
        if (getNumberOfEmails() != null) {
            _hashCode += getNumberOfEmails().hashCode();
        }
        if (getDeviceLayers() != null) {
            _hashCode += getDeviceLayers().hashCode();
        }
        if (getDeviceFingerprint() != null) {
            _hashCode += getDeviceFingerprint().hashCode();
        }
        if (getCustomerTimeZone() != null) {
            _hashCode += getCustomerTimeZone().hashCode();
        }
        if (getCustomerLocalDateTime() != null) {
            _hashCode += getCustomerLocalDateTime().hashCode();
        }
        if (getDeviceRegion() != null) {
            _hashCode += getDeviceRegion().hashCode();
        }
        if (getDeviceCountry() != null) {
            _hashCode += getDeviceCountry().hashCode();
        }
        if (getProxyStatus() != null) {
            _hashCode += getProxyStatus().hashCode();
        }
        if (getJavascriptStatus() != null) {
            _hashCode += getJavascriptStatus().hashCode();
        }
        if (getFlashStatus() != null) {
            _hashCode += getFlashStatus().hashCode();
        }
        if (getCookiesStatus() != null) {
            _hashCode += getCookiesStatus().hashCode();
        }
        if (getBrowserCountry() != null) {
            _hashCode += getBrowserCountry().hashCode();
        }
        if (getBrowserLanguage() != null) {
            _hashCode += getBrowserLanguage().hashCode();
        }
        if (getMobileDeviceIndicator() != null) {
            _hashCode += getMobileDeviceIndicator().hashCode();
        }
        if (getMobileDeviceType() != null) {
            _hashCode += getMobileDeviceType().hashCode();
        }
        if (getMobileWirelessIndicator() != null) {
            _hashCode += getMobileWirelessIndicator().hashCode();
        }
        if (getVoiceDevice() != null) {
            _hashCode += getVoiceDevice().hashCode();
        }
        if (getPcRemoteIndicator() != null) {
            _hashCode += getPcRemoteIndicator().hashCode();
        }
        if (getRulesDataLength() != null) {
            _hashCode += getRulesDataLength().hashCode();
        }
        if (getRulesData() != null) {
            _hashCode += getRulesData().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(FraudAnalysisResponseType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "FraudAnalysisResponseType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fraudScoreIndicator");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "fraudScoreIndicator"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fraudStatusCode");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "fraudStatusCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("riskInquiryTransactionID");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "riskInquiryTransactionID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("autoDecisionResponse");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "autoDecisionResponse"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("riskScore");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "riskScore"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("kaptchaMatchFlag");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "kaptchaMatchFlag"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("worstCountry");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "worstCountry"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("customerRegion");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "customerRegion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("paymentBrand");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "paymentBrand"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fourteenDayVelocity");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "fourteenDayVelocity"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sixHourVelocity");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "sixHourVelocity"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("customerNetwork");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "customerNetwork"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numberOfDevices");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "numberOfDevices"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numberOfCards");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "numberOfCards"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numberOfEmails");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "numberOfEmails"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("deviceLayers");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "deviceLayers"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("deviceFingerprint");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "deviceFingerprint"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("customerTimeZone");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "customerTimeZone"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("customerLocalDateTime");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "customerLocalDateTime"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("deviceRegion");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "deviceRegion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("deviceCountry");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "deviceCountry"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("proxyStatus");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "proxyStatus"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("javascriptStatus");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "javascriptStatus"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("flashStatus");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "flashStatus"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cookiesStatus");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "cookiesStatus"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("browserCountry");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "browserCountry"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("browserLanguage");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "browserLanguage"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mobileDeviceIndicator");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "mobileDeviceIndicator"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mobileDeviceType");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "mobileDeviceType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mobileWirelessIndicator");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "mobileWirelessIndicator"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("voiceDevice");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "voiceDevice"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pcRemoteIndicator");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "pcRemoteIndicator"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("rulesDataLength");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "rulesDataLength"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("rulesData");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "rulesData"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
