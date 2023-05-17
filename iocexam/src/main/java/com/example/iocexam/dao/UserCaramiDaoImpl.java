package com.example.iocexam.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.iocexam.domain.User;
@Repository("userCaramiDao")
public class UserCaramiDaoImpl implements UserDao {

	@Override
	public User getuser(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addUser(User user) {
		System.out.println(user + "의 정보가 caramiDao를 이용해서 잘 저장 되었습니다.");

	}

}
