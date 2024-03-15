package com.patika.kredinbizdenservice.model;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {
	
	private static final List<User> users = new ArrayList<>();
	
	public static boolean isEmailAlreadyExists(String email) {
        return users.stream().anyMatch(user -> user.getEmail().equals(email));
    }
	
	public static void saveUser(User user) {
        if (!isEmailAlreadyExists(user.getEmail())) {
            users.add(user);
        } 
    }

	public static List<User> getUsers() {
		return users;
	}
}
