package com.travellingfreak.itinerary.api.entrypoints.planning;

import com.travellingfreak.itinerary.api.core.model.PageResponse;
import com.travellingfreak.itinerary.api.entrypoints.requests.BookAccommodationRequest;
import com.travellingfreak.itinerary.api.entrypoints.responses.BookingDetails;

import org.keycloak.KeycloakPrincipal;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.micrometer.core.annotation.Timed;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping("/api/booking/{travelId}")
@Api(tags = "Booking API")
@RequiredArgsConstructor
public class BookingEndpoint {

  @ApiOperation("Link an accommodation to a travel for the specified duration and linked cost")
  @PostMapping(value = "", produces = "application/json")
  @Timed("api.planning.view.planning.overview")
  @PreAuthorize("hasPermission(#travelId, '', 'WRITE')")
  public void bookAccommodation(@PathVariable("travelId") final long travelId,
                                @ApiIgnore @AuthenticationPrincipal final KeycloakPrincipal userDetails,
                                @RequestBody BookAccommodationRequest bookAccommodationRequest) {
    throw new IllegalStateException("To be implemented");
  }

  @ApiOperation("Updates a booking")
  @PatchMapping(value = "{id}", produces = "application/json")
  @Timed("api.planning.view.planning.overview")
  @PreAuthorize("hasPermission(#travelId, '', 'WRITE')")
  public void updateAccommodation(@PathVariable("travelId") final long travelId,
                                  @ApiIgnore @AuthenticationPrincipal final KeycloakPrincipal userDetails,
                                  @PathVariable("id") final long bookingId,
                                  @RequestBody BookAccommodationRequest bookAccommodationRequest) {
    throw new IllegalStateException("To be implemented");
  }

  @ApiOperation("Deletes a booking")
  @DeleteMapping(value = "{id}", produces = "application/json")
  @Timed("api.planning.view.planning.overview")
  @PreAuthorize("hasPermission(#travelId, '', 'WRITE')")
  public void deleteAccommodation(@PathVariable("travelId") final long travelId,
                                  @ApiIgnore @AuthenticationPrincipal final KeycloakPrincipal userDetails,
                                  @PathVariable("id") final long bookingId) {
    throw new IllegalStateException("To be implemented");
  }

  @ApiOperation("List all bookings for a given travel")
  @GetMapping(value = "", produces = "application/json")
  @Timed("api.planning.view.planning.overview")
  @PreAuthorize("hasPermission(#travelId, '', 'READ')")
  public PageResponse<BookingDetails> listAccommodations(@PathVariable("travelId") final long travelId,
                                                          @ApiIgnore @AuthenticationPrincipal final KeycloakPrincipal userDetails) {
    throw new IllegalStateException("To be implemented");
  }

}
