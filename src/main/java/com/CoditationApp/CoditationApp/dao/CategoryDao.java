package com.CoditationApp.CoditationApp.dao;

import org.springframework.data.repository.CrudRepository;

import com.CoditationApp.CoditationApp.model.Category;

public interface CategoryDao extends CrudRepository<Category, Integer>{

}