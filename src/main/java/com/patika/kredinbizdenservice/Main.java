package com.patika.kredinbizdenservice;

import com.patika.kredinbizdenservice.model.Application;
import com.patika.kredinbizdenservice.model.User;

public class Main {

	public static void main(String[] args) {
		//aynı mail ile user yaratamyoruz
		User user1 = new User("Onur Altug", "Akca", "onur7altug@gmail.com", "1234", "05363544235", true);
		User user2 = new User("Ozan", "Akca", "onur7altug@gmail.com", "1234", "05362341198", true);
		
		Application application1 = new Application(null, user1, null);
		Application application2 = new Application(null, user1, null);
		Application application3 = new Application(null, user1, null);
		
		//password hashlendi
		System.out.println(user1.getPassword());
		
		//en çok başvuran kullanıcı
		System.out.println(Application.findUserWithMostApplications().getName());
		
		//mail girererek kullanıcının başvuralını görüntüleme
		Application.applicationsOfUserWithEmail("onur7altug@gmail.com");
	}

}
