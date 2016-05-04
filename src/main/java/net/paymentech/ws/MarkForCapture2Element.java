/**
 * MarkForCapture2Element.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package net.paymentech.ws;

public class MarkForCapture2Element  implements java.io.Serializable {
    private java.lang.String orbitalConnectionUsername;

    private java.lang.String orbitalConnectionPassword;

    private java.lang.String orderID;

    private java.lang.String amount;

    private java.lang.String taxInd;

    private java.lang.String taxAmount;

    private java.lang.String bin;

    private java.lang.String merchantID;

    private java.lang.String terminalID;

    private java.lang.String txRefNum;

    private java.lang.String retryTrace;

    private java.lang.String pCardOrderID;

    private java.lang.String pCardDestZip;

    private java.lang.String pCardDestName;

    private java.lang.String pCardDestAddress;

    private java.lang.String pCardDestAddress2;

    private java.lang.String pCardDestCity;

    private java.lang.String pCardDestStateCd;

    private java.lang.String amexTranAdvAddn1;

    private java.lang.String amexTranAdvAddn2;

    private java.lang.String amexTranAdvAddn3;

    private java.lang.String amexTranAdvAddn4;

    private java.lang.String pCard3FreightAmt;

    private java.lang.String pCard3DutyAmt;

    private java.lang.String pCard3DestCountryCd;

    private java.lang.String pCard3ShipFromZip;

    private java.lang.String pCard3DiscAmt;

    private java.lang.String pCard3VATtaxAmt;

    private java.lang.String pCard3VATtaxRate;

    private java.lang.String pCard3AltTaxInd;

    private java.lang.String pCard3AltTaxAmt;

    private java.lang.String pCard3LineItemCount;

    private net.paymentech.ws.PC3LineItem[] pCard3LineItems;

    public MarkForCapture2Element() {
    }

    public MarkForCapture2Element(
           java.lang.String orbitalConnectionUsername,
           java.lang.String orbitalConnectionPassword,
           java.lang.String orderID,
           java.lang.String amount,
           java.lang.String taxInd,
           java.lang.String taxAmount,
           java.lang.String bin,
           java.lang.String merchantID,
           java.lang.String terminalID,
           java.lang.String txRefNum,
           java.lang.String retryTrace,
           java.lang.String pCardOrderID,
           java.lang.String pCardDestZip,
           java.lang.String pCardDestName,
           java.lang.String pCardDestAddress,
           java.lang.String pCardDestAddress2,
           java.lang.String pCardDestCity,
           java.lang.String pCardDestStateCd,
           java.lang.String amexTranAdvAddn1,
           java.lang.String amexTranAdvAddn2,
           java.lang.String amexTranAdvAddn3,
           java.lang.String amexTranAdvAddn4,
           java.lang.String pCard3FreightAmt,
           java.lang.String pCard3DutyAmt,
           java.lang.String pCard3DestCountryCd,
           java.lang.String pCard3ShipFromZip,
           java.lang.String pCard3DiscAmt,
           java.lang.String pCard3VATtaxAmt,
           java.lang.String pCard3VATtaxRate,
           java.lang.String pCard3AltTaxInd,
           java.lang.String pCard3AltTaxAmt,
           java.lang.String pCard3LineItemCount,
           net.paymentech.ws.PC3LineItem[] pCard3LineItems) {
           this.orbitalConnectionUsername = orbitalConnectionUsername;
           this.orbitalConnectionPassword = orbitalConnectionPassword;
           this.orderID = orderID;
           this.amount = amount;
           this.taxInd = taxInd;
           this.taxAmount = taxAmount;
           this.bin = bin;
           this.merchantID = merchantID;
           this.terminalID = terminalID;
           this.txRefNum = txRefNum;
           this.retryTrace = retryTrace;
           this.pCardOrderID = pCardOrderID;
           this.pCardDestZip = pCardDestZip;
           this.pCardDestName = pCardDestName;
           this.pCardDestAddress = pCardDestAddress;
           this.pCardDestAddress2 = pCardDestAddress2;
           this.pCardDestCity = pCardDestCity;
           this.pCardDestStateCd = pCardDestStateCd;
           this.amexTranAdvAddn1 = amexTranAdvAddn1;
           this.amexTranAdvAddn2 = amexTranAdvAddn2;
           this.amexTranAdvAddn3 = amexTranAdvAddn3;
           this.amexTranAdvAddn4 = amexTranAdvAddn4;
           this.pCard3FreightAmt = pCard3FreightAmt;
           this.pCard3DutyAmt = pCard3DutyAmt;
           this.pCard3DestCountryCd = pCard3DestCountryCd;
           this.pCard3ShipFromZip = pCard3ShipFromZip;
           this.pCard3DiscAmt = pCard3DiscAmt;
           this.pCard3VATtaxAmt = pCard3VATtaxAmt;
           this.pCard3VATtaxRate = pCard3VATtaxRate;
           this.pCard3AltTaxInd = pCard3AltTaxInd;
           this.pCard3AltTaxAmt = pCard3AltTaxAmt;
           this.pCard3LineItemCount = pCard3LineItemCount;
           this.pCard3LineItems = pCard3LineItems;
    }


    /**
     * Gets the orbitalConnectionUsername value for this MarkForCapture2Element.
     * 
     * @return orbitalConnectionUsername
     */
    public java.lang.String getOrbitalConnectionUsername() {
        return orbitalConnectionUsername;
    }


    /**
     * Sets the orbitalConnectionUsername value for this MarkForCapture2Element.
     * 
     * @param orbitalConnectionUsername
     */
    public void setOrbitalConnectionUsername(java.lang.String orbitalConnectionUsername) {
        this.orbitalConnectionUsername = orbitalConnectionUsername;
    }


    /**
     * Gets the orbitalConnectionPassword value for this MarkForCapture2Element.
     * 
     * @return orbitalConnectionPassword
     */
    public java.lang.String getOrbitalConnectionPassword() {
        return orbitalConnectionPassword;
    }


    /**
     * Sets the orbitalConnectionPassword value for this MarkForCapture2Element.
     * 
     * @param orbitalConnectionPassword
     */
    public void setOrbitalConnectionPassword(java.lang.String orbitalConnectionPassword) {
        this.orbitalConnectionPassword = orbitalConnectionPassword;
    }


    /**
     * Gets the orderID value for this MarkForCapture2Element.
     * 
     * @return orderID
     */
    public java.lang.String getOrderID() {
        return orderID;
    }


    /**
     * Sets the orderID value for this MarkForCapture2Element.
     * 
     * @param orderID
     */
    public void setOrderID(java.lang.String orderID) {
        this.orderID = orderID;
    }


    /**
     * Gets the amount value for this MarkForCapture2Element.
     * 
     * @return amount
     */
    public java.lang.String getAmount() {
        return amount;
    }


    /**
     * Sets the amount value for this MarkForCapture2Element.
     * 
     * @param amount
     */
    public void setAmount(java.lang.String amount) {
        this.amount = amount;
    }


    /**
     * Gets the taxInd value for this MarkForCapture2Element.
     * 
     * @return taxInd
     */
    public java.lang.String getTaxInd() {
        return taxInd;
    }


    /**
     * Sets the taxInd value for this MarkForCapture2Element.
     * 
     * @param taxInd
     */
    public void setTaxInd(java.lang.String taxInd) {
        this.taxInd = taxInd;
    }


    /**
     * Gets the taxAmount value for this MarkForCapture2Element.
     * 
     * @return taxAmount
     */
    public java.lang.String getTaxAmount() {
        return taxAmount;
    }


    /**
     * Sets the taxAmount value for this MarkForCapture2Element.
     * 
     * @param taxAmount
     */
    public void setTaxAmount(java.lang.String taxAmount) {
        this.taxAmount = taxAmount;
    }


    /**
     * Gets the bin value for this MarkForCapture2Element.
     * 
     * @return bin
     */
    public java.lang.String getBin() {
        return bin;
    }


    /**
     * Sets the bin value for this MarkForCapture2Element.
     * 
     * @param bin
     */
    public void setBin(java.lang.String bin) {
        this.bin = bin;
    }


    /**
     * Gets the merchantID value for this MarkForCapture2Element.
     * 
     * @return merchantID
     */
    public java.lang.String getMerchantID() {
        return merchantID;
    }


    /**
     * Sets the merchantID value for this MarkForCapture2Element.
     * 
     * @param merchantID
     */
    public void setMerchantID(java.lang.String merchantID) {
        this.merchantID = merchantID;
    }


    /**
     * Gets the terminalID value for this MarkForCapture2Element.
     * 
     * @return terminalID
     */
    public java.lang.String getTerminalID() {
        return terminalID;
    }


    /**
     * Sets the terminalID value for this MarkForCapture2Element.
     * 
     * @param terminalID
     */
    public void setTerminalID(java.lang.String terminalID) {
        this.terminalID = terminalID;
    }


    /**
     * Gets the txRefNum value for this MarkForCapture2Element.
     * 
     * @return txRefNum
     */
    public java.lang.String getTxRefNum() {
        return txRefNum;
    }


    /**
     * Sets the txRefNum value for this MarkForCapture2Element.
     * 
     * @param txRefNum
     */
    public void setTxRefNum(java.lang.String txRefNum) {
        this.txRefNum = txRefNum;
    }


    /**
     * Gets the retryTrace value for this MarkForCapture2Element.
     * 
     * @return retryTrace
     */
    public java.lang.String getRetryTrace() {
        return retryTrace;
    }


    /**
     * Sets the retryTrace value for this MarkForCapture2Element.
     * 
     * @param retryTrace
     */
    public void setRetryTrace(java.lang.String retryTrace) {
        this.retryTrace = retryTrace;
    }


    /**
     * Gets the pCardOrderID value for this MarkForCapture2Element.
     * 
     * @return pCardOrderID
     */
    public java.lang.String getPCardOrderID() {
        return pCardOrderID;
    }


    /**
     * Sets the pCardOrderID value for this MarkForCapture2Element.
     * 
     * @param pCardOrderID
     */
    public void setPCardOrderID(java.lang.String pCardOrderID) {
        this.pCardOrderID = pCardOrderID;
    }


    /**
     * Gets the pCardDestZip value for this MarkForCapture2Element.
     * 
     * @return pCardDestZip
     */
    public java.lang.String getPCardDestZip() {
        return pCardDestZip;
    }


    /**
     * Sets the pCardDestZip value for this MarkForCapture2Element.
     * 
     * @param pCardDestZip
     */
    public void setPCardDestZip(java.lang.String pCardDestZip) {
        this.pCardDestZip = pCardDestZip;
    }


    /**
     * Gets the pCardDestName value for this MarkForCapture2Element.
     * 
     * @return pCardDestName
     */
    public java.lang.String getPCardDestName() {
        return pCardDestName;
    }


    /**
     * Sets the pCardDestName value for this MarkForCapture2Element.
     * 
     * @param pCardDestName
     */
    public void setPCardDestName(java.lang.String pCardDestName) {
        this.pCardDestName = pCardDestName;
    }


    /**
     * Gets the pCardDestAddress value for this MarkForCapture2Element.
     * 
     * @return pCardDestAddress
     */
    public java.lang.String getPCardDestAddress() {
        return pCardDestAddress;
    }


    /**
     * Sets the pCardDestAddress value for this MarkForCapture2Element.
     * 
     * @param pCardDestAddress
     */
    public void setPCardDestAddress(java.lang.String pCardDestAddress) {
        this.pCardDestAddress = pCardDestAddress;
    }


    /**
     * Gets the pCardDestAddress2 value for this MarkForCapture2Element.
     * 
     * @return pCardDestAddress2
     */
    public java.lang.String getPCardDestAddress2() {
        return pCardDestAddress2;
    }


    /**
     * Sets the pCardDestAddress2 value for this MarkForCapture2Element.
     * 
     * @param pCardDestAddress2
     */
    public void setPCardDestAddress2(java.lang.String pCardDestAddress2) {
        this.pCardDestAddress2 = pCardDestAddress2;
    }


    /**
     * Gets the pCardDestCity value for this MarkForCapture2Element.
     * 
     * @return pCardDestCity
     */
    public java.lang.String getPCardDestCity() {
        return pCardDestCity;
    }


    /**
     * Sets the pCardDestCity value for this MarkForCapture2Element.
     * 
     * @param pCardDestCity
     */
    public void setPCardDestCity(java.lang.String pCardDestCity) {
        this.pCardDestCity = pCardDestCity;
    }


    /**
     * Gets the pCardDestStateCd value for this MarkForCapture2Element.
     * 
     * @return pCardDestStateCd
     */
    public java.lang.String getPCardDestStateCd() {
        return pCardDestStateCd;
    }


    /**
     * Sets the pCardDestStateCd value for this MarkForCapture2Element.
     * 
     * @param pCardDestStateCd
     */
    public void setPCardDestStateCd(java.lang.String pCardDestStateCd) {
        this.pCardDestStateCd = pCardDestStateCd;
    }


    /**
     * Gets the amexTranAdvAddn1 value for this MarkForCapture2Element.
     * 
     * @return amexTranAdvAddn1
     */
    public java.lang.String getAmexTranAdvAddn1() {
        return amexTranAdvAddn1;
    }


    /**
     * Sets the amexTranAdvAddn1 value for this MarkForCapture2Element.
     * 
     * @param amexTranAdvAddn1
     */
    public void setAmexTranAdvAddn1(java.lang.String amexTranAdvAddn1) {
        this.amexTranAdvAddn1 = amexTranAdvAddn1;
    }


    /**
     * Gets the amexTranAdvAddn2 value for this MarkForCapture2Element.
     * 
     * @return amexTranAdvAddn2
     */
    public java.lang.String getAmexTranAdvAddn2() {
        return amexTranAdvAddn2;
    }


    /**
     * Sets the amexTranAdvAddn2 value for this MarkForCapture2Element.
     * 
     * @param amexTranAdvAddn2
     */
    public void setAmexTranAdvAddn2(java.lang.String amexTranAdvAddn2) {
        this.amexTranAdvAddn2 = amexTranAdvAddn2;
    }


    /**
     * Gets the amexTranAdvAddn3 value for this MarkForCapture2Element.
     * 
     * @return amexTranAdvAddn3
     */
    public java.lang.String getAmexTranAdvAddn3() {
        return amexTranAdvAddn3;
    }


    /**
     * Sets the amexTranAdvAddn3 value for this MarkForCapture2Element.
     * 
     * @param amexTranAdvAddn3
     */
    public void setAmexTranAdvAddn3(java.lang.String amexTranAdvAddn3) {
        this.amexTranAdvAddn3 = amexTranAdvAddn3;
    }


    /**
     * Gets the amexTranAdvAddn4 value for this MarkForCapture2Element.
     * 
     * @return amexTranAdvAddn4
     */
    public java.lang.String getAmexTranAdvAddn4() {
        return amexTranAdvAddn4;
    }


    /**
     * Sets the amexTranAdvAddn4 value for this MarkForCapture2Element.
     * 
     * @param amexTranAdvAddn4
     */
    public void setAmexTranAdvAddn4(java.lang.String amexTranAdvAddn4) {
        this.amexTranAdvAddn4 = amexTranAdvAddn4;
    }


    /**
     * Gets the pCard3FreightAmt value for this MarkForCapture2Element.
     * 
     * @return pCard3FreightAmt
     */
    public java.lang.String getPCard3FreightAmt() {
        return pCard3FreightAmt;
    }


    /**
     * Sets the pCard3FreightAmt value for this MarkForCapture2Element.
     * 
     * @param pCard3FreightAmt
     */
    public void setPCard3FreightAmt(java.lang.String pCard3FreightAmt) {
        this.pCard3FreightAmt = pCard3FreightAmt;
    }


    /**
     * Gets the pCard3DutyAmt value for this MarkForCapture2Element.
     * 
     * @return pCard3DutyAmt
     */
    public java.lang.String getPCard3DutyAmt() {
        return pCard3DutyAmt;
    }


    /**
     * Sets the pCard3DutyAmt value for this MarkForCapture2Element.
     * 
     * @param pCard3DutyAmt
     */
    public void setPCard3DutyAmt(java.lang.String pCard3DutyAmt) {
        this.pCard3DutyAmt = pCard3DutyAmt;
    }


    /**
     * Gets the pCard3DestCountryCd value for this MarkForCapture2Element.
     * 
     * @return pCard3DestCountryCd
     */
    public java.lang.String getPCard3DestCountryCd() {
        return pCard3DestCountryCd;
    }


    /**
     * Sets the pCard3DestCountryCd value for this MarkForCapture2Element.
     * 
     * @param pCard3DestCountryCd
     */
    public void setPCard3DestCountryCd(java.lang.String pCard3DestCountryCd) {
        this.pCard3DestCountryCd = pCard3DestCountryCd;
    }


    /**
     * Gets the pCard3ShipFromZip value for this MarkForCapture2Element.
     * 
     * @return pCard3ShipFromZip
     */
    public java.lang.String getPCard3ShipFromZip() {
        return pCard3ShipFromZip;
    }


    /**
     * Sets the pCard3ShipFromZip value for this MarkForCapture2Element.
     * 
     * @param pCard3ShipFromZip
     */
    public void setPCard3ShipFromZip(java.lang.String pCard3ShipFromZip) {
        this.pCard3ShipFromZip = pCard3ShipFromZip;
    }


    /**
     * Gets the pCard3DiscAmt value for this MarkForCapture2Element.
     * 
     * @return pCard3DiscAmt
     */
    public java.lang.String getPCard3DiscAmt() {
        return pCard3DiscAmt;
    }


    /**
     * Sets the pCard3DiscAmt value for this MarkForCapture2Element.
     * 
     * @param pCard3DiscAmt
     */
    public void setPCard3DiscAmt(java.lang.String pCard3DiscAmt) {
        this.pCard3DiscAmt = pCard3DiscAmt;
    }


    /**
     * Gets the pCard3VATtaxAmt value for this MarkForCapture2Element.
     * 
     * @return pCard3VATtaxAmt
     */
    public java.lang.String getPCard3VATtaxAmt() {
        return pCard3VATtaxAmt;
    }


    /**
     * Sets the pCard3VATtaxAmt value for this MarkForCapture2Element.
     * 
     * @param pCard3VATtaxAmt
     */
    public void setPCard3VATtaxAmt(java.lang.String pCard3VATtaxAmt) {
        this.pCard3VATtaxAmt = pCard3VATtaxAmt;
    }


    /**
     * Gets the pCard3VATtaxRate value for this MarkForCapture2Element.
     * 
     * @return pCard3VATtaxRate
     */
    public java.lang.String getPCard3VATtaxRate() {
        return pCard3VATtaxRate;
    }


    /**
     * Sets the pCard3VATtaxRate value for this MarkForCapture2Element.
     * 
     * @param pCard3VATtaxRate
     */
    public void setPCard3VATtaxRate(java.lang.String pCard3VATtaxRate) {
        this.pCard3VATtaxRate = pCard3VATtaxRate;
    }


    /**
     * Gets the pCard3AltTaxInd value for this MarkForCapture2Element.
     * 
     * @return pCard3AltTaxInd
     */
    public java.lang.String getPCard3AltTaxInd() {
        return pCard3AltTaxInd;
    }


    /**
     * Sets the pCard3AltTaxInd value for this MarkForCapture2Element.
     * 
     * @param pCard3AltTaxInd
     */
    public void setPCard3AltTaxInd(java.lang.String pCard3AltTaxInd) {
        this.pCard3AltTaxInd = pCard3AltTaxInd;
    }


    /**
     * Gets the pCard3AltTaxAmt value for this MarkForCapture2Element.
     * 
     * @return pCard3AltTaxAmt
     */
    public java.lang.String getPCard3AltTaxAmt() {
        return pCard3AltTaxAmt;
    }


    /**
     * Sets the pCard3AltTaxAmt value for this MarkForCapture2Element.
     * 
     * @param pCard3AltTaxAmt
     */
    public void setPCard3AltTaxAmt(java.lang.String pCard3AltTaxAmt) {
        this.pCard3AltTaxAmt = pCard3AltTaxAmt;
    }


    /**
     * Gets the pCard3LineItemCount value for this MarkForCapture2Element.
     * 
     * @return pCard3LineItemCount
     */
    public java.lang.String getPCard3LineItemCount() {
        return pCard3LineItemCount;
    }


    /**
     * Sets the pCard3LineItemCount value for this MarkForCapture2Element.
     * 
     * @param pCard3LineItemCount
     */
    public void setPCard3LineItemCount(java.lang.String pCard3LineItemCount) {
        this.pCard3LineItemCount = pCard3LineItemCount;
    }


    /**
     * Gets the pCard3LineItems value for this MarkForCapture2Element.
     * 
     * @return pCard3LineItems
     */
    public net.paymentech.ws.PC3LineItem[] getPCard3LineItems() {
        return pCard3LineItems;
    }


    /**
     * Sets the pCard3LineItems value for this MarkForCapture2Element.
     * 
     * @param pCard3LineItems
     */
    public void setPCard3LineItems(net.paymentech.ws.PC3LineItem[] pCard3LineItems) {
        this.pCard3LineItems = pCard3LineItems;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof MarkForCapture2Element)) return false;
        MarkForCapture2Element other = (MarkForCapture2Element) obj;
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
            ((this.orderID==null && other.getOrderID()==null) || 
             (this.orderID!=null &&
              this.orderID.equals(other.getOrderID()))) &&
            ((this.amount==null && other.getAmount()==null) || 
             (this.amount!=null &&
              this.amount.equals(other.getAmount()))) &&
            ((this.taxInd==null && other.getTaxInd()==null) || 
             (this.taxInd!=null &&
              this.taxInd.equals(other.getTaxInd()))) &&
            ((this.taxAmount==null && other.getTaxAmount()==null) || 
             (this.taxAmount!=null &&
              this.taxAmount.equals(other.getTaxAmount()))) &&
            ((this.bin==null && other.getBin()==null) || 
             (this.bin!=null &&
              this.bin.equals(other.getBin()))) &&
            ((this.merchantID==null && other.getMerchantID()==null) || 
             (this.merchantID!=null &&
              this.merchantID.equals(other.getMerchantID()))) &&
            ((this.terminalID==null && other.getTerminalID()==null) || 
             (this.terminalID!=null &&
              this.terminalID.equals(other.getTerminalID()))) &&
            ((this.txRefNum==null && other.getTxRefNum()==null) || 
             (this.txRefNum!=null &&
              this.txRefNum.equals(other.getTxRefNum()))) &&
            ((this.retryTrace==null && other.getRetryTrace()==null) || 
             (this.retryTrace!=null &&
              this.retryTrace.equals(other.getRetryTrace()))) &&
            ((this.pCardOrderID==null && other.getPCardOrderID()==null) || 
             (this.pCardOrderID!=null &&
              this.pCardOrderID.equals(other.getPCardOrderID()))) &&
            ((this.pCardDestZip==null && other.getPCardDestZip()==null) || 
             (this.pCardDestZip!=null &&
              this.pCardDestZip.equals(other.getPCardDestZip()))) &&
            ((this.pCardDestName==null && other.getPCardDestName()==null) || 
             (this.pCardDestName!=null &&
              this.pCardDestName.equals(other.getPCardDestName()))) &&
            ((this.pCardDestAddress==null && other.getPCardDestAddress()==null) || 
             (this.pCardDestAddress!=null &&
              this.pCardDestAddress.equals(other.getPCardDestAddress()))) &&
            ((this.pCardDestAddress2==null && other.getPCardDestAddress2()==null) || 
             (this.pCardDestAddress2!=null &&
              this.pCardDestAddress2.equals(other.getPCardDestAddress2()))) &&
            ((this.pCardDestCity==null && other.getPCardDestCity()==null) || 
             (this.pCardDestCity!=null &&
              this.pCardDestCity.equals(other.getPCardDestCity()))) &&
            ((this.pCardDestStateCd==null && other.getPCardDestStateCd()==null) || 
             (this.pCardDestStateCd!=null &&
              this.pCardDestStateCd.equals(other.getPCardDestStateCd()))) &&
            ((this.amexTranAdvAddn1==null && other.getAmexTranAdvAddn1()==null) || 
             (this.amexTranAdvAddn1!=null &&
              this.amexTranAdvAddn1.equals(other.getAmexTranAdvAddn1()))) &&
            ((this.amexTranAdvAddn2==null && other.getAmexTranAdvAddn2()==null) || 
             (this.amexTranAdvAddn2!=null &&
              this.amexTranAdvAddn2.equals(other.getAmexTranAdvAddn2()))) &&
            ((this.amexTranAdvAddn3==null && other.getAmexTranAdvAddn3()==null) || 
             (this.amexTranAdvAddn3!=null &&
              this.amexTranAdvAddn3.equals(other.getAmexTranAdvAddn3()))) &&
            ((this.amexTranAdvAddn4==null && other.getAmexTranAdvAddn4()==null) || 
             (this.amexTranAdvAddn4!=null &&
              this.amexTranAdvAddn4.equals(other.getAmexTranAdvAddn4()))) &&
            ((this.pCard3FreightAmt==null && other.getPCard3FreightAmt()==null) || 
             (this.pCard3FreightAmt!=null &&
              this.pCard3FreightAmt.equals(other.getPCard3FreightAmt()))) &&
            ((this.pCard3DutyAmt==null && other.getPCard3DutyAmt()==null) || 
             (this.pCard3DutyAmt!=null &&
              this.pCard3DutyAmt.equals(other.getPCard3DutyAmt()))) &&
            ((this.pCard3DestCountryCd==null && other.getPCard3DestCountryCd()==null) || 
             (this.pCard3DestCountryCd!=null &&
              this.pCard3DestCountryCd.equals(other.getPCard3DestCountryCd()))) &&
            ((this.pCard3ShipFromZip==null && other.getPCard3ShipFromZip()==null) || 
             (this.pCard3ShipFromZip!=null &&
              this.pCard3ShipFromZip.equals(other.getPCard3ShipFromZip()))) &&
            ((this.pCard3DiscAmt==null && other.getPCard3DiscAmt()==null) || 
             (this.pCard3DiscAmt!=null &&
              this.pCard3DiscAmt.equals(other.getPCard3DiscAmt()))) &&
            ((this.pCard3VATtaxAmt==null && other.getPCard3VATtaxAmt()==null) || 
             (this.pCard3VATtaxAmt!=null &&
              this.pCard3VATtaxAmt.equals(other.getPCard3VATtaxAmt()))) &&
            ((this.pCard3VATtaxRate==null && other.getPCard3VATtaxRate()==null) || 
             (this.pCard3VATtaxRate!=null &&
              this.pCard3VATtaxRate.equals(other.getPCard3VATtaxRate()))) &&
            ((this.pCard3AltTaxInd==null && other.getPCard3AltTaxInd()==null) || 
             (this.pCard3AltTaxInd!=null &&
              this.pCard3AltTaxInd.equals(other.getPCard3AltTaxInd()))) &&
            ((this.pCard3AltTaxAmt==null && other.getPCard3AltTaxAmt()==null) || 
             (this.pCard3AltTaxAmt!=null &&
              this.pCard3AltTaxAmt.equals(other.getPCard3AltTaxAmt()))) &&
            ((this.pCard3LineItemCount==null && other.getPCard3LineItemCount()==null) || 
             (this.pCard3LineItemCount!=null &&
              this.pCard3LineItemCount.equals(other.getPCard3LineItemCount()))) &&
            ((this.pCard3LineItems==null && other.getPCard3LineItems()==null) || 
             (this.pCard3LineItems!=null &&
              java.util.Arrays.equals(this.pCard3LineItems, other.getPCard3LineItems())));
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
        if (getOrderID() != null) {
            _hashCode += getOrderID().hashCode();
        }
        if (getAmount() != null) {
            _hashCode += getAmount().hashCode();
        }
        if (getTaxInd() != null) {
            _hashCode += getTaxInd().hashCode();
        }
        if (getTaxAmount() != null) {
            _hashCode += getTaxAmount().hashCode();
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
        if (getTxRefNum() != null) {
            _hashCode += getTxRefNum().hashCode();
        }
        if (getRetryTrace() != null) {
            _hashCode += getRetryTrace().hashCode();
        }
        if (getPCardOrderID() != null) {
            _hashCode += getPCardOrderID().hashCode();
        }
        if (getPCardDestZip() != null) {
            _hashCode += getPCardDestZip().hashCode();
        }
        if (getPCardDestName() != null) {
            _hashCode += getPCardDestName().hashCode();
        }
        if (getPCardDestAddress() != null) {
            _hashCode += getPCardDestAddress().hashCode();
        }
        if (getPCardDestAddress2() != null) {
            _hashCode += getPCardDestAddress2().hashCode();
        }
        if (getPCardDestCity() != null) {
            _hashCode += getPCardDestCity().hashCode();
        }
        if (getPCardDestStateCd() != null) {
            _hashCode += getPCardDestStateCd().hashCode();
        }
        if (getAmexTranAdvAddn1() != null) {
            _hashCode += getAmexTranAdvAddn1().hashCode();
        }
        if (getAmexTranAdvAddn2() != null) {
            _hashCode += getAmexTranAdvAddn2().hashCode();
        }
        if (getAmexTranAdvAddn3() != null) {
            _hashCode += getAmexTranAdvAddn3().hashCode();
        }
        if (getAmexTranAdvAddn4() != null) {
            _hashCode += getAmexTranAdvAddn4().hashCode();
        }
        if (getPCard3FreightAmt() != null) {
            _hashCode += getPCard3FreightAmt().hashCode();
        }
        if (getPCard3DutyAmt() != null) {
            _hashCode += getPCard3DutyAmt().hashCode();
        }
        if (getPCard3DestCountryCd() != null) {
            _hashCode += getPCard3DestCountryCd().hashCode();
        }
        if (getPCard3ShipFromZip() != null) {
            _hashCode += getPCard3ShipFromZip().hashCode();
        }
        if (getPCard3DiscAmt() != null) {
            _hashCode += getPCard3DiscAmt().hashCode();
        }
        if (getPCard3VATtaxAmt() != null) {
            _hashCode += getPCard3VATtaxAmt().hashCode();
        }
        if (getPCard3VATtaxRate() != null) {
            _hashCode += getPCard3VATtaxRate().hashCode();
        }
        if (getPCard3AltTaxInd() != null) {
            _hashCode += getPCard3AltTaxInd().hashCode();
        }
        if (getPCard3AltTaxAmt() != null) {
            _hashCode += getPCard3AltTaxAmt().hashCode();
        }
        if (getPCard3LineItemCount() != null) {
            _hashCode += getPCard3LineItemCount().hashCode();
        }
        if (getPCard3LineItems() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPCard3LineItems());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPCard3LineItems(), i);
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
        new org.apache.axis.description.TypeDesc(MarkForCapture2Element.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "MarkForCapture2Element"));
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
        elemField.setFieldName("orderID");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "orderID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("amount");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "amount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("taxInd");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "taxInd"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("taxAmount");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "taxAmount"));
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
        elemField.setFieldName("terminalID");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "terminalID"));
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
        elemField.setFieldName("retryTrace");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "retryTrace"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("PCardOrderID");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "pCardOrderID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("PCardDestZip");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "pCardDestZip"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("PCardDestName");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "pCardDestName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("PCardDestAddress");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "pCardDestAddress"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("PCardDestAddress2");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "pCardDestAddress2"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("PCardDestCity");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "pCardDestCity"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("PCardDestStateCd");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "pCardDestStateCd"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("amexTranAdvAddn1");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "amexTranAdvAddn1"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("amexTranAdvAddn2");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "amexTranAdvAddn2"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("amexTranAdvAddn3");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "amexTranAdvAddn3"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("amexTranAdvAddn4");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "amexTranAdvAddn4"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("PCard3FreightAmt");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "pCard3FreightAmt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("PCard3DutyAmt");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "pCard3DutyAmt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("PCard3DestCountryCd");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "pCard3DestCountryCd"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("PCard3ShipFromZip");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "pCard3ShipFromZip"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("PCard3DiscAmt");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "pCard3DiscAmt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("PCard3VATtaxAmt");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "pCard3VATtaxAmt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("PCard3VATtaxRate");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "pCard3VATtaxRate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("PCard3AltTaxInd");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "pCard3AltTaxInd"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("PCard3AltTaxAmt");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "pCard3AltTaxAmt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("PCard3LineItemCount");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "pCard3LineItemCount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("PCard3LineItems");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "pCard3LineItems"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "PC3LineItem"));
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
