package com.whizen.service;

import java.util.List;

import com.whizen.entity.Email;

public interface EmailService {
	public Email get(Integer id);
	public List<Email> list();
	public int insert(Email email);
	public int delete(Integer id);
	public int update(Email email);

}
