package com.travellingfreak.itinerary.api.dataproviders.repositories.planning.buckets;

import com.travellingfreak.itinerary.api.dataproviders.model.planning.buckets.Day;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DayRepository extends CrudRepository<Day, Long> {

}
