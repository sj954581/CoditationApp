package com.CoditationApp.CoditationApp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
@AllArgsConstructor
@Table(name = "product")
public class Product {
	
	public Product() {}
	
	public Product(int primaryid,int id,int categoryid,String name,String price) {
		this.primaryid = primaryid;
		this.id = id;
		this.categoryid = categoryid;
		this.name = name;
		this.price = price;
	}
	
	@Id
	@GeneratedValue
	public int primaryid;
	
	@Column(name="id")
	public int id;
	
	@Column(name="categoryid")
	public int categoryid;
	
	@Column(name="name")
	public String name;
	
	@Column(name="price")
	public String price;

	public int getPrimaryid() {
		return primaryid;
	}
	
	public void setPrimaryid(int primaryid) {
		this.primaryid = primaryid;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getCategoryid() {
		return categoryid;
	}
	
	public void setCategoryid(int categoryid) {
		this.categoryid = categoryid;
	}
	
	public String getPrice() {
		return price;
	}
	
	public void setPrice(String price) {
		this.price = price;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "{Productid=" + id + ", categoryid=" + categoryid + ", name=" + name
				+ ", price=" + price + "}";
	}
}