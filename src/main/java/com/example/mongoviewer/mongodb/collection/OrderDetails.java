package com.example.mongoviewer.mongodb.collection;

import java.io.Serializable;
import java.math.BigInteger;


import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.example.mongoviewer.mongodb.constants.CollectionNames;

@Document(collection = CollectionNames.OrderDetails)
@CompoundIndexes({
	@CompoundIndex(name = "pk_order_details", def = "{'orderNumber' : 1, 'productCode' : 1}", collection = CollectionNames.OrderDetails, unique = true)
})
public class OrderDetails implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3528581580396146917L;

	@Id
	private String id;

	private Long orderNumber;

	private String productCode;

	private Long quantityOrdered;

	private BigInteger priceEach;

	@Indexed(name = "idx1_order_details", direction = IndexDirection.ASCENDING)
	private Integer orderLineNumber;

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
	 * @return the productCode
	 */
	public String getProductCode() {
		return productCode;
	}
	/**
	 * @param productCode the productCode to set
	 */
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	/**
	 * @return the quantityOrdered
	 */
	public Long getQuantityOrdered() {
		return quantityOrdered;
	}
	/**
	 * @param quantityOrdered the quantityOrdered to set
	 */
	public void setQuantityOrdered(Long quantityOrdered) {
		this.quantityOrdered = quantityOrdered;
	}
	/**
	 * @return the priceEach
	 */
	public BigInteger getPriceEach() {
		return priceEach;
	}
	/**
	 * @param priceEach the priceEach to set
	 */
	public void setPriceEach(BigInteger priceEach) {
		this.priceEach = priceEach;
	}
	/**
	 * @return the orderLineNumber
	 */
	public Integer getOrderLineNumber() {
		return orderLineNumber;
	}
	/**
	 * @param orderLineNumber the orderLineNumber to set
	 */
	public void setOrderLineNumber(Integer orderLineNumber) {
		this.orderLineNumber = orderLineNumber;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);
	}

}
