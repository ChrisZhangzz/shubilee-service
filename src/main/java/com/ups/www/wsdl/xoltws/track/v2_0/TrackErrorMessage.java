/**
 * TrackErrorMessage.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.3  Built on : Jun 27, 2015 (11:17:49 BST)
 */
package com.ups.www.wsdl.xoltws.track.v2_0;

public class TrackErrorMessage extends java.lang.Exception {
    private static final long serialVersionUID = 1436551578434L;
    private com.ups.www.wsdl.xoltws.track.v2_0.TrackServiceStub.Errors faultMessage;

    public TrackErrorMessage() {
        super("TrackErrorMessage");
    }

    public TrackErrorMessage(java.lang.String s) {
        super(s);
    }

    public TrackErrorMessage(java.lang.String s, java.lang.Throwable ex) {
        super(s, ex);
    }

    public TrackErrorMessage(java.lang.Throwable cause) {
        super(cause);
    }

    public void setFaultMessage(
        com.ups.www.wsdl.xoltws.track.v2_0.TrackServiceStub.Errors msg) {
        faultMessage = msg;
    }

    public com.ups.www.wsdl.xoltws.track.v2_0.TrackServiceStub.Errors getFaultMessage() {
        return faultMessage;
    }
}
