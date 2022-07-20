package com.ty.TextileStockManagementSystem.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.TextileStockManagementSystem.dto.Shop;
import com.ty.TextileStockManagementSystem.repository.ShopRepository;

@Repository
public class ShopDao {
	
		@Autowired
		ShopRepository shopRepository;
		
		public Shop saveShop(Shop shop) {
			return shopRepository.save(shop);
		}
		
		public Shop getShopById(int id) {
			Optional<Shop> opt=shopRepository.findById(id);
			if(opt.isEmpty()) {
				return null;
			}else {
				return opt.get();
			}
		}
		
		public List<Shop> getAllShop(){
			return shopRepository.findAll();
		}
		
		public Shop updateShop(int id,Shop shop) {
			Optional<Shop> opt=shopRepository.findById(id);
			if(opt.isEmpty()) {
				return null;
			}else {
				return shopRepository.save(shop);
			}
		}
		
		public String deleteShop(int id) {
			Optional<Shop> opt=shopRepository.findById(id);
			if(opt.isEmpty()) {
				return null;
			}else {
				shopRepository.deleteById(id);
				return "Not Found";
			}
		}
}
