package com.cybage.model;

import java.sql.Blob;
import java.util.Arrays;

import javax.persistence.*;



@Entity
@Table
public class Product {
	private int id;
	private String filename;
	private byte[] data;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	
	@Column
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	
	@Column
	public byte[] getData() {
		return data;
	}
	public void setData(byte[] data) {
		this.data = data;
	}
	
	
	@Override
	public String toString() {
		return String.format("Product [id=%s, filename=%s, data=%s]", id, filename, Arrays.toString(data));
	}
	
	
	
	
}
