package com.sliit.ssd.model;

import lombok.Data;

@Data
public class CalendarEvent {
    private String id;
    private String summary;
    private String description;
    private String startDateTime;
    private String endDateTime;

}
