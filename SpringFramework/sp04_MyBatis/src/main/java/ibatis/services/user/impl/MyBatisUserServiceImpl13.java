package ibatis.services.user.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ibatis.services.domain.User;
import ibatis.services.user.UserService;
import ibatis.services.user.userDAO;

@Service
public class MyBatisUserServiceImpl13 implements UserService {
	
	@Autowired
	private userDAO userDAO;

	@Override
	public void addUser(User user) throws Exception {
		userDAO.addUser(user);
	}

	@Override
	public void updateUser(User user) throws Exception {
		userDAO.updateUser(user);
	}

	@Override
	public User getUser(String userId) throws Exception {
		return userDAO.getUser(userId);
	}

	@Override
	public List<User> getUserList(User user) throws Exception {
		return userDAO.getUserList(user);
	}

}
