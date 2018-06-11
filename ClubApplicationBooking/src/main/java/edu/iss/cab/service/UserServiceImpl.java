package edu.iss.cab.service;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.iss.cab.model.User;
import edu.iss.cab.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	@Resource
	private UserRepository userRepository;

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.iss.cab.service.UserService#findAllUsers()
	 */
	@Override
	@Transactional
	public ArrayList<User> findAllUsers() {
		ArrayList<User> ul = (ArrayList<User>) userRepository.findAll();
		return ul;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.iss.cab.service.UserService#findUser(java.lang.String)
	 */
	@Override
	@Transactional
	public User findUser(String userId) {
		return userRepository.findOne(userId);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.iss.cab.service.UserService#createUser(edu.iss.cab.model.User)
	 */
	@Override
	@Transactional
	public User createUser(User user) {
		return userRepository.saveAndFlush(user);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.iss.cab.service.UserService#changeUser(edu.iss.cab.model.User)
	 */
	@Override
	@Transactional
	public User changeUser(User user) {
		return userRepository.saveAndFlush(user);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.iss.cab.service.UserService#removeUser(edu.iss.cab.model.User)
	 */
	@Override
	@Transactional
	public void removeUser(User user) {
		userRepository.delete(user);
	}

	@Transactional
	public User authenticate(String uname, String pwd) {
		User u = userRepository.findUserByNamePwd(uname, pwd);
		return u;
	}
}
