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
import org.springframework.web.bind.annotation.RestController;

import gmc.challenge.banking.models.UsersDto;
import gmc.challenge.banking.services.AccountsService;
import gmc.challenge.banking.services.UsersService;

@RestController
@RequestMapping(path = "/user")
public class UserController {
	
	private final UsersService usersService;
	
	public UserController(UsersService usersService, AccountsService accountsSerice) {
		super();
		this.usersService = usersService;
	}
	
	@PostMapping("/add")
	public ResponseEntity<UsersDto> addUser(@RequestBody UsersDto inputUser) {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		
		UsersDto userToAdd = modelMapper.map(inputUser, UsersDto.class);
		UsersDto returnValue = usersService.addOrUpdateUser(userToAdd);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(returnValue);
	}
	
	@GetMapping("/{userId}/show")
	public ResponseEntity<UsersDto> readUser(@RequestParam String userId) {
		UsersDto returnValue = usersService.getUser(userId);		
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(returnValue);
	}
	
	@PostMapping("/{userId}/edit")
	public ResponseEntity<UsersDto> updateUser(@RequestBody UsersDto inputUser) {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		
		UsersDto userToUpdate = modelMapper.map(inputUser, UsersDto.class);
		UsersDto returnValue = usersService.addOrUpdateUser(userToUpdate);
		
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(returnValue);
	}
	
	@GetMapping("/{userId}/delete")
	public ResponseEntity<String> deleteUser(@RequestParam String userId) {
		usersService.deleteUser(userId);		
		return ResponseEntity.status(HttpStatus.ACCEPTED).body("User Deleted");
	}

}
