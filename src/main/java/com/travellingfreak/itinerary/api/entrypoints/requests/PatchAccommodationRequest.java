package com.travellingfreak.itinerary.api.entrypoints.requests;

import lombok.Data;

@Data
public class PatchAccommodationRequest {
  private String name;
  private String country;
  private String city;
  private String address;
  private String streetAddress;
  private String postCode;
  private String minCheckIn;
  private String maxCheckOut;
  private int numberOfStars;
}
