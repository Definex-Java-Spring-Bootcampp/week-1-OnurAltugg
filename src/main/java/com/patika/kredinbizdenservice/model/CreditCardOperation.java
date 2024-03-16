package com.patika.kredinbizdenservice.model;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CreditCardOperation {
	
	public static void sortByCampaignCountDescending(List<CreditCard> creditCards) {

        Comparator<CreditCard> comparator = Comparator.comparingInt(card -> card.getCampaignList().size());

        Collections.sort(creditCards, comparator.reversed());
        
        for (CreditCard card : creditCards) {
            System.out.println(card);
            System.out.println();
        }
	}

}
