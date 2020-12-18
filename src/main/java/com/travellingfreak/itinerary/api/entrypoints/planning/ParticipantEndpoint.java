package com.travellingfreak.itinerary.api.entrypoints.planning;

import com.travellingfreak.itinerary.api.entrypoints.requests.ParticipantRequest;
import com.travellingfreak.itinerary.api.entrypoints.requests.PatchRoleRequest;
import com.travellingfreak.itinerary.api.entrypoints.responses.UserListResponse;

import org.keycloak.KeycloakPrincipal;
import org.springframework.http.ResponseEntity;
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

import io.micrometer.core.annotation.Timed;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping("/api/travel/{travelId}")
@Api(tags = "Participants API")
@RequiredArgsConstructor
public class ParticipantEndpoint {

  @ApiOperation("Add a new participant to this plan")
  @PostMapping(value = "/participants", produces = "application/json")
  @Timed("api.participants.create")
  @PreAuthorize("hasPermission(#travelId, '', 'ADMIN')")
  public ResponseEntity<Void> addParticipants(@PathVariable("travelId") final long travelId,
                                              @ApiIgnore @AuthenticationPrincipal final KeycloakPrincipal userDetails,
                                              @RequestBody final ParticipantRequest participantRequest) {
    throw new IllegalStateException("To be implemented");
  }

  @ApiOperation("Updates the participant role. Only the owner of the trip can set someone as admin, and only the owner can remove someone with admin rights")
  @PatchMapping(value = "/participants/{id}", produces = "application/json")
  @Timed("api.participants.patch")
  @PreAuthorize("hasPermission(#travelId, '', 'ADMIN')")
  public ResponseEntity<Void> updateParticipantRole(@PathVariable("travelId") final long travelId,
                                              @PathVariable("id") final long participantId,
                                              @ApiIgnore @AuthenticationPrincipal final KeycloakPrincipal userDetails,
                                              @RequestBody final PatchRoleRequest patchRoleRequest) {
    throw new IllegalStateException("To be implemented");
  }

  @ApiOperation("Retrieve list of possible users that matches the query and are friends with the requester.")
  @GetMapping(value = "/autocomplete/friends", produces = "application/json")
  @Timed("api.participants.get.autocomplete.friends")
  @PreAuthorize("hasPermission(#travelId, '', 'ADMIN')")
  public UserListResponse addParticipants(
      @PathVariable("travelId") final long travelId,
      @ApiIgnore @AuthenticationPrincipal final KeycloakPrincipal userDetails,
      @ApiParam(name = "name",
                value = "Might match either name or e-mail. If missing, should return all the friends for the requester")
      @RequestParam(value = "name", required = false) final String nameOrEmail) {
    throw new IllegalStateException("To be implemented");
  }

  @ApiOperation(value = "Removes a participant from the specified travel. Only the owner of the travel can remove an admin user",
                code = 201
  )
  @DeleteMapping(value = "/participant/{id}", produces = "application/json")
  @Timed("api.participants.delete")
  @PreAuthorize("hasPermission(#travelId, '', 'ADMIN')")
  public ResponseEntity<Void> removeParticipants(@PathVariable("travelId") final long tripId,
                                                  @ApiIgnore @AuthenticationPrincipal final KeycloakPrincipal userDetails,
                                                  @PathVariable("id") final long participantId){
    throw new IllegalStateException("To be implemented");
  }


}
