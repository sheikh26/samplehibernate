package com.nenosystems.dto.inh;

public class CreditCardPaymentDTO extends PaymentDTO {
	private String ccType = null;

	/**
	 * @return the ccType
	 */
	public String getCcType() {
		return ccType;
	}

	/**
	 * @paparam ccType
	 *            the ccType to set
	 */
	public void setCcType(String ccType) {
		this.ccType = ccType;
	}

}
