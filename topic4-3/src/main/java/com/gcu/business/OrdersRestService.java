package com.gcu.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gcu.model.OrderModel;
import com.gcu.model.OrdersList;

@RestController
@RequestMapping("/service")
public class OrdersRestService {
	
	private OrdersBusinessInterface service;

	/**
     * Setter for the OrdersBusinessInterface dependency.
     * 
     * @param service The OrdersBusinessInterface implementation.
     */
    @Autowired
    public void setService(OrdersBusinessInterface service) {
        this.service = service;
    }

    /**
     * Retrieves orders data in JSON format.
     * 
     * @return A list of OrderModel objects serialized to JSON.
     */
    @GetMapping(path="/getjson", produces= {MediaType.APPLICATION_JSON_VALUE})
    public List<OrderModel> getOrderAsJson() {
        return service.getOrders();
    }
    
    /**
     * Retrieves orders data in XML format.
     * 
     * @return An OrdersList object containing the list of orders serialized to XML.
     */
    @GetMapping(path="/getxml", produces= {MediaType.APPLICATION_XML_VALUE})
    public OrdersList getOrdersAsXml() {
        OrdersList list = new OrdersList();
        list.setOrders(service.getOrders());
        return list;
    }
}
