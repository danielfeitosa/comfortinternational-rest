package com.sponsorshiphub.domain;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Project {
	@Id
	private String id;

	private String name;
	private String description;
	private String country;
	
    @DBRef(lazy=true)
	private List<Sponsored> sponsoreds = new ArrayList<Sponsored>();

	public List<Sponsored> getSponsoreds() {
		return sponsoreds;
	}

	public void setSponsoreds(List<Sponsored> sponsoreds) {
		this.sponsoreds = sponsoreds;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

}
