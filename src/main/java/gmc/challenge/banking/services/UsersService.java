package gmc.challenge.banking.services;

import gmc.challenge.banking.models.UsersDto;

public interface UsersService {
	
	public UsersDto getUser(String userId);
	public UsersDto addOrUpdateUser(UsersDto userToAdd);
	public void deleteUser(String userId);

}
