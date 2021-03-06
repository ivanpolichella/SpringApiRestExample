package com.ejemplo.springboot.app.item.models.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ejemplo.springboot.app.item.models.Item;
import com.ejemplo.springboot.app.model.Producto;
import com.ejemplo.springboot.app.item.models.dao.ItemDao;
import com.ejemplo.springboot.app.item.models.dao.ProductoDao;

@Service("serviceTemplate")
public class ItemServiceImpl implements ItemService {
	@Autowired
	private RestTemplate clienteRest;
	
	@Autowired
	private ItemDao itemDao;
	
	@Autowired
	private ProductoDao productoDao;
	
	@Override
	public List<Item> findAll() {
		List<Producto> productos = Arrays.asList(clienteRest.getForObject("http://localhost:8001/ver", Producto[].class));
		return productos.stream().map(p -> new Item(p,1)).collect(Collectors.toList());
	}
	
	@Override
	public List<Item> findAllAddedProducts() {
		List<Item> items = (List<Item>) itemDao.findAll(); 
		return items;
	}

	@Override
	public Item findById(Long id, Integer cantidad) {
		Map<String, String> pathVariables = new HashMap<String, String>();
		pathVariables.put("id", id.toString());
		Producto producto = clienteRest.getForObject("http://localhost:8001/ver/{id}", Producto.class,pathVariables);
		return new Item(producto, cantidad);
	}

	@Override
	public Item addProduct(Long id, Integer cant) {
		Item item = this.findById(id, cant);
		this.productoDao.save(item.getProducto());
		return this.itemDao.save(item);
		
	}
}
