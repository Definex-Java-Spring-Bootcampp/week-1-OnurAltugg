package com.patika.kredinbizdenservice.model;

import java.math.BigDecimal;

public class ApplicationOperation {
	
	public static User findUserWithMostApplications() {
        int maxApplicationNumber = Integer.MIN_VALUE;
        User theUser = null;
        for (User user : UserRepository.getUsers()) {
            if (maxApplicationNumber < user.getApplicationList().size()) {
            	maxApplicationNumber = user.getApplicationList().size();
            	theUser = user;
            }
        }
        if(theUser == null) {
        	System.out.println("Henüz herhangi bir kullanıcı başvuru yapmadı.");
        }
        return theUser;
    }
    
    public static void applicationsOfUserWithEmail(String email){
    	User user = null;
    	for(User theUser: UserRepository.getUsers()) {
    		if(theUser.getEmail().equals(email)) {
				user = theUser;
			}
    	}
    	if(user == null) {
    		System.out.println("Bu maile sahip bir kullanıcı yok.");
    	}
    	else {
    		for (Application application : user.getApplicationList()) {
        		System.out.println(application);
    		}
    	}
    }
    
    public static void findMaxLoan() {
        User userWithMaxLoan = null;
        BigDecimal maxLoan = BigDecimal.ZERO; 

        for (User user : UserRepository.getUsers()) {
            for (Application application : user.getApplicationList()) {
            	if(application.getLoan() == null) {
            		continue;
            	}
                BigDecimal loanAmount = application.getLoan().getAmount();
                if (loanAmount.compareTo(maxLoan) > 0) {
                    maxLoan = loanAmount;
                    userWithMaxLoan = user;
                }
            }
        }
        if (userWithMaxLoan != null) {
            System.out.println(userWithMaxLoan + " -> " + maxLoan);
        } 
        else {
            System.out.println("Herhangi bir kredi başvurusu bulunamadı.");
        }
    }

}
