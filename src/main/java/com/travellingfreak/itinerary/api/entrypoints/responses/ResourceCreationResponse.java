package com.travellingfreak.itinerary.api.entrypoints.responses;

import lombok.Data;

/**
 * Date: 6/14/2020 Time: 4:06 PM
 */
@Data
public class ResourceCreationResponse<Id> {
  private final Id resourceId;
}
