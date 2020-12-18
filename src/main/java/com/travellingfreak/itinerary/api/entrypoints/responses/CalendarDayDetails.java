package com.travellingfreak.itinerary.api.entrypoints.responses;

import java.time.LocalTime;
import java.util.List;

import lombok.Data;

/**
 * User: AustPC Date: 4/15/2020 Time: 5:02 PM
 *
 * @author AustPC
 */
@Data
public class CalendarDayDetails {
  private final int dayId;
  private final int dayNumber;
  // activities are planned before start time or after end time
  private final boolean isOverbooked;

  private final int dayOfMonth;
  private final LocalTime startTime;
  private final LocalTime endTime;

  // activities without start time
  private final List<CalendarActivity> allDaysActivities;

  // activities with start time / end time sorted by start time
  private final List<CalendarActivity> plannedActivities;

}
