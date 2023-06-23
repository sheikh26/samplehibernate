package com.nenosystems.test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nenosystems.dto.AuctionItemDTO;
import com.nenosystems.dto.BidDTO;

public class TestAuctionItem {

	public static void main(String[] args) {
		// testAddAuction();
		testGet();
		// testDelete();
	}

	public static void testAddAuction() {

		AuctionItemDTO auctionItemDTO = new AuctionItemDTO();
		auctionItemDTO.setId(1);
		auctionItemDTO.setDescription("Sachin ka Topi");

		BidDTO bid1 = new BidDTO();
		bid1.setId(4);
		bid1.setAmount(5);
		bid1.setTimestamp("AAA");

		BidDTO bid2 = new BidDTO();
		bid2.setId(5);
		bid2.setAmount(10);
		bid2.setTimestamp("BBB");

		Set bids = new HashSet();
		bids.add(bid1);
		bids.add(bid2);

		auctionItemDTO.setBids(bids);

		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();

		Session s = sessionFactory.openSession();
		Transaction tx = s.beginTransaction();

		s.save(auctionItemDTO);

		tx.commit();
		s.close();

		System.out.println("Action Successfuly Added");

	}

	public static void testGet() {

		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();

		Session s = sessionFactory.openSession();

		AuctionItemDTO dto = (AuctionItemDTO) s.get(AuctionItemDTO.class, 1L);

		Iterator it = dto.getBids().iterator();

		BidDTO bid = null;
		while (it.hasNext()) {
			bid = (BidDTO) it.next();
			System.out.println("ID " + bid.getId());
			System.out.println("Amount " + bid.getAmount());
		}
		s.close();

	}

	public static void testDelete() {

		AuctionItemDTO dto = new AuctionItemDTO();
		dto.setId(4);

		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();

		Session s = sessionFactory.openSession();
		Transaction tx = s.beginTransaction();

		s.delete(dto);

		tx.commit();
		s.close();

	}

}
