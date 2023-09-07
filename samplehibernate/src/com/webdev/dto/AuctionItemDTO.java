package com.webdev.dto;

import java.util.Set;

public class AuctionItemDTO {
	
	private long id;
	private Set bids;
	private String description;
	private BidDTO successfulBid = null;
	
	public Set getBids() {
		return bids;
	}
	public void setBids(Set bids) {
		this.bids = bids;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	public BidDTO getSuccessfulBid() {
		return successfulBid;
	}

	public void setSuccessfulBid(BidDTO successfulBid) {
		this.successfulBid = successfulBid;
	} 
	
	

}
