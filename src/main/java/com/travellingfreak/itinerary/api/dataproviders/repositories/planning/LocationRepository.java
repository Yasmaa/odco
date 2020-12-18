package com.travellingfreak.itinerary.api.dataproviders.repositories.planning;

import com.travellingfreak.itinerary.api.dataproviders.model.planning.Location;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends CrudRepository<Location, Long> {

}
