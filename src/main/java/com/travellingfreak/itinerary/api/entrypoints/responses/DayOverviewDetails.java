package com.travellingfreak.itinerary.api.entrypoints.responses;

import java.time.LocalTime;
import java.util.List;

import lombok.Data;

/**
 * User: AustPC Date: 4/15/2020 Time: 6:35 PM
 *
 * @author AustPC
 */
@Data
public class DayOverviewDetails {
  private final BookingQuickView hotel;
  private final LocalTime minPlannableTime;
  private final LocalTime maxPlannableTime;

  private final List<CalendarActivity> allDayActivities;
  private final List<CalendarActivity> plannedActivities;
  private final double estimatedCost;
  private final String currency;
  private final int alreadyPlannedHours;
  private final int totalPlanHours;
//  private final List<ActivitySuggestion> activitySuggestions;

}
