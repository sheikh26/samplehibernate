package com.webdev.dto.inh;

public class ChequePaymentDTO extends PaymentDTO {
	
	private String chequeNumber = null;
	private String bankName = null;

	/**
	 * @return the chequeNumber
	 */
	public String getChequeNumber() {
		return chequeNumber;
	}

	/**
	 * @paparam chequeNumber
	 *            the chequeNumber to set
	 */
	public void setChequeNumber(String chequeNumber) {
		this.chequeNumber = chequeNumber;
	}

	/**
	 * @return the bankName
	 */
	public String getBankName() {
		return bankName;
	}

	/**
	 * @paparam bankName
	 *            the bankName to set
	 */
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

}
