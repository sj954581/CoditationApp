package com.CoditationApp.CoditationApp.dao;

import org.springframework.data.repository.CrudRepository;

import com.CoditationApp.CoditationApp.model.Product;

public interface ProductDao extends CrudRepository<Product, Integer>{

}