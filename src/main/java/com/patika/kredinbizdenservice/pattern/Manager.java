package com.patika.kredinbizdenservice.pattern;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.patika.kredinbizdenservice.enums.SectorType;
import com.patika.kredinbizdenservice.model.Application;
import com.patika.kredinbizdenservice.model.Bank;
import com.patika.kredinbizdenservice.model.Campaign;
import com.patika.kredinbizdenservice.model.ConsumerLoan;
import com.patika.kredinbizdenservice.model.CreditCard;
import com.patika.kredinbizdenservice.model.HouseLoan;
import com.patika.kredinbizdenservice.model.Loan;
import com.patika.kredinbizdenservice.model.Product;
import com.patika.kredinbizdenservice.model.User;
import com.patika.kredinbizdenservice.model.VechileLoan;


public class Manager {
	
	private static Manager manager;

    private Manager() {}

    public static Manager getManager() {
        if (manager == null) {
        	manager = new Manager();
        }
        return manager;
    }

	public Bank createBank(String name) {
		return new Bank(name);
	}

	public User createUser(String name, String surname, LocalDate birthDate, String email, 
			String password, String phoneNumber, Boolean isActive) {
		return new User(name, surname, birthDate, email, password, phoneNumber, isActive);
	}
	
	public User createUser(String name, String surname, String email, String password, 
			String phoneNumber, Boolean isActive) {
		return new User(name, surname, email, password, phoneNumber, isActive);
	}

	public Campaign createCampaign(String title, String content, LocalDate dueDate, 
			LocalDate createDate, LocalDate updateDate, SectorType sector) {
		return new Campaign(title, content, dueDate, createDate, updateDate, sector);
	}

	public Product createCreditCard(BigDecimal fee, List<Campaign> campaignList) {
		return new CreditCard(fee, campaignList);
	}
	
	public Application createApplication() {return new Application();
	}
	
	public Application createApplication(CreditCard creditCard, User user, LocalDateTime localDateTime) {
		return new Application(creditCard, user, localDateTime);
	}
	
	public Application createApplication(Product product, User user, LocalDateTime localDateTime) {
		return new Application(product, user, localDateTime);
	}
	
	public Application createApplication(Loan loan, User user, LocalDateTime localDateTime) {
		return new Application(loan, user, localDateTime);
	}
	
	public Loan createConsumerLoan(){return new ConsumerLoan();}
	
	public Loan createConsumerLoan(BigDecimal amount, Integer installment, Double interestRate) {
		return new ConsumerLoan(amount, installment, interestRate);
	}
	
	public Loan createVehicleLoan(){return new VechileLoan();}

	public Loan createVehicleLoan(BigDecimal amount, Integer installment, Double interestRate) {
		return new VechileLoan(amount, installment, interestRate);
	}
	
	public Loan createHouseLoan(){return new HouseLoan();}
	
	public Loan createHouseLoan(BigDecimal amount, Integer installment, Double interestRate) {
		return new HouseLoan(amount, installment, interestRate);
	}

}
