package com.travellingfreak.itinerary.api.dataproviders.repositories.accounts;

import com.travellingfreak.itinerary.api.dataproviders.model.accounts.Account;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends CrudRepository<Account, String> {
  List<Account> findAllByIdIn(List<String> ids);
}
