package com.patika.kredinbizdenservice;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;

import com.patika.kredinbizdenservice.model.Application;
import com.patika.kredinbizdenservice.model.ConsumerLoan;
import com.patika.kredinbizdenservice.model.Loan;
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
		
		Application application1 = new Application(new ConsumerLoan(BigDecimal.valueOf(3.3), null, null), user1, null);
		Application application2 = new Application(new ConsumerLoan(BigDecimal.valueOf(7.3), null, null), user1, null);
		Application application3 = new Application(new VechileLoan(BigDecimal.valueOf(2.3), null, null), user3, null);
		
		//password hashlendi. user1'in hash passwordu.
		System.out.println(user1.getPassword());
		System.out.println();
		
		//en çok başvuran kullanıcı
		System.out.println(Application.findUserWithMostApplications());
		System.out.println();
		
		//mail girererek kullanıcının başvuralını görüntüleme
		Application.applicationsOfUserWithEmail("onur7altug@gmail.com");
		
		//max loanı ve user bilgisini bulma
		Application.findMaxLoan();
	}

}
