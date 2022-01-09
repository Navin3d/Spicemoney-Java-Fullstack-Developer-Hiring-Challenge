package gmc.challenge.banking.models;

import java.io.Serializable;
import lombok.Data;

@Data
public class UsersDto implements Serializable {

	private static final long serialVersionUID = 2201102653754003252L;
	
	private String userId;

	private String firstName;
	
	private String middleName;
	
	private String lastName;
	
	private String encryptedPin;
	
	private Long mobileNumber;
	
	private String email;

}
