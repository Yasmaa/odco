package com.travellingfreak.itinerary.api.entrypoints.responses;

import java.time.LocalDate;
import java.util.List;

import lombok.Data;

/**
 * User: AustPC Date: 4/15/2020 Time: 6:19 PM
 *
 * @author AustPC
 */
@Data
public class CalendarWeekView {
  private final int month;
  private final int year;
  private final LocalDate startDate;
  private final LocalDate endDate;

  private final List<CalendarDayDetails> calendarDays;
}
