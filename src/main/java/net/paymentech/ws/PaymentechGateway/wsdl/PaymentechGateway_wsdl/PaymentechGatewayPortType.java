/**
 * PaymentechGatewayPortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package net.paymentech.ws.PaymentechGateway.wsdl.PaymentechGateway_wsdl;

public interface PaymentechGatewayPortType extends java.rmi.Remote {

    /**
     * Service definition of function ns__NewOrder
     */
    public net.paymentech.ws.NewOrderResponseElement newOrder(net.paymentech.ws.NewOrderRequestElement newOrderRequest) throws java.rmi.RemoteException;

    /**
     * Service definition of function ns__LogMessage
     */
    public net.paymentech.ws.LogMessageResponseElement logMessage(net.paymentech.ws.LogMessageRequestElement logMessageRequest) throws java.rmi.RemoteException;

    /**
     * Service definition of function ns__MarkForCapture
     */
    public net.paymentech.ws.MarkForCaptureResponseElement markForCapture(net.paymentech.ws.MarkForCaptureElement markForCaptureRequest) throws java.rmi.RemoteException;

    /**
     * Service definition of function ns__MarkForCapture2
     */
    public net.paymentech.ws.MarkForCaptureResponse2Element markForCapture2(net.paymentech.ws.MarkForCapture2Element markForCaptureRequest) throws java.rmi.RemoteException;

    /**
     * Service definition of function ns__MFC
     */
    public net.paymentech.ws.MFCResponseElement MFC(net.paymentech.ws.MFCElement mfcRequest) throws java.rmi.RemoteException;

    /**
     * Service definition of function ns__Reversal
     */
    public net.paymentech.ws.ReversalResponseElement reversal(net.paymentech.ws.ReversalElement reversalRequest) throws java.rmi.RemoteException;

    /**
     * Service definition of function ns__EndOfDay
     */
    public net.paymentech.ws.EndOfDayResponseElement endOfDay(net.paymentech.ws.EndOfDayElement endOfDayRequest) throws java.rmi.RemoteException;

    /**
     * Service definition of function ns__ProfileAdd
     */
    public net.paymentech.ws.ProfileResponseElement profileAdd(net.paymentech.ws.ProfileAddElement profileAddRequest) throws java.rmi.RemoteException;

    /**
     * Service definition of function ns__ProfileChange
     */
    public net.paymentech.ws.ProfileResponseElement profileChange(net.paymentech.ws.ProfileChangeElement profileChangeRequest) throws java.rmi.RemoteException;

    /**
     * Service definition of function ns__ProfileDelete
     */
    public net.paymentech.ws.ProfileResponseElement profileDelete(net.paymentech.ws.ProfileDeleteElement profileDeleteRequest) throws java.rmi.RemoteException;

    /**
     * Service definition of function ns__ProfileFetch
     */
    public net.paymentech.ws.ProfileResponseElement profileFetch(net.paymentech.ws.ProfileFetchElement profileFetchRequest) throws java.rmi.RemoteException;

    /**
     * Service definition of function ns__FlexCache
     */
    public net.paymentech.ws.FlexCacheResponseElement flexCache(net.paymentech.ws.FlexCacheElement flexCacheRequest) throws java.rmi.RemoteException;

    /**
     * Service definition of function ns__Unmark
     */
    public net.paymentech.ws.UnmarkResponseElement unmark(net.paymentech.ws.UnmarkElement unmarkRequest) throws java.rmi.RemoteException;

    /**
     * Service definition of function ns__Inquiry
     */
    public net.paymentech.ws.InquiryResponseElement inquiry(net.paymentech.ws.InquiryElement inquiryRequest) throws java.rmi.RemoteException;

    /**
     * Service definition of function ns__AccountUpdater
     */
    public net.paymentech.ws.AccountUpdaterResponseElement accountUpdater(net.paymentech.ws.AccountUpdaterElement auRequest) throws java.rmi.RemoteException;

    /**
     * Service definition of function ns__SafetechFraudAnalysis
     */
    public net.paymentech.ws.SafetechFraudAnalysisResponseElement safetechFraudAnalysis(net.paymentech.ws.SafetechFraudAnalysisRequestElement safetechFraudAnalysisRequest) throws java.rmi.RemoteException;

    /**
     * Service definition of function ns__EMVHostParametersDownload
     */
    public net.paymentech.ws.EMVParametersResponseElement EMVHostParametersDownload(net.paymentech.ws.EMVParametersRequest emvParametersRequest) throws java.rmi.RemoteException;
}
