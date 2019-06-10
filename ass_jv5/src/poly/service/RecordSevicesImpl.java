package poly.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import poly.dao.RecordDao;
import poly.entity.Records;

@Service
@Qualifier("RecordService")
public class RecordSevicesImpl implements RecordSevices{

	@Autowired
	RecordDao recordDao;
	
	@Override
	public boolean insert(Records rc) {
		return recordDao.insert(rc);
	}

	@Override
	public boolean update(Records rc) {
		return recordDao.update(rc);
	}

	@Override
	public boolean delete(Records rc) {
		return recordDao.delete(rc);
	}

	@Override
	public Records findByID(String id) {
		return recordDao.findByID(id);
	}

	@Override
	public ArrayList<Records> getall(int type) {
		return recordDao.getall(type);
	}

	@Override
	public boolean deleteToStaffId(String id) {
		return recordDao.deleteToStaffId(id);
	}

}
