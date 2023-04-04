package test.service;

import test.domain.Posting;

public interface PostingService {
	Iterable<Posting> findAll();
	Iterable<Posting> findByDocDateAndAuthorizedDelivery(String date, boolean filter);
	Iterable<Posting> findByMonthAndAuthorizedDelivery(String month, 
			String year, boolean filter);
	Iterable<Posting> findByQuarterAndAuthorizedDelivery(String quarter, 
			String year, boolean filter);
	Iterable<Posting> findByYearAndAuthorizedDelivery(String year, boolean filter);
}
