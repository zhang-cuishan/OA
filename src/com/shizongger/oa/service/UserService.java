package com.shizongger.oa.service;

import java.util.List;

import com.shizongger.oa.domain.User;

public interface UserService {
	
	public void add(User user);
	
	public void delete(Long id);
	
	public void update(User user);
	
	public List<User> selectAll();
	
	public User selectById(Long id);
	
	public User findByLoginNameAndPassword(String loginName, String password);
}
