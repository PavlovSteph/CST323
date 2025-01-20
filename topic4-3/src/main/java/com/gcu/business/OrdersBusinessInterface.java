package com.gcu.business;

import java.util.List;

import com.gcu.model.OrderModel;

public interface OrdersBusinessInterface {
	
	/**
     * A test method for demonstration purposes.
     */
    public void test();
    
    /**
     * Retrieves a list of orders.
     * 
     * @return A list of {@link OrderModel} objects representing orders.
     */
    public List<OrderModel> getOrders();
    
    /**
     * Initialization method.
     * This method is invoked by the container after instantiation but before dependency injection.
     */
    public void init();
    
    /**
     * Destruction method.
     * This method is invoked by the container before the bean is destroyed.
     */
    public void destroy();
}
