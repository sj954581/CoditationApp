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
@Table(name = "childsubcategory")
public class ChildSubCategory {
	
	public ChildSubCategory() {}
	
	public ChildSubCategory(int primaryid,int id,int childcategoryid,String name,String type) {

		this.primaryid = primaryid;
		this.id = id;
		this.childcategoryid = childcategoryid;
		this.name = name;
		this.type = type;
	}
	
	@Id
	@GeneratedValue
	public int primaryid;
	
	@Column(name="id")
	public int id;
	
	@Column(name="childcategoryid")
	public int childcategoryid;
	
	@Column(name="name")
	public String name;
	
	@Column(name="type")
	public String type;
	
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
	
	public int getChildcategoryid() {
		return childcategoryid;
	}
	
	public void setChildcategoryid(int childcategoryid) {
		this.childcategoryid = childcategoryid;
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
		return " {ChildSubCategoryid=" + id + ", childcategoryid=" + childcategoryid
				+ ", name=" + name + ", type=" + type + "}";
	}
}