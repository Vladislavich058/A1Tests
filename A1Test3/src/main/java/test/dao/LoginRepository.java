package test.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import jakarta.transaction.Transactional;
import test.domain.Login;

public interface LoginRepository 
		extends CrudRepository<Login, Long> {
	Optional<Login> findByAppAccountName(String appAccountName);
	
	@Transactional
	@Modifying
	@Query(value = "ALTER TABLE login AUTO_INCREMENT = 1", nativeQuery = true)
	void resetAutoIncrement();
}
