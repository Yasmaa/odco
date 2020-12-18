package com.travellingfreak.itinerary.api.dataproviders.repositories.accounts;

import com.travellingfreak.itinerary.api.dataproviders.model.accounts.Participant;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParticipantRepository extends CrudRepository<Participant, Long> {

}
