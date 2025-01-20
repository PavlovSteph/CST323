package com.gcu.business;

import org.springframework.stereotype.Service;

@Service
public class SecurityBusinessService {
	
	/**
	 * Authenticates a user.
     * 
     * @param username The username of the user.
     * @param password The password of the user.
     * @return true if authentication is successful, false otherwise.	 
     */
	public boolean authenticate(String username, String passwor)
	{
		System.out.println("Hello from the SecurityBusinessService");
		return true;
	}

}
