package poly.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import poly.entity.Staffs;

@Repository
public class StaffDaoImpl implements StaffDao {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean insert(Staffs dp) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction=session.beginTransaction();
			session.save(dp);
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
	public boolean update(Staffs dp) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction=session.beginTransaction();
			session.update(dp);
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
	public boolean delete(Staffs dp) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction=session.beginTransaction();
			session.delete(dp);
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
	@SuppressWarnings("unchecked")
	public ArrayList<Staffs> getall() {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction=session.beginTransaction();
			String hql = "FROM Staffs ORDER BY departid DESC";
			Query query = session.createQuery(hql);
			ArrayList<Staffs> list= (ArrayList<Staffs>) query.list();
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
	public Staffs findByID(String id) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction=session.beginTransaction();
			Staffs dp= (Staffs) session.get(Staffs.class, id);
			transaction.commit();
			return dp;
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
	public List<Object[]> getReport() {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			String hql = "SELECT r.staff.id,"+
					" SUM(case when r.type=1 then 1 else 0 end), "+
					" SUM(case when r.type=0 then 1 else 0 end)"+
					" FROM Records r "+
					" GROUP BY r.staff.id";
			Query query = session.createQuery(hql);
			List<Object[]> list = query.list();
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
		return null;	}



}
