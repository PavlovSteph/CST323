package com.gcu.data;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.gcu.data.repository.OrdersRepository;
import com.gcu.data.entity.OrderEntity;




@Service
public class OrdersDataService implements DataAccessInterface<OrderEntity> {

@Autowired
private OrdersRepository ordersRepository; 

@SuppressWarnings("unused")
private DataSource dataSource; 
private JdbcTemplate jdbcTemplateObject; 

/**
 * Non-Default constructor for constructor injection
 * @param ordersRespository Specified for ordersRepository
 */
public OrdersDataService(OrdersRepository ordersRepository, DataSource dataSource)
{
	this.ordersRepository = ordersRepository;
	this.dataSource = dataSource; 
	this.jdbcTemplateObject = new JdbcTemplate(dataSource);
}

/**
 * CRUD: finder to return all entities
 */
public List<OrderEntity> findAll()
{
	List<OrderEntity> orders = new ArrayList<OrderEntity>();
	try
	{
		//Get all the Entity Orders
		Iterable<OrderEntity> ordersIterable = ordersRepository.findAll();
		
		//Convert to a List and return the List
		orders = new ArrayList<OrderEntity>();
		ordersIterable.forEach(orders::add);
	}
	catch (Exception e)
	{
		e.printStackTrace();
	}
	//Return the list
	return orders;
}

/**
 * CRUD: create an entity
 */
public boolean create(OrderEntity order)
{
	String sql = "INSERT INTO ORDERS(ORDER_NO, PRODUCT_NAME, PRICE, QUANTITY) VALUES(?,?,?,?)";
	try
	{
		// Execute SQL Insert 
		jdbcTemplateObject.update(sql,
							order.getOrderNo(),
							order.getProductName(),
							order.getPrice(),
							order.getQuantity());
	}
	catch (Exception e)
	{
		e.printStackTrace();
		return false;
	}
	
	return true;
}

/**
 * CRUD: finder to return a single entity
 */
public OrderEntity findById(int id) {
	// TODO Auto-generated method stub
	return null;
}

/**
 * Method from DataAccessInterface 
 */
@Override
public boolean update(OrderEntity t) {
	// TODO Auto-generated method stub
	return true;
}

/**
 * Method from DataAccessInterface 
 */
@Override
public boolean delete(OrderEntity t) {
	// TODO Auto-generated method stub
	return true;
}

}

