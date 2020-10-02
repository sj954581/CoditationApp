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
@Table(name = "childcategory")
public class ChildCategory {
	
	public ChildCategory() {}
	
	public ChildCategory(int primaryid,int id,int categoryid,String name,String type) {

		this.primaryid = primaryid;
		this.id = id;
		this.categoryid = categoryid;
		this.name = name;
		this.type = type;
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
	
	@Column(name="type")
	public String type;
	
	public int getId() {
		return id;
	}
	
	public int getPrimaryid() {
		return primaryid;
	}
	
	public void setPrimaryid(int primaryid) {
		this.primaryid = primaryid;
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
		return "{ChildCategoryid=" + id + ", categoryid=" + categoryid + ", name=" + name
				+ ", type=" + type + "}";
	}
}