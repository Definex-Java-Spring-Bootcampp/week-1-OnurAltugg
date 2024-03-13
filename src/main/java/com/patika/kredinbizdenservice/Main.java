package com.patika.kredinbizdenservice;

import com.patika.kredinbizdenservice.model.User;

public class Main {

	public static void main(String[] args) {
		User user1 = new User("Onur Altug", "Akca", "onur7altug@gmail.com", "1234", "05363544235", true);
		User user2 = new User("Ozan", "Akca", "onur7altug@gmail.com", "1234", "05362341198", true);
		System.out.println(user1.getPassword());
	}

}
