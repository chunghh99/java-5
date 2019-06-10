package poly.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import poly.dao.DepartDao;
import poly.dao.DepartDaoImpl;
import poly.entity.Departs;

@Service
@Qualifier("DepartSevice")
public class DepartServiceImpl implements DepartService{
	
	@Autowired
	DepartDao dePartDao;
	
	@Override
	public boolean insert(Departs dp) {
		return dePartDao.insert(dp);
	}

	@Override
	public boolean update(Departs dp) {
		return dePartDao.update(dp);
	}

	@Override
	public boolean delete(Departs dp) {
		return dePartDao.delete(dp);
	}

	@Override
	public ArrayList<Departs> getall() {
		
		return dePartDao.getall();
	}

	@Override
	public Departs findByID(String id) {
		return dePartDao.findByID(id);
	}

}
