package com.travellingfreak.itinerary.api.entrypoints.responses;

import com.travellingfreak.itinerary.api.core.model.accounts.User;
import com.travellingfreak.itinerary.api.core.model.geo.City;
import com.travellingfreak.itinerary.api.core.model.threads.CollapsedPost;
import com.travellingfreak.itinerary.api.dataproviders.model.enums.Visibility;

import java.util.List;

import lombok.Data;

@Data
public class TravelDetails {
  private final long id;
  private final String tripName;
  private final CollapsedPost description;
  private final String startDate;
  private final String endDate;
  private final Visibility visibility;
  private final boolean owner;
  private final String defaultCurrency;
  private final double totalCost;
  private final double averageDailyCostPerPerson;

  private final double totalCostUserCurrency;
  private final double averageDailyCostPerPersonUserCurrency;
  private final boolean participant;
  private final List<City> cities;
  private final List<User> otherParticipants;
  private final User ownerInfo;
}
