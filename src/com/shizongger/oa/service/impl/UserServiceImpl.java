package com.shizongger.oa.service.impl;

import org.hibernate.Session;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.shizongger.oa.base.DaoSupportImpl;
import com.shizongger.oa.domain.User;
import com.shizongger.oa.service.UserService;

@Service("userService")
@Transactional
public class UserServiceImpl extends DaoSupportImpl<User> implements UserService {

	
	private Log log = LogFactory.getLog(this.getClass());	

	@Override
	public User findByLoginNameAndPassword(String loginName, String password) {
		Session session = this.getSession();
		String md5Hex = DigestUtils.md5Hex(password);
		
		User user = (User) session.createQuery("FROM User u WHERE u.loginName=? AND u.password=?")
				.setParameter(0, loginName)
				.setParameter(1, md5Hex)
				.uniqueResult();
		return user;
	}
}
