package com.ty.TextileStockManagementSystem.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.TextileStockManagementSystem.dto.Supplier;
import com.ty.TextileStockManagementSystem.repository.SupplierRepository;

@Repository
public class SupplierDao {
	@Autowired
	SupplierRepository supplierRepository;
	
	public Supplier saveSupplier(Supplier supplier) {
		return supplierRepository.save(supplier);
	}
	
	public Supplier getSupplierById(int id) {
		Optional<Supplier> opt=supplierRepository.findById(id);
		if(opt.isEmpty()) {
			return null;
		}else {
			return opt.get();
		}
	}
	
	public List<Supplier> getAllSupplier(){
		return supplierRepository.findAll();
	}
	
	public Supplier updateSupplier(int id,Supplier supplier) {
		Optional<Supplier> opt=supplierRepository.findById(id);
		if(opt.isEmpty()) {
			return null;
		}else {
			return supplierRepository.save(supplier);
		}
	}
	
	public String deleteSupplier(int id) {
		Optional<Supplier> opt=supplierRepository.findById(id);
		if(opt.isEmpty()) {
			return null;
		}else {
			supplierRepository.deleteById(id);
			return "Not Found";
		}
	}


}
