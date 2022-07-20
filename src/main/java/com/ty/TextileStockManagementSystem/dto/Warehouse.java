package com.ty.TextileStockManagementSystem.dto;

import java.nio.MappedByteBuffer;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Warehouse {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int warehouse_id;
	private String Product;
	private double cost;
	private int quantity;
	private int recorder_level;
	
	@JoinColumn
	@OneToOne
	private Admin admin;
	
	@OneToMany(mappedBy="warehouse")
	private List<Supplier> supplier;
	
	@OneToMany(mappedBy="warehouse")
	private List<Shop> shop;
	
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	public String getProduct() {
		return Product;
	}
	public void setProduct(String product) {
		Product = product;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getRecorder_level() {
		return recorder_level;
	}
	public void setRecorder_level(int recorder_level) {
		this.recorder_level = recorder_level;
	}
	
}
