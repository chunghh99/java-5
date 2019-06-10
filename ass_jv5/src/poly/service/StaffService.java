package poly.service;

import java.util.ArrayList;
import java.util.List;

import poly.entity.Staffs;

public interface StaffService {

	public boolean insert(Staffs dp);
	public boolean update(Staffs dp);
	public boolean delete(Staffs dp);
	 public Staffs findByID(String id);
	public ArrayList<Staffs> getall();
	public List<Object[]> getReport();
}
