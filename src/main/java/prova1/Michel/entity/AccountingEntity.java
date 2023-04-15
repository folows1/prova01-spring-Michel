package prova1.Michel.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountingEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long itemCode;
	private String type;
	private String description;
	private float accValue;
	private float profit;
	private String dateTime;
	private boolean active;
}
