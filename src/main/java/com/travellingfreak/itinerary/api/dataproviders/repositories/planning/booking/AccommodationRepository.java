package com.travellingfreak.itinerary.api.dataproviders.repositories.planning.booking;

import com.travellingfreak.itinerary.api.dataproviders.model.planning.booking.AccommodationDetails;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccommodationRepository extends CrudRepository<AccommodationDetails, Long> {

}
