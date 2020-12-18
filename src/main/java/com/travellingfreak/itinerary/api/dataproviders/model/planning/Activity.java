package com.travellingfreak.itinerary.api.dataproviders.model.planning;

import com.travellingfreak.itinerary.api.dataproviders.model.base.SoftDeleteWithAudit;
import com.travellingfreak.itinerary.api.dataproviders.model.enums.Category;
import com.travellingfreak.itinerary.api.dataproviders.model.enums.SubCategory;
import com.travellingfreak.itinerary.api.dataproviders.model.planning.activities.Attachment;
import com.travellingfreak.itinerary.api.dataproviders.model.planning.activities.Like;
import com.travellingfreak.itinerary.api.dataproviders.model.planning.buckets.Bucket;
import com.travellingfreak.itinerary.api.dataproviders.model.planning.buckets.Day;
import com.travellingfreak.itinerary.api.dataproviders.model.posts.Post;

import org.hibernate.annotations.Loader;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.var;

/**
 * Date: 7/19/2020 Time: 10:13 AM
 */
@Entity
@Table(name = "activities")
@SQLDelete(sql =
               "UPDATE Activity " +
               "SET deleted = true " +
               "WHERE id = ?")
@Loader(namedQuery = "findActivityById")
@NamedQuery(name = "findActivityById", query =
    "SELECT a "+
    "FROM Activity a " +
    "WHERE " +
    "      a.id = ?1 AND "+
    "      a.deleted = false")
@Where(clause = "deleted = false")
@Data
@EqualsAndHashCode(callSuper = true)
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(discriminatorType = DiscriminatorType.STRING, name = "category")
@AllArgsConstructor
@NoArgsConstructor

public class Activity extends SoftDeleteWithAudit {
  @Id
  @GeneratedValue
  private long id;

  @ManyToOne(fetch = FetchType.LAZY)
  private Travel travel;

  @ManyToOne(fetch = FetchType.LAZY)
  private Day day;

  @ManyToOne(fetch = FetchType.LAZY)
  private Bucket bucket;

  @Column(name = "bucket_position")
  private Integer bucketPosition;

  @Enumerated(EnumType.STRING)
  @NotNull
  private Category category;

  @Enumerated(EnumType.STRING)
  @NotNull
  private SubCategory subCategory;

  @NotNull
  private String title;

  @OneToOne
  private Post post;

  @OneToMany
  private List<Like> reactions = new ArrayList<>();

  @OneToMany
  private List<Attachment> images = new ArrayList<>();

  public void like(final String memberId) {
    final var like = new Like();
    like.setCreatedBy(memberId);
    like.setActivity(this);
    like.setThumbsUp(true);
    this.reactions.add(like);
  }

  public void dislike(final String memberId) {
    final var like = new Like();
    like.setCreatedBy(memberId);
    like.setActivity(this);
    like.setThumbsUp(false);
    this.reactions.add(like);
  }

  public void addAttachment(final Attachment attachment) {
    this.images.add(attachment);
    attachment.setActivity(this);
  }

  public void removeAttachment(final Attachment attachment) {
    this.images.remove(attachment);
    attachment.setActivity(null);
  }
}
