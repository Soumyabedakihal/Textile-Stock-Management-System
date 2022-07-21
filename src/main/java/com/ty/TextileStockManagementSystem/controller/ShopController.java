package com.ty.TextileStockManagementSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.TextileStockManagementSystem.dto.ResponseStructure;
import com.ty.TextileStockManagementSystem.dto.Shop;
import com.ty.TextileStockManagementSystem.service.ShopService;

@RestController
public class ShopController {
	@Autowired
	ShopService shopService;

	@PostMapping("/shop")
	public ResponseStructure<Shop> saveShop(@RequestParam int warehouse_id,@RequestBody Shop shop) {
		return shopService.saveShop(warehouse_id,shop);
	}

	@GetMapping("/shop")
	public ResponseStructure<List<Shop>> getAllShop() {
		return shopService.getAllShop();
	}

	@GetMapping("/shop/{id}")
	public ResponseStructure<Shop> getShopById(@PathVariable int id) {
		return shopService.getShopById(id);
	}

	@PutMapping("/shop")
	public ResponseStructure<Shop> updateShop(@RequestParam int id, @RequestBody Shop shop) {
		return shopService.updateShop(id, shop);
	}

	@DeleteMapping("/shop/{id}")
	public ResponseStructure<String> deleteShop(@PathVariable int id) {
		return shopService.deleteShop(id);
	}
	
}

