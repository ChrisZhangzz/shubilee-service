/**
 * EMVParametersRequest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package net.paymentech.ws;

public class EMVParametersRequest  implements java.io.Serializable {
    private java.lang.String orbitalConnectionUsername;

    private java.lang.String orbitalConnectionPassword;

    private java.lang.String version;

    private java.lang.String bin;

    private java.lang.String terminalID;

    private java.lang.String merchantID;

    private java.lang.String emvParameterDownloadDate;

    private java.lang.String returnEmvDownloadDate;

    public EMVParametersRequest() {
    }

    public EMVParametersRequest(
           java.lang.String orbitalConnectionUsername,
           java.lang.String orbitalConnectionPassword,
           java.lang.String version,
           java.lang.String bin,
           java.lang.String terminalID,
           java.lang.String merchantID,
           java.lang.String emvParameterDownloadDate,
           java.lang.String returnEmvDownloadDate) {
           this.orbitalConnectionUsername = orbitalConnectionUsername;
           this.orbitalConnectionPassword = orbitalConnectionPassword;
           this.version = version;
           this.bin = bin;
           this.terminalID = terminalID;
           this.merchantID = merchantID;
           this.emvParameterDownloadDate = emvParameterDownloadDate;
           this.returnEmvDownloadDate = returnEmvDownloadDate;
    }


    /**
     * Gets the orbitalConnectionUsername value for this EMVParametersRequest.
     * 
     * @return orbitalConnectionUsername
     */
    public java.lang.String getOrbitalConnectionUsername() {
        return orbitalConnectionUsername;
    }


    /**
     * Sets the orbitalConnectionUsername value for this EMVParametersRequest.
     * 
     * @param orbitalConnectionUsername
     */
    public void setOrbitalConnectionUsername(java.lang.String orbitalConnectionUsername) {
        this.orbitalConnectionUsername = orbitalConnectionUsername;
    }


    /**
     * Gets the orbitalConnectionPassword value for this EMVParametersRequest.
     * 
     * @return orbitalConnectionPassword
     */
    public java.lang.String getOrbitalConnectionPassword() {
        return orbitalConnectionPassword;
    }


    /**
     * Sets the orbitalConnectionPassword value for this EMVParametersRequest.
     * 
     * @param orbitalConnectionPassword
     */
    public void setOrbitalConnectionPassword(java.lang.String orbitalConnectionPassword) {
        this.orbitalConnectionPassword = orbitalConnectionPassword;
    }


    /**
     * Gets the version value for this EMVParametersRequest.
     * 
     * @return version
     */
    public java.lang.String getVersion() {
        return version;
    }


    /**
     * Sets the version value for this EMVParametersRequest.
     * 
     * @param version
     */
    public void setVersion(java.lang.String version) {
        this.version = version;
    }


    /**
     * Gets the bin value for this EMVParametersRequest.
     * 
     * @return bin
     */
    public java.lang.String getBin() {
        return bin;
    }


    /**
     * Sets the bin value for this EMVParametersRequest.
     * 
     * @param bin
     */
    public void setBin(java.lang.String bin) {
        this.bin = bin;
    }


    /**
     * Gets the terminalID value for this EMVParametersRequest.
     * 
     * @return terminalID
     */
    public java.lang.String getTerminalID() {
        return terminalID;
    }


    /**
     * Sets the terminalID value for this EMVParametersRequest.
     * 
     * @param terminalID
     */
    public void setTerminalID(java.lang.String terminalID) {
        this.terminalID = terminalID;
    }


    /**
     * Gets the merchantID value for this EMVParametersRequest.
     * 
     * @return merchantID
     */
    public java.lang.String getMerchantID() {
        return merchantID;
    }


    /**
     * Sets the merchantID value for this EMVParametersRequest.
     * 
     * @param merchantID
     */
    public void setMerchantID(java.lang.String merchantID) {
        this.merchantID = merchantID;
    }


    /**
     * Gets the emvParameterDownloadDate value for this EMVParametersRequest.
     * 
     * @return emvParameterDownloadDate
     */
    public java.lang.String getEmvParameterDownloadDate() {
        return emvParameterDownloadDate;
    }


    /**
     * Sets the emvParameterDownloadDate value for this EMVParametersRequest.
     * 
     * @param emvParameterDownloadDate
     */
    public void setEmvParameterDownloadDate(java.lang.String emvParameterDownloadDate) {
        this.emvParameterDownloadDate = emvParameterDownloadDate;
    }


    /**
     * Gets the returnEmvDownloadDate value for this EMVParametersRequest.
     * 
     * @return returnEmvDownloadDate
     */
    public java.lang.String getReturnEmvDownloadDate() {
        return returnEmvDownloadDate;
    }


    /**
     * Sets the returnEmvDownloadDate value for this EMVParametersRequest.
     * 
     * @param returnEmvDownloadDate
     */
    public void setReturnEmvDownloadDate(java.lang.String returnEmvDownloadDate) {
        this.returnEmvDownloadDate = returnEmvDownloadDate;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof EMVParametersRequest)) return false;
        EMVParametersRequest other = (EMVParametersRequest) obj;
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
            ((this.terminalID==null && other.getTerminalID()==null) || 
             (this.terminalID!=null &&
              this.terminalID.equals(other.getTerminalID()))) &&
            ((this.merchantID==null && other.getMerchantID()==null) || 
             (this.merchantID!=null &&
              this.merchantID.equals(other.getMerchantID()))) &&
            ((this.emvParameterDownloadDate==null && other.getEmvParameterDownloadDate()==null) || 
             (this.emvParameterDownloadDate!=null &&
              this.emvParameterDownloadDate.equals(other.getEmvParameterDownloadDate()))) &&
            ((this.returnEmvDownloadDate==null && other.getReturnEmvDownloadDate()==null) || 
             (this.returnEmvDownloadDate!=null &&
              this.returnEmvDownloadDate.equals(other.getReturnEmvDownloadDate())));
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
        if (getTerminalID() != null) {
            _hashCode += getTerminalID().hashCode();
        }
        if (getMerchantID() != null) {
            _hashCode += getMerchantID().hashCode();
        }
        if (getEmvParameterDownloadDate() != null) {
            _hashCode += getEmvParameterDownloadDate().hashCode();
        }
        if (getReturnEmvDownloadDate() != null) {
            _hashCode += getReturnEmvDownloadDate().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(EMVParametersRequest.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "EMVParametersRequest"));
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
        elemField.setFieldName("terminalID");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "terminalID"));
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
        elemField.setFieldName("emvParameterDownloadDate");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "emvParameterDownloadDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("returnEmvDownloadDate");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "returnEmvDownloadDate"));
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
