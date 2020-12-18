package com.travellingfreak.itinerary.api.dataproviders.repositories.planning.buckets;

import com.travellingfreak.itinerary.api.dataproviders.model.planning.buckets.Bucket;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BucketsRepository extends CrudRepository<Bucket, Long> {

}
