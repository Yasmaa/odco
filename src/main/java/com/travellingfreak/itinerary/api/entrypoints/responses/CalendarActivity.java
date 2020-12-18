package com.travellingfreak.itinerary.api.entrypoints.responses;

import java.time.LocalTime;

import lombok.Data;

/**
 * User: AustPC Date: 4/15/2020 Time: 5:13 PM
 *
 * @author AustPC
 */
@Data
public class CalendarActivity implements Comparable<CalendarActivity> {
  private final long id;
  private final String title;
  private final LocalTime startTime;
  private final LocalTime endTime;

  @Override public int compareTo(CalendarActivity o) {
    return startTime.compareTo(o.startTime);
  }
}
