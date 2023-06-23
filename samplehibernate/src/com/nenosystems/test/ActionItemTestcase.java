package com.nenosystems.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.nenosystems.dto.AuctionItemDTO;
import com.nenosystems.dto.BidDTO;
import com.nenosystems.services.AuctionItemServiceHibImpl;

public class ActionItemTestcase {

	AuctionItemServiceHibImpl service;

	@Before
	public void setUp() throws Exception {
		service = new AuctionItemServiceHibImpl();
	}

	@After
	public void tearDown() throws Exception {
		service = null;
	}

	@Test
	public void testAddAuction() {

		BidDTO bid1 = new BidDTO();
		bid1.setId(100);
		bid1.setAmount(100);
		bid1.setAmount(100);
		bid1.setTimestamp("AAAA");

		BidDTO bid2 = new BidDTO();
		bid2.setId(200);
		bid2.setAmount(200);
		bid2.setTimestamp("BBB");

		Set bids = new HashSet();
		bids.add(bid1);
		bids.add(bid2);

		AuctionItemDTO auctionItemDTO = new AuctionItemDTO();
		auctionItemDTO.setBids(bids);
		auctionItemDTO.setDescription("Test Action");
		auctionItemDTO.setId(100);

		service.addAuction(auctionItemDTO);

	}

	@Test
	public void testDeleteAuction() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateAuction() {
		fail("Not yet implemented");
	}

	public static void main(String[] args)throws Exception {

		ActionItemTestcase testcase = new ActionItemTestcase();
		testcase.setUp();
		testcase.testAddAuction();

	}

}
