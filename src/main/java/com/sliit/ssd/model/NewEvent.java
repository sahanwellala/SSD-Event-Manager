package com.sliit.ssd.model;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * New Calendar event model class
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
