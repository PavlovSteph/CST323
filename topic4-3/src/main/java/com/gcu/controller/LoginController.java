package com.gcu.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    // Logger for logging the events when the user attempts to login
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    private OrdersBusinessInterface service;
    private SecurityBusinessService security;

    @Autowired
    public void setOrdersBusinessService(OrdersBusinessInterface service) {
        this.service = service;
    }

    @Autowired
    public void setSecurityBusinessService(SecurityBusinessService security) {
        this.security = security;
    }

    // Handles the GET request to display the login form
    @GetMapping("/")
    public String display(Model model) {
        logger.info("Entering display method for login page");

        // Prepare the model for the login page
        model.addAttribute("title", "Login Form");
        model.addAttribute("loginModel", new LoginModel());

        logger.info("Login page displayed");
        return "login";
    }

    // Handles the POST request to process the login attempt
    @PostMapping("/doLogin")
    public String doLogin(@Valid LoginModel loginModel, BindingResult bindingResult, Model model) {
        logger.info("Entering doLogin method for user: {}", loginModel.getUsername());

        // Check if there were validation errors during login form submission
        if (bindingResult.hasErrors()) {
            logger.warn("Error occurred while logging in for user: {}", loginModel.getUsername());
            model.addAttribute("title", "Login Form");
            // Return to the login page if theres an error
            return "login";  
        }

        // Authenticate the user
        boolean authenticated = security.authenticate(loginModel.getUsername(), loginModel.getPassword());
        
        if (!authenticated) {
            logger.warn("Failed login attempt for user: {}", loginModel.getUsername());
            model.addAttribute("error", "Invalid username or password");
            // Return to the login page with an error message if failed login
            return "login";  
        }

        logger.info("Successful login for user: {}", loginModel.getUsername());

        // Retrieve the user's orders after successful login
        List<OrderModel> orders = service.getOrders();

        // Add orders to the model and display the orders page
        model.addAttribute("title", "My Orders");
        model.addAttribute("orders", orders);

        // adding exit path logging for successful login
        logger.info("Exiting doLogin method for user: {}", loginModel.getUsername()); 
        // Return to the orders page
        return "orders"; 
    }

    // Handles the GET request to logout the user
    @GetMapping("/logout")
    public String logout(Model model) {
        logger.info("Entering logout method");

        // Add logout message
        model.addAttribute("message", "You have been logged out successfully");

        logger.info("User logged out");
        // Redirect to the login page after logout
        return "login";  
    }
}

