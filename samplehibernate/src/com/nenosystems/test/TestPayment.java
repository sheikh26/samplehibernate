package com.nenosystems.test;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nenosystems.dto.inh.CashPaymentDTO;
import com.nenosystems.dto.inh.ChequePaymentDTO;
import com.nenosystems.dto.inh.CreditCardPaymentDTO;

public class TestPayment {

	/**
	 * @paparam args
	 */
	public static void main(String[] args) throws Exception {
		testGet();
		//testAdd();

	}

	public static void testGet() throws Exception {

		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();

		Session s = sessionFactory.openSession();

		//Get Cash Payments
		List l = s.createQuery("from CashPaymentDTO").list();

		Iterator it = l.iterator();

		CashPaymentDTO cashPaymentDTO = null;

		System.out.println("######### CASH Payment #######");
		while (it.hasNext()) {

			cashPaymentDTO = (CashPaymentDTO) it.next();
			System.out.println(cashPaymentDTO.getId() + " : "
					+ cashPaymentDTO.getAmount());

		}

		
		// Get Credit Card Payments
		l = s.createQuery("from CreditCardPaymentDTO").list();

		it = l.iterator();

		CreditCardPaymentDTO cardPaymentDTO = null;

		System.out.println("######### Credit Card Payment #######");
		while (it.hasNext()) {

			cardPaymentDTO = (CreditCardPaymentDTO) it.next();
			System.out.println(cardPaymentDTO.getId() + " : "
					+ cardPaymentDTO.getAmount() + " : "
					+ cardPaymentDTO.getCcType());

		}

		// Get Cheque Payments

		l = s.createQuery("from ChequePaymentDTO").list();
		it = l.iterator();

		ChequePaymentDTO chequePaymentDTO = null;

		System.out.println("######### Cheque Payment #######");
		while (it.hasNext()) {

			chequePaymentDTO = (ChequePaymentDTO) it.next();
			System.out.println(chequePaymentDTO.getId() + " : "
					+ chequePaymentDTO.getAmount() + " : "
					+ chequePaymentDTO.getChequeNumber() + " : "
					+ chequePaymentDTO.getBankName());

		}

		s.close();

	}

	public static void testAdd() throws Exception {

		CashPaymentDTO cashPaymentDTO = new CashPaymentDTO();
		cashPaymentDTO.setAmount(11000);

		CreditCardPaymentDTO cardPaymentDTO = new CreditCardPaymentDTO();
		cardPaymentDTO.setAmount(12000);
		cardPaymentDTO.setCcType("VISA");

		ChequePaymentDTO chequePaymentDTO = new ChequePaymentDTO();
		chequePaymentDTO.setAmount(13000);
		chequePaymentDTO.setBankName("AXIS Bank");
		chequePaymentDTO.setChequeNumber("092901");

		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();

		Session s = sessionFactory.openSession();
		Transaction tx = s.beginTransaction();

		s.save(cashPaymentDTO);
		s.save(cardPaymentDTO);
		s.save(chequePaymentDTO);

		tx.commit();
		s.close();

	}

}
