package com.travellingfreak.itinerary.api.core.planning;

import com.travellingfreak.itinerary.api.core.model.Counter;
import com.travellingfreak.itinerary.api.dataproviders.model.enums.PlanningMode;
import com.travellingfreak.itinerary.api.dataproviders.model.planning.Travel;
import com.travellingfreak.itinerary.api.dataproviders.model.planning.TravelSetting;
import com.travellingfreak.itinerary.api.dataproviders.model.planning.buckets.Day;
import com.travellingfreak.itinerary.api.dataproviders.model.posts.Post;
import com.travellingfreak.itinerary.api.dataproviders.repositories.planning.TravelRepository;
import com.travellingfreak.itinerary.api.entrypoints.requests.CreateTravelRequest;

import org.springframework.stereotype.Component;

import java.util.ArrayList;

import lombok.RequiredArgsConstructor;
import lombok.var;

/**
 * Date: 7/26/2020 Time: 8:27 PM
 */
@Component
@RequiredArgsConstructor
public class CreateTravelUseCase {
  private final TravelRepository travelRepository;
  public long createTravelUseCase(final String creator, final CreateTravelRequest request) {
    final Travel t = new Travel();
    t.setCreatedBy(creator);
    final var body = request.getBody();
    t.setTitle(body.getTitle());
    t.setDescription(new Post(body.getDescription()));
    t.setMode(body.getMode());
    t.setCoverPhoto(body.getCoverPhoto());
    if (body.getMode() == PlanningMode.PLANNING ) {
      t.setStartDate(body.getStartDate());
      t.setEndDate(body.getEndDate());
      final var counter = new Counter();
      body.getStartDate().datesUntil(body.getEndDate())
          .forEach(it -> {
            counter.inc();
            final var count = counter.getCount();
            t.addDay(new Day(0L, t, count, it, "Day " + count, new ArrayList<>(), new ArrayList<>()));
          });
    } else {
      for(int i = 0; i < body.getNumberOfDays(); i++) {
        t.addDay(new Day(0L, t, i, null, "Day " + i, new ArrayList<>(), new ArrayList<>()));
      }
    }
    travelRepository.save(t);
    final var advanced = request.getAdvanced();
    t.addSettings(new TravelSetting(
        0L, t,
        advanced.getDefaultCurrency(),
        advanced.getDistanceUnit(),
        advanced.getTemperatureMeasureUnit(),
        advanced.getMaximumActivitiesPerDay(),
        advanced.getPlanningType(),
        advanced.getDefaultTransportMode(),
        advanced.isAllowGuestsToInvite(),
        advanced.isAllowFileSharing(),
        advanced.isAllowDiscussions(),
        advanced.isAllowEmailProcessing(),
        advanced.getDayStartsAt(),
        advanced.getDayEndsAt(),
        advanced.getDailyBudget(),
        advanced.getBudget(),
        advanced.getBudgetCurrency()
    ));
    return t.getId();
  }
}
