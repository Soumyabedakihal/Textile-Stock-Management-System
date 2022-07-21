package com.ty.TextileStockManagementSystem.dto;

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
	private int reorder_level;
	
	@JoinColumn
	@OneToOne
	private Admin admin;
	
	@OneToMany(mappedBy="warehouse")
	private List<Supplier> supplier;
	
	@OneToMany(mappedBy="warehouse")
	private List<Shop> shop;
	
	public int getWarehouse_id() {
		return warehouse_id;
	}
	public void setWarehouse_id(int warehouse_id) {
		this.warehouse_id = warehouse_id;
	}
	public List<Supplier> getSupplier() {
		return supplier;
	}
	public void setSupplier(List<Supplier> supplier) {
		this.supplier = supplier;
	}
	public List<Shop> getShop() {
		return shop;
	}
	public void setShop(List<Shop> shop) {
		this.shop = shop;
	}
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
	public int getReorder_level() {
		return reorder_level;
	}
	public void setReorder_level(int reorder_level) {
		this.reorder_level = reorder_level;
	}
	
}
