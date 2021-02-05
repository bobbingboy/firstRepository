package com.vintage.model;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepo extends JpaRepository<Location, Long>{
	
//	@Query("SELECT l FROM LOCATION as l WHERE l.locatName=?1")
//	Location findByLocation(String LocatName);
}
