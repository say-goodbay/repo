package com.whizen.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whizen.dao.Impl.UserDaoImpl;
import com.whizen.entity.User;
import com.whizen.mapper.UserMapper;
import com.whizen.service.UserService;
@Service
public class UserImpl implements UserService {
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private UserDaoImpl userDao;

	@Override
	public User get(Integer id) {
		// TODO Auto-generated method stub
		return this.userMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<User> list() {
		// TODO Auto-generated method stub
		return this.userMapper.selectAll();
	}

	@Override
	public int insert(User user) {
		// TODO Auto-generated method stub
		return this.userMapper.insert(user);
	}

	@Override
	public int delete(Integer id) {
		// TODO Auto-generated method stub
		return this.userMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int update(User user) {
		// TODO Auto-generated method stub
		return this.userMapper.updateByPrimaryKey(user);
	}

	@Override
	public User getUserByName(String userName) {
		// TODO Auto-generated method stub
		return this.userDao.getUserByName(userName);
	}
}
