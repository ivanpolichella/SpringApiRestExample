package com.ejemplo.springboot.app.item.models.service;

import java.util.List;

import com.ejemplo.springboot.app.item.models.Item;

public interface ItemService {
	
	public List<Item> findAll();
	public Item findById(Long id, Integer cantidad);
	public Item addProduct(Long id, Integer cant);
	public List<Item> findAllAddedProducts();
}
