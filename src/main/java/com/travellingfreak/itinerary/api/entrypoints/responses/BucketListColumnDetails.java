package com.travellingfreak.itinerary.api.entrypoints.responses;

import java.util.List;

import lombok.Data;

/**
 * Date: 6/6/2020 Time: 12:08 PM
 */
@Data
public class BucketListColumnDetails {
  private final long id;
  private final String title;
  private final List<ActivityDetails> activities;
}
