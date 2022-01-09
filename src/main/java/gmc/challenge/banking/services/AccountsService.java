package gmc.challenge.banking.services;

import gmc.challenge.banking.models.AccountsDto;

public interface AccountsService {
	
	public AccountsDto getAccount(String accountId);
	public AccountsDto addOrUpdateAccount(AccountsDto account);
	public void deleteAccount(String accountId);
	
}
