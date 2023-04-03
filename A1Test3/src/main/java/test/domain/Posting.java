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

	long matDoc;
	
	long item;
	
	LocalDate docDate;
	
	LocalDate postingDate;
	
	String materialDescription;
	
	long quantity;
	
	String bUn;
	
	double amountLC;
	
	String crcy;
	
	String userName;
	
	boolean authorizedDelivery;
	
}
