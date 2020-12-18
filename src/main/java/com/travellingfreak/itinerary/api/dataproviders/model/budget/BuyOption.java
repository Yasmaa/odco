package com.travellingfreak.itinerary.api.dataproviders.model.budget;

import com.travellingfreak.itinerary.api.dataproviders.model.base.SoftDelete;
import com.travellingfreak.itinerary.api.dataproviders.model.enums.CurrencyCode;

import org.hibernate.annotations.Loader;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * Date: 7/18/2020 Time: 10:46 PM
 */
@EqualsAndHashCode(callSuper = true)
@Entity(name = "BuyOption")
@Table(name = "buy_options")
@SQLDelete(sql =
           "UPDATE BuyOption " +
           "SET deleted = true " +
           "WHERE id = ?")
@Loader(namedQuery = "findBuyOptionById")
@NamedQuery(name = "findBuyOptionById", query =
            "SELECT b "+
            "FROM BuyOption b " +
            "WHERE " +
            "      b.id = ?1 AND "+
            "      b.deleted = false")
@Where(clause = "deleted = false")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class BuyOption extends SoftDelete {
  @Id
  @GeneratedValue
  private long id;

  @ManyToOne(fetch = FetchType.LAZY)
  private Pass pass;

  private String name;

  @Column(name = "has_fixed_price")
  private boolean hasFixedPrice;

  @Column(name = "fixed_price")
  private long fixedPrice;

  @Column(name = "price_per_day")
  private long pricePerDay;

  @Column(name = "duration_in_days")
  private long durationInDays;

  @Enumerated(EnumType.STRING)
  @Column(name = "currency_code")
  private CurrencyCode currencyCode;
}
