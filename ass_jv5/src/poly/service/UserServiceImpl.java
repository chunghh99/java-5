
package poly.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import poly.dao.UserDao;
import poly.entity.Users;

@Service
@Qualifier("userService")
public class UserServiceImpl implements UserService{
	@Autowired 
	UserDao userDao;
	
	@Override
	public boolean insert(Users u) {
		// TODO Auto-generated method stub
		return userDao.insert(u);
	}

	@Override
	public boolean update(Users u) {
		// TODO Auto-generated method stub
		return userDao.update(u);
	}

	@Override
	public boolean delete(Users u) {
		// TODO Auto-generated method stub
		return userDao.delete(u);
	}

	@Override
	public ArrayList<Users> getall() {
		// TODO Auto-generated method stub
		return userDao.getall();
	}

	@Override
	public Users findByID(String id) {
		// TODO Auto-generated method stub
		return userDao.findByID(id);
	}

}
