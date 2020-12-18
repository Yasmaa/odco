package com.travellingfreak.itinerary.api.entrypoints.planning;

import com.travellingfreak.itinerary.api.core.model.PageResponse;
import com.travellingfreak.itinerary.api.entrypoints.requests.ActivityCost;
import com.travellingfreak.itinerary.api.entrypoints.requests.AddCostRequest;
import com.travellingfreak.itinerary.api.entrypoints.requests.CreateActivityForm;
import com.travellingfreak.itinerary.api.entrypoints.requests.MoveActivityRequest;
import com.travellingfreak.itinerary.api.entrypoints.requests.PatchActivityTimeRequest;
import com.travellingfreak.itinerary.api.entrypoints.responses.CalendarMonthView;
import com.travellingfreak.itinerary.api.entrypoints.responses.CalendarWeekView;

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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping("/api/activities/{travelId}")
@Api(tags = "Activities API")
@RequiredArgsConstructor
public class ActivitiesEndpoint {

  @ApiOperation("Allow to render the calendar month view")
  @GetMapping(value = "calendar/month/{year}/{month}", produces = "application/json")
  @PreAuthorize("hasPermission(#travelId, '', 'READ')")
  public CalendarMonthView getMonthView(@PathVariable("travelId") final long tripId,
                                        @ApiIgnore @AuthenticationPrincipal final KeycloakPrincipal userDetails,
                                        @PathVariable("year") final int year,
                                        @PathVariable("month") final int month) {
    throw new IllegalStateException("To be implemented");
  }

  @ApiOperation("Allow to render the calendar month view positioned at the start of the travel")
  @GetMapping(value = "calendar/month", produces = "application/json")
  @PreAuthorize("hasPermission(#travelId, '', 'READ')")
  public CalendarMonthView getMonthViewAtTripStart(@PathVariable("travelId") final long tripId,
                                                   @ApiIgnore @AuthenticationPrincipal final KeycloakPrincipal userDetails) {
    throw new IllegalStateException("To be implemented");
  }

  @ApiOperation("Allow to render the calendar week view based on parameters")
  @GetMapping(value = "calendar/month/{year}/{month}/{week}", produces = "application/json")
  @PreAuthorize("hasPermission(#travelId, '', 'READ')")
  public CalendarWeekView getWeekView(
      @PathVariable("travelId") final long tripId,
      @ApiIgnore @AuthenticationPrincipal final KeycloakPrincipal userDetails,
      @PathVariable("year") final int year,
      @PathVariable("month") final int month,
      @PathVariable("week") final int week) {
    throw new IllegalStateException("To be implemented");
  }

  @ApiOperation("Update the activity day")
  @PatchMapping(value = "activity/{activityId}/day", produces = "application/json")
  @PreAuthorize("hasPermission(#travelId, '', 'WRITE')")
  public void moveActivity(
      @PathVariable("travelId") final long tripId,
      @ApiIgnore @AuthenticationPrincipal final KeycloakPrincipal userDetails,
      @PathVariable("activityId") final long activityId,
      @RequestBody final MoveActivityRequest moveActivityRequest
  ) {
    throw new IllegalStateException("To be implemented");
  }

  @ApiOperation("Update the activity start and end time")
  @PatchMapping(value = "activity/{activityId}/time", produces = "application/json")
  @PreAuthorize("hasPermission(#travelId, '', 'WRITE')")
  public void updateActivityTime(
      @PathVariable("travelId") final long tripId,
      @ApiIgnore @AuthenticationPrincipal final KeycloakPrincipal userDetails,
      @PathVariable("activityId") final long activityId,
      @RequestBody final PatchActivityTimeRequest moveActivityRequest
  ) {
    throw new IllegalStateException("To be implemented");
  }

  @ApiOperation("Likes an activity. If the activity has already a reaction from this user, the previous reaction is removed before adding the like")
  @PostMapping(value = "activity/{activityId}/reaction/thumb-up", produces = "application/json")
  @PreAuthorize("hasPermission(#travelId, '', 'GUEST')")
  public void likeActivity(
      @PathVariable("travelId") final long tripId,
      @ApiIgnore @AuthenticationPrincipal final KeycloakPrincipal userDetails,
      @PathVariable("activityId") final long activityId
  ) {
    throw new IllegalStateException("To be implemented");
  }

