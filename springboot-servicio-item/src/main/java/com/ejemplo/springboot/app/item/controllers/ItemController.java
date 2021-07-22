package com.ejemplo.springboot.app.item.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ejemplo.springboot.app.item.models.Item;
import com.ejemplo.springboot.app.item.models.service.ItemService;

@RestController
public class ItemController {
	
	@Autowired
	@Qualifier("serviceFeing")
	private  ItemService itemService;
	
	@GetMapping("/listar")
	public List<Item> listar(){
		return itemService.findAll();
	}
	
	@GetMapping("/listarAgregados")
	public List<Item> listarAgregados(){
		return itemService.findAllAddedProducts();
	}
	
	@GetMapping("/ver/{id}/cantidad/{cantidad}")
	public Item detalle(@PathVariable Long id, @PathVariable Integer cantidad) {
		return itemService.findById(id, cantidad);
	}
	
	@PostMapping("agregar/{item}/cantidad/{cant}")
	public Item save(@PathVariable Long item, @PathVariable Integer cant) {
		return itemService.addProduct(item, cant);
		
	}

}
