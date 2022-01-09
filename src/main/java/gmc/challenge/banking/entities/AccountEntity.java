package gmc.challenge.banking.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import gmc.challenge.banking.models.AccountType;
import lombok.Data;

@Data
@Entity
@Table(name = "accounts")
public class AccountEntity implements Serializable {

	private static final long serialVersionUID = -2979647325564453485L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;
	
	@Column(name = "account_id", unique = true, nullable = false)
	private String accountId;
	
	@ManyToOne
	@Column(name = "user_id", nullable = false)
	private UsersEntity user;
	
	@Column(name = "account_balance", nullable = false)
	private Long accountBalance;
	
	@Enumerated(value = EnumType.STRING)
	@Column(name = "account_type", nullable = false)
	private AccountType accountType;
	
	@Column(name = "is_account_enable", nullable = false)
	private Boolean isAccountEnable = true;
	
	@Column(name = "is_account_active", nullable = false)
	private Boolean isAccountActive = true;

}
