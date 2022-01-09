package gmc.challenge.banking.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import gmc.challenge.banking.entities.BeneficiaryEntity;
import gmc.challenge.banking.models.AccountsDto;
import gmc.challenge.banking.models.PaymentsDto;
import gmc.challenge.banking.services.PaymentsService;

@RequestMapping("/pay")
public class PaymentsController {
	
	private final PaymentsService paymentsService;

	public PaymentsController(PaymentsService paymentsService) {
		super();
		this.paymentsService = paymentsService;
	}

	@PostMapping
	public ResponseEntity<AccountsDto> payToUser(@RequestBody PaymentsDto paymentsDto) {		
		AccountsDto returnValue = paymentsService.payToUser(paymentsDto);
		
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(returnValue);
	}
	
	@GetMapping("/{accountId}/history/out")
	public ResponseEntity<List<BeneficiaryEntity>> paymentHistoryOut(@RequestBody String accountId) {		
		List<BeneficiaryEntity> returnValue = paymentsService.payedToUsers(accountId);
		
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(returnValue);
	}
	
	@GetMapping("/{accountId}/history/in")
	public ResponseEntity<List<BeneficiaryEntity>> paymentHistoryIn(@RequestBody String accountId) {		
		List<BeneficiaryEntity> returnValue = paymentsService.paidByUsers(accountId);
		
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(returnValue);
	}

}
