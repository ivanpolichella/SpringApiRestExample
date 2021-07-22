package com.ejemplo.springboot.app.productos.models.dao;

import org.springframework.data.repository.CrudRepository;
import com.ejemplo.springboot.app.model.Producto;

public interface ProductoDao extends CrudRepository<Producto, Long> {

}
