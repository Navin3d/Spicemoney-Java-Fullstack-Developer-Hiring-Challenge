package gmc.challenge.banking.models;

import java.io.Serializable;

import lombok.Data;

@Data
public class AccountsDto implements Serializable {

	private static final long serialVersionUID = -2994348190267484931L;

	private String accountId;
	
	private String userId;
	
	private Long accountBalance;
	
	private AccountType accountType;
	
}
