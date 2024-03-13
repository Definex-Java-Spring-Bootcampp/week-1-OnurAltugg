package com.patika.kredinbizdenservice.model;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class User {

    private String name;
    private String surname;
    private LocalDate birthDate;
    private String email; //bir email ile bir kere kayıt olunabilir.
    private String password; //hash fonskiyonlarından biri ile hashlanecek.
    private String phoneNumber;
    private Boolean isActive;
    private List<Application> applicationList;

    public User(String name, String surname, LocalDate birthDate, String email, String password, String phoneNumber, Boolean isActive) {
        if(!UserRepository.isEmailAlreadyExists(email)) {
        	this.name = name;
            this.surname = surname;
            this.birthDate = birthDate;
            this.email = email;
            this.password = shaHashCode(password);
            this.phoneNumber = phoneNumber;
            this.isActive = isActive;
            UserRepository.saveUser(this);
        }
        else {
        	System.out.println("Bu e-posta adresi zaten kayıtlı!");
        }
    }

    public User(String name, String surname, String email, String password, String phoneNumber, Boolean isActive) {
    	if(!UserRepository.isEmailAlreadyExists(email)) {
        	this.name = name;
            this.surname = surname;
            this.email = email;
            this.password = shaHashCode(password);
            this.phoneNumber = phoneNumber;
            this.isActive = isActive;
            UserRepository.saveUser(this);
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

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public List<Application> getApplicationList() {
        return applicationList;
    }

    public void setApplicationList(List<Application> applicationList) {
        this.applicationList = applicationList;
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
  
}
