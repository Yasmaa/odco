package com.travellingfreak.itinerary.api.dataproviders.model.posts;

import com.travellingfreak.itinerary.api.dataproviders.model.accounts.Account;
import com.travellingfreak.itinerary.api.dataproviders.model.base.Audit;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Date: 7/19/2020 Time: 2:36 PM
 */
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "posts")
@Data
public class Post extends Audit {
  @Id
  @GeneratedValue
  private long id;

  private String message;

  public Post() {
  }
  public Post(final String message) {
    this.message = message;
  }

  @ManyToMany
  @JoinTable(
      name = "post_mentions",
      joinColumns = @JoinColumn(name = "post_id"),
      inverseJoinColumns = @JoinColumn(name = "account_id")
  )
  private List<Account> mentions = new ArrayList<>();

  @OneToMany
  private List<Reply> replies = new ArrayList<>();
}
