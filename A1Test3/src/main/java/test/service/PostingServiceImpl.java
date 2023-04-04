package test.service;

import java.time.LocalDate;
import java.time.temporal.IsoFields;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test.dao.PostingRepository;
import test.domain.Posting;

@Service
public class PostingServiceImpl implements PostingService {
	
	@Autowired
	private PostingRepository postingRepo;

	@Override
	public Iterable<Posting> findAll() {
		return postingRepo.findAll();
	}

	@Override
	public Iterable<Posting> findByDocDateAndAuthorizedDelivery(String date, boolean filter) {
		return postingRepo.findByDocDateAndAuthorizedDelivery(LocalDate.parse(date), filter);
	}

	@Override
	public Iterable<Posting> findByMonthAndAuthorizedDelivery(String month, String year, boolean filter) {
		List<Posting> postings = (List<Posting>) postingRepo.findAll();
		return postings.stream()
					.filter(p -> p.getDocDate().getMonthValue()==Integer.parseInt(month) 
									&& p.getDocDate().getYear()==Integer.parseInt(year)
									&& p.isAuthorizedDelivery()==filter)
						.collect(Collectors.toList());
	}

	@Override
	public Iterable<Posting> findByQuarterAndAuthorizedDelivery(String quarter, String year, boolean filter) {
		List<Posting> postings = (List<Posting>) postingRepo.findAll();
		return postings.stream()
				.filter(p -> p.getDocDate().get(IsoFields.QUARTER_OF_YEAR)==Integer.parseInt(quarter) 
								&& p.getDocDate().getYear()==Integer.parseInt(year)
								&& p.isAuthorizedDelivery()==filter)
					.collect(Collectors.toList());
	}

	@Override
	public Iterable<Posting> findByYearAndAuthorizedDelivery(String year, boolean filter) {
		List<Posting> postings = (List<Posting>) postingRepo.findAll();
		return postings.stream()
					.filter(p -> p.getDocDate().getYear()==Integer.parseInt(year)
								&& p.isAuthorizedDelivery()==filter)
						.collect(Collectors.toList());
	}

}
