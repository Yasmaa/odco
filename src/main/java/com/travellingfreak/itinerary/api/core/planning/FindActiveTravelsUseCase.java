package com.travellingfreak.itinerary.api.core.planning;

import com.travellingfreak.itinerary.api.core.model.UpcomingTravelCard;
import com.travellingfreak.itinerary.api.dataproviders.model.accounts.Account;
import com.travellingfreak.itinerary.api.dataproviders.model.accounts.Participant;
import com.travellingfreak.itinerary.api.dataproviders.model.planning.Travel;
import com.travellingfreak.itinerary.api.dataproviders.repositories.accounts.AccountRepository;
import com.travellingfreak.itinerary.api.dataproviders.repositories.planning.TravelRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;
import lombok.var;
import lombok.extern.log4j.Log4j2;

/**
 * Date: 7/19/2020 Time: 9:49 PM
 */
@Log4j2
@Component
@RequiredArgsConstructor
public class FindActiveTravelsUseCase {
  private final TravelRepository travelRepository;
  private final AccountRepository accountRepository;
  public Page<UpcomingTravelCard> findUpcomingTravels(final String username, final int page, final int limit) {
    final var activeTravels = travelRepository.findUpcomingTravels(username, LocalDate.now(), PageRequest.of(page, limit));
    if ( activeTravels.hasContent() ) {
      final var participants = activeTravels.stream()
          .map(Travel::getParticipants)
          .flatMap(Collection::stream)
          .map(Participant::getAccountId)
          .collect(Collectors.toSet());
      final var authors = activeTravels.stream()
          .map(Travel::getCreatedBy)
          .collect(Collectors.toSet());
      participants.addAll(authors);
      final var users = accountRepository.findAllByIdIn(List.copyOf(participants)).stream().collect(Collectors.toMap(Account::getId, Account::getDisplayName));
      return activeTravels.map(it -> new UpcomingTravelCard(
          it.getId(),
          it.getStartDate(),
          it.getEndDate(),
          it.getDays().size(),
          it.getParticipants()
              .stream()
              .map(Participant::getAccountId)
              .map(users::get)
              .collect(Collectors.toList()),
          users.get(it.getCreatedBy())
      ));
    } else {
      return Page.empty();
    }
  }
}
