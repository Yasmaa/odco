package com.travellingfreak.itinerary.api.dataproviders.repositories.planning;

import com.travellingfreak.itinerary.api.dataproviders.model.planning.Travel;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface TravelRepository extends CrudRepository<Travel, Long> {
  @Query("select t from Travel t where ( t.mode = 'DRAFT' or (t.mode = 'PLANNING' and t.startDate > :currentDate)) and t.deleted = false and (t.createdBy = :username or :username in (select p.accountId from Participant p where p.travel = t))")
  Page<Travel> findUpcomingTravels(String username, LocalDate currentDate, Pageable pageRequest);

  @Query("select t from Travel t where (t.deleted = true or (t.mode = 'PLANNING' and t.startDate <= :currentDate)) and (t.createdBy = :username or :username in (select p.accountId from Participant p where p.travel = t))")
  Page<Travel> findArchivedTravels(String username, LocalDate currentDate, Pageable pageRequest);

}
