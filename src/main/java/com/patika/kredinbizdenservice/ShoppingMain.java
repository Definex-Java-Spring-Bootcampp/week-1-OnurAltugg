package com.patika.kredinbizdenservice;

import com.patika.kredinbizdenservice.enums.Category;
import com.patika.kredinbizdenservice.shopping.Customer;
import com.patika.kredinbizdenservice.shopping.Order;
import com.patika.kredinbizdenservice.shopping.Product;

public class ShoppingMain {

	public static void main(String[] args) {
		Customer customer1 = new Customer("Onur", "Akca", "onurakca@gmail.com", "2134", "05363544235", 24, true);
		Customer customer2 = new Customer("Altug", "Akca", "altugakca@gmail.com", "1234", "052635544123", 30, true);
		Customer customer3 = new Customer("Cem", "Tahin", "cemtahin@gmail.com", "3434", "05343311229", 27, true);
		
		Product product1 = new Product("TV", Category.ELECTRONICS, 20000.0, 100);
		Product product2 = new Product("Bench Press", Category.SPORTS, 8500.0, 20);
		Product product3 = new Product("Chair", Category.FURNITURE, 850.99, 70);
		
		Order orderOfCustomer1 = new Order();
		orderOfCustomer1.addProduct(product1);
		orderOfCustomer1.addProduct(product2);
		orderOfCustomer1.addProduct(product3);
		orderOfCustomer1.generateBill();
		customer1.addOrder(orderOfCustomer1);
		
		Order orderOfCustomer2 = new Order();
		orderOfCustomer2.addProduct(product1);
		orderOfCustomer2.addProduct(product2);
		orderOfCustomer2.generateBill();
		customer2.addOrder(orderOfCustomer2);
		
		Order orderOfCustomer3 = new Order();
		orderOfCustomer3.addProduct(product2);
		orderOfCustomer3.addProduct(product3);
		orderOfCustomer3.generateBill();
		customer3.addOrder(orderOfCustomer3);

		
		System.out.println("Sistemdeki müşteri sayısı: " + Customer.getCustomers().size() + "\n");
		
		int customerTotalProductCount = Customer.getCustomers().stream()
			    .filter(customer -> customer.getName().equals("Cem"))
			    .flatMap(customer -> customer.getOrders().stream())
			    .mapToInt(order -> order.getProducts().size())
			    .sum();
		System.out.println("Cem adlı müşterinin aldığı ürün sayısı: " + customerTotalProductCount + "\n");
		
		
		double customerShoppingCost = Customer.getCustomers().stream()
				.filter(customer -> customer.getName().equals("Cem") && customer.getAge() < 30 
						&& customer.getAge() > 25)
				.flatMap(customer -> customer.getOrders().stream())
				.mapToDouble(order -> order.getBill().getTotalAmount())
			    .sum();
		System.out.println("Cem adlı müşterinin alışveriş tutarı: " + customerShoppingCost + " TL\n");
		
		System.out.println("1500 TL üzeri faturalar:");
		Customer.getCustomers().stream()
	    .flatMap(customer -> customer.getOrders().stream())
	    .filter(order -> order.getBill().getTotalAmount() > 1500)
	    .map(Order::getBill)
	    .forEach(System.out::println);
	}
}
