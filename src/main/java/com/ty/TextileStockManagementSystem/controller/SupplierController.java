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
import com.ty.TextileStockManagementSystem.dto.Supplier;
import com.ty.TextileStockManagementSystem.service.SupplierService;

@RestController
public class SupplierController {
	@Autowired
	SupplierService supplierService;

	@PostMapping("/supplier")
	public ResponseStructure<Supplier> saveSupplier(@RequestParam int warehouse_id,@RequestBody Supplier supplier) {
		return supplierService.saveSupplier(warehouse_id,supplier);
	}

	@GetMapping("/supplier")
	public ResponseStructure<List<Supplier>> getAllSupplier() {
		return supplierService.getAllSupplier();
	}

	@GetMapping("/supplier{id}")
	public ResponseStructure<Supplier> getSupplierById(@PathVariable int id) {
		return supplierService.getSupplierById(id);
	}

	@PutMapping("/supplier")
	public ResponseStructure<Supplier> updateSupplier(@RequestParam int id, @RequestBody Supplier supplier) {
		return supplierService.updateSupplier(id, supplier);
	}

	@DeleteMapping("/supplier/{id}")
	public ResponseStructure<String> deleteSupplier(@PathVariable int id) {
		return supplierService.deleteSupplier(id);
	}
}
