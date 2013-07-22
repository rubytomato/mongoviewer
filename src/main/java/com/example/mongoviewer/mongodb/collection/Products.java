package com.example.mongoviewer.mongodb.collection;

import java.io.Serializable;
import java.math.BigDecimal;


import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.example.mongoviewer.mongodb.constants.CollectionNames;

@Document(collection = CollectionNames.Products)
public class Products implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6168513469129446234L;

	@Id
	private String id;

	@Indexed(name = "pk_products", direction = IndexDirection.ASCENDING, unique = true)
	private String productCode;

	private String productName;

	private String productLine;

	private String productScale;

	private String productVendor;

	private String productDescription;

	private Integer quantityInStock;

	private BigDecimal buyPrice;

	private BigDecimal MSRP;

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
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}
	/**
	 * @param productName the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}
	/**
	 * @return the productLine
	 */
	public String getProductLine() {
		return productLine;
	}
	/**
	 * @param productLine the productLine to set
	 */
	public void setProductLine(String productLine) {
		this.productLine = productLine;
	}
	/**
	 * @return the productScale
	 */
	public String getProductScale() {
		return productScale;
	}
	/**
	 * @param productScale the productScale to set
	 */
	public void setProductScale(String productScale) {
		this.productScale = productScale;
	}
	/**
	 * @return the productVendor
	 */
	public String getProductVendor() {
		return productVendor;
	}
	/**
	 * @param productVendor the productVendor to set
	 */
	public void setProductVendor(String productVendor) {
		this.productVendor = productVendor;
	}
	/**
	 * @return the productDescription
	 */
	public String getProductDescription() {
		return productDescription;
	}
	/**
	 * @param productDescription the productDescription to set
	 */
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	/**
	 * @return the quantityInStock
	 */
	public Integer getQuantityInStock() {
		return quantityInStock;
	}
	/**
	 * @param quantityInStock the quantityInStock to set
	 */
	public void setQuantityInStock(Integer quantityInStock) {
		this.quantityInStock = quantityInStock;
	}
	/**
	 * @return the buyPrice
	 */
	public BigDecimal getBuyPrice() {
		return buyPrice;
	}
	/**
	 * @param buyPrice the buyPrice to set
	 */
	public void setBuyPrice(BigDecimal buyPrice) {
		this.buyPrice = buyPrice;
	}
	/**
	 * @return the mSRP
	 */
	public BigDecimal getMSRP() {
		return MSRP;
	}
	/**
	 * @param mSRP the mSRP to set
	 */
	public void setMSRP(BigDecimal mSRP) {
		MSRP = mSRP;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this, ToStringStyle.DEFAULT_STYLE);
	}

}
