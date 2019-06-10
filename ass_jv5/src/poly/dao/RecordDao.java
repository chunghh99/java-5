package poly.dao;

import java.util.ArrayList;

import poly.entity.Records;

public interface RecordDao {
	public boolean insert(Records rc);
	public boolean update(Records rc);
	public boolean delete(Records rc);
	public Records findByID(String id);
	public ArrayList<Records> getall(int type);
	public boolean deleteToStaffId(String id);
}
