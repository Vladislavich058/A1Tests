package test.config;

import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import lombok.extern.slf4j.Slf4j;

import java.io.FileReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import test.dao.LoginRepository;
import test.dao.PostingRepository;
import test.domain.Login;
import test.domain.Posting;

@Slf4j
@Configuration
public class DataLoadConfig {
	
	@Bean
	ApplicationRunner loginsDataLoader(LoginRepository repo, List<Login> parseLogin) {
		if(repo.findAll().iterator().hasNext()) {
			repo.deleteAll();
			repo.resetAutoIncrement();
		}
		return args -> {
			parseLogin.forEach(login -> repo.save(login));;
		};
	}
	
	@Bean
	ApplicationRunner postingsDataLoader(PostingRepository repo, List<Posting> parsePosting) {
		if(repo.findAll().iterator().hasNext()) {
			repo.deleteAll();
			repo.resetAutoIncrement();
		}
		return args -> {
			parsePosting.forEach(posting -> repo.save(posting));
		}; 
	}
	
	@Bean
	DateTimeFormatter dateTimeFormatter() {
		return DateTimeFormatter.ofPattern("dd.MM.yyyy");
	}
	
	@Bean
	List<Login> parseLogin(){
		List<Login> logins = new ArrayList<Login>();
		
		try {
			CSVReader csvReader = new CSVReaderBuilder(
					new FileReader("src/main/resources/logins.csv"))
					.withSkipLines(1).build();
			String[] cvsRecord;
			while ((cvsRecord=csvReader.readNext()) != null) { 
				logins.add(new Login(cvsRecord[0].trim(),
									cvsRecord[1].trim(),
									Boolean.parseBoolean(cvsRecord[2].trim()),
									cvsRecord[3].trim(),
									cvsRecord[4].trim()));
			}
			return logins;
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Bean
	List<Posting> parsePosting(LoginRepository loginRepo, DateTimeFormatter dateTimeFormatter){
		
		List<Posting> postings = new ArrayList<Posting>();
		
		try {
			CSVReader csvReader = new CSVReaderBuilder(
					new FileReader("src/main/resources/postings.csv"))
					.withSkipLines(1)
					.withSkipLines(2)
					.withCSVParser(new CSVParserBuilder().withSeparator(';').build())
					.build();
			String[] cvsRecord;
			while ((cvsRecord=csvReader.readNext()) != null) { 
				Posting posting = Posting.builder()
									.matDoc(Long.parseLong(cvsRecord[0].trim()))
									.item(Long.parseLong(cvsRecord[1].trim()))
									.docDate(LocalDate.parse(cvsRecord[2].trim(), dateTimeFormatter))
									.postingDate(LocalDate.parse(cvsRecord[3].trim(), dateTimeFormatter))
									.materialDescription(cvsRecord[4].trim())
									.quantity(Long.parseLong(cvsRecord[5].trim()))
									.bUn(cvsRecord[6].trim())
									.amountLC(Double.parseDouble(cvsRecord[7].trim().replace(",", ".")))
									.crcy(cvsRecord[8].trim())
									.userName(cvsRecord[9].trim())
									.build();
				if(!loginRepo.findByAppAccountName(cvsRecord[9].trim()).isEmpty() 
						&& loginRepo.findByAppAccountName(cvsRecord[9].trim()).get().getIsActive() ) {
					posting.setAuthorizedDelivery(true);
				}
				else {
					posting.setAuthorizedDelivery(false);
				}
				postings.add(posting);
			}
			
			return postings;
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
