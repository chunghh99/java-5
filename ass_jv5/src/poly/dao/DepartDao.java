package poly.dao;

import java.util.ArrayList;

import poly.entity.Departs;

public interface DepartDao {
	
	public boolean insert(Departs dp);
	public boolean update(Departs dp);
	public boolean delete(Departs dp);
	public Departs findByID(String id);
	public ArrayList<Departs> getall();

}
