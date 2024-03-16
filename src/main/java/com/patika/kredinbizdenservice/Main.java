package com.patika.kredinbizdenservice;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

import com.patika.kredinbizdenservice.model.Application;
import com.patika.kredinbizdenservice.model.ApplicationOperation;
import com.patika.kredinbizdenservice.model.ConsumerLoan;
import com.patika.kredinbizdenservice.model.CreditCard;
import com.patika.kredinbizdenservice.model.User;
import com.patika.kredinbizdenservice.model.VechileLoan;

public class Main {

	public static void main(String[] args) {
		//aynı mail ile user yaratamıyoruz. user2 yaratilmayacak.
		User user1 = new User("Onur Altug", "Akca", LocalDate.of(1999, Month.MARCH, 15), 
				"onur7altug@gmail.com", "1234", "05363544235", true);
		User user2 = new User("Ozan", "Akca", LocalDate.of(1994, Month.MARCH, 15), 
				"onur7altug@gmail.com", "1234", "05362341198", true);
		User user3 = new User("Ozan", "Akca", LocalDate.of(1994, Month.JUNE, 30), 
				"ozanakca@gmail.com", "1234", "05362341198", true);

		System.out.println();
		
		Application application1 = new Application(new ConsumerLoan(BigDecimal.valueOf(3.3), 10, 10.2),
				user1, LocalDateTime.now());
		Application application2 = new Application(new ConsumerLoan(BigDecimal.valueOf(7.3), 6, 5.6),
				user1, LocalDateTime.of(2023, 2, 20, 15, 30));
		Application application3 = new Application(new VechileLoan(BigDecimal.valueOf(22.3), 8, 4.8),
				user3, LocalDateTime.of(2024, 3, 16, 18, 20));
		
		
		System.out.println("password hashlendi. user1'in hashlenmiş passwordu:");
		System.out.println(user1.getPassword());
		System.out.println();
		
		System.out.println("En çok başvury yapan kullanıcı:");
		System.out.println(ApplicationOperation.findUserWithMostApplications());
		System.out.println();
		
		System.out.println("En yüksek kredi isteyen kullanıcı ve istediği tutar:");
		ApplicationOperation.findMaxLoan();
		System.out.println();
		
		System.out.println("Son 30 gün içersinde yapılan başvurular:");
		ApplicationOperation.applicationsMadeLastMonth();
		System.out.println();
		
		System.out.println("onur7altug@gmail.com mailine sahip kullanıcının başvuruları:");
		ApplicationOperation.applicationsOfUserWithEmail("onur7altug@gmail.com");
		
	}

}
