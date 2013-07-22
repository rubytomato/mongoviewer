package com.example.mongoviewer.mongodb.collection;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.mapping.Document;

import com.example.mongoviewer.mongodb.constants.CollectionNames;

@Document(collection = CollectionNames.Payments)
@CompoundIndexes({
	@CompoundIndex(name = "pk_payments", def = "{'customerNumber' : 1, 'checkNumber' : 1}", collection = CollectionNames.Payments, unique = true)
})
public class Payments implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1575843674663916378L;

	@Id
	private String id;

	private Long customerNumber;

	private String checkNumber;

	private Date paymentDate;

	private BigDecimal amount;

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the customerNumber
	 */
	public Long getCustomerNumber() {
		return customerNumber;
	}
	/**
	 * @param customerNumber the customerNumber to set
	 */
	public void setCustomerNumber(Long customerNumber) {
		this.customerNumber = customerNumber;
	}
	/**
	 * @return the checkNumber
	 */
	public String getCheckNumber() {
		return checkNumber;
	}
	/**
	 * @param checkNumber the checkNumber to set
	 */
	public void setCheckNumber(String checkNumber) {
		this.checkNumber = checkNumber;
	}
	/**
	 * @return the paymentDate
	 */
	public Date getPaymentDate() {
		return paymentDate;
	}
	/**
	 * @param paymentDate the paymentDate to set
	 */
	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}
	/**
	 * @return the amount
	 */
	public BigDecimal getAmount() {
		return amount;
	}
	/**
	 * @param amount the amount to set
	 */
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this, ToStringStyle.DEFAULT_STYLE);
	}

}
