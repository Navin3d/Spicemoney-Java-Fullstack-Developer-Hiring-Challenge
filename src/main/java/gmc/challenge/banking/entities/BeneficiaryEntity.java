package gmc.challenge.banking.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "beneficiary_history")
public class BeneficiaryEntity implements Serializable {

	private static final long serialVersionUID = 4510454427628429593L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private final Long id;
	
	@Column(name = "sender_name", nullable = false)
	private final String senderName;
	
	@Column(name = "sender_message", nullable = false)
	private final String sendersMessage;
	
	@Column(name = "from_account_id", nullable = false)
	private final String fromAccountId;
	
	@Column(name = "to_account_id", nullable = false)
	private final UsersEntity toAccountId;
	
	@Column(name = "amount_paid", nullable = false)
	private final Long amountPaid;
	
	@Column(name = "transaction_time")
	private final String transactionTime;

}
