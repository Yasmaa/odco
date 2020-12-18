package com.travellingfreak.itinerary.api.entrypoints.planning;

import com.travellingfreak.itinerary.api.core.model.PageResponse;
import com.travellingfreak.itinerary.api.entrypoints.requests.CreateAccommodationRequest;
import com.travellingfreak.itinerary.api.entrypoints.requests.PatchAccommodationRequest;
import com.travellingfreak.itinerary.api.entrypoints.responses.AccommodationDetails;
import com.travellingfreak.itinerary.api.entrypoints.responses.ResourceCreationResponse;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Positive;

import io.micrometer.core.annotation.Timed;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping("/api/accommodations/{travelId}")
@Api(tags = "Accommodation API")
@RequiredArgsConstructor
public class AccommodationEndpoint {

  @ApiOperation("Read accommodation")
  @GetMapping(value = "{id}", produces = "application/json")
  @Timed("api.accommodations.get")
  @PreAuthorize("hasPermission(#travelId, '', 'READ')")
  public AccommodationDetails get(
      @PathVariable("travelId") final long travelId,
      @ApiIgnore @AuthenticationPrincipal final KeycloakPrincipal principal,
      @PathVariable("id") final long id) {
    throw new IllegalStateException("To be implemented");
  }

  @ApiOperation("Delete accommodation. Only custom accommodation can be deleted")
  @DeleteMapping(value = "{id}", produces = "application/json")
  @Timed("api.accommodations.delete")
  @PreAuthorize("hasPermission(#travelId, '', 'ADMIN')")
  public void deleteAccommodation (
      @PathVariable("travelId") final long travelId,
      @ApiIgnore @AuthenticationPrincipal final KeycloakPrincipal principal,
      @PathVariable("id") final long id) {
    throw new IllegalStateException("To be implemented");
  }

  @ApiOperation("Add a custom accommodation linked to this travel")
  @PostMapping(value = "", produces = "application/json")
  @Timed("api.accommodations.create")
  @PreAuthorize("hasPermission(#travelId, '', 'READ')")
  public ResourceCreationResponse<Long> addAccommodation(
      @PathVariable("travelId") final long travelId,
      @ApiIgnore @AuthenticationPrincipal final KeycloakPrincipal principal,
      @RequestBody final CreateAccommodationRequest createAccommodationRequest) {
    throw new IllegalStateException("To be implemented");
  }

  @ApiOperation("Patch a custom accommodation linked to this travel")
  @PatchMapping(value = "{id}", produces = "application/json")
  @Timed("api.accommodations.patch")
  @PreAuthorize("hasPermission(#travelId, '', 'READ')")
  public void patchAccommodation(
      @PathVariable("travelId") final long travelId,
      @ApiIgnore @AuthenticationPrincipal final KeycloakPrincipal principal,
      @PathVariable("id") final long id,
      @RequestBody PatchAccommodationRequest patchAccommodationRequest) {
    throw new IllegalStateException("To be implemented");
  }

  @ApiOperation("Search accommodation. Results should include either publicly available accommodations (custom_travel_id = null) or accommodations created "
                + "for this travel (custom_travel_id = travelId)")
  @GetMapping(value = "search", produces = "application/json")
  @Timed("api.accommodations.searchAccommodation")
  @PreAuthorize("hasPermission(#travelId, '', 'READ')")
  public PageResponse<AccommodationDetails> searchAccommodation(
      @PathVariable("travelId") final long travelId,
      @ApiIgnore @AuthenticationPrincipal final KeycloakPrincipal principal,
      @RequestParam ("q") final String name,
      @RequestParam @Positive final int page,
      @RequestParam @Positive final int limit) {
    throw new IllegalStateException("To be implemented");
  }

  @ApiOperation("Returns the list of accommodations which have a reference with this travel, i.e. there is at least one booking reference linked to it")
  @GetMapping(value = "list", produces = "application/json")
  @Timed("api.accommodations.list")
  @PreAuthorize("hasPermission(#travelId, '', 'READ')")
  public PageResponse<AccommodationDetails> listAccommodations(
      @PathVariable("travelId") final long travelId,
      @ApiIgnore @AuthenticationPrincipal final KeycloakPrincipal principal,
      @RequestParam @Positive final int page,
      @RequestParam @Positive final int limit) {
    throw new IllegalStateException("To be implemented");
  }

}
