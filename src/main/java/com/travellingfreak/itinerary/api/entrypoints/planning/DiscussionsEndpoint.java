package com.travellingfreak.itinerary.api.entrypoints.planning;

import com.travellingfreak.itinerary.api.dataproviders.model.posts.Post;
import com.travellingfreak.itinerary.api.entrypoints.requests.CreatePostRequest;

import org.keycloak.KeycloakPrincipal;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.micrometer.core.annotation.Timed;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping("/api/discussions/{travelId}")
@Api(tags = "Discussions API")
@RequiredArgsConstructor
public class DiscussionsEndpoint {

  @ApiOperation("Sets the description of the travel (which is managed as a post)")
  @PostMapping(value = "travel", produces = "application/json")
  @Timed("api.planning.createTravelPost")
  @PreAuthorize("hasPermission(#travelId, '', 'WRITE')")
  public ResponseEntity<Void> createTravelPost(@PathVariable("travelId") final long travelId,
                                               @ApiIgnore @AuthenticationPrincipal final KeycloakPrincipal principal,
                                               @RequestBody final CreatePostRequest createPostRequest) {
    throw new IllegalStateException("To be implemented");
  }

  @ApiOperation("Adds a new post for a particular day")
  @PostMapping(value = "day/{day}", produces = "application/json")
  @Timed("api.planning.createDayPost")
  @PreAuthorize("hasPermission(#travelId, '', 'WRITE')")
  public ResponseEntity<Void> createDayPost(@PathVariable("travelId") final long travelId,
                            @ApiIgnore @AuthenticationPrincipal final KeycloakPrincipal principal,
                            @PathVariable("day") final long id,
                            @RequestBody final CreatePostRequest createPostRequest) {
    throw new IllegalStateException("To be implemented");
  }

  @ApiOperation(value = "Allows to edit a previously posted message",
                notes = "You need to be either owner of the travel plan or the creator of the message to be able to update it")
  @PutMapping(value = "{discussionId}", produces = "application/json")
  @Timed("api.planning.editPost")
  @PreAuthorize("hasPermission(#travelId, '', 'WRITE')")
  public ResponseEntity<Void> editPost(@PathVariable("travelId") final long travelId,
                       @ApiIgnore @AuthenticationPrincipal final KeycloakPrincipal principal,
                       @PathVariable("discussionId") final long discussionId,
                       @RequestBody final CreatePostRequest createPostRequest) {
    throw new IllegalStateException("To be implemented");
  }

  @ApiOperation(value = "Allows to delete a previously posted message",
                notes = "You need to be either owner of the travel plan or the creator of the message to be able to update it")
  @DeleteMapping(value = "{discussionId}", produces = "application/json")
  @Timed("api.planning.deletePost")
  @PreAuthorize("hasPermission(#travelId, '', 'WRITE')")
  public ResponseEntity<Void> deletePost(@PathVariable("travelId") final long travelId,
                         @ApiIgnore @AuthenticationPrincipal final KeycloakPrincipal principal,
                         @PathVariable("discussionId") final long discussionId) {
    throw new IllegalStateException("To be implemented");
  }


  @ApiOperation("Adds a new reply to an existing post")
  @PostMapping(value = "reply/{postId}", produces = "application/json")
  @Timed("api.planning.replyToPost")
  @PreAuthorize("hasPermission(#travelId, '', 'WRITE')")
  public ResponseEntity<Void> replyToPost(@PathVariable("travelId") final long travelId,
                          @ApiIgnore @AuthenticationPrincipal final KeycloakPrincipal principal,
                          @PathVariable("postId") final long postId,
                          @RequestBody final CreatePostRequest createPostRequest) {
    throw new IllegalStateException("To be implemented");
  }

  @ApiOperation("Expand a post. Apis which return posts only return CollapsedPosts")
  @GetMapping(value = "reply/{postId}", produces = "application/json")
  @Timed("api.planning.getPost")
  @PreAuthorize("hasPermission(#travelId, '', 'WRITE')")
  public Post getPost(@PathVariable("travelId") final long travelId,
                      @ApiIgnore @AuthenticationPrincipal final KeycloakPrincipal principal,
                      @PathVariable("postId") final long postId) {
    throw new IllegalStateException("To be implemented");
  }

  @ApiOperation(value = "Updates an existing reply to a post",
                notes = "You need to be either owner of the travel plan or the creator of the message to be able to update it")
  @PutMapping(value = "reply/{replyId}", produces = "application/json")
  @Timed("api.planning.replyToPost")
  @PreAuthorize("hasPermission(#travelId, '', 'WRITE')")
  public ResponseEntity<Void> editReply(@PathVariable("travelId") final long travelId,
                        @ApiIgnore @AuthenticationPrincipal final KeycloakPrincipal principal,
                        @PathVariable("replyId") final long replyId,
                        @RequestBody final CreatePostRequest createPostRequest) {
    throw new IllegalStateException("To be implemented");
  }

  @ApiOperation(value = "Deletes an existing reply to a post",
                notes = "You need to be either owner of the travel plan or the creator of the message to be able to update it")
  @DeleteMapping(value = "reply/{replyId}", produces = "application/json")
  @Timed("api.planning.deleteReply")
  @PreAuthorize("hasPermission(#travelId, '', 'WRITE')")
  public ResponseEntity<Void> deleteReply(@PathVariable("travelId") final long travelId,
                          @ApiIgnore @AuthenticationPrincipal final KeycloakPrincipal principal,
                          @PathVariable("replyId") final long replyId) {
    throw new IllegalStateException("To be implemented");
  }

}
