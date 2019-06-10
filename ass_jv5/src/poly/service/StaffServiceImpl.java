package poly.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import poly.dao.StaffDao;
import poly.entity.Staffs;

@Service
@Qualifier("staffService")
public class StaffServiceImpl implements StaffService {

	@Autowired
	StaffDao staffDao;

	@Override
	public boolean insert(Staffs dp) {
		
		return staffDao.insert(dp);
	}

	@Override
	public boolean update(Staffs dp) {
		
		return staffDao.update(dp);
	}

	@Override
	public boolean delete(Staffs dp) {
	
		return staffDao.delete(dp);
	}

	@Override
	public ArrayList<Staffs> getall() {
		
		return staffDao.getall();
	}

	@Override
	public Staffs findByID(String id) {
	
		return staffDao.findByID(id);

	}

	@Override
	public List<Object[]> getReport() {
		
		return staffDao.getReport();
	}



}
