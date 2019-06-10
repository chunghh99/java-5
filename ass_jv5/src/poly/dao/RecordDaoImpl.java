package poly.dao;

import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import poly.entity.Departs;
import poly.entity.Records;

@Repository
public class RecordDaoImpl implements RecordDao {

	@Autowired
	SessionFactory sessionFactory;
		
	@Override
	public boolean insert(Records rc) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction=session.beginTransaction();
			session.save(rc);
			transaction.commit();
			return true;
		} catch (Exception e) {
			if(transaction!=null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}finally {
			session.flush();
			session.close();
		}
		return false;
	}

	@Override
	public boolean update(Records rc) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction=session.beginTransaction();
			session.update(rc);
			transaction.commit();
			return true;
		} catch (Exception e) {
			if(transaction!=null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}finally {
			session.flush();
			session.close();
		}
		return false;
	}

	@Override
	public boolean delete(Records rc) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction=session.beginTransaction();
			session.delete(rc);
			transaction.commit();
			return true;
		} catch (Exception e) {
			if(transaction!=null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}finally {
			session.flush();
			session.close();
		}
		return false;
	}

	@Override
	public Records findByID(String id) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction=session.beginTransaction();
			Records rc= (Records) session.get(Records.class, id);
			transaction.commit();
			return rc;
		} catch (Exception e) {
			if(transaction!=null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}finally {
			session.flush();
			session.close();
		}
		return null;
	}

	@Override
	@SuppressWarnings("unchecked")
	public ArrayList<Records> getall(int type) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction=session.beginTransaction();
			String hql = "FROM Records WHERE type=:type";
			Query query = session.createQuery(hql);
			query.setParameter("type", type);
			ArrayList<Records> list=(ArrayList<Records>) query.list();
			transaction.commit();
			return list;
		} catch (Exception e) {
			if(transaction!=null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}finally {
			session.flush();
			session.close();
		}
		
		
		return null;
	}

	@Override
	public boolean deleteToStaffId(String id) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction=session.beginTransaction();
			String hql="DELETE from Records WHERE StaffId like:staffId ";
			Query query = session.createQuery(hql);
			query.setParameter("staffId", id);
			transaction.commit();
			return true;
		} catch (Exception e) {
			if(transaction!=null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}finally {
			session.flush();
			session.close();
		}
		return false;
	}


}
