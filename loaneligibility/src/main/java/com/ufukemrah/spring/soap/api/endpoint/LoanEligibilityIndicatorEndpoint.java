package com.ufukemrah.spring.soap.api.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.ufukemrah.spring.soap.api.loaneligibility.Acknowledgement;
import com.ufukemrah.spring.soap.api.loaneligibility.CustomerRequest;
import com.ufukemrah.spring.soap.api.service.LoanEligibilityService;

@Endpoint
public class LoanEligibilityIndicatorEndpoint {

	private static final String NAMESPACE="http://www.ufukemrah.com/spring/soap/api/loanEligibility";
	@Autowired
	private LoanEligibilityService service;
	@PayloadRoot(namespace = NAMESPACE,localPart = "CustomerRequest")
	@ResponsePayload
	public Acknowledgement getLoanStatus(@RequestPayload CustomerRequest customerRequest) {
		return service.checkLoanEgibility(customerRequest);
	}
}
