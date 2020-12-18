package com.travellingfreak.itinerary.api.dataproviders.model.planning.activities;

import com.travellingfreak.itinerary.api.dataproviders.model.budget.Cost;
import com.travellingfreak.itinerary.api.dataproviders.model.budget.TravelPass;
import com.travellingfreak.itinerary.api.dataproviders.model.planning.Activity;
import com.travellingfreak.itinerary.api.dataproviders.model.planning.Location;

import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * Date: 7/19/2020 Time: 10:33 AM
 */
@EqualsAndHashCode(callSuper = true)
@Table(name = "transportation_activities")
@Entity
@Data
@DiscriminatorValue("TRANSPORTATION")
@AllArgsConstructor
@NoArgsConstructor

public class TransportationActivity extends Activity {
  @Column(name = "departure_time")
  private LocalTime departureTime;

  @Column(name = "travel_duration_in_seconds")
  private int travelDurationInSeconds;

  @ManyToOne
  private Location startLocation;

  @ManyToOne
  private Location endLocation;

  @Column(name = "distance_covered")
  private int distanceCovered;

  @OneToOne
  private Cost price;

  @ManyToOne
  private TravelPass pass;

  public void addCost(final Cost c) {
    c.setTravel(getTravel());
    c.setParentActivity(this);
    this.price = c;
  }

  public void clearCost() {
    this.price.setTravel(null);
    this.price.setParentActivity(null);
    this.price = null;
  }
}
