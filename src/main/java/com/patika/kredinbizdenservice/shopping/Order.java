package com.patika.kredinbizdenservice.shopping;

import java.util.ArrayList;
import java.util.List;

public class Order {
	
	private List<Product> products;
    private Bill bill;

    public Order() {
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void generateBill() {
        this.bill = new Bill(products);
    }

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Bill getBill() {
		return bill;
	}

	public void setBill(Bill bill) {
		this.bill = bill;
	}
    
}
