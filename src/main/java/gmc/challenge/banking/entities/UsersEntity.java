package gmc.challenge.banking.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Table(name = "user")
@Entity
@Data
public class UsersEntity implements Serializable {

	private static final long serialVersionUID = 4234645029225257763L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private final Long id;
	
	@Column(name = "user_id", unique = true, nullable = false)
	private final String userId;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	@Column(name = "account_id")
	private final Set<AccountEntity> accounts = new HashSet<>();
	
	@Column(name = "encrypted_pin")
	private final String encryptedPin;
	
	@Column(name = "first_name")
	private final String firstName;
	
	@Column(name = "middle_name")
	private final String middleName;
	
	@Column(name = "last_name")
	private final String lastName;
	
	@Column(name = "mobile_number")
	private final Long mobileNumber;
	
	@Column(name = "email")
	private final String email;
	
	@Column(name = "is_mobile_number_verified", nullable = false)
	private final Boolean isMobileNumberVerified = false;
	
	@Column(name = "mobile_number_reset_token", unique = true)
	private final String mobileNumberResetToken;
	
	@Column(name = "is_mail_verified", nullable = false)
	private final Boolean isEmailVerified = false;
	
	@Column(name = "email_reset_token", unique = true)
	private final String emailResetToken;
	
	@Column(name = "is_user_enable", nullable = false)
	private final Boolean isUserEnable = true;
	
	@Column(name = "is_user_active", nullable = false)
	private final Boolean isUserActive = true;

}
