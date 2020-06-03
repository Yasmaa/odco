package com.staxrt.odco.repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.staxrt.odco.model.Region;
import com.staxrt.odco.model.Secteur;

@Repository
public interface RegionRepo extends JpaRepository<Region, Integer> {
	
	@Query(value =
	           "SELECT " +
	                   "v" +
	                   " FROM" +
	                   " Region v GROUP BY v.idRegion" )
			  
	List<Region> findAllcp();
	
	
	@Query(value =
	           "SELECT " +
	                   "v.nomRegion ,c.capital,count(c.idCoop),sum(c.employeeFemmes+c.employeeHommes)" +
	                   " FROM" +
	                   " Region v,Cooperative c where  v.idRegion = c.idRegion  GROUP BY v.nomRegion" )
			  
	Collection<Region> findTotaladhByreg();

}