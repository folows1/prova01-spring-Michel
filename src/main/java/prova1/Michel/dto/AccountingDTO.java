package prova1.Michel.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import prova1.Michel.entity.AccountingEntity;

@Data
@NoArgsConstructor
public class AccountingDTO {
	private long itemCode;
	private String type;
	private String description;
	private float accValue;
	private float profit;
	private String dateTime;
//	private boolean active;
	
	public AccountingDTO(AccountingEntity acc) {
		this.itemCode = acc.getItemCode();
		this.type = acc.getType();
		this.description = acc.getDescription();
		this.accValue = acc.getAccValue();
		this.profit = acc.getProfit();
		this.dateTime = acc.getDateTime();
	}
}
