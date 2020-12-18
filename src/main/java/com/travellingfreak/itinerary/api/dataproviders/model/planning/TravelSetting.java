package com.travellingfreak.itinerary.api.dataproviders.model.planning;

import com.travellingfreak.itinerary.api.dataproviders.model.enums.CurrencyCode;
import com.travellingfreak.itinerary.api.dataproviders.model.enums.MeasurementUnit;
import com.travellingfreak.itinerary.api.dataproviders.model.enums.TemperatureUnit;

import java.math.BigDecimal;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Date: 7/19/2020 Time: 9:49 AM
 */
@Entity(name = "TravelSetting")
@Table(name = "travel_settings")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TravelSetting {
  @Id
  @GeneratedValue
  private long id;

  @OneToOne
  private Travel travel;

  @Column(name = "default_currency")
  @Enumerated(EnumType.STRING)
  private CurrencyCode defaultCurrency;

  @Column(name = "distance_unit")
  @Enumerated(EnumType.STRING)
  private MeasurementUnit distanceUnit;

  @Column(name = "temperature_measure_unit")
  @Enumerated(EnumType.STRING)
  private TemperatureUnit temperatureMeasureUnit;

  @Column(name = "maximum_activities_per_day")
  private int maximumActivitiesPerDay;

  @Column(name = "planning_type")
  private String planningType;

  @Column(name = "default_transport_mode")
  private String defaultTransportMode;

  @Column(name = "allow_guests_to_invite")
  private boolean allowGuestsToInvite;

  @Column(name = "allow_file_sharing")
  private boolean allowFileSharing;

  @Column(name = "allow_discussions")
  private boolean allowDiscussions;

  @Column(name = "allow_email_processing")
  private boolean allowEmailProcessing;

  @Column(name = "day_starts_at")
  private LocalTime dayStartsAt;

  @Column(name = "day_ends_at")
  private LocalTime dayEndsAt;

  @Column(name = "daily_budget")
  private BigDecimal dailyBudget;

  private BigDecimal budget;

  @Column(name = "budget_currency")
  @Enumerated(EnumType.STRING)
  private CurrencyCode budgetCurrency;

}
