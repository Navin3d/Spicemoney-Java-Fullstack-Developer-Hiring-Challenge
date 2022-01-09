package gmc.challenge.banking.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import gmc.challenge.banking.entities.BeneficiaryEntity;

public interface BenificiaryDao extends JpaRepository<BeneficiaryEntity, Long> {
	List<BeneficiaryEntity> findAllByFromAccountId(String accountId);
	List<BeneficiaryEntity> findAllByToAccountId(String accountId);
}
