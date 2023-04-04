package test.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import test.domain.Posting;
import test.service.PostingService;

@RestController
@RequestMapping(path="/api",
				produces="application/json")
@CrossOrigin("http://localhost:4200")
public class PostingController {
	
	@Autowired
	private PostingService service;
	
	@GetMapping("/postings")
	public Iterable<Posting> findAll(){
		return service.findAll();
	}
	
	@GetMapping("/postings/sortByDay")
	public Iterable<Posting> sortByDay(String date, boolean filter){
		return service.findByDocDateAndAuthorizedDelivery(date, filter);
	}
	
	@GetMapping("/postings/sortByMonth")
	public Iterable<Posting> sortByMonth(String month, String year, boolean filter){
		return service.findByMonthAndAuthorizedDelivery(month, year, filter);
	}
	
	@GetMapping("/postings/sortByQuarter")
	public Iterable<Posting> sortByQuarter(String quarter, String year, boolean filter){
		return service.findByQuarterAndAuthorizedDelivery(quarter, year, filter);
	}
	
	@GetMapping("/postings/sortByYear")
	public Iterable<Posting> sortByYear(String year, boolean filter){
		return service.findByYearAndAuthorizedDelivery(year, filter);
	}
}
