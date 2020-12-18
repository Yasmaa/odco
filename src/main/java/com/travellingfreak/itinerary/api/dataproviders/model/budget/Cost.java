package com.travellingfreak.itinerary.api.dataproviders.model.budget;

import com.travellingfreak.itinerary.api.dataproviders.model.base.Audit;
import com.travellingfreak.itinerary.api.dataproviders.model.enums.CurrencyCode;
import com.travellingfreak.itinerary.api.dataproviders.model.planning.Activity;
import com.travellingfreak.itinerary.api.dataproviders.model.planning.Travel;
import com.travellingfreak.itinerary.api.dataproviders.model.planning.booking.BookingReference;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * Date: 7/19/2020 Time: 11:16 AM
 */
@EqualsAndHashCode(callSuper = true) @Entity
@Table(name = "travel_costs")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cost extends Audit {
  @Id
  @GeneratedValue
  private long id;

  private String note;

  @ManyToOne
  private Travel travel;

  @NotNull
  private BigDecimal amount;

  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  private Activity parentActivity;

  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  private BookingReference parentBooking;

  @Enumerated(EnumType.STRING)
  @NotNull
  private CurrencyCode currency;
}
