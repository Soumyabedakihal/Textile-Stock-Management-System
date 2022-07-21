package com.ty.TextileStockManagementSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ty.TextileStockManagementSystem.dao.ShopDao;
import com.ty.TextileStockManagementSystem.dao.WarehouseDao;
import com.ty.TextileStockManagementSystem.dto.Shop;
import com.ty.TextileStockManagementSystem.dto.Warehouse;
import com.ty.TextileStockManagementSystem.dto.ResponseStructure;
import com.ty.TextileStockManagementSystem.exception.NoIdFoundException;

@Service
public class ShopService {
	@Autowired
	private ShopDao shopDao;
	
	@Autowired
	private WarehouseDao warehouseDao;
	
	ResponseStructure<Shop> responseStructure=new ResponseStructure<Shop>();
	
	public ResponseStructure<Shop> saveShop(int warehouse_id,Shop shop){
		Warehouse warehouse=warehouseDao.getWarehouseById(warehouse_id);
		shop.setWarehouse(warehouse);
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("success");
		responseStructure.setData(shopDao.saveShop(shop));
		return responseStructure;
	}
	
	public ResponseStructure<Shop> getShopById(int id) {
		Shop shop=shopDao.getShopById(id);
		if(shop!=null) {
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("success");
		responseStructure.setData(shop);
		return responseStructure;
		}
		throw new NoIdFoundException("Shop id " + shop.getShop_id() + " not found");
	}
	
	public ResponseStructure<List<Shop>> getAllShop(){
			ResponseStructure<List<Shop>> responseStructure = new ResponseStructure<List<Shop>>();
			List<Shop> list = shopDao.getAllShop();
			if (!list.isEmpty()) {
				responseStructure.setStatusCode(HttpStatus.OK.value());
				responseStructure.setMessage("Found Something");
				responseStructure.setData(list);
				return responseStructure;
			}
			throw new NoIdFoundException("no data found");
	}
	
	public ResponseStructure<Shop> updateShop(int id,Shop shop) {
			Shop shop1 = shopDao.updateShop(id,shop);
			if (shop1 != null) {
				responseStructure.setStatusCode(HttpStatus.OK.value());
				responseStructure.setMessage("Found And Updated");
				responseStructure.setData(shop);
				return responseStructure;
			}
			throw new NoIdFoundException("Shop Request id " + shop1.getShop_id() + " not found");
		}
	
	public ResponseStructure<String> deleteShop(int id) {
		String shop = shopDao.deleteShop(id);
		ResponseStructure<String> responseStructure = new ResponseStructure<String>();
		if (shop.equals("Shop request deleted")) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Success");
			responseStructure.setData(shop);
			return responseStructure;
		}
		throw new NoIdFoundException("ShopRequest id " + id + " not found");
	}
	
	
}
