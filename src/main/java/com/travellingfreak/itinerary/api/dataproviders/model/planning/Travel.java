package com.travellingfreak.itinerary.api.dataproviders.model.planning;

import com.travellingfreak.itinerary.api.dataproviders.model.accounts.Participant;
import com.travellingfreak.itinerary.api.dataproviders.model.base.SoftDeleteWithAudit;
import com.travellingfreak.itinerary.api.dataproviders.model.budget.Cost;
import com.travellingfreak.itinerary.api.dataproviders.model.budget.TravelPass;
import com.travellingfreak.itinerary.api.dataproviders.model.enums.PlanningMode;
import com.travellingfreak.itinerary.api.dataproviders.model.enums.Visibility;
import com.travellingfreak.itinerary.api.dataproviders.model.geo.Toponym;
import com.travellingfreak.itinerary.api.dataproviders.model.planning.buckets.Bucket;
import com.travellingfreak.itinerary.api.dataproviders.model.planning.buckets.Day;
import com.travellingfreak.itinerary.api.dataproviders.model.posts.Post;

import org.hibernate.annotations.Loader;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * Date: 7/18/2020 Time: 9:40 PM
 */
@Entity(name = "Travel")
@Table(name = "travels")
@SQLDelete(sql =
               "UPDATE Travel " +
               "SET deleted = true " +
               "WHERE id = ?")
@Loader(namedQuery = "findTravelById")
@NamedQuery(name = "findTravelById", query =
    "SELECT t "+
    "FROM Travel t " +
    "WHERE " +
    "      t.id = ?1 AND "+
    "      t.deleted = false")
@Where(clause = "deleted = false")
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor

public class Travel extends SoftDeleteWithAudit {
  @Id
  @GeneratedValue
  private long id;

  private String title;

  @OneToOne
  private Post description;

  @Enumerated(EnumType.STRING)
  private PlanningMode mode;

  @Column(name = "cover_photo")
  private String coverPhoto;

  @Column(name = "start_date")
  private LocalDate startDate;

  @Column(name = "end_date")
  private LocalDate endDate;

  @Enumerated(EnumType.STRING)
  private Visibility visibility;

  @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  private TravelSetting settings;

  @OneToMany(cascade = CascadeType.ALL)
  private List<Day> days = new ArrayList<>();

  @OneToMany(cascade = CascadeType.ALL)
  private List<Bucket> buckets = new ArrayList<>();

  @OneToMany(cascade = CascadeType.ALL)
  private List<TravelPass> passes = new ArrayList<>();

  @OneToMany(cascade = CascadeType.ALL)
  private List<Cost> costs = new ArrayList<>();

  @OneToMany(cascade = CascadeType.ALL)
  private List<Participant> participants = new ArrayList<>();

  @ManyToMany
  @JoinTable(
      name = "travel_toponyms",
      joinColumns = @JoinColumn(name = "travel_id"),
      inverseJoinColumns = @JoinColumn(name = "location_id")
  )
  private List<Toponym> locations = new ArrayList<>();

  public void addPass(final TravelPass pass) {
    passes.add(pass);
    pass.setTravel(this);
  }

  public void removePass(final TravelPass pass) {
    passes.remove(pass);
    pass.setTravel(null);
  }

  public void addSettings(final TravelSetting settings) {
    this.settings = settings;
    settings.setTravel(this);
  }

  public void removeSettings() {
    if ( settings != null ) {
      settings.setTravel(null);
      settings = null;
    }
  }

  public void addDay(final Day d) {
    this.days.add(d);
    d.setTravel(this);
  }

  public void removeDay(final Day d) {
    this.days.remove(d);
    d.setTravel(null);
  }

  public void addBucket(final Bucket b) {
    this.buckets.add(b);
    b.setTravel(this);
  }

  public void removeBucket(final Bucket b) {
    this.buckets.remove(b);
    b.setTravel(null);
  }

  public void addCost(final Cost c) {
    this.costs.add(c);
    c.setTravel(this);
  }

  public void removeCost(final Cost b) {
    this.costs.remove(b);
    b.setTravel(null);
  }

  public Optional<Day> findDay(final LocalDate startDate) {
    return this.days
        .stream()
        .filter(it -> it.getDate().isEqual(startDate))
        .findFirst();
  }

  public void addParticipant(final Participant p) {
    p.setTravel(this);
    this.participants.add(p);
  }

  public void removeParticipant(final Participant p) {
    this.participants.remove(p);
    p.setTravel(null);
  }

}
