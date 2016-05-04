/**
 * NewOrderRequestElement.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package net.paymentech.ws;

public class NewOrderRequestElement  implements java.io.Serializable {
    private java.lang.String orbitalConnectionUsername;

    private java.lang.String orbitalConnectionPassword;

    private java.lang.String version;

    private java.lang.String industryType;

    private java.lang.String transType;

    private java.lang.String bin;

    private java.lang.String merchantID;

    private java.lang.String terminalID;

    private java.lang.String cardBrand;

    private java.lang.String ccAccountNum;

    private java.lang.String encryptedPan;

    private java.lang.String encryptedPanMethod;

    private java.lang.String encryptedPanKey;

    private java.lang.String encryptedPanPublicKeyFingerPrint;

    private java.lang.String encryptedPanHash;

    private java.lang.String ccExp;

    private java.lang.String ccCardVerifyPresenceInd;

    private java.lang.String ccCardVerifyNum;

    private java.lang.String switchSoloIssueNum;

    private java.lang.String switchSoloCardStartDate;

    private java.lang.String ecpCheckRT;

    private java.lang.String ecpCheckDDA;

    private java.lang.String ecpBankAcctType;

    private java.lang.String ecpAuthMethod;

    private java.lang.String ecpDelvMethod;

    private java.lang.String avsZip;

    private java.lang.String avsAddress1;

    private java.lang.String avsAddress2;

    private java.lang.String avsCity;

    private java.lang.String avsState;

    private java.lang.String avsName;

    private java.lang.String avsCountryCode;

    private java.lang.String avsPhone;

    private java.lang.String useCustomerRefNum;

    private java.lang.String addProfileFromOrder;

    private java.lang.String customerRefNum;

    private java.lang.String profileOrderOverideInd;

    private java.lang.String authenticationECIInd;

    private java.lang.String verifyByVisaCAVV;

    private java.lang.String verifyByVisaXID;

    private java.lang.String priorAuthCd;

    private java.lang.String orderID;

    private java.lang.String amount;

    private java.lang.String comments;

    private java.lang.String shippingRef;

    private java.lang.String taxInd;

    private java.lang.String taxAmount;

    private java.lang.String amexTranAdvAddn1;

    private java.lang.String amexTranAdvAddn2;

    private java.lang.String amexTranAdvAddn3;

    private java.lang.String amexTranAdvAddn4;

    private java.lang.String mcSecureCodeAAV;

    private java.lang.String softDescMercName;

    private java.lang.String softDescProdDesc;

    private java.lang.String softDescMercCity;

    private java.lang.String softDescMercPhone;

    private java.lang.String softDescMercURL;

    private java.lang.String softDescMercEmail;

    private java.lang.String recurringInd;

    private java.lang.String txRefNum;

    private java.lang.String retryTrace;

    private java.lang.String pCardOrderID;

    private java.lang.String pCardDestZip;

    private java.lang.String pCardDestName;

    private java.lang.String pCardDestAddress;

    private java.lang.String pCardDestAddress2;

    private java.lang.String pCardDestCity;

    private java.lang.String pCardDestStateCd;

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

    private java.lang.String magStripeTrack1;

    private java.lang.String magStripeTrack2;

    private java.lang.String retailTransInfo;

    private java.lang.String customerName;

    private java.lang.String customerEmail;

    private java.lang.String customerPhone;

    private java.lang.String cardPresentInd;

    private java.lang.String euddBankSortCode;

    private java.lang.String euddCountryCode;

    private java.lang.String euddRibCode;

    private java.lang.String euddBankBranchCode;

    private java.lang.String euddIBAN;

    private java.lang.String euddBIC;

    private java.lang.String euddMandateSignatureDate;

    private java.lang.String euddMandateID;

    private java.lang.String euddMandateType;

    private java.lang.String paymentInd;

    private java.lang.String bmlCustomerIP;

    private java.lang.String bmlCustomerEmail;

    private java.lang.String bmlShippingCost;

    private java.lang.String bmlTNCVersion;

    private java.lang.String bmlCustomerRegistrationDate;

    private java.lang.String bmlCustomerTypeFlag;

    private java.lang.String bmlItemCategory;

    private java.lang.String bmlPreapprovalInvitationNum;

    private java.lang.String bmlMerchantPromotionalCode;

    private java.lang.String bmlCustomerBirthDate;

    private java.lang.String bmlCustomerSSN;

    private java.lang.String bmlCustomerAnnualIncome;

    private java.lang.String bmlCustomerResidenceStatus;

    private java.lang.String bmlCustomerCheckingAccount;

    private java.lang.String bmlCustomerSavingsAccount;

    private java.lang.String bmlProductDeliveryType;

    private java.lang.String avsDestName;

    private java.lang.String avsDestAddress1;

    private java.lang.String avsDestAddress2;

    private java.lang.String avsDestCity;

    private java.lang.String avsDestState;

    private java.lang.String avsDestZip;

    private java.lang.String avsDestCountryCode;

    private java.lang.String avsDestPhoneNum;

    private java.lang.String debitBillerReferenceNumber;

    private java.lang.String mbType;

    private java.lang.String mbOrderIdGenerationMethod;

    private java.lang.String mbRecurringStartDate;

    private java.lang.String mbRecurringEndDate;

    private java.lang.String mbRecurringNoEndDateFlag;

    private java.lang.String mbRecurringMaxBillings;

    private java.lang.String mbRecurringFrequency;

    private java.lang.String mbMicroPaymentMaxDollarValue;

    private java.lang.String mbMicroPaymentMaxBillingDays;

    private java.lang.String mbMicroPaymentMaxTransactions;

    private java.lang.String mbDeferredBillDate;

    private java.lang.String debitPinNumber;

    private java.lang.String debitPinSecurityControl;

    private java.lang.String debitPinCashBack;

    private java.lang.String partialAuthInd;

    private java.lang.String accountUpdaterEligibility;

    private java.lang.String useStoredAAVInd;

    private java.lang.String ecpActionCode;

    private java.lang.String ecpCheckSerialNumber;

    private java.lang.String ecpTerminalCity;

    private java.lang.String ecpTerminalState;

    private java.lang.String ecpImageReferenceNumber;

    private java.lang.String customerAni;

    private java.lang.String avsPhoneType;

    private java.lang.String avsDestPhoneType;

    private java.lang.String customerIpAddress;

    private java.lang.String emailAddressSubtype;

    private java.lang.String customerBrowserName;

    private java.lang.String shippingMethod;

    private net.paymentech.ws.FraudAnalysisType fraudAnalysis;

    private net.paymentech.ws.SoftMerchantDescriptorsType softMerchantDescriptors;

    private java.lang.String latitudeLongitude;

    private java.lang.String politicalTimeZone;

    private java.lang.String vendorID;

    private java.lang.String softwareID;

    private java.lang.String mobileDeviceType;

    private java.lang.String deviceID;

    private java.lang.String localDateTime;

    private java.lang.String readerSerialNumber;

    private java.lang.String keySerialNumber;

    private java.lang.String encryptedMagStripeTrack2;

    private java.lang.String encryptionInd;

    private java.lang.String cardIndicators;

    private java.lang.String tipAmt;

    private java.lang.String discountAmt;

    private java.lang.String txnSurchargeAmt;

    private java.lang.String paymentActionInd;

    private java.lang.String dpanInd;

    private java.lang.String axAEVV;

    private java.lang.String posEntryMode;

    private java.lang.String dataEntrySource;

    private java.lang.String panSequenceNumber;

    private java.lang.String applicationId;

    private java.lang.String applicationLabel;

    private java.lang.String chipCardData;

    private java.lang.String pin;

    private java.lang.String pinKeySerialNumber;

    private java.lang.String tvr;

    private java.lang.String tsi;

    private java.lang.String attendedTerminal;

    private java.lang.String terminalLocation;

    private java.lang.String cardholderPresent;

    private java.lang.String cardholderActivatedTerminal;

    private java.lang.String terminalEntry;

    private java.lang.String terminalLaneId;

    private java.lang.String emvSupport;

    private java.lang.String peripheralSupport;

    private java.lang.String communicationSupport;

    private java.lang.String industrySupport;

    private java.lang.String complianceClass;

    private java.lang.String deviceSecuritySupport;

    private java.lang.String dwWalletID;

    private java.lang.String dwSLI;

    private java.lang.String dwIncentiveInd;

    private java.lang.String digitalWalletType;

    public NewOrderRequestElement() {
    }

    public NewOrderRequestElement(
           java.lang.String orbitalConnectionUsername,
           java.lang.String orbitalConnectionPassword,
           java.lang.String version,
           java.lang.String industryType,
           java.lang.String transType,
           java.lang.String bin,
           java.lang.String merchantID,
           java.lang.String terminalID,
           java.lang.String cardBrand,
           java.lang.String ccAccountNum,
           java.lang.String encryptedPan,
           java.lang.String encryptedPanMethod,
           java.lang.String encryptedPanKey,
           java.lang.String encryptedPanPublicKeyFingerPrint,
           java.lang.String encryptedPanHash,
           java.lang.String ccExp,
           java.lang.String ccCardVerifyPresenceInd,
           java.lang.String ccCardVerifyNum,
           java.lang.String switchSoloIssueNum,
           java.lang.String switchSoloCardStartDate,
           java.lang.String ecpCheckRT,
           java.lang.String ecpCheckDDA,
           java.lang.String ecpBankAcctType,
           java.lang.String ecpAuthMethod,
           java.lang.String ecpDelvMethod,
           java.lang.String avsZip,
           java.lang.String avsAddress1,
           java.lang.String avsAddress2,
           java.lang.String avsCity,
           java.lang.String avsState,
           java.lang.String avsName,
           java.lang.String avsCountryCode,
           java.lang.String avsPhone,
           java.lang.String useCustomerRefNum,
           java.lang.String addProfileFromOrder,
           java.lang.String customerRefNum,
           java.lang.String profileOrderOverideInd,
           java.lang.String authenticationECIInd,
           java.lang.String verifyByVisaCAVV,
           java.lang.String verifyByVisaXID,
           java.lang.String priorAuthCd,
           java.lang.String orderID,
           java.lang.String amount,
           java.lang.String comments,
           java.lang.String shippingRef,
           java.lang.String taxInd,
           java.lang.String taxAmount,
           java.lang.String amexTranAdvAddn1,
           java.lang.String amexTranAdvAddn2,
           java.lang.String amexTranAdvAddn3,
           java.lang.String amexTranAdvAddn4,
           java.lang.String mcSecureCodeAAV,
           java.lang.String softDescMercName,
           java.lang.String softDescProdDesc,
           java.lang.String softDescMercCity,
           java.lang.String softDescMercPhone,
           java.lang.String softDescMercURL,
           java.lang.String softDescMercEmail,
           java.lang.String recurringInd,
           java.lang.String txRefNum,
           java.lang.String retryTrace,
           java.lang.String pCardOrderID,
           java.lang.String pCardDestZip,
           java.lang.String pCardDestName,
           java.lang.String pCardDestAddress,
           java.lang.String pCardDestAddress2,
           java.lang.String pCardDestCity,
           java.lang.String pCardDestStateCd,
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
           net.paymentech.ws.PC3LineItem[] pCard3LineItems,
           java.lang.String magStripeTrack1,
           java.lang.String magStripeTrack2,
           java.lang.String retailTransInfo,
           java.lang.String customerName,
           java.lang.String customerEmail,
           java.lang.String customerPhone,
           java.lang.String cardPresentInd,
           java.lang.String euddBankSortCode,
           java.lang.String euddCountryCode,
           java.lang.String euddRibCode,
           java.lang.String euddBankBranchCode,
           java.lang.String euddIBAN,
           java.lang.String euddBIC,
           java.lang.String euddMandateSignatureDate,
           java.lang.String euddMandateID,
           java.lang.String euddMandateType,
           java.lang.String paymentInd,
           java.lang.String bmlCustomerIP,
           java.lang.String bmlCustomerEmail,
           java.lang.String bmlShippingCost,
           java.lang.String bmlTNCVersion,
           java.lang.String bmlCustomerRegistrationDate,
           java.lang.String bmlCustomerTypeFlag,
           java.lang.String bmlItemCategory,
           java.lang.String bmlPreapprovalInvitationNum,
           java.lang.String bmlMerchantPromotionalCode,
           java.lang.String bmlCustomerBirthDate,
           java.lang.String bmlCustomerSSN,
           java.lang.String bmlCustomerAnnualIncome,
           java.lang.String bmlCustomerResidenceStatus,
           java.lang.String bmlCustomerCheckingAccount,
           java.lang.String bmlCustomerSavingsAccount,
           java.lang.String bmlProductDeliveryType,
           java.lang.String avsDestName,
           java.lang.String avsDestAddress1,
           java.lang.String avsDestAddress2,
           java.lang.String avsDestCity,
           java.lang.String avsDestState,
           java.lang.String avsDestZip,
           java.lang.String avsDestCountryCode,
           java.lang.String avsDestPhoneNum,
           java.lang.String debitBillerReferenceNumber,
           java.lang.String mbType,
           java.lang.String mbOrderIdGenerationMethod,
           java.lang.String mbRecurringStartDate,
           java.lang.String mbRecurringEndDate,
           java.lang.String mbRecurringNoEndDateFlag,
           java.lang.String mbRecurringMaxBillings,
           java.lang.String mbRecurringFrequency,
           java.lang.String mbMicroPaymentMaxDollarValue,
           java.lang.String mbMicroPaymentMaxBillingDays,
           java.lang.String mbMicroPaymentMaxTransactions,
           java.lang.String mbDeferredBillDate,
           java.lang.String debitPinNumber,
           java.lang.String debitPinSecurityControl,
           java.lang.String debitPinCashBack,
           java.lang.String partialAuthInd,
           java.lang.String accountUpdaterEligibility,
           java.lang.String useStoredAAVInd,
           java.lang.String ecpActionCode,
           java.lang.String ecpCheckSerialNumber,
           java.lang.String ecpTerminalCity,
           java.lang.String ecpTerminalState,
           java.lang.String ecpImageReferenceNumber,
           java.lang.String customerAni,
           java.lang.String avsPhoneType,
           java.lang.String avsDestPhoneType,
           java.lang.String customerIpAddress,
           java.lang.String emailAddressSubtype,
           java.lang.String customerBrowserName,
           java.lang.String shippingMethod,
           net.paymentech.ws.FraudAnalysisType fraudAnalysis,
           net.paymentech.ws.SoftMerchantDescriptorsType softMerchantDescriptors,
           java.lang.String latitudeLongitude,
           java.lang.String politicalTimeZone,
           java.lang.String vendorID,
           java.lang.String softwareID,
           java.lang.String mobileDeviceType,
           java.lang.String deviceID,
           java.lang.String localDateTime,
           java.lang.String readerSerialNumber,
           java.lang.String keySerialNumber,
           java.lang.String encryptedMagStripeTrack2,
           java.lang.String encryptionInd,
           java.lang.String cardIndicators,
           java.lang.String tipAmt,
           java.lang.String discountAmt,
           java.lang.String txnSurchargeAmt,
           java.lang.String paymentActionInd,
           java.lang.String dpanInd,
           java.lang.String axAEVV,
           java.lang.String posEntryMode,
           java.lang.String dataEntrySource,
           java.lang.String panSequenceNumber,
           java.lang.String applicationId,
           java.lang.String applicationLabel,
           java.lang.String chipCardData,
           java.lang.String pin,
           java.lang.String pinKeySerialNumber,
           java.lang.String tvr,
           java.lang.String tsi,
           java.lang.String attendedTerminal,
           java.lang.String terminalLocation,
           java.lang.String cardholderPresent,
           java.lang.String cardholderActivatedTerminal,
           java.lang.String terminalEntry,
           java.lang.String terminalLaneId,
           java.lang.String emvSupport,
           java.lang.String peripheralSupport,
           java.lang.String communicationSupport,
           java.lang.String industrySupport,
           java.lang.String complianceClass,
           java.lang.String deviceSecuritySupport,
           java.lang.String dwWalletID,
           java.lang.String dwSLI,
           java.lang.String dwIncentiveInd,
           java.lang.String digitalWalletType) {
           this.orbitalConnectionUsername = orbitalConnectionUsername;
           this.orbitalConnectionPassword = orbitalConnectionPassword;
           this.version = version;
           this.industryType = industryType;
           this.transType = transType;
           this.bin = bin;
           this.merchantID = merchantID;
           this.terminalID = terminalID;
           this.cardBrand = cardBrand;
           this.ccAccountNum = ccAccountNum;
           this.encryptedPan = encryptedPan;
           this.encryptedPanMethod = encryptedPanMethod;
           this.encryptedPanKey = encryptedPanKey;
           this.encryptedPanPublicKeyFingerPrint = encryptedPanPublicKeyFingerPrint;
           this.encryptedPanHash = encryptedPanHash;
           this.ccExp = ccExp;
           this.ccCardVerifyPresenceInd = ccCardVerifyPresenceInd;
           this.ccCardVerifyNum = ccCardVerifyNum;
           this.switchSoloIssueNum = switchSoloIssueNum;
           this.switchSoloCardStartDate = switchSoloCardStartDate;
           this.ecpCheckRT = ecpCheckRT;
           this.ecpCheckDDA = ecpCheckDDA;
           this.ecpBankAcctType = ecpBankAcctType;
           this.ecpAuthMethod = ecpAuthMethod;
           this.ecpDelvMethod = ecpDelvMethod;
           this.avsZip = avsZip;
           this.avsAddress1 = avsAddress1;
           this.avsAddress2 = avsAddress2;
           this.avsCity = avsCity;
           this.avsState = avsState;
           this.avsName = avsName;
           this.avsCountryCode = avsCountryCode;
           this.avsPhone = avsPhone;
           this.useCustomerRefNum = useCustomerRefNum;
           this.addProfileFromOrder = addProfileFromOrder;
           this.customerRefNum = customerRefNum;
           this.profileOrderOverideInd = profileOrderOverideInd;
           this.authenticationECIInd = authenticationECIInd;
           this.verifyByVisaCAVV = verifyByVisaCAVV;
           this.verifyByVisaXID = verifyByVisaXID;
           this.priorAuthCd = priorAuthCd;
           this.orderID = orderID;
           this.amount = amount;
           this.comments = comments;
           this.shippingRef = shippingRef;
           this.taxInd = taxInd;
           this.taxAmount = taxAmount;
           this.amexTranAdvAddn1 = amexTranAdvAddn1;
           this.amexTranAdvAddn2 = amexTranAdvAddn2;
           this.amexTranAdvAddn3 = amexTranAdvAddn3;
           this.amexTranAdvAddn4 = amexTranAdvAddn4;
           this.mcSecureCodeAAV = mcSecureCodeAAV;
           this.softDescMercName = softDescMercName;
           this.softDescProdDesc = softDescProdDesc;
           this.softDescMercCity = softDescMercCity;
           this.softDescMercPhone = softDescMercPhone;
           this.softDescMercURL = softDescMercURL;
           this.softDescMercEmail = softDescMercEmail;
           this.recurringInd = recurringInd;
           this.txRefNum = txRefNum;
           this.retryTrace = retryTrace;
           this.pCardOrderID = pCardOrderID;
           this.pCardDestZip = pCardDestZip;
           this.pCardDestName = pCardDestName;
           this.pCardDestAddress = pCardDestAddress;
           this.pCardDestAddress2 = pCardDestAddress2;
           this.pCardDestCity = pCardDestCity;
           this.pCardDestStateCd = pCardDestStateCd;
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
           this.magStripeTrack1 = magStripeTrack1;
           this.magStripeTrack2 = magStripeTrack2;
           this.retailTransInfo = retailTransInfo;
           this.customerName = customerName;
           this.customerEmail = customerEmail;
           this.customerPhone = customerPhone;
           this.cardPresentInd = cardPresentInd;
           this.euddBankSortCode = euddBankSortCode;
           this.euddCountryCode = euddCountryCode;
           this.euddRibCode = euddRibCode;
           this.euddBankBranchCode = euddBankBranchCode;
           this.euddIBAN = euddIBAN;
           this.euddBIC = euddBIC;
           this.euddMandateSignatureDate = euddMandateSignatureDate;
           this.euddMandateID = euddMandateID;
           this.euddMandateType = euddMandateType;
           this.paymentInd = paymentInd;
           this.bmlCustomerIP = bmlCustomerIP;
           this.bmlCustomerEmail = bmlCustomerEmail;
           this.bmlShippingCost = bmlShippingCost;
           this.bmlTNCVersion = bmlTNCVersion;
           this.bmlCustomerRegistrationDate = bmlCustomerRegistrationDate;
           this.bmlCustomerTypeFlag = bmlCustomerTypeFlag;
           this.bmlItemCategory = bmlItemCategory;
           this.bmlPreapprovalInvitationNum = bmlPreapprovalInvitationNum;
           this.bmlMerchantPromotionalCode = bmlMerchantPromotionalCode;
           this.bmlCustomerBirthDate = bmlCustomerBirthDate;
           this.bmlCustomerSSN = bmlCustomerSSN;
           this.bmlCustomerAnnualIncome = bmlCustomerAnnualIncome;
           this.bmlCustomerResidenceStatus = bmlCustomerResidenceStatus;
           this.bmlCustomerCheckingAccount = bmlCustomerCheckingAccount;
           this.bmlCustomerSavingsAccount = bmlCustomerSavingsAccount;
           this.bmlProductDeliveryType = bmlProductDeliveryType;
           this.avsDestName = avsDestName;
           this.avsDestAddress1 = avsDestAddress1;
           this.avsDestAddress2 = avsDestAddress2;
           this.avsDestCity = avsDestCity;
           this.avsDestState = avsDestState;
           this.avsDestZip = avsDestZip;
           this.avsDestCountryCode = avsDestCountryCode;
           this.avsDestPhoneNum = avsDestPhoneNum;
           this.debitBillerReferenceNumber = debitBillerReferenceNumber;
           this.mbType = mbType;
           this.mbOrderIdGenerationMethod = mbOrderIdGenerationMethod;
           this.mbRecurringStartDate = mbRecurringStartDate;
           this.mbRecurringEndDate = mbRecurringEndDate;
           this.mbRecurringNoEndDateFlag = mbRecurringNoEndDateFlag;
           this.mbRecurringMaxBillings = mbRecurringMaxBillings;
           this.mbRecurringFrequency = mbRecurringFrequency;
           this.mbMicroPaymentMaxDollarValue = mbMicroPaymentMaxDollarValue;
           this.mbMicroPaymentMaxBillingDays = mbMicroPaymentMaxBillingDays;
           this.mbMicroPaymentMaxTransactions = mbMicroPaymentMaxTransactions;
           this.mbDeferredBillDate = mbDeferredBillDate;
           this.debitPinNumber = debitPinNumber;
           this.debitPinSecurityControl = debitPinSecurityControl;
           this.debitPinCashBack = debitPinCashBack;
           this.partialAuthInd = partialAuthInd;
           this.accountUpdaterEligibility = accountUpdaterEligibility;
           this.useStoredAAVInd = useStoredAAVInd;
           this.ecpActionCode = ecpActionCode;
           this.ecpCheckSerialNumber = ecpCheckSerialNumber;
           this.ecpTerminalCity = ecpTerminalCity;
           this.ecpTerminalState = ecpTerminalState;
           this.ecpImageReferenceNumber = ecpImageReferenceNumber;
           this.customerAni = customerAni;
           this.avsPhoneType = avsPhoneType;
           this.avsDestPhoneType = avsDestPhoneType;
           this.customerIpAddress = customerIpAddress;
           this.emailAddressSubtype = emailAddressSubtype;
           this.customerBrowserName = customerBrowserName;
           this.shippingMethod = shippingMethod;
           this.fraudAnalysis = fraudAnalysis;
           this.softMerchantDescriptors = softMerchantDescriptors;
           this.latitudeLongitude = latitudeLongitude;
           this.politicalTimeZone = politicalTimeZone;
           this.vendorID = vendorID;
           this.softwareID = softwareID;
           this.mobileDeviceType = mobileDeviceType;
           this.deviceID = deviceID;
           this.localDateTime = localDateTime;
           this.readerSerialNumber = readerSerialNumber;
           this.keySerialNumber = keySerialNumber;
           this.encryptedMagStripeTrack2 = encryptedMagStripeTrack2;
           this.encryptionInd = encryptionInd;
           this.cardIndicators = cardIndicators;
           this.tipAmt = tipAmt;
           this.discountAmt = discountAmt;
           this.txnSurchargeAmt = txnSurchargeAmt;
           this.paymentActionInd = paymentActionInd;
           this.dpanInd = dpanInd;
           this.axAEVV = axAEVV;
           this.posEntryMode = posEntryMode;
           this.dataEntrySource = dataEntrySource;
           this.panSequenceNumber = panSequenceNumber;
           this.applicationId = applicationId;
           this.applicationLabel = applicationLabel;
           this.chipCardData = chipCardData;
           this.pin = pin;
           this.pinKeySerialNumber = pinKeySerialNumber;
           this.tvr = tvr;
           this.tsi = tsi;
           this.attendedTerminal = attendedTerminal;
           this.terminalLocation = terminalLocation;
           this.cardholderPresent = cardholderPresent;
           this.cardholderActivatedTerminal = cardholderActivatedTerminal;
           this.terminalEntry = terminalEntry;
           this.terminalLaneId = terminalLaneId;
           this.emvSupport = emvSupport;
           this.peripheralSupport = peripheralSupport;
           this.communicationSupport = communicationSupport;
           this.industrySupport = industrySupport;
           this.complianceClass = complianceClass;
           this.deviceSecuritySupport = deviceSecuritySupport;
           this.dwWalletID = dwWalletID;
           this.dwSLI = dwSLI;
           this.dwIncentiveInd = dwIncentiveInd;
           this.digitalWalletType = digitalWalletType;
    }


    /**
     * Gets the orbitalConnectionUsername value for this NewOrderRequestElement.
     * 
     * @return orbitalConnectionUsername
     */
    public java.lang.String getOrbitalConnectionUsername() {
        return orbitalConnectionUsername;
    }


    /**
     * Sets the orbitalConnectionUsername value for this NewOrderRequestElement.
     * 
     * @param orbitalConnectionUsername
     */
    public void setOrbitalConnectionUsername(java.lang.String orbitalConnectionUsername) {
        this.orbitalConnectionUsername = orbitalConnectionUsername;
    }


    /**
     * Gets the orbitalConnectionPassword value for this NewOrderRequestElement.
     * 
     * @return orbitalConnectionPassword
     */
    public java.lang.String getOrbitalConnectionPassword() {
        return orbitalConnectionPassword;
    }


    /**
     * Sets the orbitalConnectionPassword value for this NewOrderRequestElement.
     * 
     * @param orbitalConnectionPassword
     */
    public void setOrbitalConnectionPassword(java.lang.String orbitalConnectionPassword) {
        this.orbitalConnectionPassword = orbitalConnectionPassword;
    }


    /**
     * Gets the version value for this NewOrderRequestElement.
     * 
     * @return version
     */
    public java.lang.String getVersion() {
        return version;
    }


    /**
     * Sets the version value for this NewOrderRequestElement.
     * 
     * @param version
     */
    public void setVersion(java.lang.String version) {
        this.version = version;
    }


    /**
     * Gets the industryType value for this NewOrderRequestElement.
     * 
     * @return industryType
     */
    public java.lang.String getIndustryType() {
        return industryType;
    }


    /**
     * Sets the industryType value for this NewOrderRequestElement.
     * 
     * @param industryType
     */
    public void setIndustryType(java.lang.String industryType) {
        this.industryType = industryType;
    }


    /**
     * Gets the transType value for this NewOrderRequestElement.
     * 
     * @return transType
     */
    public java.lang.String getTransType() {
        return transType;
    }


    /**
     * Sets the transType value for this NewOrderRequestElement.
     * 
     * @param transType
     */
    public void setTransType(java.lang.String transType) {
        this.transType = transType;
    }


    /**
     * Gets the bin value for this NewOrderRequestElement.
     * 
     * @return bin
     */
    public java.lang.String getBin() {
        return bin;
    }


    /**
     * Sets the bin value for this NewOrderRequestElement.
     * 
     * @param bin
     */
    public void setBin(java.lang.String bin) {
        this.bin = bin;
    }


    /**
     * Gets the merchantID value for this NewOrderRequestElement.
     * 
     * @return merchantID
     */
    public java.lang.String getMerchantID() {
        return merchantID;
    }


    /**
     * Sets the merchantID value for this NewOrderRequestElement.
     * 
     * @param merchantID
     */
    public void setMerchantID(java.lang.String merchantID) {
        this.merchantID = merchantID;
    }


    /**
     * Gets the terminalID value for this NewOrderRequestElement.
     * 
     * @return terminalID
     */
    public java.lang.String getTerminalID() {
        return terminalID;
    }


    /**
     * Sets the terminalID value for this NewOrderRequestElement.
     * 
     * @param terminalID
     */
    public void setTerminalID(java.lang.String terminalID) {
        this.terminalID = terminalID;
    }


    /**
     * Gets the cardBrand value for this NewOrderRequestElement.
     * 
     * @return cardBrand
     */
    public java.lang.String getCardBrand() {
        return cardBrand;
    }


    /**
     * Sets the cardBrand value for this NewOrderRequestElement.
     * 
     * @param cardBrand
     */
    public void setCardBrand(java.lang.String cardBrand) {
        this.cardBrand = cardBrand;
    }


    /**
     * Gets the ccAccountNum value for this NewOrderRequestElement.
     * 
     * @return ccAccountNum
     */
    public java.lang.String getCcAccountNum() {
        return ccAccountNum;
    }


    /**
     * Sets the ccAccountNum value for this NewOrderRequestElement.
     * 
     * @param ccAccountNum
     */
    public void setCcAccountNum(java.lang.String ccAccountNum) {
        this.ccAccountNum = ccAccountNum;
    }


    /**
     * Gets the encryptedPan value for this NewOrderRequestElement.
     * 
     * @return encryptedPan
     */
    public java.lang.String getEncryptedPan() {
        return encryptedPan;
    }


    /**
     * Sets the encryptedPan value for this NewOrderRequestElement.
     * 
     * @param encryptedPan
     */
    public void setEncryptedPan(java.lang.String encryptedPan) {
        this.encryptedPan = encryptedPan;
    }


    /**
     * Gets the encryptedPanMethod value for this NewOrderRequestElement.
     * 
     * @return encryptedPanMethod
     */
    public java.lang.String getEncryptedPanMethod() {
        return encryptedPanMethod;
    }


    /**
     * Sets the encryptedPanMethod value for this NewOrderRequestElement.
     * 
     * @param encryptedPanMethod
     */
    public void setEncryptedPanMethod(java.lang.String encryptedPanMethod) {
        this.encryptedPanMethod = encryptedPanMethod;
    }


    /**
     * Gets the encryptedPanKey value for this NewOrderRequestElement.
     * 
     * @return encryptedPanKey
     */
    public java.lang.String getEncryptedPanKey() {
        return encryptedPanKey;
    }


    /**
     * Sets the encryptedPanKey value for this NewOrderRequestElement.
     * 
     * @param encryptedPanKey
     */
    public void setEncryptedPanKey(java.lang.String encryptedPanKey) {
        this.encryptedPanKey = encryptedPanKey;
    }


    /**
     * Gets the encryptedPanPublicKeyFingerPrint value for this NewOrderRequestElement.
     * 
     * @return encryptedPanPublicKeyFingerPrint
     */
    public java.lang.String getEncryptedPanPublicKeyFingerPrint() {
        return encryptedPanPublicKeyFingerPrint;
    }


    /**
     * Sets the encryptedPanPublicKeyFingerPrint value for this NewOrderRequestElement.
     * 
     * @param encryptedPanPublicKeyFingerPrint
     */
    public void setEncryptedPanPublicKeyFingerPrint(java.lang.String encryptedPanPublicKeyFingerPrint) {
        this.encryptedPanPublicKeyFingerPrint = encryptedPanPublicKeyFingerPrint;
    }


    /**
     * Gets the encryptedPanHash value for this NewOrderRequestElement.
     * 
     * @return encryptedPanHash
     */
    public java.lang.String getEncryptedPanHash() {
        return encryptedPanHash;
    }


    /**
     * Sets the encryptedPanHash value for this NewOrderRequestElement.
     * 
     * @param encryptedPanHash
     */
    public void setEncryptedPanHash(java.lang.String encryptedPanHash) {
        this.encryptedPanHash = encryptedPanHash;
    }


    /**
     * Gets the ccExp value for this NewOrderRequestElement.
     * 
     * @return ccExp
     */
    public java.lang.String getCcExp() {
        return ccExp;
    }


    /**
     * Sets the ccExp value for this NewOrderRequestElement.
     * 
     * @param ccExp
     */
    public void setCcExp(java.lang.String ccExp) {
        this.ccExp = ccExp;
    }


    /**
     * Gets the ccCardVerifyPresenceInd value for this NewOrderRequestElement.
     * 
     * @return ccCardVerifyPresenceInd
     */
    public java.lang.String getCcCardVerifyPresenceInd() {
        return ccCardVerifyPresenceInd;
    }


    /**
     * Sets the ccCardVerifyPresenceInd value for this NewOrderRequestElement.
     * 
     * @param ccCardVerifyPresenceInd
     */
    public void setCcCardVerifyPresenceInd(java.lang.String ccCardVerifyPresenceInd) {
        this.ccCardVerifyPresenceInd = ccCardVerifyPresenceInd;
    }


    /**
     * Gets the ccCardVerifyNum value for this NewOrderRequestElement.
     * 
     * @return ccCardVerifyNum
     */
    public java.lang.String getCcCardVerifyNum() {
        return ccCardVerifyNum;
    }


    /**
     * Sets the ccCardVerifyNum value for this NewOrderRequestElement.
     * 
     * @param ccCardVerifyNum
     */
    public void setCcCardVerifyNum(java.lang.String ccCardVerifyNum) {
        this.ccCardVerifyNum = ccCardVerifyNum;
    }


    /**
     * Gets the switchSoloIssueNum value for this NewOrderRequestElement.
     * 
     * @return switchSoloIssueNum
     */
    public java.lang.String getSwitchSoloIssueNum() {
        return switchSoloIssueNum;
    }


    /**
     * Sets the switchSoloIssueNum value for this NewOrderRequestElement.
     * 
     * @param switchSoloIssueNum
     */
    public void setSwitchSoloIssueNum(java.lang.String switchSoloIssueNum) {
        this.switchSoloIssueNum = switchSoloIssueNum;
    }


    /**
     * Gets the switchSoloCardStartDate value for this NewOrderRequestElement.
     * 
     * @return switchSoloCardStartDate
     */
    public java.lang.String getSwitchSoloCardStartDate() {
        return switchSoloCardStartDate;
    }


    /**
     * Sets the switchSoloCardStartDate value for this NewOrderRequestElement.
     * 
     * @param switchSoloCardStartDate
     */
    public void setSwitchSoloCardStartDate(java.lang.String switchSoloCardStartDate) {
        this.switchSoloCardStartDate = switchSoloCardStartDate;
    }


    /**
     * Gets the ecpCheckRT value for this NewOrderRequestElement.
     * 
     * @return ecpCheckRT
     */
    public java.lang.String getEcpCheckRT() {
        return ecpCheckRT;
    }


    /**
     * Sets the ecpCheckRT value for this NewOrderRequestElement.
     * 
     * @param ecpCheckRT
     */
    public void setEcpCheckRT(java.lang.String ecpCheckRT) {
        this.ecpCheckRT = ecpCheckRT;
    }


    /**
     * Gets the ecpCheckDDA value for this NewOrderRequestElement.
     * 
     * @return ecpCheckDDA
     */
    public java.lang.String getEcpCheckDDA() {
        return ecpCheckDDA;
    }


    /**
     * Sets the ecpCheckDDA value for this NewOrderRequestElement.
     * 
     * @param ecpCheckDDA
     */
    public void setEcpCheckDDA(java.lang.String ecpCheckDDA) {
        this.ecpCheckDDA = ecpCheckDDA;
    }


    /**
     * Gets the ecpBankAcctType value for this NewOrderRequestElement.
     * 
     * @return ecpBankAcctType
     */
    public java.lang.String getEcpBankAcctType() {
        return ecpBankAcctType;
    }


    /**
     * Sets the ecpBankAcctType value for this NewOrderRequestElement.
     * 
     * @param ecpBankAcctType
     */
    public void setEcpBankAcctType(java.lang.String ecpBankAcctType) {
        this.ecpBankAcctType = ecpBankAcctType;
    }


    /**
     * Gets the ecpAuthMethod value for this NewOrderRequestElement.
     * 
     * @return ecpAuthMethod
     */
    public java.lang.String getEcpAuthMethod() {
        return ecpAuthMethod;
    }


    /**
     * Sets the ecpAuthMethod value for this NewOrderRequestElement.
     * 
     * @param ecpAuthMethod
     */
    public void setEcpAuthMethod(java.lang.String ecpAuthMethod) {
        this.ecpAuthMethod = ecpAuthMethod;
    }


    /**
     * Gets the ecpDelvMethod value for this NewOrderRequestElement.
     * 
     * @return ecpDelvMethod
     */
    public java.lang.String getEcpDelvMethod() {
        return ecpDelvMethod;
    }


    /**
     * Sets the ecpDelvMethod value for this NewOrderRequestElement.
     * 
     * @param ecpDelvMethod
     */
    public void setEcpDelvMethod(java.lang.String ecpDelvMethod) {
        this.ecpDelvMethod = ecpDelvMethod;
    }


    /**
     * Gets the avsZip value for this NewOrderRequestElement.
     * 
     * @return avsZip
     */
    public java.lang.String getAvsZip() {
        return avsZip;
    }


    /**
     * Sets the avsZip value for this NewOrderRequestElement.
     * 
     * @param avsZip
     */
    public void setAvsZip(java.lang.String avsZip) {
        this.avsZip = avsZip;
    }


    /**
     * Gets the avsAddress1 value for this NewOrderRequestElement.
     * 
     * @return avsAddress1
     */
    public java.lang.String getAvsAddress1() {
        return avsAddress1;
    }


    /**
     * Sets the avsAddress1 value for this NewOrderRequestElement.
     * 
     * @param avsAddress1
     */
    public void setAvsAddress1(java.lang.String avsAddress1) {
        this.avsAddress1 = avsAddress1;
    }


    /**
     * Gets the avsAddress2 value for this NewOrderRequestElement.
     * 
     * @return avsAddress2
     */
    public java.lang.String getAvsAddress2() {
        return avsAddress2;
    }


    /**
     * Sets the avsAddress2 value for this NewOrderRequestElement.
     * 
     * @param avsAddress2
     */
    public void setAvsAddress2(java.lang.String avsAddress2) {
        this.avsAddress2 = avsAddress2;
    }


    /**
     * Gets the avsCity value for this NewOrderRequestElement.
     * 
     * @return avsCity
     */
    public java.lang.String getAvsCity() {
        return avsCity;
    }


    /**
     * Sets the avsCity value for this NewOrderRequestElement.
     * 
     * @param avsCity
     */
    public void setAvsCity(java.lang.String avsCity) {
        this.avsCity = avsCity;
    }


    /**
     * Gets the avsState value for this NewOrderRequestElement.
     * 
     * @return avsState
     */
    public java.lang.String getAvsState() {
        return avsState;
    }


    /**
     * Sets the avsState value for this NewOrderRequestElement.
     * 
     * @param avsState
     */
    public void setAvsState(java.lang.String avsState) {
        this.avsState = avsState;
    }


    /**
     * Gets the avsName value for this NewOrderRequestElement.
     * 
     * @return avsName
     */
    public java.lang.String getAvsName() {
        return avsName;
    }


    /**
     * Sets the avsName value for this NewOrderRequestElement.
     * 
     * @param avsName
     */
    public void setAvsName(java.lang.String avsName) {
        this.avsName = avsName;
    }


    /**
     * Gets the avsCountryCode value for this NewOrderRequestElement.
     * 
     * @return avsCountryCode
     */
    public java.lang.String getAvsCountryCode() {
        return avsCountryCode;
    }


    /**
     * Sets the avsCountryCode value for this NewOrderRequestElement.
     * 
     * @param avsCountryCode
     */
    public void setAvsCountryCode(java.lang.String avsCountryCode) {
        this.avsCountryCode = avsCountryCode;
    }


    /**
     * Gets the avsPhone value for this NewOrderRequestElement.
     * 
     * @return avsPhone
     */
    public java.lang.String getAvsPhone() {
        return avsPhone;
    }


    /**
     * Sets the avsPhone value for this NewOrderRequestElement.
     * 
     * @param avsPhone
     */
    public void setAvsPhone(java.lang.String avsPhone) {
        this.avsPhone = avsPhone;
    }


    /**
     * Gets the useCustomerRefNum value for this NewOrderRequestElement.
     * 
     * @return useCustomerRefNum
     */
    public java.lang.String getUseCustomerRefNum() {
        return useCustomerRefNum;
    }


    /**
     * Sets the useCustomerRefNum value for this NewOrderRequestElement.
     * 
     * @param useCustomerRefNum
     */
    public void setUseCustomerRefNum(java.lang.String useCustomerRefNum) {
        this.useCustomerRefNum = useCustomerRefNum;
    }


    /**
     * Gets the addProfileFromOrder value for this NewOrderRequestElement.
     * 
     * @return addProfileFromOrder
     */
    public java.lang.String getAddProfileFromOrder() {
        return addProfileFromOrder;
    }


    /**
     * Sets the addProfileFromOrder value for this NewOrderRequestElement.
     * 
     * @param addProfileFromOrder
     */
    public void setAddProfileFromOrder(java.lang.String addProfileFromOrder) {
        this.addProfileFromOrder = addProfileFromOrder;
    }


    /**
     * Gets the customerRefNum value for this NewOrderRequestElement.
     * 
     * @return customerRefNum
     */
    public java.lang.String getCustomerRefNum() {
        return customerRefNum;
    }


    /**
     * Sets the customerRefNum value for this NewOrderRequestElement.
     * 
     * @param customerRefNum
     */
    public void setCustomerRefNum(java.lang.String customerRefNum) {
        this.customerRefNum = customerRefNum;
    }


    /**
     * Gets the profileOrderOverideInd value for this NewOrderRequestElement.
     * 
     * @return profileOrderOverideInd
     */
    public java.lang.String getProfileOrderOverideInd() {
        return profileOrderOverideInd;
    }


    /**
     * Sets the profileOrderOverideInd value for this NewOrderRequestElement.
     * 
     * @param profileOrderOverideInd
     */
    public void setProfileOrderOverideInd(java.lang.String profileOrderOverideInd) {
        this.profileOrderOverideInd = profileOrderOverideInd;
    }


    /**
     * Gets the authenticationECIInd value for this NewOrderRequestElement.
     * 
     * @return authenticationECIInd
     */
    public java.lang.String getAuthenticationECIInd() {
        return authenticationECIInd;
    }


    /**
     * Sets the authenticationECIInd value for this NewOrderRequestElement.
     * 
     * @param authenticationECIInd
     */
    public void setAuthenticationECIInd(java.lang.String authenticationECIInd) {
        this.authenticationECIInd = authenticationECIInd;
    }


    /**
     * Gets the verifyByVisaCAVV value for this NewOrderRequestElement.
     * 
     * @return verifyByVisaCAVV
     */
    public java.lang.String getVerifyByVisaCAVV() {
        return verifyByVisaCAVV;
    }


    /**
     * Sets the verifyByVisaCAVV value for this NewOrderRequestElement.
     * 
     * @param verifyByVisaCAVV
     */
    public void setVerifyByVisaCAVV(java.lang.String verifyByVisaCAVV) {
        this.verifyByVisaCAVV = verifyByVisaCAVV;
    }


    /**
     * Gets the verifyByVisaXID value for this NewOrderRequestElement.
     * 
     * @return verifyByVisaXID
     */
    public java.lang.String getVerifyByVisaXID() {
        return verifyByVisaXID;
    }


    /**
     * Sets the verifyByVisaXID value for this NewOrderRequestElement.
     * 
     * @param verifyByVisaXID
     */
    public void setVerifyByVisaXID(java.lang.String verifyByVisaXID) {
        this.verifyByVisaXID = verifyByVisaXID;
    }


    /**
     * Gets the priorAuthCd value for this NewOrderRequestElement.
     * 
     * @return priorAuthCd
     */
    public java.lang.String getPriorAuthCd() {
        return priorAuthCd;
    }


    /**
     * Sets the priorAuthCd value for this NewOrderRequestElement.
     * 
     * @param priorAuthCd
     */
    public void setPriorAuthCd(java.lang.String priorAuthCd) {
        this.priorAuthCd = priorAuthCd;
    }


    /**
     * Gets the orderID value for this NewOrderRequestElement.
     * 
     * @return orderID
     */
    public java.lang.String getOrderID() {
        return orderID;
    }


    /**
     * Sets the orderID value for this NewOrderRequestElement.
     * 
     * @param orderID
     */
    public void setOrderID(java.lang.String orderID) {
        this.orderID = orderID;
    }


    /**
     * Gets the amount value for this NewOrderRequestElement.
     * 
     * @return amount
     */
    public java.lang.String getAmount() {
        return amount;
    }


    /**
     * Sets the amount value for this NewOrderRequestElement.
     * 
     * @param amount
     */
    public void setAmount(java.lang.String amount) {
        this.amount = amount;
    }


    /**
     * Gets the comments value for this NewOrderRequestElement.
     * 
     * @return comments
     */
    public java.lang.String getComments() {
        return comments;
    }


    /**
     * Sets the comments value for this NewOrderRequestElement.
     * 
     * @param comments
     */
    public void setComments(java.lang.String comments) {
        this.comments = comments;
    }


    /**
     * Gets the shippingRef value for this NewOrderRequestElement.
     * 
     * @return shippingRef
     */
    public java.lang.String getShippingRef() {
        return shippingRef;
    }


    /**
     * Sets the shippingRef value for this NewOrderRequestElement.
     * 
     * @param shippingRef
     */
    public void setShippingRef(java.lang.String shippingRef) {
        this.shippingRef = shippingRef;
    }


    /**
     * Gets the taxInd value for this NewOrderRequestElement.
     * 
     * @return taxInd
     */
    public java.lang.String getTaxInd() {
        return taxInd;
    }


    /**
     * Sets the taxInd value for this NewOrderRequestElement.
     * 
     * @param taxInd
     */
    public void setTaxInd(java.lang.String taxInd) {
        this.taxInd = taxInd;
    }


    /**
     * Gets the taxAmount value for this NewOrderRequestElement.
     * 
     * @return taxAmount
     */
    public java.lang.String getTaxAmount() {
        return taxAmount;
    }


    /**
     * Sets the taxAmount value for this NewOrderRequestElement.
     * 
     * @param taxAmount
     */
    public void setTaxAmount(java.lang.String taxAmount) {
        this.taxAmount = taxAmount;
    }


    /**
     * Gets the amexTranAdvAddn1 value for this NewOrderRequestElement.
     * 
     * @return amexTranAdvAddn1
     */
    public java.lang.String getAmexTranAdvAddn1() {
        return amexTranAdvAddn1;
    }


    /**
     * Sets the amexTranAdvAddn1 value for this NewOrderRequestElement.
     * 
     * @param amexTranAdvAddn1
     */
    public void setAmexTranAdvAddn1(java.lang.String amexTranAdvAddn1) {
        this.amexTranAdvAddn1 = amexTranAdvAddn1;
    }


    /**
     * Gets the amexTranAdvAddn2 value for this NewOrderRequestElement.
     * 
     * @return amexTranAdvAddn2
     */
    public java.lang.String getAmexTranAdvAddn2() {
        return amexTranAdvAddn2;
    }


    /**
     * Sets the amexTranAdvAddn2 value for this NewOrderRequestElement.
     * 
     * @param amexTranAdvAddn2
     */
    public void setAmexTranAdvAddn2(java.lang.String amexTranAdvAddn2) {
        this.amexTranAdvAddn2 = amexTranAdvAddn2;
    }


    /**
     * Gets the amexTranAdvAddn3 value for this NewOrderRequestElement.
     * 
     * @return amexTranAdvAddn3
     */
    public java.lang.String getAmexTranAdvAddn3() {
        return amexTranAdvAddn3;
    }


    /**
     * Sets the amexTranAdvAddn3 value for this NewOrderRequestElement.
     * 
     * @param amexTranAdvAddn3
     */
    public void setAmexTranAdvAddn3(java.lang.String amexTranAdvAddn3) {
        this.amexTranAdvAddn3 = amexTranAdvAddn3;
    }


    /**
     * Gets the amexTranAdvAddn4 value for this NewOrderRequestElement.
     * 
     * @return amexTranAdvAddn4
     */
    public java.lang.String getAmexTranAdvAddn4() {
        return amexTranAdvAddn4;
    }


    /**
     * Sets the amexTranAdvAddn4 value for this NewOrderRequestElement.
     * 
     * @param amexTranAdvAddn4
     */
    public void setAmexTranAdvAddn4(java.lang.String amexTranAdvAddn4) {
        this.amexTranAdvAddn4 = amexTranAdvAddn4;
    }


    /**
     * Gets the mcSecureCodeAAV value for this NewOrderRequestElement.
     * 
     * @return mcSecureCodeAAV
     */
    public java.lang.String getMcSecureCodeAAV() {
        return mcSecureCodeAAV;
    }


    /**
     * Sets the mcSecureCodeAAV value for this NewOrderRequestElement.
     * 
     * @param mcSecureCodeAAV
     */
    public void setMcSecureCodeAAV(java.lang.String mcSecureCodeAAV) {
        this.mcSecureCodeAAV = mcSecureCodeAAV;
    }


    /**
     * Gets the softDescMercName value for this NewOrderRequestElement.
     * 
     * @return softDescMercName
     */
    public java.lang.String getSoftDescMercName() {
        return softDescMercName;
    }


    /**
     * Sets the softDescMercName value for this NewOrderRequestElement.
     * 
     * @param softDescMercName
     */
    public void setSoftDescMercName(java.lang.String softDescMercName) {
        this.softDescMercName = softDescMercName;
    }


    /**
     * Gets the softDescProdDesc value for this NewOrderRequestElement.
     * 
     * @return softDescProdDesc
     */
    public java.lang.String getSoftDescProdDesc() {
        return softDescProdDesc;
    }


    /**
     * Sets the softDescProdDesc value for this NewOrderRequestElement.
     * 
     * @param softDescProdDesc
     */
    public void setSoftDescProdDesc(java.lang.String softDescProdDesc) {
        this.softDescProdDesc = softDescProdDesc;
    }


    /**
     * Gets the softDescMercCity value for this NewOrderRequestElement.
     * 
     * @return softDescMercCity
     */
    public java.lang.String getSoftDescMercCity() {
        return softDescMercCity;
    }


    /**
     * Sets the softDescMercCity value for this NewOrderRequestElement.
     * 
     * @param softDescMercCity
     */
    public void setSoftDescMercCity(java.lang.String softDescMercCity) {
        this.softDescMercCity = softDescMercCity;
    }


    /**
     * Gets the softDescMercPhone value for this NewOrderRequestElement.
     * 
     * @return softDescMercPhone
     */
    public java.lang.String getSoftDescMercPhone() {
        return softDescMercPhone;
    }


    /**
     * Sets the softDescMercPhone value for this NewOrderRequestElement.
     * 
     * @param softDescMercPhone
     */
    public void setSoftDescMercPhone(java.lang.String softDescMercPhone) {
        this.softDescMercPhone = softDescMercPhone;
    }


    /**
     * Gets the softDescMercURL value for this NewOrderRequestElement.
     * 
     * @return softDescMercURL
     */
    public java.lang.String getSoftDescMercURL() {
        return softDescMercURL;
    }


    /**
     * Sets the softDescMercURL value for this NewOrderRequestElement.
     * 
     * @param softDescMercURL
     */
    public void setSoftDescMercURL(java.lang.String softDescMercURL) {
        this.softDescMercURL = softDescMercURL;
    }


    /**
     * Gets the softDescMercEmail value for this NewOrderRequestElement.
     * 
     * @return softDescMercEmail
     */
    public java.lang.String getSoftDescMercEmail() {
        return softDescMercEmail;
    }


    /**
     * Sets the softDescMercEmail value for this NewOrderRequestElement.
     * 
     * @param softDescMercEmail
     */
    public void setSoftDescMercEmail(java.lang.String softDescMercEmail) {
        this.softDescMercEmail = softDescMercEmail;
    }


    /**
     * Gets the recurringInd value for this NewOrderRequestElement.
     * 
     * @return recurringInd
     */
    public java.lang.String getRecurringInd() {
        return recurringInd;
    }


    /**
     * Sets the recurringInd value for this NewOrderRequestElement.
     * 
     * @param recurringInd
     */
    public void setRecurringInd(java.lang.String recurringInd) {
        this.recurringInd = recurringInd;
    }


    /**
     * Gets the txRefNum value for this NewOrderRequestElement.
     * 
     * @return txRefNum
     */
    public java.lang.String getTxRefNum() {
        return txRefNum;
    }


    /**
     * Sets the txRefNum value for this NewOrderRequestElement.
     * 
     * @param txRefNum
     */
    public void setTxRefNum(java.lang.String txRefNum) {
        this.txRefNum = txRefNum;
    }


    /**
     * Gets the retryTrace value for this NewOrderRequestElement.
     * 
     * @return retryTrace
     */
    public java.lang.String getRetryTrace() {
        return retryTrace;
    }


    /**
     * Sets the retryTrace value for this NewOrderRequestElement.
     * 
     * @param retryTrace
     */
    public void setRetryTrace(java.lang.String retryTrace) {
        this.retryTrace = retryTrace;
    }


    /**
     * Gets the pCardOrderID value for this NewOrderRequestElement.
     * 
     * @return pCardOrderID
     */
    public java.lang.String getPCardOrderID() {
        return pCardOrderID;
    }


    /**
     * Sets the pCardOrderID value for this NewOrderRequestElement.
     * 
     * @param pCardOrderID
     */
    public void setPCardOrderID(java.lang.String pCardOrderID) {
        this.pCardOrderID = pCardOrderID;
    }


    /**
     * Gets the pCardDestZip value for this NewOrderRequestElement.
     * 
     * @return pCardDestZip
     */
    public java.lang.String getPCardDestZip() {
        return pCardDestZip;
    }


    /**
     * Sets the pCardDestZip value for this NewOrderRequestElement.
     * 
     * @param pCardDestZip
     */
    public void setPCardDestZip(java.lang.String pCardDestZip) {
        this.pCardDestZip = pCardDestZip;
    }


    /**
     * Gets the pCardDestName value for this NewOrderRequestElement.
     * 
     * @return pCardDestName
     */
    public java.lang.String getPCardDestName() {
        return pCardDestName;
    }


    /**
     * Sets the pCardDestName value for this NewOrderRequestElement.
     * 
     * @param pCardDestName
     */
    public void setPCardDestName(java.lang.String pCardDestName) {
        this.pCardDestName = pCardDestName;
    }


    /**
     * Gets the pCardDestAddress value for this NewOrderRequestElement.
     * 
     * @return pCardDestAddress
     */
    public java.lang.String getPCardDestAddress() {
        return pCardDestAddress;
    }


    /**
     * Sets the pCardDestAddress value for this NewOrderRequestElement.
     * 
     * @param pCardDestAddress
     */
    public void setPCardDestAddress(java.lang.String pCardDestAddress) {
        this.pCardDestAddress = pCardDestAddress;
    }


    /**
     * Gets the pCardDestAddress2 value for this NewOrderRequestElement.
     * 
     * @return pCardDestAddress2
     */
    public java.lang.String getPCardDestAddress2() {
        return pCardDestAddress2;
    }


    /**
     * Sets the pCardDestAddress2 value for this NewOrderRequestElement.
     * 
     * @param pCardDestAddress2
     */
    public void setPCardDestAddress2(java.lang.String pCardDestAddress2) {
        this.pCardDestAddress2 = pCardDestAddress2;
    }


    /**
     * Gets the pCardDestCity value for this NewOrderRequestElement.
     * 
     * @return pCardDestCity
     */
    public java.lang.String getPCardDestCity() {
        return pCardDestCity;
    }


    /**
     * Sets the pCardDestCity value for this NewOrderRequestElement.
     * 
     * @param pCardDestCity
     */
    public void setPCardDestCity(java.lang.String pCardDestCity) {
        this.pCardDestCity = pCardDestCity;
    }


    /**
     * Gets the pCardDestStateCd value for this NewOrderRequestElement.
     * 
     * @return pCardDestStateCd
     */
    public java.lang.String getPCardDestStateCd() {
        return pCardDestStateCd;
    }


    /**
     * Sets the pCardDestStateCd value for this NewOrderRequestElement.
     * 
     * @param pCardDestStateCd
     */
    public void setPCardDestStateCd(java.lang.String pCardDestStateCd) {
        this.pCardDestStateCd = pCardDestStateCd;
    }


    /**
     * Gets the pCard3FreightAmt value for this NewOrderRequestElement.
     * 
     * @return pCard3FreightAmt
     */
    public java.lang.String getPCard3FreightAmt() {
        return pCard3FreightAmt;
    }


    /**
     * Sets the pCard3FreightAmt value for this NewOrderRequestElement.
     * 
     * @param pCard3FreightAmt
     */
    public void setPCard3FreightAmt(java.lang.String pCard3FreightAmt) {
        this.pCard3FreightAmt = pCard3FreightAmt;
    }


    /**
     * Gets the pCard3DutyAmt value for this NewOrderRequestElement.
     * 
     * @return pCard3DutyAmt
     */
    public java.lang.String getPCard3DutyAmt() {
        return pCard3DutyAmt;
    }


    /**
     * Sets the pCard3DutyAmt value for this NewOrderRequestElement.
     * 
     * @param pCard3DutyAmt
     */
    public void setPCard3DutyAmt(java.lang.String pCard3DutyAmt) {
        this.pCard3DutyAmt = pCard3DutyAmt;
    }


    /**
     * Gets the pCard3DestCountryCd value for this NewOrderRequestElement.
     * 
     * @return pCard3DestCountryCd
     */
    public java.lang.String getPCard3DestCountryCd() {
        return pCard3DestCountryCd;
    }


    /**
     * Sets the pCard3DestCountryCd value for this NewOrderRequestElement.
     * 
     * @param pCard3DestCountryCd
     */
    public void setPCard3DestCountryCd(java.lang.String pCard3DestCountryCd) {
        this.pCard3DestCountryCd = pCard3DestCountryCd;
    }


    /**
     * Gets the pCard3ShipFromZip value for this NewOrderRequestElement.
     * 
     * @return pCard3ShipFromZip
     */
    public java.lang.String getPCard3ShipFromZip() {
        return pCard3ShipFromZip;
    }


    /**
     * Sets the pCard3ShipFromZip value for this NewOrderRequestElement.
     * 
     * @param pCard3ShipFromZip
     */
    public void setPCard3ShipFromZip(java.lang.String pCard3ShipFromZip) {
        this.pCard3ShipFromZip = pCard3ShipFromZip;
    }


    /**
     * Gets the pCard3DiscAmt value for this NewOrderRequestElement.
     * 
     * @return pCard3DiscAmt
     */
    public java.lang.String getPCard3DiscAmt() {
        return pCard3DiscAmt;
    }


    /**
     * Sets the pCard3DiscAmt value for this NewOrderRequestElement.
     * 
     * @param pCard3DiscAmt
     */
    public void setPCard3DiscAmt(java.lang.String pCard3DiscAmt) {
        this.pCard3DiscAmt = pCard3DiscAmt;
    }


    /**
     * Gets the pCard3VATtaxAmt value for this NewOrderRequestElement.
     * 
     * @return pCard3VATtaxAmt
     */
    public java.lang.String getPCard3VATtaxAmt() {
        return pCard3VATtaxAmt;
    }


    /**
     * Sets the pCard3VATtaxAmt value for this NewOrderRequestElement.
     * 
     * @param pCard3VATtaxAmt
     */
    public void setPCard3VATtaxAmt(java.lang.String pCard3VATtaxAmt) {
        this.pCard3VATtaxAmt = pCard3VATtaxAmt;
    }


    /**
     * Gets the pCard3VATtaxRate value for this NewOrderRequestElement.
     * 
     * @return pCard3VATtaxRate
     */
    public java.lang.String getPCard3VATtaxRate() {
        return pCard3VATtaxRate;
    }


    /**
     * Sets the pCard3VATtaxRate value for this NewOrderRequestElement.
     * 
     * @param pCard3VATtaxRate
     */
    public void setPCard3VATtaxRate(java.lang.String pCard3VATtaxRate) {
        this.pCard3VATtaxRate = pCard3VATtaxRate;
    }


    /**
     * Gets the pCard3AltTaxInd value for this NewOrderRequestElement.
     * 
     * @return pCard3AltTaxInd
     */
    public java.lang.String getPCard3AltTaxInd() {
        return pCard3AltTaxInd;
    }


    /**
     * Sets the pCard3AltTaxInd value for this NewOrderRequestElement.
     * 
     * @param pCard3AltTaxInd
     */
    public void setPCard3AltTaxInd(java.lang.String pCard3AltTaxInd) {
        this.pCard3AltTaxInd = pCard3AltTaxInd;
    }


    /**
     * Gets the pCard3AltTaxAmt value for this NewOrderRequestElement.
     * 
     * @return pCard3AltTaxAmt
     */
    public java.lang.String getPCard3AltTaxAmt() {
        return pCard3AltTaxAmt;
    }


    /**
     * Sets the pCard3AltTaxAmt value for this NewOrderRequestElement.
     * 
     * @param pCard3AltTaxAmt
     */
    public void setPCard3AltTaxAmt(java.lang.String pCard3AltTaxAmt) {
        this.pCard3AltTaxAmt = pCard3AltTaxAmt;
    }


    /**
     * Gets the pCard3LineItemCount value for this NewOrderRequestElement.
     * 
     * @return pCard3LineItemCount
     */
    public java.lang.String getPCard3LineItemCount() {
        return pCard3LineItemCount;
    }


    /**
     * Sets the pCard3LineItemCount value for this NewOrderRequestElement.
     * 
     * @param pCard3LineItemCount
     */
    public void setPCard3LineItemCount(java.lang.String pCard3LineItemCount) {
        this.pCard3LineItemCount = pCard3LineItemCount;
    }


    /**
     * Gets the pCard3LineItems value for this NewOrderRequestElement.
     * 
     * @return pCard3LineItems
     */
    public net.paymentech.ws.PC3LineItem[] getPCard3LineItems() {
        return pCard3LineItems;
    }


    /**
     * Sets the pCard3LineItems value for this NewOrderRequestElement.
     * 
     * @param pCard3LineItems
     */
    public void setPCard3LineItems(net.paymentech.ws.PC3LineItem[] pCard3LineItems) {
        this.pCard3LineItems = pCard3LineItems;
    }


    /**
     * Gets the magStripeTrack1 value for this NewOrderRequestElement.
     * 
     * @return magStripeTrack1
     */
    public java.lang.String getMagStripeTrack1() {
        return magStripeTrack1;
    }


    /**
     * Sets the magStripeTrack1 value for this NewOrderRequestElement.
     * 
     * @param magStripeTrack1
     */
    public void setMagStripeTrack1(java.lang.String magStripeTrack1) {
        this.magStripeTrack1 = magStripeTrack1;
    }


    /**
     * Gets the magStripeTrack2 value for this NewOrderRequestElement.
     * 
     * @return magStripeTrack2
     */
    public java.lang.String getMagStripeTrack2() {
        return magStripeTrack2;
    }


    /**
     * Sets the magStripeTrack2 value for this NewOrderRequestElement.
     * 
     * @param magStripeTrack2
     */
    public void setMagStripeTrack2(java.lang.String magStripeTrack2) {
        this.magStripeTrack2 = magStripeTrack2;
    }


    /**
     * Gets the retailTransInfo value for this NewOrderRequestElement.
     * 
     * @return retailTransInfo
     */
    public java.lang.String getRetailTransInfo() {
        return retailTransInfo;
    }


    /**
     * Sets the retailTransInfo value for this NewOrderRequestElement.
     * 
     * @param retailTransInfo
     */
    public void setRetailTransInfo(java.lang.String retailTransInfo) {
        this.retailTransInfo = retailTransInfo;
    }


    /**
     * Gets the customerName value for this NewOrderRequestElement.
     * 
     * @return customerName
     */
    public java.lang.String getCustomerName() {
        return customerName;
    }


    /**
     * Sets the customerName value for this NewOrderRequestElement.
     * 
     * @param customerName
     */
    public void setCustomerName(java.lang.String customerName) {
        this.customerName = customerName;
    }


    /**
     * Gets the customerEmail value for this NewOrderRequestElement.
     * 
     * @return customerEmail
     */
    public java.lang.String getCustomerEmail() {
        return customerEmail;
    }


    /**
     * Sets the customerEmail value for this NewOrderRequestElement.
     * 
     * @param customerEmail
     */
    public void setCustomerEmail(java.lang.String customerEmail) {
        this.customerEmail = customerEmail;
    }


    /**
     * Gets the customerPhone value for this NewOrderRequestElement.
     * 
     * @return customerPhone
     */
    public java.lang.String getCustomerPhone() {
        return customerPhone;
    }


    /**
     * Sets the customerPhone value for this NewOrderRequestElement.
     * 
     * @param customerPhone
     */
    public void setCustomerPhone(java.lang.String customerPhone) {
        this.customerPhone = customerPhone;
    }


    /**
     * Gets the cardPresentInd value for this NewOrderRequestElement.
     * 
     * @return cardPresentInd
     */
    public java.lang.String getCardPresentInd() {
        return cardPresentInd;
    }


    /**
     * Sets the cardPresentInd value for this NewOrderRequestElement.
     * 
     * @param cardPresentInd
     */
    public void setCardPresentInd(java.lang.String cardPresentInd) {
        this.cardPresentInd = cardPresentInd;
    }


    /**
     * Gets the euddBankSortCode value for this NewOrderRequestElement.
     * 
     * @return euddBankSortCode
     */
    public java.lang.String getEuddBankSortCode() {
        return euddBankSortCode;
    }


    /**
     * Sets the euddBankSortCode value for this NewOrderRequestElement.
     * 
     * @param euddBankSortCode
     */
    public void setEuddBankSortCode(java.lang.String euddBankSortCode) {
        this.euddBankSortCode = euddBankSortCode;
    }


    /**
     * Gets the euddCountryCode value for this NewOrderRequestElement.
     * 
     * @return euddCountryCode
     */
    public java.lang.String getEuddCountryCode() {
        return euddCountryCode;
    }


    /**
     * Sets the euddCountryCode value for this NewOrderRequestElement.
     * 
     * @param euddCountryCode
     */
    public void setEuddCountryCode(java.lang.String euddCountryCode) {
        this.euddCountryCode = euddCountryCode;
    }


    /**
     * Gets the euddRibCode value for this NewOrderRequestElement.
     * 
     * @return euddRibCode
     */
    public java.lang.String getEuddRibCode() {
        return euddRibCode;
    }


    /**
     * Sets the euddRibCode value for this NewOrderRequestElement.
     * 
     * @param euddRibCode
     */
    public void setEuddRibCode(java.lang.String euddRibCode) {
        this.euddRibCode = euddRibCode;
    }


    /**
     * Gets the euddBankBranchCode value for this NewOrderRequestElement.
     * 
     * @return euddBankBranchCode
     */
    public java.lang.String getEuddBankBranchCode() {
        return euddBankBranchCode;
    }


    /**
     * Sets the euddBankBranchCode value for this NewOrderRequestElement.
     * 
     * @param euddBankBranchCode
     */
    public void setEuddBankBranchCode(java.lang.String euddBankBranchCode) {
        this.euddBankBranchCode = euddBankBranchCode;
    }


    /**
     * Gets the euddIBAN value for this NewOrderRequestElement.
     * 
     * @return euddIBAN
     */
    public java.lang.String getEuddIBAN() {
        return euddIBAN;
    }


    /**
     * Sets the euddIBAN value for this NewOrderRequestElement.
     * 
     * @param euddIBAN
     */
    public void setEuddIBAN(java.lang.String euddIBAN) {
        this.euddIBAN = euddIBAN;
    }


    /**
     * Gets the euddBIC value for this NewOrderRequestElement.
     * 
     * @return euddBIC
     */
    public java.lang.String getEuddBIC() {
        return euddBIC;
    }


    /**
     * Sets the euddBIC value for this NewOrderRequestElement.
     * 
     * @param euddBIC
     */
    public void setEuddBIC(java.lang.String euddBIC) {
        this.euddBIC = euddBIC;
    }


    /**
     * Gets the euddMandateSignatureDate value for this NewOrderRequestElement.
     * 
     * @return euddMandateSignatureDate
     */
    public java.lang.String getEuddMandateSignatureDate() {
        return euddMandateSignatureDate;
    }


    /**
     * Sets the euddMandateSignatureDate value for this NewOrderRequestElement.
     * 
     * @param euddMandateSignatureDate
     */
    public void setEuddMandateSignatureDate(java.lang.String euddMandateSignatureDate) {
        this.euddMandateSignatureDate = euddMandateSignatureDate;
    }


    /**
     * Gets the euddMandateID value for this NewOrderRequestElement.
     * 
     * @return euddMandateID
     */
    public java.lang.String getEuddMandateID() {
        return euddMandateID;
    }


    /**
     * Sets the euddMandateID value for this NewOrderRequestElement.
     * 
     * @param euddMandateID
     */
    public void setEuddMandateID(java.lang.String euddMandateID) {
        this.euddMandateID = euddMandateID;
    }


    /**
     * Gets the euddMandateType value for this NewOrderRequestElement.
     * 
     * @return euddMandateType
     */
    public java.lang.String getEuddMandateType() {
        return euddMandateType;
    }


    /**
     * Sets the euddMandateType value for this NewOrderRequestElement.
     * 
     * @param euddMandateType
     */
    public void setEuddMandateType(java.lang.String euddMandateType) {
        this.euddMandateType = euddMandateType;
    }


    /**
     * Gets the paymentInd value for this NewOrderRequestElement.
     * 
     * @return paymentInd
     */
    public java.lang.String getPaymentInd() {
        return paymentInd;
    }


    /**
     * Sets the paymentInd value for this NewOrderRequestElement.
     * 
     * @param paymentInd
     */
    public void setPaymentInd(java.lang.String paymentInd) {
        this.paymentInd = paymentInd;
    }


    /**
     * Gets the bmlCustomerIP value for this NewOrderRequestElement.
     * 
     * @return bmlCustomerIP
     */
    public java.lang.String getBmlCustomerIP() {
        return bmlCustomerIP;
    }


    /**
     * Sets the bmlCustomerIP value for this NewOrderRequestElement.
     * 
     * @param bmlCustomerIP
     */
    public void setBmlCustomerIP(java.lang.String bmlCustomerIP) {
        this.bmlCustomerIP = bmlCustomerIP;
    }


    /**
     * Gets the bmlCustomerEmail value for this NewOrderRequestElement.
     * 
     * @return bmlCustomerEmail
     */
    public java.lang.String getBmlCustomerEmail() {
        return bmlCustomerEmail;
    }


    /**
     * Sets the bmlCustomerEmail value for this NewOrderRequestElement.
     * 
     * @param bmlCustomerEmail
     */
    public void setBmlCustomerEmail(java.lang.String bmlCustomerEmail) {
        this.bmlCustomerEmail = bmlCustomerEmail;
    }


    /**
     * Gets the bmlShippingCost value for this NewOrderRequestElement.
     * 
     * @return bmlShippingCost
     */
    public java.lang.String getBmlShippingCost() {
        return bmlShippingCost;
    }


    /**
     * Sets the bmlShippingCost value for this NewOrderRequestElement.
     * 
     * @param bmlShippingCost
     */
    public void setBmlShippingCost(java.lang.String bmlShippingCost) {
        this.bmlShippingCost = bmlShippingCost;
    }


    /**
     * Gets the bmlTNCVersion value for this NewOrderRequestElement.
     * 
     * @return bmlTNCVersion
     */
    public java.lang.String getBmlTNCVersion() {
        return bmlTNCVersion;
    }


    /**
     * Sets the bmlTNCVersion value for this NewOrderRequestElement.
     * 
     * @param bmlTNCVersion
     */
    public void setBmlTNCVersion(java.lang.String bmlTNCVersion) {
        this.bmlTNCVersion = bmlTNCVersion;
    }


    /**
     * Gets the bmlCustomerRegistrationDate value for this NewOrderRequestElement.
     * 
     * @return bmlCustomerRegistrationDate
     */
    public java.lang.String getBmlCustomerRegistrationDate() {
        return bmlCustomerRegistrationDate;
    }


    /**
     * Sets the bmlCustomerRegistrationDate value for this NewOrderRequestElement.
     * 
     * @param bmlCustomerRegistrationDate
     */
    public void setBmlCustomerRegistrationDate(java.lang.String bmlCustomerRegistrationDate) {
        this.bmlCustomerRegistrationDate = bmlCustomerRegistrationDate;
    }


    /**
     * Gets the bmlCustomerTypeFlag value for this NewOrderRequestElement.
     * 
     * @return bmlCustomerTypeFlag
     */
    public java.lang.String getBmlCustomerTypeFlag() {
        return bmlCustomerTypeFlag;
    }


    /**
     * Sets the bmlCustomerTypeFlag value for this NewOrderRequestElement.
     * 
     * @param bmlCustomerTypeFlag
     */
    public void setBmlCustomerTypeFlag(java.lang.String bmlCustomerTypeFlag) {
        this.bmlCustomerTypeFlag = bmlCustomerTypeFlag;
    }


    /**
     * Gets the bmlItemCategory value for this NewOrderRequestElement.
     * 
     * @return bmlItemCategory
     */
    public java.lang.String getBmlItemCategory() {
        return bmlItemCategory;
    }


    /**
     * Sets the bmlItemCategory value for this NewOrderRequestElement.
     * 
     * @param bmlItemCategory
     */
    public void setBmlItemCategory(java.lang.String bmlItemCategory) {
        this.bmlItemCategory = bmlItemCategory;
    }


    /**
     * Gets the bmlPreapprovalInvitationNum value for this NewOrderRequestElement.
     * 
     * @return bmlPreapprovalInvitationNum
     */
    public java.lang.String getBmlPreapprovalInvitationNum() {
        return bmlPreapprovalInvitationNum;
    }


    /**
     * Sets the bmlPreapprovalInvitationNum value for this NewOrderRequestElement.
     * 
     * @param bmlPreapprovalInvitationNum
     */
    public void setBmlPreapprovalInvitationNum(java.lang.String bmlPreapprovalInvitationNum) {
        this.bmlPreapprovalInvitationNum = bmlPreapprovalInvitationNum;
    }


    /**
     * Gets the bmlMerchantPromotionalCode value for this NewOrderRequestElement.
     * 
     * @return bmlMerchantPromotionalCode
     */
    public java.lang.String getBmlMerchantPromotionalCode() {
        return bmlMerchantPromotionalCode;
    }


    /**
     * Sets the bmlMerchantPromotionalCode value for this NewOrderRequestElement.
     * 
     * @param bmlMerchantPromotionalCode
     */
    public void setBmlMerchantPromotionalCode(java.lang.String bmlMerchantPromotionalCode) {
        this.bmlMerchantPromotionalCode = bmlMerchantPromotionalCode;
    }


    /**
     * Gets the bmlCustomerBirthDate value for this NewOrderRequestElement.
     * 
     * @return bmlCustomerBirthDate
     */
    public java.lang.String getBmlCustomerBirthDate() {
        return bmlCustomerBirthDate;
    }


    /**
     * Sets the bmlCustomerBirthDate value for this NewOrderRequestElement.
     * 
     * @param bmlCustomerBirthDate
     */
    public void setBmlCustomerBirthDate(java.lang.String bmlCustomerBirthDate) {
        this.bmlCustomerBirthDate = bmlCustomerBirthDate;
    }


    /**
     * Gets the bmlCustomerSSN value for this NewOrderRequestElement.
     * 
     * @return bmlCustomerSSN
     */
    public java.lang.String getBmlCustomerSSN() {
        return bmlCustomerSSN;
    }


    /**
     * Sets the bmlCustomerSSN value for this NewOrderRequestElement.
     * 
     * @param bmlCustomerSSN
     */
    public void setBmlCustomerSSN(java.lang.String bmlCustomerSSN) {
        this.bmlCustomerSSN = bmlCustomerSSN;
    }


    /**
     * Gets the bmlCustomerAnnualIncome value for this NewOrderRequestElement.
     * 
     * @return bmlCustomerAnnualIncome
     */
    public java.lang.String getBmlCustomerAnnualIncome() {
        return bmlCustomerAnnualIncome;
    }


    /**
     * Sets the bmlCustomerAnnualIncome value for this NewOrderRequestElement.
     * 
     * @param bmlCustomerAnnualIncome
     */
    public void setBmlCustomerAnnualIncome(java.lang.String bmlCustomerAnnualIncome) {
        this.bmlCustomerAnnualIncome = bmlCustomerAnnualIncome;
    }


    /**
     * Gets the bmlCustomerResidenceStatus value for this NewOrderRequestElement.
     * 
     * @return bmlCustomerResidenceStatus
     */
    public java.lang.String getBmlCustomerResidenceStatus() {
        return bmlCustomerResidenceStatus;
    }


    /**
     * Sets the bmlCustomerResidenceStatus value for this NewOrderRequestElement.
     * 
     * @param bmlCustomerResidenceStatus
     */
    public void setBmlCustomerResidenceStatus(java.lang.String bmlCustomerResidenceStatus) {
        this.bmlCustomerResidenceStatus = bmlCustomerResidenceStatus;
    }


    /**
     * Gets the bmlCustomerCheckingAccount value for this NewOrderRequestElement.
     * 
     * @return bmlCustomerCheckingAccount
     */
    public java.lang.String getBmlCustomerCheckingAccount() {
        return bmlCustomerCheckingAccount;
    }


    /**
     * Sets the bmlCustomerCheckingAccount value for this NewOrderRequestElement.
     * 
     * @param bmlCustomerCheckingAccount
     */
    public void setBmlCustomerCheckingAccount(java.lang.String bmlCustomerCheckingAccount) {
        this.bmlCustomerCheckingAccount = bmlCustomerCheckingAccount;
    }


    /**
     * Gets the bmlCustomerSavingsAccount value for this NewOrderRequestElement.
     * 
     * @return bmlCustomerSavingsAccount
     */
    public java.lang.String getBmlCustomerSavingsAccount() {
        return bmlCustomerSavingsAccount;
    }


    /**
     * Sets the bmlCustomerSavingsAccount value for this NewOrderRequestElement.
     * 
     * @param bmlCustomerSavingsAccount
     */
    public void setBmlCustomerSavingsAccount(java.lang.String bmlCustomerSavingsAccount) {
        this.bmlCustomerSavingsAccount = bmlCustomerSavingsAccount;
    }


    /**
     * Gets the bmlProductDeliveryType value for this NewOrderRequestElement.
     * 
     * @return bmlProductDeliveryType
     */
    public java.lang.String getBmlProductDeliveryType() {
        return bmlProductDeliveryType;
    }


    /**
     * Sets the bmlProductDeliveryType value for this NewOrderRequestElement.
     * 
     * @param bmlProductDeliveryType
     */
    public void setBmlProductDeliveryType(java.lang.String bmlProductDeliveryType) {
        this.bmlProductDeliveryType = bmlProductDeliveryType;
    }


    /**
     * Gets the avsDestName value for this NewOrderRequestElement.
     * 
     * @return avsDestName
     */
    public java.lang.String getAvsDestName() {
        return avsDestName;
    }


    /**
     * Sets the avsDestName value for this NewOrderRequestElement.
     * 
     * @param avsDestName
     */
    public void setAvsDestName(java.lang.String avsDestName) {
        this.avsDestName = avsDestName;
    }


    /**
     * Gets the avsDestAddress1 value for this NewOrderRequestElement.
     * 
     * @return avsDestAddress1
     */
    public java.lang.String getAvsDestAddress1() {
        return avsDestAddress1;
    }


    /**
     * Sets the avsDestAddress1 value for this NewOrderRequestElement.
     * 
     * @param avsDestAddress1
     */
    public void setAvsDestAddress1(java.lang.String avsDestAddress1) {
        this.avsDestAddress1 = avsDestAddress1;
    }


    /**
     * Gets the avsDestAddress2 value for this NewOrderRequestElement.
     * 
     * @return avsDestAddress2
     */
    public java.lang.String getAvsDestAddress2() {
        return avsDestAddress2;
    }


    /**
     * Sets the avsDestAddress2 value for this NewOrderRequestElement.
     * 
     * @param avsDestAddress2
     */
    public void setAvsDestAddress2(java.lang.String avsDestAddress2) {
        this.avsDestAddress2 = avsDestAddress2;
    }


    /**
     * Gets the avsDestCity value for this NewOrderRequestElement.
     * 
     * @return avsDestCity
     */
    public java.lang.String getAvsDestCity() {
        return avsDestCity;
    }


    /**
     * Sets the avsDestCity value for this NewOrderRequestElement.
     * 
     * @param avsDestCity
     */
    public void setAvsDestCity(java.lang.String avsDestCity) {
        this.avsDestCity = avsDestCity;
    }


    /**
     * Gets the avsDestState value for this NewOrderRequestElement.
     * 
     * @return avsDestState
     */
    public java.lang.String getAvsDestState() {
        return avsDestState;
    }


    /**
     * Sets the avsDestState value for this NewOrderRequestElement.
     * 
     * @param avsDestState
     */
    public void setAvsDestState(java.lang.String avsDestState) {
        this.avsDestState = avsDestState;
    }


    /**
     * Gets the avsDestZip value for this NewOrderRequestElement.
     * 
     * @return avsDestZip
     */
    public java.lang.String getAvsDestZip() {
        return avsDestZip;
    }


    /**
     * Sets the avsDestZip value for this NewOrderRequestElement.
     * 
     * @param avsDestZip
     */
    public void setAvsDestZip(java.lang.String avsDestZip) {
        this.avsDestZip = avsDestZip;
    }


    /**
     * Gets the avsDestCountryCode value for this NewOrderRequestElement.
     * 
     * @return avsDestCountryCode
     */
    public java.lang.String getAvsDestCountryCode() {
        return avsDestCountryCode;
    }


    /**
     * Sets the avsDestCountryCode value for this NewOrderRequestElement.
     * 
     * @param avsDestCountryCode
     */
    public void setAvsDestCountryCode(java.lang.String avsDestCountryCode) {
        this.avsDestCountryCode = avsDestCountryCode;
    }


    /**
     * Gets the avsDestPhoneNum value for this NewOrderRequestElement.
     * 
     * @return avsDestPhoneNum
     */
    public java.lang.String getAvsDestPhoneNum() {
        return avsDestPhoneNum;
    }


    /**
     * Sets the avsDestPhoneNum value for this NewOrderRequestElement.
     * 
     * @param avsDestPhoneNum
     */
    public void setAvsDestPhoneNum(java.lang.String avsDestPhoneNum) {
        this.avsDestPhoneNum = avsDestPhoneNum;
    }


    /**
     * Gets the debitBillerReferenceNumber value for this NewOrderRequestElement.
     * 
     * @return debitBillerReferenceNumber
     */
    public java.lang.String getDebitBillerReferenceNumber() {
        return debitBillerReferenceNumber;
    }


    /**
     * Sets the debitBillerReferenceNumber value for this NewOrderRequestElement.
     * 
     * @param debitBillerReferenceNumber
     */
    public void setDebitBillerReferenceNumber(java.lang.String debitBillerReferenceNumber) {
        this.debitBillerReferenceNumber = debitBillerReferenceNumber;
    }


    /**
     * Gets the mbType value for this NewOrderRequestElement.
     * 
     * @return mbType
     */
    public java.lang.String getMbType() {
        return mbType;
    }


    /**
     * Sets the mbType value for this NewOrderRequestElement.
     * 
     * @param mbType
     */
    public void setMbType(java.lang.String mbType) {
        this.mbType = mbType;
    }


    /**
     * Gets the mbOrderIdGenerationMethod value for this NewOrderRequestElement.
     * 
     * @return mbOrderIdGenerationMethod
     */
    public java.lang.String getMbOrderIdGenerationMethod() {
        return mbOrderIdGenerationMethod;
    }


    /**
     * Sets the mbOrderIdGenerationMethod value for this NewOrderRequestElement.
     * 
     * @param mbOrderIdGenerationMethod
     */
    public void setMbOrderIdGenerationMethod(java.lang.String mbOrderIdGenerationMethod) {
        this.mbOrderIdGenerationMethod = mbOrderIdGenerationMethod;
    }


    /**
     * Gets the mbRecurringStartDate value for this NewOrderRequestElement.
     * 
     * @return mbRecurringStartDate
     */
    public java.lang.String getMbRecurringStartDate() {
        return mbRecurringStartDate;
    }


    /**
     * Sets the mbRecurringStartDate value for this NewOrderRequestElement.
     * 
     * @param mbRecurringStartDate
     */
    public void setMbRecurringStartDate(java.lang.String mbRecurringStartDate) {
        this.mbRecurringStartDate = mbRecurringStartDate;
    }


    /**
     * Gets the mbRecurringEndDate value for this NewOrderRequestElement.
     * 
     * @return mbRecurringEndDate
     */
    public java.lang.String getMbRecurringEndDate() {
        return mbRecurringEndDate;
    }


    /**
     * Sets the mbRecurringEndDate value for this NewOrderRequestElement.
     * 
     * @param mbRecurringEndDate
     */
    public void setMbRecurringEndDate(java.lang.String mbRecurringEndDate) {
        this.mbRecurringEndDate = mbRecurringEndDate;
    }


    /**
     * Gets the mbRecurringNoEndDateFlag value for this NewOrderRequestElement.
     * 
     * @return mbRecurringNoEndDateFlag
     */
    public java.lang.String getMbRecurringNoEndDateFlag() {
        return mbRecurringNoEndDateFlag;
    }


    /**
     * Sets the mbRecurringNoEndDateFlag value for this NewOrderRequestElement.
     * 
     * @param mbRecurringNoEndDateFlag
     */
    public void setMbRecurringNoEndDateFlag(java.lang.String mbRecurringNoEndDateFlag) {
        this.mbRecurringNoEndDateFlag = mbRecurringNoEndDateFlag;
    }


    /**
     * Gets the mbRecurringMaxBillings value for this NewOrderRequestElement.
     * 
     * @return mbRecurringMaxBillings
     */
    public java.lang.String getMbRecurringMaxBillings() {
        return mbRecurringMaxBillings;
    }


    /**
     * Sets the mbRecurringMaxBillings value for this NewOrderRequestElement.
     * 
     * @param mbRecurringMaxBillings
     */
    public void setMbRecurringMaxBillings(java.lang.String mbRecurringMaxBillings) {
        this.mbRecurringMaxBillings = mbRecurringMaxBillings;
    }


    /**
     * Gets the mbRecurringFrequency value for this NewOrderRequestElement.
     * 
     * @return mbRecurringFrequency
     */
    public java.lang.String getMbRecurringFrequency() {
        return mbRecurringFrequency;
    }


    /**
     * Sets the mbRecurringFrequency value for this NewOrderRequestElement.
     * 
     * @param mbRecurringFrequency
     */
    public void setMbRecurringFrequency(java.lang.String mbRecurringFrequency) {
        this.mbRecurringFrequency = mbRecurringFrequency;
    }


    /**
     * Gets the mbMicroPaymentMaxDollarValue value for this NewOrderRequestElement.
     * 
     * @return mbMicroPaymentMaxDollarValue
     */
    public java.lang.String getMbMicroPaymentMaxDollarValue() {
        return mbMicroPaymentMaxDollarValue;
    }


    /**
     * Sets the mbMicroPaymentMaxDollarValue value for this NewOrderRequestElement.
     * 
     * @param mbMicroPaymentMaxDollarValue
     */
    public void setMbMicroPaymentMaxDollarValue(java.lang.String mbMicroPaymentMaxDollarValue) {
        this.mbMicroPaymentMaxDollarValue = mbMicroPaymentMaxDollarValue;
    }


    /**
     * Gets the mbMicroPaymentMaxBillingDays value for this NewOrderRequestElement.
     * 
     * @return mbMicroPaymentMaxBillingDays
     */
    public java.lang.String getMbMicroPaymentMaxBillingDays() {
        return mbMicroPaymentMaxBillingDays;
    }


    /**
     * Sets the mbMicroPaymentMaxBillingDays value for this NewOrderRequestElement.
     * 
     * @param mbMicroPaymentMaxBillingDays
     */
    public void setMbMicroPaymentMaxBillingDays(java.lang.String mbMicroPaymentMaxBillingDays) {
        this.mbMicroPaymentMaxBillingDays = mbMicroPaymentMaxBillingDays;
    }


    /**
     * Gets the mbMicroPaymentMaxTransactions value for this NewOrderRequestElement.
     * 
     * @return mbMicroPaymentMaxTransactions
     */
    public java.lang.String getMbMicroPaymentMaxTransactions() {
        return mbMicroPaymentMaxTransactions;
    }


    /**
     * Sets the mbMicroPaymentMaxTransactions value for this NewOrderRequestElement.
     * 
     * @param mbMicroPaymentMaxTransactions
     */
    public void setMbMicroPaymentMaxTransactions(java.lang.String mbMicroPaymentMaxTransactions) {
        this.mbMicroPaymentMaxTransactions = mbMicroPaymentMaxTransactions;
    }


    /**
     * Gets the mbDeferredBillDate value for this NewOrderRequestElement.
     * 
     * @return mbDeferredBillDate
     */
    public java.lang.String getMbDeferredBillDate() {
        return mbDeferredBillDate;
    }


    /**
     * Sets the mbDeferredBillDate value for this NewOrderRequestElement.
     * 
     * @param mbDeferredBillDate
     */
    public void setMbDeferredBillDate(java.lang.String mbDeferredBillDate) {
        this.mbDeferredBillDate = mbDeferredBillDate;
    }


    /**
     * Gets the debitPinNumber value for this NewOrderRequestElement.
     * 
     * @return debitPinNumber
     */
    public java.lang.String getDebitPinNumber() {
        return debitPinNumber;
    }


    /**
     * Sets the debitPinNumber value for this NewOrderRequestElement.
     * 
     * @param debitPinNumber
     */
    public void setDebitPinNumber(java.lang.String debitPinNumber) {
        this.debitPinNumber = debitPinNumber;
    }


    /**
     * Gets the debitPinSecurityControl value for this NewOrderRequestElement.
     * 
     * @return debitPinSecurityControl
     */
    public java.lang.String getDebitPinSecurityControl() {
        return debitPinSecurityControl;
    }


    /**
     * Sets the debitPinSecurityControl value for this NewOrderRequestElement.
     * 
     * @param debitPinSecurityControl
     */
    public void setDebitPinSecurityControl(java.lang.String debitPinSecurityControl) {
        this.debitPinSecurityControl = debitPinSecurityControl;
    }


    /**
     * Gets the debitPinCashBack value for this NewOrderRequestElement.
     * 
     * @return debitPinCashBack
     */
    public java.lang.String getDebitPinCashBack() {
        return debitPinCashBack;
    }


    /**
     * Sets the debitPinCashBack value for this NewOrderRequestElement.
     * 
     * @param debitPinCashBack
     */
    public void setDebitPinCashBack(java.lang.String debitPinCashBack) {
        this.debitPinCashBack = debitPinCashBack;
    }


    /**
     * Gets the partialAuthInd value for this NewOrderRequestElement.
     * 
     * @return partialAuthInd
     */
    public java.lang.String getPartialAuthInd() {
        return partialAuthInd;
    }


    /**
     * Sets the partialAuthInd value for this NewOrderRequestElement.
     * 
     * @param partialAuthInd
     */
    public void setPartialAuthInd(java.lang.String partialAuthInd) {
        this.partialAuthInd = partialAuthInd;
    }


    /**
     * Gets the accountUpdaterEligibility value for this NewOrderRequestElement.
     * 
     * @return accountUpdaterEligibility
     */
    public java.lang.String getAccountUpdaterEligibility() {
        return accountUpdaterEligibility;
    }


    /**
     * Sets the accountUpdaterEligibility value for this NewOrderRequestElement.
     * 
     * @param accountUpdaterEligibility
     */
    public void setAccountUpdaterEligibility(java.lang.String accountUpdaterEligibility) {
        this.accountUpdaterEligibility = accountUpdaterEligibility;
    }


    /**
     * Gets the useStoredAAVInd value for this NewOrderRequestElement.
     * 
     * @return useStoredAAVInd
     */
    public java.lang.String getUseStoredAAVInd() {
        return useStoredAAVInd;
    }


    /**
     * Sets the useStoredAAVInd value for this NewOrderRequestElement.
     * 
     * @param useStoredAAVInd
     */
    public void setUseStoredAAVInd(java.lang.String useStoredAAVInd) {
        this.useStoredAAVInd = useStoredAAVInd;
    }


    /**
     * Gets the ecpActionCode value for this NewOrderRequestElement.
     * 
     * @return ecpActionCode
     */
    public java.lang.String getEcpActionCode() {
        return ecpActionCode;
    }


    /**
     * Sets the ecpActionCode value for this NewOrderRequestElement.
     * 
     * @param ecpActionCode
     */
    public void setEcpActionCode(java.lang.String ecpActionCode) {
        this.ecpActionCode = ecpActionCode;
    }


    /**
     * Gets the ecpCheckSerialNumber value for this NewOrderRequestElement.
     * 
     * @return ecpCheckSerialNumber
     */
    public java.lang.String getEcpCheckSerialNumber() {
        return ecpCheckSerialNumber;
    }


    /**
     * Sets the ecpCheckSerialNumber value for this NewOrderRequestElement.
     * 
     * @param ecpCheckSerialNumber
     */
    public void setEcpCheckSerialNumber(java.lang.String ecpCheckSerialNumber) {
        this.ecpCheckSerialNumber = ecpCheckSerialNumber;
    }


    /**
     * Gets the ecpTerminalCity value for this NewOrderRequestElement.
     * 
     * @return ecpTerminalCity
     */
    public java.lang.String getEcpTerminalCity() {
        return ecpTerminalCity;
    }


    /**
     * Sets the ecpTerminalCity value for this NewOrderRequestElement.
     * 
     * @param ecpTerminalCity
     */
    public void setEcpTerminalCity(java.lang.String ecpTerminalCity) {
        this.ecpTerminalCity = ecpTerminalCity;
    }


    /**
     * Gets the ecpTerminalState value for this NewOrderRequestElement.
     * 
     * @return ecpTerminalState
     */
    public java.lang.String getEcpTerminalState() {
        return ecpTerminalState;
    }


    /**
     * Sets the ecpTerminalState value for this NewOrderRequestElement.
     * 
     * @param ecpTerminalState
     */
    public void setEcpTerminalState(java.lang.String ecpTerminalState) {
        this.ecpTerminalState = ecpTerminalState;
    }


    /**
     * Gets the ecpImageReferenceNumber value for this NewOrderRequestElement.
     * 
     * @return ecpImageReferenceNumber
     */
    public java.lang.String getEcpImageReferenceNumber() {
        return ecpImageReferenceNumber;
    }


    /**
     * Sets the ecpImageReferenceNumber value for this NewOrderRequestElement.
     * 
     * @param ecpImageReferenceNumber
     */
    public void setEcpImageReferenceNumber(java.lang.String ecpImageReferenceNumber) {
        this.ecpImageReferenceNumber = ecpImageReferenceNumber;
    }


    /**
     * Gets the customerAni value for this NewOrderRequestElement.
     * 
     * @return customerAni
     */
    public java.lang.String getCustomerAni() {
        return customerAni;
    }


    /**
     * Sets the customerAni value for this NewOrderRequestElement.
     * 
     * @param customerAni
     */
    public void setCustomerAni(java.lang.String customerAni) {
        this.customerAni = customerAni;
    }


    /**
     * Gets the avsPhoneType value for this NewOrderRequestElement.
     * 
     * @return avsPhoneType
     */
    public java.lang.String getAvsPhoneType() {
        return avsPhoneType;
    }


    /**
     * Sets the avsPhoneType value for this NewOrderRequestElement.
     * 
     * @param avsPhoneType
     */
    public void setAvsPhoneType(java.lang.String avsPhoneType) {
        this.avsPhoneType = avsPhoneType;
    }


    /**
     * Gets the avsDestPhoneType value for this NewOrderRequestElement.
     * 
     * @return avsDestPhoneType
     */
    public java.lang.String getAvsDestPhoneType() {
        return avsDestPhoneType;
    }


    /**
     * Sets the avsDestPhoneType value for this NewOrderRequestElement.
     * 
     * @param avsDestPhoneType
     */
    public void setAvsDestPhoneType(java.lang.String avsDestPhoneType) {
        this.avsDestPhoneType = avsDestPhoneType;
    }


    /**
     * Gets the customerIpAddress value for this NewOrderRequestElement.
     * 
     * @return customerIpAddress
     */
    public java.lang.String getCustomerIpAddress() {
        return customerIpAddress;
    }


    /**
     * Sets the customerIpAddress value for this NewOrderRequestElement.
     * 
     * @param customerIpAddress
     */
    public void setCustomerIpAddress(java.lang.String customerIpAddress) {
        this.customerIpAddress = customerIpAddress;
    }


    /**
     * Gets the emailAddressSubtype value for this NewOrderRequestElement.
     * 
     * @return emailAddressSubtype
     */
    public java.lang.String getEmailAddressSubtype() {
        return emailAddressSubtype;
    }


    /**
     * Sets the emailAddressSubtype value for this NewOrderRequestElement.
     * 
     * @param emailAddressSubtype
     */
    public void setEmailAddressSubtype(java.lang.String emailAddressSubtype) {
        this.emailAddressSubtype = emailAddressSubtype;
    }


    /**
     * Gets the customerBrowserName value for this NewOrderRequestElement.
     * 
     * @return customerBrowserName
     */
    public java.lang.String getCustomerBrowserName() {
        return customerBrowserName;
    }


    /**
     * Sets the customerBrowserName value for this NewOrderRequestElement.
     * 
     * @param customerBrowserName
     */
    public void setCustomerBrowserName(java.lang.String customerBrowserName) {
        this.customerBrowserName = customerBrowserName;
    }


    /**
     * Gets the shippingMethod value for this NewOrderRequestElement.
     * 
     * @return shippingMethod
     */
    public java.lang.String getShippingMethod() {
        return shippingMethod;
    }


    /**
     * Sets the shippingMethod value for this NewOrderRequestElement.
     * 
     * @param shippingMethod
     */
    public void setShippingMethod(java.lang.String shippingMethod) {
        this.shippingMethod = shippingMethod;
    }


    /**
     * Gets the fraudAnalysis value for this NewOrderRequestElement.
     * 
     * @return fraudAnalysis
     */
    public net.paymentech.ws.FraudAnalysisType getFraudAnalysis() {
        return fraudAnalysis;
    }


    /**
     * Sets the fraudAnalysis value for this NewOrderRequestElement.
     * 
     * @param fraudAnalysis
     */
    public void setFraudAnalysis(net.paymentech.ws.FraudAnalysisType fraudAnalysis) {
        this.fraudAnalysis = fraudAnalysis;
    }


    /**
     * Gets the softMerchantDescriptors value for this NewOrderRequestElement.
     * 
     * @return softMerchantDescriptors
     */
    public net.paymentech.ws.SoftMerchantDescriptorsType getSoftMerchantDescriptors() {
        return softMerchantDescriptors;
    }


    /**
     * Sets the softMerchantDescriptors value for this NewOrderRequestElement.
     * 
     * @param softMerchantDescriptors
     */
    public void setSoftMerchantDescriptors(net.paymentech.ws.SoftMerchantDescriptorsType softMerchantDescriptors) {
        this.softMerchantDescriptors = softMerchantDescriptors;
    }


    /**
     * Gets the latitudeLongitude value for this NewOrderRequestElement.
     * 
     * @return latitudeLongitude
     */
    public java.lang.String getLatitudeLongitude() {
        return latitudeLongitude;
    }


    /**
     * Sets the latitudeLongitude value for this NewOrderRequestElement.
     * 
     * @param latitudeLongitude
     */
    public void setLatitudeLongitude(java.lang.String latitudeLongitude) {
        this.latitudeLongitude = latitudeLongitude;
    }


    /**
     * Gets the politicalTimeZone value for this NewOrderRequestElement.
     * 
     * @return politicalTimeZone
     */
    public java.lang.String getPoliticalTimeZone() {
        return politicalTimeZone;
    }


    /**
     * Sets the politicalTimeZone value for this NewOrderRequestElement.
     * 
     * @param politicalTimeZone
     */
    public void setPoliticalTimeZone(java.lang.String politicalTimeZone) {
        this.politicalTimeZone = politicalTimeZone;
    }


    /**
     * Gets the vendorID value for this NewOrderRequestElement.
     * 
     * @return vendorID
     */
    public java.lang.String getVendorID() {
        return vendorID;
    }


    /**
     * Sets the vendorID value for this NewOrderRequestElement.
     * 
     * @param vendorID
     */
    public void setVendorID(java.lang.String vendorID) {
        this.vendorID = vendorID;
    }


    /**
     * Gets the softwareID value for this NewOrderRequestElement.
     * 
     * @return softwareID
     */
    public java.lang.String getSoftwareID() {
        return softwareID;
    }


    /**
     * Sets the softwareID value for this NewOrderRequestElement.
     * 
     * @param softwareID
     */
    public void setSoftwareID(java.lang.String softwareID) {
        this.softwareID = softwareID;
    }


    /**
     * Gets the mobileDeviceType value for this NewOrderRequestElement.
     * 
     * @return mobileDeviceType
     */
    public java.lang.String getMobileDeviceType() {
        return mobileDeviceType;
    }


    /**
     * Sets the mobileDeviceType value for this NewOrderRequestElement.
     * 
     * @param mobileDeviceType
     */
    public void setMobileDeviceType(java.lang.String mobileDeviceType) {
        this.mobileDeviceType = mobileDeviceType;
    }


    /**
     * Gets the deviceID value for this NewOrderRequestElement.
     * 
     * @return deviceID
     */
    public java.lang.String getDeviceID() {
        return deviceID;
    }


    /**
     * Sets the deviceID value for this NewOrderRequestElement.
     * 
     * @param deviceID
     */
    public void setDeviceID(java.lang.String deviceID) {
        this.deviceID = deviceID;
    }


    /**
     * Gets the localDateTime value for this NewOrderRequestElement.
     * 
     * @return localDateTime
     */
    public java.lang.String getLocalDateTime() {
        return localDateTime;
    }


    /**
     * Sets the localDateTime value for this NewOrderRequestElement.
     * 
     * @param localDateTime
     */
    public void setLocalDateTime(java.lang.String localDateTime) {
        this.localDateTime = localDateTime;
    }


    /**
     * Gets the readerSerialNumber value for this NewOrderRequestElement.
     * 
     * @return readerSerialNumber
     */
    public java.lang.String getReaderSerialNumber() {
        return readerSerialNumber;
    }


    /**
     * Sets the readerSerialNumber value for this NewOrderRequestElement.
     * 
     * @param readerSerialNumber
     */
    public void setReaderSerialNumber(java.lang.String readerSerialNumber) {
        this.readerSerialNumber = readerSerialNumber;
    }


    /**
     * Gets the keySerialNumber value for this NewOrderRequestElement.
     * 
     * @return keySerialNumber
     */
    public java.lang.String getKeySerialNumber() {
        return keySerialNumber;
    }


    /**
     * Sets the keySerialNumber value for this NewOrderRequestElement.
     * 
     * @param keySerialNumber
     */
    public void setKeySerialNumber(java.lang.String keySerialNumber) {
        this.keySerialNumber = keySerialNumber;
    }


    /**
     * Gets the encryptedMagStripeTrack2 value for this NewOrderRequestElement.
     * 
     * @return encryptedMagStripeTrack2
     */
    public java.lang.String getEncryptedMagStripeTrack2() {
        return encryptedMagStripeTrack2;
    }


    /**
     * Sets the encryptedMagStripeTrack2 value for this NewOrderRequestElement.
     * 
     * @param encryptedMagStripeTrack2
     */
    public void setEncryptedMagStripeTrack2(java.lang.String encryptedMagStripeTrack2) {
        this.encryptedMagStripeTrack2 = encryptedMagStripeTrack2;
    }


    /**
     * Gets the encryptionInd value for this NewOrderRequestElement.
     * 
     * @return encryptionInd
     */
    public java.lang.String getEncryptionInd() {
        return encryptionInd;
    }


    /**
     * Sets the encryptionInd value for this NewOrderRequestElement.
     * 
     * @param encryptionInd
     */
    public void setEncryptionInd(java.lang.String encryptionInd) {
        this.encryptionInd = encryptionInd;
    }


    /**
     * Gets the cardIndicators value for this NewOrderRequestElement.
     * 
     * @return cardIndicators
     */
    public java.lang.String getCardIndicators() {
        return cardIndicators;
    }


    /**
     * Sets the cardIndicators value for this NewOrderRequestElement.
     * 
     * @param cardIndicators
     */
    public void setCardIndicators(java.lang.String cardIndicators) {
        this.cardIndicators = cardIndicators;
    }


    /**
     * Gets the tipAmt value for this NewOrderRequestElement.
     * 
     * @return tipAmt
     */
    public java.lang.String getTipAmt() {
        return tipAmt;
    }


    /**
     * Sets the tipAmt value for this NewOrderRequestElement.
     * 
     * @param tipAmt
     */
    public void setTipAmt(java.lang.String tipAmt) {
        this.tipAmt = tipAmt;
    }


    /**
     * Gets the discountAmt value for this NewOrderRequestElement.
     * 
     * @return discountAmt
     */
    public java.lang.String getDiscountAmt() {
        return discountAmt;
    }


    /**
     * Sets the discountAmt value for this NewOrderRequestElement.
     * 
     * @param discountAmt
     */
    public void setDiscountAmt(java.lang.String discountAmt) {
        this.discountAmt = discountAmt;
    }


    /**
     * Gets the txnSurchargeAmt value for this NewOrderRequestElement.
     * 
     * @return txnSurchargeAmt
     */
    public java.lang.String getTxnSurchargeAmt() {
        return txnSurchargeAmt;
    }


    /**
     * Sets the txnSurchargeAmt value for this NewOrderRequestElement.
     * 
     * @param txnSurchargeAmt
     */
    public void setTxnSurchargeAmt(java.lang.String txnSurchargeAmt) {
        this.txnSurchargeAmt = txnSurchargeAmt;
    }


    /**
     * Gets the paymentActionInd value for this NewOrderRequestElement.
     * 
     * @return paymentActionInd
     */
    public java.lang.String getPaymentActionInd() {
        return paymentActionInd;
    }


    /**
     * Sets the paymentActionInd value for this NewOrderRequestElement.
     * 
     * @param paymentActionInd
     */
    public void setPaymentActionInd(java.lang.String paymentActionInd) {
        this.paymentActionInd = paymentActionInd;
    }


    /**
     * Gets the dpanInd value for this NewOrderRequestElement.
     * 
     * @return dpanInd
     */
    public java.lang.String getDpanInd() {
        return dpanInd;
    }


    /**
     * Sets the dpanInd value for this NewOrderRequestElement.
     * 
     * @param dpanInd
     */
    public void setDpanInd(java.lang.String dpanInd) {
        this.dpanInd = dpanInd;
    }


    /**
     * Gets the axAEVV value for this NewOrderRequestElement.
     * 
     * @return axAEVV
     */
    public java.lang.String getAxAEVV() {
        return axAEVV;
    }


    /**
     * Sets the axAEVV value for this NewOrderRequestElement.
     * 
     * @param axAEVV
     */
    public void setAxAEVV(java.lang.String axAEVV) {
        this.axAEVV = axAEVV;
    }


    /**
     * Gets the posEntryMode value for this NewOrderRequestElement.
     * 
     * @return posEntryMode
     */
    public java.lang.String getPosEntryMode() {
        return posEntryMode;
    }


    /**
     * Sets the posEntryMode value for this NewOrderRequestElement.
     * 
     * @param posEntryMode
     */
    public void setPosEntryMode(java.lang.String posEntryMode) {
        this.posEntryMode = posEntryMode;
    }


    /**
     * Gets the dataEntrySource value for this NewOrderRequestElement.
     * 
     * @return dataEntrySource
     */
    public java.lang.String getDataEntrySource() {
        return dataEntrySource;
    }


    /**
     * Sets the dataEntrySource value for this NewOrderRequestElement.
     * 
     * @param dataEntrySource
     */
    public void setDataEntrySource(java.lang.String dataEntrySource) {
        this.dataEntrySource = dataEntrySource;
    }


    /**
     * Gets the panSequenceNumber value for this NewOrderRequestElement.
     * 
     * @return panSequenceNumber
     */
    public java.lang.String getPanSequenceNumber() {
        return panSequenceNumber;
    }


    /**
     * Sets the panSequenceNumber value for this NewOrderRequestElement.
     * 
     * @param panSequenceNumber
     */
    public void setPanSequenceNumber(java.lang.String panSequenceNumber) {
        this.panSequenceNumber = panSequenceNumber;
    }


    /**
     * Gets the applicationId value for this NewOrderRequestElement.
     * 
     * @return applicationId
     */
    public java.lang.String getApplicationId() {
        return applicationId;
    }


    /**
     * Sets the applicationId value for this NewOrderRequestElement.
     * 
     * @param applicationId
     */
    public void setApplicationId(java.lang.String applicationId) {
        this.applicationId = applicationId;
    }


    /**
     * Gets the applicationLabel value for this NewOrderRequestElement.
     * 
     * @return applicationLabel
     */
    public java.lang.String getApplicationLabel() {
        return applicationLabel;
    }


    /**
     * Sets the applicationLabel value for this NewOrderRequestElement.
     * 
     * @param applicationLabel
     */
    public void setApplicationLabel(java.lang.String applicationLabel) {
        this.applicationLabel = applicationLabel;
    }


    /**
     * Gets the chipCardData value for this NewOrderRequestElement.
     * 
     * @return chipCardData
     */
    public java.lang.String getChipCardData() {
        return chipCardData;
    }


    /**
     * Sets the chipCardData value for this NewOrderRequestElement.
     * 
     * @param chipCardData
     */
    public void setChipCardData(java.lang.String chipCardData) {
        this.chipCardData = chipCardData;
    }


    /**
     * Gets the pin value for this NewOrderRequestElement.
     * 
     * @return pin
     */
    public java.lang.String getPin() {
        return pin;
    }


    /**
     * Sets the pin value for this NewOrderRequestElement.
     * 
     * @param pin
     */
    public void setPin(java.lang.String pin) {
        this.pin = pin;
    }


    /**
     * Gets the pinKeySerialNumber value for this NewOrderRequestElement.
     * 
     * @return pinKeySerialNumber
     */
    public java.lang.String getPinKeySerialNumber() {
        return pinKeySerialNumber;
    }


    /**
     * Sets the pinKeySerialNumber value for this NewOrderRequestElement.
     * 
     * @param pinKeySerialNumber
     */
    public void setPinKeySerialNumber(java.lang.String pinKeySerialNumber) {
        this.pinKeySerialNumber = pinKeySerialNumber;
    }


    /**
     * Gets the tvr value for this NewOrderRequestElement.
     * 
     * @return tvr
     */
    public java.lang.String getTvr() {
        return tvr;
    }


    /**
     * Sets the tvr value for this NewOrderRequestElement.
     * 
     * @param tvr
     */
    public void setTvr(java.lang.String tvr) {
        this.tvr = tvr;
    }


    /**
     * Gets the tsi value for this NewOrderRequestElement.
     * 
     * @return tsi
     */
    public java.lang.String getTsi() {
        return tsi;
    }


    /**
     * Sets the tsi value for this NewOrderRequestElement.
     * 
     * @param tsi
     */
    public void setTsi(java.lang.String tsi) {
        this.tsi = tsi;
    }


    /**
     * Gets the attendedTerminal value for this NewOrderRequestElement.
     * 
     * @return attendedTerminal
     */
    public java.lang.String getAttendedTerminal() {
        return attendedTerminal;
    }


    /**
     * Sets the attendedTerminal value for this NewOrderRequestElement.
     * 
     * @param attendedTerminal
     */
    public void setAttendedTerminal(java.lang.String attendedTerminal) {
        this.attendedTerminal = attendedTerminal;
    }


    /**
     * Gets the terminalLocation value for this NewOrderRequestElement.
     * 
     * @return terminalLocation
     */
    public java.lang.String getTerminalLocation() {
        return terminalLocation;
    }


    /**
     * Sets the terminalLocation value for this NewOrderRequestElement.
     * 
     * @param terminalLocation
     */
    public void setTerminalLocation(java.lang.String terminalLocation) {
        this.terminalLocation = terminalLocation;
    }


    /**
     * Gets the cardholderPresent value for this NewOrderRequestElement.
     * 
     * @return cardholderPresent
     */
    public java.lang.String getCardholderPresent() {
        return cardholderPresent;
    }


    /**
     * Sets the cardholderPresent value for this NewOrderRequestElement.
     * 
     * @param cardholderPresent
     */
    public void setCardholderPresent(java.lang.String cardholderPresent) {
        this.cardholderPresent = cardholderPresent;
    }


    /**
     * Gets the cardholderActivatedTerminal value for this NewOrderRequestElement.
     * 
     * @return cardholderActivatedTerminal
     */
    public java.lang.String getCardholderActivatedTerminal() {
        return cardholderActivatedTerminal;
    }


    /**
     * Sets the cardholderActivatedTerminal value for this NewOrderRequestElement.
     * 
     * @param cardholderActivatedTerminal
     */
    public void setCardholderActivatedTerminal(java.lang.String cardholderActivatedTerminal) {
        this.cardholderActivatedTerminal = cardholderActivatedTerminal;
    }


    /**
     * Gets the terminalEntry value for this NewOrderRequestElement.
     * 
     * @return terminalEntry
     */
    public java.lang.String getTerminalEntry() {
        return terminalEntry;
    }


    /**
     * Sets the terminalEntry value for this NewOrderRequestElement.
     * 
     * @param terminalEntry
     */
    public void setTerminalEntry(java.lang.String terminalEntry) {
        this.terminalEntry = terminalEntry;
    }


    /**
     * Gets the terminalLaneId value for this NewOrderRequestElement.
     * 
     * @return terminalLaneId
     */
    public java.lang.String getTerminalLaneId() {
        return terminalLaneId;
    }


    /**
     * Sets the terminalLaneId value for this NewOrderRequestElement.
     * 
     * @param terminalLaneId
     */
    public void setTerminalLaneId(java.lang.String terminalLaneId) {
        this.terminalLaneId = terminalLaneId;
    }


    /**
     * Gets the emvSupport value for this NewOrderRequestElement.
     * 
     * @return emvSupport
     */
    public java.lang.String getEmvSupport() {
        return emvSupport;
    }


    /**
     * Sets the emvSupport value for this NewOrderRequestElement.
     * 
     * @param emvSupport
     */
    public void setEmvSupport(java.lang.String emvSupport) {
        this.emvSupport = emvSupport;
    }


    /**
     * Gets the peripheralSupport value for this NewOrderRequestElement.
     * 
     * @return peripheralSupport
     */
    public java.lang.String getPeripheralSupport() {
        return peripheralSupport;
    }


    /**
     * Sets the peripheralSupport value for this NewOrderRequestElement.
     * 
     * @param peripheralSupport
     */
    public void setPeripheralSupport(java.lang.String peripheralSupport) {
        this.peripheralSupport = peripheralSupport;
    }


    /**
     * Gets the communicationSupport value for this NewOrderRequestElement.
     * 
     * @return communicationSupport
     */
    public java.lang.String getCommunicationSupport() {
        return communicationSupport;
    }


    /**
     * Sets the communicationSupport value for this NewOrderRequestElement.
     * 
     * @param communicationSupport
     */
    public void setCommunicationSupport(java.lang.String communicationSupport) {
        this.communicationSupport = communicationSupport;
    }


    /**
     * Gets the industrySupport value for this NewOrderRequestElement.
     * 
     * @return industrySupport
     */
    public java.lang.String getIndustrySupport() {
        return industrySupport;
    }


    /**
     * Sets the industrySupport value for this NewOrderRequestElement.
     * 
     * @param industrySupport
     */
    public void setIndustrySupport(java.lang.String industrySupport) {
        this.industrySupport = industrySupport;
    }


    /**
     * Gets the complianceClass value for this NewOrderRequestElement.
     * 
     * @return complianceClass
     */
    public java.lang.String getComplianceClass() {
        return complianceClass;
    }


    /**
     * Sets the complianceClass value for this NewOrderRequestElement.
     * 
     * @param complianceClass
     */
    public void setComplianceClass(java.lang.String complianceClass) {
        this.complianceClass = complianceClass;
    }


    /**
     * Gets the deviceSecuritySupport value for this NewOrderRequestElement.
     * 
     * @return deviceSecuritySupport
     */
    public java.lang.String getDeviceSecuritySupport() {
        return deviceSecuritySupport;
    }


    /**
     * Sets the deviceSecuritySupport value for this NewOrderRequestElement.
     * 
     * @param deviceSecuritySupport
     */
    public void setDeviceSecuritySupport(java.lang.String deviceSecuritySupport) {
        this.deviceSecuritySupport = deviceSecuritySupport;
    }


    /**
     * Gets the dwWalletID value for this NewOrderRequestElement.
     * 
     * @return dwWalletID
     */
    public java.lang.String getDwWalletID() {
        return dwWalletID;
    }


    /**
     * Sets the dwWalletID value for this NewOrderRequestElement.
     * 
     * @param dwWalletID
     */
    public void setDwWalletID(java.lang.String dwWalletID) {
        this.dwWalletID = dwWalletID;
    }


    /**
     * Gets the dwSLI value for this NewOrderRequestElement.
     * 
     * @return dwSLI
     */
    public java.lang.String getDwSLI() {
        return dwSLI;
    }


    /**
     * Sets the dwSLI value for this NewOrderRequestElement.
     * 
     * @param dwSLI
     */
    public void setDwSLI(java.lang.String dwSLI) {
        this.dwSLI = dwSLI;
    }


    /**
     * Gets the dwIncentiveInd value for this NewOrderRequestElement.
     * 
     * @return dwIncentiveInd
     */
    public java.lang.String getDwIncentiveInd() {
        return dwIncentiveInd;
    }


    /**
     * Sets the dwIncentiveInd value for this NewOrderRequestElement.
     * 
     * @param dwIncentiveInd
     */
    public void setDwIncentiveInd(java.lang.String dwIncentiveInd) {
        this.dwIncentiveInd = dwIncentiveInd;
    }


    /**
     * Gets the digitalWalletType value for this NewOrderRequestElement.
     * 
     * @return digitalWalletType
     */
    public java.lang.String getDigitalWalletType() {
        return digitalWalletType;
    }


    /**
     * Sets the digitalWalletType value for this NewOrderRequestElement.
     * 
     * @param digitalWalletType
     */
    public void setDigitalWalletType(java.lang.String digitalWalletType) {
        this.digitalWalletType = digitalWalletType;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof NewOrderRequestElement)) return false;
        NewOrderRequestElement other = (NewOrderRequestElement) obj;
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
            ((this.industryType==null && other.getIndustryType()==null) || 
             (this.industryType!=null &&
              this.industryType.equals(other.getIndustryType()))) &&
            ((this.transType==null && other.getTransType()==null) || 
             (this.transType!=null &&
              this.transType.equals(other.getTransType()))) &&
            ((this.bin==null && other.getBin()==null) || 
             (this.bin!=null &&
              this.bin.equals(other.getBin()))) &&
            ((this.merchantID==null && other.getMerchantID()==null) || 
             (this.merchantID!=null &&
              this.merchantID.equals(other.getMerchantID()))) &&
            ((this.terminalID==null && other.getTerminalID()==null) || 
             (this.terminalID!=null &&
              this.terminalID.equals(other.getTerminalID()))) &&
            ((this.cardBrand==null && other.getCardBrand()==null) || 
             (this.cardBrand!=null &&
              this.cardBrand.equals(other.getCardBrand()))) &&
            ((this.ccAccountNum==null && other.getCcAccountNum()==null) || 
             (this.ccAccountNum!=null &&
              this.ccAccountNum.equals(other.getCcAccountNum()))) &&
            ((this.encryptedPan==null && other.getEncryptedPan()==null) || 
             (this.encryptedPan!=null &&
              this.encryptedPan.equals(other.getEncryptedPan()))) &&
            ((this.encryptedPanMethod==null && other.getEncryptedPanMethod()==null) || 
             (this.encryptedPanMethod!=null &&
              this.encryptedPanMethod.equals(other.getEncryptedPanMethod()))) &&
            ((this.encryptedPanKey==null && other.getEncryptedPanKey()==null) || 
             (this.encryptedPanKey!=null &&
              this.encryptedPanKey.equals(other.getEncryptedPanKey()))) &&
            ((this.encryptedPanPublicKeyFingerPrint==null && other.getEncryptedPanPublicKeyFingerPrint()==null) || 
             (this.encryptedPanPublicKeyFingerPrint!=null &&
              this.encryptedPanPublicKeyFingerPrint.equals(other.getEncryptedPanPublicKeyFingerPrint()))) &&
            ((this.encryptedPanHash==null && other.getEncryptedPanHash()==null) || 
             (this.encryptedPanHash!=null &&
              this.encryptedPanHash.equals(other.getEncryptedPanHash()))) &&
            ((this.ccExp==null && other.getCcExp()==null) || 
             (this.ccExp!=null &&
              this.ccExp.equals(other.getCcExp()))) &&
            ((this.ccCardVerifyPresenceInd==null && other.getCcCardVerifyPresenceInd()==null) || 
             (this.ccCardVerifyPresenceInd!=null &&
              this.ccCardVerifyPresenceInd.equals(other.getCcCardVerifyPresenceInd()))) &&
            ((this.ccCardVerifyNum==null && other.getCcCardVerifyNum()==null) || 
             (this.ccCardVerifyNum!=null &&
              this.ccCardVerifyNum.equals(other.getCcCardVerifyNum()))) &&
            ((this.switchSoloIssueNum==null && other.getSwitchSoloIssueNum()==null) || 
             (this.switchSoloIssueNum!=null &&
              this.switchSoloIssueNum.equals(other.getSwitchSoloIssueNum()))) &&
            ((this.switchSoloCardStartDate==null && other.getSwitchSoloCardStartDate()==null) || 
             (this.switchSoloCardStartDate!=null &&
              this.switchSoloCardStartDate.equals(other.getSwitchSoloCardStartDate()))) &&
            ((this.ecpCheckRT==null && other.getEcpCheckRT()==null) || 
             (this.ecpCheckRT!=null &&
              this.ecpCheckRT.equals(other.getEcpCheckRT()))) &&
            ((this.ecpCheckDDA==null && other.getEcpCheckDDA()==null) || 
             (this.ecpCheckDDA!=null &&
              this.ecpCheckDDA.equals(other.getEcpCheckDDA()))) &&
            ((this.ecpBankAcctType==null && other.getEcpBankAcctType()==null) || 
             (this.ecpBankAcctType!=null &&
              this.ecpBankAcctType.equals(other.getEcpBankAcctType()))) &&
            ((this.ecpAuthMethod==null && other.getEcpAuthMethod()==null) || 
             (this.ecpAuthMethod!=null &&
              this.ecpAuthMethod.equals(other.getEcpAuthMethod()))) &&
            ((this.ecpDelvMethod==null && other.getEcpDelvMethod()==null) || 
             (this.ecpDelvMethod!=null &&
              this.ecpDelvMethod.equals(other.getEcpDelvMethod()))) &&
            ((this.avsZip==null && other.getAvsZip()==null) || 
             (this.avsZip!=null &&
              this.avsZip.equals(other.getAvsZip()))) &&
            ((this.avsAddress1==null && other.getAvsAddress1()==null) || 
             (this.avsAddress1!=null &&
              this.avsAddress1.equals(other.getAvsAddress1()))) &&
            ((this.avsAddress2==null && other.getAvsAddress2()==null) || 
             (this.avsAddress2!=null &&
              this.avsAddress2.equals(other.getAvsAddress2()))) &&
            ((this.avsCity==null && other.getAvsCity()==null) || 
             (this.avsCity!=null &&
              this.avsCity.equals(other.getAvsCity()))) &&
            ((this.avsState==null && other.getAvsState()==null) || 
             (this.avsState!=null &&
              this.avsState.equals(other.getAvsState()))) &&
            ((this.avsName==null && other.getAvsName()==null) || 
             (this.avsName!=null &&
              this.avsName.equals(other.getAvsName()))) &&
            ((this.avsCountryCode==null && other.getAvsCountryCode()==null) || 
             (this.avsCountryCode!=null &&
              this.avsCountryCode.equals(other.getAvsCountryCode()))) &&
            ((this.avsPhone==null && other.getAvsPhone()==null) || 
             (this.avsPhone!=null &&
              this.avsPhone.equals(other.getAvsPhone()))) &&
            ((this.useCustomerRefNum==null && other.getUseCustomerRefNum()==null) || 
             (this.useCustomerRefNum!=null &&
              this.useCustomerRefNum.equals(other.getUseCustomerRefNum()))) &&
            ((this.addProfileFromOrder==null && other.getAddProfileFromOrder()==null) || 
             (this.addProfileFromOrder!=null &&
              this.addProfileFromOrder.equals(other.getAddProfileFromOrder()))) &&
            ((this.customerRefNum==null && other.getCustomerRefNum()==null) || 
             (this.customerRefNum!=null &&
              this.customerRefNum.equals(other.getCustomerRefNum()))) &&
            ((this.profileOrderOverideInd==null && other.getProfileOrderOverideInd()==null) || 
             (this.profileOrderOverideInd!=null &&
              this.profileOrderOverideInd.equals(other.getProfileOrderOverideInd()))) &&
            ((this.authenticationECIInd==null && other.getAuthenticationECIInd()==null) || 
             (this.authenticationECIInd!=null &&
              this.authenticationECIInd.equals(other.getAuthenticationECIInd()))) &&
            ((this.verifyByVisaCAVV==null && other.getVerifyByVisaCAVV()==null) || 
             (this.verifyByVisaCAVV!=null &&
              this.verifyByVisaCAVV.equals(other.getVerifyByVisaCAVV()))) &&
            ((this.verifyByVisaXID==null && other.getVerifyByVisaXID()==null) || 
             (this.verifyByVisaXID!=null &&
              this.verifyByVisaXID.equals(other.getVerifyByVisaXID()))) &&
            ((this.priorAuthCd==null && other.getPriorAuthCd()==null) || 
             (this.priorAuthCd!=null &&
              this.priorAuthCd.equals(other.getPriorAuthCd()))) &&
            ((this.orderID==null && other.getOrderID()==null) || 
             (this.orderID!=null &&
              this.orderID.equals(other.getOrderID()))) &&
            ((this.amount==null && other.getAmount()==null) || 
             (this.amount!=null &&
              this.amount.equals(other.getAmount()))) &&
            ((this.comments==null && other.getComments()==null) || 
             (this.comments!=null &&
              this.comments.equals(other.getComments()))) &&
            ((this.shippingRef==null && other.getShippingRef()==null) || 
             (this.shippingRef!=null &&
              this.shippingRef.equals(other.getShippingRef()))) &&
            ((this.taxInd==null && other.getTaxInd()==null) || 
             (this.taxInd!=null &&
              this.taxInd.equals(other.getTaxInd()))) &&
            ((this.taxAmount==null && other.getTaxAmount()==null) || 
             (this.taxAmount!=null &&
              this.taxAmount.equals(other.getTaxAmount()))) &&
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
            ((this.mcSecureCodeAAV==null && other.getMcSecureCodeAAV()==null) || 
             (this.mcSecureCodeAAV!=null &&
              this.mcSecureCodeAAV.equals(other.getMcSecureCodeAAV()))) &&
            ((this.softDescMercName==null && other.getSoftDescMercName()==null) || 
             (this.softDescMercName!=null &&
              this.softDescMercName.equals(other.getSoftDescMercName()))) &&
            ((this.softDescProdDesc==null && other.getSoftDescProdDesc()==null) || 
             (this.softDescProdDesc!=null &&
              this.softDescProdDesc.equals(other.getSoftDescProdDesc()))) &&
            ((this.softDescMercCity==null && other.getSoftDescMercCity()==null) || 
             (this.softDescMercCity!=null &&
              this.softDescMercCity.equals(other.getSoftDescMercCity()))) &&
            ((this.softDescMercPhone==null && other.getSoftDescMercPhone()==null) || 
             (this.softDescMercPhone!=null &&
              this.softDescMercPhone.equals(other.getSoftDescMercPhone()))) &&
            ((this.softDescMercURL==null && other.getSoftDescMercURL()==null) || 
             (this.softDescMercURL!=null &&
              this.softDescMercURL.equals(other.getSoftDescMercURL()))) &&
            ((this.softDescMercEmail==null && other.getSoftDescMercEmail()==null) || 
             (this.softDescMercEmail!=null &&
              this.softDescMercEmail.equals(other.getSoftDescMercEmail()))) &&
            ((this.recurringInd==null && other.getRecurringInd()==null) || 
             (this.recurringInd!=null &&
              this.recurringInd.equals(other.getRecurringInd()))) &&
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
              java.util.Arrays.equals(this.pCard3LineItems, other.getPCard3LineItems()))) &&
            ((this.magStripeTrack1==null && other.getMagStripeTrack1()==null) || 
             (this.magStripeTrack1!=null &&
              this.magStripeTrack1.equals(other.getMagStripeTrack1()))) &&
            ((this.magStripeTrack2==null && other.getMagStripeTrack2()==null) || 
             (this.magStripeTrack2!=null &&
              this.magStripeTrack2.equals(other.getMagStripeTrack2()))) &&
            ((this.retailTransInfo==null && other.getRetailTransInfo()==null) || 
             (this.retailTransInfo!=null &&
              this.retailTransInfo.equals(other.getRetailTransInfo()))) &&
            ((this.customerName==null && other.getCustomerName()==null) || 
             (this.customerName!=null &&
              this.customerName.equals(other.getCustomerName()))) &&
            ((this.customerEmail==null && other.getCustomerEmail()==null) || 
             (this.customerEmail!=null &&
              this.customerEmail.equals(other.getCustomerEmail()))) &&
            ((this.customerPhone==null && other.getCustomerPhone()==null) || 
             (this.customerPhone!=null &&
              this.customerPhone.equals(other.getCustomerPhone()))) &&
            ((this.cardPresentInd==null && other.getCardPresentInd()==null) || 
             (this.cardPresentInd!=null &&
              this.cardPresentInd.equals(other.getCardPresentInd()))) &&
            ((this.euddBankSortCode==null && other.getEuddBankSortCode()==null) || 
             (this.euddBankSortCode!=null &&
              this.euddBankSortCode.equals(other.getEuddBankSortCode()))) &&
            ((this.euddCountryCode==null && other.getEuddCountryCode()==null) || 
             (this.euddCountryCode!=null &&
              this.euddCountryCode.equals(other.getEuddCountryCode()))) &&
            ((this.euddRibCode==null && other.getEuddRibCode()==null) || 
             (this.euddRibCode!=null &&
              this.euddRibCode.equals(other.getEuddRibCode()))) &&
            ((this.euddBankBranchCode==null && other.getEuddBankBranchCode()==null) || 
             (this.euddBankBranchCode!=null &&
              this.euddBankBranchCode.equals(other.getEuddBankBranchCode()))) &&
            ((this.euddIBAN==null && other.getEuddIBAN()==null) || 
             (this.euddIBAN!=null &&
              this.euddIBAN.equals(other.getEuddIBAN()))) &&
            ((this.euddBIC==null && other.getEuddBIC()==null) || 
             (this.euddBIC!=null &&
              this.euddBIC.equals(other.getEuddBIC()))) &&
            ((this.euddMandateSignatureDate==null && other.getEuddMandateSignatureDate()==null) || 
             (this.euddMandateSignatureDate!=null &&
              this.euddMandateSignatureDate.equals(other.getEuddMandateSignatureDate()))) &&
            ((this.euddMandateID==null && other.getEuddMandateID()==null) || 
             (this.euddMandateID!=null &&
              this.euddMandateID.equals(other.getEuddMandateID()))) &&
            ((this.euddMandateType==null && other.getEuddMandateType()==null) || 
             (this.euddMandateType!=null &&
              this.euddMandateType.equals(other.getEuddMandateType()))) &&
            ((this.paymentInd==null && other.getPaymentInd()==null) || 
             (this.paymentInd!=null &&
              this.paymentInd.equals(other.getPaymentInd()))) &&
            ((this.bmlCustomerIP==null && other.getBmlCustomerIP()==null) || 
             (this.bmlCustomerIP!=null &&
              this.bmlCustomerIP.equals(other.getBmlCustomerIP()))) &&
            ((this.bmlCustomerEmail==null && other.getBmlCustomerEmail()==null) || 
             (this.bmlCustomerEmail!=null &&
              this.bmlCustomerEmail.equals(other.getBmlCustomerEmail()))) &&
            ((this.bmlShippingCost==null && other.getBmlShippingCost()==null) || 
             (this.bmlShippingCost!=null &&
              this.bmlShippingCost.equals(other.getBmlShippingCost()))) &&
            ((this.bmlTNCVersion==null && other.getBmlTNCVersion()==null) || 
             (this.bmlTNCVersion!=null &&
              this.bmlTNCVersion.equals(other.getBmlTNCVersion()))) &&
            ((this.bmlCustomerRegistrationDate==null && other.getBmlCustomerRegistrationDate()==null) || 
             (this.bmlCustomerRegistrationDate!=null &&
              this.bmlCustomerRegistrationDate.equals(other.getBmlCustomerRegistrationDate()))) &&
            ((this.bmlCustomerTypeFlag==null && other.getBmlCustomerTypeFlag()==null) || 
             (this.bmlCustomerTypeFlag!=null &&
              this.bmlCustomerTypeFlag.equals(other.getBmlCustomerTypeFlag()))) &&
            ((this.bmlItemCategory==null && other.getBmlItemCategory()==null) || 
             (this.bmlItemCategory!=null &&
              this.bmlItemCategory.equals(other.getBmlItemCategory()))) &&
            ((this.bmlPreapprovalInvitationNum==null && other.getBmlPreapprovalInvitationNum()==null) || 
             (this.bmlPreapprovalInvitationNum!=null &&
              this.bmlPreapprovalInvitationNum.equals(other.getBmlPreapprovalInvitationNum()))) &&
            ((this.bmlMerchantPromotionalCode==null && other.getBmlMerchantPromotionalCode()==null) || 
             (this.bmlMerchantPromotionalCode!=null &&
              this.bmlMerchantPromotionalCode.equals(other.getBmlMerchantPromotionalCode()))) &&
            ((this.bmlCustomerBirthDate==null && other.getBmlCustomerBirthDate()==null) || 
             (this.bmlCustomerBirthDate!=null &&
              this.bmlCustomerBirthDate.equals(other.getBmlCustomerBirthDate()))) &&
            ((this.bmlCustomerSSN==null && other.getBmlCustomerSSN()==null) || 
             (this.bmlCustomerSSN!=null &&
              this.bmlCustomerSSN.equals(other.getBmlCustomerSSN()))) &&
            ((this.bmlCustomerAnnualIncome==null && other.getBmlCustomerAnnualIncome()==null) || 
             (this.bmlCustomerAnnualIncome!=null &&
              this.bmlCustomerAnnualIncome.equals(other.getBmlCustomerAnnualIncome()))) &&
            ((this.bmlCustomerResidenceStatus==null && other.getBmlCustomerResidenceStatus()==null) || 
             (this.bmlCustomerResidenceStatus!=null &&
              this.bmlCustomerResidenceStatus.equals(other.getBmlCustomerResidenceStatus()))) &&
            ((this.bmlCustomerCheckingAccount==null && other.getBmlCustomerCheckingAccount()==null) || 
             (this.bmlCustomerCheckingAccount!=null &&
              this.bmlCustomerCheckingAccount.equals(other.getBmlCustomerCheckingAccount()))) &&
            ((this.bmlCustomerSavingsAccount==null && other.getBmlCustomerSavingsAccount()==null) || 
             (this.bmlCustomerSavingsAccount!=null &&
              this.bmlCustomerSavingsAccount.equals(other.getBmlCustomerSavingsAccount()))) &&
            ((this.bmlProductDeliveryType==null && other.getBmlProductDeliveryType()==null) || 
             (this.bmlProductDeliveryType!=null &&
              this.bmlProductDeliveryType.equals(other.getBmlProductDeliveryType()))) &&
            ((this.avsDestName==null && other.getAvsDestName()==null) || 
             (this.avsDestName!=null &&
              this.avsDestName.equals(other.getAvsDestName()))) &&
            ((this.avsDestAddress1==null && other.getAvsDestAddress1()==null) || 
             (this.avsDestAddress1!=null &&
              this.avsDestAddress1.equals(other.getAvsDestAddress1()))) &&
            ((this.avsDestAddress2==null && other.getAvsDestAddress2()==null) || 
             (this.avsDestAddress2!=null &&
              this.avsDestAddress2.equals(other.getAvsDestAddress2()))) &&
            ((this.avsDestCity==null && other.getAvsDestCity()==null) || 
             (this.avsDestCity!=null &&
              this.avsDestCity.equals(other.getAvsDestCity()))) &&
            ((this.avsDestState==null && other.getAvsDestState()==null) || 
             (this.avsDestState!=null &&
              this.avsDestState.equals(other.getAvsDestState()))) &&
            ((this.avsDestZip==null && other.getAvsDestZip()==null) || 
             (this.avsDestZip!=null &&
              this.avsDestZip.equals(other.getAvsDestZip()))) &&
            ((this.avsDestCountryCode==null && other.getAvsDestCountryCode()==null) || 
             (this.avsDestCountryCode!=null &&
              this.avsDestCountryCode.equals(other.getAvsDestCountryCode()))) &&
            ((this.avsDestPhoneNum==null && other.getAvsDestPhoneNum()==null) || 
             (this.avsDestPhoneNum!=null &&
              this.avsDestPhoneNum.equals(other.getAvsDestPhoneNum()))) &&
            ((this.debitBillerReferenceNumber==null && other.getDebitBillerReferenceNumber()==null) || 
             (this.debitBillerReferenceNumber!=null &&
              this.debitBillerReferenceNumber.equals(other.getDebitBillerReferenceNumber()))) &&
            ((this.mbType==null && other.getMbType()==null) || 
             (this.mbType!=null &&
              this.mbType.equals(other.getMbType()))) &&
            ((this.mbOrderIdGenerationMethod==null && other.getMbOrderIdGenerationMethod()==null) || 
             (this.mbOrderIdGenerationMethod!=null &&
              this.mbOrderIdGenerationMethod.equals(other.getMbOrderIdGenerationMethod()))) &&
            ((this.mbRecurringStartDate==null && other.getMbRecurringStartDate()==null) || 
             (this.mbRecurringStartDate!=null &&
              this.mbRecurringStartDate.equals(other.getMbRecurringStartDate()))) &&
            ((this.mbRecurringEndDate==null && other.getMbRecurringEndDate()==null) || 
             (this.mbRecurringEndDate!=null &&
              this.mbRecurringEndDate.equals(other.getMbRecurringEndDate()))) &&
            ((this.mbRecurringNoEndDateFlag==null && other.getMbRecurringNoEndDateFlag()==null) || 
             (this.mbRecurringNoEndDateFlag!=null &&
              this.mbRecurringNoEndDateFlag.equals(other.getMbRecurringNoEndDateFlag()))) &&
            ((this.mbRecurringMaxBillings==null && other.getMbRecurringMaxBillings()==null) || 
             (this.mbRecurringMaxBillings!=null &&
              this.mbRecurringMaxBillings.equals(other.getMbRecurringMaxBillings()))) &&
            ((this.mbRecurringFrequency==null && other.getMbRecurringFrequency()==null) || 
             (this.mbRecurringFrequency!=null &&
              this.mbRecurringFrequency.equals(other.getMbRecurringFrequency()))) &&
            ((this.mbMicroPaymentMaxDollarValue==null && other.getMbMicroPaymentMaxDollarValue()==null) || 
             (this.mbMicroPaymentMaxDollarValue!=null &&
              this.mbMicroPaymentMaxDollarValue.equals(other.getMbMicroPaymentMaxDollarValue()))) &&
            ((this.mbMicroPaymentMaxBillingDays==null && other.getMbMicroPaymentMaxBillingDays()==null) || 
             (this.mbMicroPaymentMaxBillingDays!=null &&
              this.mbMicroPaymentMaxBillingDays.equals(other.getMbMicroPaymentMaxBillingDays()))) &&
            ((this.mbMicroPaymentMaxTransactions==null && other.getMbMicroPaymentMaxTransactions()==null) || 
             (this.mbMicroPaymentMaxTransactions!=null &&
              this.mbMicroPaymentMaxTransactions.equals(other.getMbMicroPaymentMaxTransactions()))) &&
            ((this.mbDeferredBillDate==null && other.getMbDeferredBillDate()==null) || 
             (this.mbDeferredBillDate!=null &&
              this.mbDeferredBillDate.equals(other.getMbDeferredBillDate()))) &&
            ((this.debitPinNumber==null && other.getDebitPinNumber()==null) || 
             (this.debitPinNumber!=null &&
              this.debitPinNumber.equals(other.getDebitPinNumber()))) &&
            ((this.debitPinSecurityControl==null && other.getDebitPinSecurityControl()==null) || 
             (this.debitPinSecurityControl!=null &&
              this.debitPinSecurityControl.equals(other.getDebitPinSecurityControl()))) &&
            ((this.debitPinCashBack==null && other.getDebitPinCashBack()==null) || 
             (this.debitPinCashBack!=null &&
              this.debitPinCashBack.equals(other.getDebitPinCashBack()))) &&
            ((this.partialAuthInd==null && other.getPartialAuthInd()==null) || 
             (this.partialAuthInd!=null &&
              this.partialAuthInd.equals(other.getPartialAuthInd()))) &&
            ((this.accountUpdaterEligibility==null && other.getAccountUpdaterEligibility()==null) || 
             (this.accountUpdaterEligibility!=null &&
              this.accountUpdaterEligibility.equals(other.getAccountUpdaterEligibility()))) &&
            ((this.useStoredAAVInd==null && other.getUseStoredAAVInd()==null) || 
             (this.useStoredAAVInd!=null &&
              this.useStoredAAVInd.equals(other.getUseStoredAAVInd()))) &&
            ((this.ecpActionCode==null && other.getEcpActionCode()==null) || 
             (this.ecpActionCode!=null &&
              this.ecpActionCode.equals(other.getEcpActionCode()))) &&
            ((this.ecpCheckSerialNumber==null && other.getEcpCheckSerialNumber()==null) || 
             (this.ecpCheckSerialNumber!=null &&
              this.ecpCheckSerialNumber.equals(other.getEcpCheckSerialNumber()))) &&
            ((this.ecpTerminalCity==null && other.getEcpTerminalCity()==null) || 
             (this.ecpTerminalCity!=null &&
              this.ecpTerminalCity.equals(other.getEcpTerminalCity()))) &&
            ((this.ecpTerminalState==null && other.getEcpTerminalState()==null) || 
             (this.ecpTerminalState!=null &&
              this.ecpTerminalState.equals(other.getEcpTerminalState()))) &&
            ((this.ecpImageReferenceNumber==null && other.getEcpImageReferenceNumber()==null) || 
             (this.ecpImageReferenceNumber!=null &&
              this.ecpImageReferenceNumber.equals(other.getEcpImageReferenceNumber()))) &&
            ((this.customerAni==null && other.getCustomerAni()==null) || 
             (this.customerAni!=null &&
              this.customerAni.equals(other.getCustomerAni()))) &&
            ((this.avsPhoneType==null && other.getAvsPhoneType()==null) || 
             (this.avsPhoneType!=null &&
              this.avsPhoneType.equals(other.getAvsPhoneType()))) &&
            ((this.avsDestPhoneType==null && other.getAvsDestPhoneType()==null) || 
             (this.avsDestPhoneType!=null &&
              this.avsDestPhoneType.equals(other.getAvsDestPhoneType()))) &&
            ((this.customerIpAddress==null && other.getCustomerIpAddress()==null) || 
             (this.customerIpAddress!=null &&
              this.customerIpAddress.equals(other.getCustomerIpAddress()))) &&
            ((this.emailAddressSubtype==null && other.getEmailAddressSubtype()==null) || 
             (this.emailAddressSubtype!=null &&
              this.emailAddressSubtype.equals(other.getEmailAddressSubtype()))) &&
            ((this.customerBrowserName==null && other.getCustomerBrowserName()==null) || 
             (this.customerBrowserName!=null &&
              this.customerBrowserName.equals(other.getCustomerBrowserName()))) &&
            ((this.shippingMethod==null && other.getShippingMethod()==null) || 
             (this.shippingMethod!=null &&
              this.shippingMethod.equals(other.getShippingMethod()))) &&
            ((this.fraudAnalysis==null && other.getFraudAnalysis()==null) || 
             (this.fraudAnalysis!=null &&
              this.fraudAnalysis.equals(other.getFraudAnalysis()))) &&
            ((this.softMerchantDescriptors==null && other.getSoftMerchantDescriptors()==null) || 
             (this.softMerchantDescriptors!=null &&
              this.softMerchantDescriptors.equals(other.getSoftMerchantDescriptors()))) &&
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
            ((this.keySerialNumber==null && other.getKeySerialNumber()==null) || 
             (this.keySerialNumber!=null &&
              this.keySerialNumber.equals(other.getKeySerialNumber()))) &&
            ((this.encryptedMagStripeTrack2==null && other.getEncryptedMagStripeTrack2()==null) || 
             (this.encryptedMagStripeTrack2!=null &&
              this.encryptedMagStripeTrack2.equals(other.getEncryptedMagStripeTrack2()))) &&
            ((this.encryptionInd==null && other.getEncryptionInd()==null) || 
             (this.encryptionInd!=null &&
              this.encryptionInd.equals(other.getEncryptionInd()))) &&
            ((this.cardIndicators==null && other.getCardIndicators()==null) || 
             (this.cardIndicators!=null &&
              this.cardIndicators.equals(other.getCardIndicators()))) &&
            ((this.tipAmt==null && other.getTipAmt()==null) || 
             (this.tipAmt!=null &&
              this.tipAmt.equals(other.getTipAmt()))) &&
            ((this.discountAmt==null && other.getDiscountAmt()==null) || 
             (this.discountAmt!=null &&
              this.discountAmt.equals(other.getDiscountAmt()))) &&
            ((this.txnSurchargeAmt==null && other.getTxnSurchargeAmt()==null) || 
             (this.txnSurchargeAmt!=null &&
              this.txnSurchargeAmt.equals(other.getTxnSurchargeAmt()))) &&
            ((this.paymentActionInd==null && other.getPaymentActionInd()==null) || 
             (this.paymentActionInd!=null &&
              this.paymentActionInd.equals(other.getPaymentActionInd()))) &&
            ((this.dpanInd==null && other.getDpanInd()==null) || 
             (this.dpanInd!=null &&
              this.dpanInd.equals(other.getDpanInd()))) &&
            ((this.axAEVV==null && other.getAxAEVV()==null) || 
             (this.axAEVV!=null &&
              this.axAEVV.equals(other.getAxAEVV()))) &&
            ((this.posEntryMode==null && other.getPosEntryMode()==null) || 
             (this.posEntryMode!=null &&
              this.posEntryMode.equals(other.getPosEntryMode()))) &&
            ((this.dataEntrySource==null && other.getDataEntrySource()==null) || 
             (this.dataEntrySource!=null &&
              this.dataEntrySource.equals(other.getDataEntrySource()))) &&
            ((this.panSequenceNumber==null && other.getPanSequenceNumber()==null) || 
             (this.panSequenceNumber!=null &&
              this.panSequenceNumber.equals(other.getPanSequenceNumber()))) &&
            ((this.applicationId==null && other.getApplicationId()==null) || 
             (this.applicationId!=null &&
              this.applicationId.equals(other.getApplicationId()))) &&
            ((this.applicationLabel==null && other.getApplicationLabel()==null) || 
             (this.applicationLabel!=null &&
              this.applicationLabel.equals(other.getApplicationLabel()))) &&
            ((this.chipCardData==null && other.getChipCardData()==null) || 
             (this.chipCardData!=null &&
              this.chipCardData.equals(other.getChipCardData()))) &&
            ((this.pin==null && other.getPin()==null) || 
             (this.pin!=null &&
              this.pin.equals(other.getPin()))) &&
            ((this.pinKeySerialNumber==null && other.getPinKeySerialNumber()==null) || 
             (this.pinKeySerialNumber!=null &&
              this.pinKeySerialNumber.equals(other.getPinKeySerialNumber()))) &&
            ((this.tvr==null && other.getTvr()==null) || 
             (this.tvr!=null &&
              this.tvr.equals(other.getTvr()))) &&
            ((this.tsi==null && other.getTsi()==null) || 
             (this.tsi!=null &&
              this.tsi.equals(other.getTsi()))) &&
            ((this.attendedTerminal==null && other.getAttendedTerminal()==null) || 
             (this.attendedTerminal!=null &&
              this.attendedTerminal.equals(other.getAttendedTerminal()))) &&
            ((this.terminalLocation==null && other.getTerminalLocation()==null) || 
             (this.terminalLocation!=null &&
              this.terminalLocation.equals(other.getTerminalLocation()))) &&
            ((this.cardholderPresent==null && other.getCardholderPresent()==null) || 
             (this.cardholderPresent!=null &&
              this.cardholderPresent.equals(other.getCardholderPresent()))) &&
            ((this.cardholderActivatedTerminal==null && other.getCardholderActivatedTerminal()==null) || 
             (this.cardholderActivatedTerminal!=null &&
              this.cardholderActivatedTerminal.equals(other.getCardholderActivatedTerminal()))) &&
            ((this.terminalEntry==null && other.getTerminalEntry()==null) || 
             (this.terminalEntry!=null &&
              this.terminalEntry.equals(other.getTerminalEntry()))) &&
            ((this.terminalLaneId==null && other.getTerminalLaneId()==null) || 
             (this.terminalLaneId!=null &&
              this.terminalLaneId.equals(other.getTerminalLaneId()))) &&
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
              this.deviceSecuritySupport.equals(other.getDeviceSecuritySupport()))) &&
            ((this.dwWalletID==null && other.getDwWalletID()==null) || 
             (this.dwWalletID!=null &&
              this.dwWalletID.equals(other.getDwWalletID()))) &&
            ((this.dwSLI==null && other.getDwSLI()==null) || 
             (this.dwSLI!=null &&
              this.dwSLI.equals(other.getDwSLI()))) &&
            ((this.dwIncentiveInd==null && other.getDwIncentiveInd()==null) || 
             (this.dwIncentiveInd!=null &&
              this.dwIncentiveInd.equals(other.getDwIncentiveInd()))) &&
            ((this.digitalWalletType==null && other.getDigitalWalletType()==null) || 
             (this.digitalWalletType!=null &&
              this.digitalWalletType.equals(other.getDigitalWalletType())));
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
        if (getIndustryType() != null) {
            _hashCode += getIndustryType().hashCode();
        }
        if (getTransType() != null) {
            _hashCode += getTransType().hashCode();
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
        if (getCardBrand() != null) {
            _hashCode += getCardBrand().hashCode();
        }
        if (getCcAccountNum() != null) {
            _hashCode += getCcAccountNum().hashCode();
        }
        if (getEncryptedPan() != null) {
            _hashCode += getEncryptedPan().hashCode();
        }
        if (getEncryptedPanMethod() != null) {
            _hashCode += getEncryptedPanMethod().hashCode();
        }
        if (getEncryptedPanKey() != null) {
            _hashCode += getEncryptedPanKey().hashCode();
        }
        if (getEncryptedPanPublicKeyFingerPrint() != null) {
            _hashCode += getEncryptedPanPublicKeyFingerPrint().hashCode();
        }
        if (getEncryptedPanHash() != null) {
            _hashCode += getEncryptedPanHash().hashCode();
        }
        if (getCcExp() != null) {
            _hashCode += getCcExp().hashCode();
        }
        if (getCcCardVerifyPresenceInd() != null) {
            _hashCode += getCcCardVerifyPresenceInd().hashCode();
        }
        if (getCcCardVerifyNum() != null) {
            _hashCode += getCcCardVerifyNum().hashCode();
        }
        if (getSwitchSoloIssueNum() != null) {
            _hashCode += getSwitchSoloIssueNum().hashCode();
        }
        if (getSwitchSoloCardStartDate() != null) {
            _hashCode += getSwitchSoloCardStartDate().hashCode();
        }
        if (getEcpCheckRT() != null) {
            _hashCode += getEcpCheckRT().hashCode();
        }
        if (getEcpCheckDDA() != null) {
            _hashCode += getEcpCheckDDA().hashCode();
        }
        if (getEcpBankAcctType() != null) {
            _hashCode += getEcpBankAcctType().hashCode();
        }
        if (getEcpAuthMethod() != null) {
            _hashCode += getEcpAuthMethod().hashCode();
        }
        if (getEcpDelvMethod() != null) {
            _hashCode += getEcpDelvMethod().hashCode();
        }
        if (getAvsZip() != null) {
            _hashCode += getAvsZip().hashCode();
        }
        if (getAvsAddress1() != null) {
            _hashCode += getAvsAddress1().hashCode();
        }
        if (getAvsAddress2() != null) {
            _hashCode += getAvsAddress2().hashCode();
        }
        if (getAvsCity() != null) {
            _hashCode += getAvsCity().hashCode();
        }
        if (getAvsState() != null) {
            _hashCode += getAvsState().hashCode();
        }
        if (getAvsName() != null) {
            _hashCode += getAvsName().hashCode();
        }
        if (getAvsCountryCode() != null) {
            _hashCode += getAvsCountryCode().hashCode();
        }
        if (getAvsPhone() != null) {
            _hashCode += getAvsPhone().hashCode();
        }
        if (getUseCustomerRefNum() != null) {
            _hashCode += getUseCustomerRefNum().hashCode();
        }
        if (getAddProfileFromOrder() != null) {
            _hashCode += getAddProfileFromOrder().hashCode();
        }
        if (getCustomerRefNum() != null) {
            _hashCode += getCustomerRefNum().hashCode();
        }
        if (getProfileOrderOverideInd() != null) {
            _hashCode += getProfileOrderOverideInd().hashCode();
        }
        if (getAuthenticationECIInd() != null) {
            _hashCode += getAuthenticationECIInd().hashCode();
        }
        if (getVerifyByVisaCAVV() != null) {
            _hashCode += getVerifyByVisaCAVV().hashCode();
        }
        if (getVerifyByVisaXID() != null) {
            _hashCode += getVerifyByVisaXID().hashCode();
        }
        if (getPriorAuthCd() != null) {
            _hashCode += getPriorAuthCd().hashCode();
        }
        if (getOrderID() != null) {
            _hashCode += getOrderID().hashCode();
        }
        if (getAmount() != null) {
            _hashCode += getAmount().hashCode();
        }
        if (getComments() != null) {
            _hashCode += getComments().hashCode();
        }
        if (getShippingRef() != null) {
            _hashCode += getShippingRef().hashCode();
        }
        if (getTaxInd() != null) {
            _hashCode += getTaxInd().hashCode();
        }
        if (getTaxAmount() != null) {
            _hashCode += getTaxAmount().hashCode();
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
        if (getMcSecureCodeAAV() != null) {
            _hashCode += getMcSecureCodeAAV().hashCode();
        }
        if (getSoftDescMercName() != null) {
            _hashCode += getSoftDescMercName().hashCode();
        }
        if (getSoftDescProdDesc() != null) {
            _hashCode += getSoftDescProdDesc().hashCode();
        }
        if (getSoftDescMercCity() != null) {
            _hashCode += getSoftDescMercCity().hashCode();
        }
        if (getSoftDescMercPhone() != null) {
            _hashCode += getSoftDescMercPhone().hashCode();
        }
        if (getSoftDescMercURL() != null) {
            _hashCode += getSoftDescMercURL().hashCode();
        }
        if (getSoftDescMercEmail() != null) {
            _hashCode += getSoftDescMercEmail().hashCode();
        }
        if (getRecurringInd() != null) {
            _hashCode += getRecurringInd().hashCode();
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
        if (getMagStripeTrack1() != null) {
            _hashCode += getMagStripeTrack1().hashCode();
        }
        if (getMagStripeTrack2() != null) {
            _hashCode += getMagStripeTrack2().hashCode();
        }
        if (getRetailTransInfo() != null) {
            _hashCode += getRetailTransInfo().hashCode();
        }
        if (getCustomerName() != null) {
            _hashCode += getCustomerName().hashCode();
        }
        if (getCustomerEmail() != null) {
            _hashCode += getCustomerEmail().hashCode();
        }
        if (getCustomerPhone() != null) {
            _hashCode += getCustomerPhone().hashCode();
        }
        if (getCardPresentInd() != null) {
            _hashCode += getCardPresentInd().hashCode();
        }
        if (getEuddBankSortCode() != null) {
            _hashCode += getEuddBankSortCode().hashCode();
        }
        if (getEuddCountryCode() != null) {
            _hashCode += getEuddCountryCode().hashCode();
        }
        if (getEuddRibCode() != null) {
            _hashCode += getEuddRibCode().hashCode();
        }
        if (getEuddBankBranchCode() != null) {
            _hashCode += getEuddBankBranchCode().hashCode();
        }
        if (getEuddIBAN() != null) {
            _hashCode += getEuddIBAN().hashCode();
        }
        if (getEuddBIC() != null) {
            _hashCode += getEuddBIC().hashCode();
        }
        if (getEuddMandateSignatureDate() != null) {
            _hashCode += getEuddMandateSignatureDate().hashCode();
        }
        if (getEuddMandateID() != null) {
            _hashCode += getEuddMandateID().hashCode();
        }
        if (getEuddMandateType() != null) {
            _hashCode += getEuddMandateType().hashCode();
        }
        if (getPaymentInd() != null) {
            _hashCode += getPaymentInd().hashCode();
        }
        if (getBmlCustomerIP() != null) {
            _hashCode += getBmlCustomerIP().hashCode();
        }
        if (getBmlCustomerEmail() != null) {
            _hashCode += getBmlCustomerEmail().hashCode();
        }
        if (getBmlShippingCost() != null) {
            _hashCode += getBmlShippingCost().hashCode();
        }
        if (getBmlTNCVersion() != null) {
            _hashCode += getBmlTNCVersion().hashCode();
        }
        if (getBmlCustomerRegistrationDate() != null) {
            _hashCode += getBmlCustomerRegistrationDate().hashCode();
        }
        if (getBmlCustomerTypeFlag() != null) {
            _hashCode += getBmlCustomerTypeFlag().hashCode();
        }
        if (getBmlItemCategory() != null) {
            _hashCode += getBmlItemCategory().hashCode();
        }
        if (getBmlPreapprovalInvitationNum() != null) {
            _hashCode += getBmlPreapprovalInvitationNum().hashCode();
        }
        if (getBmlMerchantPromotionalCode() != null) {
            _hashCode += getBmlMerchantPromotionalCode().hashCode();
        }
        if (getBmlCustomerBirthDate() != null) {
            _hashCode += getBmlCustomerBirthDate().hashCode();
        }
        if (getBmlCustomerSSN() != null) {
            _hashCode += getBmlCustomerSSN().hashCode();
        }
        if (getBmlCustomerAnnualIncome() != null) {
            _hashCode += getBmlCustomerAnnualIncome().hashCode();
        }
        if (getBmlCustomerResidenceStatus() != null) {
            _hashCode += getBmlCustomerResidenceStatus().hashCode();
        }
        if (getBmlCustomerCheckingAccount() != null) {
            _hashCode += getBmlCustomerCheckingAccount().hashCode();
        }
        if (getBmlCustomerSavingsAccount() != null) {
            _hashCode += getBmlCustomerSavingsAccount().hashCode();
        }
        if (getBmlProductDeliveryType() != null) {
            _hashCode += getBmlProductDeliveryType().hashCode();
        }
        if (getAvsDestName() != null) {
            _hashCode += getAvsDestName().hashCode();
        }
        if (getAvsDestAddress1() != null) {
            _hashCode += getAvsDestAddress1().hashCode();
        }
        if (getAvsDestAddress2() != null) {
            _hashCode += getAvsDestAddress2().hashCode();
        }
        if (getAvsDestCity() != null) {
            _hashCode += getAvsDestCity().hashCode();
        }
        if (getAvsDestState() != null) {
            _hashCode += getAvsDestState().hashCode();
        }
        if (getAvsDestZip() != null) {
            _hashCode += getAvsDestZip().hashCode();
        }
        if (getAvsDestCountryCode() != null) {
            _hashCode += getAvsDestCountryCode().hashCode();
        }
        if (getAvsDestPhoneNum() != null) {
            _hashCode += getAvsDestPhoneNum().hashCode();
        }
        if (getDebitBillerReferenceNumber() != null) {
            _hashCode += getDebitBillerReferenceNumber().hashCode();
        }
        if (getMbType() != null) {
            _hashCode += getMbType().hashCode();
        }
        if (getMbOrderIdGenerationMethod() != null) {
            _hashCode += getMbOrderIdGenerationMethod().hashCode();
        }
        if (getMbRecurringStartDate() != null) {
            _hashCode += getMbRecurringStartDate().hashCode();
        }
        if (getMbRecurringEndDate() != null) {
            _hashCode += getMbRecurringEndDate().hashCode();
        }
        if (getMbRecurringNoEndDateFlag() != null) {
            _hashCode += getMbRecurringNoEndDateFlag().hashCode();
        }
        if (getMbRecurringMaxBillings() != null) {
            _hashCode += getMbRecurringMaxBillings().hashCode();
        }
        if (getMbRecurringFrequency() != null) {
            _hashCode += getMbRecurringFrequency().hashCode();
        }
        if (getMbMicroPaymentMaxDollarValue() != null) {
            _hashCode += getMbMicroPaymentMaxDollarValue().hashCode();
        }
        if (getMbMicroPaymentMaxBillingDays() != null) {
            _hashCode += getMbMicroPaymentMaxBillingDays().hashCode();
        }
        if (getMbMicroPaymentMaxTransactions() != null) {
            _hashCode += getMbMicroPaymentMaxTransactions().hashCode();
        }
        if (getMbDeferredBillDate() != null) {
            _hashCode += getMbDeferredBillDate().hashCode();
        }
        if (getDebitPinNumber() != null) {
            _hashCode += getDebitPinNumber().hashCode();
        }
        if (getDebitPinSecurityControl() != null) {
            _hashCode += getDebitPinSecurityControl().hashCode();
        }
        if (getDebitPinCashBack() != null) {
            _hashCode += getDebitPinCashBack().hashCode();
        }
        if (getPartialAuthInd() != null) {
            _hashCode += getPartialAuthInd().hashCode();
        }
        if (getAccountUpdaterEligibility() != null) {
            _hashCode += getAccountUpdaterEligibility().hashCode();
        }
        if (getUseStoredAAVInd() != null) {
            _hashCode += getUseStoredAAVInd().hashCode();
        }
        if (getEcpActionCode() != null) {
            _hashCode += getEcpActionCode().hashCode();
        }
        if (getEcpCheckSerialNumber() != null) {
            _hashCode += getEcpCheckSerialNumber().hashCode();
        }
        if (getEcpTerminalCity() != null) {
            _hashCode += getEcpTerminalCity().hashCode();
        }
        if (getEcpTerminalState() != null) {
            _hashCode += getEcpTerminalState().hashCode();
        }
        if (getEcpImageReferenceNumber() != null) {
            _hashCode += getEcpImageReferenceNumber().hashCode();
        }
        if (getCustomerAni() != null) {
            _hashCode += getCustomerAni().hashCode();
        }
        if (getAvsPhoneType() != null) {
            _hashCode += getAvsPhoneType().hashCode();
        }
        if (getAvsDestPhoneType() != null) {
            _hashCode += getAvsDestPhoneType().hashCode();
        }
        if (getCustomerIpAddress() != null) {
            _hashCode += getCustomerIpAddress().hashCode();
        }
        if (getEmailAddressSubtype() != null) {
            _hashCode += getEmailAddressSubtype().hashCode();
        }
        if (getCustomerBrowserName() != null) {
            _hashCode += getCustomerBrowserName().hashCode();
        }
        if (getShippingMethod() != null) {
            _hashCode += getShippingMethod().hashCode();
        }
        if (getFraudAnalysis() != null) {
            _hashCode += getFraudAnalysis().hashCode();
        }
        if (getSoftMerchantDescriptors() != null) {
            _hashCode += getSoftMerchantDescriptors().hashCode();
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
        if (getKeySerialNumber() != null) {
            _hashCode += getKeySerialNumber().hashCode();
        }
        if (getEncryptedMagStripeTrack2() != null) {
            _hashCode += getEncryptedMagStripeTrack2().hashCode();
        }
        if (getEncryptionInd() != null) {
            _hashCode += getEncryptionInd().hashCode();
        }
        if (getCardIndicators() != null) {
            _hashCode += getCardIndicators().hashCode();
        }
        if (getTipAmt() != null) {
            _hashCode += getTipAmt().hashCode();
        }
        if (getDiscountAmt() != null) {
            _hashCode += getDiscountAmt().hashCode();
        }
        if (getTxnSurchargeAmt() != null) {
            _hashCode += getTxnSurchargeAmt().hashCode();
        }
        if (getPaymentActionInd() != null) {
            _hashCode += getPaymentActionInd().hashCode();
        }
        if (getDpanInd() != null) {
            _hashCode += getDpanInd().hashCode();
        }
        if (getAxAEVV() != null) {
            _hashCode += getAxAEVV().hashCode();
        }
        if (getPosEntryMode() != null) {
            _hashCode += getPosEntryMode().hashCode();
        }
        if (getDataEntrySource() != null) {
            _hashCode += getDataEntrySource().hashCode();
        }
        if (getPanSequenceNumber() != null) {
            _hashCode += getPanSequenceNumber().hashCode();
        }
        if (getApplicationId() != null) {
            _hashCode += getApplicationId().hashCode();
        }
        if (getApplicationLabel() != null) {
            _hashCode += getApplicationLabel().hashCode();
        }
        if (getChipCardData() != null) {
            _hashCode += getChipCardData().hashCode();
        }
        if (getPin() != null) {
            _hashCode += getPin().hashCode();
        }
        if (getPinKeySerialNumber() != null) {
            _hashCode += getPinKeySerialNumber().hashCode();
        }
        if (getTvr() != null) {
            _hashCode += getTvr().hashCode();
        }
        if (getTsi() != null) {
            _hashCode += getTsi().hashCode();
        }
        if (getAttendedTerminal() != null) {
            _hashCode += getAttendedTerminal().hashCode();
        }
        if (getTerminalLocation() != null) {
            _hashCode += getTerminalLocation().hashCode();
        }
        if (getCardholderPresent() != null) {
            _hashCode += getCardholderPresent().hashCode();
        }
        if (getCardholderActivatedTerminal() != null) {
            _hashCode += getCardholderActivatedTerminal().hashCode();
        }
        if (getTerminalEntry() != null) {
            _hashCode += getTerminalEntry().hashCode();
        }
        if (getTerminalLaneId() != null) {
            _hashCode += getTerminalLaneId().hashCode();
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
        if (getDwWalletID() != null) {
            _hashCode += getDwWalletID().hashCode();
        }
        if (getDwSLI() != null) {
            _hashCode += getDwSLI().hashCode();
        }
        if (getDwIncentiveInd() != null) {
            _hashCode += getDwIncentiveInd().hashCode();
        }
        if (getDigitalWalletType() != null) {
            _hashCode += getDigitalWalletType().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(NewOrderRequestElement.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "NewOrderRequestElement"));
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
        elemField.setFieldName("industryType");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "industryType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("transType");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "transType"));
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
        elemField.setFieldName("cardBrand");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "cardBrand"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ccAccountNum");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "ccAccountNum"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("encryptedPan");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "encryptedPan"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("encryptedPanMethod");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "encryptedPanMethod"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("encryptedPanKey");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "encryptedPanKey"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("encryptedPanPublicKeyFingerPrint");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "encryptedPanPublicKeyFingerPrint"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("encryptedPanHash");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "encryptedPanHash"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ccExp");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "ccExp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ccCardVerifyPresenceInd");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "ccCardVerifyPresenceInd"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ccCardVerifyNum");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "ccCardVerifyNum"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("switchSoloIssueNum");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "switchSoloIssueNum"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("switchSoloCardStartDate");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "switchSoloCardStartDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ecpCheckRT");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "ecpCheckRT"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ecpCheckDDA");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "ecpCheckDDA"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ecpBankAcctType");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "ecpBankAcctType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ecpAuthMethod");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "ecpAuthMethod"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ecpDelvMethod");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "ecpDelvMethod"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("avsZip");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "avsZip"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("avsAddress1");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "avsAddress1"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("avsAddress2");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "avsAddress2"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("avsCity");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "avsCity"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("avsState");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "avsState"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("avsName");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "avsName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("avsCountryCode");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "avsCountryCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("avsPhone");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "avsPhone"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("useCustomerRefNum");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "useCustomerRefNum"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("addProfileFromOrder");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "addProfileFromOrder"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("customerRefNum");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "customerRefNum"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("profileOrderOverideInd");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "profileOrderOverideInd"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("authenticationECIInd");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "authenticationECIInd"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("verifyByVisaCAVV");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "verifyByVisaCAVV"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("verifyByVisaXID");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "verifyByVisaXID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("priorAuthCd");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "priorAuthCd"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("orderID");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "orderID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("amount");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "amount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("comments");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "comments"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("shippingRef");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "shippingRef"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
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
        elemField.setFieldName("mcSecureCodeAAV");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "mcSecureCodeAAV"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("softDescMercName");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "softDescMercName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("softDescProdDesc");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "softDescProdDesc"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("softDescMercCity");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "softDescMercCity"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("softDescMercPhone");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "softDescMercPhone"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("softDescMercURL");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "softDescMercURL"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("softDescMercEmail");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "softDescMercEmail"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("recurringInd");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "recurringInd"));
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
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("magStripeTrack1");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "magStripeTrack1"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("magStripeTrack2");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "magStripeTrack2"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("retailTransInfo");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "retailTransInfo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("customerName");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "customerName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("customerEmail");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "customerEmail"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("customerPhone");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "customerPhone"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cardPresentInd");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "cardPresentInd"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("euddBankSortCode");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "euddBankSortCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("euddCountryCode");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "euddCountryCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("euddRibCode");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "euddRibCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("euddBankBranchCode");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "euddBankBranchCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("euddIBAN");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "euddIBAN"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("euddBIC");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "euddBIC"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("euddMandateSignatureDate");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "euddMandateSignatureDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("euddMandateID");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "euddMandateID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("euddMandateType");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "euddMandateType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("paymentInd");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "paymentInd"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bmlCustomerIP");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "bmlCustomerIP"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bmlCustomerEmail");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "bmlCustomerEmail"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bmlShippingCost");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "bmlShippingCost"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bmlTNCVersion");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "bmlTNCVersion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bmlCustomerRegistrationDate");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "bmlCustomerRegistrationDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bmlCustomerTypeFlag");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "bmlCustomerTypeFlag"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bmlItemCategory");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "bmlItemCategory"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bmlPreapprovalInvitationNum");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "bmlPreapprovalInvitationNum"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bmlMerchantPromotionalCode");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "bmlMerchantPromotionalCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bmlCustomerBirthDate");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "bmlCustomerBirthDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bmlCustomerSSN");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "bmlCustomerSSN"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bmlCustomerAnnualIncome");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "bmlCustomerAnnualIncome"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bmlCustomerResidenceStatus");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "bmlCustomerResidenceStatus"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bmlCustomerCheckingAccount");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "bmlCustomerCheckingAccount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bmlCustomerSavingsAccount");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "bmlCustomerSavingsAccount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bmlProductDeliveryType");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "bmlProductDeliveryType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("avsDestName");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "avsDestName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("avsDestAddress1");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "avsDestAddress1"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("avsDestAddress2");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "avsDestAddress2"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("avsDestCity");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "avsDestCity"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("avsDestState");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "avsDestState"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("avsDestZip");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "avsDestZip"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("avsDestCountryCode");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "avsDestCountryCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("avsDestPhoneNum");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "avsDestPhoneNum"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("debitBillerReferenceNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "debitBillerReferenceNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mbType");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "mbType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mbOrderIdGenerationMethod");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "mbOrderIdGenerationMethod"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mbRecurringStartDate");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "mbRecurringStartDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mbRecurringEndDate");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "mbRecurringEndDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mbRecurringNoEndDateFlag");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "mbRecurringNoEndDateFlag"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mbRecurringMaxBillings");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "mbRecurringMaxBillings"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mbRecurringFrequency");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "mbRecurringFrequency"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mbMicroPaymentMaxDollarValue");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "mbMicroPaymentMaxDollarValue"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mbMicroPaymentMaxBillingDays");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "mbMicroPaymentMaxBillingDays"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mbMicroPaymentMaxTransactions");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "mbMicroPaymentMaxTransactions"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mbDeferredBillDate");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "mbDeferredBillDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("debitPinNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "debitPinNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("debitPinSecurityControl");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "debitPinSecurityControl"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("debitPinCashBack");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "debitPinCashBack"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("partialAuthInd");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "partialAuthInd"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("accountUpdaterEligibility");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "accountUpdaterEligibility"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("useStoredAAVInd");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "useStoredAAVInd"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ecpActionCode");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "ecpActionCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ecpCheckSerialNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "ecpCheckSerialNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ecpTerminalCity");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "ecpTerminalCity"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ecpTerminalState");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "ecpTerminalState"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ecpImageReferenceNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "ecpImageReferenceNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("customerAni");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "customerAni"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("avsPhoneType");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "avsPhoneType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("avsDestPhoneType");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "avsDestPhoneType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("customerIpAddress");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "customerIpAddress"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("emailAddressSubtype");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "emailAddressSubtype"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("customerBrowserName");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "customerBrowserName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("shippingMethod");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "shippingMethod"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fraudAnalysis");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "fraudAnalysis"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "FraudAnalysisType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("softMerchantDescriptors");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "softMerchantDescriptors"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "SoftMerchantDescriptorsType"));
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
        elemField.setFieldName("keySerialNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "keySerialNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("encryptedMagStripeTrack2");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "encryptedMagStripeTrack2"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("encryptionInd");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "encryptionInd"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cardIndicators");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "cardIndicators"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipAmt");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "tipAmt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("discountAmt");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "discountAmt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("txnSurchargeAmt");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "txnSurchargeAmt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("paymentActionInd");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "paymentActionInd"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dpanInd");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "dpanInd"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("axAEVV");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "axAEVV"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("posEntryMode");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "posEntryMode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dataEntrySource");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "dataEntrySource"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("panSequenceNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "panSequenceNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("applicationId");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "applicationId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("applicationLabel");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "applicationLabel"));
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
        elemField.setFieldName("pin");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "pin"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pinKeySerialNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "pinKeySerialNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tvr");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "tvr"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tsi");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "tsi"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("attendedTerminal");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "attendedTerminal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("terminalLocation");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "terminalLocation"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cardholderPresent");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "cardholderPresent"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cardholderActivatedTerminal");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "cardholderActivatedTerminal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("terminalEntry");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "terminalEntry"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("terminalLaneId");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "terminalLaneId"));
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
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwWalletID");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "dwWalletID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwSLI");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "dwSLI"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwIncentiveInd");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "dwIncentiveInd"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("digitalWalletType");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:ws.paymentech.net/PaymentechGateway", "digitalWalletType"));
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
