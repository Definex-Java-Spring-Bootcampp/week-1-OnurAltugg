package com.patika.kredinbizdenservice.shopping;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Customer {

    private String name;
    private String surname;
    private String email; 
    private String password; 
    private String phoneNumber;
    private Boolean isActive;
    private static final List<Customer> customers = new ArrayList<>();
    private List<Order> orders;

    public Customer(String name, String surname, String email, String password, String phoneNumber, Boolean isActive) {
    	if(isEmailAlreadyExists(email)) {
        	this.name = name;
            this.surname = surname;
            this.email = email;
            this.password = shaHashCode(password);
            this.phoneNumber = phoneNumber;
            this.isActive = isActive;
            this.setOrders(new ArrayList<>());
            customers.add(this);
        }
        else {
        	System.out.println("Bu e-posta adresi zaten kayıtlı!");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }
    
    public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	@Override
	public String toString() {
		return "Customer [name=" + name + ", surname=" + surname + ", email=" + email
				+ ", phoneNumber=" + phoneNumber + "]";
	}

	private String shaHashCode(String password) {
		try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            byte[] hashedBytes = md.digest(password.getBytes());

            StringBuilder hexStringBuilder = new StringBuilder();
            for (byte b : hashedBytes) {
                hexStringBuilder.append(String.format("%02x", b));
            }
            return hexStringBuilder.toString();
        } 
		catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Şifreleme hatası: " + e.getMessage());
        }
	}
	
	private boolean isEmailAlreadyExists(String email) {
        return customers.stream().anyMatch(user -> user.getEmail().equals(email));
    }
  
}

