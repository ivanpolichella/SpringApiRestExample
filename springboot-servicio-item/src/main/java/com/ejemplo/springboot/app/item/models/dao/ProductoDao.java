package com.ejemplo.springboot.app.item.models.dao;

import org.springframework.data.repository.CrudRepository;
import com.ejemplo.springboot.app.model.Producto;

public interface ProductoDao extends CrudRepository<Producto,Long> {

}
