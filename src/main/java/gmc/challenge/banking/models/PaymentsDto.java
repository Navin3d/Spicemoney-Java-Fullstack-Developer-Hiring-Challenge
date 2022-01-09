package gmc.challenge.banking.models;

import java.io.Serializable;

import gmc.challenge.banking.entities.UsersEntity;
import lombok.Data;

@Data
public class PaymentsDto implements Serializable {

	private static final long serialVersionUID = 88495378255368939L;
	
	private String senderId;
	
	private String senderName;
	
	private String sendersMessage;
	
	private String fromAccountId;
	
	private String ifscCode;
	
	private String mPin;
	
	private String toAccountId;
	
	private Long amountPaid;

}
