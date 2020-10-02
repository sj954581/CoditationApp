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
@Table(name = "category")
public class Category {
	
	public Category() {}
	
	public Category(int id,String name,String type) {

		this.id = id;
		this.name = name;
		this.type = type;
	}
	
	@Id
	@GeneratedValue
	public int id;
	
	@Column(name="name")
	public String name;
	
	@Column(name="type")
	public String type;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "{Categoryid=" + id + ", name=" + name + ", type=" + type + "}";
	}
}