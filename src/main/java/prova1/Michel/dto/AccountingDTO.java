package prova1.Michel.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import prova1.Michel.entity.AccountingEntity;

@Data
@NoArgsConstructor
public class AccountingDTO {
	
    private long itemCode;

    @NotNull(message = "Type can not be null.")
    @NotEmpty(message = "Type can not be empty.")
    @Size(min = 3, max = 80, message = "The size must be between 3 and 80.")
    private String type;

    @NotNull(message = "Description can not be null.")
    @NotEmpty(message = "Description can not be empty.")
    @Size(min = 3, max = 80, message = "The size must be between 3 and 80.")
    private String description;

    @NotNull(message = "Accounting value can not be null.")
    @Positive(message = "Accounting value must not be negative.")
    private float accValue;

    @NotNull(message = "Profit can not be null.")
    @Positive(message = "Profit must not be negative.")
    private float profit;

    @NotNull(message = "Date time can not be null.")
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
