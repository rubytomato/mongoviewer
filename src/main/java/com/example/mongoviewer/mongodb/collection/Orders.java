package com.example.mongoviewer.mongodb.collection;

import java.io.Serializable;
import java.util.Date;


import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.example.mongoviewer.mongodb.constants.CollectionNames;

@Document(collection = CollectionNames.Orders)
public class Orders implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4570305313987207739L;

	@Id
	private String id;

	@Indexed(name = "pk_orders", direction = IndexDirection.DESCENDING, unique = true)
	private Long orderNumber;

	private Date orderDate;

	private Date requiredDate;

	private Date shippedDate;

	private String status;

	private String comments;

	@Indexed(name = "idx1_orders", direction = IndexDirection.ASCENDING)
	private Long customerNumber;

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
	 * @return the orderNumber
	 */
	public Long getOrderNumber() {
		return orderNumber;
	}
	/**
	 * @param orderNumber the orderNumber to set
	 */
	public void setOrderNumber(Long orderNumber) {
		this.orderNumber = orderNumber;
	}
	/**
	 * @return the orderDate
	 */
	public Date getOrderDate() {
		return orderDate;
	}
	/**
	 * @param orderDate the orderDate to set
	 */
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	/**
	 * @return the requiredDate
	 */
	public Date getRequiredDate() {
		return requiredDate;
	}
	/**
	 * @param requiredDate the requiredDate to set
	 */
	public void setRequiredDate(Date requiredDate) {
		this.requiredDate = requiredDate;
	}
	/**
	 * @return the shippedDate
	 */
	public Date getShippedDate() {
		return shippedDate;
	}
	/**
	 * @param shippedDate the shippedDate to set
	 */
	public void setShippedDate(Date shippedDate) {
		this.shippedDate = shippedDate;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * @return the comments
	 */
	public String getComments() {
		return comments;
	}
	/**
	 * @param comments the comments to set
	 */
	public void setComments(String comments) {
		this.comments = comments;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}

}
