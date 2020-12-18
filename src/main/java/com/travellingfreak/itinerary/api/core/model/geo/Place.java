package com.travellingfreak.itinerary.api.core.model.geo;

import lombok.Data;

@Data
public class Place {
  private long id;
  private String name;
  private String tag;
  private String address;
  private double latitude;
  private double longitude;
}
