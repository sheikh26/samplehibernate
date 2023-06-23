package com.nenosystems.dto.inh;

public class PaymentDTO {

	protected int id = 0;
	protected double amount = 0;
	protected String paymentType = null;
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @paparam id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the amount
	 */
	public double getAmount() {
		return amount;
	}
	/**
	 * @paparam amount the amount to set
	 */
	public void setAmount(double amount) {
		this.amount = amount;
	}
	/**
	 * @return the paymentType
	 */
	public String getPaymentType() {
		return paymentType;
	}
	/**
	 * @paparam paymentType the paymentType to set
	 */
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

}
