package test.dao;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import jakarta.transaction.Transactional;
import test.domain.Posting;

public interface PostingRepository 
			extends CrudRepository<Posting, Long> {
	
	@Transactional
	@Modifying
	@Query(value = "ALTER TABLE posting AUTO_INCREMENT = 1", nativeQuery = true)
	void resetAutoIncrement();
}
