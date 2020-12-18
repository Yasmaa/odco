package com.travellingfreak.itinerary.api.core.model.accounts;

import lombok.Data;

/**
 * User: AustPC Date: 3/17/2020 Time: 11:00 PM
 *
 * @author AustPC
 */
@Data
public class User {
  private final String id;
  private final String email;
  private final String name;
}
