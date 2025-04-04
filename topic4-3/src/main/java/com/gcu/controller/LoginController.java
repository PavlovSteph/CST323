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

    @GetMapping("/")
    public String display(Model model) {
        model.addAttribute("title", "Login Form");
        model.addAttribute("loginModel", new LoginModel());
        logger.info("Login page displayed");
        return "login";
    }

    @PostMapping("/doLogin")
    public String doLogin(@Valid LoginModel loginModel, BindingResult bindingResult, Model model) {
        logger.info("Login attempt for user: {}", loginModel.getUsername());

        if (bindingResult.hasErrors()) {
            logger.warn("Validation errors occurred while logging in for user: {}", loginModel.getUsername());
            model.addAttribute("title", "Login Form");
            return "login";
        }

        boolean authenticated = security.authenticate(loginModel.getUsername(), loginModel.getPassword());
        
        if (!authenticated) {
            logger.warn("Failed login attempt for user: {}", loginModel.getUsername());
            model.addAttribute("error", "Invalid username or password");
            return "login";
        }

        logger.info("Successful login for user: {}", loginModel.getUsername());

        List<OrderModel> orders = service.getOrders();

        model.addAttribute("title", "My Orders");
        model.addAttribute("orders", orders);

        return "orders";
    }

    @GetMapping("/logout")
    public String logout(Model model) {
        logger.info("User logged out");
        model.addAttribute("message", "You have been logged out successfully");
        return "login";
    }
}
