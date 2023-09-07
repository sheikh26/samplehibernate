package com.webdev.services;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.webdev.dto.AuctionItemDTO;
import com.webdev.utility.HibernateUtil;

public class AuctionItemServiceHibImpl {

	public AuctionItemDTO addAuction(AuctionItemDTO dto) {
		Session session = HibernateUtil.currentSession();
		Transaction tx = session.beginTransaction();

		session.save(dto);

		tx.commit();
		HibernateUtil.closeSession();

		return dto;
	}

	public void deleteAuction(AuctionItemDTO dto) {
		Session session = HibernateUtil.currentSession();
		Transaction tx = session.beginTransaction();

		session.delete(dto);

		tx.commit();
		HibernateUtil.closeSession();
	}

	public AuctionItemDTO updateAuction(AuctionItemDTO dto) {
		Session session = HibernateUtil.currentSession();
		Transaction tx = session.beginTransaction();

		session.update(dto);

		tx.commit();
		HibernateUtil.closeSession();

		return dto;
	}

}
