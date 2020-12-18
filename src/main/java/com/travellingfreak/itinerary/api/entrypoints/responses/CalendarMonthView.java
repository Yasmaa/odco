package com.travellingfreak.itinerary.api.entrypoints.responses;

import java.util.List;

import lombok.Data;

/**
 * User: AustPC Date: 4/15/2020 Time: 5:02 PM
 *
 * @author AustPC
 */
@Data
public class CalendarMonthView {
  private final int month;
  private final int year;
  private final List<CalendarDayDetails> calendarDays;
}
