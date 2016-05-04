package com.shubilee.common;

import java.util.regex.Pattern;

public enum CardType {

    UNKNOWN,
    VISA("^4[0-9]{12}(?:[0-9]{3})?$"),
    MASTERCARD("^5[1-5][0-9]{14}$"),
    AMERICAN_EXPRESS("^3[47][0-9]{13}$"),
    DINERS_CLUB("^3(?:0[0-5]|[68][0-9])[0-9]{11}$"),
    DISCOVER("^6(?:011|5[0-9]{2})[0-9]{12}$"),
    JCB("^(?:2131|1800|35\\d{3})\\d{11}$");

    private Pattern pattern;

    CardType() {
        this.pattern = null;
    }

    CardType(String pattern) {
        this.pattern = Pattern.compile(pattern);
    }

    public static CardType detect(String cardNumber) {

        for (CardType cardType : CardType.values()) {
            if (null == cardType.pattern) continue;
            if (cardType.pattern.matcher(cardNumber).matches()) return cardType;
        }

        return UNKNOWN;
    }

	public String toString() {
		switch (this) {
		case VISA:
			return YamiConstant.OGWS_CARD_TYPE_VISA;
		case MASTERCARD:
			return YamiConstant.OGWS_CARD_TYPE_MSTE;
		case AMERICAN_EXPRESS:
			return YamiConstant.OGWS_CARD_TYPE_AMEX;
		case DINERS_CLUB:
			return YamiConstant.OGWS_CARD_TYPE_DINE;
		case DISCOVER:
			return YamiConstant.OGWS_CARD_TYPE_DISC;
		case JCB:
			return YamiConstant.OGWS_CARD_TYPE_JCB;
		default:
			return YamiConstant.OGWS_CARD_TYPE_UNKN;
		}
	}
}