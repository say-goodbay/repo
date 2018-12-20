package com.whizen.service;

import java.util.List;
import com.whizen.entity.User;

public interface UserService {
	public User get(Integer id);
	public List<User> list();
	public int insert(User user);
	public int delete(Integer id);
	public int update(User user);
	public User getUserByName(String userName);
}
