package com.travellingfreak.itinerary.api.dataproviders.model.planning.buckets;

import com.travellingfreak.itinerary.api.dataproviders.model.base.Audit;
import com.travellingfreak.itinerary.api.dataproviders.model.planning.Activity;
import com.travellingfreak.itinerary.api.dataproviders.model.planning.Travel;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.var;

/**
 * Date: 7/19/2020 Time: 10:06 AM
 */
@EqualsAndHashCode(callSuper = true) @Entity(name = "Bucket")
@Table(name = "buckets")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Bucket extends Audit {

  @Id
  @GeneratedValue
  private long id;

  @ManyToOne(fetch = FetchType.LAZY)
  private Travel travel;

  private String name;

  @OneToMany
  @OrderBy("bucketPosition")
  private List<Activity> activities = new ArrayList<>();

  public void addActivity(final int position, final Activity activity) {
    for (int i = position; i < activities.size(); i++) {
      final Activity other = activities.get(i);
      other.setBucketPosition(i + 1);
    }
    this.activities.add(position, activity);
    activity.setBucket(this);
    activity.setBucketPosition(position);
  }

  public void addActivity(final Activity activity) {
    this.activities.add(activity);
    activity.setBucket(this);
    activity.setBucketPosition(this.activities.size());
  }

  public void removeActivity(final Activity activity) {
    final var position = this.activities.indexOf(activity);
    for (int i = position + 1; i < activities.size(); i++) {
      Activity other = activities.get(i);
      other.setBucketPosition(i - 1);
    }
    this.activities.remove(position);
    activity.setBucketPosition(null);
    activity.setBucket(null);
  }

}
