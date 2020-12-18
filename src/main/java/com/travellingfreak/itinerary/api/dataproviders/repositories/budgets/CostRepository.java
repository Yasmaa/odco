package com.travellingfreak.itinerary.api.dataproviders.repositories.budgets;

import com.travellingfreak.itinerary.api.dataproviders.model.budget.Cost;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CostRepository extends CrudRepository<Cost, Long> {

}
