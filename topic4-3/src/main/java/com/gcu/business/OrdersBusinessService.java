package com.gcu.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gcu.data.OrdersDataService;
import com.gcu.data.entity.OrderEntity;
import com.gcu.model.OrderModel;

public class OrdersBusinessService implements OrdersBusinessInterface{
	
	//Declaring and Initializing
		private OrdersDataService service;

		/**
		 * Setter for Service OrdersDataService
		 * @param service Specified for Service
		 */
	    @Autowired
	    public void setService(OrdersDataService service) {
	        this.service = service;
	    }
	    
	/**
     * A test method to print a message.
     */
    @Override
    public void test() {
        System.out.println("Hello from the OrdersBusinessService");
    }

    /**
     * Retrieves a list of orders.
     * 
     * @return A list of {@link OrderModel} objects representing orders.
     */
    @Override
    public List<OrderModel> getOrders() {
    	
    	//Get all the Entity Orders
    	List<OrderEntity> ordersEntity = service.findAll();
    	
    	//Iterate over the Entity ORders and create a list of Domain Orders
    	List<OrderModel> ordersDomain = new ArrayList<OrderModel>();
    	for(OrderEntity entity : ordersEntity)
    	{
    		ordersDomain.add(new OrderModel(entity.getId(), entity.getOrderNo(), entity.getProductName(), entity.getPrice(), entity.getQuantity()));
    	}
    	
    	//Return list of Domain Orders
    	return ordersDomain;
    }
    
    /**
     * Initialization method.
     * This method is invoked by the container after instantiation but before dependency injection.
     */
    @Override
    public void init() {
        System.out.println("Hello from the OrdersBusinessService from the init() method");
    }
    
    /**
     * Destruction method.
     * This method is invoked by the container before the bean is destroyed.
     */
    @Override
    public void destroy() {
        System.out.println("Hello from the OrdersBusinessService from the destroy() method");
    }
    
    
}
