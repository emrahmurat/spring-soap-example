package com.ufukemrah.spring.soap.api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ufukemrah.spring.soap.api.loaneligibility.Acknowledgement;
import com.ufukemrah.spring.soap.api.loaneligibility.CustomerRequest;
@Service
public class LoanEligibilityService {

	public Acknowledgement checkLoanEgibility(CustomerRequest customerRequest) {
		Acknowledgement acknowledgement = new Acknowledgement();
		List<String> mismatchCriteriaList = acknowledgement.getCriteriaMismatch();
		if(!(customerRequest.getAge() > 30 && customerRequest.getAge()<=60)) {
			mismatchCriteriaList.add("Person age should in beetwen 30 to 60");
		}
		if(!(customerRequest.getYearlyIncome() > 2000)) {
			mismatchCriteriaList.add("minimum income should be more than 200000");
		}
		if(!(customerRequest.getCibilScore() > 500)) {
			mismatchCriteriaList.add("Low cibil Score please try after 6 month");
		}
		if(mismatchCriteriaList.size() > 0) {
			acknowledgement.setApprovedAmout(0);
			acknowledgement.setIsEligible(false);
		}else {
			acknowledgement.setApprovedAmout(500000);
			acknowledgement.setIsEligible(true);
			mismatchCriteriaList.clear();
		}
		
		return acknowledgement;
	}
}