  @ApiOperation("Dislikes an activity. If the activity has already a reaction from this user, the previous reaction is removed before adding the dislike")
  @PostMapping(value = "activity/{activityId}/reaction/thumb-down", produces = "application/json")
  @PreAuthorize("hasPermission(#travelId, '', 'GUEST')")
  public void dislikeActivity(
      @PathVariable("travelId") final long tripId,
      @ApiIgnore @AuthenticationPrincipal final KeycloakPrincipal userDetails,
      @PathVariable("activityId") final long activityId
  ) {
    throw new IllegalStateException("To be implemented");
  }

  @ApiOperation("Remove reaction from activity")
  @DeleteMapping(value = "activity/{activityId}/reaction", produces = "application/json")
  @PreAuthorize("hasPermission(#travelId, '', 'GUEST')")
  public void removeReactionActivity(
      @PathVariable("travelId") final long tripId,
      @ApiIgnore @AuthenticationPrincipal final KeycloakPrincipal userDetails,
      @PathVariable("activityId") final long activityId
  ) {
    throw new IllegalStateException("To be implemented");
  }

  @ApiOperation("Remove activity from the plan")
  @DeleteMapping(value = "activity/{activityId}", produces = "application/json")
  @PreAuthorize("hasPermission(#travelId, '', 'WRITE')")
  public void removeActivity(
      @PathVariable("travelId") final long tripId,
      @ApiIgnore @AuthenticationPrincipal final KeycloakPrincipal userDetails,
      @PathVariable("activityId") final long activityId
  ) {
    throw new IllegalStateException("To be implemented");
  }

  @ApiOperation("Update activity details")
  @PatchMapping(value = "activity/{activityId}", produces = "application/json")
  @PreAuthorize("hasPermission(#travelId, '', 'WRITE')")
  public void removeActivity(
      @PathVariable("travelId") final long tripId,
      @ApiIgnore @AuthenticationPrincipal final KeycloakPrincipal userDetails,
      @PathVariable("activityId") final long activityId,
      @RequestBody CreateActivityForm patchData
  ) {
    throw new IllegalStateException("To be implemented");
  }


  @ApiOperation("Add cost to a default activity")
  @PostMapping(value = "activity/{activityId}/costs", produces = "application/json")
  @PreAuthorize("hasPermission(#travelId, '', 'WRITE')")
  public void addCost(
      @PathVariable("travelId") final long tripId,
      @ApiIgnore @AuthenticationPrincipal final KeycloakPrincipal userDetails,
      @PathVariable("activityId") final long activityId,
      @RequestBody AddCostRequest addCostRequest
  ) {
    throw new IllegalStateException("To be implemented");
  }

  @ApiOperation("Updates cost to a default activity")
  @PatchMapping(value = "activity/{activityId}/costs/{id}", produces = "application/json")
  @PreAuthorize("hasPermission(#travelId, '', 'WRITE')")
  public void patchCost(
      @PathVariable("travelId") final long tripId,
      @ApiIgnore @AuthenticationPrincipal final KeycloakPrincipal userDetails,
      @PathVariable("activityId") final long activityId,
      @PathVariable("id") final long id,
      @RequestBody AddCostRequest addCostRequest
  ) {
    throw new IllegalStateException("To be implemented");
  }


  @ApiOperation("Remove cost from a default activity")
  @DeleteMapping(value = "activity/{activityId}/costs/{id}", produces = "application/json")
  @PreAuthorize("hasPermission(#travelId, '', 'WRITE')")
  public void removeCost(
      @PathVariable("travelId") final long tripId,
      @ApiIgnore @AuthenticationPrincipal final KeycloakPrincipal userDetails,
      @PathVariable("activityId") final long activityId,
      @PathVariable("id") final long costId
  ) {
    throw new IllegalStateException("To be implemented");
  }

  @ApiOperation("Get all costs linked to a specific activity")
  @GetMapping(value = "activity/{activityId}/costs", produces = "application/json")
  @PreAuthorize("hasPermission(#travelId, '', 'WRITE')")
  public PageResponse<ActivityCost> getAllCosts(
      @PathVariable("travelId") final long tripId,
      @ApiIgnore @AuthenticationPrincipal final KeycloakPrincipal userDetails,
      @PathVariable("activityId") final long activityId,
      @RequestParam @Positive final int page,
      @RequestParam @Positive final int limit
  ) {
    throw new IllegalStateException("To be implemented");
  }

}
