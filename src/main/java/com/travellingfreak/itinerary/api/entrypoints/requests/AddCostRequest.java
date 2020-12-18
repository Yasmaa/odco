package com.travellingfreak.itinerary.api.entrypoints.requests;

import java.util.Currency;

import lombok.Data;

@Data
public class AddCostRequest {
  private double price;
  private Currency currencyCode;
  private String note;
}
