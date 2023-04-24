package com.kaev.analitics.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.kaev.analitics.model.SupporthoursLogEntry;

public interface SupporthourRepository extends JpaRepository<SupporthoursLogEntry, Long>{
	
	@Query(value = "SELECT * FROM AUTOMATIONSUPPORTTIME a WHERE LEFT(a.TIMESTAMP,4) = :year", nativeQuery = true)
	List<SupporthoursLogEntry> findAllInYear(@Param("year") String year);
	
}
