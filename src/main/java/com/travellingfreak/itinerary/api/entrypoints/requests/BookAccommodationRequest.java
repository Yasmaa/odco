package com.travellingfreak.itinerary.api.entrypoints.requests;

import com.travellingfreak.itinerary.api.dataproviders.model.enums.CurrencyCode;
import com.travellingfreak.itinerary.api.dataproviders.model.planning.Travel;
import com.travellingfreak.itinerary.api.dataproviders.model.planning.booking.AccommodationDetails;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
public class BookAccommodationRequest {
  private long accommodationId;
  private LocalDate startDate;
  private LocalDate endDate;
  private double amount;
  private CurrencyCode currencyCode;

  private LocalTime minCheckInTime;
  private LocalTime maxCheckOutTime;
  private String bookedThrough;
  private String confirmation;


}
