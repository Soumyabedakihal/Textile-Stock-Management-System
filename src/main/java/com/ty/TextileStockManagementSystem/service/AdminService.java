package com.ty.TextileStockManagementSystem.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ty.TextileStockManagementSystem.dao.AdminDao;
import com.ty.TextileStockManagementSystem.dto.Admin;
import com.ty.TextileStockManagementSystem.dto.ResponseStructure;
import com.ty.TextileStockManagementSystem.exception.NoIdFoundException;

@Service
public class AdminService {
	@Autowired
	private AdminDao adminDao;
	
	ResponseStructure<Admin> responseStructure=new ResponseStructure<Admin>();
	
	public ResponseStructure<Admin> saveAdmin(Admin admin){
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("success");
		responseStructure.setData(adminDao.saveAdmin(admin));
		return responseStructure;
	}
	
	public ResponseStructure<Admin> getAdminById(int id) {
		Admin admin=adminDao.getAdminById(id);
		if(admin!=null) {
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("success");
		responseStructure.setData(admin);
		return responseStructure;
		}
		throw new NoIdFoundException("Admin id " + id + " not found");
	}
	
//	public ResponseStructure<List<Admin>> getAllAdmin(){
//			ResponseStructure<List<Admin>> responseStructure = new ResponseStructure<List<Admin>>();
//			List<Admin> list = adminDao.getAllAdmin();
//			if (!list.isEmpty()) {
//				responseStructure.setStatusCode(HttpStatus.OK.value());
//				responseStructure.setMessage("Found Something");
//				responseStructure.setData(list);
//				return responseStructure;
//			}
//			throw new NoIdFoundException("no data found");
//	}
	
	public ResponseStructure<Admin> updateAdmin(int id,Admin admin) {
			Admin admin1 = adminDao.updateAdmin(id,admin);
			if (admin1 != null) {
				responseStructure.setStatusCode(HttpStatus.OK.value());
				responseStructure.setMessage("Found And Updated");
				responseStructure.setData(admin);
				return responseStructure;
			}
			throw new NoIdFoundException("Admin Request id " + admin1.getId() + " not found");
		}
	
	public ResponseStructure<String> deleteAdmin(int id) {
		String admin = adminDao.deleteAdmin(id);
		ResponseStructure<String> responseStructure = new ResponseStructure<String>();
		if (admin.equals("Admin request deleted")) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Success");
			responseStructure.setData(admin);
			return responseStructure;
		}
		throw new NoIdFoundException("AdminRequest id " + id + " not found");
	}
}
