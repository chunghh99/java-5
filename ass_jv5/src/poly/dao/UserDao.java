package poly.dao;

import java.util.ArrayList;

import poly.entity.Staffs;
import poly.entity.Users;

public interface UserDao {
	public boolean insert(Users u);
	public boolean update(Users u);
	public boolean delete(Users u);
	public ArrayList<Users> getall();
	public Users findByID(String id);
}
