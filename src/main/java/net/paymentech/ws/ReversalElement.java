/**
 * ReversalElement.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package net.paymentech.ws;

public class ReversalElement  implements java.io.Serializable {
    private java.lang.String orbitalConnectionUsername;

    private java.lang.String orbitalConnectionPassword;

    private java.lang.String version;

    private java.lang.String txRefNum;

    private java.lang.String txRefIdx;

    private java.lang.String adjustedAmount;

    private java.lang.String orderID;

    private java.lang.String bin;

    private java.lang.String merchantID;

    private java.lang.String terminalID;

    private java.lang.String reversalRetryNumber;

    private java.lang.String retryTrace;

    private java.lang.String onlineReversalInd;

    private java.lang.String latitudeLongitude;

    private java.lang.String politicalTimeZone;

    private java.lang.String vendorID;

    private java.lang.String softwareID;

    private java.lang.String mobileDeviceType;

    private java.lang.String deviceID;

    private java.lang.String localDateTime;

    private java.lang.String readerSerialNumber;

    private java.lang.String chipCardData;

    private java.lang.String emvSupport;

    private java.lang.String peripheralSupport;

    private java.lang.String communicationSupport;

    private java.lang.String industrySupport;

    private java.lang.String complianceClass;

    private java.lang.String deviceSecuritySupport;

    public ReversalElement() {
    }

    public ReversalElement(
           java.lang.String orbitalConnectionUsername,
           java.lang.String orbitalConnectionPassword,
           java.lang.String version,
           java.lang.String txRefNum,
           java.lang.String txRefIdx,
           java.lang.String adjustedAmount,
           java.lang.String orderID,
           java.lang.String bin,
           java.lang.String merchantID,
           java.lang.String terminalID,
           java.lang.String reversalRetryNumber,
           java.lang.String retryTrace,
           java.lang.String onlineReversalInd,
           java.lang.String latitudeLongitude,
           java.lang.String politicalTimeZone,
           java.lang.String vendorID,
           java.lang.String softwareID,
           java.lang.String mobileDeviceType,
           java.lang.String deviceID,
           java.lang.String localDateTime,
           java.lang.String readerSerialNumber,
           java.lang.String chipCardData,
           java.lang.String emvSupport,
           java.lang.String peripheralSupport,
           java.lang.String communicationSupport,
           java.lang.String industrySupport,
           java.lang.String complianceClass,
           java.lang.String deviceSecuritySupport) {
           this.orbitalConnectionUsername = orbitalConnectionUsername;
           this.orbitalConnectionPassword = orbitalConnectionPassword;
           this.version = version;
           this.txRefNum = txRefNum;
           this.txRefIdx = txRefIdx;
           this.adjustedAmount = adjustedAmount;
           this.orderID = orderID;
           this.bin = bin;
           this.merchantID = merchantID;
           this.terminalID = terminalID;
           this.reversalRetryNumber = reversalRetryNumber;
           this.retryTrace = retryTrace;
           this.onlineReversalInd = onlineReversalInd;
           this.latitudeLongitude = latitudeLongitude;
           this.politicalTimeZone = politicalTimeZone;
           this.vendorID = vendorID;
           this.softwareID = softwareID;
           this.mobileDeviceType = mobileDeviceType;
           this.deviceID = deviceID;
           this.localDateTime = localDateTime;
           this.readerSerialNumber = readerSerialNumber;
           this.chipCardData = chipCardData;
           this.emvSupport = emvSupport;
           this.peripheralSupport = peripheralSupport;
           this.communicationSupport = communicationSupport;
           this.industrySupport = industrySupport;
           this.complianceClass = complianceClass;
           this.deviceSecuritySupport = deviceSecuritySupport;
    }


    /**
     * Gets the orbitalConnectionUsername value for this ReversalElement.
     * 
     * @return orbitalConnectionUsername
     */
    public java.lang.String getOrbitalConnectionUsername() {
        return orbitalConnectionUsername;
    }


    /**
     * Sets the orbitalConnectionUsername value for this ReversalElement.
     * 
     * @param orbitalConnectionUsername
     */
    public void setOrbitalConnectionUsername(java.lang.String orbitalConnectionUsername) {
        this.orbitalConnectionUsername = orbitalConnectionUsername;
    }


    /**
     * Gets the orbitalConnectionPassword value for this ReversalElement.
     * 
     * @return orbitalConnectionPassword
     */
    public java.lang.String getOrbitalConnectionPassword() {
        return orbitalConnectionPassword;
    }


    /**
     * Sets the orbitalConnectionPassword value for this ReversalElement.
     * 
     * @param orbitalConnectionPassword
     */
    public void setOrbitalConnectionPassword(java.lang.String orbitalConnectionPassword) {
        this.orbitalConnectionPassword = orbitalConnectionPassword;
    }


    /**
     * Gets the version value for this ReversalElement.
     * 
     * @return version
     */
    public java.lang.String getVersion() {
        return version;
    }


    /**
     * Sets the version value for this ReversalElement.
     * 
     * @param version
     */
    public void setVersion(java.lang.String version) {
        this.version = version;
    }


    /**
     * Gets the txRefNum value for this ReversalElement.
     * 
     * @return txRefNum
     */
    public java.lang.String getTxRefNum() {
        return txRefNum;
    }


    /**
     * Sets the txRefNum value for this ReversalElement.
     * 
     * @param txRefNum
     */
    public void setTxRefNum(java.lang.String txRefNum) {
        this.txRefNum = txRefNum;
    }


    /**
     * Gets the txRefIdx value for this ReversalElement.
     * 
     * @return txRefIdx
     */
    public java.lang.String getTxRefIdx() {
        return txRefIdx;
    }


    /**
     * Sets the txRefIdx value for this ReversalElement.
     * 
     * @param txRefIdx
     */
    public void setTxRefIdx(java.lang.String txRefIdx) {
        this.txRefIdx = txRefIdx;
    }


    /**
     * Gets the adjustedAmount value for this ReversalElement.
     * 
     * @return adjustedAmount
     */
    public java.lang.String getAdjustedAmount() {
        return adjustedAmount;
    }


    /**
     * Sets the adjustedAmount value for this ReversalElement.
     * 
     * @param adjustedAmount
     */
    public void setAdjustedAmount(java.lang.String adjustedAmount) {
        this.adjustedAmount = adjustedAmount;
    }


    /**
     * Gets the orderID value for this ReversalElement.
     * 
     * @return orderID
     */
    public java.lang.String getOrderID() {
        return orderID;
    }


    /**
     * Sets the orderID value for this ReversalElement.
     * 
     * @param orderID
     */
    public void setOrderID(java.lang.String orderID) {
        this.orderID = orderID;
    }


    /**
     * Gets the bin value for this ReversalElement.
     * 
     * @return bin
     */
    public java.lang.String getBin() {
        return bin;
    }


    /**
     * Sets the bin value for this ReversalElement.
     * 
     * @param bin
     */
    public void setBin(java.lang.String bin) {
        this.bin = bin;
    }


    /**
     * Gets the merchantID value for this ReversalElement.
     * 
     * @return merchantID
     */
    public java.lang.String getMerchantID() {
        return merchantID;
    }


    /**
     * Sets the merchantID value for this ReversalElement.
     * 
     * @param merchantID
     */
    public void setMerchantID(java.lang.String merchantID) {
        this.merchantID = merchantID;
    }


    /**
     * Gets the terminalID value for this ReversalElement.
     * 
     * @return terminalID
     */
    public java.lang.String getTerminalID() {
        return terminalID;
    }


    /**
     * Sets the terminalID value for this ReversalElement.
     * 
     * @param terminalID
     */
    public void setTerminalID(java.lang.String terminalID) {
        this.terminalID = terminalID;
    }


    /**
     * Gets the reversalRetryNumber value for this ReversalElement.
     * 
     * @return reversalRetryNumber
     */
    public java.lang.String getReversalRetryNumber() {
        return reversalRetryNumber;
    }


    /**
     * Sets the reversalRetryNumber value for this ReversalElement.
     * 
     * @param reversalRetryNumber
     */
    public void setReversalRetryNumber(java.lang.String reversalRetryNumber) {
        this.reversalRetryNumber = reversalRetryNumber;
    }


    /**
     * Gets the retryTrace value for this ReversalElement.
     * 
     * @return retryTrace
     */
    public java.lang.String getRetryTrace() {
        return retryTrace;
    }


    /**
     * Sets the retryTrace value for this ReversalElement.
     * 
     * @param retryTrace
     */
    public void setRetryTrace(java.lang.String retryTrace) {
        this.retryTrace = retryTrace;
    }


    /**
     * Gets the onlineReversalInd value for this ReversalElement.
     * 
     * @return onlineReversalInd
     */
    public java.lang.String getOnlineReversalInd() {
        return onlineReversalInd;
    }


    /**
     * Sets the onlineReversalInd value for this ReversalElement.
     * 
     * @param onlineReversalInd
     */
    public void setOnlineReversalInd(java.lang.String onlineReversalInd) {
        this.onlineReversalInd = onlineReversalInd;
    }


    /**
     * Gets the latitudeLongitude value for this ReversalElement.
     * 
     * @return latitudeLongitude
     */
    public java.lang.String getLatitudeLongitude() {
        return latitudeLongitude;
    }


    /**
     * Sets the latitudeLongitude value for this ReversalElement.
     * 
     * @param latitudeLongitude
     */
    public void setLatitudeLongitude(java.lang.String latitudeLongitude) {
        this.latitudeLongitude = latitudeLongitude;
    }


    /**
     * Gets the politicalTimeZone value for this ReversalElement.
     * 
     * @return politicalTimeZone
     */
    public java.lang.String getPoliticalTimeZone() {
        return politicalTimeZone;
    }


    /**
     * Sets the politicalTimeZone value for this ReversalElement.
     * 
     * @param politicalTimeZone
     */
    public void setPoliticalTimeZone(java.lang.String politicalTimeZone) {
        this.politicalTimeZone = politicalTimeZone;
    }


    /**
     * Gets the vendorID value for this ReversalElement.
     * 
     * @return vendorID
     */
    public java.lang.String getVendorID() {
        return vendorID;
    }


    /**
     * Sets the vendorID value for this ReversalElement.
     * 
     * @param vendorID
     */
    public void setVendorID(java.lang.String vendorID) {
        this.vendorID = vendorID;
    }


    /**
     * Gets the softwareID value for this ReversalElement.
     * 
     * @return softwareID
     */
    public java.lang.String getSoftwareID() {
        return softwareID;
    }


    /**
     * Sets the softwareID value for this ReversalElement.
     * 
     * @param softwareID
     */
    public void setSoftwareID(java.lang.String softwareID) {
        this.softwareID = softwareID;
    }


    /**
     * Gets the mobileDeviceType value for this ReversalElement.
     * 
     * @return mobileDeviceType
     */
    public java.lang.String getMobileDeviceType() {
        return mobileDeviceType;
    }


    /**
     * Sets the mobileDeviceType value for this ReversalElement.
     * 
     * @param mobileDeviceType
     */
    public void setMobileDeviceType(java.lang.String mobileDeviceType) {
        this.mobileDeviceType = mobileDeviceType;
    }


    /**
     * Gets the deviceID value for this ReversalElement.
     * 
     * @return deviceID
     */
    public java.lang.String getDeviceID() {
        return deviceID;
    }


    /**
     * Sets the deviceID value for this ReversalElement.
     * 
     * @param deviceID
     */
    public void setDeviceID(java.lang.String deviceID) {
        this.deviceID = deviceID;
    }


    /**
     * Gets the localDateTime value for this ReversalElement.
     * 
     * @return localDateTime
     */
    public java.lang.String getLocalDateTime() {
        return localDateTime;
    }


    /**
     * Sets the localDateTime value for this ReversalElement.
     * 
     * @param localDateTime
     */
    public void setLocalDateTime(java.lang.String localDateTime) {
        this.localDateTime = localDateTime;
    }


    /**
     * Gets the readerSerialNumber value for this ReversalElement.
     * 
     * @return readerSerialNumber
     */
    public java.lang.String getReaderSerialNumber() {
        return readerSerialNumber;
    }


    /**
     * Sets the readerSerialNumber value for this ReversalElement.
     * 
     * @param readerSerialNumber
     */
    public void setReaderSerialNumber(java.lang.String readerSerialNumber) {
        this.readerSerialNumber = readerSerialNumber;
    }


    /**
     * Gets the chipCardData value for this ReversalElement.
     * 
     * @return chipCardData
     */
    public java.lang.String getChipCardData() {
        return chipCardData;
    }


    /**
     * Sets the chipCardData value for this ReversalElement.
     * 
     * @param chipCardData
     */
    public void setChipCardData(java.lang.String chipCardData) {
        this.chipCardData = chipCardData;
    }


    /**
     * Gets the emvSupport value for this ReversalElement.
     * 
     * @return emvSupport
     */
    public java.lang.String getEmvSupport() {
        return emvSupport;
    }


    /**
     * Sets the emvSupport value for this ReversalElement.
     * 
     * @param emvSupport
     */
    public void setEmvSupport(java.lang.String emvSupport) {
        this.emvSupport = emvSupport;
    }


    /**
     * Gets the peripheralSupport value for this ReversalElement.
     * 
     * @return peripheralSupport
     */
    public java.lang.String getPeripheralSupport() {
        return peripheralSupport;
    }


    /**
     * Sets the peripheralSupport value for this ReversalElement.
     * 
     * @param peripheralSupport
     */
    public void setPeripheralSupport(java.lang.String peripheralSupport) {
        this.peripheralSupport = peripheralSupport;
    }


    /**
     * Gets the communicationSupport value for this ReversalElement.
     * 
     * @return communicationSupport
     */
    public java.lang.String getCommunicationSupport() {
        return communicationSupport;
    }


    /**
     * Sets the communicationSupport value for this ReversalElement.
     * 
     * @param communicationSupport
     */
    public void setCommunicationSupport(java.lang.String communicationSupport) {
        this.communicationSupport = communicationSupport;
    }


    /**
     * Gets the industrySupport value for this ReversalElement.
     * 
     * @return industrySupport
     */
    public java.lang.String getIndustrySupport() {
        return industrySupport;
    }


    /**
     * Sets the industrySupport value for this ReversalElement.
     * 
     * @param industrySupport
     */
    public void setIndustrySupport(java.lang.String industrySupport) {
        this.industrySupport = industrySupport;
    }


    /**
     * Gets the complianceClass value for this ReversalElement.
     * 
     * @return complianceClass
     */
    public java.lang.String getComplianceClass() {
        return complianceClass;
    }


    /**
     * Sets the complianceClass value for this ReversalElement.
     * 
     * @param complianceClass
     */
    public void setComplianceClass(java.lang.String complianceClass) {
        this.complianceClass = complianceClass;
    }


    /**
     * Gets the deviceSecuritySupport value for this ReversalElement.
     * 
     * @return deviceSecuritySupport
     */
    public java.lang.String getDeviceSecuritySupport() {
        return deviceSecuritySupport;
    }


    /**
     * Sets the deviceSecuritySupport value for this ReversalElement.
     * 
     * @param deviceSecuritySupport
     */
    public void setDeviceSecuritySupport(java.lang.String deviceSecuritySupport) {
        this.deviceSecuritySupport = deviceSecuritySupport;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ReversalElement)) return false;
        ReversalElement other = (ReversalElement) obj;
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
            ((this.txRefNum==null && other.getTxRefNum()==null) || 
             (this.txRefNum!=null &&
              this.txRefNum.equals(other.getTxRefNum()))) &&
            ((this.txRefIdx==null && other.getTxRefIdx()==null) || 
             (this.txRefIdx!=null &&
              this.txRefIdx.equals(other.getTxRefIdx()))) &&
            ((this.adjustedAmount==null && other.getAdjustedAmount()==null) || 
             (this.adjustedAmount!=null &&
              this.adjustedAmount.equals(other.getAdjustedAmount()))) &&
            ((this.orderID==null && other.getOrderID()==null) || 
             (this.orderID!=null &&
              this.orderID.equals(other.getOrderID()))) &&
            ((this.bin==null && other.getBin()==null) || 
             (this.bin!=null &&
              this.bin.equals(other.getBin()))) &&
            ((this.merchantID==null && other.getMerchantID()==null) || 
             (this.merchantID!=null &&
              this.merchantID.equals(other.getMerchantID()))) &&
            ((this.terminalID==null && other.getTerminalID()==null) || 
             (this.terminalID!=null &&
              this.terminalID.equals(other.getTerminalID()))) &&
            ((this.reversalRetryNumber==null && other.getReversalRetryNumber()==null) || 
             (this.reversalRetryNumber!=null &&
              this.reversalRetryNumber.equals(other.getReversalRetryNumber()))) &&
            ((this.retryTrace==null && other.getRetryTrace()==null) || 
             (this.retryTrace!=null &&
              this.retryTrace.equals(other.getRetryTrace()))) &&
            ((this.onlineReversalInd==null && other.getOnlineReversalInd()==null) || 
             (this.onlineReversalInd!=null &&
              this.onlineReversalInd.equals(other.getOnlineReversalInd()))) &&
            ((this.latitudeLongitude==null && other.getLatitudeLongitude()==null) || 
             (this.latitudeLongitude!=null &&
              this.latitudeLongitude.equals(other.getLatitudeLongitude()))) &&
            ((this.politicalTimeZone==null && other.getPoliticalTimeZone()==null) || 
             (this.politicalTimeZone!=null &&
              this.politicalTimeZone.equals(other.getPoliticalTimeZone()))) &&
            ((this.vendorID==null && other.getVendorID()==null) || 
             (this.vendorID!=null &&
              this.vendorID.equals(other.getVendorID()))) &&
            ((this.softwareID==null && other.getSoftwareID()==null) || 
             (this.softwareID!=null &&
              this.softwareID.equals(other.getSoftwareID()))) &&
            ((this.mobileDeviceType==null && other.getMobileDeviceType()==null) || 
             (this.mobileDeviceType!=null &&
              this.mobileDeviceType.equals(other.getMobileDeviceType()))) &&
            ((this.deviceID==null && other.getDeviceID()==null) || 
             (this.deviceID!=null &&
              this.deviceID.equals(other.getDeviceID()))) &&
            ((this.localDateTime==null && other.getLocalDateTime()==null) || 
             (this.localDateTime!=null &&
              this.localDateTime.equals(other.getLocalDateTime()))) &&
            ((this.readerSerialNumber==null && other.getReaderSerialNumber()==null) || 
             (this.readerSerialNumber!=null &&
              this.readerSerialNumber.equals(other.getReaderSerialNumber()))) &&
            ((this.chipCardData==null && other.getChipCardData()==null) || 
             (this.chipCardData!=null &&
              this.chipCardData.equals(other.getChipCardData()))) &&
            ((this.emvSupport==null && other.getEmvSupport()==null) || 
             (this.emvSupport!=null &&
              this.emvSupport.equals(other.getEmvSupport()))) &&
            ((this.peripheralSupport==null && other.getPeripheralSupport()==null) || 
             (this.peripheralSupport!=null &&
              this.peripheralSupport.equals(other.getPeripheralSupport()))) &&
            ((this.communicationSupport==null && other.getCommunicationSupport()==null) || 
             (this.communicationSupport!=null &&
              this.communicationSupport.equals(other.getCommunicationSupport()))) &&
            ((this.industrySupport==null && other.getIndustrySupport()==null) || 
             (this.industrySupport!=null &&
              this.industrySupport.equals(other.getIndustrySupport()))) &&
            ((this.complianceClass==null && other.getComplianceClass()==null) || 
             (this.complianceClass!=null &&
              this.complianceClass.equals(other.getComplianceClass()))) &&
            ((this.deviceSecuritySupport==null && other.getDeviceSecuritySupport()==null) || 
             (this.deviceSecuritySupport!=null &&
              this.deviceSecuritySupport.equals(other.getDeviceSecuritySupport())));
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
        if (getTxRefNum() != null) {
            _hashCode += getTxRefNum().hashCode();
        }
        if (getTxRefIdx() != null) {
            _hashCode += getTxRefIdx().hashCode();
        }
        if (getAdjustedAmount() != null) {
            _hashCode += getAdjustedAmount().hashCode();
        }
        if (getOrderID() != null) {
            _hashCode += getOrderID().hashCode();
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
        if (getReversalRetryNumber() != null) {
            _hashCode += getReversalRetryNumber().hashCode();
        }
        if (getRetryTrace() != null) {
            _hashCode += getRetryTrace().hashCode();
        }
        if (getOnlineReversalInd() != null) {
            _hashCode += getOnlineReversalInd().hashCode();
        }
        if (getLatitudeLongitude() != null) {
            _hashCode += getLatitudeLongitude().hashCode();
        }
        if (getPoliticalTimeZone() != null) {
            _hashCode += getPoliticalTimeZone().hashCode();
        }
        if (getVendorID() != null) {
            _hashCode += getVendorID().hashCode();
        }
        if (getSoftwareID() != null) {
            _hashCode += getSoftwareID().hashCode();
        }
        if (getMobileDeviceType() != null) {
            _hashCode += getMobileDeviceType().hashCode();
        }
        if (getDeviceID() != null) {
            _hashCode += getDeviceID().hashCode();
        }
        if (getLocalDateTime() != null) {
            _hashCode += getLocalDateTime().hashCode();
        }
        if (getReaderSerialNumber() != null) {
            _hashCode += getReaderSerialNumber().hashCode();
        }
        if (getChipCardData() != null) {
            _hashCode += getChipCardData().hashCode();
        }
        if (getEmvSupport() != null) {
            _hashCode += getEmvSupport().hashCode();
        }
        if (getPeripheralSupport() != null) {
            _hashCode += getPeripheralSupport().hashCode();
        }
        if (getCommunicationSupport() != null) {
            _hashCode += getCommunicationSupport().hashCode();
        }
        if (getIndustrySupport() != null) {
            _hashCode += getIndustrySupport().hashCode();
        }
        if (getComplianceClass() != null) {
            _hashCode += getComplianceClass().hashCode();
        }
        if (getDeviceSecuritySupport() != null) {
            _hashCode += getDeviceSecuritySupport().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ReversalElement.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "ReversalElement"));
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
        elemField.setFieldName("txRefNum");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "txRefNum"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("txRefIdx");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "txRefIdx"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("adjustedAmount");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "adjustedAmount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("orderID");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "orderID"));
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
        elemField.setFieldName("reversalRetryNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "reversalRetryNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("retryTrace");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "retryTrace"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("onlineReversalInd");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "onlineReversalInd"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("latitudeLongitude");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "latitudeLongitude"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("politicalTimeZone");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "politicalTimeZone"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("vendorID");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "vendorID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("softwareID");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "softwareID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mobileDeviceType");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "mobileDeviceType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("deviceID");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "deviceID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("localDateTime");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "localDateTime"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("readerSerialNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "readerSerialNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("chipCardData");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "chipCardData"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("emvSupport");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "emvSupport"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("peripheralSupport");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "peripheralSupport"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("communicationSupport");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "communicationSupport"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("industrySupport");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "industrySupport"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("complianceClass");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "complianceClass"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("deviceSecuritySupport");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "deviceSecuritySupport"));
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
