package com.example.iocexam.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.iocexam.dao.UserDao;
import com.example.iocexam.domain.User;
@Service
public class UserServiceImpl implements UserService {
	@Qualifier("userDaoImpl")
	@Autowired
	private UserDao userDao;
	
	public UserServiceImpl() {
		System.out.println("userService() 실행!!");
	}
	
//	@Autowired
	public UserServiceImpl(UserDao userCaramiDao) {
		this.userDao = userCaramiDao;
		System.out.println("userService(userDao) 생성!!");
	}
	
	

	@Override
	public void joinUser(User user) {
		//회원가입에 필요한 비지니스를 처리한다. 
		//회원 가입이 가능하다면 회원 정보를 저장하도록 한다. 
		
		//저장하는 로직은 DAO가 구현하고 있으므로  DAO를 사용하도록 코드를 작성한다. 
		
		userDao.addUser(user);

	}

}
