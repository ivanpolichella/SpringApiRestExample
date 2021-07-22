package com.ejemplo.springboot.app.productos.models.service;

import java.util.List;

import com.ejemplo.springboot.app.model.Producto;

public interface IProductoService {
	
	public List<Producto> findAll();
	public Producto findById(Long id);
	
}
