package com.patika.kredinbizdenservice.model;


import com.patika.kredinbizdenservice.enums.LoanType;

import java.math.BigDecimal;
import java.util.List;

public class ConsumerLoan extends Loan {

    private LoanType loanType = LoanType.IHTIYAC_KREDISI;
    private List<Integer> installmentOptions;

    public ConsumerLoan() {

    }

    public ConsumerLoan(BigDecimal amount, Integer installment, Double interestRate) {
        super(amount, installment, interestRate);
    }

    public LoanType getLoanType() {
        return loanType;
    }
    
    public List<Integer> getInstallmentOptions() {
		return installmentOptions;
	}

	public void setInstallmentOptions(List<Integer> installmentOptions) {
		this.installmentOptions = installmentOptions;
	}

    @Override
    void calculate(BigDecimal amount, int installment) {
        //tc bul, maaşı bul
    }


}
