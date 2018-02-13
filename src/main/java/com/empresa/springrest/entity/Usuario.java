package com.empresa.springrest.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Table(name= "Usuario")
@Entity
public class Usuario implements Serializable {
	@GeneratedValue
	@Id
	@Column(name="id")
	private long id;
	@Column(name="user", unique = true)
	private String user;
	@Column(name="password")
	private String password;
	@Column(name="role")
	private byte role;
	
	@Column(name="status")
	private boolean status;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public byte getRole() {
		return role;
	}

	public void setRole(byte role) {
		this.role = role;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
	
}
