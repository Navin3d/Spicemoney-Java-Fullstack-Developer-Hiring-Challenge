package gmc.challenge.banking.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import gmc.challenge.banking.entities.AccountEntity;

public interface AccountsDao extends JpaRepository<AccountEntity, Long> {
	AccountEntity findByAccountId(String accountId);
}
