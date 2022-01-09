package gmc.challenge.banking.services;

import java.util.List;

import gmc.challenge.banking.entities.BeneficiaryEntity;
import gmc.challenge.banking.models.AccountsDto;
import gmc.challenge.banking.models.PaymentsDto;

public interface PaymentsService {
	AccountsDto payToUser(PaymentsDto paymentsDto);
	
	List<BeneficiaryEntity> payedToUsers(String accountId);
	
	List<BeneficiaryEntity> paidByUsers(String accountId);
}
