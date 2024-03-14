package com.patika.kredinbizdenservice.model;


import com.patika.kredinbizdenservice.enums.ApplicationStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Application {

    private Loan loan;
    private Product product;
    private User user;
    private LocalDateTime localDateTime;
    private ApplicationStatus applicationStatus;
	private static final List<User> applicationsOfUsers = new ArrayList<>();

    private Application() {
    }

    /*
    public Application(CreditCard creditCard, User user, LocalDateTime localDateTime) {
        this.creditCard = creditCard;
        this.user = user;
        this.localDateTime = localDateTime;
        this.applicationStatus = ApplicationStatus.INITIAL;
    }*/

    public Application(Product product, User user, LocalDateTime localDateTime) {
        this.product = product;
        this.user = user;
        this.localDateTime = localDateTime;
        this.applicationStatus = ApplicationStatus.INITIAL;
        applicationsOfUsers.add(user);
        user.getApplicationList().add(this);
    }

    public Application(Loan loan, User user, LocalDateTime localDateTime) {
        this.loan = loan;
        this.user = user;
        this.localDateTime = localDateTime;
        this.applicationStatus = ApplicationStatus.INITIAL;
        applicationsOfUsers.add(user);
        user.getApplicationList().add(this);
    }

    public Loan getLoan() {
        return loan;
    }

    public void setLoan(Loan loan) {
        this.loan = loan;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public ApplicationStatus getApplicationStatus() {
        return applicationStatus;
    }

    public void setApplicationStatus(ApplicationStatus applicationStatus) {
        this.applicationStatus = applicationStatus;
    }
    
    public static User findUserWithMostApplications() {
        if (applicationsOfUsers.isEmpty()) {
            System.out.println("Henüz bir başvuru yok.");
            return null;
        }
        applicationsOfUsers.sort((user1, user2) -> 
        							Integer.compare(getApplicationCount(user2), getApplicationCount(user1)));
        return applicationsOfUsers.get(0);
    }

    private static int getApplicationCount(User theUser) {
        int count = 0;
        for (User user : applicationsOfUsers) {
            if (user.equals(theUser)) {
                count++;
            }
        }
        return count;
    }
    
    public static void applicationsOfUserWithEmail(String email){
    	User user = null;
    	for(User theUser: applicationsOfUsers) {
    		if(theUser.getEmail().equals(email)) {
				user = theUser;
			}
    	}
    	for (Application application : user.getApplicationList()) {
    		System.out.println(application);
		}
    }
    
    public static void findMaxLoan() {
        User userWithMaxLoan = null;
        BigDecimal maxLoan = BigDecimal.ZERO; 

        for (User user : applicationsOfUsers) {
            for (Application application : user.getApplicationList()) {
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

    @Override
    public String toString() {
        return "Application{" +
                "loan=" + loan +
                ", user=" + user +
                ", localDateTime=" + localDateTime +
                ", applicationStatus=" + applicationStatus +
                '}';
    }
}
