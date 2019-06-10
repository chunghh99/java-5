package poly.dao;

import java.util.ArrayList;
import java.util.List;

import poly.entity.Staffs;

public interface StaffDao {

	public boolean insert(Staffs dp);
	public boolean update(Staffs dp);
	public boolean delete(Staffs dp);
	public Staffs findByID(String id);
	public ArrayList<Staffs> getall();
	public List<Object[]> getReport();
}
