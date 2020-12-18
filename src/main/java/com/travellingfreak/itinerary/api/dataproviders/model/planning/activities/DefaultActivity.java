package com.travellingfreak.itinerary.api.dataproviders.model.planning.activities;

import com.travellingfreak.itinerary.api.dataproviders.model.budget.Cost;
import com.travellingfreak.itinerary.api.dataproviders.model.planning.Activity;
import com.travellingfreak.itinerary.api.dataproviders.model.planning.Location;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * Date: 7/19/2020 Time: 10:32 AM
 */
@EqualsAndHashCode(callSuper = true)
@Table(name = "standard_activities")
@Entity
@Data
@DiscriminatorValue("ACTIVITY")
@AllArgsConstructor
@NoArgsConstructor
public class DefaultActivity extends Activity {
  @Column(name = "start_time")
  private LocalTime startTime;

  @Column(name = "end_time")
  private LocalTime endTime;

  @ManyToMany
  @JoinTable(
      name = "activity_locations",
      joinColumns = @JoinColumn(name = "activity_id"),
      inverseJoinColumns = @JoinColumn(name = "location_id")
  )
  private List<Location> locationRefs = new ArrayList<>();

  @OneToMany
  private List<Cost> fees = new ArrayList<>();

  public void addLocation(final Location location) {
    this.locationRefs.add(location);
  }
  public void removeLocation(final Location location) {
    this.locationRefs.remove(location);
  }

  public void addFee(final Cost cost) {
    this.fees.add(cost);
    cost.setParentActivity(this);
    cost.setTravel(getTravel());
  }
  public void removeFee(final Cost cost) {
    this.fees.remove(cost);
    cost.setParentActivity(null);
    cost.setTravel(null);
  }

}
