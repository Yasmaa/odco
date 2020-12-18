package com.travellingfreak.itinerary.api.dataproviders.model.planning.activities;

import com.travellingfreak.itinerary.api.dataproviders.model.planning.Activity;
import com.travellingfreak.itinerary.api.dataproviders.model.planning.booking.BookingReference;

import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * Date: 7/19/2020 Time: 10:32 AM
 */
@EqualsAndHashCode(callSuper = true)
@Table(name = "lodging_activities")
@Entity
@Data
@DiscriminatorValue("LODGING")
@AllArgsConstructor
@NoArgsConstructor

public class LodgingActivity extends Activity {
  @Column(name = "event_time")
  private LocalTime eventTime;

  @ManyToOne
  private BookingReference bookingRef;

}
