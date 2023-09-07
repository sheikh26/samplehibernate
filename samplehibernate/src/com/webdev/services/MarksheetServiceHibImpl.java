package com.webdev.services;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.webdev.dto.MarksheetDTO;

public class MarksheetServiceHibImpl implements MarksheetService {

	public int addMarkSheet(MarksheetDTO dto) throws Exception {

		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		session.save(dto);

		tx.commit();
		session.close();

		return 1;
	}

	public int deleteMarkSheet(MarksheetDTO dto) throws Exception {
		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		session.delete(dto);

		tx.commit();
		session.close();

		return 1;
	}

	public MarksheetDTO getMarkSheet(String rollNo) throws Exception {

		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();

		Session session = sessionFactory.openSession();

		Query q = session.createQuery("from MarksheetDTO where rollNo = ?");
		q.setString(0, rollNo);
		List l = q.list();

		MarksheetDTO marksheetDTO = null;

		if (l.size() > 0) {
			marksheetDTO = (MarksheetDTO) l.get(0);
		}

		session.close();

		return marksheetDTO;
	}

	public List getMeritList() throws Exception {

		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();

		Session session = sessionFactory.openSession();

		Query q = session
				.createQuery("from MarksheetDTO order by (physics+physics+chemistry+maths) desc");

		List l = q.list();
		return l;
	}

	public List listMarksheet() throws Exception {
		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();

		Session session = sessionFactory.openSession();

		Query q = session.createQuery("from MarksheetDTO");

		List l = q.list();
		return l;
	}

	public int updateMarkSheet(MarksheetDTO dto) throws Exception {
		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		session.update(dto);

		tx.commit();
		session.close();

		return 1;
	}

}
