/**
 * EMVParametersResponseElement.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package net.paymentech.ws;

public class EMVParametersResponseElement  implements java.io.Serializable {
    private java.lang.String EMVDownloadDate;

    private net.paymentech.ws.EMVProviderLineItem[] pEMVProviderLineItem;

    private java.lang.String procStatus;

    private java.lang.String procStatusMessage;

    public EMVParametersResponseElement() {
    }

    public EMVParametersResponseElement(
           java.lang.String EMVDownloadDate,
           net.paymentech.ws.EMVProviderLineItem[] pEMVProviderLineItem,
           java.lang.String procStatus,
           java.lang.String procStatusMessage) {
           this.EMVDownloadDate = EMVDownloadDate;
           this.pEMVProviderLineItem = pEMVProviderLineItem;
           this.procStatus = procStatus;
           this.procStatusMessage = procStatusMessage;
    }


    /**
     * Gets the EMVDownloadDate value for this EMVParametersResponseElement.
     * 
     * @return EMVDownloadDate
     */
    public java.lang.String getEMVDownloadDate() {
        return EMVDownloadDate;
    }


    /**
     * Sets the EMVDownloadDate value for this EMVParametersResponseElement.
     * 
     * @param EMVDownloadDate
     */
    public void setEMVDownloadDate(java.lang.String EMVDownloadDate) {
        this.EMVDownloadDate = EMVDownloadDate;
    }


    /**
     * Gets the pEMVProviderLineItem value for this EMVParametersResponseElement.
     * 
     * @return pEMVProviderLineItem
     */
    public net.paymentech.ws.EMVProviderLineItem[] getPEMVProviderLineItem() {
        return pEMVProviderLineItem;
    }


    /**
     * Sets the pEMVProviderLineItem value for this EMVParametersResponseElement.
     * 
     * @param pEMVProviderLineItem
     */
    public void setPEMVProviderLineItem(net.paymentech.ws.EMVProviderLineItem[] pEMVProviderLineItem) {
        this.pEMVProviderLineItem = pEMVProviderLineItem;
    }


    /**
     * Gets the procStatus value for this EMVParametersResponseElement.
     * 
     * @return procStatus
     */
    public java.lang.String getProcStatus() {
        return procStatus;
    }


    /**
     * Sets the procStatus value for this EMVParametersResponseElement.
     * 
     * @param procStatus
     */
    public void setProcStatus(java.lang.String procStatus) {
        this.procStatus = procStatus;
    }


    /**
     * Gets the procStatusMessage value for this EMVParametersResponseElement.
     * 
     * @return procStatusMessage
     */
    public java.lang.String getProcStatusMessage() {
        return procStatusMessage;
    }


    /**
     * Sets the procStatusMessage value for this EMVParametersResponseElement.
     * 
     * @param procStatusMessage
     */
    public void setProcStatusMessage(java.lang.String procStatusMessage) {
        this.procStatusMessage = procStatusMessage;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof EMVParametersResponseElement)) return false;
        EMVParametersResponseElement other = (EMVParametersResponseElement) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.EMVDownloadDate==null && other.getEMVDownloadDate()==null) || 
             (this.EMVDownloadDate!=null &&
              this.EMVDownloadDate.equals(other.getEMVDownloadDate()))) &&
            ((this.pEMVProviderLineItem==null && other.getPEMVProviderLineItem()==null) || 
             (this.pEMVProviderLineItem!=null &&
              java.util.Arrays.equals(this.pEMVProviderLineItem, other.getPEMVProviderLineItem()))) &&
            ((this.procStatus==null && other.getProcStatus()==null) || 
             (this.procStatus!=null &&
              this.procStatus.equals(other.getProcStatus()))) &&
            ((this.procStatusMessage==null && other.getProcStatusMessage()==null) || 
             (this.procStatusMessage!=null &&
              this.procStatusMessage.equals(other.getProcStatusMessage())));
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
        if (getEMVDownloadDate() != null) {
            _hashCode += getEMVDownloadDate().hashCode();
        }
        if (getPEMVProviderLineItem() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPEMVProviderLineItem());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPEMVProviderLineItem(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getProcStatus() != null) {
            _hashCode += getProcStatus().hashCode();
        }
        if (getProcStatusMessage() != null) {
            _hashCode += getProcStatusMessage().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(EMVParametersResponseElement.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "EMVParametersResponseElement"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("EMVDownloadDate");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "EMVDownloadDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("PEMVProviderLineItem");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "pEMVProviderLineItem"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "EMVProviderLineItem"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "item"));
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
