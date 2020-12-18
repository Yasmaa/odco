package com.travellingfreak.itinerary.api.entrypoints.requests;

import lombok.Data;

/**
 * User: AustPC Date: 4/17/2020 Time: 1:35 PM
 *
 * @author AustPC
 */
@Data
public class CreateDayRequest {
  private Integer beforeDayId;
  private String name;
  private String notes;
}
