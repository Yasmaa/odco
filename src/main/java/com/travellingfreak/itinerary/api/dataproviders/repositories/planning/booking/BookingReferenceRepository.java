package com.travellingfreak.itinerary.api.dataproviders.repositories.planning.booking;

import com.travellingfreak.itinerary.api.dataproviders.model.planning.booking.BookingReference;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingReferenceRepository extends CrudRepository<BookingReference, Long> {

}
