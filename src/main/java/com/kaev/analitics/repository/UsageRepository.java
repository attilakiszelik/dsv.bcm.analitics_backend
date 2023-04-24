package com.kaev.analitics.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.kaev.analitics.model.UsageLogEntry;

public interface UsageRepository extends JpaRepository<UsageLogEntry, Long>{
	
	@Query(value = "SELECT * FROM AUTOMATIONUSAGE a WHERE LEFT(a.TIMESTAMP,4) = :year", nativeQuery = true)
	List<UsageLogEntry> findAllInYear(@Param("year") String year);
	
}
