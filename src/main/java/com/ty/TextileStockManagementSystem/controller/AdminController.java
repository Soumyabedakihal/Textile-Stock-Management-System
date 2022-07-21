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

import com.ty.TextileStockManagementSystem.dto.Admin;
import com.ty.TextileStockManagementSystem.dto.ResponseStructure;
import com.ty.TextileStockManagementSystem.service.AdminService;

@RestController
public class AdminController {
	@Autowired
	AdminService adminService;

	@PostMapping("/admin")
	public ResponseStructure<Admin> saveAdmin(@RequestBody Admin admin) {
		return adminService.saveAdmin(admin);
	}
	
	@GetMapping("/admin/{id}")
	public ResponseStructure<Admin> getAdminById(@PathVariable int id) {
		return adminService.getAdminById(id);
	}

	@PutMapping("/admin")
	public ResponseStructure<Admin> updateAdmin(@RequestParam int id, @RequestBody Admin admin) {
		return adminService.updateAdmin(id, admin);
	}

	@DeleteMapping("/admin/{id}")
	public ResponseStructure<String> deleteAdmin(@PathVariable int id) {
		return adminService.deleteAdmin(id);
	}
}
