package com.travellingfreak.itinerary.api.dataproviders.model.planning.activities;

import com.travellingfreak.itinerary.api.dataproviders.model.budget.Cost;
import com.travellingfreak.itinerary.api.dataproviders.model.geo.Toponym;
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
 * Date: 7/19/2020 Time: 10:32 AM
 */
@EqualsAndHashCode(callSuper = true)
@Table(name = "flight_activities")
@Entity
@Data
@DiscriminatorValue("FLIGHT")
@AllArgsConstructor
@NoArgsConstructor
public class FlightActivity extends Activity {
  @Column(name = "departure_time")
  private LocalTime departureTime;

  @Column(name = "flight_duration_in_minutes")
  private int flightDurationInMinutes;

  @ManyToOne
  private Toponym startLocation;

  @ManyToOne
  private Toponym endLocation;

  @Column(name ="flight_number")
  private String flightNumber;

  private String gate;

  @OneToOne
  private Cost price;

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
