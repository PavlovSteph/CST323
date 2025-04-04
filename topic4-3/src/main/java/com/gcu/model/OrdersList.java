package com.gcu.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="ORDERS")
public class OrdersList {
	
	private List<OrderModel> orders = new ArrayList<OrderModel>();

	/**
     * Gets the list of orders.
     * 
     * @return The list of orders.
     */
    @XmlElement(name="order")
    public List<OrderModel> getOrders() {
        return this.orders;
    }
    
    /**
     * Sets the list of orders.
     * 
     * @param orders The list of orders to set.
     */
    public void setOrders(List<OrderModel> orders) {
        this.orders = orders;
    }
}
