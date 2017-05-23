package com.cybage.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.JoinColumn;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity()
@Table(name = "users")
public class User implements Serializable
{
	private int user_id;
	private String user_name;
	private String user_password;
	
	
	
	
	@Id

	@Column(name = "userid")
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	@Column(name = "name")
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	
	@Column(name = "password")
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	
	
	@Override
	public String toString() {
		return String.format("User [user_id=%s, user_name=%s, user_password=%s]", user_id, user_name, user_password);
	}
	
	

	
	
	
}
