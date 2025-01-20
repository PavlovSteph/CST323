package com.gcu.data.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("ORDERS")
public class OrderEntity 
{
	@Id
	Long id;

	@Column("ORDER_NO")
	String orderNo;
	
	@Column("PRODUCT_NAME")
	String productName;
	
	@Column("PRICE")
	float price;
	
	@Column("QUANTITY")
	int quantity;
	
	/**
	 * Default Constructor
	 */
	public OrderEntity() {
		
    }
	
	/**
	 * Non-default Constructor
	 * @param id Specified id
	 * @param orderNo Specified orderNo
	 * @param productName Specified productName
	 * @param price Specified price
	 * @param quantity Specified quantity
	 */
	public OrderEntity(Long id, String orderNo, String productName, float price, int quantity) {
		this.id = id;
		this.orderNo = orderNo;
		this.productName = productName;
		this.price = price;
		this.quantity = quantity;
	}
	
	/**
	 * Getter for id 
	 * @return id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Setter for id
	 * @param id
	 */
	public void setId(Long id) {
		this.id = id;
	}
	
	/**
	 * Getter for orderNo
	 * @return orderNo
	 */
	public String getOrderNo() {
		return orderNo;
	}

	/**
	 * Setter for orderNo
	 * @param orderNo
	 */
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	/**
	 * Getter for productName
	 * @return productName
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * Setter for productName
	 * @param productName
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}

	/**
	 * Getter for price
	 * @return price
	 */
	public float getPrice() {
		return price;
	}

	/**
	 * Setter for price
	 * @param price
	 */
	public void setPrice(float price) {
		this.price = price;
	}

	/**
	 * Getter for quantity
	 * @return quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * Setter for quantity
	 * @param quantity
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}

