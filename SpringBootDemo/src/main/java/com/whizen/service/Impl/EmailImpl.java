package com.whizen.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whizen.entity.Email;
import com.whizen.entity.User;
import com.whizen.mapper.EmailMapper;
import com.whizen.service.EmailService;
@Service
public class EmailImpl implements EmailService {
	@Autowired
	private EmailMapper emailMapper;

	@Override
	public Email get(Integer id) {
		// TODO Auto-generated method stub
		return this.emailMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Email> list() {
		// TODO Auto-generated method stub
		return this.emailMapper.selectAll();
	}

	@Override
	public int insert(Email email) {
		// TODO Auto-generated method stub
		return this.emailMapper.insert(email);
	}

	@Override
	public int delete(Integer id) {
		// TODO Auto-generated method stub
		return this.emailMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int update(Email email) {
		// TODO Auto-generated method stub
		return this.emailMapper.updateByPrimaryKey(email);
	}
	
}
