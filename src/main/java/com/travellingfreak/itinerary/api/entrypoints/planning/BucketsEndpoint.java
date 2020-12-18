package com.travellingfreak.itinerary.api.entrypoints.planning;

import com.travellingfreak.itinerary.api.entrypoints.requests.AddColumnRequest;
import com.travellingfreak.itinerary.api.entrypoints.requests.CreateActivityForm;
import com.travellingfreak.itinerary.api.entrypoints.requests.MoveBucketActivityRequest;
import com.travellingfreak.itinerary.api.entrypoints.responses.BucketListDetails;
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
import org.springframework.web.bind.annotation.RestController;

import io.micrometer.core.annotation.Timed;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping("/api/buckets/{travelId}")
@Api(tags = "Buckets API")
@RequiredArgsConstructor
public class BucketsEndpoint {

  @ApiOperation("Get the current bucket list for a given trip")
  @GetMapping(value = "bucket-list", produces = "application/json")
  @Timed("api.bucket-list.get")
  @PreAuthorize("hasPermission(#travelId, '', 'READ')")
  public BucketListDetails get(@PathVariable("travelId") final long travelId,
                               @ApiIgnore @AuthenticationPrincipal final KeycloakPrincipal principal) {
    throw new IllegalStateException("To be implemented");
  }

  @ApiOperation("Creates an activity and add it to the bucket list")
  @PostMapping(value = "bucket-list/{columnId}", produces = "application/json")
  @Timed("api.bucket-list.add")
  @PreAuthorize("hasPermission(#travelId, '', 'WRITE')")
  public ResourceCreationResponse<Long> addItem(@PathVariable("travelId") final long travelId,
                                                @ApiIgnore @AuthenticationPrincipal final KeycloakPrincipal principal,
                                                @PathVariable("columnId") final long columnId,
                                                @RequestBody final CreateActivityForm createActivityForm) {
    throw new IllegalStateException("To be implemented");
  }

  @ApiOperation("Creates a new column")
  @PostMapping(value = "/bucket-list", produces = "application/json")
  @Timed("api.bucket-list.add-column")
  @PreAuthorize("hasPermission(#travelId, '', 'WRITE')")
  public ResourceCreationResponse<Long> addColumn(@PathVariable("travelId") final long travelId,
                                                  @ApiIgnore @AuthenticationPrincipal final KeycloakPrincipal principal,
                                                  @RequestBody final AddColumnRequest addColumnRequest) {
    throw new IllegalStateException("To be implemented");
  }

  @ApiOperation("Deletes the column and the association to the bucket list")
  @DeleteMapping(value = "bucket-list/{id}", produces = "application/json")
  @Timed("api.bucket-list.remove-column")
  @PreAuthorize("hasPermission(#travelId, '', 'DELETE')")
  public void deleteColumn(@PathVariable("travelId") final long travelId,
                           @ApiIgnore @AuthenticationPrincipal final KeycloakPrincipal principal,
                           @PathVariable("id") final long columnId) {
    throw new IllegalStateException("To be implemented");
  }

  @ApiOperation("Deletes the activity and the association to the bucket list")
  @DeleteMapping(value = "bucket-list/{columnId}/{id}", produces = "application/json")
  @Timed("api.bucket-list.remove-item")
  @PreAuthorize("hasPermission(#travelId, '', 'DELETE')")
  public void removeItem(@PathVariable("travelId") final long travelId,
                         @ApiIgnore @AuthenticationPrincipal final KeycloakPrincipal principal,
                         @PathVariable("columnId") final long columnId,
                         @PathVariable("id") final long activityId) {
    throw new IllegalStateException("To be implemented");
  }

  @ApiOperation("Deletes all the activities and the association to the bucket list")
  @DeleteMapping(value = "bucket-list", produces = "application/json")
  @Timed("api.bucket-list.clearAll")
  @PreAuthorize("hasPermission(#travelId, '', 'DELETE')")
  public void clearAll(@PathVariable("travelId") final long travelId,
                       @ApiIgnore @AuthenticationPrincipal final KeycloakPrincipal principal) {
    throw new IllegalStateException("To be implemented");
  }

  @ApiOperation("Move activity within columns")
  @PatchMapping(value = "bucket-list/{activity}", produces = "application/json")
  @Timed("api.bucket-list.clearAll")
  @PreAuthorize("hasPermission(#travelId, '', 'WRITE')")
  public void move(@PathVariable("travelId") final long travelId,
                   @ApiIgnore @AuthenticationPrincipal final KeycloakPrincipal principal,
                   @PathVariable("activity") final long activityId,
                   @RequestBody final MoveBucketActivityRequest request) {
    throw new IllegalStateException("To be implemented");
  }

}
