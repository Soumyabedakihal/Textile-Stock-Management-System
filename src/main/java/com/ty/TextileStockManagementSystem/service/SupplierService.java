package com.ty.TextileStockManagementSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ty.TextileStockManagementSystem.dao.SupplierDao;
import com.ty.TextileStockManagementSystem.dao.WarehouseDao;
import com.ty.TextileStockManagementSystem.dto.ResponseStructure;
import com.ty.TextileStockManagementSystem.dto.Supplier;
import com.ty.TextileStockManagementSystem.dto.Warehouse;
import com.ty.TextileStockManagementSystem.exception.NoIdFoundException;

@Service
public class SupplierService {
	
	@Autowired
	private SupplierDao supplierDao;
	
	@Autowired
	private WarehouseDao warehouseDao;
	
	ResponseStructure<Supplier> responseStructure=new ResponseStructure<Supplier>();
	
	public ResponseStructure<Supplier> saveSupplier(int warehouse_id,Supplier supplier){
		Warehouse warehouse=warehouseDao.getWarehouseById(warehouse_id);
		supplier.setWarehouse(warehouse);
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("success");
		responseStructure.setData(supplierDao.saveSupplier(supplier));
		return responseStructure;
	}
	
	public ResponseStructure<Supplier> getSupplierById(int id) {
		Supplier supplier=supplierDao.getSupplierById(id);
		if(supplier!=null) {
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("success");
		responseStructure.setData(supplier);
		return responseStructure;
		}
		throw new NoIdFoundException("Supplier id " + supplier.getId() + " not found");
	}
	
	public ResponseStructure<List<Supplier>> getAllSupplier(){
			ResponseStructure<List<Supplier>> responseStructure = new ResponseStructure<List<Supplier>>();
			List<Supplier> list = supplierDao.getAllSupplier();
			if (!list.isEmpty()) {
				responseStructure.setStatusCode(HttpStatus.OK.value());
				responseStructure.setMessage("Found Something");
				responseStructure.setData(list);
				return responseStructure;
			}
			throw new NoIdFoundException("no data found");
	}
	
	public ResponseStructure<Supplier> updateSupplier(int id,Supplier supplier) {
			Supplier supplier1 = supplierDao.updateSupplier(id,supplier);
			if (supplier1 != null) {
				responseStructure.setStatusCode(HttpStatus.OK.value());
				responseStructure.setMessage("Found And Updated");
				responseStructure.setData(supplier);
				return responseStructure;
			}
			throw new NoIdFoundException("Supplier Request id " + supplier1.getId() + " not found");
		}
	
	public ResponseStructure<String> deleteSupplier(int id) {
		String supplier = supplierDao.deleteSupplier(id);
		ResponseStructure<String> responseStructure = new ResponseStructure<String>();
		if (supplier.equals("Supplier request deleted")) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Success");
			responseStructure.setData(supplier);
			return responseStructure;
		}
		throw new NoIdFoundException("SupplierRequest id " + id + " not found");
	}
}
