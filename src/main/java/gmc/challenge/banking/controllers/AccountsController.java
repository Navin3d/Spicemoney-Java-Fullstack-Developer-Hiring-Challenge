package gmc.challenge.banking.controllers;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import gmc.challenge.banking.models.AccountsDto;
import gmc.challenge.banking.services.AccountsService;
import gmc.challenge.banking.services.UsersService;

@RequestMapping(path = "/account")
public class AccountsController {
	
	private final UsersService usersService;
	private final AccountsService accountsSerice;
	
	public AccountsController(UsersService usersService, AccountsService accountsSerice) {
		super();
		this.usersService = usersService;
		this.accountsSerice = accountsSerice;
	}
	
	@PostMapping("/add")
	public ResponseEntity<AccountsDto> addAccount(@RequestBody AccountsDto accountToAdd) {
		
		AccountsDto returnValue = accountsSerice.addOrUpdateAccount(accountToAdd);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(returnValue);
	}
	
	@GetMapping("/{accountId}/show")
	public ResponseEntity<AccountsDto> readAccount(@RequestParam String accountId) {
		AccountsDto returnValue = accountsSerice.getAccount(accountId);		
		return ResponseEntity.status(HttpStatus.CREATED).body(returnValue);
	}
	
	@PostMapping("/{accountId}/edit")
	public ResponseEntity<AccountsDto> updateAccount(@RequestBody AccountsDto accountToUpdate) {		
		AccountsDto returnValue = accountsSerice.addOrUpdateAccount(accountToUpdate);
		
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(returnValue);
	}
	
	@GetMapping("/{accountId}/delete")
	public ResponseEntity<String> deleteAccount(@RequestParam String accountId) {
		accountsSerice.deleteAccount(accountId);		
		return ResponseEntity.status(HttpStatus.ACCEPTED).body("Account Deleted");
	}

}
