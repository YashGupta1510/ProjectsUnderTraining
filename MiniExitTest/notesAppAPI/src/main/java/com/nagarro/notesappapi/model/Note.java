package com.nagarro.notesappapi.model;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue; 
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Note {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	String id;
	@Column(columnDefinition="TEXT")
	String body;
	
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date createdAt;
	

	@ManyToOne
	@JoinColumn(name = "email")
	User user;
	
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
	public Note() {
	}
	public Note(String id, String body) {
		super();
		this.id = id;
		this.body = body;
	}
	
	@Override
	public int hashCode() {
	    return id.hashCode();
	}
	public boolean equals(Object anObject) {
		return body.equals(anObject);
	}
	@Override
	public String toString() {
		return "Note [id=" + id + ", body=" + body + ", createdAt=" + createdAt + ", user=" + user + "]";
	}
}
