package com.gcu.model;

public class OrderModel {
	
	//Declare and Initialize
	private long id;
	private String orderNo;
	private String productName;
	private float price;
	private int quantity;
	
	/**
	 *  Non-default constructor
	 * @param id Specified id
	 * @param orderNo Specified orderNo
	 * @param productName Specified productName
	 * @param price Specified price
	 * @param quantity quantity
	 */
    public OrderModel(long id, String orderNo, String productName, float price, int quantity) {
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
	public long getId() {
		return id;
	}
	
	/**
	 * Setter for id
	 * @param id
	 */
	public void setId(long id) {
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
	 * Setter for setOrderNo
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
	 * @return
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
