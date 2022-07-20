package com.ty.TextileStockManagementSystem.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.TextileStockManagementSystem.dto.Warehouse;
import com.ty.TextileStockManagementSystem.repository.WarehouseRepository;

@Repository
public class WarehouseDao {
	@Autowired
	WarehouseRepository warehouseRepository;
	
	public Warehouse saveWarehouse(Warehouse warehouse) {
		return warehouseRepository.save(warehouse);
	}
	
	public Warehouse getWarehouseById(int id) {
		Optional<Warehouse> opt=warehouseRepository.findById(id);
		if(opt.isEmpty()) {
			return null;
		}else {
			return opt.get();
		}
	}
	
	public List<Warehouse> getAllWarehouse(){
		return warehouseRepository.findAll();
	}
	
	public Warehouse updateWarehouse(int id,Warehouse warehouse) {
		Optional<Warehouse> opt=warehouseRepository.findById(id);
		if(opt.isEmpty()) {
			return null;
		}else {
			return warehouseRepository.save(warehouse);
		}
	}
	
	public String deleteWarehouse(int id) {
		Optional<Warehouse> opt=warehouseRepository.findById(id);
		if(opt.isEmpty()) {
			return null;
		}else {
			warehouseRepository.deleteById(id);
			return "Not Found";
		}
	}
}
