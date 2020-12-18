package com.travellingfreak.itinerary.api.entrypoints.requests;

import com.travellingfreak.itinerary.api.dataproviders.model.enums.CurrencyCode;
import com.travellingfreak.itinerary.api.dataproviders.model.enums.MeasurementUnit;
import com.travellingfreak.itinerary.api.dataproviders.model.enums.PlanningMode;
import com.travellingfreak.itinerary.api.dataproviders.model.enums.TemperatureUnit;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

import lombok.Data;

@Data
public class PatchTravelSettingsRequest {
  private CurrencyCode defaultCurrency;
  private MeasurementUnit distanceUnit;
  private TemperatureUnit temperatureMeasureUnit;
  private int maximumActivitiesPerDay;
  private String planningType;
  private String defaultTransportMode;
  private boolean allowGuestsToInvite;
  private boolean allowFileSharing;
  private boolean allowDiscussions;
  private boolean allowEmailProcessing;
  private LocalTime dayStartsAt;
  private LocalTime dayEndsAt;
  private BigDecimal dailyBudget;
  private BigDecimal budget;
  private CurrencyCode budgetCurrency;
}
