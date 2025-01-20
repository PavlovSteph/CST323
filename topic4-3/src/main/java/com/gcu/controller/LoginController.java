package com.gcu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gcu.business.OrdersBusinessInterface;
import com.gcu.business.SecurityBusinessService;
import com.gcu.model.LoginModel;
import com.gcu.model.OrderModel;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/login")
public class LoginController { 
	
	private OrdersBusinessInterface service;
	private SecurityBusinessService security;
	
	/**
     * Setter for the OrdersBusinessInterface dependency.
     * 
     * @param service The OrdersBusinessInterface implementation.
     */
    @Autowired
    public void setOrdersBusinessService(OrdersBusinessInterface service) {
        this.service = service;
    }
    
    /**
     * Setter for the SecurityBusinessService dependency.
     * 
     * @param security The SecurityBusinessService instance.
     */
    @Autowired
    public void setSecurityBusinessService(SecurityBusinessService security) {
        this.security = security;
    }
	
	/**
	 * Displays the login form.
     *
     * @param model the Spring MVC model to add attributes
     * @return the view name for the login form
	 */
	@GetMapping("/")
	public String display(Model model)
	{
		model.addAttribute("title", "Login Form");
        model.addAttribute("loginModel", new LoginModel());
        
		return "login";
	}
	
	/**
	 * Processes the login request.
     *
     * @param loginModel     the LoginModel containing login credentials
     * @param bindingResult  the Spring MVC binding result for validation
     * @param model          the Spring MVC model to add attributes
     * @return the view name for displaying orders if login is successful, otherwise the login form
	 */
	@PostMapping("/doLogin")
    public String doLogin(@Valid LoginModel loginModel, BindingResult bindingResult, Model model) {
        // Print username and password to the console
        if (bindingResult.hasErrors())
        {
        	model.addAttribute("title", "Login Form");
        	return "login";
        }
        
     // Call the test method of OrdersBusinessService
        //service.test();
        
        // Authenticate user
        boolean authenticated = security.authenticate(loginModel.getUsername(), loginModel.getPassword());
        if (!authenticated) {
            // Handle unsuccessful authentication
            return "login"; // Return login form with error message
        }

        List<OrderModel> orders = service.getOrders();
       
        // Return the view name
        model.addAttribute("title", "My Orders");
        model.addAttribute("orders", orders);
        
        return "orders";
    }

}
