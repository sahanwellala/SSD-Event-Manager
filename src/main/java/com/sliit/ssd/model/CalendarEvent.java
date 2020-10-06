package com.sliit.ssd.model;

import lombok.Data;

/**
 * Calendar event model class
 * Authors: Wellala S. S.(IT17009096) | M. A Ashhar Ahamed (IT17043588)
 */
@Data
public class CalendarEvent {
    private String id;
    private String summary;
    private String description;
    private String startDateTime;
    private String endDateTime;

}
