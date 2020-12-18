package com.travellingfreak.itinerary.api.dataproviders.repositories.planning.activities;

import com.travellingfreak.itinerary.api.dataproviders.model.planning.activities.Like;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LikeRepository extends CrudRepository<Like, Long> {

}
