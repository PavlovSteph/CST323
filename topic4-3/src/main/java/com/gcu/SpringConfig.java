package com.gcu;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.gcu.business.OrdersBusinessInterface;
import com.gcu.business.OrdersBusinessService;

@Configuration
public class SpringConfig {
	
	/**
	 * Creates and configures a bean for the orders business service.
	 * 
	 * @return An instance of OrdersBusinessService implementing OrdersBusinessInterface.
	 */
	@Bean(name="ordersBusinessService")
	public OrdersBusinessInterface getOrderBusiness() {
		
		return new OrdersBusinessService();
	}
}
