package com.sponsorshiphub.domain;

import java.util.Date;

public class Sponsorship {
	
	private Sponsor sponsor;
	private Sponsored sponsored;
	private Date dataBegin;
	private Date dataEnd;
	public Sponsor getSponsor() {
		return sponsor;
	}
	public void setSponsor(Sponsor sponsor) {
		this.sponsor = sponsor;
	}
	public Sponsored getSponsored() {
		return sponsored;
	}
	public void setSponsored(Sponsored sponsored) {
		this.sponsored = sponsored;
	}
	public Date getDataBegin() {
		return dataBegin;
	}
	public void setDataBegin(Date dataBegin) {
		this.dataBegin = dataBegin;
	}
	public Date getDataEnd() {
		return dataEnd;
	}
	public void setDataEnd(Date dataEnd) {
		this.dataEnd = dataEnd;
	}
	
	
	
	

}
