/**
 * EMVProviderLineItem.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package net.paymentech.ws;

public class EMVProviderLineItem  implements java.io.Serializable {
    private java.lang.String cardBrand;

    private java.lang.String applicationId;

    private java.lang.String fallback;

    private java.lang.String biasedRandomThreshold;

    private java.lang.String floorLimit;

    private net.paymentech.ws.EMVPublicKeyLineItem[] pEMVPublicKeyLineItem;

    public EMVProviderLineItem() {
    }

    public EMVProviderLineItem(
           java.lang.String cardBrand,
           java.lang.String applicationId,
           java.lang.String fallback,
           java.lang.String biasedRandomThreshold,
           java.lang.String floorLimit,
           net.paymentech.ws.EMVPublicKeyLineItem[] pEMVPublicKeyLineItem) {
           this.cardBrand = cardBrand;
           this.applicationId = applicationId;
           this.fallback = fallback;
           this.biasedRandomThreshold = biasedRandomThreshold;
           this.floorLimit = floorLimit;
           this.pEMVPublicKeyLineItem = pEMVPublicKeyLineItem;
    }


    /**
     * Gets the cardBrand value for this EMVProviderLineItem.
     * 
     * @return cardBrand
     */
    public java.lang.String getCardBrand() {
        return cardBrand;
    }


    /**
     * Sets the cardBrand value for this EMVProviderLineItem.
     * 
     * @param cardBrand
     */
    public void setCardBrand(java.lang.String cardBrand) {
        this.cardBrand = cardBrand;
    }


    /**
     * Gets the applicationId value for this EMVProviderLineItem.
     * 
     * @return applicationId
     */
    public java.lang.String getApplicationId() {
        return applicationId;
    }


    /**
     * Sets the applicationId value for this EMVProviderLineItem.
     * 
     * @param applicationId
     */
    public void setApplicationId(java.lang.String applicationId) {
        this.applicationId = applicationId;
    }


    /**
     * Gets the fallback value for this EMVProviderLineItem.
     * 
     * @return fallback
     */
    public java.lang.String getFallback() {
        return fallback;
    }


    /**
     * Sets the fallback value for this EMVProviderLineItem.
     * 
     * @param fallback
     */
    public void setFallback(java.lang.String fallback) {
        this.fallback = fallback;
    }


    /**
     * Gets the biasedRandomThreshold value for this EMVProviderLineItem.
     * 
     * @return biasedRandomThreshold
     */
    public java.lang.String getBiasedRandomThreshold() {
        return biasedRandomThreshold;
    }


    /**
     * Sets the biasedRandomThreshold value for this EMVProviderLineItem.
     * 
     * @param biasedRandomThreshold
     */
    public void setBiasedRandomThreshold(java.lang.String biasedRandomThreshold) {
        this.biasedRandomThreshold = biasedRandomThreshold;
    }


    /**
     * Gets the floorLimit value for this EMVProviderLineItem.
     * 
     * @return floorLimit
     */
    public java.lang.String getFloorLimit() {
        return floorLimit;
    }


    /**
     * Sets the floorLimit value for this EMVProviderLineItem.
     * 
     * @param floorLimit
     */
    public void setFloorLimit(java.lang.String floorLimit) {
        this.floorLimit = floorLimit;
    }


    /**
     * Gets the pEMVPublicKeyLineItem value for this EMVProviderLineItem.
     * 
     * @return pEMVPublicKeyLineItem
     */
    public net.paymentech.ws.EMVPublicKeyLineItem[] getPEMVPublicKeyLineItem() {
        return pEMVPublicKeyLineItem;
    }


    /**
     * Sets the pEMVPublicKeyLineItem value for this EMVProviderLineItem.
     * 
     * @param pEMVPublicKeyLineItem
     */
    public void setPEMVPublicKeyLineItem(net.paymentech.ws.EMVPublicKeyLineItem[] pEMVPublicKeyLineItem) {
        this.pEMVPublicKeyLineItem = pEMVPublicKeyLineItem;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof EMVProviderLineItem)) return false;
        EMVProviderLineItem other = (EMVProviderLineItem) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cardBrand==null && other.getCardBrand()==null) || 
             (this.cardBrand!=null &&
              this.cardBrand.equals(other.getCardBrand()))) &&
            ((this.applicationId==null && other.getApplicationId()==null) || 
             (this.applicationId!=null &&
              this.applicationId.equals(other.getApplicationId()))) &&
            ((this.fallback==null && other.getFallback()==null) || 
             (this.fallback!=null &&
              this.fallback.equals(other.getFallback()))) &&
            ((this.biasedRandomThreshold==null && other.getBiasedRandomThreshold()==null) || 
             (this.biasedRandomThreshold!=null &&
              this.biasedRandomThreshold.equals(other.getBiasedRandomThreshold()))) &&
            ((this.floorLimit==null && other.getFloorLimit()==null) || 
             (this.floorLimit!=null &&
              this.floorLimit.equals(other.getFloorLimit()))) &&
            ((this.pEMVPublicKeyLineItem==null && other.getPEMVPublicKeyLineItem()==null) || 
             (this.pEMVPublicKeyLineItem!=null &&
              java.util.Arrays.equals(this.pEMVPublicKeyLineItem, other.getPEMVPublicKeyLineItem())));
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
        if (getCardBrand() != null) {
            _hashCode += getCardBrand().hashCode();
        }
        if (getApplicationId() != null) {
            _hashCode += getApplicationId().hashCode();
        }
        if (getFallback() != null) {
            _hashCode += getFallback().hashCode();
        }
        if (getBiasedRandomThreshold() != null) {
            _hashCode += getBiasedRandomThreshold().hashCode();
        }
        if (getFloorLimit() != null) {
            _hashCode += getFloorLimit().hashCode();
        }
        if (getPEMVPublicKeyLineItem() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPEMVPublicKeyLineItem());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPEMVPublicKeyLineItem(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(EMVProviderLineItem.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "EMVProviderLineItem"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cardBrand");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "cardBrand"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("applicationId");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "applicationId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fallback");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "fallback"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("biasedRandomThreshold");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "biasedRandomThreshold"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("floorLimit");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "floorLimit"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("PEMVPublicKeyLineItem");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "pEMVPublicKeyLineItem"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "EMVPublicKeyLineItem"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "item"));
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
