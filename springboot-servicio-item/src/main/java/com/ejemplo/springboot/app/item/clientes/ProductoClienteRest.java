package com.ejemplo.springboot.app.item.clientes;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ejemplo.springboot.app.item.models.Item;
import com.ejemplo.springboot.app.model.Producto;

@FeignClient(name = "servicio-producto", url="localhost:8001")
public interface ProductoClienteRest {
	
	@GetMapping("/ver")
	public List<Producto> listar();
	
	@GetMapping("/ver/{id}")
	public Producto detalle(@PathVariable Long id);
	
	@PostMapping("agregar/{item}/cantidad/{cant}")
	public Item save(@PathVariable Long item, @PathVariable Integer cant);
}
