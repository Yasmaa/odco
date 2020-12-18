package com.travellingfreak.itinerary.api.dataproviders.repositories.planning.activities;

import com.travellingfreak.itinerary.api.dataproviders.model.planning.Activity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityRepository extends CrudRepository<Activity, Long> {

}
