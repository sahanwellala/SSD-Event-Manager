package com.sliit.ssd.model;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * New Calendar event model class
 * Authors: Wellala S. S.(IT17009096) | M. A Ashhar Ahamed (IT17043588)
 */
@Data
@NoArgsConstructor
public class NewEvent {
    private String summary;
    private String description;
    private String startDate;
    private String endDate;
    private String startTime;
    private String endTime;

}
