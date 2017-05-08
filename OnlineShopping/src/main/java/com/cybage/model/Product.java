package com.cybage.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity()
@Table(name = "products")
public class Product implements Serializable 
{
	private int product_id;
	private String product_name;
	private String product_description;
	private String product_img;
	private String product_catagory;
	
	
	@Id

	@Column(name="pid")
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	
	@Column(name="pname")
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	
	@Column(name="pdesc")
	public String getProduct_description() {
		return product_description;
	}
	public void setProduct_description(String product_description) {
		this.product_description = product_description;
	}
	
	@Column(name="pimg")
	public String getProduct_img() {
		return product_img;
	}
	public void setProduct_img(String product_img) {
		this.product_img = product_img;
	}
	
	@Column(name="pcat")
	public String getProduct_catagory() {
		return product_catagory;
	}
	public void setProduct_catagory(String product_catagory) {
		this.product_catagory = product_catagory;
	}
	
	
	
	@Override
	public String toString() {
		return String.format("[product_id=%s, product_name=%s, product_description=%s, product_img=%s]",
				product_id, product_name, product_description, product_img);
	}
	
	
	

}
