package gmc.challenge.banking.services.implementation;

import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

import gmc.challenge.banking.daos.AccountsDao;
import gmc.challenge.banking.daos.UsersDao;
import gmc.challenge.banking.entities.AccountEntity;
import gmc.challenge.banking.entities.UsersEntity;
import gmc.challenge.banking.models.AccountsDto;
import gmc.challenge.banking.services.AccountsService;

@Service
public class AccountsServiceImpl implements AccountsService {

	private final AccountsDao usersDao;
	private final UsersDao accountsDao;

	public AccountsServiceImpl(AccountsDao usersDao, UsersDao accountsDao) {
		super();
		this.usersDao = usersDao;
		this.accountsDao = accountsDao;
	}
	
	@Override
	public AccountsDto getAccount(String accountId) {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		
		AccountEntity dataModel = usersDao.findByAccountId(accountId);
		AccountsDto returnValue = modelMapper.map(dataModel, AccountsDto.class);		
		
		return returnValue;
	}

	@Override
	public AccountsDto addOrUpdateAccount(AccountsDto account) {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		
		AccountEntity savedUser = null;
		
		if(account.getAccountId() == null) {
			account.setAccountId(UUID.randomUUID().toString());
			
			AccountEntity detachedUser = modelMapper.map(account, AccountEntity.class);
					
			savedUser = usersDao.save(detachedUser);
			
			UsersEntity foundUser = accountsDao.findByUserId(account.getUserId());
			
			foundUser.getAccounts().add(detachedUser);
			
			accountsDao.save(foundUser);
			
		} else {
			AccountEntity detachedUser = modelMapper.map(account, AccountEntity.class);
			
			savedUser = usersDao.save(detachedUser);
		}
		
		AccountsDto returnValue  = modelMapper.map(savedUser, AccountsDto.class);
		
		return returnValue;
	}

	@Override
	public void deleteAccount(String accountId) {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		
		AccountEntity dataModel = usersDao.findByAccountId(accountId);
		
		usersDao.delete(dataModel);	
	}

}
