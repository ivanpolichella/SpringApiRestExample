package com.ejemplo.springboot.app.item.models.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejemplo.springboot.app.item.clientes.ProductoClienteRest;
import com.ejemplo.springboot.app.item.models.Item;
import com.ejemplo.springboot.app.item.models.dao.ItemDao;
import com.ejemplo.springboot.app.item.models.dao.ProductoDao;

@Service("serviceFeing")
public class ItemServiceFeing implements ItemService {
	@Autowired
	private ProductoClienteRest clienteFeign;
	
	@Autowired
	private ItemDao itemDao;
	
	@Autowired
	private ProductoDao productoDao;
	
	
	@Override
	public List<Item> findAll() {
		return clienteFeign.listar().stream().map(p -> new Item(p,1)).collect(Collectors.toList());
	}

	@Override
	public Item findById(Long id, Integer cantidad) {
		return new Item(clienteFeign.detalle(id), cantidad);
	}
	
	@Override
	public Item addProduct(Long id, Integer cant) {
		Item item = this.findById(id, cant);
		item.setProducto(this.productoDao.save(item.getProducto()));
		return this.itemDao.save(item);
	}

	@Override
	public List<Item> findAllAddedProducts() {
		List<Item> items = (List<Item>) itemDao.findAll(); 
		return items;
	}
}
