package com.travellingfreak.itinerary.api.entrypoints.planning;

import com.travellingfreak.itinerary.api.core.model.PageResponse;
import com.travellingfreak.itinerary.api.core.model.threads.CollapsedPost;
import com.travellingfreak.itinerary.api.entrypoints.requests.CreateActivityForm;
import com.travellingfreak.itinerary.api.entrypoints.responses.DayBudgetView;
import com.travellingfreak.itinerary.api.entrypoints.responses.DayDiscussionView;
import com.travellingfreak.itinerary.api.entrypoints.responses.DayMapView;
import com.travellingfreak.itinerary.api.entrypoints.responses.DayOverviewDetails;
import com.travellingfreak.itinerary.api.entrypoints.responses.DaySettings;
import com.travellingfreak.itinerary.api.entrypoints.responses.ResourceCreationResponse;

import org.keycloak.KeycloakPrincipal;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import io.micrometer.core.annotation.Timed;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping("/api/planning/{travelId}/{day}")
@Api(tags = "Planning API")
@RequiredArgsConstructor
public class PlanningEndpoint {

  @ApiOperation("View planning slot (which is the day)")
  @GetMapping(value = "overview", produces = "application/json")
  @Timed("api.planning.view.planning.overview")
  @PreAuthorize("hasPermission(#travelId, '', 'READ')")
  public DayOverviewDetails getOverview(@PathVariable("travelId") final long travelId,
                                        @ApiIgnore @AuthenticationPrincipal final KeycloakPrincipal userDetails,
                                        @PathVariable("day") final long id) {
    throw new IllegalStateException("To be implemented");
  }

  @ApiOperation("View planning slot as budget list")
  @GetMapping(value = "budget", produces = "application/json")
  @Timed("api.planning.view.planning.budget")
  @PreAuthorize("hasPermission(#travelId, '', 'READ')")
  public DayBudgetView getBudgetView(@PathVariable("travelId") final long travelId,
                                     @ApiIgnore @AuthenticationPrincipal final KeycloakPrincipal userDetails,
                                     @PathVariable("day") final long id) {
    return null;
  }

  @ApiOperation(value = "View settings.", notes = "It also returns the settings for the travel, which are applied if no settings are specified for the day")
  @GetMapping(value = "settings", produces = "application/json")
  @Timed("api.planning.view.planning.budget")
  @PreAuthorize("hasPermission(#travelId, '', 'READ')")
  public DaySettings getSettingsView(@PathVariable("travelId") final long travelId,
                                     @ApiIgnore @AuthenticationPrincipal final KeycloakPrincipal userDetails,
                                     @PathVariable("day") final long id) {
    return null;
  }

  @ApiOperation("View planning slot as map")
  @GetMapping(value = "map", produces = "application/json")
  @Timed("api.planning.view.planning.budget")
  @PreAuthorize("hasPermission(#travelId, '', 'READ')")
  public DayMapView getMapView(@PathVariable("travelId") final long travelId,
                               @ApiIgnore @AuthenticationPrincipal final KeycloakPrincipal userDetails,
                               @PathVariable("day") final long id) {
    return null;
  }

  @ApiOperation(value = "View planning discussions.", notes = "It should also mark all the recent posts as read for the current user (after returning the list)")
  @GetMapping(value = "discussion", produces = "application/json")
  @Timed("api.planning.view.planning.budget")
  @PreAuthorize("hasPermission(#travelId, '', 'READ')")
  public PageResponse<CollapsedPost> getDiscussionView(@PathVariable("travelId") final long travelId,
                                                       @ApiIgnore @AuthenticationPrincipal final KeycloakPrincipal userDetails,
                                                       @PathVariable("day") final long id
  ) {
    return null;
  }

  @ApiOperation("Creates an activity and add it to the day")
  @PostMapping(value = "", produces = "application/json")
  @Timed("api.activity.add")
  @PreAuthorize("hasPermission(#travelId, '', 'WRITE')")
  public ResourceCreationResponse<Long> addItem(@PathVariable("travelId") final long travelId,
                                                @ApiIgnore @AuthenticationPrincipal final KeycloakPrincipal principal,
                                                @PathVariable("day") final long id,
                                                @RequestBody final CreateActivityForm createActivityForm) {
    throw new IllegalStateException("To be implemented");
  }


}
