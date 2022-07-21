package com.ty.TextileStockManagementSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ty.TextileStockManagementSystem.dao.AdminDao;
import com.ty.TextileStockManagementSystem.dao.WarehouseDao;
import com.ty.TextileStockManagementSystem.dto.Admin;
import com.ty.TextileStockManagementSystem.dto.ResponseStructure;
import com.ty.TextileStockManagementSystem.dto.Warehouse;
import com.ty.TextileStockManagementSystem.exception.NoIdFoundException;

@Service
public class WarehouseService {
	@Autowired
	private WarehouseDao warehouseDao;
	
	@Autowired
	private AdminDao adminDao;
	
	ResponseStructure<Warehouse> responseStructure=new ResponseStructure<Warehouse>();
	
	public ResponseStructure<Warehouse> saveWarehouse(int id, Warehouse warehouse){
		Admin admin=adminDao.getAdminById(id);
		warehouse.setAdmin(admin);
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("success");
		responseStructure.setData(warehouseDao.saveWarehouse(warehouse));
		return responseStructure;
	}
	
	public ResponseStructure<Warehouse> getWarehouseById(int id) {
		Warehouse warehouse=warehouseDao.getWarehouseById(id);
		if(warehouse!=null) {
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("success");
		responseStructure.setData(warehouse);
		return responseStructure;
		}
		throw new NoIdFoundException("Warehouse id " + warehouse.getWarehouse_id() + " not found");
	}
	
//	public ResponseStructure<List<Warehouse>> getAllWarehouse(){
//			ResponseStructure<List<Warehouse>> responseStructure = new ResponseStructure<List<Warehouse>>();
//			List<Warehouse> list = warehouseDao.getAllWarehouse();
//			if (!list.isEmpty()) {
//				responseStructure.setStatusCode(HttpStatus.OK.value());
//				responseStructure.setMessage("Found Something");
//				responseStructure.setData(list);
//				return responseStructure;
//			}
//			throw new NoIdFoundException("no data found");
//	}
	
	public ResponseStructure<Warehouse> updateWarehouse(int id,Warehouse warehouse) {
			Warehouse warehouse1 = warehouseDao.updateWarehouse(id,warehouse);
			if (warehouse1 != null) {
				responseStructure.setStatusCode(HttpStatus.OK.value());
				responseStructure.setMessage("Found And Updated");
				responseStructure.setData(warehouse);
				return responseStructure;
			}
			throw new NoIdFoundException("Warehouse Request id " + warehouse1.getWarehouse_id() + " not found");
		}
	
	public ResponseStructure<String> deleteWarehouse(int id) {
		String warehouse = warehouseDao.deleteWarehouse(id);
		ResponseStructure<String> responseStructure = new ResponseStructure<String>();
		if (warehouse.equals("Warehouse request deleted")) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Success");
			responseStructure.setData(warehouse);
			return responseStructure;
		}
		throw new NoIdFoundException("WarehouseRequest id " + id + " not found");
	}
}
