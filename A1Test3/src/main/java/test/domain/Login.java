package test.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Login {
	
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private Long id;
	
	@NonNull
	String application;
	
	@NonNull
	String appAccountName;
	
	@NonNull
	Boolean isActive;
	
	@NonNull
	String jobTitle;
	
	@NonNull
	String department;
}
