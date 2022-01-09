package gmc.challenge.banking.services.implementation;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import gmc.challenge.banking.daos.AccountsDao;
import gmc.challenge.banking.daos.BenificiaryDao;
import gmc.challenge.banking.daos.UsersDao;
import gmc.challenge.banking.entities.AccountEntity;
import gmc.challenge.banking.entities.BeneficiaryEntity;
import gmc.challenge.banking.entities.UsersEntity;
import gmc.challenge.banking.exceptions.AccountNotFoundException;
import gmc.challenge.banking.exceptions.BenificiaryLimitExedsException;
import gmc.challenge.banking.exceptions.PinMismatchException;
import gmc.challenge.banking.models.AccountsDto;
import gmc.challenge.banking.models.PaymentsDto;
import gmc.challenge.banking.services.PaymentsService;

@Service
public class PaymentsServiceImpl implements PaymentsService {
	
	private final AccountsDao accountsDao;
	private final UsersDao usersDao;
	private final BenificiaryDao benificiaryDao;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;

	public PaymentsServiceImpl(AccountsDao accountsDao, UsersDao usersDao, BCryptPasswordEncoder bCryptPasswordEncoder, BenificiaryDao benificiaryDao) {
		super();
		this.accountsDao = accountsDao;
		this.usersDao = usersDao;
		this.benificiaryDao = benificiaryDao;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	@Override
	public AccountsDto payToUser(PaymentsDto paymentsDto) {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		
		UsersEntity foundUser = usersDao.findByUserId(paymentsDto.getSenderId());
		
		if(bCryptPasswordEncoder.matches(paymentsDto.getMPin(), foundUser.getEncryptedPin()))
			throw new PinMismatchException();
		
		AccountEntity senderAccount = null;
		
		try{
			senderAccount = accountsDao.findByAccountId(paymentsDto.getFromAccountId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(senderAccount == null) 
			throw new AccountNotFoundException();		
		
		AccountEntity receiverAccount = null;
		
		try{
			receiverAccount = accountsDao.findByAccountId(paymentsDto.getToAccountId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(receiverAccount == null) 
			throw new AccountNotFoundException();
		
		if(paymentsDto.getAmountPaid() > 200000)
			throw new BenificiaryLimitExedsException();
		
		senderAccount.setAccountBalance(receiverAccount.getAccountBalance() - paymentsDto.getAmountPaid());
		
		receiverAccount.setAccountBalance(receiverAccount.getAccountBalance() + paymentsDto.getAmountPaid());
		
		accountsDao.save(senderAccount);
		accountsDao.save(receiverAccount);
		
		AccountsDto returnValue = modelMapper.map(senderAccount, AccountsDto.class);
		
		return returnValue;
	}

	@Override
	public List<BeneficiaryEntity> payedToUsers(String accountId) {
		List<BeneficiaryEntity> returnValue = benificiaryDao.findAllByFromAccountId(accountId);
		return returnValue;
	}

	@Override
	public List<BeneficiaryEntity> paidByUsers(String accountId) {
		List<BeneficiaryEntity> returnValue = benificiaryDao.findAllByToAccountId(accountId);
		return returnValue;
	}

}
