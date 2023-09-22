package com.nagarro.exittestapi.model;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;


@Entity 
public class Review {
	
	 @Id
	 @GeneratedValue(generator = "UUID")
	    @GenericGenerator(
	        name = "UUID",
	    strategy = "org.hibernate.id.UUIDGenerator"
	    )
	 private String id;
	 private boolean approved;
	 private String heading;
	 private int rating;
	 @Column(columnDefinition="TEXT")
	 private String text;
	 
	 private String code;
	 
	 
	public Review() {
	}

	public Review(String heading, int rating, String text, String code, boolean approved) {
		super();
		this.heading = heading;
		this.rating = rating;
		this.text = text;
		this.approved = approved;
		this.code = code;
		
	}

	public String getHeading() {
		return heading;
	}

	public void setHeading(String heading) {
		this.heading = heading;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public boolean isApproved() {
		return approved;
	}

	public void setApproved(boolean approved) {
		this.approved = approved;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getCode() {
		return code;
	}
	
	

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "Review [id=" + id + ", approved=" + approved + ", heading=" + heading + ", rating=" + rating + ", text="
				+ text + ", Code=" + code + "]";
	}
	 
	
}
