/**
 * PaymentechGatewayStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package net.paymentech.ws.PaymentechGateway.wsdl.PaymentechGateway_wsdl;

public class PaymentechGatewayStub extends org.apache.axis.client.Stub implements net.paymentech.ws.PaymentechGateway.wsdl.PaymentechGateway_wsdl.PaymentechGatewayPortType {
    private java.util.Vector cachedSerClasses = new java.util.Vector();
    private java.util.Vector cachedSerQNames = new java.util.Vector();
    private java.util.Vector cachedSerFactories = new java.util.Vector();
    private java.util.Vector cachedDeserFactories = new java.util.Vector();

    static org.apache.axis.description.OperationDesc [] _operations;

    static {
        _operations = new org.apache.axis.description.OperationDesc[17];
        _initOperationDesc1();
        _initOperationDesc2();
    }

    private static void _initOperationDesc1(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("NewOrder");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "newOrderRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "NewOrderRequestElement"), net.paymentech.ws.NewOrderRequestElement.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "NewOrderResponseElement"));
        oper.setReturnClass(net.paymentech.ws.NewOrderResponseElement.class);
        oper.setReturnQName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[0] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("LogMessage");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "logMessageRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "LogMessageRequestElement"), net.paymentech.ws.LogMessageRequestElement.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "LogMessageResponseElement"));
        oper.setReturnClass(net.paymentech.ws.LogMessageResponseElement.class);
        oper.setReturnQName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[1] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("MarkForCapture");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "markForCaptureRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "MarkForCaptureElement"), net.paymentech.ws.MarkForCaptureElement.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "MarkForCaptureResponseElement"));
        oper.setReturnClass(net.paymentech.ws.MarkForCaptureResponseElement.class);
        oper.setReturnQName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[2] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("MarkForCapture2");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "markForCaptureRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "MarkForCapture2Element"), net.paymentech.ws.MarkForCapture2Element.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "MarkForCaptureResponse2Element"));
        oper.setReturnClass(net.paymentech.ws.MarkForCaptureResponse2Element.class);
        oper.setReturnQName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[3] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("MFC");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "mfcRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "MFCElement"), net.paymentech.ws.MFCElement.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "MFCResponseElement"));
        oper.setReturnClass(net.paymentech.ws.MFCResponseElement.class);
        oper.setReturnQName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[4] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("Reversal");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "reversalRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "ReversalElement"), net.paymentech.ws.ReversalElement.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "ReversalResponseElement"));
        oper.setReturnClass(net.paymentech.ws.ReversalResponseElement.class);
        oper.setReturnQName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[5] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("EndOfDay");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "endOfDayRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "EndOfDayElement"), net.paymentech.ws.EndOfDayElement.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "EndOfDayResponseElement"));
        oper.setReturnClass(net.paymentech.ws.EndOfDayResponseElement.class);
        oper.setReturnQName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[6] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ProfileAdd");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "profileAddRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "ProfileAddElement"), net.paymentech.ws.ProfileAddElement.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "ProfileResponseElement"));
        oper.setReturnClass(net.paymentech.ws.ProfileResponseElement.class);
        oper.setReturnQName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[7] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ProfileChange");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "profileChangeRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "ProfileChangeElement"), net.paymentech.ws.ProfileChangeElement.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "ProfileResponseElement"));
        oper.setReturnClass(net.paymentech.ws.ProfileResponseElement.class);
        oper.setReturnQName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[8] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ProfileDelete");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "profileDeleteRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "ProfileDeleteElement"), net.paymentech.ws.ProfileDeleteElement.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "ProfileResponseElement"));
        oper.setReturnClass(net.paymentech.ws.ProfileResponseElement.class);
        oper.setReturnQName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[9] = oper;

    }

    private static void _initOperationDesc2(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ProfileFetch");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "profileFetchRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "ProfileFetchElement"), net.paymentech.ws.ProfileFetchElement.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "ProfileResponseElement"));
        oper.setReturnClass(net.paymentech.ws.ProfileResponseElement.class);
        oper.setReturnQName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[10] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("FlexCache");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "flexCacheRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "FlexCacheElement"), net.paymentech.ws.FlexCacheElement.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "FlexCacheResponseElement"));
        oper.setReturnClass(net.paymentech.ws.FlexCacheResponseElement.class);
        oper.setReturnQName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[11] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("Unmark");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "unmarkRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "UnmarkElement"), net.paymentech.ws.UnmarkElement.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "UnmarkResponseElement"));
        oper.setReturnClass(net.paymentech.ws.UnmarkResponseElement.class);
        oper.setReturnQName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[12] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("Inquiry");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "inquiryRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "InquiryElement"), net.paymentech.ws.InquiryElement.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "InquiryResponseElement"));
        oper.setReturnClass(net.paymentech.ws.InquiryResponseElement.class);
        oper.setReturnQName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[13] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("AccountUpdater");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "auRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "AccountUpdaterElement"), net.paymentech.ws.AccountUpdaterElement.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "AccountUpdaterResponseElement"));
        oper.setReturnClass(net.paymentech.ws.AccountUpdaterResponseElement.class);
        oper.setReturnQName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[14] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("SafetechFraudAnalysis");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "safetechFraudAnalysisRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "SafetechFraudAnalysisRequestElement"), net.paymentech.ws.SafetechFraudAnalysisRequestElement.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "SafetechFraudAnalysisResponseElement"));
        oper.setReturnClass(net.paymentech.ws.SafetechFraudAnalysisResponseElement.class);
        oper.setReturnQName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[15] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("EMVHostParametersDownload");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "emvParametersRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "EMVParametersRequest"), net.paymentech.ws.EMVParametersRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "EMVParametersResponseElement"));
        oper.setReturnClass(net.paymentech.ws.EMVParametersResponseElement.class);
        oper.setReturnQName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[16] = oper;

    }

    public PaymentechGatewayStub() throws org.apache.axis.AxisFault {
         this(null);
    }

    public PaymentechGatewayStub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
         this(service);
         super.cachedEndpoint = endpointURL;
    }

    public PaymentechGatewayStub(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
        if (service == null) {
            super.service = new org.apache.axis.client.Service();
        } else {
            super.service = service;
        }
        ((org.apache.axis.client.Service)super.service).setTypeMappingVersion("1.2");
            java.lang.Class cls;
            javax.xml.namespace.QName qName;
            javax.xml.namespace.QName qName2;
            java.lang.Class beansf = org.apache.axis.encoding.ser.BeanSerializerFactory.class;
            java.lang.Class beandf = org.apache.axis.encoding.ser.BeanDeserializerFactory.class;
            java.lang.Class enumsf = org.apache.axis.encoding.ser.EnumSerializerFactory.class;
            java.lang.Class enumdf = org.apache.axis.encoding.ser.EnumDeserializerFactory.class;
            java.lang.Class arraysf = org.apache.axis.encoding.ser.ArraySerializerFactory.class;
            java.lang.Class arraydf = org.apache.axis.encoding.ser.ArrayDeserializerFactory.class;
            java.lang.Class simplesf = org.apache.axis.encoding.ser.SimpleSerializerFactory.class;
            java.lang.Class simpledf = org.apache.axis.encoding.ser.SimpleDeserializerFactory.class;
            java.lang.Class simplelistsf = org.apache.axis.encoding.ser.SimpleListSerializerFactory.class;
            java.lang.Class simplelistdf = org.apache.axis.encoding.ser.SimpleListDeserializerFactory.class;
            qName = new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "AccountUpdaterElement");
            cachedSerQNames.add(qName);
            cls = net.paymentech.ws.AccountUpdaterElement.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "AccountUpdaterResponseElement");
            cachedSerQNames.add(qName);
            cls = net.paymentech.ws.AccountUpdaterResponseElement.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "BaseElementsType");
            cachedSerQNames.add(qName);
            cls = net.paymentech.ws.BaseElementsType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "EMVParametersRequest");
            cachedSerQNames.add(qName);
            cls = net.paymentech.ws.EMVParametersRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "EMVParametersResponseElement");
            cachedSerQNames.add(qName);
            cls = net.paymentech.ws.EMVParametersResponseElement.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "EMVProviderLineItem");
            cachedSerQNames.add(qName);
            cls = net.paymentech.ws.EMVProviderLineItem.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "EMVProviderLineItemArray");
            cachedSerQNames.add(qName);
            cls = net.paymentech.ws.EMVProviderLineItem[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "EMVProviderLineItem");
            qName2 = new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "EMVPublicKeyLineItem");
            cachedSerQNames.add(qName);
            cls = net.paymentech.ws.EMVPublicKeyLineItem.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "EMVPublicKeyLineItemArray");
            cachedSerQNames.add(qName);
            cls = net.paymentech.ws.EMVPublicKeyLineItem[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "EMVPublicKeyLineItem");
            qName2 = new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "EndOfDayElement");
            cachedSerQNames.add(qName);
            cls = net.paymentech.ws.EndOfDayElement.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "EndOfDayResponseElement");
            cachedSerQNames.add(qName);
            cls = net.paymentech.ws.EndOfDayResponseElement.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "FlexCacheElement");
            cachedSerQNames.add(qName);
            cls = net.paymentech.ws.FlexCacheElement.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "FlexCacheResponseElement");
            cachedSerQNames.add(qName);
            cls = net.paymentech.ws.FlexCacheResponseElement.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "FraudAnalysisResponseType");
            cachedSerQNames.add(qName);
            cls = net.paymentech.ws.FraudAnalysisResponseType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "FraudAnalysisType");
            cachedSerQNames.add(qName);
            cls = net.paymentech.ws.FraudAnalysisType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "InquiryElement");
            cachedSerQNames.add(qName);
            cls = net.paymentech.ws.InquiryElement.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "InquiryResponseElement");
            cachedSerQNames.add(qName);
            cls = net.paymentech.ws.InquiryResponseElement.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "LogMessageRequestElement");
            cachedSerQNames.add(qName);
            cls = net.paymentech.ws.LogMessageRequestElement.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "LogMessageResponseElement");
            cachedSerQNames.add(qName);
            cls = net.paymentech.ws.LogMessageResponseElement.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "MarkForCapture2Element");
            cachedSerQNames.add(qName);
            cls = net.paymentech.ws.MarkForCapture2Element.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "MarkForCaptureElement");
            cachedSerQNames.add(qName);
            cls = net.paymentech.ws.MarkForCaptureElement.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "MarkForCaptureResponse2Element");
            cachedSerQNames.add(qName);
            cls = net.paymentech.ws.MarkForCaptureResponse2Element.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "MarkForCaptureResponseElement");
            cachedSerQNames.add(qName);
            cls = net.paymentech.ws.MarkForCaptureResponseElement.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "MFCElement");
            cachedSerQNames.add(qName);
            cls = net.paymentech.ws.MFCElement.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "MFCResponseElement");
            cachedSerQNames.add(qName);
            cls = net.paymentech.ws.MFCResponseElement.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "NewOrderRequestElement");
            cachedSerQNames.add(qName);
            cls = net.paymentech.ws.NewOrderRequestElement.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "NewOrderResponseElement");
            cachedSerQNames.add(qName);
            cls = net.paymentech.ws.NewOrderResponseElement.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "PC3LineItem");
            cachedSerQNames.add(qName);
            cls = net.paymentech.ws.PC3LineItem.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "PC3LineItemArray");
            cachedSerQNames.add(qName);
            cls = net.paymentech.ws.PC3LineItem[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "PC3LineItem");
            qName2 = new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "ProfileAddElement");
            cachedSerQNames.add(qName);
            cls = net.paymentech.ws.ProfileAddElement.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "ProfileChangeElement");
            cachedSerQNames.add(qName);
            cls = net.paymentech.ws.ProfileChangeElement.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "ProfileDeleteElement");
            cachedSerQNames.add(qName);
            cls = net.paymentech.ws.ProfileDeleteElement.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "ProfileFetchElement");
            cachedSerQNames.add(qName);
            cls = net.paymentech.ws.ProfileFetchElement.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "ProfileResponseElement");
            cachedSerQNames.add(qName);
            cls = net.paymentech.ws.ProfileResponseElement.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "ReversalElement");
            cachedSerQNames.add(qName);
            cls = net.paymentech.ws.ReversalElement.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "ReversalResponseElement");
            cachedSerQNames.add(qName);
            cls = net.paymentech.ws.ReversalResponseElement.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "SafetechFraudAnalysisRequestElement");
            cachedSerQNames.add(qName);
            cls = net.paymentech.ws.SafetechFraudAnalysisRequestElement.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "SafetechFraudAnalysisResponseElement");
            cachedSerQNames.add(qName);
            cls = net.paymentech.ws.SafetechFraudAnalysisResponseElement.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "SoftMerchantDescriptorsType");
            cachedSerQNames.add(qName);
            cls = net.paymentech.ws.SoftMerchantDescriptorsType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "UnmarkElement");
            cachedSerQNames.add(qName);
            cls = net.paymentech.ws.UnmarkElement.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "UnmarkResponseElement");
            cachedSerQNames.add(qName);
            cls = net.paymentech.ws.UnmarkResponseElement.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

    }

    protected org.apache.axis.client.Call createCall() throws java.rmi.RemoteException {
        try {
            org.apache.axis.client.Call _call = super._createCall();
            if (super.maintainSessionSet) {
                _call.setMaintainSession(super.maintainSession);
            }
            if (super.cachedUsername != null) {
                _call.setUsername(super.cachedUsername);
            }
            if (super.cachedPassword != null) {
                _call.setPassword(super.cachedPassword);
            }
            if (super.cachedEndpoint != null) {
                _call.setTargetEndpointAddress(super.cachedEndpoint);
            }
            if (super.cachedTimeout != null) {
                _call.setTimeout(super.cachedTimeout);
            }
            if (super.cachedPortName != null) {
                _call.setPortName(super.cachedPortName);
            }
            java.util.Enumeration keys = super.cachedProperties.keys();
            while (keys.hasMoreElements()) {
                java.lang.String key = (java.lang.String) keys.nextElement();
                _call.setProperty(key, super.cachedProperties.get(key));
            }
            // All the type mapping information is registered
            // when the first call is made.
            // The type mapping information is actually registered in
            // the TypeMappingRegistry of the service, which
            // is the reason why registration is only needed for the first call.
            synchronized (this) {
                if (firstCall()) {
                    // must set encoding style before registering serializers
                    _call.setEncodingStyle(null);
                    for (int i = 0; i < cachedSerFactories.size(); ++i) {
                        java.lang.Class cls = (java.lang.Class) cachedSerClasses.get(i);
                        javax.xml.namespace.QName qName =
                                (javax.xml.namespace.QName) cachedSerQNames.get(i);
                        java.lang.Object x = cachedSerFactories.get(i);
                        if (x instanceof Class) {
                            java.lang.Class sf = (java.lang.Class)
                                 cachedSerFactories.get(i);
                            java.lang.Class df = (java.lang.Class)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                        else if (x instanceof javax.xml.rpc.encoding.SerializerFactory) {
                            org.apache.axis.encoding.SerializerFactory sf = (org.apache.axis.encoding.SerializerFactory)
                                 cachedSerFactories.get(i);
                            org.apache.axis.encoding.DeserializerFactory df = (org.apache.axis.encoding.DeserializerFactory)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                    }
                }
            }
            return _call;
        }
        catch (java.lang.Throwable _t) {
            throw new org.apache.axis.AxisFault("Failure trying to get the Call object", _t);
        }
    }

    public net.paymentech.ws.NewOrderResponseElement newOrder(net.paymentech.ws.NewOrderRequestElement newOrderRequest) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[0]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "NewOrder"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {newOrderRequest});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (net.paymentech.ws.NewOrderResponseElement) _resp;
            } catch (java.lang.Exception _exception) {
                return (net.paymentech.ws.NewOrderResponseElement) org.apache.axis.utils.JavaUtils.convert(_resp, net.paymentech.ws.NewOrderResponseElement.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public net.paymentech.ws.LogMessageResponseElement logMessage(net.paymentech.ws.LogMessageRequestElement logMessageRequest) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[1]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "LogMessage"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {logMessageRequest});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (net.paymentech.ws.LogMessageResponseElement) _resp;
            } catch (java.lang.Exception _exception) {
                return (net.paymentech.ws.LogMessageResponseElement) org.apache.axis.utils.JavaUtils.convert(_resp, net.paymentech.ws.LogMessageResponseElement.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public net.paymentech.ws.MarkForCaptureResponseElement markForCapture(net.paymentech.ws.MarkForCaptureElement markForCaptureRequest) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[2]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "MarkForCapture"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {markForCaptureRequest});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (net.paymentech.ws.MarkForCaptureResponseElement) _resp;
            } catch (java.lang.Exception _exception) {
                return (net.paymentech.ws.MarkForCaptureResponseElement) org.apache.axis.utils.JavaUtils.convert(_resp, net.paymentech.ws.MarkForCaptureResponseElement.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public net.paymentech.ws.MarkForCaptureResponse2Element markForCapture2(net.paymentech.ws.MarkForCapture2Element markForCaptureRequest) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[3]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "MarkForCapture2"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {markForCaptureRequest});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (net.paymentech.ws.MarkForCaptureResponse2Element) _resp;
            } catch (java.lang.Exception _exception) {
                return (net.paymentech.ws.MarkForCaptureResponse2Element) org.apache.axis.utils.JavaUtils.convert(_resp, net.paymentech.ws.MarkForCaptureResponse2Element.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public net.paymentech.ws.MFCResponseElement MFC(net.paymentech.ws.MFCElement mfcRequest) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[4]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "MFC"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {mfcRequest});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (net.paymentech.ws.MFCResponseElement) _resp;
            } catch (java.lang.Exception _exception) {
                return (net.paymentech.ws.MFCResponseElement) org.apache.axis.utils.JavaUtils.convert(_resp, net.paymentech.ws.MFCResponseElement.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public net.paymentech.ws.ReversalResponseElement reversal(net.paymentech.ws.ReversalElement reversalRequest) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[5]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "Reversal"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {reversalRequest});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (net.paymentech.ws.ReversalResponseElement) _resp;
            } catch (java.lang.Exception _exception) {
                return (net.paymentech.ws.ReversalResponseElement) org.apache.axis.utils.JavaUtils.convert(_resp, net.paymentech.ws.ReversalResponseElement.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public net.paymentech.ws.EndOfDayResponseElement endOfDay(net.paymentech.ws.EndOfDayElement endOfDayRequest) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[6]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "EndOfDay"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {endOfDayRequest});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (net.paymentech.ws.EndOfDayResponseElement) _resp;
            } catch (java.lang.Exception _exception) {
                return (net.paymentech.ws.EndOfDayResponseElement) org.apache.axis.utils.JavaUtils.convert(_resp, net.paymentech.ws.EndOfDayResponseElement.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public net.paymentech.ws.ProfileResponseElement profileAdd(net.paymentech.ws.ProfileAddElement profileAddRequest) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[7]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "ProfileAdd"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {profileAddRequest});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (net.paymentech.ws.ProfileResponseElement) _resp;
            } catch (java.lang.Exception _exception) {
                return (net.paymentech.ws.ProfileResponseElement) org.apache.axis.utils.JavaUtils.convert(_resp, net.paymentech.ws.ProfileResponseElement.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public net.paymentech.ws.ProfileResponseElement profileChange(net.paymentech.ws.ProfileChangeElement profileChangeRequest) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[8]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "ProfileChange"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {profileChangeRequest});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (net.paymentech.ws.ProfileResponseElement) _resp;
            } catch (java.lang.Exception _exception) {
                return (net.paymentech.ws.ProfileResponseElement) org.apache.axis.utils.JavaUtils.convert(_resp, net.paymentech.ws.ProfileResponseElement.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public net.paymentech.ws.ProfileResponseElement profileDelete(net.paymentech.ws.ProfileDeleteElement profileDeleteRequest) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[9]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "ProfileDelete"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {profileDeleteRequest});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (net.paymentech.ws.ProfileResponseElement) _resp;
            } catch (java.lang.Exception _exception) {
                return (net.paymentech.ws.ProfileResponseElement) org.apache.axis.utils.JavaUtils.convert(_resp, net.paymentech.ws.ProfileResponseElement.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public net.paymentech.ws.ProfileResponseElement profileFetch(net.paymentech.ws.ProfileFetchElement profileFetchRequest) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[10]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "ProfileFetch"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {profileFetchRequest});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (net.paymentech.ws.ProfileResponseElement) _resp;
            } catch (java.lang.Exception _exception) {
                return (net.paymentech.ws.ProfileResponseElement) org.apache.axis.utils.JavaUtils.convert(_resp, net.paymentech.ws.ProfileResponseElement.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public net.paymentech.ws.FlexCacheResponseElement flexCache(net.paymentech.ws.FlexCacheElement flexCacheRequest) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[11]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "FlexCache"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {flexCacheRequest});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (net.paymentech.ws.FlexCacheResponseElement) _resp;
            } catch (java.lang.Exception _exception) {
                return (net.paymentech.ws.FlexCacheResponseElement) org.apache.axis.utils.JavaUtils.convert(_resp, net.paymentech.ws.FlexCacheResponseElement.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public net.paymentech.ws.UnmarkResponseElement unmark(net.paymentech.ws.UnmarkElement unmarkRequest) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[12]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "Unmark"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {unmarkRequest});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (net.paymentech.ws.UnmarkResponseElement) _resp;
            } catch (java.lang.Exception _exception) {
                return (net.paymentech.ws.UnmarkResponseElement) org.apache.axis.utils.JavaUtils.convert(_resp, net.paymentech.ws.UnmarkResponseElement.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public net.paymentech.ws.InquiryResponseElement inquiry(net.paymentech.ws.InquiryElement inquiryRequest) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[13]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "Inquiry"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {inquiryRequest});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (net.paymentech.ws.InquiryResponseElement) _resp;
            } catch (java.lang.Exception _exception) {
                return (net.paymentech.ws.InquiryResponseElement) org.apache.axis.utils.JavaUtils.convert(_resp, net.paymentech.ws.InquiryResponseElement.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public net.paymentech.ws.AccountUpdaterResponseElement accountUpdater(net.paymentech.ws.AccountUpdaterElement auRequest) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[14]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "AccountUpdater"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {auRequest});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (net.paymentech.ws.AccountUpdaterResponseElement) _resp;
            } catch (java.lang.Exception _exception) {
                return (net.paymentech.ws.AccountUpdaterResponseElement) org.apache.axis.utils.JavaUtils.convert(_resp, net.paymentech.ws.AccountUpdaterResponseElement.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public net.paymentech.ws.SafetechFraudAnalysisResponseElement safetechFraudAnalysis(net.paymentech.ws.SafetechFraudAnalysisRequestElement safetechFraudAnalysisRequest) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[15]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "SafetechFraudAnalysis"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {safetechFraudAnalysisRequest});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (net.paymentech.ws.SafetechFraudAnalysisResponseElement) _resp;
            } catch (java.lang.Exception _exception) {
                return (net.paymentech.ws.SafetechFraudAnalysisResponseElement) org.apache.axis.utils.JavaUtils.convert(_resp, net.paymentech.ws.SafetechFraudAnalysisResponseElement.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public net.paymentech.ws.EMVParametersResponseElement EMVHostParametersDownload(net.paymentech.ws.EMVParametersRequest emvParametersRequest) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[16]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "EMVHostParametersDownload"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {emvParametersRequest});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (net.paymentech.ws.EMVParametersResponseElement) _resp;
            } catch (java.lang.Exception _exception) {
                return (net.paymentech.ws.EMVParametersResponseElement) org.apache.axis.utils.JavaUtils.convert(_resp, net.paymentech.ws.EMVParametersResponseElement.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

}
