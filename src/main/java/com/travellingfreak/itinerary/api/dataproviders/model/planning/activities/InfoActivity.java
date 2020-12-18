package com.travellingfreak.itinerary.api.dataproviders.model.planning.activities;

import com.travellingfreak.itinerary.api.dataproviders.model.planning.Activity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Date: 7/19/2020 Time: 10:33 AM
 */
@EqualsAndHashCode(callSuper = true)
@Table(name = "info_activities")
@Entity
@Data
@DiscriminatorValue("INFO")
public class InfoActivity extends Activity {

}


