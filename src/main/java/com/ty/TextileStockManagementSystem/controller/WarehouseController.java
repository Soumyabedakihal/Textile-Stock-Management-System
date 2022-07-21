package com.ty.TextileStockManagementSystem.controller;

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
import com.ty.TextileStockManagementSystem.dto.Warehouse;
import com.ty.TextileStockManagementSystem.service.WarehouseService;

@RestController
public class WarehouseController {

	@Autowired
	WarehouseService warehouseService;

	@PostMapping("/warehouse")
	public ResponseStructure<Warehouse> saveWareHouse(@RequestParam int id, @RequestBody Warehouse warehouse) {
		return warehouseService.saveWarehouse(id,warehouse);
	}

	@GetMapping("/warehouse/{id}")
	public ResponseStructure<Warehouse> getWarehouseById(@PathVariable int id) {
		return warehouseService.getWarehouseById(id);
	}

	@PutMapping("/warehouse")
	public ResponseStructure<Warehouse> updateWarehouse(@RequestParam int id, @RequestBody Warehouse warehouse) {
		return warehouseService.updateWarehouse(id, warehouse);
	}

	@DeleteMapping("warehouse/{id}")
	public ResponseStructure<String> deleteWarehouse(@PathVariable int id) {
		return warehouseService.deleteWarehouse(id);
	}
}
