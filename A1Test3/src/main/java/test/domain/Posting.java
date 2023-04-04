package test.domain;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Posting {

	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private Long id;

	private long matDoc;
	
	private long item;
	
	private LocalDate docDate;
	
	private LocalDate postingDate;
	
	private String materialDescription;
	
	private long quantity;
	
	private String bUn;
	
	private double amountLC;
	
	private String crcy;
	
	private String userName;
	
	private boolean authorizedDelivery;
	
}
