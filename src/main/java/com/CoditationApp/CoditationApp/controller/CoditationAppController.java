package com.CoditationApp.CoditationApp.controller;

import java.util.List;
import java.util.Collection;
import java.lang.Iterable;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CoditationApp.CoditationApp.model.Category;
import com.CoditationApp.CoditationApp.model.ChildCategory;
import com.CoditationApp.CoditationApp.model.ChildSubCategory;
import com.CoditationApp.CoditationApp.model.Product;

import com.CoditationApp.CoditationApp.dao.CategoryDao;
import com.CoditationApp.CoditationApp.dao.ChildCategoryDao;
import com.CoditationApp.CoditationApp.dao.ChildSubCategoryDao;
import com.CoditationApp.CoditationApp.dao.ProductDao;

@RestController
public class CoditationAppController {
	
	@Autowired
	public CategoryDao categoryDao;
	
	@Autowired
	public ChildCategoryDao childCategoryDao;
	
	@Autowired
	public ChildSubCategoryDao childSubCategoryDao;
	
	@Autowired
	public ProductDao productDao;
	
	@RequestMapping(value="/test")
	public String testMethod() {
		return "Hello.. test API for CoditationApp got run";
	}
	
	@PostMapping("/saveCategory")
	public String saveCategory(@RequestBody Category category) {
		categoryDao.save(category);
		return "Category Saved : " + category.getId();
	}
	
	@PostMapping("/saveChildCategory")
	public String saveChildCategory(@RequestBody ChildCategory childCategory) {
		childCategoryDao.save(childCategory);
		return "Child Category Saved : " + childCategory.getId();
	}
	
	@PostMapping("/saveChildSubCategory")
	public String saveChildSubCategory(@RequestBody ChildSubCategory childSubCategory) {
		childSubCategoryDao.save(childSubCategory);
		return "Child Sub Category Saved : " + childSubCategory.getId();
	}
	
//	bellow API is for both Create/Update
	@PostMapping("/saveProduct")
	public String saveProduct(@RequestBody Product product) {
		productDao.save(product);
		return "Product Saved : " + product.getId();
	}
	
	@GetMapping("/getAllCategoryDetails")
	public JSONArray getAllCategoryDetails() {
		List<Category> myCustomList = (List<Category>) categoryDao.findAll();
		JSONArray jsonArrayResponce = new JSONArray();
		
		for (int i=0; i < myCustomList.size(); i++) {
			JSONArray jsonArray = new JSONArray();
		        jsonArray.put(myCustomList.get(i).toString());
		        
		        // Start Getting All Child catagories
		        List<ChildCategory> myCustomChildList = (List<ChildCategory>) childCategoryDao.findAll();
		        for (int j=0; j < myCustomChildList.size(); j++) {
		        	if(myCustomList.get(i).getId() == myCustomChildList.get(j).getCategoryid()) {
		        		JSONArray jsonChildCatagory = new JSONArray();
		        		jsonChildCatagory.put(myCustomChildList.get(j).toString());
		        		
		        		// Start Getting All Sub Child Catagories
		        		List<ChildSubCategory> myCustomChildSubList = (List<ChildSubCategory>) childSubCategoryDao.findAll();
		        		for (int k=0; k < myCustomChildSubList.size(); k++) {
		        			if(myCustomChildList.get(j).getId() == myCustomChildSubList.get(k).getChildcategoryid()) {
		        				jsonChildCatagory.put(myCustomChildSubList.get(k).toString());
		        			}
		        		}
		        		jsonArray.put(jsonChildCatagory);
		        	}
		        }
		        jsonArrayResponce.put(jsonArray);
		}
		return jsonArrayResponce;
	}
	
	@GetMapping("/getAllProductsByCategoryId/{categoryid}")
	public JSONArray getAllProductsByCategoryId(@PathVariable("categoryid") int categoryid ) {
		List<Product> myCustomList = (List<Product>) productDao.findAll();
		JSONArray jsonArrayResponce = new JSONArray();
		
		for(int i=0;i<myCustomList.size();i++) {
			if(myCustomList.get(i).getCategoryid() == categoryid) {
				jsonArrayResponce.put(myCustomList.get(i).toString());
			}
		}
		return jsonArrayResponce;
	}
	
}