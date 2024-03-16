package com.patika.kredinbizdenservice;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import com.patika.kredinbizdenservice.enums.SectorType;
import com.patika.kredinbizdenservice.model.Application;
import com.patika.kredinbizdenservice.model.ApplicationOperation;
import com.patika.kredinbizdenservice.model.Bank;
import com.patika.kredinbizdenservice.model.Campaign;
import com.patika.kredinbizdenservice.model.ConsumerLoan;
import com.patika.kredinbizdenservice.model.CreditCard;
import com.patika.kredinbizdenservice.model.CreditCardOperation;
import com.patika.kredinbizdenservice.model.Product;
import com.patika.kredinbizdenservice.model.User;
import com.patika.kredinbizdenservice.model.VechileLoan;

public class Main {

	public static void main(String[] args) {
		Bank bank = new Bank("Akbank");
		
		//aynı mail ile user yaratamıyoruz. user2 yaratilmayacak.
		User user1 = new User("Onur Altug", "Akca", LocalDate.of(1999, Month.MARCH, 15), 
				"onur7altug@gmail.com", "1234", "05363544235", true);
		User user2 = new User("Ozan", "Akca", LocalDate.of(1994, Month.MARCH, 15), 
				"onur7altug@gmail.com", "1234", "05362341198", true);
		User user3 = new User("Ozan", "Akca", LocalDate.of(1994, Month.JUNE, 30), 
				"ozanakca@gmail.com", "1234", "05362341198", true);
		
		Campaign marketCampaign = new Campaign(
                "Market Kampanya",
                "Bu bir market kampanya içeriğidir.",
                LocalDate.of(2024, 4, 30), 
                LocalDate.of(2024, 3, 1),  
                LocalDate.of(2024, 3, 10), 
                SectorType.MARKET
        );
		Campaign travelCampaign = new Campaign(
                "Travel Kampanya",
                "Bu bir ulaşım kampanya içeriğidir.",
                LocalDate.of(2024, 5, 15), 
                LocalDate.of(2024, 2, 15), 
                LocalDate.of(2024, 2, 28), 
                SectorType.TRAVELS
        );
		Campaign foodCampaign = new Campaign(
                "Yemek Kampanya",
                "Bu bir yemek kampanya içeriğidir.",
                LocalDate.of(2024, 10, 15), 
                LocalDate.of(2023, 1, 10), 
                LocalDate.of(2023, 2, 20), 
                SectorType.OTHERS
        );
		
		List<Campaign> campaignsOfMaster = new ArrayList<>();
		campaignsOfMaster.add(marketCampaign);
		
		List<Campaign> campaignsOfVisa= new ArrayList<>();
		campaignsOfVisa.add(foodCampaign);
		campaignsOfVisa.add(travelCampaign);
		
		CreditCard masterCard = new CreditCard(BigDecimal.valueOf(1.1), campaignsOfMaster);
		CreditCard visaCard = new CreditCard(BigDecimal.valueOf(2.1), campaignsOfVisa);
		
		bank.getCreditCards().add(masterCard);
		bank.getCreditCards().add(visaCard);
		
		Application application1 = new Application(new ConsumerLoan(BigDecimal.valueOf(3.3), 10, 10.2),
				user1, LocalDateTime.now());
		Application application2 = new Application(new ConsumerLoan(BigDecimal.valueOf(7.3), 6, 5.6),
				user1, LocalDateTime.of(2023, 2, 20, 15, 30));
		Application application3 = new Application(new VechileLoan(BigDecimal.valueOf(22.3), 8, 4.8),
				user3, LocalDateTime.of(2024, 3, 16, 18, 20));
		
		System.out.println();
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
		
		System.out.println("En çoktan aza kampanya sayısına sahip kredi kartlar:");
		CreditCardOperation.sortByCampaignCountDescending(bank.getCreditCards());
		System.out.println();
		
		System.out.println("onur7altug@gmail.com mailine sahip kullanıcının başvuruları:");
		ApplicationOperation.applicationsOfUserWithEmail("onur7altug@gmail.com");
		
	}

}
