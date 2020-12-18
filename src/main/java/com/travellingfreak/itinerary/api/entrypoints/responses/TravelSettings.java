package com.travellingfreak.itinerary.api.entrypoints.responses;



import com.travellingfreak.itinerary.api.dataproviders.model.enums.CurrencyCode;
import com.travellingfreak.itinerary.api.dataproviders.model.enums.MeasurementUnit;
import com.travellingfreak.itinerary.api.dataproviders.model.enums.TransitMode;
import com.travellingfreak.itinerary.api.dataproviders.model.enums.Visibility;

import java.time.LocalTime;

import lombok.Data;

/**
 * User: AustPC Date: 4/15/2020 Time: 8:55 PM
 *
 * @author AustPC
 */
@Data
public class TravelSettings {
  private final CurrencyCode defaultCurrency;
  private final MeasurementUnit distanceUnit;
  private final int maximumActivitiesPerDay;
  private final DayClassification planningType;
  private final TransitMode defaultTransportMode;
  private final Visibility visibility;

  private final boolean allowGuestsToInvite;
  private final boolean allowFileSharing;
  private final boolean allowDiscussions;
  private final boolean allowEmailProcessing;

  private final LocalTime dayStartsAt;
  private final LocalTime dayEndsAt;
  private final double dailyBudget;
}
