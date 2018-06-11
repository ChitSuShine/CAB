package edu.iss.cab.service;

import java.util.ArrayList;

import javax.management.relation.Role;

import org.springframework.transaction.annotation.Transactional;

import edu.iss.cab.model.User;

public interface UserService {

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.iss.cab.service.UserService#findAllUsers()
	 */
	ArrayList<User> findAllUsers();

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.iss.cab.service.UserService#findUser(java.lang.String)
	 */
	User findUser(String userId);

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.iss.cab.service.UserService#createUser(edu.iss.cats.model.User)
	 */
	User createUser(User user);

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.iss.cab.service.UserService#changeUser(edu.iss.cab.model.User)
	 */
	User changeUser(User user);

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.iss.cab.service.UserService#removeUser(edu.iss.cab.model.User)
	 */
	void removeUser(User user);

	User authenticate(String uname, String pwd);
}