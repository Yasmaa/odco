package com.travellingfreak.itinerary.api.entrypoints.responses;

import com.travellingfreak.itinerary.api.core.model.accounts.User;
import com.travellingfreak.itinerary.api.dataproviders.model.enums.Category;

import lombok.Data;

/**
 * User: AustPC Date: 4/16/2020 Time: 8:57 PM
 *
 * @author AustPC
 */
@Data
public class GeoTaggedActivity {
  private final LatLng location;
  private final Category activityCategory;
  private final String title;
  private final User createdBy;
}
