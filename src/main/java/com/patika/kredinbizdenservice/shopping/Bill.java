package com.patika.kredinbizdenservice.shopping;

import java.util.List;

public class Bill {
	
	private List<Product> products;
    private double totalAmount;

	public Bill(List<Product> products) {
        this.products = products;
        this.totalAmount = calculateTotalAmount();
    }

    private double calculateTotalAmount() {
        double total = 0;
        for (Product product : products) {
            total += product.getPrice();
        }
        return total;
    }
    
    public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

}
