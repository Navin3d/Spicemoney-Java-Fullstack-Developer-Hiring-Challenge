package gmc.challenge.banking.services.implementation;

import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

import gmc.challenge.banking.daos.UsersDao;
import gmc.challenge.banking.entities.UsersEntity;
import gmc.challenge.banking.models.UsersDto;
import gmc.challenge.banking.services.UsersService;

@Service
public class UsersServiceImpl implements UsersService{
	
	private final UsersDao usersDao;

	public UsersServiceImpl(UsersDao usersDao) {
		super();
		this.usersDao = usersDao;
	}

	@Override
	public UsersDto getUser(String userId) {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		
		UsersEntity dataModel = usersDao.findByUserId(userId);
		UsersDto returnValue = modelMapper.map(dataModel, UsersDto.class);		
		
		return returnValue;
	}

	@Override
	public UsersDto addOrUpdateUser(UsersDto userToAdd) {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		
		UsersEntity savedUser = null;
		
		if(userToAdd.getUserId() == null) {
			userToAdd.setUserId(UUID.randomUUID().toString());
			
			UsersEntity detachedUser = modelMapper.map(userToAdd, UsersEntity.class);
			
			usersDao.save(detachedUser);
		} else {
			UsersEntity detachedUser = modelMapper.map(userToAdd, UsersEntity.class);
			
			usersDao.save(detachedUser);
		}
		
		UsersDto returnValue  = modelMapper.map(savedUser, UsersDto.class);
		
		return returnValue;
	}

	@Override
	public void deleteUser(String userId) {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		
		UsersEntity dataModel = usersDao.findByUserId(userId);
		
		usersDao.delete(dataModel);	
	}

}
