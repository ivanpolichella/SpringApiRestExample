package com.ejemplo.springboot.app.item.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.ejemplo.springboot.app.item.models.Item;

public interface ItemDao extends CrudRepository<Item,Long> {

}
