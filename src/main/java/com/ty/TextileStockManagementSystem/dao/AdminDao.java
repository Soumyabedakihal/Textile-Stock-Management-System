package com.ty.TextileStockManagementSystem.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.TextileStockManagementSystem.dto.Admin;
import com.ty.TextileStockManagementSystem.repository.AdminRepository;

@Repository
public class AdminDao {
	
	@Autowired
	AdminRepository adminRepository;
	
	public Admin saveAdmin(Admin admin) {
		return adminRepository.save(admin);
	}
	
	public Admin getAdminById(int id) {
		Optional<Admin> opt=adminRepository.findById(id);
		if(opt.isEmpty()) {
			return null;
		}else {
			return opt.get();
		}
	}
	
	public Admin updateAdmin(int id,Admin admin) {
		Optional<Admin> opt=adminRepository.findById(id);
		if(opt.isEmpty()) {
			return null;
		}else {
			return adminRepository.save(admin);
		}
	}
	
	public String deleteAdmin(int id) {
		Optional<Admin> opt=adminRepository.findById(id);
		if(opt.isEmpty()) {
			return null;
		}else {
			adminRepository.deleteById(id);
			return "Not Found";
		}
	}
	
}
