/**
 * EMVPublicKeyLineItem.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package net.paymentech.ws;

public class EMVPublicKeyLineItem  implements java.io.Serializable {
    private java.lang.String index;

    private java.lang.String exponentLength;

    private java.lang.String exponent;

    private java.lang.String modulusLength;

    private java.lang.String modulus;

    private java.lang.String checksumLength;

    private java.lang.String checksum;

    public EMVPublicKeyLineItem() {
    }

    public EMVPublicKeyLineItem(
           java.lang.String index,
           java.lang.String exponentLength,
           java.lang.String exponent,
           java.lang.String modulusLength,
           java.lang.String modulus,
           java.lang.String checksumLength,
           java.lang.String checksum) {
           this.index = index;
           this.exponentLength = exponentLength;
           this.exponent = exponent;
           this.modulusLength = modulusLength;
           this.modulus = modulus;
           this.checksumLength = checksumLength;
           this.checksum = checksum;
    }


    /**
     * Gets the index value for this EMVPublicKeyLineItem.
     * 
     * @return index
     */
    public java.lang.String getIndex() {
        return index;
    }


    /**
     * Sets the index value for this EMVPublicKeyLineItem.
     * 
     * @param index
     */
    public void setIndex(java.lang.String index) {
        this.index = index;
    }


    /**
     * Gets the exponentLength value for this EMVPublicKeyLineItem.
     * 
     * @return exponentLength
     */
    public java.lang.String getExponentLength() {
        return exponentLength;
    }


    /**
     * Sets the exponentLength value for this EMVPublicKeyLineItem.
     * 
     * @param exponentLength
     */
    public void setExponentLength(java.lang.String exponentLength) {
        this.exponentLength = exponentLength;
    }


    /**
     * Gets the exponent value for this EMVPublicKeyLineItem.
     * 
     * @return exponent
     */
    public java.lang.String getExponent() {
        return exponent;
    }


    /**
     * Sets the exponent value for this EMVPublicKeyLineItem.
     * 
     * @param exponent
     */
    public void setExponent(java.lang.String exponent) {
        this.exponent = exponent;
    }


    /**
     * Gets the modulusLength value for this EMVPublicKeyLineItem.
     * 
     * @return modulusLength
     */
    public java.lang.String getModulusLength() {
        return modulusLength;
    }


    /**
     * Sets the modulusLength value for this EMVPublicKeyLineItem.
     * 
     * @param modulusLength
     */
    public void setModulusLength(java.lang.String modulusLength) {
        this.modulusLength = modulusLength;
    }


    /**
     * Gets the modulus value for this EMVPublicKeyLineItem.
     * 
     * @return modulus
     */
    public java.lang.String getModulus() {
        return modulus;
    }


    /**
     * Sets the modulus value for this EMVPublicKeyLineItem.
     * 
     * @param modulus
     */
    public void setModulus(java.lang.String modulus) {
        this.modulus = modulus;
    }


    /**
     * Gets the checksumLength value for this EMVPublicKeyLineItem.
     * 
     * @return checksumLength
     */
    public java.lang.String getChecksumLength() {
        return checksumLength;
    }


    /**
     * Sets the checksumLength value for this EMVPublicKeyLineItem.
     * 
     * @param checksumLength
     */
    public void setChecksumLength(java.lang.String checksumLength) {
        this.checksumLength = checksumLength;
    }


    /**
     * Gets the checksum value for this EMVPublicKeyLineItem.
     * 
     * @return checksum
     */
    public java.lang.String getChecksum() {
        return checksum;
    }


    /**
     * Sets the checksum value for this EMVPublicKeyLineItem.
     * 
     * @param checksum
     */
    public void setChecksum(java.lang.String checksum) {
        this.checksum = checksum;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof EMVPublicKeyLineItem)) return false;
        EMVPublicKeyLineItem other = (EMVPublicKeyLineItem) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.index==null && other.getIndex()==null) || 
             (this.index!=null &&
              this.index.equals(other.getIndex()))) &&
            ((this.exponentLength==null && other.getExponentLength()==null) || 
             (this.exponentLength!=null &&
              this.exponentLength.equals(other.getExponentLength()))) &&
            ((this.exponent==null && other.getExponent()==null) || 
             (this.exponent!=null &&
              this.exponent.equals(other.getExponent()))) &&
            ((this.modulusLength==null && other.getModulusLength()==null) || 
             (this.modulusLength!=null &&
              this.modulusLength.equals(other.getModulusLength()))) &&
            ((this.modulus==null && other.getModulus()==null) || 
             (this.modulus!=null &&
              this.modulus.equals(other.getModulus()))) &&
            ((this.checksumLength==null && other.getChecksumLength()==null) || 
             (this.checksumLength!=null &&
              this.checksumLength.equals(other.getChecksumLength()))) &&
            ((this.checksum==null && other.getChecksum()==null) || 
             (this.checksum!=null &&
              this.checksum.equals(other.getChecksum())));
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
        if (getIndex() != null) {
            _hashCode += getIndex().hashCode();
        }
        if (getExponentLength() != null) {
            _hashCode += getExponentLength().hashCode();
        }
        if (getExponent() != null) {
            _hashCode += getExponent().hashCode();
        }
        if (getModulusLength() != null) {
            _hashCode += getModulusLength().hashCode();
        }
        if (getModulus() != null) {
            _hashCode += getModulus().hashCode();
        }
        if (getChecksumLength() != null) {
            _hashCode += getChecksumLength().hashCode();
        }
        if (getChecksum() != null) {
            _hashCode += getChecksum().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(EMVPublicKeyLineItem.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "EMVPublicKeyLineItem"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("index");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "index"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("exponentLength");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "exponentLength"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("exponent");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "exponent"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("modulusLength");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "modulusLength"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("modulus");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "modulus"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("checksumLength");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "checksumLength"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("checksum");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "checksum"));
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
