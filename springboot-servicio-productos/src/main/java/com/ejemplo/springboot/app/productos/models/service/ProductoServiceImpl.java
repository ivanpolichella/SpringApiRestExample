package com.ejemplo.springboot.app.productos.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ejemplo.springboot.app.productos.models.dao.ProductoDao;
import com.ejemplo.springboot.app.model.Producto;

@Service
public class ProductoServiceImpl implements IProductoService{
	@Autowired
	private ProductoDao productoDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Producto> findAll() {
		return (List<Producto>) productoDao.findAll();
	}

	@Override
	public Producto findById(Long id) {	
		return productoDao.findById(id).orElse(null);
	}

}
