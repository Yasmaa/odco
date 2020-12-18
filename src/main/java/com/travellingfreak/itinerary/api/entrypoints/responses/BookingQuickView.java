package com.travellingfreak.itinerary.api.entrypoints.responses;

import com.travellingfreak.itinerary.api.dataproviders.model.enums.CurrencyCode;

import java.time.LocalDate;
import java.time.LocalTime;

import lombok.Data;

@Data
public class BookingQuickView {
  private long id;
  private String accommodationName;
  private LocalDate startDate;
  private LocalDate endDate;
}
